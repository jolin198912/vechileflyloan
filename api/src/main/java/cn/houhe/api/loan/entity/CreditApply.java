package cn.houhe.api.loan.entity;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体类 - 表：credit_apply
 * @since 2017-06-05 10:38:33
 */
@Alias("CreditApply")
public class CreditApply implements Serializable {
	/** ca_id -- id 主键 */
	private Integer caId;

	/** name -- 姓名 */
	@Length(max=10,message="loan.CreditApply.name.Length")
	private String name;

	/** member_id -- 用户id */
	@NotNull(message="loan.CreditApply.memberId.NotNull")
	private Integer memberId;

	/** id_card -- 身份证号码 */
	@NotEmpty(message="loan.CreditApply.idCard.NotEmpty")
	@Length(max=18,message="loan.CreditApply.idCard.Length")
	private String idCard;

	/** couple_card -- 配偶身份证号码 */
	@NotEmpty(message="loan.CreditApply.coupleCard.NotEmpty")
	@Length(max=18,message="loan.CreditApply.coupleCard.Length")
	private String coupleCard;

	/** couple_mobile -- 配偶手机号码 */
	@Length(max=20,message="loan.CreditApply.coupleMobile.Length")
	private String coupleMobile;

	/** couple_name -- 配偶姓名 */
	@Length(max=10,message="loan.CreditApply.coupleName.Length")
	private String coupleName;

	/** couple_education -- 配偶文化程度(0其他1高中及以下2大专3本科4硕士5博士) */
	private Byte coupleEducation;

	/** couple_job -- 配偶职业(0照顾孩子，1工作，2个体户，3务农) */
	private Byte coupleJob;

	/** sex -- 性别0男1女 */
	@NotNull(message="loan.CreditApply.sex.NotNull")
	private Byte sex;

	/** birthday -- 生日 */
	private Date birthday;

	/** origin_type -- 0城镇户口1农村户口 */
	@NotNull(message="loan.CreditApply.originType.NotNull")
	private Byte originType;

	/** domicile_province -- 居住地址省份 */
	@NotEmpty(message="loan.CreditApply.domicileProvince.NotEmpty")
	@Length(max=10,message="loan.CreditApply.domicileProvince.Length")
	private String domicileProvince;

	/** domicile_detail -- 居住地址 */
	@Length(max=100,message="loan.CreditApply.domicileDetail.Length")
	private String domicileDetail;

	/** domicile_time -- 居住时间 */
	private Byte domicileTime;

	/** nation -- 民族 */
	@Length(max=10,message="loan.CreditApply.nation.Length")
	private String nation;

	/** education -- 文化程度(0其他1高中及以下2大专3本科4硕士5博士) */
	private Byte education;

	/** high_edu_starttime -- 最高教育开始时间 */
	private Date highEduStarttime;

	/** high_edu_endtime -- 最高教育结束时间 */
	private Date highEduEndtime;

	/** company_name -- 单位名称 */
	@Length(max=100,message="loan.CreditApply.companyName.Length")
	private String companyName;

	/** com_bus_time_length -- 公司经营时长（年） */
	@NotNull(message="loan.CreditApply.comBusTimeLength.NotNull")
	private Short comBusTimeLength;

	/** is_company_fivehun -- 是否是500强0否1是 */
	@NotNull(message="loan.CreditApply.isCompanyFivehun.NotNull")
	private Byte isCompanyFivehun;

	/** is_allow_contact -- 是否允许读取通讯录0否1是 */
	@NotNull(message="loan.CreditApply.isAllowContact.NotNull")
	private Byte isAllowContact;

	/** is_allow_record -- 是否允许读取通话记录0否1是 */
	@NotNull(message="loan.CreditApply.isAllowRecord.NotNull")
	private Byte isAllowRecord;

	/** is_allow_message -- 允许读取短信0否1是 */
	private Byte isAllowMessage;

	/** is_allow_location -- 允许读取定位0否1是 */
	@NotNull(message="loan.CreditApply.isAllowLocation.NotNull")
	private Byte isAllowLocation;

	/** job -- 职务（0普通员工，1基层管理，2中层管理，3高层管理） */
	private Byte job;

	/** industry -- 行业（互联网，教育等） */
	@Length(max=50,message="loan.CreditApply.industry.Length")
	private String industry;

	/** work_place -- 单位地址 */
	@Length(max=200,message="loan.CreditApply.workPlace.Length")
	private String workPlace;

	/** work_experience -- 工作经验 */
	@Length(max=50,message="loan.CreditApply.workExperience.Length")
	private String workExperience;

	/** wanted_limit -- 期望额度 */
	private Integer wantedLimit;

	/** wanted_period -- 期望还款期限 */
	private Byte wantedPeriod;

	/** wanted_repay_day -- 期望还款日期 */
	private Byte wantedRepayDay;

	/** marriage -- 婚姻状态(0单身，1离异，2丧偶，3已婚) */
	@NotNull(message="loan.CreditApply.marriage.NotNull")
	private Byte marriage;

	/** child_amount -- 子女个数 */
	@NotNull(message="loan.CreditApply.childAmount.NotNull")
	private Byte childAmount;

	/** family_amount -- 家庭人口(0：2人，1：3人，2：4人，3：5人，4：5人以上) */
	@NotNull(message="loan.CreditApply.familyAmount.NotNull")
	private Byte familyAmount;

	/** apply_time -- 申请时间 */
	private Date applyTime;

	/** year_pay -- 保险年缴纳费 */
	@NotNull(message="loan.CreditApply.yearPay.NotNull")
	private BigDecimal yearPay;

	/** qq -- QQ号 */
	@Length(max=20,message="loan.CreditApply.qq.Length")
	private String qq;

	/** qq_age -- qq年龄 */
	@NotNull(message="loan.CreditApply.qqAge.NotNull")
	private Short qqAge;

	/** wx_age -- 微信年龄 */
	@NotNull(message="loan.CreditApply.wxAge.NotNull")
	private Short wxAge;

	/** wx -- 微信号 */
	@Length(max=50,message="loan.CreditApply.wx.Length")
	private String wx;

	/** fengkong_state -- 风控状态0未经过风控评估1已经过风控评估 */
	@NotNull(message="loan.CreditApply.fengkongState.NotNull")
	private Byte fengkongState;

	/** apply_state -- 审核状态（0填写资料申请中1提交完资料审批中2初审通过3初审不通过4终审通过5终审不通过6自动审批通过7自动审批不通过） */
	@NotNull(message="loan.CreditApply.applyState.NotNull")
	private Byte applyState;

	/** apply_step -- 申请步骤 */
	@NotNull(message="loan.CreditApply.applyStep.NotNull")
	private Byte applyStep;

	/** createdon --  */
	@NotNull(message="loan.CreditApply.createdon.NotNull")
	private Date createdon;

	/** remark -- 备注 */
	@Length(max=30,message="loan.CreditApply.remark.Length")
	private String remark;

	/** buy_type -- 买房类型0按揭1全款 */
	@NotNull(message="loan.CreditApply.buyType.NotNull")
	private Byte buyType;

	/** house_type -- 0其他1租房2亲属住房3自建房4商品房 */
	@NotNull(message="loan.CreditApply.houseType.NotNull")
	private Byte houseType;

	/** house_caty -- 住宅类型（0普通住宅，1别墅） */
	@NotNull(message="loan.CreditApply.houseCaty.NotNull")
	private Byte houseCaty;

	/** house_big -- 房子面积 */
	@NotNull(message="loan.CreditApply.houseBig.NotNull")
	private Short houseBig;

	/** loan_amount -- 每月按揭金额 */
	@NotNull(message="loan.CreditApply.loanAmount.NotNull")
	private BigDecimal loanAmount;

	/** city -- 所在城市 */
	@Length(max=50,message="loan.CreditApply.city.Length")
	private String city;

	/** area -- 所在小区 */
	@Length(max=50,message="loan.CreditApply.area.Length")
	private String area;

	/** income -- 每月收入 */
	@NotNull(message="loan.CreditApply.income.NotNull")
	private BigDecimal income;

	/** social_security -- 社保缴纳基数0：5000以下，1：5000-10000，2：10000以上 */
	@NotNull(message="loan.CreditApply.socialSecurity.NotNull")
	private Byte socialSecurity;

	/** accumulation_fund -- 公积金缴纳基数0：5000以下，1：5000-10000，2：10000以上 */
	@NotNull(message="loan.CreditApply.accumulationFund.NotNull")
	private Byte accumulationFund;

	/** jingdong_quto -- 京东白条额度 */
	@NotNull(message="loan.CreditApply.jingdongQuto.NotNull")
	private BigDecimal jingdongQuto;

	/** mayijieb_quto -- 蚂蚁借呗额度 */
	@NotNull(message="loan.CreditApply.mayijiebQuto.NotNull")
	private BigDecimal mayijiebQuto;

	/** huabei_quto -- 蚂蚁花呗额度 */
	@NotNull(message="loan.CreditApply.huabeiQuto.NotNull")
	private BigDecimal huabeiQuto;

	/** debit -- 负债 */
	@NotNull(message="loan.CreditApply.debit.NotNull")
	private BigDecimal debit;

	/** car_number -- 车牌号 */
	@Length(max=10,message="loan.CreditApply.carNumber.Length")
	private String carNumber;

	/** car_brand -- 车辆品牌 */
	@Length(max=20,message="loan.CreditApply.carBrand.Length")
	private String carBrand;

	/** car_lisence -- 驾照登记地址 */
	@Length(max=100,message="loan.CreditApply.carLisence.Length")
	private String carLisence;

	/** car_property -- 车辆性质（非运营0运营1） */
	@NotNull(message="loan.CreditApply.carProperty.NotNull")
	private Byte carProperty;

	/** car_driven -- 驾龄 */
	@NotNull(message="loan.CreditApply.carDriven.NotNull")
	private Byte carDriven;

	/** car_owner -- 车辆所有人 */
	@Length(max=20,message="loan.CreditApply.carOwner.Length")
	private String carOwner;

	/** car_code -- 车辆识别代码 */
	@Length(max=20,message="loan.CreditApply.carCode.Length")
	private String carCode;

	/** buy_date -- 购买日期 */
	private Date buyDate;

	/** counts -- 第几辆车（0第一辆，1第二辆，2第三辆，3第四辆及以上） */
	@NotNull(message="loan.CreditApply.counts.NotNull")
	private Short counts;

	/** price -- 购买价格 */
	@NotNull(message="loan.CreditApply.price.NotNull")
	private BigDecimal price;

	/** car_insurance_amount -- 车保费金额 */
	@NotNull(message="loan.CreditApply.carInsuranceAmount.NotNull")
	private BigDecimal carInsuranceAmount;

	/** address -- 户籍地址 */
	@Length(max=200,message="loan.CreditApply.address.Length")
	private String address;

	/** native_place -- 籍贯 */
	@Length(max=10,message="loan.CreditApply.nativePlace.Length")
	private String nativePlace;

	private static final long serialVersionUID = 1L;

	/** 获取id 主键 */
	public Integer getCaId() {
		return caId;
	}

	/** 设置id 主键 */
	public void setCaId(Integer caId) {
		this.caId = caId;
	}

	/** 获取姓名 */
	public String getName() {
		return name;
	}

	/** 设置姓名 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/** 获取用户id */
	public Integer getMemberId() {
		return memberId;
	}

	/** 设置用户id */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/** 获取身份证号码 */
	public String getIdCard() {
		return idCard;
	}

	/** 设置身份证号码 */
	public void setIdCard(String idCard) {
		this.idCard = idCard == null ? null : idCard.trim();
	}

	/** 获取配偶身份证号码 */
	public String getCoupleCard() {
		return coupleCard;
	}

	/** 设置配偶身份证号码 */
	public void setCoupleCard(String coupleCard) {
		this.coupleCard = coupleCard == null ? null : coupleCard.trim();
	}

	/** 获取配偶手机号码 */
	public String getCoupleMobile() {
		return coupleMobile;
	}

	/** 设置配偶手机号码 */
	public void setCoupleMobile(String coupleMobile) {
		this.coupleMobile = coupleMobile == null ? null : coupleMobile.trim();
	}

	/** 获取配偶姓名 */
	public String getCoupleName() {
		return coupleName;
	}

	/** 设置配偶姓名 */
	public void setCoupleName(String coupleName) {
		this.coupleName = coupleName == null ? null : coupleName.trim();
	}

	/** 获取配偶文化程度(0其他1高中及以下2大专3本科4硕士5博士) */
	public Byte getCoupleEducation() {
		return coupleEducation;
	}

	/** 设置配偶文化程度(0其他1高中及以下2大专3本科4硕士5博士) */
	public void setCoupleEducation(Byte coupleEducation) {
		this.coupleEducation = coupleEducation;
	}

	/** 获取配偶职业(0照顾孩子，1工作，2个体户，3务农) */
	public Byte getCoupleJob() {
		return coupleJob;
	}

	/** 设置配偶职业(0照顾孩子，1工作，2个体户，3务农) */
	public void setCoupleJob(Byte coupleJob) {
		this.coupleJob = coupleJob;
	}

	/** 获取性别0男1女 */
	public Byte getSex() {
		return sex;
	}

	/** 设置性别0男1女 */
	public void setSex(Byte sex) {
		this.sex = sex;
	}

	/** 获取生日 */
	public Date getBirthday() {
		return birthday;
	}

	/** 设置生日 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/** 获取0城镇户口1农村户口 */
	public Byte getOriginType() {
		return originType;
	}

	/** 设置0城镇户口1农村户口 */
	public void setOriginType(Byte originType) {
		this.originType = originType;
	}

	/** 获取居住地址省份 */
	public String getDomicileProvince() {
		return domicileProvince;
	}

	/** 设置居住地址省份 */
	public void setDomicileProvince(String domicileProvince) {
		this.domicileProvince = domicileProvince == null ? null : domicileProvince.trim();
	}

	/** 获取居住地址 */
	public String getDomicileDetail() {
		return domicileDetail;
	}

	/** 设置居住地址 */
	public void setDomicileDetail(String domicileDetail) {
		this.domicileDetail = domicileDetail == null ? null : domicileDetail.trim();
	}

	/** 获取居住时间 */
	public Byte getDomicileTime() {
		return domicileTime;
	}

	/** 设置居住时间 */
	public void setDomicileTime(Byte domicileTime) {
		this.domicileTime = domicileTime;
	}

	/** 获取民族 */
	public String getNation() {
		return nation;
	}

	/** 设置民族 */
	public void setNation(String nation) {
		this.nation = nation == null ? null : nation.trim();
	}

	/** 获取文化程度(0其他1高中及以下2大专3本科4硕士5博士) */
	public Byte getEducation() {
		return education;
	}

	/** 设置文化程度(0其他1高中及以下2大专3本科4硕士5博士) */
	public void setEducation(Byte education) {
		this.education = education;
	}

	/** 获取最高教育开始时间 */
	public Date getHighEduStarttime() {
		return highEduStarttime;
	}

	/** 设置最高教育开始时间 */
	public void setHighEduStarttime(Date highEduStarttime) {
		this.highEduStarttime = highEduStarttime;
	}

	/** 获取最高教育结束时间 */
	public Date getHighEduEndtime() {
		return highEduEndtime;
	}

	/** 设置最高教育结束时间 */
	public void setHighEduEndtime(Date highEduEndtime) {
		this.highEduEndtime = highEduEndtime;
	}

	/** 获取单位名称 */
	public String getCompanyName() {
		return companyName;
	}

	/** 设置单位名称 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName == null ? null : companyName.trim();
	}

	/** 获取公司经营时长（年） */
	public Short getComBusTimeLength() {
		return comBusTimeLength;
	}

	/** 设置公司经营时长（年） */
	public void setComBusTimeLength(Short comBusTimeLength) {
		this.comBusTimeLength = comBusTimeLength;
	}

	/** 获取是否是500强0否1是 */
	public Byte getIsCompanyFivehun() {
		return isCompanyFivehun;
	}

	/** 设置是否是500强0否1是 */
	public void setIsCompanyFivehun(Byte isCompanyFivehun) {
		this.isCompanyFivehun = isCompanyFivehun;
	}

	/** 获取是否允许读取通讯录0否1是 */
	public Byte getIsAllowContact() {
		return isAllowContact;
	}

	/** 设置是否允许读取通讯录0否1是 */
	public void setIsAllowContact(Byte isAllowContact) {
		this.isAllowContact = isAllowContact;
	}

	/** 获取是否允许读取通话记录0否1是 */
	public Byte getIsAllowRecord() {
		return isAllowRecord;
	}

	/** 设置是否允许读取通话记录0否1是 */
	public void setIsAllowRecord(Byte isAllowRecord) {
		this.isAllowRecord = isAllowRecord;
	}

	/** 获取允许读取短信0否1是 */
	public Byte getIsAllowMessage() {
		return isAllowMessage;
	}

	/** 设置允许读取短信0否1是 */
	public void setIsAllowMessage(Byte isAllowMessage) {
		this.isAllowMessage = isAllowMessage;
	}

	/** 获取允许读取定位0否1是 */
	public Byte getIsAllowLocation() {
		return isAllowLocation;
	}

	/** 设置允许读取定位0否1是 */
	public void setIsAllowLocation(Byte isAllowLocation) {
		this.isAllowLocation = isAllowLocation;
	}

	/** 获取职务（0普通员工，1基层管理，2中层管理，3高层管理） */
	public Byte getJob() {
		return job;
	}

	/** 设置职务（0普通员工，1基层管理，2中层管理，3高层管理） */
	public void setJob(Byte job) {
		this.job = job;
	}

	/** 获取行业（互联网，教育等） */
	public String getIndustry() {
		return industry;
	}

	/** 设置行业（互联网，教育等） */
	public void setIndustry(String industry) {
		this.industry = industry == null ? null : industry.trim();
	}

	/** 获取单位地址 */
	public String getWorkPlace() {
		return workPlace;
	}

	/** 设置单位地址 */
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace == null ? null : workPlace.trim();
	}

	/** 获取工作经验 */
	public String getWorkExperience() {
		return workExperience;
	}

	/** 设置工作经验 */
	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience == null ? null : workExperience.trim();
	}

	/** 获取期望额度 */
	public Integer getWantedLimit() {
		return wantedLimit;
	}

	/** 设置期望额度 */
	public void setWantedLimit(Integer wantedLimit) {
		this.wantedLimit = wantedLimit;
	}

	/** 获取期望还款期限 */
	public Byte getWantedPeriod() {
		return wantedPeriod;
	}

	/** 设置期望还款期限 */
	public void setWantedPeriod(Byte wantedPeriod) {
		this.wantedPeriod = wantedPeriod;
	}

	/** 获取期望还款日期 */
	public Byte getWantedRepayDay() {
		return wantedRepayDay;
	}

	/** 设置期望还款日期 */
	public void setWantedRepayDay(Byte wantedRepayDay) {
		this.wantedRepayDay = wantedRepayDay;
	}

	/** 获取婚姻状态(0单身，1离异，2丧偶，3已婚) */
	public Byte getMarriage() {
		return marriage;
	}

	/** 设置婚姻状态(0单身，1离异，2丧偶，3已婚) */
	public void setMarriage(Byte marriage) {
		this.marriage = marriage;
	}

	/** 获取子女个数 */
	public Byte getChildAmount() {
		return childAmount;
	}

	/** 设置子女个数 */
	public void setChildAmount(Byte childAmount) {
		this.childAmount = childAmount;
	}

	/** 获取家庭人口(0：2人，1：3人，2：4人，3：5人，4：5人以上) */
	public Byte getFamilyAmount() {
		return familyAmount;
	}

	/** 设置家庭人口(0：2人，1：3人，2：4人，3：5人，4：5人以上) */
	public void setFamilyAmount(Byte familyAmount) {
		this.familyAmount = familyAmount;
	}

	/** 获取申请时间 */
	public Date getApplyTime() {
		return applyTime;
	}

	/** 设置申请时间 */
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	/** 获取保险年缴纳费 */
	public BigDecimal getYearPay() {
		return yearPay;
	}

	/** 设置保险年缴纳费 */
	public void setYearPay(BigDecimal yearPay) {
		this.yearPay = yearPay;
	}

	/** 获取QQ号 */
	public String getQq() {
		return qq;
	}

	/** 设置QQ号 */
	public void setQq(String qq) {
		this.qq = qq == null ? null : qq.trim();
	}

	/** 获取qq年龄 */
	public Short getQqAge() {
		return qqAge;
	}

	/** 设置qq年龄 */
	public void setQqAge(Short qqAge) {
		this.qqAge = qqAge;
	}

	/** 获取微信年龄 */
	public Short getWxAge() {
		return wxAge;
	}

	/** 设置微信年龄 */
	public void setWxAge(Short wxAge) {
		this.wxAge = wxAge;
	}

	/** 获取微信号 */
	public String getWx() {
		return wx;
	}

	/** 设置微信号 */
	public void setWx(String wx) {
		this.wx = wx == null ? null : wx.trim();
	}

	/** 获取风控状态0未经过风控评估1已经过风控评估 */
	public Byte getFengkongState() {
		return fengkongState;
	}

	/** 设置风控状态0未经过风控评估1已经过风控评估 */
	public void setFengkongState(Byte fengkongState) {
		this.fengkongState = fengkongState;
	}

	/** 获取审核状态（0填写资料申请中1提交完资料审批中2初审通过3初审不通过4终审通过5终审不通过6自动审批通过7自动审批不通过） */
	public Byte getApplyState() {
		return applyState;
	}

	/** 设置审核状态（0填写资料申请中1提交完资料审批中2初审通过3初审不通过4终审通过5终审不通过6自动审批通过7自动审批不通过） */
	public void setApplyState(Byte applyState) {
		this.applyState = applyState;
	}

	/** 获取申请步骤 */
	public Byte getApplyStep() {
		return applyStep;
	}

	/** 设置申请步骤 */
	public void setApplyStep(Byte applyStep) {
		this.applyStep = applyStep;
	}

	/** 获取 */
	public Date getCreatedon() {
		return createdon;
	}

	/** 设置 */
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	/** 获取备注 */
	public String getRemark() {
		return remark;
	}

	/** 设置备注 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/** 获取买房类型0按揭1全款 */
	public Byte getBuyType() {
		return buyType;
	}

	/** 设置买房类型0按揭1全款 */
	public void setBuyType(Byte buyType) {
		this.buyType = buyType;
	}

	/** 获取0其他1租房2亲属住房3自建房4商品房 */
	public Byte getHouseType() {
		return houseType;
	}

	/** 设置0其他1租房2亲属住房3自建房4商品房 */
	public void setHouseType(Byte houseType) {
		this.houseType = houseType;
	}

	/** 获取住宅类型（0普通住宅，1别墅） */
	public Byte getHouseCaty() {
		return houseCaty;
	}

	/** 设置住宅类型（0普通住宅，1别墅） */
	public void setHouseCaty(Byte houseCaty) {
		this.houseCaty = houseCaty;
	}

	/** 获取房子面积 */
	public Short getHouseBig() {
		return houseBig;
	}

	/** 设置房子面积 */
	public void setHouseBig(Short houseBig) {
		this.houseBig = houseBig;
	}

	/** 获取每月按揭金额 */
	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	/** 设置每月按揭金额 */
	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	/** 获取所在城市 */
	public String getCity() {
		return city;
	}

	/** 设置所在城市 */
	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	/** 获取所在小区 */
	public String getArea() {
		return area;
	}

	/** 设置所在小区 */
	public void setArea(String area) {
		this.area = area == null ? null : area.trim();
	}

	/** 获取每月收入 */
	public BigDecimal getIncome() {
		return income;
	}

	/** 设置每月收入 */
	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	/** 获取社保缴纳基数0：5000以下，1：5000-10000，2：10000以上 */
	public Byte getSocialSecurity() {
		return socialSecurity;
	}

	/** 设置社保缴纳基数0：5000以下，1：5000-10000，2：10000以上 */
	public void setSocialSecurity(Byte socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

	/** 获取公积金缴纳基数0：5000以下，1：5000-10000，2：10000以上 */
	public Byte getAccumulationFund() {
		return accumulationFund;
	}

	/** 设置公积金缴纳基数0：5000以下，1：5000-10000，2：10000以上 */
	public void setAccumulationFund(Byte accumulationFund) {
		this.accumulationFund = accumulationFund;
	}

	/** 获取京东白条额度 */
	public BigDecimal getJingdongQuto() {
		return jingdongQuto;
	}

	/** 设置京东白条额度 */
	public void setJingdongQuto(BigDecimal jingdongQuto) {
		this.jingdongQuto = jingdongQuto;
	}

	/** 获取蚂蚁借呗额度 */
	public BigDecimal getMayijiebQuto() {
		return mayijiebQuto;
	}

	/** 设置蚂蚁借呗额度 */
	public void setMayijiebQuto(BigDecimal mayijiebQuto) {
		this.mayijiebQuto = mayijiebQuto;
	}

	/** 获取蚂蚁花呗额度 */
	public BigDecimal getHuabeiQuto() {
		return huabeiQuto;
	}

	/** 设置蚂蚁花呗额度 */
	public void setHuabeiQuto(BigDecimal huabeiQuto) {
		this.huabeiQuto = huabeiQuto;
	}

	/** 获取负债 */
	public BigDecimal getDebit() {
		return debit;
	}

	/** 设置负债 */
	public void setDebit(BigDecimal debit) {
		this.debit = debit;
	}

	/** 获取车牌号 */
	public String getCarNumber() {
		return carNumber;
	}

	/** 设置车牌号 */
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber == null ? null : carNumber.trim();
	}

	/** 获取车辆品牌 */
	public String getCarBrand() {
		return carBrand;
	}

	/** 设置车辆品牌 */
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand == null ? null : carBrand.trim();
	}

	/** 获取驾照登记地址 */
	public String getCarLisence() {
		return carLisence;
	}

	/** 设置驾照登记地址 */
	public void setCarLisence(String carLisence) {
		this.carLisence = carLisence == null ? null : carLisence.trim();
	}

	/** 获取车辆性质（非运营0运营1） */
	public Byte getCarProperty() {
		return carProperty;
	}

	/** 设置车辆性质（非运营0运营1） */
	public void setCarProperty(Byte carProperty) {
		this.carProperty = carProperty;
	}

	/** 获取驾龄 */
	public Byte getCarDriven() {
		return carDriven;
	}

	/** 设置驾龄 */
	public void setCarDriven(Byte carDriven) {
		this.carDriven = carDriven;
	}

	/** 获取车辆所有人 */
	public String getCarOwner() {
		return carOwner;
	}

	/** 设置车辆所有人 */
	public void setCarOwner(String carOwner) {
		this.carOwner = carOwner == null ? null : carOwner.trim();
	}

	/** 获取车辆识别代码 */
	public String getCarCode() {
		return carCode;
	}

	/** 设置车辆识别代码 */
	public void setCarCode(String carCode) {
		this.carCode = carCode == null ? null : carCode.trim();
	}

	/** 获取购买日期 */
	public Date getBuyDate() {
		return buyDate;
	}

	/** 设置购买日期 */
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	/** 获取第几辆车（0第一辆，1第二辆，2第三辆，3第四辆及以上） */
	public Short getCounts() {
		return counts;
	}

	/** 设置第几辆车（0第一辆，1第二辆，2第三辆，3第四辆及以上） */
	public void setCounts(Short counts) {
		this.counts = counts;
	}

	/** 获取购买价格 */
	public BigDecimal getPrice() {
		return price;
	}

	/** 设置购买价格 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/** 获取车保费金额 */
	public BigDecimal getCarInsuranceAmount() {
		return carInsuranceAmount;
	}

	/** 设置车保费金额 */
	public void setCarInsuranceAmount(BigDecimal carInsuranceAmount) {
		this.carInsuranceAmount = carInsuranceAmount;
	}

	/** 获取户籍地址 */
	public String getAddress() {
		return address;
	}

	/** 设置户籍地址 */
	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	/** 获取籍贯 */
	public String getNativePlace() {
		return nativePlace;
	}

	/** 设置籍贯 */
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace == null ? null : nativePlace.trim();
	}

	/**
	
	 * @since 2017-06-05 10:38:33
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
		CreditApply other = (CreditApply) that;
		return (this.getCaId() == null ? other.getCaId() == null : this.getCaId().equals(other.getCaId()))
			&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
			&& (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
			&& (this.getIdCard() == null ? other.getIdCard() == null : this.getIdCard().equals(other.getIdCard()))
			&& (this.getCoupleCard() == null ? other.getCoupleCard() == null : this.getCoupleCard().equals(other.getCoupleCard()))
			&& (this.getCoupleMobile() == null ? other.getCoupleMobile() == null : this.getCoupleMobile().equals(other.getCoupleMobile()))
			&& (this.getCoupleName() == null ? other.getCoupleName() == null : this.getCoupleName().equals(other.getCoupleName()))
			&& (this.getCoupleEducation() == null ? other.getCoupleEducation() == null : this.getCoupleEducation().equals(other.getCoupleEducation()))
			&& (this.getCoupleJob() == null ? other.getCoupleJob() == null : this.getCoupleJob().equals(other.getCoupleJob()))
			&& (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
			&& (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
			&& (this.getOriginType() == null ? other.getOriginType() == null : this.getOriginType().equals(other.getOriginType()))
			&& (this.getDomicileProvince() == null ? other.getDomicileProvince() == null : this.getDomicileProvince().equals(other.getDomicileProvince()))
			&& (this.getDomicileDetail() == null ? other.getDomicileDetail() == null : this.getDomicileDetail().equals(other.getDomicileDetail()))
			&& (this.getDomicileTime() == null ? other.getDomicileTime() == null : this.getDomicileTime().equals(other.getDomicileTime()))
			&& (this.getNation() == null ? other.getNation() == null : this.getNation().equals(other.getNation()))
			&& (this.getEducation() == null ? other.getEducation() == null : this.getEducation().equals(other.getEducation()))
			&& (this.getHighEduStarttime() == null ? other.getHighEduStarttime() == null : this.getHighEduStarttime().equals(other.getHighEduStarttime()))
			&& (this.getHighEduEndtime() == null ? other.getHighEduEndtime() == null : this.getHighEduEndtime().equals(other.getHighEduEndtime()))
			&& (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
			&& (this.getComBusTimeLength() == null ? other.getComBusTimeLength() == null : this.getComBusTimeLength().equals(other.getComBusTimeLength()))
			&& (this.getIsCompanyFivehun() == null ? other.getIsCompanyFivehun() == null : this.getIsCompanyFivehun().equals(other.getIsCompanyFivehun()))
			&& (this.getIsAllowContact() == null ? other.getIsAllowContact() == null : this.getIsAllowContact().equals(other.getIsAllowContact()))
			&& (this.getIsAllowRecord() == null ? other.getIsAllowRecord() == null : this.getIsAllowRecord().equals(other.getIsAllowRecord()))
			&& (this.getIsAllowMessage() == null ? other.getIsAllowMessage() == null : this.getIsAllowMessage().equals(other.getIsAllowMessage()))
			&& (this.getIsAllowLocation() == null ? other.getIsAllowLocation() == null : this.getIsAllowLocation().equals(other.getIsAllowLocation()))
			&& (this.getJob() == null ? other.getJob() == null : this.getJob().equals(other.getJob()))
			&& (this.getIndustry() == null ? other.getIndustry() == null : this.getIndustry().equals(other.getIndustry()))
			&& (this.getWorkPlace() == null ? other.getWorkPlace() == null : this.getWorkPlace().equals(other.getWorkPlace()))
			&& (this.getWorkExperience() == null ? other.getWorkExperience() == null : this.getWorkExperience().equals(other.getWorkExperience()))
			&& (this.getWantedLimit() == null ? other.getWantedLimit() == null : this.getWantedLimit().equals(other.getWantedLimit()))
			&& (this.getWantedPeriod() == null ? other.getWantedPeriod() == null : this.getWantedPeriod().equals(other.getWantedPeriod()))
			&& (this.getWantedRepayDay() == null ? other.getWantedRepayDay() == null : this.getWantedRepayDay().equals(other.getWantedRepayDay()))
			&& (this.getMarriage() == null ? other.getMarriage() == null : this.getMarriage().equals(other.getMarriage()))
			&& (this.getChildAmount() == null ? other.getChildAmount() == null : this.getChildAmount().equals(other.getChildAmount()))
			&& (this.getFamilyAmount() == null ? other.getFamilyAmount() == null : this.getFamilyAmount().equals(other.getFamilyAmount()))
			&& (this.getApplyTime() == null ? other.getApplyTime() == null : this.getApplyTime().equals(other.getApplyTime()))
			&& (this.getYearPay() == null ? other.getYearPay() == null : this.getYearPay().equals(other.getYearPay()))
			&& (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
			&& (this.getQqAge() == null ? other.getQqAge() == null : this.getQqAge().equals(other.getQqAge()))
			&& (this.getWxAge() == null ? other.getWxAge() == null : this.getWxAge().equals(other.getWxAge()))
			&& (this.getWx() == null ? other.getWx() == null : this.getWx().equals(other.getWx()))
			&& (this.getFengkongState() == null ? other.getFengkongState() == null : this.getFengkongState().equals(other.getFengkongState()))
			&& (this.getApplyState() == null ? other.getApplyState() == null : this.getApplyState().equals(other.getApplyState()))
			&& (this.getApplyStep() == null ? other.getApplyStep() == null : this.getApplyStep().equals(other.getApplyStep()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
			&& (this.getBuyType() == null ? other.getBuyType() == null : this.getBuyType().equals(other.getBuyType()))
			&& (this.getHouseType() == null ? other.getHouseType() == null : this.getHouseType().equals(other.getHouseType()))
			&& (this.getHouseCaty() == null ? other.getHouseCaty() == null : this.getHouseCaty().equals(other.getHouseCaty()))
			&& (this.getHouseBig() == null ? other.getHouseBig() == null : this.getHouseBig().equals(other.getHouseBig()))
			&& (this.getLoanAmount() == null ? other.getLoanAmount() == null : this.getLoanAmount().equals(other.getLoanAmount()))
			&& (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
			&& (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
			&& (this.getIncome() == null ? other.getIncome() == null : this.getIncome().equals(other.getIncome()))
			&& (this.getSocialSecurity() == null ? other.getSocialSecurity() == null : this.getSocialSecurity().equals(other.getSocialSecurity()))
			&& (this.getAccumulationFund() == null ? other.getAccumulationFund() == null : this.getAccumulationFund().equals(other.getAccumulationFund()))
			&& (this.getJingdongQuto() == null ? other.getJingdongQuto() == null : this.getJingdongQuto().equals(other.getJingdongQuto()))
			&& (this.getMayijiebQuto() == null ? other.getMayijiebQuto() == null : this.getMayijiebQuto().equals(other.getMayijiebQuto()))
			&& (this.getHuabeiQuto() == null ? other.getHuabeiQuto() == null : this.getHuabeiQuto().equals(other.getHuabeiQuto()))
			&& (this.getDebit() == null ? other.getDebit() == null : this.getDebit().equals(other.getDebit()))
			&& (this.getCarNumber() == null ? other.getCarNumber() == null : this.getCarNumber().equals(other.getCarNumber()))
			&& (this.getCarBrand() == null ? other.getCarBrand() == null : this.getCarBrand().equals(other.getCarBrand()))
			&& (this.getCarLisence() == null ? other.getCarLisence() == null : this.getCarLisence().equals(other.getCarLisence()))
			&& (this.getCarProperty() == null ? other.getCarProperty() == null : this.getCarProperty().equals(other.getCarProperty()))
			&& (this.getCarDriven() == null ? other.getCarDriven() == null : this.getCarDriven().equals(other.getCarDriven()))
			&& (this.getCarOwner() == null ? other.getCarOwner() == null : this.getCarOwner().equals(other.getCarOwner()))
			&& (this.getCarCode() == null ? other.getCarCode() == null : this.getCarCode().equals(other.getCarCode()))
			&& (this.getBuyDate() == null ? other.getBuyDate() == null : this.getBuyDate().equals(other.getBuyDate()))
			&& (this.getCounts() == null ? other.getCounts() == null : this.getCounts().equals(other.getCounts()))
			&& (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
			&& (this.getCarInsuranceAmount() == null ? other.getCarInsuranceAmount() == null : this.getCarInsuranceAmount().equals(other.getCarInsuranceAmount()))
			&& (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
			&& (this.getNativePlace() == null ? other.getNativePlace() == null : this.getNativePlace().equals(other.getNativePlace()));
	}

	/**
	
	 * @since 2017-06-05 10:38:33
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getCaId() == null) ? 0 : getCaId().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
		result = prime * result + ((getIdCard() == null) ? 0 : getIdCard().hashCode());
		result = prime * result + ((getCoupleCard() == null) ? 0 : getCoupleCard().hashCode());
		result = prime * result + ((getCoupleMobile() == null) ? 0 : getCoupleMobile().hashCode());
		result = prime * result + ((getCoupleName() == null) ? 0 : getCoupleName().hashCode());
		result = prime * result + ((getCoupleEducation() == null) ? 0 : getCoupleEducation().hashCode());
		result = prime * result + ((getCoupleJob() == null) ? 0 : getCoupleJob().hashCode());
		result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
		result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
		result = prime * result + ((getOriginType() == null) ? 0 : getOriginType().hashCode());
		result = prime * result + ((getDomicileProvince() == null) ? 0 : getDomicileProvince().hashCode());
		result = prime * result + ((getDomicileDetail() == null) ? 0 : getDomicileDetail().hashCode());
		result = prime * result + ((getDomicileTime() == null) ? 0 : getDomicileTime().hashCode());
		result = prime * result + ((getNation() == null) ? 0 : getNation().hashCode());
		result = prime * result + ((getEducation() == null) ? 0 : getEducation().hashCode());
		result = prime * result + ((getHighEduStarttime() == null) ? 0 : getHighEduStarttime().hashCode());
		result = prime * result + ((getHighEduEndtime() == null) ? 0 : getHighEduEndtime().hashCode());
		result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
		result = prime * result + ((getComBusTimeLength() == null) ? 0 : getComBusTimeLength().hashCode());
		result = prime * result + ((getIsCompanyFivehun() == null) ? 0 : getIsCompanyFivehun().hashCode());
		result = prime * result + ((getIsAllowContact() == null) ? 0 : getIsAllowContact().hashCode());
		result = prime * result + ((getIsAllowRecord() == null) ? 0 : getIsAllowRecord().hashCode());
		result = prime * result + ((getIsAllowMessage() == null) ? 0 : getIsAllowMessage().hashCode());
		result = prime * result + ((getIsAllowLocation() == null) ? 0 : getIsAllowLocation().hashCode());
		result = prime * result + ((getJob() == null) ? 0 : getJob().hashCode());
		result = prime * result + ((getIndustry() == null) ? 0 : getIndustry().hashCode());
		result = prime * result + ((getWorkPlace() == null) ? 0 : getWorkPlace().hashCode());
		result = prime * result + ((getWorkExperience() == null) ? 0 : getWorkExperience().hashCode());
		result = prime * result + ((getWantedLimit() == null) ? 0 : getWantedLimit().hashCode());
		result = prime * result + ((getWantedPeriod() == null) ? 0 : getWantedPeriod().hashCode());
		result = prime * result + ((getWantedRepayDay() == null) ? 0 : getWantedRepayDay().hashCode());
		result = prime * result + ((getMarriage() == null) ? 0 : getMarriage().hashCode());
		result = prime * result + ((getChildAmount() == null) ? 0 : getChildAmount().hashCode());
		result = prime * result + ((getFamilyAmount() == null) ? 0 : getFamilyAmount().hashCode());
		result = prime * result + ((getApplyTime() == null) ? 0 : getApplyTime().hashCode());
		result = prime * result + ((getYearPay() == null) ? 0 : getYearPay().hashCode());
		result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
		result = prime * result + ((getQqAge() == null) ? 0 : getQqAge().hashCode());
		result = prime * result + ((getWxAge() == null) ? 0 : getWxAge().hashCode());
		result = prime * result + ((getWx() == null) ? 0 : getWx().hashCode());
		result = prime * result + ((getFengkongState() == null) ? 0 : getFengkongState().hashCode());
		result = prime * result + ((getApplyState() == null) ? 0 : getApplyState().hashCode());
		result = prime * result + ((getApplyStep() == null) ? 0 : getApplyStep().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		result = prime * result + ((getBuyType() == null) ? 0 : getBuyType().hashCode());
		result = prime * result + ((getHouseType() == null) ? 0 : getHouseType().hashCode());
		result = prime * result + ((getHouseCaty() == null) ? 0 : getHouseCaty().hashCode());
		result = prime * result + ((getHouseBig() == null) ? 0 : getHouseBig().hashCode());
		result = prime * result + ((getLoanAmount() == null) ? 0 : getLoanAmount().hashCode());
		result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
		result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
		result = prime * result + ((getIncome() == null) ? 0 : getIncome().hashCode());
		result = prime * result + ((getSocialSecurity() == null) ? 0 : getSocialSecurity().hashCode());
		result = prime * result + ((getAccumulationFund() == null) ? 0 : getAccumulationFund().hashCode());
		result = prime * result + ((getJingdongQuto() == null) ? 0 : getJingdongQuto().hashCode());
		result = prime * result + ((getMayijiebQuto() == null) ? 0 : getMayijiebQuto().hashCode());
		result = prime * result + ((getHuabeiQuto() == null) ? 0 : getHuabeiQuto().hashCode());
		result = prime * result + ((getDebit() == null) ? 0 : getDebit().hashCode());
		result = prime * result + ((getCarNumber() == null) ? 0 : getCarNumber().hashCode());
		result = prime * result + ((getCarBrand() == null) ? 0 : getCarBrand().hashCode());
		result = prime * result + ((getCarLisence() == null) ? 0 : getCarLisence().hashCode());
		result = prime * result + ((getCarProperty() == null) ? 0 : getCarProperty().hashCode());
		result = prime * result + ((getCarDriven() == null) ? 0 : getCarDriven().hashCode());
		result = prime * result + ((getCarOwner() == null) ? 0 : getCarOwner().hashCode());
		result = prime * result + ((getCarCode() == null) ? 0 : getCarCode().hashCode());
		result = prime * result + ((getBuyDate() == null) ? 0 : getBuyDate().hashCode());
		result = prime * result + ((getCounts() == null) ? 0 : getCounts().hashCode());
		result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
		result = prime * result + ((getCarInsuranceAmount() == null) ? 0 : getCarInsuranceAmount().hashCode());
		result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
		result = prime * result + ((getNativePlace() == null) ? 0 : getNativePlace().hashCode());
		return result;
	}
}