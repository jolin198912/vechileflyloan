package cn.houhe.api.user.mapper;

import cn.houhe.api.user.entity.RoleResourceExt;
import cn.houhe.api.user.web.bo.RoleResouDto;

import java.util.List;

/**
 * MyBatis Mapper 接口 - ：role
 * @since 2017-03-30 13:50:02
 */
public interface RoleExtMapper {

	RoleResouDto selectForRole(Integer roleid);
	void  batchAssignRes(List<RoleResourceExt> list);
	void deleteResource(Integer roleid);
}