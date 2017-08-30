package cn.houhe.api.user.mapper;

import cn.houhe.api.user.entity.VerifyThirdQuery;
import cn.houhe.api.user.web.bo.VerifyThirdQueryDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/7.
 */
public interface VerifyThirdQueryExtMapper {
    Integer getCount(@Param("dto") VerifyThirdQueryDto dto);
    List<VerifyThirdQuery> getList(@Param("dto") VerifyThirdQueryDto dto);
    List<Map<String,String>> statics(@Param("dto") VerifyThirdQueryDto dto);
    Integer staticstotalcnt();
    VerifyThirdQuery getlast();
}
