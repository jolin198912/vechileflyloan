package cn.houhe.api.user.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.user.entity.Resource;
import cn.houhe.api.user.entity.ResourceExt;
import cn.houhe.api.user.mapper.ResourceExtMapper;
import cn.houhe.api.user.mapper.ResourceMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * 业务实现层 - 表：resource
 * @since 2017-04-10 16:42:07
 */
@Service("resourceService")
public class ResourceService implements Serializable {
	private static final long serialVersionUID = 1L;

	@javax.annotation.Resource
	private ResourceMapper resourceMapper;

	@javax.annotation.Resource
	private ResourceExtMapper resourceExtMapper;

	public void insert(Resource entity) throws ServiceException {
		try {
			resourceMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<ResourceExt> findAllResource() throws ServiceException {
		try {
			return resourceExtMapper.findResourceAll();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(Resource entity) throws ServiceException {
		try {
			resourceMapper.deleteByPrimaryKey(entity.getResId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				resourceMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(Resource entity) throws ServiceException {
		try {
			resourceMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(Resource entity) throws ServiceException {
		try {
			resourceMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Resource findByPrimaryKey(Integer resId) throws ServiceException {
		try {
			return resourceMapper.selectByPrimaryKey(resId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<Resource> findPage(Criteria<Resource> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(Resource.class);
			}
			criteria.pagination(true);
			List<Resource> list = resourceMapper.selectByCriteria(criteria);
			return new Pager<Resource>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<Resource> findAll(Criteria<Resource> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(Resource.class);
			}
			criteria.pagination(false);
			return resourceMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}