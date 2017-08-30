package cn.houhe.api.loan.mapper;

import cn.houhe.api.loan.entity.bo.WithholdListObject;
import cn.houhe.api.loan.web.bo.WithholdListDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：audit_person
 * @since 2017-04-07 18:44:32
 */
public interface WithholdListExtMapper {

	List<WithholdListObject> selectWithholdList(@Param("dto") WithholdListDto dto);

	int selectWithholdListCount(@Param("dto") WithholdListDto dto);
}