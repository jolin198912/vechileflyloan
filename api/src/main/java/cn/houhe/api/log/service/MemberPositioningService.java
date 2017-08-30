package cn.houhe.api.log.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.log.entity.MemberPositioning;
import cn.houhe.api.log.mapper.MemberPositioningMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：member_positioning
 * @since 2017-04-07 14:30:23
 */
@Service("memberPositioningService")
public class MemberPositioningService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private MemberPositioningMapper memberPositioningMapper;

	public void insert(MemberPositioning entity) throws ServiceException {
		try {
			memberPositioningMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(MemberPositioning entity) throws ServiceException {
		try {
			memberPositioningMapper.deleteByPrimaryKey(entity.getMemposid());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				memberPositioningMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(MemberPositioning entity) throws ServiceException {
		try {
			memberPositioningMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(MemberPositioning entity) throws ServiceException {
		try {
			memberPositioningMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public MemberPositioning findByPrimaryKey(Integer memposid) throws ServiceException {
		try {
			return memberPositioningMapper.selectByPrimaryKey(memposid);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<MemberPositioning> findPage(Criteria<MemberPositioning> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(MemberPositioning.class);
			}
			criteria.pagination(true);
			List<MemberPositioning> list = memberPositioningMapper.selectByCriteria(criteria);
			return new Pager<MemberPositioning>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<MemberPositioning> findAll(Criteria<MemberPositioning> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(MemberPositioning.class);
			}
			criteria.pagination(false);
			return memberPositioningMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}