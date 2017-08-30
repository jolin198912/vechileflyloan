package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.loan.entity.DebitCallbackRcd;
import cn.houhe.api.loan.mapper.DebitCallbackRcdMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：debit_callback_rcd
 * @since 2017-03-29 18:30:03
 */
@Service("debitCallbackRcdService")
public class DebitCallbackRcdService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private DebitCallbackRcdMapper debitCallbackRcdMapper;

	public void insert(DebitCallbackRcd entity) throws ServiceException {
		try {
			debitCallbackRcdMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(DebitCallbackRcd entity) throws ServiceException {
		try {
			debitCallbackRcdMapper.deleteByPrimaryKey(entity.getDcrId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				debitCallbackRcdMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(DebitCallbackRcd entity) throws ServiceException {
		try {
			debitCallbackRcdMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(DebitCallbackRcd entity) throws ServiceException {
		try {
			debitCallbackRcdMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public DebitCallbackRcd findByPrimaryKey(Integer dcrId) throws ServiceException {
		try {
			return debitCallbackRcdMapper.selectByPrimaryKey(dcrId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<DebitCallbackRcd> findPage(Criteria<DebitCallbackRcd> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(DebitCallbackRcd.class);
			}
			criteria.pagination(true);
			List<DebitCallbackRcd> list = debitCallbackRcdMapper.selectByCriteria(criteria);
			return new Pager<DebitCallbackRcd>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<DebitCallbackRcd> findAll(Criteria<DebitCallbackRcd> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(DebitCallbackRcd.class);
			}
			criteria.pagination(false);
			return debitCallbackRcdMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}