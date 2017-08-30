package cn.houhe.api.loan.web.bo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/2.
 */
public class PaidListExcelDto {
    //合同编号
    public String loan_number;
    //客户姓名
    public String username;
    //客户贷款情况0新增客户1结清再贷2增贷
    public String memSituation;
    //借款日期
    public Date start_time;
    //合同到期日
    public Date end_time;
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
    //实收合计
    public BigDecimal payableTotal;
    //剩余合计
    public BigDecimal lastTotal;
    //合同出借人
    public String lenders;

    public PaidListExcelDto()
    {
    }

    public PaidListExcelDto(String loan_number, String username, String memSituation, Date start_time, Date end_time, BigDecimal loan_limit, String rate, String time, Integer delayDays, BigDecimal receivableTotal, BigDecimal payableTotal, BigDecimal lastTotal)
    {
        this.loan_number = loan_number;
        this.username = username;
        this.memSituation = memSituation;
        this.start_time = start_time;
        this.end_time = end_time;
        this.loan_limit = loan_limit;
        this.rate = rate;
        this.time = time;
        this.delayDays = delayDays;
        this.receivableTotal = receivableTotal;
        this.payableTotal = payableTotal;
        this.lastTotal = lastTotal;
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

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
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

    public BigDecimal getPayableTotal() {
        return payableTotal;
    }

    public void setPayableTotal(BigDecimal payableTotal) {
        this.payableTotal = payableTotal;
    }

    public BigDecimal getLastTotal() {
        return lastTotal;
    }

    public void setLastTotal(BigDecimal lastTotal) {
        this.lastTotal = lastTotal;
    }

    public String getLenders() {
        return lenders;
    }

    public void setLenders(String lenders) {
        this.lenders = lenders;
    }
}
