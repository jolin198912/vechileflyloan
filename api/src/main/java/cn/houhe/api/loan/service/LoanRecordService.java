package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.loan.entity.LoanRecord;
import cn.houhe.api.loan.mapper.LoanRecordMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：loan_record
 * @since 2017-04-12 15:46:36
 */
@Service("loanRecordService")
public class LoanRecordService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private LoanRecordMapper loanRecordMapper;

	public void insert(LoanRecord entity) throws ServiceException {
		try {
			loanRecordMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(LoanRecord entity) throws ServiceException {
		try {
			loanRecordMapper.deleteByPrimaryKey(entity.getLoanId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				loanRecordMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(LoanRecord entity) throws ServiceException {
		try {
			loanRecordMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(LoanRecord entity) throws ServiceException {
		try {
			loanRecordMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public LoanRecord findByPrimaryKey(Integer loanId) throws ServiceException {
		try {
			return loanRecordMapper.selectByPrimaryKey(loanId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<LoanRecord> findPage(Criteria<LoanRecord> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(LoanRecord.class);
			}
			criteria.pagination(true);
			List<LoanRecord> list = loanRecordMapper.selectByCriteria(criteria);
			return new Pager<LoanRecord>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<LoanRecord> findAll(Criteria<LoanRecord> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(LoanRecord.class);
			}
			criteria.pagination(false);
			return loanRecordMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}



}