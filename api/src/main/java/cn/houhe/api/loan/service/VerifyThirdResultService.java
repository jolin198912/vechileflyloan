package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.loan.entity.VerifyThirdResult;
import cn.houhe.api.loan.mapper.VerifyThirdResultMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：verify_third_result
 * @since 2017-05-23 18:14:56
 */
@Service("verifyThirdResultService")
public class VerifyThirdResultService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private VerifyThirdResultMapper verifyThirdResultMapper;

	public void insert(VerifyThirdResult entity) throws ServiceException {
		try {
			verifyThirdResultMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(VerifyThirdResult entity) throws ServiceException {
		try {
			verifyThirdResultMapper.deleteByPrimaryKey(entity.getVtrId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				verifyThirdResultMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(VerifyThirdResult entity) throws ServiceException {
		try {
			verifyThirdResultMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(VerifyThirdResult entity) throws ServiceException {
		try {
			verifyThirdResultMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public VerifyThirdResult findByPrimaryKey(Integer vtrId) throws ServiceException {
		try {
			return verifyThirdResultMapper.selectByPrimaryKey(vtrId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<VerifyThirdResult> findPage(Criteria<VerifyThirdResult> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(VerifyThirdResult.class);
			}
			criteria.pagination(true);
			List<VerifyThirdResult> list = verifyThirdResultMapper.selectByCriteria(criteria);
			return new Pager<VerifyThirdResult>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<VerifyThirdResult> findAll(Criteria<VerifyThirdResult> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(VerifyThirdResult.class);
			}
			criteria.pagination(false);
			return verifyThirdResultMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}