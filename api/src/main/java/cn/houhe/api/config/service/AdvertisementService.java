package cn.houhe.api.config.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.config.entity.Advertisement;
import cn.houhe.api.config.entity.AdvertisementExt;
import cn.houhe.api.config.mapper.AdvertisementExtMapper;
import cn.houhe.api.config.mapper.AdvertisementMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 业务实现层 - 表：advertisement
 * @since 2017-03-30 10:04:06
 */
@Service("advertisementService")
public class AdvertisementService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private AdvertisementMapper advertisementMapper;

	@Resource
	private AdvertisementExtMapper advertisementExtMapper;

	public void insert(Advertisement entity) throws ServiceException {
		try {
			advertisementMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void insertSelective(Advertisement entity) throws ServiceException {
		try {
			advertisementMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(Advertisement entity) throws ServiceException {
		try {
			advertisementMapper.deleteByPrimaryKey(entity.getAdId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				advertisementMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(Advertisement entity) throws ServiceException {
		try {
			advertisementMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(Advertisement entity) throws ServiceException {
		try {
			advertisementMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Advertisement findByPrimaryKey(Integer adId) throws ServiceException {
		try {
			return advertisementMapper.selectByPrimaryKey(adId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<Advertisement> findPage(Criteria<Advertisement> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(Advertisement.class);
			}
			criteria.pagination(true);
			List<Advertisement> list = advertisementMapper.selectByCriteria(criteria);
			return new Pager<Advertisement>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<Advertisement> findAll(Criteria<Advertisement> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(Advertisement.class);
			}
			criteria.pagination(false);
			return advertisementMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateStatus(AdvertisementExt entiy) throws ServiceException
	{
		try {
			 advertisementExtMapper.updateStatus(entiy);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<AdvertisementExt> selAdvList() throws ServiceException {
		try {
			return advertisementExtMapper.selectAdvList();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}