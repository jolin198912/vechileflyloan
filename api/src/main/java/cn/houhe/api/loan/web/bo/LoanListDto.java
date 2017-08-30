package cn.houhe.api.loan.web.bo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by think on 2017/4/12.
 */
public class LoanListDto {

    private int page =1;
    private int rows = 10;

    /**
     * 审核人员id
     */
    private Integer apid;

    /**
     * 申请人名称
     */
    private String name;

    /**
     * 客户情况
     */
    private Byte memtype;

    /**
     * 审批开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date start;

    /**
     * 审批结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date end;

    /**
     * 通过状态(0，1，2，3)
     */
    private Integer state;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public Integer getApid() {
        return apid;
    }

    public void setApid(Integer apid) {
        this.apid = apid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    public Byte getMemtype() {
        return memtype;
    }

    public void setMemtype(Byte memtype) {
        this.memtype = memtype;
    }
}
