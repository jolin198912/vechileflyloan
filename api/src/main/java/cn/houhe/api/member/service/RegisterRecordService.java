package cn.houhe.api.member.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.member.entity.RegisterRecord;
import cn.houhe.api.member.entity.RegisterRecordExt;
import cn.houhe.api.member.mapper.RegisterRecordExtMapper;
import cn.houhe.api.member.mapper.RegisterRecordMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：register_record
 * @since 2017-04-14 11:59:03
 */
@Service("registerRecordService")
public class RegisterRecordService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private RegisterRecordMapper registerRecordMapper;

	@Resource
	private RegisterRecordExtMapper registerRecordExtMapper;

	public void insert(RegisterRecordExt entity) throws ServiceException {
		try {
			registerRecordExtMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void insert(RegisterRecord entity) throws ServiceException {
		try {
			registerRecordMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(RegisterRecord entity) throws ServiceException {
		try {
			registerRecordMapper.deleteByPrimaryKey(entity.getRrId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				registerRecordMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(RegisterRecord entity) throws ServiceException {
		try {
			registerRecordMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(RegisterRecord entity) throws ServiceException {
		try {
			registerRecordMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public RegisterRecord findByPrimaryKey(Integer rrId) throws ServiceException {
		try {
			return registerRecordMapper.selectByPrimaryKey(rrId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<RegisterRecord> findPage(Criteria<RegisterRecord> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(RegisterRecord.class);
			}
			criteria.pagination(true);
			List<RegisterRecord> list = registerRecordMapper.selectByCriteria(criteria);
			return new Pager<RegisterRecord>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<RegisterRecord> findAll(Criteria<RegisterRecord> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(RegisterRecord.class);
			}
			criteria.pagination(false);
			return registerRecordMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}