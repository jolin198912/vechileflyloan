package cn.houhe.api.loan.entity.bo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/24.
 */
public class RepaymentDto {
    public int rpt_id;
    public  int loan_record_id;
    public int member_id;
    public String username;
    public String user_mobile;
    public BigDecimal total_pay;
    //@JsonFormat(pattern = "yyyy-MM-dd")
    public Date pay_date;
    public  Short delay_days;
    public  BigDecimal late_fee;
    public  BigDecimal remind_fee;
    public  BigDecimal real_total_pay;
    //@JsonFormat(pattern = "yyyy-MM-dd")
    public Date real_pay_date;
    //@JsonFormat(pattern = "yyyy-MM-dd")
    public Date bad_day;
    public  String remainder;
    public  Date createdon;
    public String loan_number;
    public BigDecimal real_pay;
    public Integer current_term;

    public Integer getCurrent_term() {
        return current_term;
    }

    public void setCurrent_term(Integer current_term) {
        this.current_term = current_term;
    }

    public BigDecimal getReal_pay() {
        return real_pay;
    }

    public void setReal_pay(BigDecimal real_pay) {
        this.real_pay = real_pay;
    }

    public Date getReal_pay_date() {
        return real_pay_date;
    }

    public void setReal_pay_date(Date real_pay_date) {
        this.real_pay_date = real_pay_date;
    }

    public Date getBad_day() {
        return bad_day;
    }

    public void setBad_day(Date bad_day) {
        this.bad_day = bad_day;
    }

    public String getLoan_number() {
        return loan_number;
    }

    public void setLoan_number(String loan_number) {
        this.loan_number = loan_number;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public int getRpt_id() {
        return rpt_id;
    }

    public void setRpt_id(int rpt_id) {
        this.rpt_id = rpt_id;
    }

    public int getLoan_record_id() {
        return loan_record_id;
    }

    public void setLoan_record_id(int loan_record_id) {
        this.loan_record_id = loan_record_id;
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

    public BigDecimal getRemind_fee() {
        return remind_fee;
    }

    public void setRemind_fee(BigDecimal remind_fee) {
        this.remind_fee = remind_fee;
    }

    public BigDecimal getReal_total_pay() {
        return real_total_pay;
    }

    public void setReal_total_pay(BigDecimal real_total_pay) {
        this.real_total_pay = real_total_pay;
    }

    public String getRemainder() {
        return remainder;
    }

    public void setRemainder(String remainder) {
        this.remainder = remainder;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }
}
