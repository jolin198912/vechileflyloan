package cn.houhe.api.loan.service.job;

import cn.com.iotrust.common.util.SpringContextHolder;
import cn.houhe.api.loan.service.CreditApplyExtService;

/**
 * Created by think on 2017/4/25.
 */
public class CreditApproveJob {
    public void approve(String tokenKey, Integer caId, Integer memberId) throws Exception{
        SpringContextHolder.getBean(CreditApplyExtService.class).autoApprove(tokenKey,caId,memberId);
    }
}
