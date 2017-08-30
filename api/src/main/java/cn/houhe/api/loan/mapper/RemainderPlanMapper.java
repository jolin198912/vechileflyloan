package cn.houhe.api.loan.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.loan.entity.RemainderPlan;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：remainder_plan
 * @since 2017-05-24 18:33:37
 */
public interface RemainderPlanMapper {
	/**
	 * 按主键删除
	 * @since 2017-05-24 18:33:37
	 */
	int deleteByPrimaryKey(Integer rpId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-05-24 18:33:37
	 */
	int insert(RemainderPlan record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-05-24 18:33:37
	 */
	void insertSelective(@Param("loanRecordId")Integer loanRecordId, @Param("repaymentsPlanId")Integer repaymentsPlanId, @Param("remainderId")Integer remainderId, @Param("remainder")String remainder, @Param("remark")String remark, @Param("createdon")Date createdon);

	/**
	 * 按主键查询
	 * @since 2017-05-24 18:33:37
	 */
	RemainderPlan selectByPrimaryKey(Integer rpId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-05-24 18:33:37
	 */
	int updateByPrimaryKeySelective(RemainderPlan record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-05-24 18:33:37
	 */
	int updateByPrimaryKey(RemainderPlan record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-05-24 18:33:37
	 */
	List<RemainderPlan> selectByCriteria(Criteria<RemainderPlan> criteria);
}