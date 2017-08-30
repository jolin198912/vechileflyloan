package cn.houhe.api.member.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.member.entity.RegisterRecord;
import cn.houhe.api.member.entity.RegisterRecordExt;
import cn.houhe.api.member.mapper.RegisterRecordExtMapper;
import cn.houhe.api.member.mapper.RegisterRecordMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 业务实现层 - 表：register_record
 * @since 2017-04-14 11:59:03
 */
@Service("registerRecordExtService")
public class RegisterRecordExtService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private RegisterRecordExtMapper registerRecordExtMapper;

	public List<RegisterRecordExt> findPageExt(RegisterRecordExt registerRecordExt) throws ServiceException {
		try {
			List<RegisterRecordExt> list = registerRecordExtMapper.findPageData(registerRecordExt);
			return list;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Integer getCount(RegisterRecordExt registerRecordExt) throws ServiceException {
		try {
			return  registerRecordExtMapper.getCount(registerRecordExt);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public RegisterRecordExt findByMobile(String mobile) throws ServiceException {
		try {
			return registerRecordExtMapper.selectByMobile(mobile);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}