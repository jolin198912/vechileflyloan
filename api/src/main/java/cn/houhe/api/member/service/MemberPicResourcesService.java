package cn.houhe.api.member.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.member.entity.MemberPicResources;
import cn.houhe.api.member.mapper.MemberPicResourcesMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：member_pic_resources
 * @since 2017-03-30 10:12:39
 */
@Service("memberPicResourcesService")
public class MemberPicResourcesService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private MemberPicResourcesMapper memberPicResourcesMapper;

	public void insert(MemberPicResources entity) throws ServiceException {
		try {
			memberPicResourcesMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(MemberPicResources entity) throws ServiceException {
		try {
			memberPicResourcesMapper.deleteByPrimaryKey(entity.getMemresid());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				memberPicResourcesMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(MemberPicResources entity) throws ServiceException {
		try {
			memberPicResourcesMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(MemberPicResources entity) throws ServiceException {
		try {
			memberPicResourcesMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public MemberPicResources findByPrimaryKey(Integer memresid) throws ServiceException {
		try {
			return memberPicResourcesMapper.selectByPrimaryKey(memresid);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<MemberPicResources> findPage(Criteria<MemberPicResources> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(MemberPicResources.class);
			}
			criteria.pagination(true);
			List<MemberPicResources> list = memberPicResourcesMapper.selectByCriteria(criteria);
			return new Pager<MemberPicResources>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<MemberPicResources> findAll(Criteria<MemberPicResources> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(MemberPicResources.class);
			}
			criteria.pagination(false);
			return memberPicResourcesMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}