package cn.houhe.api.user.web.bo;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
public class UserAddDto {
    /**
     * 账号ID
     */
    public int id;
    /**
     * 登录账号
     */
    public String account;
    public String password;
    public String password2;
    /**
     * 名字
     */
    public String name;

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    /**
     * 手机号
     */
    public String phone;

    public String roleIds;
    /**
     * 部门
     */
    public String department;

    /**
     * 是否boss账号
     */
    public int isboss;

    public int getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsboss() {
        return isboss;
    }

    public void setIsboss(int isboss) {
        this.isboss = isboss;
    }
}
