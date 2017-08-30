package cn.houhe.api.loan.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.loan.entity.RepaymentsPlan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：repayments_plan
 * @since 2017-05-11 11:13:42
 */
@Repository
public interface RepaymentsPlanMapper {
	/**
	 * 按主键删除
	 * @since 2017-05-11 11:13:42
	 */
	int deleteByPrimaryKey(Integer rptId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-05-11 11:13:42
	 */
	int insert(RepaymentsPlan record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-05-11 11:13:42
	 */
	int insertSelective(RepaymentsPlan record);

	/**
	 * 按主键查询
	 * @since 2017-05-11 11:13:42
	 */
	RepaymentsPlan selectByPrimaryKey(Integer rptId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-05-11 11:13:42
	 */
	int updateByPrimaryKeySelective(RepaymentsPlan record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-05-11 11:13:42
	 */
	int updateByPrimaryKey(RepaymentsPlan record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-05-11 11:13:42
	 */
	List<RepaymentsPlan> selectByCriteria(Criteria<RepaymentsPlan> criteria);
}