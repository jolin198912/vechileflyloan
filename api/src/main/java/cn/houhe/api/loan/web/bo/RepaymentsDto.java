package cn.houhe.api.loan.web.bo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/24.
 */
public class RepaymentsDto {
    public Integer status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date paystart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date payend;
    public String name;
    public Integer memid;
    public Integer page;
    public Integer rows;
    public String contractNo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date realpayStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date realpayEnd;

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Date getRealpayStart() {
        return realpayStart;
    }

    public void setRealpayStart(Date realpayStart) {
        this.realpayStart = realpayStart;
    }

    public Date getRealpayEnd() {
        return realpayEnd;
    }

    public void setRealpayEnd(Date realpayEnd) {
        this.realpayEnd = realpayEnd;
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

    public Integer getMemid() {
        return memid;
    }

    public void setMemid(Integer memid) {
        this.memid = memid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getPaystart() {
        return paystart;
    }

    public void setPaystart(Date paystart) {
        this.paystart = paystart;
    }

    public Date getPayend() {
        return payend;
    }

    public void setPayend(Date payend) {
        this.payend = payend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
