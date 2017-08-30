package cn.houhe.api.loan.entity.bo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by think on 2017/4/12.
 */
public class LoanList {

    /** loan_id -- id 主键 */
    private Integer loanId;

    /** user_mobile -- 贷款人手机 */
    private String mobile;

    /** username -- 贷款人姓名 */
    private String name;

    /** apply_time -- 申请时间 */
    private Date applyTime;

    /** apply_state -- 审核状态（1填写完资料审批中2初审通过3初审不通过4终审通过5终审不通过6自动审批通过7自动审批不通过） */
    private Byte applyState;

    /** loan_limit -- 贷款额度 */
    private BigDecimal loanLimit;

    /**--客户贷款情况0新增客户1结清再贷2增贷*/
    private  Byte memSituationType;

    /** loan_limit_total -- 授信额度 */
    private Integer loanLimitTotal;
    /*逾期次数*/
    private Integer delayCount;

    public Integer getDelayCount() {
        return delayCount;
    }

    public void setDelayCount(Integer delayCount) {
        this.delayCount = delayCount;
    }

    /**
     * 初审人
     */
    private String fap;
    /**
     * 终审人
     */
    private String sap;

    //初审时间
    private Date fapTime;

    //终审时间
    private Date sapTime;

    private BigDecimal amount;

    private String payPlat;

    /** status -- 打款状态0待打款1成功2失败 */
    private Byte status;

    /** paytime -- 打款时间 */
    private Date paytime;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPayPlat() {
        return payPlat;
    }

    public void setPayPlat(String payPlat) {
        this.payPlat = payPlat;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Byte getApplyState() {
        return applyState;
    }

    public void setApplyState(Byte applyState) {
        this.applyState = applyState;
    }

    public BigDecimal getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(BigDecimal loanLimit) {
        this.loanLimit = loanLimit;
    }

    public Integer getLoanLimitTotal() {
        return loanLimitTotal;
    }

    public void setLoanLimitTotal(Integer loanLimitTotal) {
        this.loanLimitTotal = loanLimitTotal;
    }

    public String getFap() {
        return fap;
    }

    public void setFap(String fap) {
        this.fap = fap;
    }

    public String getSap() {
        return sap;
    }

    public void setSap(String sap) {
        this.sap = sap;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }
    public Byte getMemSituationType() {
        return memSituationType;
    }

    public void setMemSituationType(Byte memSituationType) {
        this.memSituationType = memSituationType;
    }

    public Date getFapTime() {
        return fapTime;
    }

    public void setFapTime(Date fapTime) {
        this.fapTime = fapTime;
    }

    public Date getSapTime() {
        return sapTime;
    }

    public void setSapTime(Date sapTime) {
        this.sapTime = sapTime;
    }
}
