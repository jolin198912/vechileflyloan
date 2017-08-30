package cn.houhe.api.loan.web.bo;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/5/6.
 */
public class AdvancePayDto {
    //贷款id
    private Integer loanId;
    //会员id
    private   Integer memid;
    //银行卡号
    private String bankcardno;
    //银行名称
    private String bank;
    //持卡人姓名
    private String bankusername;
    //会员手机
    private String mobile;
    //逾期罚金
    private BigDecimal fine;
    //提前还款违约金
    private BigDecimal advancefee;
    //扣款总额
    private BigDecimal total;
    //利息
    private  BigDecimal inverst;

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public Integer getMemid() {
        return memid;
    }

    public void setMemid(Integer memid) {
        this.memid = memid;
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

    public String getBankusername() {
        return bankusername;
    }

    public void setBankusername(String bankusername) {
        this.bankusername = bankusername;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public BigDecimal getFine() {
        return fine;
    }

    public void setFine(BigDecimal fine) {
        this.fine = fine;
    }

    public BigDecimal getAdvancefee() {
        return advancefee;
    }

    public void setAdvancefee(BigDecimal advancefee) {
        this.advancefee = advancefee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getInverst() {
        return inverst;
    }

    public void setInverst(BigDecimal inverst) {
        this.inverst = inverst;
    }
}
