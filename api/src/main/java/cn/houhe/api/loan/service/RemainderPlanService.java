package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.loan.entity.RemainderPlan;
import cn.houhe.api.loan.mapper.RemainderPlanMapper;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：remainder_plan
 * @since 2017-05-24 18:33:37
 */
@Service("remainderPlanService")
public class RemainderPlanService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private RemainderPlanMapper remainderPlanMapper;

	public void insert(RemainderPlan entity) throws ServiceException {
		try {
			remainderPlanMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void insertSelective(String loanRecordIds , String repaymentsPlanIds, Integer remainderId, String remainder, String remark, Date createdon) throws ServiceException {
		try {
			String str1[] = loanRecordIds.split(",");
			String str2[] = repaymentsPlanIds.split(",");
			for(int i=0;i<str1.length;i++){
				remainderPlanMapper.insertSelective(Integer.parseInt(str1[i]),Integer.parseInt(str2[i]),remainderId,remainder, remark, createdon);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(RemainderPlan entity) throws ServiceException {
		try {
			remainderPlanMapper.deleteByPrimaryKey(entity.getRpId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				remainderPlanMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(RemainderPlan entity) throws ServiceException {
		try {
			remainderPlanMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(RemainderPlan entity) throws ServiceException {
		try {
			remainderPlanMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public RemainderPlan findByPrimaryKey(Integer rpId) throws ServiceException {
		try {
			return remainderPlanMapper.selectByPrimaryKey(rpId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<RemainderPlan> findPage(Criteria<RemainderPlan> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(RemainderPlan.class);
			}
			criteria.pagination(true);
			List<RemainderPlan> list = remainderPlanMapper.selectByCriteria(criteria);
			return new Pager<RemainderPlan>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<RemainderPlan> findAll(Criteria<RemainderPlan> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(RemainderPlan.class);
			}
			criteria.pagination(false);
			return remainderPlanMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}