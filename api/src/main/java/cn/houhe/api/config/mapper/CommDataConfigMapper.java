package cn.houhe.api.config.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.config.entity.CommDataConfig;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：comm_data_config
 * @since 2017-04-13 11:30:10
 */
@Repository
public interface CommDataConfigMapper {
	/**
	 * 按主键删除
	 * @since 2017-04-13 11:30:10
	 */
	int deleteByPrimaryKey(Short menuId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-04-13 11:30:10
	 */
	int insert(CommDataConfig record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-04-13 11:30:10
	 */
	int insertSelective(CommDataConfig record);

	/**
	 * 按主键查询
	 * @since 2017-04-13 11:30:10
	 */
	CommDataConfig selectByPrimaryKey(Short menuId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-04-13 11:30:10
	 */
	int updateByPrimaryKeySelective(CommDataConfig record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-04-13 11:30:10
	 */
	int updateByPrimaryKey(CommDataConfig record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-04-13 11:30:10
	 */
	List<CommDataConfig> selectByCriteria(Criteria<CommDataConfig> criteria);
}