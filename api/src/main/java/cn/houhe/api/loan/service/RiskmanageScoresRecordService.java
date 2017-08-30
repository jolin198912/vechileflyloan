package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.loan.entity.RiskmanageScoresRecord;
import cn.houhe.api.loan.mapper.RiskmanageScoresRecordMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：riskmanage_scores_record
 * @since 2017-05-10 11:21:55
 */
@Service("riskmanageScoresRecordService")
public class RiskmanageScoresRecordService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private RiskmanageScoresRecordMapper riskmanageScoresRecordMapper;

	public void insert(RiskmanageScoresRecord entity) throws ServiceException {
		try {
			riskmanageScoresRecordMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void insertSelective(RiskmanageScoresRecord entity) throws ServiceException {
		try {
			riskmanageScoresRecordMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(RiskmanageScoresRecord entity) throws ServiceException {
		try {
			riskmanageScoresRecordMapper.deleteByPrimaryKey(entity.getRsrId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				riskmanageScoresRecordMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(RiskmanageScoresRecord entity) throws ServiceException {
		try {
			riskmanageScoresRecordMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(RiskmanageScoresRecord entity) throws ServiceException {
		try {
			riskmanageScoresRecordMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public RiskmanageScoresRecord findByPrimaryKey(Integer rsrId) throws ServiceException {
		try {
			return riskmanageScoresRecordMapper.selectByPrimaryKey(rsrId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<RiskmanageScoresRecord> findPage(Criteria<RiskmanageScoresRecord> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(RiskmanageScoresRecord.class);
			}
			criteria.pagination(true);
			List<RiskmanageScoresRecord> list = riskmanageScoresRecordMapper.selectByCriteria(criteria);
			return new Pager<RiskmanageScoresRecord>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<RiskmanageScoresRecord> findAll(Criteria<RiskmanageScoresRecord> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(RiskmanageScoresRecord.class);
			}
			criteria.pagination(false);
			return riskmanageScoresRecordMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}