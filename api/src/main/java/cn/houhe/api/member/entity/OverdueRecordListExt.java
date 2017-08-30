package cn.houhe.api.member.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/20.
 */
public class OverdueRecordListExt {
    /** memid -- 用户id */
    private Integer memId;
    /** rpt_id -- 主键 */
    private Integer rptId;
    /** loan_limit -- 贷款额度 */
    private BigDecimal loanLimit;
    /** loan_type -- 产品类型 */
    private Byte loanType;
    /** time -- 贷款天数或者月数（如：贷款3个月） */
    private Short stagingTime;
    /** start_time -- 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    /** end_time -- 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
    /** total_pay -- 本期应还总额（最初生成的还款计划的应还总额） */
    private BigDecimal totalPay;
    /** current_term -- 当前期数（1代表第一期） */
    private Short currentTerm;
    /** pay_date -- 应还款日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date payDate;
    /** delay_days -- 逾期天数 */
    private Short delayDays;
    /** late_fee -- 逾期罚金 */
    private BigDecimal lateFee;
    /** remind_fee -- 催收费 */
    private BigDecimal remindFee;
    /** real_pay -- 实际偿还金额 */
    private BigDecimal realPay;
    /** real_pay_date -- 实还款日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date realPayDate;
    /** status -- 还款状态(0一分未还1部分还款2正常还清3逾期还清4提前还款) */
    private Byte status;

    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    public Integer getRptId() {
        return rptId;
    }

    public void setRptId(Integer rptId) {
        this.rptId = rptId;
    }

    public BigDecimal getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(BigDecimal loanLimit) {
        this.loanLimit = loanLimit;
    }

    public Byte getLoanType() {
        return loanType;
    }

    public void setLoanType(Byte loanType) {
        this.loanType = loanType;
    }

    public Short getStagingTime() {
        return stagingTime;
    }

    public void setStagingTime(Short stagingTime) {
        this.stagingTime = stagingTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(BigDecimal totalPay) {
        this.totalPay = totalPay;
    }

    public Short getCurrentTerm() {
        return currentTerm;
    }

    public void setCurrentTerm(Short currentTerm) {
        this.currentTerm = currentTerm;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Short getDelayDays() {
        return delayDays;
    }

    public void setDelayDays(Short delayDays) {
        this.delayDays = delayDays;
    }

    public BigDecimal getLateFee() {
        return lateFee;
    }

    public void setLateFee(BigDecimal lateFee) {
        this.lateFee = lateFee;
    }

    public BigDecimal getRemindFee() {
        return remindFee;
    }

    public void setRemindFee(BigDecimal remindFee) {
        this.remindFee = remindFee;
    }

    public BigDecimal getRealPay() {
        return realPay;
    }

    public void setRealPay(BigDecimal realPay) {
        this.realPay = realPay;
    }

    public Date getRealPayDate() {
        return realPayDate;
    }

    public void setRealPayDate(Date realPayDate) {
        this.realPayDate = realPayDate;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OverdueRecordListExt{" +
                "memId=" + memId +
                ", rptId=" + rptId +
                ", loanLimit=" + loanLimit +
                ", loanType=" + loanType +
                ", stagingTime=" + stagingTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", totalPay=" + totalPay +
                ", currentTerm=" + currentTerm +
                ", payDate=" + payDate +
                ", delayDays=" + delayDays +
                ", lateFee=" + lateFee +
                ", remindFee=" + remindFee +
                ", realPay=" + realPay +
                ", realPayDate=" + realPayDate +
                ", status=" + status +
                '}';
    }
}
