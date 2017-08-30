package cn.houhe.api.member.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/19.
 */
public class DebitRecordListExt {
    /** memid -- 用户id */
    private Integer memId;
    /** loan_number -- 合同编号 */
    private String loanNumber;
    /** loan_limit -- 借款金额 */
    private BigDecimal loanLimit;
    /** plan_pay_time -- 应还款日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date planPayTime;
    /** createdon -- 实际还款日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdon;
    /** repay_type -- 还款类型0自动还款1提前还款2逾期还款 */
    private Byte repayType;
    /** loan_type -- 产品类型 */
    private Byte loanType;
    /** time -- 贷款天数或者月数（如：贷款3个月） */
    private Short stagingTimes;
    /** current_term -- 当前期数（1代表第一期） */
    private Short currentTerm;
    /** principal -- 本金 */
    private BigDecimal principal;
    /** interest -- 利息 */
    private BigDecimal interest;
    /** delay_days -- 逾期天数 */
    private Short delayDays;
    /** late_fee -- 逾期罚金 */
    private BigDecimal lateFee;
    /** liquidated_damages -- 提前还款的违约金（手续费） */
    private BigDecimal liquidatedDamages;
    /** real_pay -- 实际偿还金额 */
    private BigDecimal realPay;

    private int page;
    private int rows;

    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    public String getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
    }

    public BigDecimal getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(BigDecimal loanLimit) {
        this.loanLimit = loanLimit;
    }

    public Date getPlanPayTime() {
        return planPayTime;
    }

    public void setPlanPayTime(Date planPayTime) {
        this.planPayTime = planPayTime;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    public Byte getRepayType() {
        return repayType;
    }

    public void setRepayType(Byte repayType) {
        this.repayType = repayType;
    }

    public Byte getLoanType() {
        return loanType;
    }

    public void setLoanType(Byte loanType) {
        this.loanType = loanType;
    }

    public Short getStagingTimes() {
        return stagingTimes;
    }

    public void setStagingTimes(Short stagingTimes) {
        this.stagingTimes = stagingTimes;
    }

    public Short getCurrentTerm() {
        return currentTerm;
    }

    public void setCurrentTerm(Short currentTerm) {
        this.currentTerm = currentTerm;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
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

    public BigDecimal getLiquidatedDamages() {
        return liquidatedDamages;
    }

    public void setLiquidatedDamages(BigDecimal liquidatedDamages) {
        this.liquidatedDamages = liquidatedDamages;
    }

    public BigDecimal getRealPay() {
        return realPay;
    }

    public void setRealPay(BigDecimal realPay) {
        this.realPay = realPay;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "DebitRecordListExt{" +
                "loanNumber='" + loanNumber + '\'' +
                ", loanLimit=" + loanLimit +
                ", loanType=" + loanType +
                ", stagingTimes=" + stagingTimes +
                ", currentTerm=" + currentTerm +
                ", principal=" + principal +
                ", delayDays=" + delayDays +
                ", lateFee=" + lateFee +
                ", liquidatedDamages=" + liquidatedDamages +
                ", realPay=" + realPay +
                ", page=" + page +
                ", rows=" + rows +
                '}';
    }
}
