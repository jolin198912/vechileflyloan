package cn.houhe.api.loan.web.bo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/26.
 */
public class RemainderNoDivDto {
    public String username;
    public String user_mobile;
    public BigDecimal total_pay;//逾期金额
    public Date pay_date;
    public  Short delay_days;
    public  BigDecimal late_fee;
    public  BigDecimal real_total_pay;
    public RemainderNoDivDto(String username, String user_mobile, BigDecimal total_pay, Date pay_date, Short delay_days, BigDecimal late_fee,   BigDecimal real_total_pay)
    {
        this.username = username;
        this.user_mobile = user_mobile;
        this.total_pay = total_pay;
        this.pay_date = pay_date;
        this.delay_days = delay_days;
        this.late_fee = late_fee;
        this.real_total_pay=real_total_pay;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_mobile() {
        return user_mobile;
    }

    public void setUser_mobile(String user_mobile) {
        this.user_mobile = user_mobile;
    }

    public BigDecimal getTotal_pay() {
        return total_pay;
    }

    public void setTotal_pay(BigDecimal total_pay) {
        this.total_pay = total_pay;
    }

    public Date getPay_date() {
        return pay_date;
    }

    public void setPay_date(Date pay_date) {
        this.pay_date = pay_date;
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

    public BigDecimal getReal_total_pay() {
        return real_total_pay;
    }

    public void setReal_total_pay(BigDecimal real_total_pay) {
        this.real_total_pay = real_total_pay;
    }
}
