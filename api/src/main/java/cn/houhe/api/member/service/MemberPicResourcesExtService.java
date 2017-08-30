package cn.houhe.api.member.service;

import cn.com.iotrust.common.ServiceException;
import cn.houhe.api.common.AliTools;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.member.entity.MemberPicResources;
import cn.houhe.api.member.mapper.MemberPicResourcesExtMapper;
import cn.houhe.api.member.web.MemberPicResourcesAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;

/**
 * 业务实现层 - 表：member_pic_resources
 * @since 2017-03-30 10:12:39
 */
@Service("memberPicResourcesExtService")
public class MemberPicResourcesExtService implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(MemberPicResourcesAction.class);

	@Resource
	private MemberPicResourcesExtMapper memberPicResourcesExtMapper;

	public MemberPicResources findPicByMemberId(Integer memberId) throws ServiceException {
		try {
			return memberPicResourcesExtMapper.selectPicByMemberId(memberId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void insertHeadPic(MemberPicResources entity) throws ServiceException {
		try {
			memberPicResourcesExtMapper.insertHeadPic(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateHeadPicByMemberId(MemberPicResources entity) throws ServiceException {
		try {
			memberPicResourcesExtMapper.updateHeadPicByMemberId(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * 修改用户头像
	 * @param param
	 * @return
	 */
	public ResultDto updateHeadPicSer(RequestDto<MemberPicResources> param) {
		ResultDto result = new ResultDto("0","修改用户头像");
		try {
			MemberPicResources m = param.getData();
			MemberPicResources mempic = findPicByMemberId(m.getMemberId());
			m.setUrl(AliTools.ossPrefix + m.getUrl());
			if(mempic != null) {
				m.setModifiedon(new Date());
				updateHeadPicByMemberId(m);
			}else {
				m.setCreatedon(new Date());
				insertHeadPic(m);
			}
			result.setData(m.getUrl());
			result.setMsg("头像修改成功");
			return result;
		}catch (Exception e){
			result.setCode("-1");
			result.setMsg("头像修改失败，请重试");
			logger.error(e.getMessage(), e);
		}
		return result;
	}
}