package cn.houhe.api.member.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.ServiceOperationException;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.loan.service.pay.PayService;
import cn.houhe.api.loan.service.pay.bean.PayBean;
import cn.houhe.api.loan.service.pay.versionSMS.MsgBean;
import cn.houhe.api.loan.service.pay.versionSMS.MsgBody;
import cn.houhe.api.member.entity.BankCard;
import cn.houhe.api.member.entity.BankCardExt;
import cn.houhe.api.member.entity.MerBankCardExt;
import cn.houhe.api.member.mapper.BankCardExtMapper;
import cn.houhe.api.member.web.BankCardAction;
import cn.houhe.api.member.web.bo.BankCardDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * 业务实现层 - 表：bank_card
 * @since 2017-03-30 10:12:39
 */
@Service("bankCardExtService")
public class BankCardExtService implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(BankCardAction.class);

	@Resource
	private BankCardExtMapper bankCardExtMapper;

	@Autowired
	private StringRedisTemplate redisTemplate;

	@Autowired
	private BankCardService bankCardService;

	@Autowired
	private PayService payService;

	public List<BankCardExt> findByMemberId(Integer member_id) throws ServiceException {
		try {
			return bankCardExtMapper.selectByMemberId(member_id);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public BankCard findByBankCardNo(String bankcardno) throws ServiceException {
		try {
			return bankCardExtMapper.selectByBankCardNo(bankcardno);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * 获取银行卡列表
	 * @param param
	 * @return
	 */
	public ResultDto getBankCardListSer(RequestDto<BankCardDto> param) {
		ResultDto result = new ResultDto();
		result.setMsg("获取银行卡列表");
		try {
			Integer memberid = param.getData().getMemberId();
			List<BankCardExt> bankcardlist = findByMemberId(memberid);
			if(bankcardlist != null) {
				int lstlen = bankcardlist.size();
				for (int i = 0; i < lstlen; i++) {
					BankCardExt item = bankcardlist.get(i);
					item.setBindcollectrefundbank(1);
					//if(Objects.equals(item.getBankcardno(), item.getReceivebankcardno()) && Objects.equals(item.getBankcardno(), item.getRepaybankcardno())) { item.setBindcollectrefundbank(1); } else { item.setBindcollectrefundbank(0); }
				}
			}
			result.setData(bankcardlist);
			result.setCode("0");
		}catch (Exception e){
			result.setCode("-1");
			result.setMsg("银行卡列表异常");
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 添加银行卡
	 * @param param
	 * @return
	 */
	public ResultDto addBankCardSer(RequestDto<BankCardDto> param) {
		ResultDto result = new ResultDto();
		result.setMsg("添加银行卡");
		try {
			Integer memberid = param.getData().getMemberId();
			String cardholder = param.getData().getCardholder();
			String bankcardno = param.getData().getBankcardno();
			String collectingbank = param.getData().getCollectingbank();
			String reservedmobile = param.getData().getReservedmobile();
			//String verificode = param.getData().getVerificode();
			BankCard bankcardinfo = findByBankCardNo(bankcardno);
			if(bankcardinfo != null){
				result.setCode("1");
				result.setMsg("您添加的该银行卡已存在");
				return result;
			}
			//发送手机验证码
			//验证输入的验证码是否正确
			//String code = redisTemplate.opsForValue().get(reservedmobile);
			//if(code == null) { code = ""; }
			//if (code.equals(verificode)) {
				BankCard bankcarddto = new BankCard();
				bankcarddto.setMemberId(memberid);
				bankcarddto.setCardholder(cardholder);
				bankcarddto.setBankcardno(bankcardno);
				bankcarddto.setCollectingbank(collectingbank);
				bankcarddto.setReservedmobileno(reservedmobile);
				bankCardService.insertSelective(bankcarddto);
				result.setCode("0");
				result.setMsg("银行卡添加成功");
			//}
			//else{
				//result.setCode("2");
				//result.setMsg("验证码错误，请重新输入");
			//}
		}catch (Exception e){
			result.setCode("-1");
			result.setMsg("银行卡添加失败，请重试");
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 查询银行卡信息
	 * @param param
	 * @return
	 */
	public ResultDto getBankCardInfoSer(RequestDto<BankCardDto> param) {
		ResultDto result = new ResultDto();
		result.setMsg("查询银行卡信息");
		try {
			Integer memberid = param.getData().getMemberId();
			String bankcardno = param.getData().getBankcardno().replace(" ","");
			MsgBean msgbean = new MsgBean();
			MsgBody msgbody = new MsgBody();
			msgbody.setACC_NO(bankcardno);
			msgbean.getBODYS().add(msgbody);
            MerBankCardExt merbc = bankCardExtMapper.getMerBankCardInfo(memberid);
			PayBean accinfo = payService.queryAccountInfo(msgbean);
			accinfo.getData().put("mobile", merbc.getMobileNo());
			result.setCode(accinfo.getCode());
			result.setMsg(accinfo.getMsg());
			result.setData(accinfo.getData());
		}catch (Exception e){
			result.setCode("-1");
			result.setMsg("查询异常");
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 发送短信验证码
	 * @param param
	 * @return
	 */
	public ResultDto sendMessage(RequestDto<BankCardDto> param) {
		ResultDto result = new ResultDto();
		result.setMsg("发送短信验证码");
		try {
			BankCardDto data=param.getData();
			Integer memberid = data.getMemberId();

			MerBankCardExt merbc = bankCardExtMapper.getMerBankCardInfo(memberid);

			String accNo = data.getBankcardno().replace(" ","");
			String mobileNo =data.getReservedmobile();
			MsgBody msgBody = new MsgBody();
			msgBody.setSN( String.format("%10d", memberid).replace(" ", "0"));
			msgBody.setMOBILE_NO(mobileNo);
			msgBody.setACC_NO(accNo);
			msgBody.setACC_NAME(merbc.getRealName());
			msgBody.setID_NO(merbc.getIdCardNo());
			msgBody.setTRANS_DESC("请求授权");

			MsgBean msgBean = new MsgBean();
			msgBean.getBODYS().add(msgBody);
			PayBean reqBean = payService.sendMessage(msgBean);
			result.setCode(reqBean.getCode());
			result.setMsg(reqBean.getMsg());
			result.setData(reqBean.getData());
		}catch (Exception e) {
			result.setCode("-1");
			result.setMsg("发送短信验证码失败");
			logger.error(e.getMessage(),e);
		}
		return result;
	}

	/**
	 * 认证
	 * @param param
	 * @return
	 */
    public ResultDto verify(RequestDto<BankCardDto> param) {
        ResultDto result = new ResultDto();
        result.setMsg("认证");
        try {
            BankCardDto data = param.getData();
            Integer userId = data.getMemberId();

			MerBankCardExt merbc = bankCardExtMapper.getMerBankCardInfo(userId);
            String accNo = data.getBankcardno();
            String accName = merbc.getRealName();
            String mobileNo = data.getReservedmobile();
            String msgcode = data.getMsgcode();
            String cardId = merbc.getIdCardNo();
            String batchno = data.getBatchno();
            MsgBody msgBody = new MsgBody();
			msgBody.setACC_NO(accNo);
            msgBody.setACC_NAME(accName);
            msgBody.setAMOUNT("1");
            msgBody.setSMS_CODE(msgcode);
            msgBody.setMOBILE_NO(mobileNo);
            msgBody.setSN(batchno);
            if(userId == null) {
                msgBody.setID_NO("");
            }
            msgBody.setID_NO(cardId);
            msgBody.setTRANS_DESC("认证");

            MsgBean msgBean = new MsgBean();
            msgBean.getBODYS().add(msgBody);
            msgBean.setBATCH_NO(batchno);
            PayBean res= payService.verify(msgBean,userId);
            result.setCode(res.getCode());
            result.setMsg(res.getMsg());
        }catch (Exception e) {
            result.setCode("-1");
            result.setMsg("认证失败");
            logger.error(e.getMessage(),e);
        }
        return result;
    }

	/**
	 * 查看会员详细信息
	 *
	 * @param memberId
	 * @return
	 */
	public MerBankCardExt getMerBankCardInfo(Integer memberId) {
		MerBankCardExt infoObject = bankCardExtMapper.getMerBankCardInfo(memberId);
		if (infoObject == null) {
			throw new ServiceOperationException("未找到相关信息");
		}
		return infoObject;
	}

	public  ResultDto verifyQuery(RequestDto<BankCardDto> param)
	{
		ResultDto result = new ResultDto();
		result.setMsg("认证查询");
		try {
			BankCardDto data = param.getData();
			String accNo = data.getBankcardno();
			String accName = data.getCardholder();
			PayBean resBean = payService.verifyQuery(accNo,accName);
			result.setData(resBean.getData());
		}catch (Exception e) {
			result.setCode("-1");
			result.setMsg("认证查询失败");
			logger.error(e.getMessage(),e);
		}
		return result;

	}
}