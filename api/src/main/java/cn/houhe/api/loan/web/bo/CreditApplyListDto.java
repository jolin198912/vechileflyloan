package cn.houhe.api.loan.web.bo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by think on 2017/4/10.
 */
public class CreditApplyListDto {

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
     * 申请开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date start;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")

    /**
     * 申请结束时间
     */
    private Date end;


    /**
     * 审批开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date astart;

    /**
     * 审批结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date aend;
    /**
     * 通过状态(0，1，2)
     */
    private Integer state;

    public Date getAstart() {
        return astart;
    }

    public void setAstart(Date astart) {
        this.astart = astart;
    }

    public Date getAend() {
        return aend;
    }

    public void setAend(Date aend) {
        this.aend = aend;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
}
