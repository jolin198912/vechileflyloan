package cn.houhe.api.user.web.bo;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
public class RoleResouDto  {
    /**
     * ID
     */
    public Integer id;
    /**
     * 名字
     */
    public String name;

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

    public  List<ResDto> resList;

    public List<ResDto> getResList() {
        return resList;
    }

    public void setResList(List<ResDto> resList) {
        this.resList = resList;
    }
}



