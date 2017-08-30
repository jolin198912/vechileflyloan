package cn.houhe.api.log.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.log.entity.LogOperator;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：log_operator
 * @since 2017-04-10 11:10:03
 */
public interface LogOperatorMapper {
	/**
	 * 按主键删除
	 * @since 2017-04-10 11:10:03
	 */
	int deleteByPrimaryKey(Integer loid);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-04-10 11:10:03
	 */
	int insert(LogOperator record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-04-10 11:10:03
	 */
	int insertSelective(LogOperator record);

	/**
	 * 按主键查询
	 * @since 2017-04-10 11:10:03
	 */
	LogOperator selectByPrimaryKey(Integer loid);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-04-10 11:10:03
	 */
	int updateByPrimaryKeySelective(LogOperator record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-04-10 11:10:03
	 */
	int updateByPrimaryKey(LogOperator record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-04-10 11:10:03
	 */
	List<LogOperator> selectByCriteria(Criteria<LogOperator> criteria);
}