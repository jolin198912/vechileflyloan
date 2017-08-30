package cn.houhe.api.loan.mapper;

import cn.houhe.api.loan.entity.bo.PaidListObject;
import cn.houhe.api.loan.web.bo.PaidListDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：audit_person
 * @since 2017-04-07 18:44:32
 */
public interface PaidListExtMapper {

	List<PaidListObject> selectPaidList(@Param("dto") PaidListDto dto);

	int selectPaidListCount(@Param("dto") PaidListDto dto);
}