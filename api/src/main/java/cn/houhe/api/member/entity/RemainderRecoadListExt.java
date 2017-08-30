package cn.houhe.api.member.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/20.
 */
public class RemainderRecoadListExt {
    /** memid -- 用户id */
    private Integer memId;
    /** rpt_id -- 主键 */
    private Integer rptId;
    /** createdon -- 催收时间 */
    //@JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdon;
    /** remainder -- 催收人员 */
    private String remainder;
    /** remaind_object -- 催收对象 */
    private Byte remaindObject;
    /** call_state -- 接通情况（接通,关机，停机等） */
    private String callState;
    /** remaind_name -- 联系人姓名 */
    private String remaindName;
    /** attitude -- 客户态度 */
    private String attitude;
    /** link_attitude -- 联系人态度 */
    private String linkAttitude;
    /** contact_truth -- 联系人真实性 */
    private Byte contactTruth;
    /** debit_desire -- 还款意愿 */
    private String debitDesire;
    /** promise_debit_date -- 承诺还款时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date promiseDebitDate;
    /** reason -- 拖欠原因 */
    private String reason;
    /** remark -- 催记 */
    private String remark;

    private int page;
    private int rows;

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

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    public String getRemainder() {
        return remainder;
    }

    public void setRemainder(String remainder) {
        this.remainder = remainder;
    }

    public Byte getRemaindObject() {
        return remaindObject;
    }

    public void setRemaindObject(Byte remaindObject) {
        this.remaindObject = remaindObject;
    }

    public String getCallState() {
        return callState;
    }

    public void setCallState(String callState) {
        this.callState = callState;
    }

    public String getRemaindName() {
        return remaindName;
    }

    public void setRemaindName(String remaindName) {
        this.remaindName = remaindName;
    }

    public String getAttitude() {
        return attitude;
    }

    public void setAttitude(String attitude) {
        this.attitude = attitude;
    }

    public String getLinkAttitude() {
        return linkAttitude;
    }

    public void setLinkAttitude(String linkAttitude) {
        this.linkAttitude = linkAttitude;
    }

    public Byte getContactTruth() {
        return contactTruth;
    }

    public void setContactTruth(Byte contactTruth) {
        this.contactTruth = contactTruth;
    }

    public String getDebitDesire() {
        return debitDesire;
    }

    public void setDebitDesire(String debitDesire) {
        this.debitDesire = debitDesire;
    }

    public Date getPromiseDebitDate() {
        return promiseDebitDate;
    }

    public void setPromiseDebitDate(Date promiseDebitDate) {
        this.promiseDebitDate = promiseDebitDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    @Override
    public String toString() {
        return "RemainderRecoadListExt{" +
                "createdon=" + createdon +
                ", remainder='" + remainder + '\'' +
                ", remaindObject=" + remaindObject +
                ", remaindName='" + remaindName + '\'' +
                ", attitude='" + attitude + '\'' +
                ", contactTruth=" + contactTruth +
                ", debitDesire='" + debitDesire + '\'' +
                ", promiseDebitDate=" + promiseDebitDate +
                ", reason='" + reason + '\'' +
                ", remark='" + remark + '\'' +
                ", page=" + page +
                ", rows=" + rows +
                '}';
    }
}
