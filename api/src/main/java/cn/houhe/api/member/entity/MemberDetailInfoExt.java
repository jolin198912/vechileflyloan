package cn.houhe.api.member.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/4/17.
 */
public class MemberDetailInfoExt {
    /** memid -- 用户id */
    private Integer memId;
    /** realname -- 姓名 */
    private String realName;
    /** idcardno -- 身份证号 */
    private String idCardNo;
    /** mobileno -- 手机号 */
    private String mobileNo;
    /** nation -- 民族 */
    private String nation;
    /** sex -- 性别0男1女 */
    private Byte sex;
    @JsonFormat(pattern = "yyyy-MM-dd")
    /** birthday -- 生日 */
    private Date birthday;
    /** origin_palce -- 籍贯 */
    private String originPalce;
    /** zm_scores -- 芝麻信用分 */
    private Integer zmScores;
    /** total_scores -- 信用分值 */
    private Integer totalScores;
    @JsonFormat(pattern = "yyyy-MM-dd")
    /** assessment_day -- 评估日期 */
    private Date assessmentDay;
    /** name -- 现金分期用户等级名称 */
    private String levelName;
    /** name -- pdl用户等级名称 */
    private String pdlLevelName;
    /** loan_limit_total -- 授信额度 */
    private Integer loanLimitTotal;
    /** loan_limit_used -- 已用额度 */
    private Integer loanLimitUsed;
    /** loan_limit_left -- 可用额度 */
    private Integer loanLimitLeft;
    /** loan_limit_applying -- 申请中额度 */
    private Integer loanLimitApplying;
    /** loan_apply_times -- 贷款次数 */
    private Byte loanApplyTimes;
    /** delay_debit_times -- 逾期贷款次数 */
    private Short delayDebitTimes;
    /** detailaddr -- 详细地址 */
    private String detailAddr;
    /** leveleducation -- 文化程度 */
    private Byte levelEducation;
    /** maritalstatus -- 婚姻状况(0未婚，1已婚未育，2已婚已育3离异) */
    private Byte maritalStatus;
    /** childrennumber -- 子女个数 */
    private Short childreNnumber;
    /** unitname -- 单位名称 */
    private String unitName;
    /** position -- 职务 */
    private Byte positionName;
    /** url -- 身份证正面照片 */
    private String idCardFrontPic;
    /** url -- 身份证反面照片 */
    private String idCardReversePic;
    /** url -- 人脸识别照片 */
    private String faceRecognitionPic;
    /** my_invitecode -- 我的邀请码 */
    private String myInvitecode;
    /** mobilephonebrand -- 手机品牌 */
    private String mobilePhoneBrand;
    /** linkman -- 联系人 */
    private String linkMan;
    /** linkphone -- 联系人 */
    private String linkPhone;
    /** receive_bank -- 收款银行 */
    private String receiveBank;
    /** receive_bank_cardno -- 收款银行账号 */
    private String receiveBankCardNo;
    /** repay_bank -- 还款银行 */
    private String repayBank;
    /** repay_bank_cardno -- 还款银行账号 */
    private String repayBankCardNo;
    /** url -- 行驶证正面照片 */
    private String runFrontPic;
    /** url -- 行驶证反面照片 */
    private String runReversePic;
    /** contract_file_url -- 授信合同 */
    private List<LoanContractExt> creditContractFileUrl;
    /** couple_card -- 配偶身份证号码 */
    private String coupleCard;
    /** couple_mobile -- 配偶手机号码 */
    private String coupleMobile;
    /** couple_name -- 配偶姓名 */
    private String coupleName;
    /** couple_education -- 配偶文化程度(0其他1高中及以下2大专3本科4硕士5博士) */
    private Byte coupleEducation;
    /** couple_job -- 配偶职业(0照顾孩子，1工作，2个体户，3务农) */
    private Byte coupleJob;
    /** origin_type -- 0城镇户口1农村户口 */
    private Byte originType;
    /** domicile_detail -- 居住地址 */
    private String domicileDetail;
    /** domicile_time -- 居住时间（0：1年以下，1：1~3年， 2：3~7年，3：7年以上） */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Byte domicileTime;
    /** high_edu_starttime -- 最高教育开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date highEduStarttime;
    /** high_edu_endtime -- 最高教育结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date highEduEndtime;
    /** com_bus_time_length -- 公司经营时长（年） */
    private Short comBusTimeLength;
    /** is_company_fivehun -- 是否是500强0否1是 */
    private Byte isCompanyFivehun;
    /** is_allow_contact -- 是否允许读取通讯录0否1是 */
    private Byte isAllowContact;
    /** is_allow_record -- 是否允许读取通话记录0否1是 */
    private Byte isAllowRecord;
    /** is_allow_message -- 允许读取短信0否1是 */
    private Byte isAllowMessage;
    /** is_allow_location -- 允许读取定位0否1是 */
    private Byte isAllowLocation;
    /** industry -- 行业（互联网，教育等） */
    private String industry;
    /** work_place -- 单位地址 */
    private String workPlace;
    /** work_experience -- 工作经验 */
    private String workExperience;
    /** wanted_limit -- 期望额度 */
    private Integer wantedLimit;
    /** wanted_period -- 期望还款期限 */
    private Byte wantedPeriod;
    /** wanted_repay_day -- 期望还款日期 */
    private Byte wantedRepayDay;
    /** family_amount -- 家庭人口(0：2人，1：3人，2：4人，3：5人，4：5人以上) */
    private Byte familyAmount;
    /** apply_time -- 申请时间 */
    private Date applyTime;
    /** year_pay -- 保险年缴纳费（0：5000以下，1：5000~10000，2：10000以上） */
    private BigDecimal yearPay;
    /** qq -- QQ号 */
    private String qq;
    /** qq_age -- qq年龄 */
    private Short qqAge;
    /** wx_age -- 微信年龄 */
    private Short wxAge;
    /** wx -- 微信号 */
    private String wx;
    /** buy_type -- 买房类型0按揭1全款 */
    private Byte buyType;
    /** house_type -- 0其他1租房2亲属住房3自建房4商品房 */
    private Byte houseType;
    /** house_caty -- 住宅类型（0普通住宅，1别墅） */
    private Byte houseCaty;
    /** house_big -- 房子面积 */
    private Short houseBig;
    /** loan_amount -- 每月按揭金额 */
    private BigDecimal loanAmount;
    /** city -- 所在城市 */
    private String city;
    /** area -- 所在小区 */
    private String area;
    /** income -- 每月收入（0：5000以下，1：5000~10000，2：10000以上） */
    private BigDecimal income;
    /** social_security -- 社保缴纳基数0：5000以下，1：5000-10000，2：10000以上 */
    private Byte socialSecurity;
    /** accumulation_fund -- 公积金缴纳基数0：5000以下，1：5000-10000，2：10000以上 */
    private Byte accumulationFund;
    /** jingdong_quto -- 京东白条额度 */
    private BigDecimal jingdongQuto;
    /** mayijieb_quto -- 蚂蚁借呗额度 */
    private BigDecimal mayijiebQuto;
    /** huabei_quto -- 蚂蚁花呗额度 */
    private BigDecimal huabeiQuto;
    /** debit -- 负债 */
    private BigDecimal debit;
    /** car_number -- 车牌号 */
    private String carNumber;
    /** car_brand -- 车辆品牌 */
    private String carBrand;
    /** car_lisence -- 驾照登记地址 */
    private String carLisence;
    /** car_property -- 车辆性质（非运营0运营1） */
    private Byte carProperty;
    /** car_driven -- 驾龄 */
    private Byte carDriven;
    /** car_owner -- 车辆所有人 */
    private String carOwner;
    /** car_code -- 车辆识别代码 */
    private String carCode;
    /** buy_date -- 购买日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date buyDate;
    /** counts -- 第几辆车（0第一辆，1第二辆，2第三辆，3第四辆及以上） */
    private Short counts;
    /** price -- 购买价格 */
    private BigDecimal price;
    /** car_insurance_amount -- 保费金额 */
    private BigDecimal carInsuranceAmount;

    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getOriginPalce() {
        return originPalce;
    }

    public void setOriginPalce(String originPalce) {
        this.originPalce = originPalce;
    }

    public Integer getZmScores() {
        return zmScores;
    }

    public void setZmScores(Integer zmScores) {
        this.zmScores = zmScores;
    }

    public Integer getTotalScores() {
        return totalScores;
    }

    public void setTotalScores(Integer totalScores) {
        this.totalScores = totalScores;
    }

    public Date getAssessmentDay() {
        return assessmentDay;
    }

    public void setAssessmentDay(Date assessmentDay) {
        this.assessmentDay = assessmentDay;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getPdlLevelName() {
        return pdlLevelName;
    }

    public void setPdlLevelName(String pdlLevelName) {
        this.pdlLevelName = pdlLevelName;
    }

    public Integer getLoanLimitTotal() {
        return loanLimitTotal;
    }

    public void setLoanLimitTotal(Integer loanLimitTotal) {
        this.loanLimitTotal = loanLimitTotal;
    }

    public Integer getLoanLimitUsed() {
        return loanLimitUsed;
    }

    public void setLoanLimitUsed(Integer loanLimitUsed) {
        this.loanLimitUsed = loanLimitUsed;
    }

    public Integer getLoanLimitLeft() {
        return loanLimitLeft;
    }

    public void setLoanLimitLeft(Integer loanLimitLeft) {
        this.loanLimitLeft = loanLimitLeft;
    }

    public Integer getLoanLimitApplying() {
        return loanLimitApplying;
    }

    public void setLoanLimitApplying(Integer loanLimitApplying) {
        this.loanLimitApplying = loanLimitApplying;
    }

    public Byte getLoanApplyTimes() {
        return loanApplyTimes;
    }

    public void setLoanApplyTimes(Byte loanApplyTimes) {
        this.loanApplyTimes = loanApplyTimes;
    }

    public Short getDelayDebitTimes() {
        return delayDebitTimes;
    }

    public void setDelayDebitTimes(Short delayDebitTimes) {
        this.delayDebitTimes = delayDebitTimes;
    }

    public String getDetailAddr() {
        return detailAddr;
    }

    public void setDetailAddr(String detailAddr) {
        this.detailAddr = detailAddr;
    }

    public Byte getLevelEducation() {
        return levelEducation;
    }

    public void setLevelEducation(Byte levelEducation) {
        this.levelEducation = levelEducation;
    }

    public Byte getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Byte maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Short getChildreNnumber() {
        return childreNnumber;
    }

    public void setChildreNnumber(Short childreNnumber) {
        this.childreNnumber = childreNnumber;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Byte getPositionName() {
        return positionName;
    }

    public void setPositionName(Byte positionName) {
        this.positionName = positionName;
    }

    public String getIdCardFrontPic() {
        return idCardFrontPic;
    }

    public void setIdCardFrontPic(String idCardFrontPic) {
        this.idCardFrontPic = idCardFrontPic;
    }

    public String getIdCardReversePic() {
        return idCardReversePic;
    }

    public void setIdCardReversePic(String idCardReversePic) {
        this.idCardReversePic = idCardReversePic;
    }

    public String getFaceRecognitionPic() {
        return faceRecognitionPic;
    }

    public void setFaceRecognitionPic(String faceRecognitionPic) {
        this.faceRecognitionPic = faceRecognitionPic;
    }

    public String getMyInvitecode() {
        return myInvitecode;
    }

    public void setMyInvitecode(String myInvitecode) {
        this.myInvitecode = myInvitecode;
    }

    public String getMobilePhoneBrand() {
        return mobilePhoneBrand;
    }

    public void setMobilePhoneBrand(String mobilePhoneBrand) {
        this.mobilePhoneBrand = mobilePhoneBrand;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getReceiveBank() {
        return receiveBank;
    }

    public void setReceiveBank(String receiveBank) {
        this.receiveBank = receiveBank;
    }

    public String getReceiveBankCardNo() {
        return receiveBankCardNo;
    }

    public void setReceiveBankCardNo(String receiveBankCardNo) {
        this.receiveBankCardNo = receiveBankCardNo;
    }

    public String getRepayBank() {
        return repayBank;
    }

    public void setRepayBank(String repayBank) {
        this.repayBank = repayBank;
    }

    public String getRepayBankCardNo() {
        return repayBankCardNo;
    }

    public void setRepayBankCardNo(String repayBankCardNo) {
        this.repayBankCardNo = repayBankCardNo;
    }

    public String getRunFrontPic() {
        return runFrontPic;
    }

    public void setRunFrontPic(String runFrontPic) {
        this.runFrontPic = runFrontPic;
    }

    public String getRunReversePic() {
        return runReversePic;
    }

    public void setRunReversePic(String runReversePic) {
        this.runReversePic = runReversePic;
    }

    public List<LoanContractExt> getCreditContractFileUrl() {
        return creditContractFileUrl;
    }

    public void setCreditContractFileUrl(List<LoanContractExt> creditContractFileUrl) {
        this.creditContractFileUrl = creditContractFileUrl;
    }

    public String getCoupleCard() {
        return coupleCard;
    }

    public void setCoupleCard(String coupleCard) {
        this.coupleCard = coupleCard;
    }

    public String getCoupleMobile() {
        return coupleMobile;
    }

    public void setCoupleMobile(String coupleMobile) {
        this.coupleMobile = coupleMobile;
    }

    public String getCoupleName() {
        return coupleName;
    }

    public void setCoupleName(String coupleName) {
        this.coupleName = coupleName;
    }

    public Byte getCoupleEducation() {
        return coupleEducation;
    }

    public void setCoupleEducation(Byte coupleEducation) {
        this.coupleEducation = coupleEducation;
    }

    public Byte getCoupleJob() {
        return coupleJob;
    }

    public void setCoupleJob(Byte coupleJob) {
        this.coupleJob = coupleJob;
    }

    public Byte getOriginType() {
        return originType;
    }

    public void setOriginType(Byte originType) {
        this.originType = originType;
    }

    public String getDomicileDetail() {
        return domicileDetail;
    }

    public void setDomicileDetail(String domicileDetail) {
        this.domicileDetail = domicileDetail;
    }

    public Byte getDomicileTime() {
        return domicileTime;
    }

    public void setDomicileTime(Byte domicileTime) {
        this.domicileTime = domicileTime;
    }

    public Date getHighEduStarttime() {
        return highEduStarttime;
    }

    public void setHighEduStarttime(Date highEduStarttime) {
        this.highEduStarttime = highEduStarttime;
    }

    public Date getHighEduEndtime() {
        return highEduEndtime;
    }

    public void setHighEduEndtime(Date highEduEndtime) {
        this.highEduEndtime = highEduEndtime;
    }

    public Short getComBusTimeLength() {
        return comBusTimeLength;
    }

    public void setComBusTimeLength(Short comBusTimeLength) {
        this.comBusTimeLength = comBusTimeLength;
    }

    public Byte getIsCompanyFivehun() {
        return isCompanyFivehun;
    }

    public void setIsCompanyFivehun(Byte isCompanyFivehun) {
        this.isCompanyFivehun = isCompanyFivehun;
    }

    public Byte getIsAllowContact() {
        return isAllowContact;
    }

    public void setIsAllowContact(Byte isAllowContact) {
        this.isAllowContact = isAllowContact;
    }

    public Byte getIsAllowRecord() {
        return isAllowRecord;
    }

    public void setIsAllowRecord(Byte isAllowRecord) {
        this.isAllowRecord = isAllowRecord;
    }

    public Byte getIsAllowMessage() {
        return isAllowMessage;
    }

    public void setIsAllowMessage(Byte isAllowMessage) {
        this.isAllowMessage = isAllowMessage;
    }

    public Byte getIsAllowLocation() {
        return isAllowLocation;
    }

    public void setIsAllowLocation(Byte isAllowLocation) {
        this.isAllowLocation = isAllowLocation;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public Integer getWantedLimit() {
        return wantedLimit;
    }

    public void setWantedLimit(Integer wantedLimit) {
        this.wantedLimit = wantedLimit;
    }

    public Byte getWantedPeriod() {
        return wantedPeriod;
    }

    public void setWantedPeriod(Byte wantedPeriod) {
        this.wantedPeriod = wantedPeriod;
    }

    public Byte getWantedRepayDay() {
        return wantedRepayDay;
    }

    public void setWantedRepayDay(Byte wantedRepayDay) {
        this.wantedRepayDay = wantedRepayDay;
    }

    public Byte getFamilyAmount() {
        return familyAmount;
    }

    public void setFamilyAmount(Byte familyAmount) {
        this.familyAmount = familyAmount;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public BigDecimal getYearPay() {
        return yearPay;
    }

    public void setYearPay(BigDecimal yearPay) {
        this.yearPay = yearPay;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Short getQqAge() {
        return qqAge;
    }

    public void setQqAge(Short qqAge) {
        this.qqAge = qqAge;
    }

    public Short getWxAge() {
        return wxAge;
    }

    public void setWxAge(Short wxAge) {
        this.wxAge = wxAge;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public Byte getBuyType() {
        return buyType;
    }

    public void setBuyType(Byte buyType) {
        this.buyType = buyType;
    }

    public Byte getHouseType() {
        return houseType;
    }

    public void setHouseType(Byte houseType) {
        this.houseType = houseType;
    }

    public Byte getHouseCaty() {
        return houseCaty;
    }

    public void setHouseCaty(Byte houseCaty) {
        this.houseCaty = houseCaty;
    }

    public Short getHouseBig() {
        return houseBig;
    }

    public void setHouseBig(Short houseBig) {
        this.houseBig = houseBig;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public Byte getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(Byte socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public Byte getAccumulationFund() {
        return accumulationFund;
    }

    public void setAccumulationFund(Byte accumulationFund) {
        this.accumulationFund = accumulationFund;
    }

    public BigDecimal getJingdongQuto() {
        return jingdongQuto;
    }

    public void setJingdongQuto(BigDecimal jingdongQuto) {
        this.jingdongQuto = jingdongQuto;
    }

    public BigDecimal getMayijiebQuto() {
        return mayijiebQuto;
    }

    public void setMayijiebQuto(BigDecimal mayijiebQuto) {
        this.mayijiebQuto = mayijiebQuto;
    }

    public BigDecimal getHuabeiQuto() {
        return huabeiQuto;
    }

    public void setHuabeiQuto(BigDecimal huabeiQuto) {
        this.huabeiQuto = huabeiQuto;
    }

    public BigDecimal getDebit() {
        return debit;
    }

    public void setDebit(BigDecimal debit) {
        this.debit = debit;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarLisence() {
        return carLisence;
    }

    public void setCarLisence(String carLisence) {
        this.carLisence = carLisence;
    }

    public Byte getCarProperty() {
        return carProperty;
    }

    public void setCarProperty(Byte carProperty) {
        this.carProperty = carProperty;
    }

    public Byte getCarDriven() {
        return carDriven;
    }

    public void setCarDriven(Byte carDriven) {
        this.carDriven = carDriven;
    }

    public String getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Short getCounts() {
        return counts;
    }

    public void setCounts(Short counts) {
        this.counts = counts;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCarInsuranceAmount() {
        return carInsuranceAmount;
    }

    public void setCarInsuranceAmount(BigDecimal carInsuranceAmount) {
        this.carInsuranceAmount = carInsuranceAmount;
    }

    @Override
    public String toString() {
        return "MemberDetailInfoExt{" +
                "realName='" + realName + '\'' +
                ", idCardNo='" + idCardNo + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", zmScores=" + zmScores +
                ", totalScores=" + totalScores +
                ", assessmentDay=" + assessmentDay +
                ", levelName='" + levelName + '\'' +
                ", loanLimitTotal=" + loanLimitTotal +
                ", loanLimitUsed=" + loanLimitUsed +
                ", loanLimitLeft=" + loanLimitLeft +
                ", loanLimitApplying=" + loanLimitApplying +
                ", loanApplyTimes=" + loanApplyTimes +
                ", delayDebitTimes=" + delayDebitTimes +
                ", detailAddr='" + detailAddr + '\'' +
                ", levelEducation=" + levelEducation +
                ", maritalStatus=" + maritalStatus +
                ", childreNnumber=" + childreNnumber +
                ", unitName='" + unitName + '\'' +
                ", positionName=" + positionName +
                ", idCardFrontPic='" + idCardFrontPic + '\'' +
                ", idCardReversePic='" + idCardReversePic + '\'' +
                ", faceRecognitionPic='" + faceRecognitionPic + '\'' +
                ", myInvitecode='" + myInvitecode + '\'' +
                ", mobilePhoneBrand='" + mobilePhoneBrand + '\'' +
                ", linkMan='" + linkMan + '\'' +
                ", linkPhone='" + linkPhone + '\'' +
                ", receiveBank='" + receiveBank + '\'' +
                ", receiveBankCardNo='" + receiveBankCardNo + '\'' +
                ", repayBank='" + repayBank + '\'' +
                ", repayBankCardNo='" + repayBankCardNo + '\'' +
                ", runFrontPic='" + runFrontPic + '\'' +
                ", runReversePic='" + runReversePic + '\'' +
                '}';
    }
}
