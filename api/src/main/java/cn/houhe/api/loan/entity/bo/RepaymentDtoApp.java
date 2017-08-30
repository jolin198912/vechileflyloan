package cn.houhe.api.loan.entity.bo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/24.
 */
public class RepaymentDtoApp {
    private Integer rpt_id;
    //贷款id
    private Integer loan_record_id;
    //还款日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date payDate;
    //应还总额
    private BigDecimal realTotalPay;
    //应还本金
    private BigDecimal principal;
    //利息
    private BigDecimal interest;
    //逾期天数
    private Integer delayDays;
    //扣款银行卡号
    private String bankCardno;
    //扣款银行
    private  String bank;
    //收款状态
    private byte gather_status;

    public Integer getRpt_id() {
        return rpt_id;
    }

    public void setRpt_id(Integer rpt_id) {
        this.rpt_id = rpt_id;
    }

    public Integer getLoan_record_id() {
        return loan_record_id;
    }

    public void setLoan_record_id(Integer loan_record_id) {
        this.loan_record_id = loan_record_id;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public BigDecimal getRealTotalPay() {
        return realTotalPay;
    }

    public void setRealTotalPay(BigDecimal realTotalPay) {
        this.realTotalPay = realTotalPay;
    }

    public Integer getDelayDays() {
        return delayDays;
    }

    public void setDelayDays(Integer delayDays) {
        this.delayDays = delayDays;
    }

    public String getBankCardno() {
        return bankCardno;
    }

    public void setBankCardno(String bankCardno) {
        this.bankCardno = bankCardno;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
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

    public byte getGather_status() {
        return gather_status;
    }
    public void setGather_status(byte gather_status) {
        this.gather_status = gather_status;
    }
}
