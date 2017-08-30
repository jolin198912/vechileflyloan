package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.loan.entity.Remainder;
import cn.houhe.api.loan.mapper.RemainderMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：remainder
 * @since 2017-03-29 18:30:03
 */
@Service("remainderService")
public class RemainderService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private RemainderMapper remainderMapper;

	public void insert(Remainder entity) throws ServiceException {
		try {
			remainderMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void insertSelective(Remainder entity) throws ServiceException {
		try {
			remainderMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(Remainder entity) throws ServiceException {
		try {
			remainderMapper.deleteByPrimaryKey(entity.getRmdId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				remainderMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(Remainder entity) throws ServiceException {
		try {
			remainderMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(Remainder entity) throws ServiceException {
		try {
			remainderMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Remainder findByPrimaryKey(Integer rmdId) throws ServiceException {
		try {
			return remainderMapper.selectByPrimaryKey(rmdId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<Remainder> findPage(Criteria<Remainder> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(Remainder.class);
			}
			criteria.pagination(true);
			List<Remainder> list = remainderMapper.selectByCriteria(criteria);
			return new Pager<Remainder>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<Remainder> findAll(Criteria<Remainder> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(Remainder.class);
			}
			criteria.pagination(false);
			return remainderMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}