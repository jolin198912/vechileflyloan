package cn.houhe.api.member.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.member.entity.PhoneContact;
import cn.houhe.api.member.mapper.PhoneContactMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：phone_contact
 * @since 2017-04-21 17:41:59
 */
@Service("phoneContactService")
public class PhoneContactService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private PhoneContactMapper phoneContactMapper;

	public void insert(PhoneContact entity) throws ServiceException {
		try {
			phoneContactMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(PhoneContact entity) throws ServiceException {
		try {
			phoneContactMapper.deleteByPrimaryKey(entity.getPcId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				phoneContactMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(PhoneContact entity) throws ServiceException {
		try {
			phoneContactMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(PhoneContact entity) throws ServiceException {
		try {
			phoneContactMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public PhoneContact findByPrimaryKey(Integer pcId) throws ServiceException {
		try {
			return phoneContactMapper.selectByPrimaryKey(pcId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<PhoneContact> findPage(Criteria<PhoneContact> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(PhoneContact.class);
			}
			criteria.pagination(true);
			List<PhoneContact> list = phoneContactMapper.selectByCriteria(criteria);
			return new Pager<PhoneContact>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<PhoneContact> findAll(Criteria<PhoneContact> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(PhoneContact.class);
			}
			criteria.pagination(false);
			return phoneContactMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}