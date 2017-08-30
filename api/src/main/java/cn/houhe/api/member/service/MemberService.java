package cn.houhe.api.member.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.member.entity.Member;
import cn.houhe.api.member.entity.MemberExt;
import cn.houhe.api.member.entity.RegisterRecord;
import cn.houhe.api.member.entity.RegisterRecordExt;
import cn.houhe.api.member.mapper.MemberExtMapper;
import cn.houhe.api.member.mapper.MemberMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：member
 * @since 2017-03-30 10:12:39
 */
@Service("memberService")
public class MemberService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private MemberMapper memberMapper;
	@Autowired
	private RegisterRecordService registerRecordService;

	@Autowired
	private RegisterRecordExtService registerRecordExtService;

	@Transactional(rollbackFor = Exception.class)
	public void insertMemAndRecord(Member member, RegisterRecordExt registerRecordExt) throws ServiceException {
		try {
			insertSelective(member);
			RegisterRecordExt regrecord = registerRecordExtService.findByMobile(registerRecordExt.getMobile());
			if(regrecord == null){
				registerRecordService.insert(registerRecordExt);
			}else {
				RegisterRecord registerRecord = new RegisterRecord();
				registerRecord.setRrId(regrecord.getRrId());
				registerRecord.setMobile(regrecord.getMobile());
				registerRecord.setIdCode(registerRecordExt.getIdCode());
				registerRecord.setIdCodeCount(registerRecordExt.getIdCodeCount());
				registerRecord.setIsSuccess(registerRecordExt.getIsSuccess());
				registerRecordService.updateSelective(registerRecord);
			}
		}catch (Exception e) {
			throw new ServiceException(e.getMessage(),e);
		}

	}

	public void insert(Member entity) throws ServiceException {
		try {
			memberMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void insertSelective(Member entity) throws ServiceException {
		try {
			memberMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(Member entity) throws ServiceException {
		try {
			memberMapper.deleteByPrimaryKey(entity.getMemid());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				memberMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(Member entity) throws ServiceException {
		try {
			memberMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(Member entity) throws ServiceException {
		try {
			memberMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Member findByPrimaryKey(Integer memid) throws ServiceException {
		try {
			return memberMapper.selectByPrimaryKey(memid);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<Member> findPage(Criteria<Member> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(Member.class);
			}
			criteria.pagination(true);
			List<Member> list = memberMapper.selectByCriteria(criteria);
			return new Pager<Member>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<Member> findAll(Criteria<Member> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(Member.class);
			}
			criteria.pagination(false);
			return memberMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}