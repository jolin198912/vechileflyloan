package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.loan.entity.LoanBankCard;
import cn.houhe.api.loan.mapper.LoanBankCardMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：loan_bank_card
 * @since 2017-05-05 16:09:35
 */
@Service("loanBankCardService")
public class LoanBankCardService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private LoanBankCardMapper loanBankCardMapper;

	public void insert(LoanBankCard entity) throws ServiceException {
		try {
			loanBankCardMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(LoanBankCard entity) throws ServiceException {
		try {
			loanBankCardMapper.deleteByPrimaryKey(entity.getLbcId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				loanBankCardMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(LoanBankCard entity) throws ServiceException {
		try {
			loanBankCardMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(LoanBankCard entity) throws ServiceException {
		try {
			loanBankCardMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public LoanBankCard findByPrimaryKey(Integer lbcId) throws ServiceException {
		try {
			return loanBankCardMapper.selectByPrimaryKey(lbcId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<LoanBankCard> findPage(Criteria<LoanBankCard> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(LoanBankCard.class);
			}
			criteria.pagination(true);
			List<LoanBankCard> list = loanBankCardMapper.selectByCriteria(criteria);
			return new Pager<LoanBankCard>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<LoanBankCard> findAll(Criteria<LoanBankCard> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(LoanBankCard.class);
			}
			criteria.pagination(false);
			return loanBankCardMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}