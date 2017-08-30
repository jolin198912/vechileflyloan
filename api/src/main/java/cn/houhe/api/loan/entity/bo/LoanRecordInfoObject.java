package cn.houhe.api.loan.entity.bo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by think on 2017/4/12.
 */
public class LoanRecordInfoObject {
    /** loan_id -- id 主键 */
    private Integer loanId;

    /** loan_limit -- 贷款额度 */
    private BigDecimal loanLimit;

    @JsonFormat(pattern = "yyyy-MM-dd")
    /** start_time -- 开始时间 */
    private Date start;
    @JsonFormat(pattern = "yyyy-MM-dd")
    /** end_time -- 结束时间 */
    private Date end;

    /** username -- 贷款人姓名 */
    private String name;

    /** rate -- 贷款利率(存最终值，如0.05%，存0.0005) */
    private BigDecimal rate;

    /** apply_state -- 审核状态（1填写完资料审批中2初审通过3初审不通过4终审通过5终审不通过6自动审批通过7自动审批不通过） */
    private Byte applyState;

    /** apply_time -- 申请时间 */
    private Date applyTime;

    /** member_id -- 用户id */
    private Integer memberId;

    /** credit_rating -- 现金分期信用评级 */
    private String creditRating;

    //pdl信用等级
    private  String pdlCreditRating;

    /** user_mobile -- 贷款人手机 */
    private String mobile;

    /**
     * 信用申请时人脸
     */
    private String creditFace;

    /**
     * 借款时人脸
     */
    private String loanFace;

    /**
     * 收款银行卡号
     */
    private String  rbcardno;

    /**
     * 收款银行
     */
    private String  rbank;

    //贷款时长
    private Integer time;

    //贷款期限类型
    private byte loantype;

    /**
     * 逾期次数
     */
    private Integer dbt;

    /**
     * 人脸相似度
     */
    private float fs;

    //审核备注
    private String remark;

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public BigDecimal getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(BigDecimal loanLimit) {
        this.loanLimit = loanLimit;
    }


    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Byte getApplyState() {
        return applyState;
    }

    public void setApplyState(Byte applyState) {
        this.applyState = applyState;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(String creditRating) {
        this.creditRating = creditRating;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCreditFace() {
        return creditFace;
    }

    public void setCreditFace(String creditFace) {
        this.creditFace = creditFace;
    }

    public String getLoanFace() {
        return loanFace;
    }

    public void setLoanFace(String loanFace) {
        this.loanFace = loanFace;
    }

    public String getRbcardno() {
        return rbcardno;
    }

    public void setRbcardno(String rbcardno) {
        this.rbcardno = rbcardno;
    }

    public String getRbank() {
        return rbank;
    }

    public void setRbank(String rbank) {
        this.rbank = rbank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDbt() {
        return dbt;
    }

    public void setDbt(Integer dbt) {
        this.dbt = dbt;
    }

    public float getFs() {
        return fs;
    }

    public void setFs(float fs) {
        this.fs = fs;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public byte getLoantype() {
        return loantype;
    }

    public void setLoantype(byte loantype) {
        this.loantype = loantype;
    }

    public String getPdlCreditRating() {
        return pdlCreditRating;
    }

    public void setPdlCreditRating(String pdlCreditRating) {
        this.pdlCreditRating = pdlCreditRating;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "LoanRecordInfoObject{" +
                "loanId=" + loanId +
                ", loanLimit=" + loanLimit +
                ", start=" + start +
                ", end=" + end +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", applyState=" + applyState +
                ", applyTime=" + applyTime +
                ", memberId=" + memberId +
                ", creditRating='" + creditRating + '\'' +
                ", mobile='" + mobile + '\'' +
                ", creditFace='" + creditFace + '\'' +
                ", loanFace='" + loanFace + '\'' +
                ", rbcardno='" + rbcardno + '\'' +
                ", rbank='" + rbank + '\'' +
                ", dbt=" + dbt +
                ", fs=" + fs +
                '}';
    }
}
