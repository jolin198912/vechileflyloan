package cn.houhe.api.config.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.config.entity.LoanPeriod;
import cn.houhe.api.config.mapper.LoanPeriodMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：loan_period
 * @since 2017-03-30 10:04:06
 */
@Service("loanPeriodService")
public class LoanPeriodService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private LoanPeriodMapper loanPeriodMapper;

	public void insert(LoanPeriod entity) throws ServiceException {
		try {
			loanPeriodMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(LoanPeriod entity) throws ServiceException {
		try {
			loanPeriodMapper.deleteByPrimaryKey(entity.getLpId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Short> ids) throws ServiceException {
		try {
			for (Short id : ids) {
				loanPeriodMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(LoanPeriod entity) throws ServiceException {
		try {
			loanPeriodMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(LoanPeriod entity) throws ServiceException {
		try {
			loanPeriodMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public LoanPeriod findByPrimaryKey(Short lpId) throws ServiceException {
		try {
			return loanPeriodMapper.selectByPrimaryKey(lpId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<LoanPeriod> findPage(Criteria<LoanPeriod> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(LoanPeriod.class);
			}
			criteria.pagination(true);
			List<LoanPeriod> list = loanPeriodMapper.selectByCriteria(criteria);
			return new Pager<LoanPeriod>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<LoanPeriod> findAll(Criteria<LoanPeriod> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(LoanPeriod.class);
			}
			criteria.pagination(false);
			return loanPeriodMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}