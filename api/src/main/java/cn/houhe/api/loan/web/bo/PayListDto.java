package cn.houhe.api.loan.web.bo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/27.
 */
public class PayListDto {
    //支付平台
    private byte payplatform;
    //订单状态
    private byte orderstatus;
    //打款开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stratPayDate;
    //打款结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endPayDate;
    public Integer page = 1;
    public Integer rows = 10;

    public byte getPayplatform() {
        return payplatform;
    }

    public void setPayplatform(byte payplatform) {
        this.payplatform = payplatform;
    }

    public byte getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(byte orderstatus) {
        this.orderstatus = orderstatus;
    }

    public Date getStratPayDate() {
        return stratPayDate;
    }

    public void setStratPayDate(Date stratPayDate) {
        this.stratPayDate = stratPayDate;
    }

    public Date getEndPayDate() {
        return endPayDate;
    }

    public void setEndPayDate(Date endPayDate) {
        this.endPayDate = endPayDate;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
