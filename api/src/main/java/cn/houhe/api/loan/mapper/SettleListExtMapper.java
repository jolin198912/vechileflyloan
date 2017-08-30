package cn.houhe.api.loan.mapper;

import cn.houhe.api.loan.entity.bo.SettleListObject;
import cn.houhe.api.loan.web.bo.SettleListDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：audit_person
 * @since 2017-04-07 18:44:32
 */
public interface SettleListExtMapper {

	List<SettleListObject> selectSettleList(@Param("dto")SettleListDto dto);

	int selectSettleListCount(@Param("dto")SettleListDto dto);
}