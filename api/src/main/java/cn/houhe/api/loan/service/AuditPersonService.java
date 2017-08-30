package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.loan.entity.AuditPerson;
import cn.houhe.api.loan.mapper.AuditPersonMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：audit_person
 * @since 2017-04-07 18:44:32
 */
@Service("auditPersonService")
public class AuditPersonService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private AuditPersonMapper auditPersonMapper;

	public void insert(AuditPerson entity) throws ServiceException {
		try {
			auditPersonMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(AuditPerson entity) throws ServiceException {
		try {
			auditPersonMapper.deleteByPrimaryKey(entity.getApId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				auditPersonMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(AuditPerson entity) throws ServiceException {
		try {
			auditPersonMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(AuditPerson entity) throws ServiceException {
		try {
			auditPersonMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public AuditPerson findByPrimaryKey(Integer apId) throws ServiceException {
		try {
			return auditPersonMapper.selectByPrimaryKey(apId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<AuditPerson> findPage(Criteria<AuditPerson> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(AuditPerson.class);
			}
			criteria.pagination(true);
			List<AuditPerson> list = auditPersonMapper.selectByCriteria(criteria);
			return new Pager<AuditPerson>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<AuditPerson> findAll(Criteria<AuditPerson> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(AuditPerson.class);
			}
			criteria.pagination(false);
			return auditPersonMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}