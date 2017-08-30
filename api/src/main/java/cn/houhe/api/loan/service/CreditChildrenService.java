package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.loan.entity.CreditChildren;
import cn.houhe.api.loan.mapper.CreditChildrenMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：credit_children
 * @since 2017-05-06 17:56:22
 */
@Service("creditChildrenService")
public class CreditChildrenService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private CreditChildrenMapper creditChildrenMapper;

	public void insert(CreditChildren entity) throws ServiceException {
		try {
			creditChildrenMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(CreditChildren entity) throws ServiceException {
		try {
			creditChildrenMapper.deleteByPrimaryKey(entity.getCcdId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				creditChildrenMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(CreditChildren entity) throws ServiceException {
		try {
			creditChildrenMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(CreditChildren entity) throws ServiceException {
		try {
			creditChildrenMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public CreditChildren findByPrimaryKey(Integer ccdId) throws ServiceException {
		try {
			return creditChildrenMapper.selectByPrimaryKey(ccdId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<CreditChildren> findPage(Criteria<CreditChildren> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(CreditChildren.class);
			}
			criteria.pagination(true);
			List<CreditChildren> list = creditChildrenMapper.selectByCriteria(criteria);
			return new Pager<CreditChildren>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<CreditChildren> findAll(Criteria<CreditChildren> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(CreditChildren.class);
			}
			criteria.pagination(false);
			return creditChildrenMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}