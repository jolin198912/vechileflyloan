package cn.houhe.api.loan.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * MyBatis Mapper 接口 - 表：remainder_plan
 * @since 2017-05-24 18:33:37
 */
public interface RemainderPlanExtMapper {
	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-05-24 18:33:37
	 */
	void insertSelective(@Param("loanRecordId") Integer loanRecordId, @Param("repaymentsPlanId") Integer repaymentsPlanId, @Param("remainderId") Integer remainderId, @Param("remainder") String remainder, @Param("remark") String remark, @Param("createdon") Date createdon);
}