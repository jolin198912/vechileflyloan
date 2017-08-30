package cn.houhe.api.log.web.bo;

/**
 * Created by Administrator on 2017/4/7.
 */
public class MessageDto {
    private Integer mid;
    /** title -- 标题 */
    private String title;
    /** content -- 消息内容 */
    private String content;
    private int page=1;
    private int rows=20;
    /** member_id -- 用户id */
    private Integer memberId;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
