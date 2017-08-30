package cn.houhe.api.member.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 */
public class LoanRecordListExt {
    /** memid -- 用户id */
    private Integer memId;
    /** loan_id -- 贷款记录id */
    private Integer loanId;
    /** loan_limit -- 贷款额度 */
    private BigDecimal loanLimit;
    /** loan_type -- 产品类型 */
    private Byte loanType;
    /** time -- 贷款天数或者月数（如：贷款3个月） */
    private Short stagingTime;
    /** start_time -- 开始时间 */
    private Date startTime;
    /** end_time -- 结束时间 */
    private Date endTime;
    /** rate -- 贷款利率(存最终值，如0.05%，存0.0005) */
    private BigDecimal rate;
    /** amount -- 打款金额 */
    private BigDecimal amount;
    /** paytime -- 打款时间 */
    private Date payTime;
    /** pay_platform -- 放款平台（微众银行等） */
    private String payPlatform;
    /** receive_bank -- 收款银行 */
    private String receiveBank;
    /** receive_bank_cardno -- 收款银行账号 */
    private String receiveBankCardNo;
    /** apply_time -- 申请时间 */
    private Date applyTime;
    /** contract_file_url -- 贷款合同 */
    private List<LoanContractExt> loanContractFileUrl;

    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
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

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getPayPlatform() {
        return payPlatform;
    }

    public void setPayPlatform(String payPlatform) {
        this.payPlatform = payPlatform;
    }

    public String getReceiveBank() {
        return receiveBank;
    }

    public void setReceiveBank(String receiveBank) {
        this.receiveBank = receiveBank;
    }

    public String getReceiveBankCardNo() {
        return receiveBankCardNo;
    }

    public void setReceiveBankCardNo(String receiveBankCardNo) {
        this.receiveBankCardNo = receiveBankCardNo;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public List<LoanContractExt> getLoanContractFileUrl() {
        return loanContractFileUrl;
    }

    public void setLoanContractFileUrl(List<LoanContractExt> loanContractFileUrl) {
        this.loanContractFileUrl = loanContractFileUrl;
    }

    @Override
    public String toString() {
        return "LoanRecordListExt{" +
                "loanLimit=" + loanLimit +
                ", loanType=" + loanType +
                ", stagingTime=" + stagingTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", rate=" + rate +
                ", amount=" + amount +
                ", payTime=" + payTime +
                ", payPlatform='" + payPlatform + '\'' +
                ", receiveBank='" + receiveBank + '\'' +
                ", receiveBankCardNo='" + receiveBankCardNo + '\'' +
                ", applyTime=" + applyTime +
                '}';
    }
}
