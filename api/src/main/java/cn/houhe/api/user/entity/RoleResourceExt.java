package cn.houhe.api.user.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/13.
 */
public class RoleResourceExt implements Serializable {
    private Integer roleid;
    private Integer resId;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }
}
