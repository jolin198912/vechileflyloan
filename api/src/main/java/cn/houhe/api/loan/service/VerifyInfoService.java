package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.loan.entity.VerifyInfo;
import cn.houhe.api.loan.mapper.VerifyInfoMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：verify_info
 * @since 2017-05-23 11:06:38
 */
@Service("verifyInfoService")
public class VerifyInfoService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private VerifyInfoMapper verifyInfoMapper;

	public void insert(VerifyInfo entity) throws ServiceException {
		try {
			verifyInfoMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(VerifyInfo entity) throws ServiceException {
		try {
			verifyInfoMapper.deleteByPrimaryKey(entity.getVfiId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				verifyInfoMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(VerifyInfo entity) throws ServiceException {
		try {
			verifyInfoMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(VerifyInfo entity) throws ServiceException {
		try {
			verifyInfoMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public VerifyInfo findByPrimaryKey(Integer vfiId) throws ServiceException {
		try {
			return verifyInfoMapper.selectByPrimaryKey(vfiId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<VerifyInfo> findPage(Criteria<VerifyInfo> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(VerifyInfo.class);
			}
			criteria.pagination(true);
			List<VerifyInfo> list = verifyInfoMapper.selectByCriteria(criteria);
			return new Pager<VerifyInfo>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<VerifyInfo> findAll(Criteria<VerifyInfo> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(VerifyInfo.class);
			}
			criteria.pagination(false);
			return verifyInfoMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}