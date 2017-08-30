package cn.houhe.api.loan.mapper;

import cn.houhe.api.loan.entity.bo.ReceivableListObject;
import cn.houhe.api.loan.web.bo.ReceivableListDto;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：audit_person
 * @since 2017-04-07 18:44:32
 */
public interface ReceivableListExtMapper {

	List<ReceivableListObject> selectReceivableList(@Param("dto") ReceivableListDto dto);

	int selectReceivableListCount(@Param("dto") ReceivableListDto dto);

	BigDecimal getPaiedAmount(@Param("loanid") Integer loanid, @Param("paydate")Date paydate);
}