package cn.houhe.api.loan.mapper;

import cn.houhe.api.loan.entity.bo.LoanList;
import cn.houhe.api.loan.entity.bo.LoanRecordInfoAPP;
import cn.houhe.api.loan.entity.bo.LoanRecordInfoObject;
import cn.houhe.api.loan.web.bo.LoanListDto;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * MyBatis Mapper 接口 - 表：loan_record
 * @since 2017-04-12 15:46:36
 */
public interface LoanRecordExtMapper {

	int selectLoanApplyListCount(@Param("dto") LoanListDto loanListDto);

	List<LoanList> selectLoanApplyList(@Param("dto") LoanListDto loanListDto, @Param("startRow") int startRow, @Param("pageSize") int pageSize);


    LoanRecordInfoObject getLoanApplyInfo(@Param("lrid") Integer lrid);

	Integer getLoanTotalMoney(@Param("dto") LoanListDto loanListDto);

	LoanRecordInfoAPP getInfoByid(@Param("loanid") Integer loanid);

	LoanRecordInfoAPP getDetailById(@Param("loanid") Integer loanid);

	void updateAdvancefee(@Param("loanId")Integer loanId, @Param("advancefee")BigDecimal advancefee);

    Map loanSum(@Param("start") Date start,@Param("end") Date end);

	Map compLoanBadSum(@Param("start") Date start, @Param("end") Date end);

	Map loanBalance(@Param("start") Date start,@Param("end") Date end);

	Map loanBadSum(@Param("start") Date start,@Param("end") Date end);

	BigDecimal getFine(@Param("loanid") Integer loanid);
}