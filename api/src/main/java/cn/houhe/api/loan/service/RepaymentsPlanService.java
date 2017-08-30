package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.loan.entity.RepaymentsPlan;
import cn.houhe.api.loan.entity.bo.RepaymentDto;
import cn.houhe.api.loan.mapper.RepaymentsPlanExtMapper;
import cn.houhe.api.loan.mapper.RepaymentsPlanMapper;
import cn.houhe.api.loan.web.bo.RepaymentsDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 业务实现层 - 表：repayments_plan
 * @since 2017-03-29 18:30:03
 */
@Service("repaymentsPlanService")
public class RepaymentsPlanService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private RepaymentsPlanMapper repaymentsPlanMapper;

	@Resource
	private RepaymentsPlanExtMapper repaymentsPlanExtMapper;

	public void insert(RepaymentsPlan entity) throws ServiceException {
		try {
			repaymentsPlanMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(RepaymentsPlan entity) throws ServiceException {
		try {
			repaymentsPlanMapper.deleteByPrimaryKey(entity.getRptId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				repaymentsPlanMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(RepaymentsPlan entity) throws ServiceException {
		try {
			repaymentsPlanMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(RepaymentsPlan entity) throws ServiceException {
		try {
			repaymentsPlanMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public RepaymentsPlan findByPrimaryKey(Integer rptId) throws ServiceException {
		try {
			return repaymentsPlanMapper.selectByPrimaryKey(rptId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<RepaymentsPlan> findPage(Criteria<RepaymentsPlan> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(RepaymentsPlan.class);
			}
			criteria.pagination(true);
			List<RepaymentsPlan> list = repaymentsPlanMapper.selectByCriteria(criteria);
			return new Pager<RepaymentsPlan>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<RepaymentsPlan> findAll(Criteria<RepaymentsPlan> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(RepaymentsPlan.class);
			}
			criteria.pagination(false);
			return repaymentsPlanMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<RepaymentDto> findPaymentPage(RepaymentsDto dto) throws ServiceException
	{
		try {
				int total=repaymentsPlanExtMapper.selectRepaymentListCount(dto);

			Pager<RepaymentDto> page=new Pager<RepaymentDto>(dto.page,dto.rows,total,new ArrayList<RepaymentDto>());
			if(total>0)
			{
				page.setList(repaymentsPlanExtMapper.selectRepaymentList(dto));
			}

			return  page;
		}catch (Exception e)
		{
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<RepaymentDto> getOverdueList(RepaymentsDto dto) throws ServiceException
	{
		try {
			int total=repaymentsPlanExtMapper.selectOverdueListCount(dto);

			Pager<RepaymentDto> page=new Pager<RepaymentDto>(dto.page,dto.rows,total,new ArrayList<RepaymentDto>());
			if(total>0)
			{
				page.setList(repaymentsPlanExtMapper.selectOverdueList(dto));
			}
			return  page;
		}catch (Exception e)
		{
			throw new ServiceException(e.getMessage(), e);
		}
	}


}