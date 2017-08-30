package cn.houhe.api.config.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.config.entity.DistributionConfig;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：distribution__config
 * @since 2017-05-24 11:08:35
 */
public interface DistributionConfigMapper {
	/**
	 * 按主键删除
	 * @since 2017-05-24 11:08:35
	 */
	int deleteByPrimaryKey(Integer pcId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-05-24 11:08:35
	 */
	int insert(DistributionConfig record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-05-24 11:08:35
	 */
	int insertSelective(DistributionConfig record);

	/**
	 * 按主键查询
	 * @since 2017-05-24 11:08:35
	 */
	DistributionConfig selectByPrimaryKey(Integer pcId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-05-24 11:08:35
	 */
	int updateByPrimaryKeySelective(DistributionConfig record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-05-24 11:08:35
	 */
	int updateByPrimaryKey(DistributionConfig record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-05-24 11:08:35
	 */
	List<DistributionConfig> selectByCriteria(Criteria<DistributionConfig> criteria);
}