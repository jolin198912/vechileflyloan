package cn.houhe.api.loan.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.loan.entity.RiskmanageScoresRecord;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：riskmanage_scores_record
 * @since 2017-05-11 18:26:36
 */
public interface RiskmanageScoresRecordMapper {
	/**
	 * 按主键删除
	 * @since 2017-05-11 18:26:36
	 */
	int deleteByPrimaryKey(Integer rsrId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-05-11 18:26:36
	 */
	int insert(RiskmanageScoresRecord record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-05-11 18:26:36
	 */
	int insertSelective(RiskmanageScoresRecord record);

	/**
	 * 按主键查询
	 * @since 2017-05-11 18:26:36
	 */
	RiskmanageScoresRecord selectByPrimaryKey(Integer rsrId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-05-11 18:26:36
	 */
	int updateByPrimaryKeySelective(RiskmanageScoresRecord record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-05-11 18:26:36
	 */
	int updateByPrimaryKey(RiskmanageScoresRecord record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-05-11 18:26:36
	 */
	List<RiskmanageScoresRecord> selectByCriteria(Criteria<RiskmanageScoresRecord> criteria);
}