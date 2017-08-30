package cn.houhe.api.loan.entity.bo;

import java.math.BigDecimal;
import java.util.Date;

/**代付清单实体
 * Created by Administrator on 2017/4/28.
 */
public class PayListObject {
    //订单号
    private String number;
    //姓名
    private  String username;
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
    private byte status;

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

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}
