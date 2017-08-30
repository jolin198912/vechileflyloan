package cn.houhe.api.user.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.user.entity.Role;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 瑙掕壊琛�：role
 * @since 2017-03-30 13:50:02
 */
public interface RoleMapper {
	/**
	 * 按主键删除
	 * @since 2017-03-30 13:50:02
	 */
	int deleteByPrimaryKey(Integer roleid);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-03-30 13:50:02
	 */
	int insert(Role record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-03-30 13:50:02
	 */
	int insertSelective(Role record);

	/**
	 * 按主键查询
	 * @since 2017-03-30 13:50:02
	 */
	Role selectByPrimaryKey(Integer roleid);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-03-30 13:50:02
	 */
	int updateByPrimaryKeySelective(Role record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-03-30 13:50:02
	 */
	int updateByPrimaryKey(Role record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-03-30 13:50:02
	 */
	List<Role> selectByCriteria(Criteria<Role> criteria);
}