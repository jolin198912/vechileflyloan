package cn.houhe.api.loan.entity.bo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**实收账单实体
 * Created by Administrator on 2017/4/27.
 */
public class PaidListObject {
    private Integer loan_id;
    //合同编号
    private String loan_number;
    //客户姓名
    private String username;
    //客户贷款情况0新增客户1结清再贷2增贷
    private byte mem_situation_type;
    //借款日期
    //@JsonFormat(pattern = "yyyy-MM-dd")
    private Date start_time;
    //合同到期日
    //@JsonFormat(pattern = "yyyy-MM-dd")
    private Date end_time;
    //借款金额
    private BigDecimal loan_limit;
    //综合利率
    private BigDecimal rate;
    //贷款期限
    private Integer time;
    //贷款期限类型（0日，1月）
    private byte loan_type;
    //还款状态：0，未还完，1按计划还清，2提前还清
    private  byte repay_state;
    //应收本金
    //private BigDecimal principal;
    //应收利息
    private BigDecimal interest;
    //实收本金
    private BigDecimal principalPayable;
    //实收利息
    private BigDecimal interestPayable;
    //额度管理费
    private BigDecimal quota_manage_fee;
    //提现费用
    private BigDecimal withdrawals_fee;
    //提前还款费用
    private BigDecimal advance_repay_fee;
    //逾期天数
    private Integer delay_days;
    //应收逾期费用
    private BigDecimal late_fee;
    //应收催收费用
    private BigDecimal remind_fee;
    //实收逾期费用
    private BigDecimal late_fee_payable;
    //实收催收费用
    private BigDecimal remind_fee_payable;
    //应收合计
    private BigDecimal total_receivable;
    //实收合计
    private BigDecimal total_payable;
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

    public byte getMem_situation_type() {
        return mem_situation_type;
    }

    public void setMem_situation_type(byte mem_situation_type) {
        this.mem_situation_type = mem_situation_type;
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

    public byte getRepay_state() {
        return repay_state;
    }

    public void setRepay_state(byte repay_state) {
        this.repay_state = repay_state;
    }

//    public BigDecimal getPrincipal() {
//        return principal;
//    }
//
//    public void setPrincipal(BigDecimal principal) {
//        this.principal = principal;
//    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getPrincipalPayable() {
        return principalPayable;
    }

    public void setPrincipalPayable(BigDecimal principalPayable) {
        this.principalPayable = principalPayable;
    }

    public BigDecimal getInterestPayable() {
        return interestPayable;
    }

    public void setInterestPayable(BigDecimal interestPayable) {
        this.interestPayable = interestPayable;
    }

    public BigDecimal getQuota_manage_fee() {
        return quota_manage_fee;
    }

    public void setQuota_manage_fee(BigDecimal quota_manage_fee) {
        this.quota_manage_fee = quota_manage_fee;
    }

    public BigDecimal getWithdrawals_fee() {
        return withdrawals_fee;
    }

    public void setWithdrawals_fee(BigDecimal withdrawals_fee) {
        this.withdrawals_fee = withdrawals_fee;
    }

    public BigDecimal getAdvance_repay_fee() {
        return advance_repay_fee;
    }

    public void setAdvance_repay_fee(BigDecimal advance_repay_fee) {
        this.advance_repay_fee = advance_repay_fee;
    }

    public Integer getDelay_days() {
        return delay_days;
    }

    public void setDelay_days(Integer delay_days) {
        this.delay_days = delay_days;
    }

    public BigDecimal getLate_fee() {
        return late_fee;
    }

    public void setLate_fee(BigDecimal late_fee) {
        this.late_fee = late_fee;
    }

    public BigDecimal getRemind_fee() {
        return remind_fee;
    }

    public void setRemind_fee(BigDecimal remind_fee) {
        this.remind_fee = remind_fee;
    }

    public BigDecimal getLate_fee_payable() {
        return late_fee_payable;
    }

    public void setLate_fee_payable(BigDecimal late_fee_payable) {
        this.late_fee_payable = late_fee_payable;
    }

    public BigDecimal getRemind_fee_payable() {
        return remind_fee_payable;
    }

    public void setRemind_fee_payable(BigDecimal remind_fee_payable) {
        this.remind_fee_payable = remind_fee_payable;
    }

    public BigDecimal getTotal_receivable() {
        return total_receivable;
    }

    public void setTotal_receivable(BigDecimal total_receivable) {
        this.total_receivable = total_receivable;
    }

    public BigDecimal getTotal_payable() {
        return total_payable;
    }

    public void setTotal_payable(BigDecimal total_payable) {
        this.total_payable = total_payable;
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
}
