package cn.houhe.api.config.entity;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/5/3.
 */
public class LevelRateExt {
    private Short levelId;
    /** name -- 等级名称 */
    private String name;
    /** min_score -- 最小分值(PDL) */
    private Short minScore;
    /** max_score -- 最大分值(PDL) */
    private Short maxScore;
    /** max_limit -- 最大信用额度(PDL) */
    private BigDecimal maxLimit;
    /** min_limit -- 最小信用额度(PDL) */
    private BigDecimal minLimit;
    /** installment_min_score -- 分期贷款的最小分值 */
    private BigDecimal installmentMinScore;
    /** installment_max_score -- 分期贷款的最大分值 */
    private BigDecimal installmentMaxScore;
    /** installment_max_limit -- 分期贷款的最大信用额度 */
    private BigDecimal installmentMaxLimit;
    /** installment_min_limit -- 分期贷款的最小信用额度 */
    private BigDecimal installmentMinLimit;

    /** rr_id --  */
    private Short rrId;
    /** rate -- (PDL)月利率(存最终值，如0.05%，存0.0005) */
    private BigDecimal rate;
    /** type -- 类型0PDL1现金分期 */
    private Short type;
    /** loan_pay_rate -- (PDL)放款手续费率 */
    private BigDecimal loanPayRate;
    /** account_manage_rate -- (PDL)账号管理费率 */
    private BigDecimal accountManageRate;
    /** consultation_rate -- (PDL)咨询费率 */
    private BigDecimal consultationRate;
    /** first_loan_rate -- (PDL)首次贷款综合费率 */
    private BigDecimal firstLoanRate;
    /** least_loan_rate -- (PDL)最低综合费率 */
    private BigDecimal leastLoanRate;
    /** delay_rate -- (PDL)逾期罚息费率 */
    private BigDecimal delayRate;
    /** discount -- (PDL)费率折扣 */
    private BigDecimal discount;
    /** withdrawals_rate -- (PDL)提现费率 */
    private BigDecimal withdrawalsRate;
    /** quota_manage_rate -- (PDL)额度管理费率 */
    private BigDecimal quotaManageRate;
    /** remind_fee -- (PDL)催收费（逾期一天的崔收费） */
    private BigDecimal remindFee;
    /** quota_manage_fee -- (PDL)额度管理费 */
    //private BigDecimal quotaManageFee;

    /** rr_id --  */
    private Short rrId1;
    /** rate -- 月利率(存最终值，如0.05%，存0.0005) */
    private BigDecimal rate1;
    /** type -- 类型0PDL1现金分期 */
    private Short type1;
    /** loan_pay_rate -- 放款手续费率 */
    private BigDecimal loanPayRate1;
    /** account_manage_rate -- 账号管理费率 */
    private BigDecimal accountManageRate1;
    /** consultation_rate -- 咨询费率 */
    private BigDecimal consultationRate1;
    /** first_loan_rate -- 首次贷款综合费率 */
    private BigDecimal firstLoanRate1;
    /** least_loan_rate -- 最低综合费率 */
    private BigDecimal leastLoanRate1;
    /** delay_rate -- 逾期罚息费率 */
    private BigDecimal delayRate1;
    /** discount -- 费率折扣 */
    private BigDecimal discount1;
    /** withdrawals_rate -- 提现费率 */
    private BigDecimal withdrawalsRate1;
    /** quota_manage_rate -- 额度管理费率 */
    private BigDecimal quotaManageRate1;
    /** remind_fee -- 催收费（逾期一天的崔收费） */
    private BigDecimal remindFee1;
    /** quota_manage_fee -- 额度管理费 */
    //private BigDecimal quotaManageFee;

    public Short getLevelId() {
        return levelId;
    }

    public void setLevelId(Short levelId) {
        this.levelId = levelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getMinScore() {
        return minScore;
    }

    public void setMinScore(Short minScore) {
        this.minScore = minScore;
    }

    public Short getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Short maxScore) {
        this.maxScore = maxScore;
    }

    public BigDecimal getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(BigDecimal maxLimit) {
        this.maxLimit = maxLimit;
    }

    public BigDecimal getMinLimit() {
        return minLimit;
    }

    public void setMinLimit(BigDecimal minLimit) {
        this.minLimit = minLimit;
    }

    public BigDecimal getInstallmentMinScore() {
        return installmentMinScore;
    }

    public void setInstallmentMinScore(BigDecimal installmentMinScore) {
        this.installmentMinScore = installmentMinScore;
    }

    public BigDecimal getInstallmentMaxScore() {
        return installmentMaxScore;
    }

    public void setInstallmentMaxScore(BigDecimal installmentMaxScore) {
        this.installmentMaxScore = installmentMaxScore;
    }

    public BigDecimal getInstallmentMaxLimit() {
        return installmentMaxLimit;
    }

    public void setInstallmentMaxLimit(BigDecimal installmentMaxLimit) {
        this.installmentMaxLimit = installmentMaxLimit;
    }

    public BigDecimal getInstallmentMinLimit() {
        return installmentMinLimit;
    }

    public void setInstallmentMinLimit(BigDecimal installmentMinLimit) {
        this.installmentMinLimit = installmentMinLimit;
    }

    public Short getRrId() {
        return rrId;
    }

    public void setRrId(Short rrId) {
        this.rrId = rrId;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
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
    }

    public BigDecimal getFirstLoanRate() {
        return firstLoanRate;
    }

    public void setFirstLoanRate(BigDecimal firstLoanRate) {
        this.firstLoanRate = firstLoanRate;
    }

    public BigDecimal getLeastLoanRate() {
        return leastLoanRate;
    }

    public void setLeastLoanRate(BigDecimal leastLoanRate) {
        this.leastLoanRate = leastLoanRate;
    }

    public BigDecimal getDelayRate() {
        return delayRate;
    }

    public void setDelayRate(BigDecimal delayRate) {
        this.delayRate = delayRate;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getWithdrawalsRate() {
        return withdrawalsRate;
    }

    public void setWithdrawalsRate(BigDecimal withdrawalsRate) {
        this.withdrawalsRate = withdrawalsRate;
    }

    public BigDecimal getQuotaManageRate() {
        return quotaManageRate;
    }

    public void setQuotaManageRate(BigDecimal quotaManageRate) {
        this.quotaManageRate = quotaManageRate;
    }

    public BigDecimal getRemindFee() {
        return remindFee;
    }

    public void setRemindFee(BigDecimal remindFee) {
        this.remindFee = remindFee;
    }

    public BigDecimal getQuotaManageRate1() {
        return quotaManageRate1;
    }

    public void setQuotaManageRate1(BigDecimal quotaManageRate1) {
        this.quotaManageRate1 = quotaManageRate1;
    }

    public Short getRrId1() {
        return rrId1;
    }

    public void setRrId1(Short rrId1) {
        this.rrId1 = rrId1;
    }

    public BigDecimal getRate1() {
        return rate1;
    }

    public void setRate1(BigDecimal rate1) {
        this.rate1 = rate1;
    }

    public Short getType1() {
        return type1;
    }

    public void setType1(Short type1) {
        this.type1 = type1;
    }

    public BigDecimal getLoanPayRate1() {
        return loanPayRate1;
    }

    public void setLoanPayRate1(BigDecimal loanPayRate1) {
        this.loanPayRate1 = loanPayRate1;
    }

    public BigDecimal getAccountManageRate1() {
        return accountManageRate1;
    }

    public void setAccountManageRate1(BigDecimal accountManageRate1) {
        this.accountManageRate1 = accountManageRate1;
    }

    public BigDecimal getConsultationRate1() {
        return consultationRate1;
    }

    public void setConsultationRate1(BigDecimal consultationRate1) {
        this.consultationRate1 = consultationRate1;
    }

    public BigDecimal getFirstLoanRate1() {
        return firstLoanRate1;
    }

    public void setFirstLoanRate1(BigDecimal firstLoanRate1) {
        this.firstLoanRate1 = firstLoanRate1;
    }

    public BigDecimal getLeastLoanRate1() {
        return leastLoanRate1;
    }

    public void setLeastLoanRate1(BigDecimal leastLoanRate1) {
        this.leastLoanRate1 = leastLoanRate1;
    }

    public BigDecimal getDelayRate1() {
        return delayRate1;
    }

    public void setDelayRate1(BigDecimal delayRate1) {
        this.delayRate1 = delayRate1;
    }

    public BigDecimal getDiscount1() {
        return discount1;
    }

    public void setDiscount1(BigDecimal discount1) {
        this.discount1 = discount1;
    }

    public BigDecimal getWithdrawalsRate1() {
        return withdrawalsRate1;
    }

    public void setWithdrawalsRate1(BigDecimal withdrawalsRate1) {
        this.withdrawalsRate1 = withdrawalsRate1;
    }

    public BigDecimal getRemindFee1() {
        return remindFee1;
    }

    public void setRemindFee1(BigDecimal remindFee1) {
        this.remindFee1 = remindFee1;
    }
}
