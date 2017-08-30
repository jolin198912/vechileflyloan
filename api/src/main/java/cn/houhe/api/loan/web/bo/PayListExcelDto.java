package cn.houhe.api.loan.web.bo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/27.
 */
public class PayListExcelDto {
    //订单号
    private String number;
    //姓名
    private String username;
    //手机号
    private String user_mobile;
    //贷款金额
    private BigDecimal loan_limit;
    //放款金额
    private BigDecimal amount;
    //支付平台
    private String pay_platform;
    //打款时间
    private Date paytime;
    //扣款状态0待还款1成功2失败
    private String status;

    public PayListExcelDto()
    {
    }

    public PayListExcelDto(String number, String username, String user_mobile, BigDecimal loan_limit, BigDecimal amount, String pay_platform, Date paytime, String status)
    {
        this.number = number;
        this.username = username;
        this.user_mobile = user_mobile;
        this.loan_limit = loan_limit;
        this.amount = amount;
        this.pay_platform = pay_platform;
        this.paytime= paytime;
        this.status = status;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public BigDecimal getLoan_limit() {
        return loan_limit;
    }

    public void setLoan_limit(BigDecimal loan_limit) {
        this.loan_limit = loan_limit;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPay_platform() {
        return pay_platform;
    }

    public void setPay_platform(String pay_platform) {
        this.pay_platform = pay_platform;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
