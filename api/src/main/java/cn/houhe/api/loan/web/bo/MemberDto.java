package cn.houhe.api.loan.web.bo;

import java.util.Date;

/**
 * Created by Administrator on 2017/5/4.
 */
public class MemberDto {
    private Integer memid;
    private Date endate;
    private Integer page=1;
    private Integer rows=10;

    public Integer getMemid() {
        return memid;
    }

    public void setMemid(Integer memid) {
        this.memid = memid;
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

    public Date getEndate() {
        return endate;
    }

    public void setEndate(Date endate) {
        this.endate = endate;
    }
}
