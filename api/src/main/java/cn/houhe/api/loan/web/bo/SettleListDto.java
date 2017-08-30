package cn.houhe.api.loan.web.bo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/27.
 */
public class SettleListDto {
    //合同编号
    private String loanNo;
    //客户姓名
    private String username;
    //结清开始时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date stratPayDate;
    //结清结束时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endPayDate;
    //结清方式
    private byte repayType;
    public Integer page = 1;
    public Integer rows = 10;

    public String getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public byte getRepayType() {
        return repayType;
    }

    public void setRepayType(byte repayType) {
        this.repayType = repayType;
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
