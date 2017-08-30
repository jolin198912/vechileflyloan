package cn.houhe.api.user.web.bo;

/**
 * Created by Administrator on 2017/3/30.
 */
public class RoleDto {
    /**
     * ID
     */
    public Integer id;
    /**
     * 名字
     */
    public String name;
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

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}



