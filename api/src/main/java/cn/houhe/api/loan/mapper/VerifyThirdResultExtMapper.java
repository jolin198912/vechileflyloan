package cn.houhe.api.loan.mapper;

import cn.houhe.api.loan.entity.VerifyThirdResult;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/5/24.
 */
public interface VerifyThirdResultExtMapper {
    boolean addResult(VerifyThirdResult entity);
    VerifyThirdResult findByApplyId(@Param("credit_apply_id") int applyid);
}
