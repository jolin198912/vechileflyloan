package cn.houhe.api.loan.entity.bo;

import cn.houhe.api.loan.entity.LoanContract;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by think on 2017/4/12.
 */
public class LoanRecordInfoAPP {
    /** loan_id -- id 主键 */
    private Integer loanId;

    /** loan_limit -- 贷款额度 */
    private BigDecimal loanLimit;

    //剩余本金
    private BigDecimal lastPrincipal;

    @JsonFormat(pattern = "yyyy-MM-dd")
    /** start_time -- 开始时间 */
    private Date starttime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    /** start_time -- 结束时间 */
    private Date endtime;

    /** apply_state -- 审核状态（1填写完资料审批中2初审通过3初审不通过4终审通过5终审不通过6自动审批通过7自动审批不通过） */
    private Byte applyState;

    //还款状态：0，未还完，1按计划还清，2提前还清
    private Byte repayState;

    //打款状态（0待打款，1已打款，2打款中，3打款失败）
    private Byte payStatus;

    //贷款期限类型（0日，1月）
    private Byte loanType;

    //贷款天数或者月数（如：贷款3个月）
    private Short time;

    //还款日
    private Integer bill_day;

    //综合利率
    private BigDecimal rate;

    /**
     * 收款银行卡号
     */
    private String  bankcardno;

    /**
     * 收款银行
     */
    private String  bank;

    //是否可提前还款（0否，1是）
    private int isAdvancePay;

    private  String bankUserName;

    //合同
    private List<LoanContract> contracts;

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

    public BigDecimal getLastPrincipal() {
        return lastPrincipal;
    }

    public void setLastPrincipal(BigDecimal lastPrincipal) {
        this.lastPrincipal = lastPrincipal;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Byte getApplyState() {
        return applyState;
    }

    public void setApplyState(Byte applyState) {
        this.applyState = applyState;
    }

    public String getBankcardno() {
        return bankcardno;
    }

    public void setBankcardno(String bankcardno) {
        this.bankcardno = bankcardno;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Byte getRepayState() {
        return repayState;
    }

    public void setRepayState(Byte repayState) {
        this.repayState = repayState;
    }

    public Byte getLoanType() {
        return loanType;
    }

    public void setLoanType(Byte loanType) {
        this.loanType = loanType;
    }

    public Short getTime() {
        return time;
    }

    public void setTime(Short time) {
        this.time = time;
    }

    public Integer getBill_day() {
        return bill_day;
    }

    public void setBill_day(Integer bill_day) {
        this.bill_day = bill_day;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getBankUserName() {
        return bankUserName;
    }

    public void setBankUserName(String bankUserName) {
        this.bankUserName = bankUserName;
    }

    public int getIsAdvancePay() {
        return isAdvancePay;
    }

    public void setIsAdvancePay(int isAdvancePay) {
        this.isAdvancePay = isAdvancePay;
    }

    public List<LoanContract> getContracts() {
        return contracts;
    }

    public void setContracts(List<LoanContract> contracts) {
        this.contracts = contracts;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Byte getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Byte payStatus) {
        this.payStatus = payStatus;
    }
}
