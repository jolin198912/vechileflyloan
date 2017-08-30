package cn.houhe.api.loan.mapper;

import cn.houhe.api.loan.entity.RepaymentsPlan;
import cn.houhe.api.loan.entity.bo.RepaymentDto;
import cn.houhe.api.loan.entity.bo.RepaymentDtoApp;
import cn.houhe.api.loan.web.bo.MemberDto;
import cn.houhe.api.loan.web.bo.RepaymentsDto;
import cn.houhe.api.loan.web.bo.RepaymentsPlanListDto;
import cn.houhe.api.loan.web.bo.SelectDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：repayments_plan
 * @since 2017-04-24 10:14:20
 */
@Repository
public interface RepaymentsPlanExtMapper {

	int selectRepaymentListCount(@Param("dto") RepaymentsDto dto);

	List<RepaymentDto> selectRepaymentList(@Param("dto") RepaymentsDto dto);

    RepaymentsPlan getPlanLock(@Param("rptId") Integer rptId);

	int selectOverdueListCount(@Param("dto") RepaymentsDto dto);

	List<RepaymentDto> selectOverdueList(@Param("dto") RepaymentsDto dto);

	List<RepaymentDtoApp> getNotPayList(@Param("dto")MemberDto dto);

	List<RepaymentsPlanListDto> getRepaymentsPlanList();

	RepaymentDtoApp getOverdueTotal(@Param("loanId")Integer loanid);

	BigDecimal getLastPrincipalTotal(@Param("loanId")Integer loanid);

	void updateStatus(@Param("loanId")Integer loanid);

	int updateRepayStatus(@Param("rpt_id")int repayments_plan_id,@Param("status")int status);

	Integer getPayingCount(@Param("loanId")Integer loanid);

	RepaymentDtoApp getLeastPayTime(@Param("loanId")Integer loanid);

	List<SelectDto> selectPersonnelList();

	boolean isAllPlanPay(@Param("loanId")Integer loanid);
}