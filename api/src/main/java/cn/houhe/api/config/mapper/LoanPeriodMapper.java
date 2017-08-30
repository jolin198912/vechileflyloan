package cn.houhe.api.config.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.config.entity.LoanPeriod;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：loan_period
 * @since 2017-03-30 10:04:06
 */
public interface LoanPeriodMapper {
	/**
	 * 按主键删除
	 * @since 2017-03-30 10:04:06
	 */
	int deleteByPrimaryKey(Short lpId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-03-30 10:04:06
	 */
	int insert(LoanPeriod record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-03-30 10:04:06
	 */
	int insertSelective(LoanPeriod record);

	/**
	 * 按主键查询
	 * @since 2017-03-30 10:04:06
	 */
	LoanPeriod selectByPrimaryKey(Short lpId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-03-30 10:04:06
	 */
	int updateByPrimaryKeySelective(LoanPeriod record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-03-30 10:04:06
	 */
	int updateByPrimaryKey(LoanPeriod record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-03-30 10:04:06
	 */
	List<LoanPeriod> selectByCriteria(Criteria<LoanPeriod> criteria);
}