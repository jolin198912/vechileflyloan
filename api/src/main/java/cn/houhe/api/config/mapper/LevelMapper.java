package cn.houhe.api.config.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.config.entity.Level;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：level
 * @since 2017-04-28 16:36:11
 */
public interface LevelMapper {
	/**
	 * 按主键删除
	 * @since 2017-04-28 16:36:11
	 */
	int deleteByPrimaryKey(Short levelId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-04-28 16:36:11
	 */
	int insert(Level record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-04-28 16:36:11
	 */
	int insertSelective(Level record);

	/**
	 * 按主键查询
	 * @since 2017-04-28 16:36:11
	 */
	Level selectByPrimaryKey(Short levelId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-04-28 16:36:11
	 */
	int updateByPrimaryKeySelective(Level record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-04-28 16:36:11
	 */
	int updateByPrimaryKey(Level record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-04-28 16:36:11
	 */
	List<Level> selectByCriteria(Criteria<Level> criteria);
}