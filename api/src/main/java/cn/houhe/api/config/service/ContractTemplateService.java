package cn.houhe.api.config.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.config.entity.ContractTemplate;
import cn.houhe.api.config.mapper.ContractTemplateMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：contract_template
 * @since 2017-03-30 10:04:06
 */
@Service("contractTemplateService")
public class ContractTemplateService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private ContractTemplateMapper contractTemplateMapper;

	public void insert(ContractTemplate entity) throws ServiceException {
		try {
			contractTemplateMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(ContractTemplate entity) throws ServiceException {
		try {
			contractTemplateMapper.deleteByPrimaryKey(entity.getCtId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Short> ids) throws ServiceException {
		try {
			for (Short id : ids) {
				contractTemplateMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(ContractTemplate entity) throws ServiceException {
		try {
			contractTemplateMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(ContractTemplate entity) throws ServiceException {
		try {
			contractTemplateMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public ContractTemplate findByPrimaryKey(Short ctId) throws ServiceException {
		try {
			return contractTemplateMapper.selectByPrimaryKey(ctId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<ContractTemplate> findPage(Criteria<ContractTemplate> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(ContractTemplate.class);
			}
			criteria.pagination(true);
			List<ContractTemplate> list = contractTemplateMapper.selectByCriteria(criteria);
			return new Pager<ContractTemplate>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<ContractTemplate> findAll(Criteria<ContractTemplate> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(ContractTemplate.class);
			}
			criteria.pagination(false);
			return contractTemplateMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}