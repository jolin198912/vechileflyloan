package cn.houhe.api.loan.web.bo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by Administrator on 2017/5/6.
 */
public class StatisticsDto {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date start;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date end;

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
}
