package cn.houhe.api.config.web.bo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
public class IssueTypeDto implements Serializable {
    private Short itId;
    private String name;
    private List<IssueDto> issuelist;
    private int page=1;
    private int rows=20;

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

    public Short getItId() {
        return itId;
    }

    public void setItId(Short itId) {
        this.itId = itId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IssueDto> getIssuelist() {
        return issuelist;
    }

    public void setIssuelist(List<IssueDto> issuelist) {
        this.issuelist = issuelist;
    }
}
