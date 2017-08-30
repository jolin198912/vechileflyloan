package cn.houhe.api.member.web.bo;

/**
 * Created by Administrator on 2017/4/13.
 */
public class MemberListDto {
    /** memid -- 会员id */
    private Integer memId;
    /** rpt_id -- 主键 */
    private Integer rptId;
    /** mobileno -- 手机号 */
    private String mobileno;
    /** applyState -- 是否申请（0：否 1：是） */
    private Byte applyState;
    /** loanState -- 是否贷款（0：否 1：是） */
    private Byte loanState;
    /** invitecode -- 邀请码 */
    private String invitecode;
    /**是否黑名单（0否；1是）*/
    private  byte isenable;

    public byte getIsenable() {
        return isenable;
    }

    public void setIsenable(byte isenable) {
        this.isenable = isenable;
    }

    private int page=1;
    private int rows=20;

    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    public Integer getRptId() {
        return rptId;
    }

    public void setRptId(Integer rptId) {
        this.rptId = rptId;
    }

    /** 获取手机号 */
    public String getMobileno() {
        return mobileno;
    }

    /** 设置手机号 */
    public void setMobileno(String mobileno) {
        this.mobileno = mobileno == null ? null : mobileno.trim();
    }

    /** applyState -- 获取是否申请（0：否 1：是） */
    public Byte getApplyState() {
        return applyState;
    }

    /** applyState -- 设置是否申请（0：否 1：是） */
    public void setApplyState(Byte applyState) {
        this.applyState = applyState;
    }

    /** loanState -- 获取是否贷款（0：否 1：是） */
    public Byte getLoanState() {
        return loanState;
    }

    /** loanStatus -- 设置是否贷款（0：否 1：是） */
    public void setLoanState(Byte loanState) {
        this.loanState = loanState;
    }

    public String getInvitecode() {
        return invitecode;
    }

    public void setInvitecode(String invitecode) {
        this.invitecode = invitecode;
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
