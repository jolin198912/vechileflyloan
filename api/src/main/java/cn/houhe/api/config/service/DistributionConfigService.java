package cn.houhe.api.config.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.config.entity.DistributionConfig;
import cn.houhe.api.config.mapper.DistributionConfigMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：distribution__config
 * @since 2017-05-24 11:08:35
 */
@Service("distributionConfigService")
public class DistributionConfigService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private DistributionConfigMapper distributionConfigMapper;

	public void insert(DistributionConfig entity) throws ServiceException {
		try {
			distributionConfigMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(DistributionConfig entity) throws ServiceException {
		try {
			distributionConfigMapper.deleteByPrimaryKey(entity.getPcId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				distributionConfigMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(DistributionConfig entity) throws ServiceException {
		try {
			distributionConfigMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(DistributionConfig entity) throws ServiceException {
		try {
			distributionConfigMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public DistributionConfig findByPrimaryKey(Integer pcId) throws ServiceException {
		try {
			return distributionConfigMapper.selectByPrimaryKey(pcId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<DistributionConfig> findPage(Criteria<DistributionConfig> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(DistributionConfig.class);
			}
			criteria.pagination(true);
			List<DistributionConfig> list = distributionConfigMapper.selectByCriteria(criteria);
			return new Pager<DistributionConfig>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<DistributionConfig> findAll(Criteria<DistributionConfig> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(DistributionConfig.class);
			}
			criteria.pagination(false);
			return distributionConfigMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}