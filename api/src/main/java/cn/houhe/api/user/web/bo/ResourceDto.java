package cn.houhe.api.user.web.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */
public class ResourceDto implements Serializable {
    private int id;
    private String code;
    private String text;
    private AttributeDto attribute = new AttributeDto(0,"");
    private boolean checked;
    public List<ResourceDto> children = new ArrayList<ResourceDto>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public AttributeDto getAttribute() {
        return attribute;
    }

    public void setAttribute(AttributeDto attribute) {
        this.attribute = attribute;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public List<ResourceDto> getChildren() {
        return children;
    }

    public void setChildren(List<ResourceDto> children) {
        this.children = children;
    }
}

