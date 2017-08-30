package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.loan.entity.LoanBasicFee;
import cn.houhe.api.loan.mapper.LoanBasicFeeMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：loan_basic_fee
 * @since 2017-05-06 17:45:27
 */
@Service("loanBasicFeeService")
public class LoanBasicFeeService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private LoanBasicFeeMapper loanBasicFeeMapper;

	public void insert(LoanBasicFee entity) throws ServiceException {
		try {
			loanBasicFeeMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(LoanBasicFee entity) throws ServiceException {
		try {
			loanBasicFeeMapper.deleteByPrimaryKey(entity.getLbaId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				loanBasicFeeMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(LoanBasicFee entity) throws ServiceException {
		try {
			loanBasicFeeMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(LoanBasicFee entity) throws ServiceException {
		try {
			loanBasicFeeMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public LoanBasicFee findByPrimaryKey(Integer lbaId) throws ServiceException {
		try {
			return loanBasicFeeMapper.selectByPrimaryKey(lbaId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<LoanBasicFee> findPage(Criteria<LoanBasicFee> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(LoanBasicFee.class);
			}
			criteria.pagination(true);
			List<LoanBasicFee> list = loanBasicFeeMapper.selectByCriteria(criteria);
			return new Pager<LoanBasicFee>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<LoanBasicFee> findAll(Criteria<LoanBasicFee> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(LoanBasicFee.class);
			}
			criteria.pagination(false);
			return loanBasicFeeMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}