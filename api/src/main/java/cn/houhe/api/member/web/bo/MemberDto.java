package cn.houhe.api.member.web.bo;

import org.hibernate.validator.constraints.Length;

/**
 * Created by Administrator on 2017/3/30.
 */
public class MemberDto {
    /** mobile -- 手机号 */
    private String mobile;
    /** loginpsw -- 登录密码 */
    private String loginpsw;
    /** verificode -- 验证码 */
    private String verificode;
    /** invitecode -- 邀请码 */
    private String invitecode;
    /** newloginpsw -- 新登录密码 */
    private String newloginpsw;
    /** tradingpsw -- 交易密码 */
    private String tradingpsw;
    /** newtradingpsw -- 新交易密码 */
    private String newtradingpsw;
    /** updatepswtype -- 修改登录密码类型（0：忘记登录密码 1：修改登录密码） */
    private Byte updatepswtype;
    /** idcardno -- 身份证号 */
    private String idcardno;
    /** realname -- 真实姓名 */
    private String realname;
    /** nextstep -- 忘记交易密码操作类型（0：校验用户信息 1：修改交易密码） */
    private Byte nextstep;

    /** mobile -- 获取手机号 */
    public String getMobile() {
        return mobile;
    }

    /** mobile -- 设置手机号 */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /** loginpsw -- 获取登录密码 */
    public String getLoginpsw() {
        return loginpsw;
    }

    /** loginpsw -- 设置登录密码 */
    public void setLoginpsw(String loginpsw) {
        this.loginpsw = loginpsw;
    }

    /** verificode -- 获取验证码 */
    public String getVerificode() {
        return verificode;
    }

    /** verificode -- 设置验证码 */
    public void setVerificode(String verificode) {
        this.verificode = verificode;
    }

    /** invitecode -- 获取邀请码 */
    public String getInvitecode() {
        return invitecode;
    }

    /** invitecode -- 设置邀请码 */
    public void setInvitecode(String invitecode) {
        this.invitecode = invitecode;
    }

    /** newloginpsw -- 获取新登录密码 */
    public String getNewloginpsw() {
        return newloginpsw;
    }

    /** newloginpsw -- 设置新登录密码 */
    public void setNewloginpsw(String newloginpsw) {
        this.newloginpsw = newloginpsw;
    }

    /** tradingpsw -- 获取交易密码 */
    public String getTradingpsw() {
        return tradingpsw;
    }

    /** tradingpsw -- 设置交易密码 */
    public void setTradingpsw(String tradingpsw) {
        this.tradingpsw = tradingpsw;
    }

    /** newtradingpsw -- 获取新交易密码 */
    public String getNewtradingpsw() {
        return newtradingpsw;
    }

    /** newtradingpsw -- 设置新交易密码 */
    public void setNewtradingpsw(String newtradingpsw) {
        this.newtradingpsw = newtradingpsw;
    }

    /** updatepswtype -- 获取修改登录密码类型（0：忘记登录密码 1：修改登录密码） */
    public Byte getUpdatepswtype() {
        return updatepswtype;
    }

    /** updatepswtype -- 设置修改登录密码类型（0：忘记登录密码 1：修改登录密码） */
    public void setUpdatepswtype(Byte updatepswtype) {
        this.updatepswtype = updatepswtype;
    }

    /** 获取身份证号 */
    public String getIdcardno() {
        return idcardno;
    }

    /** 设置身份证号 */
    public void setIdcardno(String idcardno) {
        this.idcardno = idcardno == null ? null : idcardno.trim();
    }

    /** 获取真实姓名 */
    public String getRealname() {
        return realname;
    }

    /** 设置真实姓名 */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /** nextstep -- 获取交易密码操作类型（0：校验用户信息 1：修改交易密码） */
    public Byte getNextstep() {
        return nextstep;
    }

    /** nextstep -- 设置交易密码操作类型（0：校验用户信息 1：修改交易密码） */
    public void setNextstep(Byte nextstep) {
        this.nextstep = nextstep;
    }
}
