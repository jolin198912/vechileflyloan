package cn.houhe.api.loan.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.loan.entity.ScheduleJob;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：schedule_job
 * @since 2017-04-27 16:27:05
 */
public interface ScheduleJobMapper {
	/**
	 * 按主键删除
	 * @since 2017-04-27 16:27:05
	 */
	int deleteByPrimaryKey(Integer jobId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-04-27 16:27:05
	 */
	int insert(ScheduleJob record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-04-27 16:27:05
	 */
	int insertSelective(ScheduleJob record);

	/**
	 * 按主键查询
	 * @since 2017-04-27 16:27:05
	 */
	ScheduleJob selectByPrimaryKey(Integer jobId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-04-27 16:27:05
	 */
	int updateByPrimaryKeySelective(ScheduleJob record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-04-27 16:27:05
	 */
	int updateByPrimaryKey(ScheduleJob record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-04-27 16:27:05
	 */
	List<ScheduleJob> selectByCriteria(Criteria<ScheduleJob> criteria);
}