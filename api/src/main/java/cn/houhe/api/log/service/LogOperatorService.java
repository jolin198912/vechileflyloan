package cn.houhe.api.log.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.log.entity.LogOperator;
import cn.houhe.api.log.mapper.LogOperatorMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：log_operator
 * @since 2017-04-07 14:30:23
 */
@Service("logOperatorService")
public class LogOperatorService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private LogOperatorMapper logOperatorMapper;

	public void insert(LogOperator entity) throws ServiceException {
		try {
			logOperatorMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(LogOperator entity) throws ServiceException {
		try {
			logOperatorMapper.deleteByPrimaryKey(entity.getLoid());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				logOperatorMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(LogOperator entity) throws ServiceException {
		try {
			logOperatorMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(LogOperator entity) throws ServiceException {
		try {
			logOperatorMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public LogOperator findByPrimaryKey(Integer loid) throws ServiceException {
		try {
			return logOperatorMapper.selectByPrimaryKey(loid);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<LogOperator> findPage(Criteria<LogOperator> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(LogOperator.class);
			}
			criteria.pagination(true);
			List<LogOperator> list = logOperatorMapper.selectByCriteria(criteria);
			return new Pager<LogOperator>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<LogOperator> findAll(Criteria<LogOperator> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(LogOperator.class);
			}
			criteria.pagination(false);
			return logOperatorMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}