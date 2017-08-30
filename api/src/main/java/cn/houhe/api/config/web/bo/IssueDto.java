package cn.houhe.api.config.web.bo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/31.
 */
public class IssueDto implements Serializable {
    private Short iuId;
    private String title;
    private Short issueTypeId;
    private Byte isSolve;
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

    public Short getIssueTypeId() {
        return issueTypeId;
    }

    public void setIssueTypeId(Short issueTypeId) {
        this.issueTypeId = issueTypeId;
    }

    public Short getIuId() {
        return iuId;
    }

    public void setIuId(Short iuId) {
        this.iuId = iuId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Byte getIsSolve() {
        return isSolve;
    }

    public void setIsSolve(Byte isSolve) {
        this.isSolve = isSolve;
    }
}
