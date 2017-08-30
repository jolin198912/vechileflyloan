package cn.houhe.api.member.web.bo;

/**
 * Created by Administrator on 2017/4/14.
 */
public class RegisterRecordDto {
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
}
