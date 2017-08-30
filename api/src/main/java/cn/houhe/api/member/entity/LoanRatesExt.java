package cn.houhe.api.member.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/4/6.
 */
public class LoanRatesExt {
    /** memid -- 主键id */
    private Integer memid;

    /** level_id --  *//*
    private Short levelId;

    *//** name -- 等级名称 *//*
    private String name;

    *//** rate -- 利率(存最终值，如0.05%，存0.0005) *//*
    private BigDecimal rate;

    *//** loan_pay_rate -- 放款手续费率(存最终值，如0.05%，存0.0005) *//*
    private BigDecimal loanPayRate;

    *//** account_manage_rate -- 账户管理费率(存最终值，如0.05%，存0.0005) *//*
    private BigDecimal accountManageRate;

    *//** consultation_rate -- 咨询服务费率(存最终值，如0.05%，存0.0005) *//*
    private BigDecimal consultationRate;*/

    /** quota_manage_rate -- 额度管理费率(存最终值，如0.05%，存0.0005) */
    private BigDecimal quotaManageRate;

    /** withdrawals_rate -- 提现费率(存最终值，如0.05%，存0.0005) */
    private BigDecimal withdrawalsRate;

    /** first_loan_rate -- 首次贷款综合费率(存最终值，如0.05%，存0.0005) */
    private BigDecimal firstLoanRate;

    /** least_loan_rate -- 最低综合费率(存最终值，如0.05%，存0.0005) */
    //private BigDecimal leastLoanRate;

    /** type -- 类型0日，1月 */
    private Byte type;

    /** time -- 天数或者月数 */
    private Short time;

    /** max_limit -- 最大贷款额度 */
    private BigDecimal maxLimit;

    /** min_limit -- 最小贷款额度 */
    private BigDecimal minLimit;

    /** 获取主键id */
    public Integer getMemid() {
        return memid;
    }

    /** 设置主键id */
    public void setMemid(Integer memid) {
        this.memid = memid;
    }

    /** 获取 *//*
    public Short getLevelId() {
        return levelId;
    }

    *//** 设置 *//*
    public void setLevelId(Short levelId) {
        this.levelId = levelId;
    }

    *//** 获取等级名称 *//*
    public String getName() {
        return name;
    }

    *//** 设置等级名称 *//*
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    *//** 获取利率(存最终值，如0.05%，存0.0005) *//*
    public BigDecimal getRate() {
        return rate;
    }

    *//** 设置利率(存最终值，如0.05%，存0.0005) *//*
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getLoanPayRate() {
        return loanPayRate;
    }

    public void setLoanPayRate(BigDecimal loanPayRate) {
        this.loanPayRate = loanPayRate;
    }

    public BigDecimal getAccountManageRate() {
        return accountManageRate;
    }

    public void setAccountManageRate(BigDecimal accountManageRate) {
        this.accountManageRate = accountManageRate;
    }

    public BigDecimal getConsultationRate() {
        return consultationRate;
    }

    public void setConsultationRate(BigDecimal consultationRate) {
        this.consultationRate = consultationRate;
    }*/

    public BigDecimal getQuotaManageRate() {
        return quotaManageRate;
    }

    public void setQuotaManageRate(BigDecimal quotaManageRate) {
        this.quotaManageRate = quotaManageRate;
    }

    public BigDecimal getWithdrawalsRate() {
        return withdrawalsRate;
    }

    public void setWithdrawalsRate(BigDecimal withdrawalsRate) {
        this.withdrawalsRate = withdrawalsRate;
    }

    public BigDecimal getFirstLoanRate() {
        return firstLoanRate;
    }

    public void setFirstLoanRate(BigDecimal firstLoanRate) {
        this.firstLoanRate = firstLoanRate;
    }

    /*public BigDecimal getLeastLoanRate() {
        return leastLoanRate;
    }

    public void setLeastLoanRate(BigDecimal leastLoanRate) {
        this.leastLoanRate = leastLoanRate;
    }*/

    /** 获取类型0日，1月 */
    public Byte getType() {
        return type;
    }

    /** 设置类型0日，1月 */
    public void setType(Byte type) {
        this.type = type;
    }

    /** 获取天数或者月数 */
    public Short getTime() {
        return time;
    }

    /** 设置天数或者月数 */
    public void setTime(Short time) {
        this.time = time;
    }

    /** 获取最大贷款额度（不分期） */
    public BigDecimal getMaxLimit() {
        return maxLimit;
    }

    /** 设置最大贷款额度（不分期） */
    public void setMaxLimit(BigDecimal maxLimit) {
        this.maxLimit = maxLimit;
    }

    /** 获取最小贷款额度（不分期） */
    public BigDecimal getMinLimit() {
        return minLimit;
    }

    /** 设置最小贷款额度（不分期） */
    public void setMinLimit(BigDecimal minLimit) {
        this.minLimit = minLimit;
    }
}
