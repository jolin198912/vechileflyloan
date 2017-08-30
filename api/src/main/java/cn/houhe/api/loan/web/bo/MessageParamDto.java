package cn.houhe.api.loan.web.bo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by victorrrr on 2017/5/11.
 */
public class MessageParamDto {

    private Date date;
    private BigDecimal amount;
    private String cardno;
    private Integer days;
    private BigDecimal realamount;
    private BigDecimal late_fee;
    private BigDecimal interest;
    private BigDecimal penalty;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public BigDecimal getRealamount() {
        return realamount;
    }

    public void setRealamount(BigDecimal realamount) {
        this.realamount = realamount;
    }

    public BigDecimal getLate_fee() {
        return late_fee;
    }

    public void setLate_fee(BigDecimal late_fee) {
        this.late_fee = late_fee;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getPenalty() {
        return penalty;
    }

    public void setPenalty(BigDecimal penalty) {
        this.penalty = penalty;
    }
}
