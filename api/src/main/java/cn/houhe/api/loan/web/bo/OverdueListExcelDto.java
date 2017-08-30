package cn.houhe.api.loan.web.bo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/26.
 */
public class OverdueListExcelDto {
    public String loan_number;
    public String username;
    public Date pay_date;
    public Date real_pay_date;
    public Integer current_term;
    public BigDecimal total_pay;
    public Short delay_days;
    public BigDecimal late_fee;
    public BigDecimal remind_fee;
    public BigDecimal real_pay;

    public OverdueListExcelDto()
    {
    }

    public OverdueListExcelDto(String loan_number, String username, Date pay_date, Date real_pay_date, Integer current_term, BigDecimal total_pay, Short delay_days, BigDecimal late_fee, BigDecimal remind_fee, BigDecimal real_pay)
    {
        this.loan_number = loan_number;
        this.username = username;
        this.pay_date = pay_date;
        this.real_pay_date = real_pay_date;
        this.current_term = current_term;
        this.total_pay = total_pay;
        this.delay_days = delay_days;
        this.late_fee = late_fee;
        this.remind_fee = remind_fee;
        this.real_pay = real_pay;
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

    public Date getPay_date() {
        return pay_date;
    }

    public void setPay_date(Date pay_date) {
        this.pay_date = pay_date;
    }

    public Date getReal_pay_date() {
        return real_pay_date;
    }

    public void setReal_pay_date(Date real_pay_date) {
        this.real_pay_date = real_pay_date;
    }

    public Integer getCurrent_term() {
        return current_term;
    }

    public void setCurrent_term(Integer current_term) {
        this.current_term = current_term;
    }

    public BigDecimal getTotal_pay() {
        return total_pay;
    }

    public void setTotal_pay(BigDecimal total_pay) {
        this.total_pay = total_pay;
    }

    public Short getDelay_days() {
        return delay_days;
    }

    public void setDelay_days(Short delay_days) {
        this.delay_days = delay_days;
    }

    public BigDecimal getLate_fee() {
        return late_fee;
    }

    public void setLate_fee(BigDecimal late_fee) {
        this.late_fee = late_fee;
    }

    public BigDecimal getRemind_fee() {
        return remind_fee;
    }

    public void setRemind_fee(BigDecimal remind_fee) {
        this.remind_fee = remind_fee;
    }

    public BigDecimal getReal_pay() {
        return real_pay;
    }

    public void setReal_pay(BigDecimal real_pay) {
        this.real_pay = real_pay;
    }
}
