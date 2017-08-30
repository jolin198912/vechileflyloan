package cn.houhe.api.user.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.user.entity.Resource;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：resource
 * @since 2017-04-10 16:50:49
 */
public interface ResourceMapper {
	/**
	 * 按主键删除
	 * @since 2017-04-10 16:50:49
	 */
	int deleteByPrimaryKey(Integer resId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-04-10 16:50:49
	 */
	int insert(Resource record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-04-10 16:50:49
	 */
	int insertSelective(Resource record);

	/**
	 * 按主键查询
	 * @since 2017-04-10 16:50:49
	 */
	Resource selectByPrimaryKey(Integer resId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-04-10 16:50:49
	 */
	int updateByPrimaryKeySelective(Resource record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-04-10 16:50:49
	 */
	int updateByPrimaryKey(Resource record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-04-10 16:50:49
	 */
	List<Resource> selectByCriteria(Criteria<Resource> criteria);
}