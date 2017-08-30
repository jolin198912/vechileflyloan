package cn.houhe.api.loan.entity.bo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**结清清单实体
 * Created by Administrator on 2017/4/27.
 */
public class SettleListObject {
    //合同编号
    private String loan_number;
    //客户姓名
    private String username;
    //客户贷款情况0新增客户1结清再贷2增贷
    private byte mem_situation_type;
    //借款日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date apply_time;
    //合同到期日
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date end_time;
    //结清日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date paytime;
    //借款金额
    private BigDecimal loan_limit;
    //综合利率
    private BigDecimal rate;
    //贷款期限
    private Integer time;
    //贷款期限类型（0日，1月）
    private byte loan_type;
    //还款结清类型0自动还款1提前还款2贷后强制结清
    private byte repay_type;
    //已收利息
    private BigDecimal total_interest;
    //放款手续费
    private BigDecimal loan_pay_fee;
    //融资服务费
    private BigDecimal financing_fee;
    //账号管理费
    private BigDecimal account_manage_fee;
    //咨询费
    private BigDecimal consultation_fee;
    //额度管理费
    private BigDecimal quota_manage_fee;
    //提现费用
    private BigDecimal withdrawals_fee;
    //提前还款费用
    private BigDecimal advance_repay_fee;
    //逾期天数
    private Integer delay_days;
    //逾期费用
    private BigDecimal late_fee;
    //催收费用
    private BigDecimal remind_fee;

    public BigDecimal getRemind_fee() {
        return remind_fee;
    }

    public void setRemind_fee(BigDecimal remind_fee) {
        this.remind_fee = remind_fee;
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

    public Date getApply_time() {
        return apply_time;
    }

    public void setApply_time(Date apply_time) {
        this.apply_time = apply_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
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

    public byte getRepay_type() {
        return repay_type;
    }

    public void setRepay_type(byte repay_type) {
        this.repay_type = repay_type;
    }

    public BigDecimal getTotal_interest() {
        return total_interest;
    }

    public void setTotal_interest(BigDecimal total_interest) {
        this.total_interest = total_interest;
    }

    public BigDecimal getLoan_pay_fee() {
        return loan_pay_fee;
    }

    public void setLoan_pay_fee(BigDecimal loan_pay_fee) {
        this.loan_pay_fee = loan_pay_fee;
    }

    public BigDecimal getFinancing_fee() {
        return financing_fee;
    }

    public void setFinancing_fee(BigDecimal financing_fee) {
        this.financing_fee = financing_fee;
    }

    public BigDecimal getAccount_manage_fee() {
        return account_manage_fee;
    }

    public void setAccount_manage_fee(BigDecimal account_manage_fee) {
        this.account_manage_fee = account_manage_fee;
    }

    public BigDecimal getConsultation_fee() {
        return consultation_fee;
    }

    public void setConsultation_fee(BigDecimal consultation_fee) {
        this.consultation_fee = consultation_fee;
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


}
