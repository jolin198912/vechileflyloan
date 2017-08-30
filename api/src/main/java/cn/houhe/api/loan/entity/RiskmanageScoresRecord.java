package cn.houhe.api.loan.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;

/**
 * 实体类 - 表：riskmanage_scores_record
 * @since 2017-05-13 11:48:40
 */
@Alias("RiskmanageScoresRecord")
public class RiskmanageScoresRecord implements Serializable {
	/** rsr_id -- 主键id */
	private Integer rsrId;

	/** creditinfo_id -- 授信信息id */
	private Integer creditinfoId;

	/** apply_time_score -- 申请时间分数 */
	@NotNull(message="loan.RiskmanageScoresRecord.applyTimeScore.NotNull")
	private Integer applyTimeScore;

	/** wanted_limit_score -- 申请额度分数 */
	@NotNull(message="loan.RiskmanageScoresRecord.wantedLimitScore.NotNull")
	private Integer wantedLimitScore;

	/** wanted_period_score -- 期望还款期限分数 */
	@NotNull(message="loan.RiskmanageScoresRecord.wantedPeriodScore.NotNull")
	private Integer wantedPeriodScore;

	/** wanted_repay_day_score -- 期望还款日期分数 */
	@NotNull(message="loan.RiskmanageScoresRecord.wantedRepayDayScore.NotNull")
	private Integer wantedRepayDayScore;

	/** buy_car_age_score -- 客户买车在25-40岁分数 */
	@NotNull(message="loan.RiskmanageScoresRecord.buyCarAgeScore.NotNull")
	private Integer buyCarAgeScore;

	/** car_lisence_score -- 驾照地址与居住地址在同一城市分数 */
	@NotNull(message="loan.RiskmanageScoresRecord.carLisenceScore.NotNull")
	private Integer carLisenceScore;

	/** car_property_score -- 非营运车辆分数 */
	@NotNull(message="loan.RiskmanageScoresRecord.carPropertyScore.NotNull")
	private Integer carPropertyScore;

	/** buy_date_above_score -- 购买时间在1年以上分数 */
	@NotNull(message="loan.RiskmanageScoresRecord.buyDateAboveScore.NotNull")
	private Integer buyDateAboveScore;

	/** buy_date_above_add_score -- 购买时间5年内的每增加一年分数 */
	@NotNull(message="loan.RiskmanageScoresRecord.buyDateAboveAddScore.NotNull")
	private Integer buyDateAboveAddScore;

	/** counts_score -- 家庭第一辆车且车辆购买价格在20万以内分数 */
	@NotNull(message="loan.RiskmanageScoresRecord.countsScore.NotNull")
	private Integer countsScore;

	/** price_score -- 车辆购买价格10-20w分数 */
	@NotNull(message="loan.RiskmanageScoresRecord.priceScore.NotNull")
	private Integer priceScore;

	/** car_insurance_amount_score -- 购买保险金额在2000以上分数 */
	@NotNull(message="loan.RiskmanageScoresRecord.carInsuranceAmountScore.NotNull")
	private Integer carInsuranceAmountScore;

	/** car_driven_score -- 驾龄2年及以上分数 */
	@NotNull(message="loan.RiskmanageScoresRecord.carDrivenScore.NotNull")
	private Integer carDrivenScore;

	/** house_area_score -- 房产平米在89以下的3-4口房子 */
	@NotNull(message="loan.RiskmanageScoresRecord.houseAreaScore.NotNull")
	private Integer houseAreaScore;

	/** house_appraisement_score -- 房产估价50-100万，每多20万加1分。20分封顶 */
	@NotNull(message="loan.RiskmanageScoresRecord.houseAppraisementScore.NotNull")
	private Integer houseAppraisementScore;

	/** loan_amount_income_score -- 房子月还款金额占收入比的70%以下 */
	@NotNull(message="loan.RiskmanageScoresRecord.loanAmountIncomeScore.NotNull")
	private Integer loanAmountIncomeScore;

	/** length_of_residence_score -- 自有住房或租房时间在3年以上 */
	@NotNull(message="loan.RiskmanageScoresRecord.lengthOfResidenceScore.NotNull")
	private Integer lengthOfResidenceScore;

	/** is_allow_contact_score -- 允许读取通讯录 */
	@NotNull(message="loan.RiskmanageScoresRecord.isAllowContactScore.NotNull")
	private Integer isAllowContactScore;

	/** is_allow_record_score -- 允许读取通话记录 */
	@NotNull(message="loan.RiskmanageScoresRecord.isAllowRecordScore.NotNull")
	private Integer isAllowRecordScore;

	/** is_allow_message_score -- 允许读取短信 */
	@NotNull(message="loan.RiskmanageScoresRecord.isAllowMessageScore.NotNull")
	private Integer isAllowMessageScore;

	/** is_allow_location_score -- 允许读取定位 */
	@NotNull(message="loan.RiskmanageScoresRecord.isAllowLocationScore.NotNull")
	private Integer isAllowLocationScore;

	/** br_stability_score -- 通过客户稳定性评估-百融 */
	@NotNull(message="loan.RiskmanageScoresRecord.brStabilityScore.NotNull")
	private Integer brStabilityScore;

	/** id_phone_locale_score -- 身份证与手机号归属地一致 */
	@NotNull(message="loan.RiskmanageScoresRecord.idPhoneLocaleScore.NotNull")
	private Integer idPhoneLocaleScore;

	/** id_phone_name_score -- 手机号身份证姓名一致性 */
	@NotNull(message="loan.RiskmanageScoresRecord.idPhoneNameScore.NotNull")
	private Integer idPhoneNameScore;

	/** phone_on_time_score -- 手机号码在网时间每超过1年 */
	@NotNull(message="loan.RiskmanageScoresRecord.phoneOnTimeScore.NotNull")
	private Integer phoneOnTimeScore;

	/** bqs_score -- 白骑士 */
	@NotNull(message="loan.RiskmanageScoresRecord.bqsScore.NotNull")
	private Integer bqsScore;

	/** phone_costs_score -- 手机消费金额在50-100、100-200、200 */
	@NotNull(message="loan.RiskmanageScoresRecord.phoneCostsScore.NotNull")
	private Integer phoneCostsScore;

	/** is500_score -- 是否500强 */
	@NotNull(message="loan.RiskmanageScoresRecord.is500Score.NotNull")
	private Integer is500Score;

	/** educationlevel_score -- 教育程度 */
	@NotNull(message="loan.RiskmanageScoresRecord.educationlevelScore.NotNull")
	private Integer educationlevelScore;

	/** edudgcheck_score -- 通过学历验证的 */
	@NotNull(message="loan.RiskmanageScoresRecord.edudgcheckScore.NotNull")
	private Integer edudgcheckScore;

	/** eduyear_score -- 学制分数 */
	@NotNull(message="loan.RiskmanageScoresRecord.eduyearScore.NotNull")
	private Integer eduyearScore;

	/** eduage_score -- 读大学小于20岁且为本科以上 */
	@NotNull(message="loan.RiskmanageScoresRecord.eduageScore.NotNull")
	private Integer eduageScore;

	/** qqwxage_score -- qq、wx使用时间分数 */
	@NotNull(message="loan.RiskmanageScoresRecord.qqwxageScore.NotNull")
	private Integer qqwxageScore;

	/** qqwxinage_score -- qq、wx使用时间在客户20-25岁期间或30-40岁期间 */
	@NotNull(message="loan.RiskmanageScoresRecord.qqwxinageScore.NotNull")
	private Integer qqwxinageScore;

	/** linkphone_score -- 紧急联系人是直系亲属且3个月内有通话记录且在通话名单中 */
	@NotNull(message="loan.RiskmanageScoresRecord.linkphoneScore.NotNull")
	private Integer linkphoneScore;

	/** workadd_score -- 单位地址得到验证的 */
	@NotNull(message="loan.RiskmanageScoresRecord.workaddScore.NotNull")
	private Integer workaddScore;

	/** workadd_home_score -- 单位地址与居住地址在同一城市 */
	@NotNull(message="loan.RiskmanageScoresRecord.workaddHomeScore.NotNull")
	private Integer workaddHomeScore;

	/** wkyear_score -- 工作时间一年以上5分，每增加1年加1分 */
	@NotNull(message="loan.RiskmanageScoresRecord.wkyearScore.NotNull")
	private Integer wkyearScore;

	/** income_score -- 收入加分 */
	@NotNull(message="loan.RiskmanageScoresRecord.incomeScore.NotNull")
	private Integer incomeScore;

	/** social_security_score -- 选填社保、公积金缴纳基数 */
	@NotNull(message="loan.RiskmanageScoresRecord.socialSecurityScore.NotNull")
	private Integer socialSecurityScore;

	/** accumulation_fund_score -- 选填社保、公积金缴纳基数 */
	@NotNull(message="loan.RiskmanageScoresRecord.accumulationFundScore.NotNull")
	private Integer accumulationFundScore;

	/** income_compare_score -- 花呗、借呗、京东白条的授信额度，三者之一跟收入一致 */
	@NotNull(message="loan.RiskmanageScoresRecord.incomeCompareScore.NotNull")
	private Integer incomeCompareScore;

	/** debit_score -- 负债/收入低于70%  */
	@NotNull(message="loan.RiskmanageScoresRecord.debitScore.NotNull")
	private Integer debitScore;

	/** age_score -- 年龄25 */
	@NotNull(message="loan.RiskmanageScoresRecord.ageScore.NotNull")
	private Integer ageScore;

	/** age_man_older_score -- 男大女小 */
	@NotNull(message="loan.RiskmanageScoresRecord.ageManOlderScore.NotNull")
	private Integer ageManOlderScore;

	/** age_diff_five_score -- 年龄相差5岁 */
	@NotNull(message="loan.RiskmanageScoresRecord.ageDiffFiveScore.NotNull")
	private Integer ageDiffFiveScore;

	/** married_score -- 已婚 */
	@NotNull(message="loan.RiskmanageScoresRecord.marriedScore.NotNull")
	private Integer marriedScore;

	/** education_equal_score -- 学历相同 */
	@NotNull(message="loan.RiskmanageScoresRecord.educationEqualScore.NotNull")
	private Integer educationEqualScore;

	/** wife_education_higher_score -- 女方学历高 */
	@NotNull(message="loan.RiskmanageScoresRecord.wifeEducationHigherScore.NotNull")
	private Integer wifeEducationHigherScore;

	/** wife_working_score -- 女方上班 */
	@NotNull(message="loan.RiskmanageScoresRecord.wifeWorkingScore.NotNull")
	private Integer wifeWorkingScore;

	/** family_count_score -- 家庭人口 */
	@NotNull(message="loan.RiskmanageScoresRecord.familyCountScore.NotNull")
	private Integer familyCountScore;

	/** country_origin_score -- 农村户口 */
	@NotNull(message="loan.RiskmanageScoresRecord.countryOriginScore.NotNull")
	private Integer countryOriginScore;

	/** city_origin_age30_score -- 城市户口30-45 */
	@NotNull(message="loan.RiskmanageScoresRecord.cityOriginAge30Score.NotNull")
	private Integer cityOriginAge30Score;

	/** boy_great_seven_score -- 男孩大于7岁 */
	@NotNull(message="loan.RiskmanageScoresRecord.boyGreatSevenScore.NotNull")
	private Integer boyGreatSevenScore;

	/** birth_age_score -- 双方生育年龄25-35 */
	@NotNull(message="loan.RiskmanageScoresRecord.birthAgeScore.NotNull")
	private Integer birthAgeScore;

	/** boy_and_girl_score -- 两个孩子且有儿有女 */
	@NotNull(message="loan.RiskmanageScoresRecord.boyAndGirlScore.NotNull")
	private Integer boyAndGirlScore;

	/** age_subtract_score -- 两个孩子年龄差距10岁以上或5岁以内 */
	@NotNull(message="loan.RiskmanageScoresRecord.ageSubtractScore.NotNull")
	private Integer ageSubtractScore;

	/** live_address_score -- 居住地址正确 */
	@NotNull(message="loan.RiskmanageScoresRecord.liveAddressScore.NotNull")
	private Integer liveAddressScore;

	/** house_address_score -- 房产地址正确 */
	@NotNull(message="loan.RiskmanageScoresRecord.houseAddressScore.NotNull")
	private Integer houseAddressScore;

	/** address_score -- 户籍地址正确 */
	@NotNull(message="loan.RiskmanageScoresRecord.addressScore.NotNull")
	private Integer addressScore;

	/** live_time_score -- 居住时间在1年以上，每增加一年加一分，最高得分20分 */
	@NotNull(message="loan.RiskmanageScoresRecord.liveTimeScore.NotNull")
	private Integer liveTimeScore;

	/** pay_year_score -- 保费在5000-10000 */
	@NotNull(message="loan.RiskmanageScoresRecord.payYearScore.NotNull")
	private Integer payYearScore;

	/** pay_income_rate_score -- 保费支出在年收入的30%以内 */
	@NotNull(message="loan.RiskmanageScoresRecord.payIncomeRateScore.NotNull")
	private Integer payIncomeRateScore;

	/** girl_degree_score -- 女方学历通过验证的 */
	@NotNull(message="loan.RiskmanageScoresRecord.girlDegreeScore.NotNull")
	private Integer girlDegreeScore;

	/** op_auth_score -- 运营商授权 */
	@NotNull(message="loan.RiskmanageScoresRecord.opAuthScore.NotNull")
	private Integer opAuthScore;

	/** credit_auth_score -- 征信授权 */
	@NotNull(message="loan.RiskmanageScoresRecord.creditAuthScore.NotNull")
	private Integer creditAuthScore;

	/** al_auth_score -- 支付宝授权 */
	@NotNull(message="loan.RiskmanageScoresRecord.alAuthScore.NotNull")
	private Integer alAuthScore;

	/** total_scores -- 总授信评分 */
	private Integer totalScores;

	/** created_on -- 创建时间 */
	@NotNull(message="loan.RiskmanageScoresRecord.createdOn.NotNull")
	private Date createdOn;

	private static final long serialVersionUID = 1L;

	/** 获取主键id */
	public Integer getRsrId() {
		return rsrId;
	}

	/** 设置主键id */
	public void setRsrId(Integer rsrId) {
		this.rsrId = rsrId;
	}

	/** 获取授信信息id */
	public Integer getCreditinfoId() {
		return creditinfoId;
	}

	/** 设置授信信息id */
	public void setCreditinfoId(Integer creditinfoId) {
		this.creditinfoId = creditinfoId;
	}

	/** 获取申请时间分数 */
	public Integer getApplyTimeScore() {
		return applyTimeScore;
	}

	/** 设置申请时间分数 */
	public void setApplyTimeScore(Integer applyTimeScore) {
		this.applyTimeScore = applyTimeScore;
	}

	/** 获取申请额度分数 */
	public Integer getWantedLimitScore() {
		return wantedLimitScore;
	}

	/** 设置申请额度分数 */
	public void setWantedLimitScore(Integer wantedLimitScore) {
		this.wantedLimitScore = wantedLimitScore;
	}

	/** 获取期望还款期限分数 */
	public Integer getWantedPeriodScore() {
		return wantedPeriodScore;
	}

	/** 设置期望还款期限分数 */
	public void setWantedPeriodScore(Integer wantedPeriodScore) {
		this.wantedPeriodScore = wantedPeriodScore;
	}

	/** 获取期望还款日期分数 */
	public Integer getWantedRepayDayScore() {
		return wantedRepayDayScore;
	}

	/** 设置期望还款日期分数 */
	public void setWantedRepayDayScore(Integer wantedRepayDayScore) {
		this.wantedRepayDayScore = wantedRepayDayScore;
	}

	/** 获取客户买车在25-40岁分数 */
	public Integer getBuyCarAgeScore() {
		return buyCarAgeScore;
	}

	/** 设置客户买车在25-40岁分数 */
	public void setBuyCarAgeScore(Integer buyCarAgeScore) {
		this.buyCarAgeScore = buyCarAgeScore;
	}

	/** 获取驾照地址与居住地址在同一城市分数 */
	public Integer getCarLisenceScore() {
		return carLisenceScore;
	}

	/** 设置驾照地址与居住地址在同一城市分数 */
	public void setCarLisenceScore(Integer carLisenceScore) {
		this.carLisenceScore = carLisenceScore;
	}

	/** 获取非营运车辆分数 */
	public Integer getCarPropertyScore() {
		return carPropertyScore;
	}

	/** 设置非营运车辆分数 */
	public void setCarPropertyScore(Integer carPropertyScore) {
		this.carPropertyScore = carPropertyScore;
	}

	/** 获取购买时间在1年以上分数 */
	public Integer getBuyDateAboveScore() {
		return buyDateAboveScore;
	}

	/** 设置购买时间在1年以上分数 */
	public void setBuyDateAboveScore(Integer buyDateAboveScore) {
		this.buyDateAboveScore = buyDateAboveScore;
	}

	/** 获取购买时间5年内的每增加一年分数 */
	public Integer getBuyDateAboveAddScore() {
		return buyDateAboveAddScore;
	}

	/** 设置购买时间5年内的每增加一年分数 */
	public void setBuyDateAboveAddScore(Integer buyDateAboveAddScore) {
		this.buyDateAboveAddScore = buyDateAboveAddScore;
	}

	/** 获取家庭第一辆车且车辆购买价格在20万以内分数 */
	public Integer getCountsScore() {
		return countsScore;
	}

	/** 设置家庭第一辆车且车辆购买价格在20万以内分数 */
	public void setCountsScore(Integer countsScore) {
		this.countsScore = countsScore;
	}

	/** 获取车辆购买价格10-20w分数 */
	public Integer getPriceScore() {
		return priceScore;
	}

	/** 设置车辆购买价格10-20w分数 */
	public void setPriceScore(Integer priceScore) {
		this.priceScore = priceScore;
	}

	/** 获取购买保险金额在2000以上分数 */
	public Integer getCarInsuranceAmountScore() {
		return carInsuranceAmountScore;
	}

	/** 设置购买保险金额在2000以上分数 */
	public void setCarInsuranceAmountScore(Integer carInsuranceAmountScore) {
		this.carInsuranceAmountScore = carInsuranceAmountScore;
	}

	/** 获取驾龄2年及以上分数 */
	public Integer getCarDrivenScore() {
		return carDrivenScore;
	}

	/** 设置驾龄2年及以上分数 */
	public void setCarDrivenScore(Integer carDrivenScore) {
		this.carDrivenScore = carDrivenScore;
	}

	/** 获取房产平米在89以下的3-4口房子 */
	public Integer getHouseAreaScore() {
		return houseAreaScore;
	}

	/** 设置房产平米在89以下的3-4口房子 */
	public void setHouseAreaScore(Integer houseAreaScore) {
		this.houseAreaScore = houseAreaScore;
	}

	/** 获取房产估价50-100万，每多20万加1分。20分封顶 */
	public Integer getHouseAppraisementScore() {
		return houseAppraisementScore;
	}

	/** 设置房产估价50-100万，每多20万加1分。20分封顶 */
	public void setHouseAppraisementScore(Integer houseAppraisementScore) {
		this.houseAppraisementScore = houseAppraisementScore;
	}

	/** 获取房子月还款金额占收入比的70%以下 */
	public Integer getLoanAmountIncomeScore() {
		return loanAmountIncomeScore;
	}

	/** 设置房子月还款金额占收入比的70%以下 */
	public void setLoanAmountIncomeScore(Integer loanAmountIncomeScore) {
		this.loanAmountIncomeScore = loanAmountIncomeScore;
	}

	/** 获取自有住房或租房时间在3年以上 */
	public Integer getLengthOfResidenceScore() {
		return lengthOfResidenceScore;
	}

	/** 设置自有住房或租房时间在3年以上 */
	public void setLengthOfResidenceScore(Integer lengthOfResidenceScore) {
		this.lengthOfResidenceScore = lengthOfResidenceScore;
	}

	/** 获取允许读取通讯录 */
	public Integer getIsAllowContactScore() {
		return isAllowContactScore;
	}

	/** 设置允许读取通讯录 */
	public void setIsAllowContactScore(Integer isAllowContactScore) {
		this.isAllowContactScore = isAllowContactScore;
	}

	/** 获取允许读取通话记录 */
	public Integer getIsAllowRecordScore() {
		return isAllowRecordScore;
	}

	/** 设置允许读取通话记录 */
	public void setIsAllowRecordScore(Integer isAllowRecordScore) {
		this.isAllowRecordScore = isAllowRecordScore;
	}

	/** 获取允许读取短信 */
	public Integer getIsAllowMessageScore() {
		return isAllowMessageScore;
	}

	/** 设置允许读取短信 */
	public void setIsAllowMessageScore(Integer isAllowMessageScore) {
		this.isAllowMessageScore = isAllowMessageScore;
	}

	/** 获取允许读取定位 */
	public Integer getIsAllowLocationScore() {
		return isAllowLocationScore;
	}

	/** 设置允许读取定位 */
	public void setIsAllowLocationScore(Integer isAllowLocationScore) {
		this.isAllowLocationScore = isAllowLocationScore;
	}

	/** 获取通过客户稳定性评估-百融 */
	public Integer getBrStabilityScore() {
		return brStabilityScore;
	}

	/** 设置通过客户稳定性评估-百融 */
	public void setBrStabilityScore(Integer brStabilityScore) {
		this.brStabilityScore = brStabilityScore;
	}

	/** 获取身份证与手机号归属地一致 */
	public Integer getIdPhoneLocaleScore() {
		return idPhoneLocaleScore;
	}

	/** 设置身份证与手机号归属地一致 */
	public void setIdPhoneLocaleScore(Integer idPhoneLocaleScore) {
		this.idPhoneLocaleScore = idPhoneLocaleScore;
	}

	/** 获取手机号身份证姓名一致性 */
	public Integer getIdPhoneNameScore() {
		return idPhoneNameScore;
	}

	/** 设置手机号身份证姓名一致性 */
	public void setIdPhoneNameScore(Integer idPhoneNameScore) {
		this.idPhoneNameScore = idPhoneNameScore;
	}

	/** 获取手机号码在网时间每超过1年 */
	public Integer getPhoneOnTimeScore() {
		return phoneOnTimeScore;
	}

	/** 设置手机号码在网时间每超过1年 */
	public void setPhoneOnTimeScore(Integer phoneOnTimeScore) {
		this.phoneOnTimeScore = phoneOnTimeScore;
	}

	/** 获取白骑士 */
	public Integer getBqsScore() {
		return bqsScore;
	}

	/** 设置白骑士 */
	public void setBqsScore(Integer bqsScore) {
		this.bqsScore = bqsScore;
	}

	/** 获取手机消费金额在50-100、100-200、200 */
	public Integer getPhoneCostsScore() {
		return phoneCostsScore;
	}

	/** 设置手机消费金额在50-100、100-200、200 */
	public void setPhoneCostsScore(Integer phoneCostsScore) {
		this.phoneCostsScore = phoneCostsScore;
	}

	/** 获取是否500强 */
	public Integer getIs500Score() {
		return is500Score;
	}

	/** 设置是否500强 */
	public void setIs500Score(Integer is500Score) {
		this.is500Score = is500Score;
	}

	/** 获取教育程度 */
	public Integer getEducationlevelScore() {
		return educationlevelScore;
	}

	/** 设置教育程度 */
	public void setEducationlevelScore(Integer educationlevelScore) {
		this.educationlevelScore = educationlevelScore;
	}

	/** 获取通过学历验证的 */
	public Integer getEdudgcheckScore() {
		return edudgcheckScore;
	}

	/** 设置通过学历验证的 */
	public void setEdudgcheckScore(Integer edudgcheckScore) {
		this.edudgcheckScore = edudgcheckScore;
	}

	/** 获取学制分数 */
	public Integer getEduyearScore() {
		return eduyearScore;
	}

	/** 设置学制分数 */
	public void setEduyearScore(Integer eduyearScore) {
		this.eduyearScore = eduyearScore;
	}

	/** 获取读大学小于20岁且为本科以上 */
	public Integer getEduageScore() {
		return eduageScore;
	}

	/** 设置读大学小于20岁且为本科以上 */
	public void setEduageScore(Integer eduageScore) {
		this.eduageScore = eduageScore;
	}

	/** 获取qq、wx使用时间分数 */
	public Integer getQqwxageScore() {
		return qqwxageScore;
	}

	/** 设置qq、wx使用时间分数 */
	public void setQqwxageScore(Integer qqwxageScore) {
		this.qqwxageScore = qqwxageScore;
	}

	/** 获取qq、wx使用时间在客户20-25岁期间或30-40岁期间 */
	public Integer getQqwxinageScore() {
		return qqwxinageScore;
	}

	/** 设置qq、wx使用时间在客户20-25岁期间或30-40岁期间 */
	public void setQqwxinageScore(Integer qqwxinageScore) {
		this.qqwxinageScore = qqwxinageScore;
	}

	/** 获取紧急联系人是直系亲属且3个月内有通话记录且在通话名单中 */
	public Integer getLinkphoneScore() {
		return linkphoneScore;
	}

	/** 设置紧急联系人是直系亲属且3个月内有通话记录且在通话名单中 */
	public void setLinkphoneScore(Integer linkphoneScore) {
		this.linkphoneScore = linkphoneScore;
	}

	/** 获取单位地址得到验证的 */
	public Integer getWorkaddScore() {
		return workaddScore;
	}

	/** 设置单位地址得到验证的 */
	public void setWorkaddScore(Integer workaddScore) {
		this.workaddScore = workaddScore;
	}

	/** 获取单位地址与居住地址在同一城市 */
	public Integer getWorkaddHomeScore() {
		return workaddHomeScore;
	}

	/** 设置单位地址与居住地址在同一城市 */
	public void setWorkaddHomeScore(Integer workaddHomeScore) {
		this.workaddHomeScore = workaddHomeScore;
	}

	/** 获取工作时间一年以上5分，每增加1年加1分 */
	public Integer getWkyearScore() {
		return wkyearScore;
	}

	/** 设置工作时间一年以上5分，每增加1年加1分 */
	public void setWkyearScore(Integer wkyearScore) {
		this.wkyearScore = wkyearScore;
	}

	/** 获取收入加分 */
	public Integer getIncomeScore() {
		return incomeScore;
	}

	/** 设置收入加分 */
	public void setIncomeScore(Integer incomeScore) {
		this.incomeScore = incomeScore;
	}

	/** 获取选填社保、公积金缴纳基数 */
	public Integer getSocialSecurityScore() {
		return socialSecurityScore;
	}

	/** 设置选填社保、公积金缴纳基数 */
	public void setSocialSecurityScore(Integer socialSecurityScore) {
		this.socialSecurityScore = socialSecurityScore;
	}

	/** 获取选填社保、公积金缴纳基数 */
	public Integer getAccumulationFundScore() {
		return accumulationFundScore;
	}

	/** 设置选填社保、公积金缴纳基数 */
	public void setAccumulationFundScore(Integer accumulationFundScore) {
		this.accumulationFundScore = accumulationFundScore;
	}

	/** 获取花呗、借呗、京东白条的授信额度，三者之一跟收入一致 */
	public Integer getIncomeCompareScore() {
		return incomeCompareScore;
	}

	/** 设置花呗、借呗、京东白条的授信额度，三者之一跟收入一致 */
	public void setIncomeCompareScore(Integer incomeCompareScore) {
		this.incomeCompareScore = incomeCompareScore;
	}

	/** 获取负债/收入低于70%  */
	public Integer getDebitScore() {
		return debitScore;
	}

	/** 设置负债/收入低于70%  */
	public void setDebitScore(Integer debitScore) {
		this.debitScore = debitScore;
	}

	/** 获取年龄25 */
	public Integer getAgeScore() {
		return ageScore;
	}

	/** 设置年龄25 */
	public void setAgeScore(Integer ageScore) {
		this.ageScore = ageScore;
	}

	/** 获取男大女小 */
	public Integer getAgeManOlderScore() {
		return ageManOlderScore;
	}

	/** 设置男大女小 */
	public void setAgeManOlderScore(Integer ageManOlderScore) {
		this.ageManOlderScore = ageManOlderScore;
	}

	/** 获取年龄相差5岁 */
	public Integer getAgeDiffFiveScore() {
		return ageDiffFiveScore;
	}

	/** 设置年龄相差5岁 */
	public void setAgeDiffFiveScore(Integer ageDiffFiveScore) {
		this.ageDiffFiveScore = ageDiffFiveScore;
	}

	/** 获取已婚 */
	public Integer getMarriedScore() {
		return marriedScore;
	}

	/** 设置已婚 */
	public void setMarriedScore(Integer marriedScore) {
		this.marriedScore = marriedScore;
	}

	/** 获取学历相同 */
	public Integer getEducationEqualScore() {
		return educationEqualScore;
	}

	/** 设置学历相同 */
	public void setEducationEqualScore(Integer educationEqualScore) {
		this.educationEqualScore = educationEqualScore;
	}

	/** 获取女方学历高 */
	public Integer getWifeEducationHigherScore() {
		return wifeEducationHigherScore;
	}

	/** 设置女方学历高 */
	public void setWifeEducationHigherScore(Integer wifeEducationHigherScore) {
		this.wifeEducationHigherScore = wifeEducationHigherScore;
	}

	/** 获取女方上班 */
	public Integer getWifeWorkingScore() {
		return wifeWorkingScore;
	}

	/** 设置女方上班 */
	public void setWifeWorkingScore(Integer wifeWorkingScore) {
		this.wifeWorkingScore = wifeWorkingScore;
	}

	/** 获取家庭人口 */
	public Integer getFamilyCountScore() {
		return familyCountScore;
	}

	/** 设置家庭人口 */
	public void setFamilyCountScore(Integer familyCountScore) {
		this.familyCountScore = familyCountScore;
	}

	/** 获取农村户口 */
	public Integer getCountryOriginScore() {
		return countryOriginScore;
	}

	/** 设置农村户口 */
	public void setCountryOriginScore(Integer countryOriginScore) {
		this.countryOriginScore = countryOriginScore;
	}

	/** 获取城市户口30-45 */
	public Integer getCityOriginAge30Score() {
		return cityOriginAge30Score;
	}

	/** 设置城市户口30-45 */
	public void setCityOriginAge30Score(Integer cityOriginAge30Score) {
		this.cityOriginAge30Score = cityOriginAge30Score;
	}

	/** 获取男孩大于7岁 */
	public Integer getBoyGreatSevenScore() {
		return boyGreatSevenScore;
	}

	/** 设置男孩大于7岁 */
	public void setBoyGreatSevenScore(Integer boyGreatSevenScore) {
		this.boyGreatSevenScore = boyGreatSevenScore;
	}

	/** 获取双方生育年龄25-35 */
	public Integer getBirthAgeScore() {
		return birthAgeScore;
	}

	/** 设置双方生育年龄25-35 */
	public void setBirthAgeScore(Integer birthAgeScore) {
		this.birthAgeScore = birthAgeScore;
	}

	/** 获取两个孩子且有儿有女 */
	public Integer getBoyAndGirlScore() {
		return boyAndGirlScore;
	}

	/** 设置两个孩子且有儿有女 */
	public void setBoyAndGirlScore(Integer boyAndGirlScore) {
		this.boyAndGirlScore = boyAndGirlScore;
	}

	/** 获取两个孩子年龄差距10岁以上或5岁以内 */
	public Integer getAgeSubtractScore() {
		return ageSubtractScore;
	}

	/** 设置两个孩子年龄差距10岁以上或5岁以内 */
	public void setAgeSubtractScore(Integer ageSubtractScore) {
		this.ageSubtractScore = ageSubtractScore;
	}

	/** 获取居住地址正确 */
	public Integer getLiveAddressScore() {
		return liveAddressScore;
	}

	/** 设置居住地址正确 */
	public void setLiveAddressScore(Integer liveAddressScore) {
		this.liveAddressScore = liveAddressScore;
	}

	/** 获取房产地址正确 */
	public Integer getHouseAddressScore() {
		return houseAddressScore;
	}

	/** 设置房产地址正确 */
	public void setHouseAddressScore(Integer houseAddressScore) {
		this.houseAddressScore = houseAddressScore;
	}

	/** 获取户籍地址正确 */
	public Integer getAddressScore() {
		return addressScore;
	}

	/** 设置户籍地址正确 */
	public void setAddressScore(Integer addressScore) {
		this.addressScore = addressScore;
	}

	/** 获取居住时间在1年以上，每增加一年加一分，最高得分20分 */
	public Integer getLiveTimeScore() {
		return liveTimeScore;
	}

	/** 设置居住时间在1年以上，每增加一年加一分，最高得分20分 */
	public void setLiveTimeScore(Integer liveTimeScore) {
		this.liveTimeScore = liveTimeScore;
	}

	/** 获取保费在5000-10000 */
	public Integer getPayYearScore() {
		return payYearScore;
	}

	/** 设置保费在5000-10000 */
	public void setPayYearScore(Integer payYearScore) {
		this.payYearScore = payYearScore;
	}

	/** 获取保费支出在年收入的30%以内 */
	public Integer getPayIncomeRateScore() {
		return payIncomeRateScore;
	}

	/** 设置保费支出在年收入的30%以内 */
	public void setPayIncomeRateScore(Integer payIncomeRateScore) {
		this.payIncomeRateScore = payIncomeRateScore;
	}

	/** 获取女方学历通过验证的 */
	public Integer getGirlDegreeScore() {
		return girlDegreeScore;
	}

	/** 设置女方学历通过验证的 */
	public void setGirlDegreeScore(Integer girlDegreeScore) {
		this.girlDegreeScore = girlDegreeScore;
	}

	/** 获取运营商授权 */
	public Integer getOpAuthScore() {
		return opAuthScore;
	}

	/** 设置运营商授权 */
	public void setOpAuthScore(Integer opAuthScore) {
		this.opAuthScore = opAuthScore;
	}

	/** 获取征信授权 */
	public Integer getCreditAuthScore() {
		return creditAuthScore;
	}

	/** 设置征信授权 */
	public void setCreditAuthScore(Integer creditAuthScore) {
		this.creditAuthScore = creditAuthScore;
	}

	/** 获取支付宝授权 */
	public Integer getAlAuthScore() {
		return alAuthScore;
	}

	/** 设置支付宝授权 */
	public void setAlAuthScore(Integer alAuthScore) {
		this.alAuthScore = alAuthScore;
	}

	public Integer getTotalScores() {
		return totalScores;
	}

	public void setTotalScores(Integer totalScores) {
		this.totalScores = totalScores;
	}

	/** 获取创建时间 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/** 设置创建时间 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	
	 * @since 2017-05-13 11:48:40
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		RiskmanageScoresRecord other = (RiskmanageScoresRecord) that;
		return (this.getRsrId() == null ? other.getRsrId() == null : this.getRsrId().equals(other.getRsrId()))
			&& (this.getCreditinfoId() == null ? other.getCreditinfoId() == null : this.getCreditinfoId().equals(other.getCreditinfoId()))
			&& (this.getApplyTimeScore() == null ? other.getApplyTimeScore() == null : this.getApplyTimeScore().equals(other.getApplyTimeScore()))
			&& (this.getWantedLimitScore() == null ? other.getWantedLimitScore() == null : this.getWantedLimitScore().equals(other.getWantedLimitScore()))
			&& (this.getWantedPeriodScore() == null ? other.getWantedPeriodScore() == null : this.getWantedPeriodScore().equals(other.getWantedPeriodScore()))
			&& (this.getWantedRepayDayScore() == null ? other.getWantedRepayDayScore() == null : this.getWantedRepayDayScore().equals(other.getWantedRepayDayScore()))
			&& (this.getBuyCarAgeScore() == null ? other.getBuyCarAgeScore() == null : this.getBuyCarAgeScore().equals(other.getBuyCarAgeScore()))
			&& (this.getCarLisenceScore() == null ? other.getCarLisenceScore() == null : this.getCarLisenceScore().equals(other.getCarLisenceScore()))
			&& (this.getCarPropertyScore() == null ? other.getCarPropertyScore() == null : this.getCarPropertyScore().equals(other.getCarPropertyScore()))
			&& (this.getBuyDateAboveScore() == null ? other.getBuyDateAboveScore() == null : this.getBuyDateAboveScore().equals(other.getBuyDateAboveScore()))
			&& (this.getBuyDateAboveAddScore() == null ? other.getBuyDateAboveAddScore() == null : this.getBuyDateAboveAddScore().equals(other.getBuyDateAboveAddScore()))
			&& (this.getCountsScore() == null ? other.getCountsScore() == null : this.getCountsScore().equals(other.getCountsScore()))
			&& (this.getPriceScore() == null ? other.getPriceScore() == null : this.getPriceScore().equals(other.getPriceScore()))
			&& (this.getCarInsuranceAmountScore() == null ? other.getCarInsuranceAmountScore() == null : this.getCarInsuranceAmountScore().equals(other.getCarInsuranceAmountScore()))
			&& (this.getCarDrivenScore() == null ? other.getCarDrivenScore() == null : this.getCarDrivenScore().equals(other.getCarDrivenScore()))
			&& (this.getHouseAreaScore() == null ? other.getHouseAreaScore() == null : this.getHouseAreaScore().equals(other.getHouseAreaScore()))
			&& (this.getHouseAppraisementScore() == null ? other.getHouseAppraisementScore() == null : this.getHouseAppraisementScore().equals(other.getHouseAppraisementScore()))
			&& (this.getLoanAmountIncomeScore() == null ? other.getLoanAmountIncomeScore() == null : this.getLoanAmountIncomeScore().equals(other.getLoanAmountIncomeScore()))
			&& (this.getLengthOfResidenceScore() == null ? other.getLengthOfResidenceScore() == null : this.getLengthOfResidenceScore().equals(other.getLengthOfResidenceScore()))
			&& (this.getIsAllowContactScore() == null ? other.getIsAllowContactScore() == null : this.getIsAllowContactScore().equals(other.getIsAllowContactScore()))
			&& (this.getIsAllowRecordScore() == null ? other.getIsAllowRecordScore() == null : this.getIsAllowRecordScore().equals(other.getIsAllowRecordScore()))
			&& (this.getIsAllowMessageScore() == null ? other.getIsAllowMessageScore() == null : this.getIsAllowMessageScore().equals(other.getIsAllowMessageScore()))
			&& (this.getIsAllowLocationScore() == null ? other.getIsAllowLocationScore() == null : this.getIsAllowLocationScore().equals(other.getIsAllowLocationScore()))
			&& (this.getBrStabilityScore() == null ? other.getBrStabilityScore() == null : this.getBrStabilityScore().equals(other.getBrStabilityScore()))
			&& (this.getIdPhoneLocaleScore() == null ? other.getIdPhoneLocaleScore() == null : this.getIdPhoneLocaleScore().equals(other.getIdPhoneLocaleScore()))
			&& (this.getIdPhoneNameScore() == null ? other.getIdPhoneNameScore() == null : this.getIdPhoneNameScore().equals(other.getIdPhoneNameScore()))
			&& (this.getPhoneOnTimeScore() == null ? other.getPhoneOnTimeScore() == null : this.getPhoneOnTimeScore().equals(other.getPhoneOnTimeScore()))
			&& (this.getBqsScore() == null ? other.getBqsScore() == null : this.getBqsScore().equals(other.getBqsScore()))
			&& (this.getPhoneCostsScore() == null ? other.getPhoneCostsScore() == null : this.getPhoneCostsScore().equals(other.getPhoneCostsScore()))
			&& (this.getIs500Score() == null ? other.getIs500Score() == null : this.getIs500Score().equals(other.getIs500Score()))
			&& (this.getEducationlevelScore() == null ? other.getEducationlevelScore() == null : this.getEducationlevelScore().equals(other.getEducationlevelScore()))
			&& (this.getEdudgcheckScore() == null ? other.getEdudgcheckScore() == null : this.getEdudgcheckScore().equals(other.getEdudgcheckScore()))
			&& (this.getEduyearScore() == null ? other.getEduyearScore() == null : this.getEduyearScore().equals(other.getEduyearScore()))
			&& (this.getEduageScore() == null ? other.getEduageScore() == null : this.getEduageScore().equals(other.getEduageScore()))
			&& (this.getQqwxageScore() == null ? other.getQqwxageScore() == null : this.getQqwxageScore().equals(other.getQqwxageScore()))
			&& (this.getQqwxinageScore() == null ? other.getQqwxinageScore() == null : this.getQqwxinageScore().equals(other.getQqwxinageScore()))
			&& (this.getLinkphoneScore() == null ? other.getLinkphoneScore() == null : this.getLinkphoneScore().equals(other.getLinkphoneScore()))
			&& (this.getWorkaddScore() == null ? other.getWorkaddScore() == null : this.getWorkaddScore().equals(other.getWorkaddScore()))
			&& (this.getWorkaddHomeScore() == null ? other.getWorkaddHomeScore() == null : this.getWorkaddHomeScore().equals(other.getWorkaddHomeScore()))
			&& (this.getWkyearScore() == null ? other.getWkyearScore() == null : this.getWkyearScore().equals(other.getWkyearScore()))
			&& (this.getIncomeScore() == null ? other.getIncomeScore() == null : this.getIncomeScore().equals(other.getIncomeScore()))
			&& (this.getSocialSecurityScore() == null ? other.getSocialSecurityScore() == null : this.getSocialSecurityScore().equals(other.getSocialSecurityScore()))
			&& (this.getAccumulationFundScore() == null ? other.getAccumulationFundScore() == null : this.getAccumulationFundScore().equals(other.getAccumulationFundScore()))
			&& (this.getIncomeCompareScore() == null ? other.getIncomeCompareScore() == null : this.getIncomeCompareScore().equals(other.getIncomeCompareScore()))
			&& (this.getDebitScore() == null ? other.getDebitScore() == null : this.getDebitScore().equals(other.getDebitScore()))
			&& (this.getAgeScore() == null ? other.getAgeScore() == null : this.getAgeScore().equals(other.getAgeScore()))
			&& (this.getAgeManOlderScore() == null ? other.getAgeManOlderScore() == null : this.getAgeManOlderScore().equals(other.getAgeManOlderScore()))
			&& (this.getAgeDiffFiveScore() == null ? other.getAgeDiffFiveScore() == null : this.getAgeDiffFiveScore().equals(other.getAgeDiffFiveScore()))
			&& (this.getMarriedScore() == null ? other.getMarriedScore() == null : this.getMarriedScore().equals(other.getMarriedScore()))
			&& (this.getEducationEqualScore() == null ? other.getEducationEqualScore() == null : this.getEducationEqualScore().equals(other.getEducationEqualScore()))
			&& (this.getWifeEducationHigherScore() == null ? other.getWifeEducationHigherScore() == null : this.getWifeEducationHigherScore().equals(other.getWifeEducationHigherScore()))
			&& (this.getWifeWorkingScore() == null ? other.getWifeWorkingScore() == null : this.getWifeWorkingScore().equals(other.getWifeWorkingScore()))
			&& (this.getFamilyCountScore() == null ? other.getFamilyCountScore() == null : this.getFamilyCountScore().equals(other.getFamilyCountScore()))
			&& (this.getCountryOriginScore() == null ? other.getCountryOriginScore() == null : this.getCountryOriginScore().equals(other.getCountryOriginScore()))
			&& (this.getCityOriginAge30Score() == null ? other.getCityOriginAge30Score() == null : this.getCityOriginAge30Score().equals(other.getCityOriginAge30Score()))
			&& (this.getBoyGreatSevenScore() == null ? other.getBoyGreatSevenScore() == null : this.getBoyGreatSevenScore().equals(other.getBoyGreatSevenScore()))
			&& (this.getBirthAgeScore() == null ? other.getBirthAgeScore() == null : this.getBirthAgeScore().equals(other.getBirthAgeScore()))
			&& (this.getBoyAndGirlScore() == null ? other.getBoyAndGirlScore() == null : this.getBoyAndGirlScore().equals(other.getBoyAndGirlScore()))
			&& (this.getAgeSubtractScore() == null ? other.getAgeSubtractScore() == null : this.getAgeSubtractScore().equals(other.getAgeSubtractScore()))
			&& (this.getLiveAddressScore() == null ? other.getLiveAddressScore() == null : this.getLiveAddressScore().equals(other.getLiveAddressScore()))
			&& (this.getHouseAddressScore() == null ? other.getHouseAddressScore() == null : this.getHouseAddressScore().equals(other.getHouseAddressScore()))
			&& (this.getAddressScore() == null ? other.getAddressScore() == null : this.getAddressScore().equals(other.getAddressScore()))
			&& (this.getLiveTimeScore() == null ? other.getLiveTimeScore() == null : this.getLiveTimeScore().equals(other.getLiveTimeScore()))
			&& (this.getPayYearScore() == null ? other.getPayYearScore() == null : this.getPayYearScore().equals(other.getPayYearScore()))
			&& (this.getPayIncomeRateScore() == null ? other.getPayIncomeRateScore() == null : this.getPayIncomeRateScore().equals(other.getPayIncomeRateScore()))
			&& (this.getGirlDegreeScore() == null ? other.getGirlDegreeScore() == null : this.getGirlDegreeScore().equals(other.getGirlDegreeScore()))
			&& (this.getOpAuthScore() == null ? other.getOpAuthScore() == null : this.getOpAuthScore().equals(other.getOpAuthScore()))
			&& (this.getCreditAuthScore() == null ? other.getCreditAuthScore() == null : this.getCreditAuthScore().equals(other.getCreditAuthScore()))
			&& (this.getAlAuthScore() == null ? other.getAlAuthScore() == null : this.getAlAuthScore().equals(other.getAlAuthScore()))
			&& (this.getCreatedOn() == null ? other.getCreatedOn() == null : this.getCreatedOn().equals(other.getCreatedOn()));
	}

	/**
	
	 * @since 2017-05-13 11:48:40
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getRsrId() == null) ? 0 : getRsrId().hashCode());
		result = prime * result + ((getCreditinfoId() == null) ? 0 : getCreditinfoId().hashCode());
		result = prime * result + ((getApplyTimeScore() == null) ? 0 : getApplyTimeScore().hashCode());
		result = prime * result + ((getWantedLimitScore() == null) ? 0 : getWantedLimitScore().hashCode());
		result = prime * result + ((getWantedPeriodScore() == null) ? 0 : getWantedPeriodScore().hashCode());
		result = prime * result + ((getWantedRepayDayScore() == null) ? 0 : getWantedRepayDayScore().hashCode());
		result = prime * result + ((getBuyCarAgeScore() == null) ? 0 : getBuyCarAgeScore().hashCode());
		result = prime * result + ((getCarLisenceScore() == null) ? 0 : getCarLisenceScore().hashCode());
		result = prime * result + ((getCarPropertyScore() == null) ? 0 : getCarPropertyScore().hashCode());
		result = prime * result + ((getBuyDateAboveScore() == null) ? 0 : getBuyDateAboveScore().hashCode());
		result = prime * result + ((getBuyDateAboveAddScore() == null) ? 0 : getBuyDateAboveAddScore().hashCode());
		result = prime * result + ((getCountsScore() == null) ? 0 : getCountsScore().hashCode());
		result = prime * result + ((getPriceScore() == null) ? 0 : getPriceScore().hashCode());
		result = prime * result + ((getCarInsuranceAmountScore() == null) ? 0 : getCarInsuranceAmountScore().hashCode());
		result = prime * result + ((getCarDrivenScore() == null) ? 0 : getCarDrivenScore().hashCode());
		result = prime * result + ((getHouseAreaScore() == null) ? 0 : getHouseAreaScore().hashCode());
		result = prime * result + ((getHouseAppraisementScore() == null) ? 0 : getHouseAppraisementScore().hashCode());
		result = prime * result + ((getLoanAmountIncomeScore() == null) ? 0 : getLoanAmountIncomeScore().hashCode());
		result = prime * result + ((getLengthOfResidenceScore() == null) ? 0 : getLengthOfResidenceScore().hashCode());
		result = prime * result + ((getIsAllowContactScore() == null) ? 0 : getIsAllowContactScore().hashCode());
		result = prime * result + ((getIsAllowRecordScore() == null) ? 0 : getIsAllowRecordScore().hashCode());
		result = prime * result + ((getIsAllowMessageScore() == null) ? 0 : getIsAllowMessageScore().hashCode());
		result = prime * result + ((getIsAllowLocationScore() == null) ? 0 : getIsAllowLocationScore().hashCode());
		result = prime * result + ((getBrStabilityScore() == null) ? 0 : getBrStabilityScore().hashCode());
		result = prime * result + ((getIdPhoneLocaleScore() == null) ? 0 : getIdPhoneLocaleScore().hashCode());
		result = prime * result + ((getIdPhoneNameScore() == null) ? 0 : getIdPhoneNameScore().hashCode());
		result = prime * result + ((getPhoneOnTimeScore() == null) ? 0 : getPhoneOnTimeScore().hashCode());
		result = prime * result + ((getBqsScore() == null) ? 0 : getBqsScore().hashCode());
		result = prime * result + ((getPhoneCostsScore() == null) ? 0 : getPhoneCostsScore().hashCode());
		result = prime * result + ((getIs500Score() == null) ? 0 : getIs500Score().hashCode());
		result = prime * result + ((getEducationlevelScore() == null) ? 0 : getEducationlevelScore().hashCode());
		result = prime * result + ((getEdudgcheckScore() == null) ? 0 : getEdudgcheckScore().hashCode());
		result = prime * result + ((getEduyearScore() == null) ? 0 : getEduyearScore().hashCode());
		result = prime * result + ((getEduageScore() == null) ? 0 : getEduageScore().hashCode());
		result = prime * result + ((getQqwxageScore() == null) ? 0 : getQqwxageScore().hashCode());
		result = prime * result + ((getQqwxinageScore() == null) ? 0 : getQqwxinageScore().hashCode());
		result = prime * result + ((getLinkphoneScore() == null) ? 0 : getLinkphoneScore().hashCode());
		result = prime * result + ((getWorkaddScore() == null) ? 0 : getWorkaddScore().hashCode());
		result = prime * result + ((getWorkaddHomeScore() == null) ? 0 : getWorkaddHomeScore().hashCode());
		result = prime * result + ((getWkyearScore() == null) ? 0 : getWkyearScore().hashCode());
		result = prime * result + ((getIncomeScore() == null) ? 0 : getIncomeScore().hashCode());
		result = prime * result + ((getSocialSecurityScore() == null) ? 0 : getSocialSecurityScore().hashCode());
		result = prime * result + ((getAccumulationFundScore() == null) ? 0 : getAccumulationFundScore().hashCode());
		result = prime * result + ((getIncomeCompareScore() == null) ? 0 : getIncomeCompareScore().hashCode());
		result = prime * result + ((getDebitScore() == null) ? 0 : getDebitScore().hashCode());
		result = prime * result + ((getAgeScore() == null) ? 0 : getAgeScore().hashCode());
		result = prime * result + ((getAgeManOlderScore() == null) ? 0 : getAgeManOlderScore().hashCode());
		result = prime * result + ((getAgeDiffFiveScore() == null) ? 0 : getAgeDiffFiveScore().hashCode());
		result = prime * result + ((getMarriedScore() == null) ? 0 : getMarriedScore().hashCode());
		result = prime * result + ((getEducationEqualScore() == null) ? 0 : getEducationEqualScore().hashCode());
		result = prime * result + ((getWifeEducationHigherScore() == null) ? 0 : getWifeEducationHigherScore().hashCode());
		result = prime * result + ((getWifeWorkingScore() == null) ? 0 : getWifeWorkingScore().hashCode());
		result = prime * result + ((getFamilyCountScore() == null) ? 0 : getFamilyCountScore().hashCode());
		result = prime * result + ((getCountryOriginScore() == null) ? 0 : getCountryOriginScore().hashCode());
		result = prime * result + ((getCityOriginAge30Score() == null) ? 0 : getCityOriginAge30Score().hashCode());
		result = prime * result + ((getBoyGreatSevenScore() == null) ? 0 : getBoyGreatSevenScore().hashCode());
		result = prime * result + ((getBirthAgeScore() == null) ? 0 : getBirthAgeScore().hashCode());
		result = prime * result + ((getBoyAndGirlScore() == null) ? 0 : getBoyAndGirlScore().hashCode());
		result = prime * result + ((getAgeSubtractScore() == null) ? 0 : getAgeSubtractScore().hashCode());
		result = prime * result + ((getLiveAddressScore() == null) ? 0 : getLiveAddressScore().hashCode());
		result = prime * result + ((getHouseAddressScore() == null) ? 0 : getHouseAddressScore().hashCode());
		result = prime * result + ((getAddressScore() == null) ? 0 : getAddressScore().hashCode());
		result = prime * result + ((getLiveTimeScore() == null) ? 0 : getLiveTimeScore().hashCode());
		result = prime * result + ((getPayYearScore() == null) ? 0 : getPayYearScore().hashCode());
		result = prime * result + ((getPayIncomeRateScore() == null) ? 0 : getPayIncomeRateScore().hashCode());
		result = prime * result + ((getGirlDegreeScore() == null) ? 0 : getGirlDegreeScore().hashCode());
		result = prime * result + ((getOpAuthScore() == null) ? 0 : getOpAuthScore().hashCode());
		result = prime * result + ((getCreditAuthScore() == null) ? 0 : getCreditAuthScore().hashCode());
		result = prime * result + ((getAlAuthScore() == null) ? 0 : getAlAuthScore().hashCode());
		result = prime * result + ((getCreatedOn() == null) ? 0 : getCreatedOn().hashCode());
		return result;
	}
}