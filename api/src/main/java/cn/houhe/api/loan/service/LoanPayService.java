package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.ServiceOperationException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.loan.entity.LoanPay;
import cn.houhe.api.loan.mapper.LoanPayExtMapper;
import cn.houhe.api.loan.mapper.LoanPayMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 业务实现层 - 表：loan_pay
 * @since 2017-04-13 15:27:06
 */
@Service("loanPayService")
public class LoanPayService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private LoanPayMapper loanPayMapper;
	@Resource
	private LoanPayExtMapper loanPayExtMapper;

	public void insert(LoanPay entity) throws ServiceException {
		try {
			loanPayMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(LoanPay entity) throws ServiceException {
		try {
			loanPayMapper.deleteByPrimaryKey(entity.getLpId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				loanPayMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(LoanPay entity) throws ServiceException {
		try {
			loanPayMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(LoanPay entity) throws ServiceException {
		try {
			loanPayMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public LoanPay findByPrimaryKey(Integer lpId) throws ServiceException {
		try {
			return loanPayMapper.selectByPrimaryKey(lpId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<LoanPay> findPage(Criteria<LoanPay> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(LoanPay.class);
			}
			criteria.pagination(true);
			List<LoanPay> list = loanPayMapper.selectByCriteria(criteria);
			return new Pager<LoanPay>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<LoanPay> findAll(Criteria<LoanPay> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(LoanPay.class);
			}
			criteria.pagination(false);
			return loanPayMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}