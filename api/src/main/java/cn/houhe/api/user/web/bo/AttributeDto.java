package cn.houhe.api.user.web.bo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/10.
 */
public class AttributeDto implements Serializable {
    private int issingle;
    //分组名称
    private String groupname;

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public int getIssingle() {
        return issingle;
    }

    public void setIssingle(int issingle) {
        this.issingle = issingle;
    }

    public AttributeDto(int issingle, String groupname) {
        this.issingle = issingle;
        this.groupname = groupname;
    }
}
