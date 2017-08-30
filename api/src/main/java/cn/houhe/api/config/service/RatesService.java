package cn.houhe.api.config.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.config.entity.Rates;
import cn.houhe.api.config.mapper.RatesMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：rates
 * @since 2017-03-30 10:04:06
 */
@Service("ratesService")
public class RatesService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private RatesMapper ratesMapper;

	public void insert(Rates entity) throws ServiceException {
		try {
			ratesMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

//	public void delete(Rates entity) throws ServiceException {
//		try {
//			ratesMapper.deleteByPrimaryKey(entity.getLevelId() ,entity.getLpId());
//		} catch (Exception e) {
//			throw new ServiceException(e.getMessage(), e);
//		}
//	}

//	@Transactional
//	public void batchDelete(List<Short> ids) throws ServiceException {
//		try {
//			for (Short id : ids) {
//				ratesMapper.deleteByPrimaryKey(id);
//			}
//		} catch (Exception e) {
//			throw new ServiceException(e.getMessage(), e);
//		}
//	}

	public void update(Rates entity) throws ServiceException {
		try {
			ratesMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(Rates entity) throws ServiceException {
		try {
			ratesMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

//	public Rates findByPrimaryKey(Short levelId, Short lpId) throws ServiceException {
//		try {
//			return ratesMapper.selectByPrimaryKey(levelId ,lpId);
//		} catch (Exception e) {
//			throw new ServiceException(e.getMessage(), e);
//		}
//	}

	public Pager<Rates> findPage(Criteria<Rates> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(Rates.class);
			}
			criteria.pagination(true);
			List<Rates> list = ratesMapper.selectByCriteria(criteria);
			return new Pager<Rates>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<Rates> findAll(Criteria<Rates> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(Rates.class);
			}
			criteria.pagination(false);
			return ratesMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}