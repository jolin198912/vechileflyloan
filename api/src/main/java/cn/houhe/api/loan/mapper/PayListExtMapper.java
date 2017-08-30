package cn.houhe.api.loan.mapper;

import cn.houhe.api.loan.entity.bo.PayListObject;
import cn.houhe.api.loan.web.bo.PayListDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：audit_person
 * @since 2017-04-07 18:44:32
 */
public interface PayListExtMapper {

	List<PayListObject> selectPayList(@Param("dto") PayListDto dto);

	int selectPayListCount(@Param("dto") PayListDto dto);
}