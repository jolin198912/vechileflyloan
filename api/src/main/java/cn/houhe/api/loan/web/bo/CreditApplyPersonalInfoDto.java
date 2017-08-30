package cn.houhe.api.loan.web.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by think on 2017/4/6.
 */
public class CreditApplyPersonalInfoDto {

    /**
     * domicile -- 长居城市
     */
//    private String domicile;


    private String domicileProvince;
    /**
     * domicile_detail -- 详细地址
     */
    private String domicileDetail;

    /** domicile_time -- 居住时间 */
    private Byte domicileTime;

    /**
     * education -- 文化程度(0高中及以下1中专2大专3本科4硕士5博士)
     */
    private Integer education;

    /**
     * family_income -- 家庭月收入
     */
//    private BigDecimal familyIncome;

    /**
     * company_type -- 单位性质(0事业单位，1私营企业2合资企业3外资企业4国有控股企业5国有企业6国家行政机关)
     */
//    private Integer companyType;

    /**
     * company_name -- 单位名称
     */
    private String companyName;

    /** is_company_fivehun -- 是否是500强0否1是 */
    private Byte isCompanyFivehun;

    /**
     * job -- 职务
     */
    private Byte job;

    /**
     * work_time_start -- 参加工作时间
     */
    /*@JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date workTimeStart;*/

    /**
     * work_time_current -- 现单位入职时间
     */

   /* @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date workTimeCurrent;*/

    /**
     * marriage -- 婚姻状态(0单身，1丧偶，2离异,3已婚)
     */
    private Integer marriage;

    /** couple_card -- 配偶身份证号码 */
    private String coupleCard;

    /** couple_mobile -- 配偶手机号码 */
    private String coupleMobile;

    /** couple_name -- 配偶姓名 */
    private String coupleName;

    /** couple_education -- 配偶文化程度(0高中及以下1中专2大专3本科4硕士5博士) */
    private Byte coupleEducation;

    /** couple_job -- 配偶职业(在家、工作) */
    private Byte coupleJob;

    /** family_amount -- 家庭人口(0：2人，1：3人，2：4人，3：5人，4：5人以上) */
    private Byte familyAmount;

    /** member_id -- 用户id */
    @JsonProperty("memId")
    private Integer memId;
    /** buy_type -- 买房类型0按揭1全款 */
    private Byte buyType;

    /** house_type -- 0商品房1自建房2亲属主住房3租房4其他 */
    private Byte houseType;

    /** origin_type -- 0城镇户口1农村户口 */
    private Byte originType;

    /** house_caty -- 住宅类型（0普通住宅，1别墅） */
    private Byte houseCaty;

    /** house_big -- 房子面积 */
    private Short houseBig;

    /** loan_amount -- 每月按揭金额 */
    private BigDecimal loanAmount = new BigDecimal(0);

    /** city -- 所在城市 */
    private String city;

    /** area -- 所在小区 */
    private String area;

    /** income --  */
    @Min(value = 0,message = "月收入不能为0")
    private BigDecimal income;

    /** social_security -- 社保缴纳基数0：5000以下，1：5000-10000，2：10000以上 */
    private Byte socialSecurity;

    /** accumulation_fund -- 公积金缴纳基数0：5000以下，1：5000-10000，2：10000以上 */
    private Byte accumulationFund;

    /** jingdong_quto -- 京东白条额度 */
    private BigDecimal jingdongQuto = new BigDecimal(0);

    /** mayijieb_quto -- 蚂蚁借呗额度 */
    private BigDecimal mayijiebQuto = new BigDecimal(0);

    /** huabei_quto -- 蚂蚁花呗额度 */
    private BigDecimal huabeiQuto = new BigDecimal(0);

    /** debit -- 负债 */
    private BigDecimal debit = new BigDecimal(0);

    private List<PhoneContactDto> contacts = new ArrayList<>();

    /** qq -- QQ号 */
    private String qq;

    /** qq_age -- qq年龄 */
    private Short qqAge;

    /** wx_age -- 微信年龄 */
    private Short wxAge;

    /** wx -- 微信号 */
    private String wx;

    /** high_edu_starttime -- 最高教育开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date highEduStarttime;

    /** high_edu_endtime -- 最高教育结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date highEduEndtime;

    private List<CreditChildrenDto> children = new ArrayList<>();

    /** year_pay -- 保险年缴纳费 */
    private BigDecimal yearPay = new BigDecimal(0);

    /** com_bus_time_length -- 公司经营时长（年） */
    private Short comBusTimeLength;

    /** work_experience -- 工作经验 */
    private String workExperience;

    /** work_place -- 单位地址 */
    private String workPlace;

    /** wanted_limit -- 期望额度 */
    private Integer wantedLimit;

    /** wanted_period -- 期望还款期限 */
    private Byte wantedPeriod;

    /** wanted_repay_day -- 期望还款日期 */
    private Byte wantedRepayDay;

    @ApiModelProperty("单位地址")
    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    @ApiModelProperty("期望额度")
    public Integer getWantedLimit() {
        return wantedLimit;
    }

    public void setWantedLimit(Integer wantedLimit) {
        this.wantedLimit = wantedLimit;
    }

    @ApiModelProperty("期望还款期限")
    public Byte getWantedPeriod() {
        return wantedPeriod;
    }

    public void setWantedPeriod(Byte wantedPeriod) {
        this.wantedPeriod = wantedPeriod;
    }

    @ApiModelProperty("期望还款日期")
    public Byte getWantedRepayDay() {
        return wantedRepayDay;
    }

    public void setWantedRepayDay(Byte wantedRepayDay) {
        this.wantedRepayDay = wantedRepayDay;
    }

    @ApiModelProperty("工作经验")
    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    @ApiModelProperty("公司经营时长")
    public Short getComBusTimeLength() {
        return comBusTimeLength;
    }

    public void setComBusTimeLength(Short comBusTimeLength) {
        this.comBusTimeLength = comBusTimeLength;
    }

    @ApiModelProperty("保险年缴纳费")
    public BigDecimal getYearPay() {
        return yearPay;
    }

    public void setYearPay(BigDecimal yearPay) {
        this.yearPay = yearPay;
    }

    @ApiModelProperty("配偶身份证号码")
    public String getCoupleCard() {
        return coupleCard;
    }

    public void setCoupleCard(String coupleCard) {
        this.coupleCard = coupleCard;
    }
    @ApiModelProperty("配偶手机号码")
    public String getCoupleMobile() {
        return coupleMobile;
    }

    public void setCoupleMobile(String coupleMobile) {
        this.coupleMobile = coupleMobile;
    }
    @ApiModelProperty("配偶姓名")
    public String getCoupleName() {
        return coupleName;
    }

    public void setCoupleName(String coupleName) {
        this.coupleName = coupleName;
    }
    @ApiModelProperty("配偶文化程度(0高中及以下1中专2大专3本科4硕士5博士)")
    public Byte getCoupleEducation() {
        return coupleEducation;
    }

    public void setCoupleEducation(Byte coupleEducation) {
        this.coupleEducation = coupleEducation;
    }
    @ApiModelProperty("配偶职业(o在家、1工作)")
    public Byte getCoupleJob() {
        return coupleJob;
    }

    public void setCoupleJob(Byte coupleJob) {
        this.coupleJob = coupleJob;
    }

    @ApiModelProperty("最高教育开始时间")
    public Date getHighEduStarttime() {
        return highEduStarttime;
    }

    public void setHighEduStarttime(Date highEduStarttime) {
        this.highEduStarttime = highEduStarttime;
    }

    @ApiModelProperty("最高教育结束时间")
    public Date getHighEduEndtime() {
        return highEduEndtime;
    }

    public void setHighEduEndtime(Date highEduEndtime) {
        this.highEduEndtime = highEduEndtime;
    }

    @ApiModelProperty("0城镇户口1农村户口")
    public Byte getOriginType() {
        return originType;
    }

    public void setOriginType(Byte originType) {
        this.originType = originType;
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

    @ApiModelProperty("买房类型0按揭1全款")
    public Byte getBuyType() {
        return buyType;
    }

    public void setBuyType(Byte buyType) {
        this.buyType = buyType;
    }

    @ApiModelProperty("0商品房1自建房2亲属主住房3租房4其他")
    public Byte getHouseType() {
        return houseType;
    }

    public void setHouseType(Byte houseType) {
        this.houseType = houseType;
    }

    @ApiModelProperty("住宅类型（0普通住宅，1别墅）")
    public Byte getHouseCaty() {
        return houseCaty;
    }

    public void setHouseCaty(Byte houseCaty) {
        this.houseCaty = houseCaty;
    }

    @ApiModelProperty("房子面积")
    public Short getHouseBig() {
        return houseBig;
    }

    public void setHouseBig(Short houseBig) {
        this.houseBig = houseBig;
    }

    @ApiModelProperty("每月按揭金额")
    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    @ApiModelProperty("所在城市")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @ApiModelProperty("所在小区")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @ApiModelProperty("每月收入")
    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    @ApiModelProperty("社保缴纳基数0：5000以下，1：5000-10000，2：10000以上")
    public Byte getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(Byte socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    @ApiModelProperty("公积金缴纳基数0：5000以下，1：5000-10000，2：10000以上")
    public Byte getAccumulationFund() {
        return accumulationFund;
    }

    public void setAccumulationFund(Byte accumulationFund) {
        this.accumulationFund = accumulationFund;
    }

    @ApiModelProperty("京东白条")
    public BigDecimal getJingdongQuto() {
        return jingdongQuto;
    }

    public void setJingdongQuto(BigDecimal jingdongQuto) {
        this.jingdongQuto = jingdongQuto;
    }

    @ApiModelProperty("蚂蚁借呗")
    public BigDecimal getMayijiebQuto() {
        return mayijiebQuto;
    }

    public void setMayijiebQuto(BigDecimal mayijiebQuto) {
        this.mayijiebQuto = mayijiebQuto;
    }

    @ApiModelProperty("花呗")
    public BigDecimal getHuabeiQuto() {
        return huabeiQuto;
    }

    public void setHuabeiQuto(BigDecimal huabeiQuto) {
        this.huabeiQuto = huabeiQuto;
    }

    @ApiModelProperty("负债")
    public BigDecimal getDebit() {
        return debit;
    }

    public void setDebit(BigDecimal debit) {
        this.debit = debit;
    }

    /*@ApiModelProperty(value = "长居城市")
    public String getDomicile() {
        return domicile;
    }

    public void setDomicile(String domicile) {
        this.domicile = domicile;
    }
*/
    @ApiModelProperty(value = "详细地址")
    public String getDomicileDetail() {
        return domicileDetail;
    }

    public void setDomicileDetail(String domicileDetail) {
        this.domicileDetail = domicileDetail;
    }

    @ApiModelProperty(value = "文化程度(0高中及以下1中专2大专3本科4硕士5博士)",dataType = "integer")
    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

//    @ApiModelProperty(value = "家庭月收入")
    /*public BigDecimal getFamilyIncome() {
        return familyIncome;
    }

    public void setFamilyIncome(BigDecimal familyIncome) {
        this.familyIncome = familyIncome;
    }*/


    /*@ApiModelProperty(value = "单位性质(0事业单位，1私营企业2合资企业3外资企业4国有控股企业5国有企业6国家行政机关)",dataType = "integer")
    public Integer getCompanyType() {
        return companyType;
    }*/

//    public void setCompanyType(Integer companyType) {
//        this.companyType = companyType;
//    }

    @ApiModelProperty(value = "单位名称")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @ApiModelProperty(value = "职务")
    public Byte getJob() {
        return job;
    }

    public void setJob(Byte job) {
        this.job = job;
    }

    /*@ApiModelProperty(value = "参加工作时间")
    public Date getWorkTimeStart() {
        return workTimeStart;
    }

    public void setWorkTimeStart(Date workTimeStart) {
        this.workTimeStart = workTimeStart;
    }

    @ApiModelProperty(value = "现单位入职时间")
    public Date getWorkTimeCurrent() {
        return workTimeCurrent;
    }

    public void setWorkTimeCurrent(Date workTimeCurrent) {
        this.workTimeCurrent = workTimeCurrent;
    }*/

    @ApiModelProperty(value = "婚姻状态(0未婚，1已婚未育，2已婚忆育3离异)")
    public Integer getMarriage() {
        return marriage;
    }

    public void setMarriage(Integer marriage) {
        this.marriage = marriage;
    }

    @ApiModelProperty(value = "用户id",name = "memId")
    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    @ApiModelProperty("是否500强")
    public Byte getIsCompanyFivehun() {
        return isCompanyFivehun;
    }

    public void setIsCompanyFivehun(Byte isCompanyFivehun) {
        this.isCompanyFivehun = isCompanyFivehun;
    }

    @ApiModelProperty("紧急联系人")
    public List<PhoneContactDto> getContacts() {
        return contacts;
    }

    public void setContacts(List<PhoneContactDto> contacts) {
        this.contacts = contacts;
    }

    @ApiModelProperty("居住时间")
    public Byte getDomicileTime() {
        return domicileTime;
    }

    public void setDomicileTime(Byte domicileTime) {
        this.domicileTime = domicileTime;
    }

    @ApiModelProperty("子女")
    public List<CreditChildrenDto> getChildren() {
        return children;
    }

    public void setChildren(List<CreditChildrenDto> children) {
        this.children = children;
    }

    @ApiModelProperty("家庭人口(0：2人，1：3人，2：4人，3：5人，4：5人以上)")
    public Byte getFamilyAmount() {
        return familyAmount;
    }

    public void setFamilyAmount(Byte familyAmount) {
        this.familyAmount = familyAmount;
    }

    public String getDomicileProvince() {
        return domicileProvince;
    }

    public void setDomicileProvince(String domicileProvince) {
        this.domicileProvince = domicileProvince;
    }
}
