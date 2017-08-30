package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.loan.entity.AuthorizeInfo;
import cn.houhe.api.loan.mapper.AuthorizeInfoMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：authorize_info
 * @since 2017-04-20 16:50:02
 */
@Service("authorizeInfoService")
public class AuthorizeInfoService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private AuthorizeInfoMapper authorizeInfoMapper;

	public void insert(AuthorizeInfo entity) throws ServiceException {
		try {
			authorizeInfoMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(AuthorizeInfo entity) throws ServiceException {
		try {
			authorizeInfoMapper.deleteByPrimaryKey(entity.getAiId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				authorizeInfoMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(AuthorizeInfo entity) throws ServiceException {
		try {
			authorizeInfoMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(AuthorizeInfo entity) throws ServiceException {
		try {
			authorizeInfoMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public AuthorizeInfo findByPrimaryKey(Integer aiId) throws ServiceException {
		try {
			return authorizeInfoMapper.selectByPrimaryKey(aiId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<AuthorizeInfo> findPage(Criteria<AuthorizeInfo> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(AuthorizeInfo.class);
			}
			criteria.pagination(true);
			List<AuthorizeInfo> list = authorizeInfoMapper.selectByCriteria(criteria);
			return new Pager<AuthorizeInfo>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<AuthorizeInfo> findAll(Criteria<AuthorizeInfo> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(AuthorizeInfo.class);
			}
			criteria.pagination(false);
			return authorizeInfoMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}