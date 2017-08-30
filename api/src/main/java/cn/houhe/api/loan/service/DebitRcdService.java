package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.ServiceOperationException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.AliTools;
import cn.houhe.api.common.Configs;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.common.enums.PushMsgEnum;
import cn.houhe.api.loan.entity.DebitRcd;
import cn.houhe.api.loan.mapper.DebitRcdExtMapper;
import cn.houhe.api.loan.mapper.DebitRcdMapper;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import cn.houhe.api.loan.web.DebitRcdAction;
import cn.houhe.api.loan.web.bo.RepaymentsPlanListDto;
import cn.houhe.api.log.entity.Message;
import cn.houhe.api.log.mapper.MessageMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：debit_rcd
 * @since 2017-03-29 18:30:03
 */
@Service("debitRcdService")
public class DebitRcdService implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(DebitRcdAction.class);

	@Resource
	private DebitRcdMapper debitRcdMapper;
	@Resource
	private DebitRcdExtMapper debitRcdExtMapper;

	@Autowired
	private RepaymentsPlanExtService repaymentsPlanExtService;

	@Autowired
	private MessageMapper messageMapper;

	public void insert(DebitRcd entity) throws ServiceException {
		try {
			debitRcdMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void insertSelective(DebitRcd entity) throws ServiceException {
		try {
			debitRcdMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(DebitRcd entity) throws ServiceException {
		try {
			debitRcdMapper.deleteByPrimaryKey(entity.getDrId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				debitRcdMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(DebitRcd entity) throws ServiceException {
		try {
			debitRcdMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(DebitRcd entity) throws ServiceException {
		try {
			debitRcdMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public DebitRcd findByPrimaryKey(Integer drId) throws ServiceException {
		try {
			return debitRcdMapper.selectByPrimaryKey(drId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<DebitRcd> findPage(Criteria<DebitRcd> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(DebitRcd.class);
			}
			criteria.pagination(true);
			List<DebitRcd> list = debitRcdMapper.selectByCriteria(criteria);
			return new Pager<DebitRcd>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<DebitRcd> findAll(Criteria<DebitRcd> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(DebitRcd.class);
			}
			criteria.pagination(false);
			return debitRcdMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * 插入还款记录
	 * @param
	 * @return
	 * @throws ServiceException
	 */
	public ResultDto insertDebitRcdDataSer() {
		ResultDto result = new ResultDto("0", "插入还款记录成功");
		try {
			List<RepaymentsPlanListDto> repplanlst = repaymentsPlanExtService.findRepaymentsPlanList();
			DebitRcd debitRcd = new DebitRcd();
			if(repplanlst != null && !repplanlst.isEmpty()) {
				for(RepaymentsPlanListDto item : repplanlst) {
					debitRcd.setRepaymentsPlanId(item.getRptId());
					debitRcd.setLoanRecordId(item.getLoanRecordId());
					debitRcd.setMemberId(item.getMemberId());
					debitRcd.setNumber(item.getRepay_number());
					debitRcd.setBankNo(item.getRepayBankCardNo());
					debitRcd.setBankName(item.getRepayBank());
					debitRcd.setBankUserName(item.getRepayName());
					debitRcd.setUserMobile(item.getUserMobile());
					debitRcd.setLateFee(item.getLateFee());
					debitRcd.setInterest(item.getInterest());
					if(debitRcdExtMapper.getLastItem(item.getLoanRecordId()).equals(item.getCurrentTerm())) {
						debitRcd.setRepayAmount(item.getRealTotalPay().subtract(item.getInterest()));
					}else
					{
						debitRcd.setRepayAmount(item.getRealTotalPay());
					}
					debitRcd.setPayTime(item.getPayDate());
					debitRcdExtMapper.insertDebitRcd(debitRcd);

					//将对应的还款计划更新为还款中
					repaymentsPlanExtService.updateRepayStatus(item.getRptId(),2);
					///还款提醒
					try {
						String title="还款提醒";
						String summary="还款提醒";
						String body="您有借款近期需要归还，请在绑定的银行卡中准备充足的金额。";
						byte msgtype= (byte) PushMsgEnum.RePayRemaind.getIndex();
						Map<String,String> sendres= AliTools.pushMsg(debitRcd.getMemberId() + "_" + Configs.pushEv, msgtype, title, summary , body);
						Message m = new Message();
						m.setMemberId(debitRcd.getMemberId());
						m.setMsgType((byte)1);
						m.setMsgContentType(msgtype);
						m.setTitle(title);
						m.setIsSend((byte)1);
						m.setContent(body);
						m.setCreatedon(new Date());
						m.setRemark(sendres.get("responseId"));
						messageMapper.insert(m);
					}catch (Exception ex)
					{
					}
				}
			}
			result.setData(true);
		} catch (Exception e) {
			result.setCode("-1");
			result.setMsg("插入还款记录失败");
			result.setData(false);
			logger.error(e.getMessage(), e);
		}
		return result;
	}
}