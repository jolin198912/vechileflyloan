package cn.houhe.api.config.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.config.entity.Rates;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：rates
 * @since 2017-05-05 12:22:12
 */
public interface RatesMapper {
	/**
	 * 按主键删除
	 * @since 2017-05-05 12:22:12
	 */
	int deleteByPrimaryKey(Short rrId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-05-05 12:22:12
	 */
	int insert(Rates record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-05-05 12:22:12
	 */
	int insertSelective(Rates record);

	/**
	 * 按主键查询
	 * @since 2017-05-05 12:22:12
	 */
	Rates selectByPrimaryKey(Short rrId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-05-05 12:22:12
	 */
	int updateByPrimaryKeySelective(Rates record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-05-05 12:22:12
	 */
	int updateByPrimaryKey(Rates record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-05-05 12:22:12
	 */
	List<Rates> selectByCriteria(Criteria<Rates> criteria);
}