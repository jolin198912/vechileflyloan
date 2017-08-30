package cn.houhe.api.loan.entity.bo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by think on 2017/4/10.
 */
public class CreditApplyList {
    private String name;
    private String mobile;
    private Date applyTime;
    private int applyState;
    /**
     * 初审人
     */
    private String fap;
    /**
     * 终审人
     */
    private String sap;

    /**
     * 申请id
     */
    private int caid;

    /**
     * 授信信息id
     */
    private int cdid;

    /**
     * 初审时间
     */
    private Date fat;

    /**
     * 终审时间
     */
    private Date sat;

    /**
     * 现金分期额度
     */
    private BigDecimal llimit;

    /**
     * pdl额度
     */
    private BigDecimal pdllimit;

    //现金分期等级
    private String creditRate;

    //pdl等级
    private String pdlcreditRate;

    //总得分
    private Integer totalscores;

    public BigDecimal getLlimit() {
        return llimit;
    }

    public void setLlimit(BigDecimal llimit) {
        this.llimit = llimit;
    }

    public Date getFat() {
        return fat;
    }

    public void setFat(Date fat) {
        this.fat = fat;
    }

    public Date getSat() {
        return sat;
    }

    public void setSat(Date sat) {
        this.sat = sat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public int getApplyState() {
        return applyState;
    }

    public void setApplyState(int applyState) {
        this.applyState = applyState;
    }

    public String getFap() {
        return fap;
    }

    public void setFap(String fap) {
        this.fap = fap;
    }

    public String getSap() {
        return sap;
    }

    public void setSap(String sap) {
        this.sap = sap;
    }

    public int getCaid() {
        return caid;
    }

    public void setCaid(int caid) {
        this.caid = caid;
    }

    public int getCdid() {
        return cdid;
    }

    public void setCdid(int cdid) {
        this.cdid = cdid;
    }

    public String getCreditRate() {
        return creditRate;
    }

    public void setCreditRate(String creditRate) {
        this.creditRate = creditRate;
    }

    public String getPdlcreditRate() {
        return pdlcreditRate;
    }

    public void setPdlcreditRate(String pdlcreditRate) {
        this.pdlcreditRate = pdlcreditRate;
    }

    public Integer getTotalscores() {
        return totalscores;
    }

    public void setTotalscores(Integer totalscores) {
        this.totalscores = totalscores;
    }

    public BigDecimal getPdllimit() {
        return pdllimit;
    }

    public void setPdllimit(BigDecimal pdllimit) {
        this.pdllimit = pdllimit;
    }
}
