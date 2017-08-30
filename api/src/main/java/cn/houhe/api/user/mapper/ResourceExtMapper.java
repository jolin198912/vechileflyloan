package cn.houhe.api.user.mapper;

import cn.houhe.api.user.entity.ResourceExt;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：resource
 * @since 2017-04-10 16:50:49
 */
public interface ResourceExtMapper {
	/**
	 * 查询所资源树
	 * @since 2017-04-10 16:50:49
	 */
	List<ResourceExt> findResourceAll();
}