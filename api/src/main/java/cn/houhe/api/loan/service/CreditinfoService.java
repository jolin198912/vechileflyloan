package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.loan.entity.Creditinfo;
import cn.houhe.api.loan.mapper.CreditinfoMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：creditinfo
 * @since 2017-04-10 16:38:32
 */
@Service("creditinfoService")
public class CreditinfoService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private CreditinfoMapper creditinfoMapper;

	public void insert(Creditinfo entity) throws ServiceException {
		try {
			creditinfoMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(Creditinfo entity) throws ServiceException {
		try {
			creditinfoMapper.deleteByPrimaryKey(entity.getCdId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				creditinfoMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(Creditinfo entity) throws ServiceException {
		try {
			creditinfoMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(Creditinfo entity) throws ServiceException {
		try {
			creditinfoMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Creditinfo findByPrimaryKey(Integer cdId) throws ServiceException {
		try {
			return creditinfoMapper.selectByPrimaryKey(cdId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<Creditinfo> findPage(Criteria<Creditinfo> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(Creditinfo.class);
			}
			criteria.pagination(true);
			List<Creditinfo> list = creditinfoMapper.selectByCriteria(criteria);
			return new Pager<Creditinfo>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<Creditinfo> findAll(Criteria<Creditinfo> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(Creditinfo.class);
			}
			criteria.pagination(false);
			return creditinfoMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}