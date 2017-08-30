package cn.houhe.api.loan.web.bo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/2.
 */
public class ReceivableListExcelDto {
    //合同编号
    public String loan_number;
    //客户姓名
    public String username;
    //客户贷款情况0新增客户1结清再贷2增贷
    public String memSituation;
    //借款金额
    public BigDecimal loan_limit;
    //贷款综合利率
    public String rate;
    //贷款期限
    public String time;
    //逾期天数
    public Integer delayDays;
    //应收合计
    public BigDecimal receivableTotal;
    //上月剩余本金
    public BigDecimal lastPrincipal;
    //本月剩余本金
    public BigDecimal currentPrincipal;
    //合同出借人
    public String lenders;

    public ReceivableListExcelDto()
    {
    }

    public ReceivableListExcelDto(String loan_number, String username, String memSituation, BigDecimal loan_limit, String rate, String time, Integer delayDays, BigDecimal receivableTotal, BigDecimal lastPrincipal, BigDecimal currentPrincipal)
    {
        this.loan_number = loan_number;
        this.username = username;
        this.memSituation = memSituation;
        this.loan_limit = loan_limit;
        this.rate = rate;
        this.time = time;
        this.delayDays = delayDays;
        this.receivableTotal = receivableTotal;
        this.lastPrincipal = lastPrincipal;
        this.currentPrincipal = currentPrincipal;
        this.lenders = "潘坚铭";
    }

    public String getLoan_number() {
        return loan_number;
    }

    public void setLoan_number(String loan_number) {
        this.loan_number = loan_number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMemSituation() {
        return memSituation;
    }

    public void setMemSituation(String memSituation) {
        this.memSituation = memSituation;
    }

    public BigDecimal getLoan_limit() {
        return loan_limit;
    }

    public void setLoan_limit(BigDecimal loan_limit) {
        this.loan_limit = loan_limit;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getDelayDays() {
        return delayDays;
    }

    public void setDelayDays(Integer delayDays) {
        this.delayDays = delayDays;
    }

    public BigDecimal getReceivableTotal() {
        return receivableTotal;
    }

    public void setReceivableTotal(BigDecimal receivableTotal) {
        this.receivableTotal = receivableTotal;
    }

    public BigDecimal getLastPrincipal() {
        return lastPrincipal;
    }

    public void setLastPrincipal(BigDecimal lastPrincipal) {
        this.lastPrincipal = lastPrincipal;
    }

    public BigDecimal getCurrentPrincipal() {
        return currentPrincipal;
    }

    public void setCurrentPrincipal(BigDecimal currentPrincipal) {
        this.currentPrincipal = currentPrincipal;
    }

    public String getLenders() {
        return lenders;
    }

    public void setLenders(String lenders) {
        this.lenders = lenders;
    }
}
