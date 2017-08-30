package cn.houhe.api.user.web.bo;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
public class UserDto {

    public UserDto(){
        this.page=1;
        this.rows=20;

    }
    /**
     * 账号ID
     */
    public int id;
    /**
     * 登录账号
     */
    public String account;
    public String password;

    public int page;

    public int rows;

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

    /**
     * 名字
     */
    public String name;
    /**
     * 手机号
     */
    public String phone;
    /**
     * 部门
     */
    public String department;
    /**
     * 角色id集合，用逗号隔开
     */
    public List<RoleDto> roles;

    public int status;
    /**

     * 催收级别
     */
    public int efficient;
    /**
     * 是否boss账号
     */
    public int isboss;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public List<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public int getEfficient() {
        return efficient;
    }

    public void setEfficient(int efficient) {
        this.efficient = efficient;
    }

    public int getIsboss() {
        return isboss;
    }

    public void setIsboss(int isboss) {
        this.isboss = isboss;
    }
}
