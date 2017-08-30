package cn.houhe.api.loan.entity.bo;

import java.math.BigDecimal;

/**应收账单实体
 * Created by Administrator on 2017/5/2.
 */
public class ReceivableListObject {
    //合同主键
    private Integer loan_id;
    //合同编号
    private String loan_number;
    //还款日
    private int bill_day;
    //客户姓名
    private String username;
    //客户贷款情况0新增客户1结清再贷2增贷
    private byte mem_situation_type;
    //借款金额
    private BigDecimal loan_limit;
    //贷款综合利率
    private  BigDecimal rate;
    //贷款期限
    private Integer time;
    //贷款期限类型（0日，1月）
    private byte loan_type;
    //逾期天数
    private Integer delayDays;
    //应还本金
    //private BigDecimal principalPayable;
    //应还利息
    private BigDecimal interestPayable;
    //提现费用
    private  BigDecimal withdrawals_fee;
    //逾期罚金
    private  BigDecimal late_fee;
    //催收费
    private BigDecimal remind_fee;
    //应收提前还款违约金
    private  BigDecimal advance_repay_fee;
    //应收合计
    private  BigDecimal receivableTotal;
    //上月剩余本金
    private  BigDecimal lastPrincipal;
    //本月剩余本金
    private  BigDecimal currentPrincipal;
    //还款状态：0，未还完，1按计划还清，2提前还清
    private byte repay_state;
    //额度管理费
    private BigDecimal quota_manage_fee;
    //现金分期利率
    private BigDecimal fq_rate;
    //放款手续费率
    private BigDecimal fq_loan_pay_rate;
    //账号管理费率
    private BigDecimal fq_account_manage_rate;
    //咨询服务费率
    private BigDecimal fq_consultation_rate;

    public Integer getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(Integer loan_id) {
        this.loan_id = loan_id;
    }

    public byte getRepay_state() {
        return repay_state;
    }

    public void setRepay_state(byte repay_state) {
        this.repay_state = repay_state;
    }

    public String getLoan_number() {
        return loan_number;
    }

    public void setLoan_number(String loan_number) {
        this.loan_number = loan_number;
    }

    public int getBill_day() {
        return bill_day;
    }

    public void setBill_day(int bill_day) {
        this.bill_day = bill_day;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getRemind_fee() {
        return remind_fee;
    }

    public void setRemind_fee(BigDecimal remind_fee) {
        this.remind_fee = remind_fee;
    }

    public byte getMem_situation_type() {
        return mem_situation_type;
    }

    public void setMem_situation_type(byte mem_situation_type) {
        this.mem_situation_type = mem_situation_type;
    }

    public BigDecimal getLoan_limit() {
        return loan_limit;
    }

    public void setLoan_limit(BigDecimal loan_limit) {
        this.loan_limit = loan_limit;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public byte getLoan_type() {
        return loan_type;
    }

    public void setLoan_type(byte loan_type) {
        this.loan_type = loan_type;
    }

    public Integer getDelayDays() {
        return delayDays;
    }

    public void setDelayDays(Integer delayDays) {
        this.delayDays = delayDays;
    }

    public BigDecimal getInterestPayable() {
        return interestPayable;
    }

    public void setInterestPayable(BigDecimal interestPayable) {
        this.interestPayable = interestPayable;
    }

    public BigDecimal getWithdrawals_fee() {
        return withdrawals_fee;
    }

    public void setWithdrawals_fee(BigDecimal withdrawals_fee) {
        this.withdrawals_fee = withdrawals_fee;
    }

    public BigDecimal getLate_fee() {
        return late_fee;
    }

    public void setLate_fee(BigDecimal late_fee) {
        this.late_fee = late_fee;
    }

    public BigDecimal getAdvance_repay_fee() {
        return advance_repay_fee;
    }

    public void setAdvance_repay_fee(BigDecimal advance_repay_fee) {
        this.advance_repay_fee = advance_repay_fee;
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

    public BigDecimal getQuota_manage_fee() {
        return quota_manage_fee;
    }

    public void setQuota_manage_fee(BigDecimal quota_manage_fee) {
        this.quota_manage_fee = quota_manage_fee;
    }

    public BigDecimal getFq_rate() {
        return fq_rate;
    }

    public void setFq_rate(BigDecimal fq_rate) {
        this.fq_rate = fq_rate;
    }

    public BigDecimal getFq_loan_pay_rate() {
        return fq_loan_pay_rate;
    }

    public void setFq_loan_pay_rate(BigDecimal fq_loan_pay_rate) {
        this.fq_loan_pay_rate = fq_loan_pay_rate;
    }

    public BigDecimal getFq_account_manage_rate() {
        return fq_account_manage_rate;
    }

    public void setFq_account_manage_rate(BigDecimal fq_account_manage_rate) {
        this.fq_account_manage_rate = fq_account_manage_rate;
    }

    public BigDecimal getFq_consultation_rate() {
        return fq_consultation_rate;
    }

    public void setFq_consultation_rate(BigDecimal fq_consultation_rate) {
        this.fq_consultation_rate = fq_consultation_rate;
    }

    public BigDecimal getReceivableTotal() {
        return receivableTotal;
    }

    public void setReceivableTotal(BigDecimal receivableTotal) {
        this.receivableTotal = receivableTotal;
    }
}
