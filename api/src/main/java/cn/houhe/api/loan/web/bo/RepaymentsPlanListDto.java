package cn.houhe.api.loan.web.bo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/6.
 */
public class RepaymentsPlanListDto {
    /** rpt_id -- 主键 */
    private Integer rptId;
    /** loan_record_id -- 贷款id */
    private Integer loanRecordId;
    /** member_id -- 用户id */
    private Integer memberId;
    /** repay_bank_cardno -- 还款银行卡号 */
    private String repayBankCardNo;
    /*还款编号*/
    private String repay_number;
    /** repay_bank -- 还款银行名称 */
    private String repayBank;
    /** repay_name -- 持卡人姓名 */
    private String repayName;
    /** user_mobile -- 贷款人手机 */
    private String userMobile;
    /** late_fee -- 罚息 */
    private BigDecimal lateFee;
    /** interest -- 本期利息 */
    private BigDecimal interest;
    /** real_total_pay -- 本期实际应还总额 */
    private BigDecimal realTotalPay;
    /** pay_date -- 应还款日期 */
    private Date payDate;
    /** currentTerm 当前期数*/
    private  String currentTerm;


    public Integer getRptId() {
        return rptId;
    }

    public void setRptId(Integer rptId) {
        this.rptId = rptId;
    }

    public Integer getLoanRecordId() {
        return loanRecordId;
    }

    public void setLoanRecordId(Integer loanRecordId) {
        this.loanRecordId = loanRecordId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getRepayBankCardNo() {
        return repayBankCardNo;
    }

    public void setRepayBankCardNo(String repayBankCardNo) {
        this.repayBankCardNo = repayBankCardNo;
    }

    public String getRepayBank() {
        return repayBank;
    }

    public void setRepayBank(String repayBank) {
        this.repayBank = repayBank;
    }

    public String getRepayName() {
        return repayName;
    }

    public void setRepayName(String repayName) {
        this.repayName = repayName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public BigDecimal getLateFee() {
        return lateFee;
    }

    public void setLateFee(BigDecimal lateFee) {
        this.lateFee = lateFee;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getRealTotalPay() {
        return realTotalPay;
    }

    public void setRealTotalPay(BigDecimal realTotalPay) {
        this.realTotalPay = realTotalPay;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getRepay_number() {
        return repay_number;
    }

    public void setRepay_number(String repay_number) {
        this.repay_number = repay_number;
    }

    public String getCurrentTerm() {
        return currentTerm;
    }

    public void setCurrentTerm(String currentTerm) {
        this.currentTerm = currentTerm;
    }
}
