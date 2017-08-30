package cn.houhe.api.loan.entity.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/10.
 */
public class CreditApplyInfo {
    /** ca_id -- id 主键 */
    private Integer ca_id;

    /** name -- 姓名 */
    @Length(max=10,message="loan.CreditApply.name.Length")
    private String name;

    /** id_card -- 身份证号码 */
    @NotEmpty(message="loan.CreditApply.idCard.NotEmpty")
    @Length(max=18,message="loan.CreditApply.idCard.Length")
    private String id_card;

    /** couple_card -- 配偶身份证号码 */
    @NotEmpty(message="loan.CreditApply.coupleCard.NotEmpty")
    @Length(max=18,message="loan.CreditApply.coupleCard.Length")
    private String couple_card;

    /** couple_mobile -- 配偶手机号码 */
    @Length(max=20,message="loan.CreditApply.coupleMobile.Length")
    private String couple_mobile;

    /** couple_name -- 配偶姓名 */
    @Length(max=10,message="loan.CreditApply.coupleName.Length")
    private String couple_name;

    /** couple_education -- 配偶文化程度(0其他1高中及以下2大专3本科4硕士5博士) */
    private Byte couple_education;

    /** couple_job -- 配偶职业(0照顾孩子，1工作，2个体户，3务农) */
    private Byte couple_job;

    /** sex -- 性别0男1女 */
    @NotNull(message="loan.CreditApply.sex.NotNull")
    private Byte sex;

    /** birthday -- 生日 */
    private Date birthday;

    /** origin_type -- 0城镇户口1农村户口 */
    @NotNull(message="loan.CreditApply.originType.NotNull")
    private Byte origin_type;

    /** domicile_detail -- 居住地址 */
    @Length(max=100,message="loan.CreditApply.domicileDetail.Length")
    private String domicile_detail;

    /** domicile_time -- 居住时间（0：1年以下，1：1~3年， 2：3~7年，3：7年以上） */
    private Byte domicile_time;

    /** nation -- 民族 */
    @Length(max=10,message="loan.CreditApply.nation.Length")
    private String nation;

    /** education -- 文化程度(0其他1高中及以下2大专3本科4硕士5博士) */
    private Byte education;

    /** high_edu_starttime -- 最高教育开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date high_edu_starttime;

    /** high_edu_endtime -- 最高教育结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date high_edu_endtime;

    /** company_name -- 单位名称 */
    @Length(max=100,message="loan.CreditApply.companyName.Length")
    private String company_name;

    /** com_bus_time_length -- 公司经营时长（年） */
    @NotNull(message="loan.CreditApply.comBusTimeLength.NotNull")
    private Short com_bus_time_length;

    /** is_company_fivehun -- 是否是500强0否1是 */
    @NotNull(message="loan.CreditApply.isCompanyFivehun.NotNull")
    private Byte is_company_fivehun;

    /** is_allow_contact -- 是否允许读取通讯录0否1是 */
    @NotNull(message="loan.CreditApply.isAllowContact.NotNull")
    private Byte is_allow_contact;

    /** is_allow_record -- 是否允许读取通话记录0否1是 */
    @NotNull(message="loan.CreditApply.isAllowRecord.NotNull")
    private Byte is_allow_record;

    /** is_allow_message -- 允许读取短信0否1是 */
    @NotNull(message="loan.CreditApply.isAllowMessage.NotNull")
    private Byte is_allow_message;

    /** is_allow_location -- 允许读取定位0否1是 */
    @NotNull(message="loan.CreditApply.isAllowLocation.NotNull")
    private Byte is_allow_location;

    /** job -- 职务（0普通员工，1基层管理，2中层管理，3高层管理） */
    private Byte job;

    /** industry -- 行业（互联网，教育等） */
    @Length(max=50,message="loan.CreditApply.industry.Length")
    private String industry;

    /** work_place -- 单位地址 */
    @Length(max=200,message="loan.CreditApply.workPlace.Length")
    private String work_place;

    /** work_experience -- 工作经验 */
    @Length(max=50,message="loan.CreditApply.workExperience.Length")
    private String work_experience;

    /** wanted_limit -- 期望额度 */
    private Integer wanted_limit;

    /** wanted_period -- 期望还款期限 */
    private Byte wanted_period;

    /** wanted_repay_day -- 期望还款日期 */
    private Byte wanted_repay_day;

    /** marriage -- 婚姻状态(0单身，1离异，2丧偶，3已婚) */
    @NotNull(message="loan.CreditApply.marriage.NotNull")
    private Byte marriage;

    /** child_amount -- 子女个数 */
    @NotNull(message="loan.CreditApply.childAmount.NotNull")
    private Byte child_amount;

    /** family_amount -- 家庭人口(0：2人，1：3人，2：4人，3：5人，4：5人以上) */
    @NotNull(message="loan.CreditApply.familyAmount.NotNull")
    private Byte family_amount;

    /** apply_time -- 申请时间 */
    private Date apply_time;

    /** year_pay -- 保险年缴纳费（0：5000以下，1：5000~10000，2：10000以上） */
    @NotNull(message="loan.CreditApply.yearPay.NotNull")
    private BigDecimal year_pay;

    /** qq -- QQ号 */
    @Length(max=20,message="loan.CreditApply.qq.Length")
    private String qq;

    /** qq_age -- qq年龄 */
    @NotNull(message="loan.CreditApply.qqAge.NotNull")
    private Short qq_age;

    /** wx_age -- 微信年龄 */
    @NotNull(message="loan.CreditApply.wxAge.NotNull")
    private Short wx_age;

    /** wx -- 微信号 */
    @Length(max=50,message="loan.CreditApply.wx.Length")
    private String wx;

    /** fengkong_state -- 风控状态0未经过风控评估1已经过风控评估 */
    @NotNull(message="loan.CreditApply.fengkongState.NotNull")
    private Byte fengkong_state;

    /** apply_state -- 审核状态（0填写资料申请中1提交完资料审批中2初审通过3初审不通过4终审通过5终审不通过6自动审批通过7自动审批不通过） */
    @NotNull(message="loan.CreditApply.applyState.NotNull")
    private Byte apply_state;

    /** apply_step -- 申请步骤 */
    @NotNull(message="loan.CreditApply.applyStep.NotNull")
    private Byte apply_step;

    /** member_id -- 用户id */
    @NotNull(message="loan.CreditApply.memberId.NotNull")
    private Integer member_id;

    /** createdon --  */
    @NotNull(message="loan.CreditApply.createdon.NotNull")
    private Date createdon;

    /** remark -- 备注 */
    @Length(max=30,message="loan.CreditApply.remark.Length")
    private String remark;

    //审核备注
    private String auditremark;

    /** buy_type -- 买房类型0按揭1全款 */
    @NotNull(message="loan.CreditApply.buyType.NotNull")
    private Byte buy_type;

    /** house_type -- 0其他1租房2亲属住房3自建房4商品房 */
    @NotNull(message="loan.CreditApply.houseType.NotNull")
    private Byte house_type;

    /** house_caty -- 住宅类型（0普通住宅，1别墅） */
    @NotNull(message="loan.CreditApply.houseCaty.NotNull")
    private Byte house_caty;

    /** house_big -- 房子面积 */
    @NotNull(message="loan.CreditApply.houseBig.NotNull")
    private Short house_big;

    /** loan_amount -- 每月按揭金额 */
    @NotNull(message="loan.CreditApply.loanAmount.NotNull")
    private BigDecimal loan_amount;

    /** city -- 所在城市 */
    @Length(max=50,message="loan.CreditApply.city.Length")
    private String city;

    /** area -- 所在小区 */
    @Length(max=50,message="loan.CreditApply.area.Length")
    private String area;

    /** income -- 每月收入（0：5000以下，1：5000~10000，2：10000以上） */
    @NotNull(message="loan.CreditApply.income.NotNull")
    private BigDecimal income;

    /** social_security -- 社保缴纳基数0：5000以下，1：5000-10000，2：10000以上 */
    @NotNull(message="loan.CreditApply.socialSecurity.NotNull")
    private Byte social_security;

    /** accumulation_fund -- 公积金缴纳基数0：5000以下，1：5000-10000，2：10000以上 */
    @NotNull(message="loan.CreditApply.accumulationFund.NotNull")
    private Byte accumulation_fund;

    /** jingdong_quto -- 京东白条额度 */
    @NotNull(message="loan.CreditApply.jingdongQuto.NotNull")
    private BigDecimal jingdong_quto;

    /** mayijieb_quto -- 蚂蚁借呗额度 */
    @NotNull(message="loan.CreditApply.mayijiebQuto.NotNull")
    private BigDecimal mayijieb_quto;

    /** huabei_quto -- 蚂蚁花呗额度 */
    @NotNull(message="loan.CreditApply.huabeiQuto.NotNull")
    private BigDecimal huabei_quto;

    /** debit -- 负债 */
    @NotNull(message="loan.CreditApply.debit.NotNull")
    private BigDecimal debit;

    /** car_number -- 车牌号 */
    @Length(max=10,message="loan.CreditApply.carNumber.Length")
    private String car_number;

    /** car_brand -- 车辆品牌 */
    @Length(max=20,message="loan.CreditApply.carBrand.Length")
    private String car_brand;

    /** car_lisence -- 驾照登记地址 */
    @Length(max=100,message="loan.CreditApply.carLisence.Length")
    private String car_lisence;

    /** car_property -- 车辆性质（非运营0运营1） */
    @NotNull(message="loan.CreditApply.carProperty.NotNull")
    private Byte car_property;

    /** car_driven -- 驾龄 */
    @NotNull(message="loan.CreditApply.carDriven.NotNull")
    private Byte car_driven;

    /** car_owner -- 车辆所有人 */
    @Length(max=20,message="loan.CreditApply.carOwner.Length")
    private String car_owner;

    /** car_code -- 车辆识别代码 */
    @Length(max=20,message="loan.CreditApply.carCode.Length")
    private String car_code;

    /** buy_date -- 购买日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date buy_date;

    /** counts -- 第几辆车（0第一辆，1第二辆，2第三辆，3第四辆及以上） */
    @NotNull(message="loan.CreditApply.counts.NotNull")
    private Short counts;

    /** price -- 购买价格 */
    @NotNull(message="loan.CreditApply.price.NotNull")
    private BigDecimal price;

    /** car_insurance_amount -- 保费金额 */
    @NotNull(message="loan.CreditApply.carInsuranceAmount.NotNull")
    private BigDecimal car_insurance_amount;

    //系统授信额度
    private BigDecimal slimit;

    //授信额度
    private  BigDecimal alimit;

    //手机号
    private String mobile;

    //身份证正面
    private String front;

    //身份证反面
    private String back;

    //人脸
    private String face;

    //行驶证正面
    private String dfront;

    //行驶证反面
    private String dback;

    //驾驶证正面
    private String jfront;

    //驾驶证反面
    private String jback;

    /** education_state -- 文化程度 */
    private Byte education_state;

    /** education_time_state -- 教育开始结束时间 */
    private Byte education_time_state;

    /** couple_name_state -- 配偶姓名 */
    private Byte couple_name_state;

    /** couple_mobile_state -- 配偶手机号 */
    private Byte couple_mobile_state;

    /** couple_idcard_state -- 配偶身份证 */
    private Byte couple_idcard_state;

    /** couple_edu_state -- 配偶文化程度 */
    private Byte couple_edu_state;

    /** address_state -- 居住地址 */
    private Byte address_state;

    private static final long serialVersionUID = 1L;

    public Integer getCa_id() {
        return ca_id;
    }

    public void setCa_id(Integer ca_id) {
        this.ca_id = ca_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getCouple_card() {
        return couple_card;
    }

    public void setCouple_card(String couple_card) {
        this.couple_card = couple_card;
    }

    public String getCouple_mobile() {
        return couple_mobile;
    }

    public void setCouple_mobile(String couple_mobile) {
        this.couple_mobile = couple_mobile;
    }

    public String getCouple_name() {
        return couple_name;
    }

    public void setCouple_name(String couple_name) {
        this.couple_name = couple_name;
    }

    public Byte getCouple_education() {
        return couple_education;
    }

    public void setCouple_education(Byte couple_education) {
        this.couple_education = couple_education;
    }

    public Byte getCouple_job() {
        return couple_job;
    }

    public void setCouple_job(Byte couple_job) {
        this.couple_job = couple_job;
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

    public Byte getOrigin_type() {
        return origin_type;
    }

    public void setOrigin_type(Byte origin_type) {
        this.origin_type = origin_type;
    }

    public String getDomicile_detail() {
        return domicile_detail;
    }

    public void setDomicile_detail(String domicile_detail) {
        this.domicile_detail = domicile_detail;
    }

    public Byte getDomicile_time() {
        return domicile_time;
    }

    public void setDomicile_time(Byte domicile_time) {
        this.domicile_time = domicile_time;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Byte getEducation() {
        return education;
    }

    public void setEducation(Byte education) {
        this.education = education;
    }

    public Date getHigh_edu_starttime() {
        return high_edu_starttime;
    }

    public void setHigh_edu_starttime(Date high_edu_starttime) {
        this.high_edu_starttime = high_edu_starttime;
    }

    public Date getHigh_edu_endtime() {
        return high_edu_endtime;
    }

    public void setHigh_edu_endtime(Date high_edu_endtime) {
        this.high_edu_endtime = high_edu_endtime;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Short getCom_bus_time_length() {
        return com_bus_time_length;
    }

    public void setCom_bus_time_length(Short com_bus_time_length) {
        this.com_bus_time_length = com_bus_time_length;
    }

    public Byte getIs_company_fivehun() {
        return is_company_fivehun;
    }

    public void setIs_company_fivehun(Byte is_company_fivehun) {
        this.is_company_fivehun = is_company_fivehun;
    }

    public Byte getIs_allow_contact() {
        return is_allow_contact;
    }

    public void setIs_allow_contact(Byte is_allow_contact) {
        this.is_allow_contact = is_allow_contact;
    }

    public Byte getIs_allow_record() {
        return is_allow_record;
    }

    public void setIs_allow_record(Byte is_allow_record) {
        this.is_allow_record = is_allow_record;
    }

    public Byte getIs_allow_message() {
        return is_allow_message;
    }

    public void setIs_allow_message(Byte is_allow_message) {
        this.is_allow_message = is_allow_message;
    }

    public Byte getIs_allow_location() {
        return is_allow_location;
    }

    public void setIs_allow_location(Byte is_allow_location) {
        this.is_allow_location = is_allow_location;
    }

    public Byte getJob() {
        return job;
    }

    public void setJob(Byte job) {
        this.job = job;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getWork_place() {
        return work_place;
    }

    public void setWork_place(String work_place) {
        this.work_place = work_place;
    }

    public String getWork_experience() {
        return work_experience;
    }

    public void setWork_experience(String work_experience) {
        this.work_experience = work_experience;
    }

    public Integer getWanted_limit() {
        return wanted_limit;
    }

    public void setWanted_limit(Integer wanted_limit) {
        this.wanted_limit = wanted_limit;
    }

    public Byte getWanted_period() {
        return wanted_period;
    }

    public void setWanted_period(Byte wanted_period) {
        this.wanted_period = wanted_period;
    }

    public Byte getWanted_repay_day() {
        return wanted_repay_day;
    }

    public void setWanted_repay_day(Byte wanted_repay_day) {
        this.wanted_repay_day = wanted_repay_day;
    }

    public Byte getMarriage() {
        return marriage;
    }

    public void setMarriage(Byte marriage) {
        this.marriage = marriage;
    }

    public Byte getChild_amount() {
        return child_amount;
    }

    public void setChild_amount(Byte child_amount) {
        this.child_amount = child_amount;
    }

    public Byte getFamily_amount() {
        return family_amount;
    }

    public void setFamily_amount(Byte family_amount) {
        this.family_amount = family_amount;
    }

    public Date getApply_time() {
        return apply_time;
    }

    public void setApply_time(Date apply_time) {
        this.apply_time = apply_time;
    }

    public BigDecimal getYear_pay() {
        return year_pay;
    }

    public void setYear_pay(BigDecimal year_pay) {
        this.year_pay = year_pay;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Short getQq_age() {
        return qq_age;
    }

    public void setQq_age(Short qq_age) {
        this.qq_age = qq_age;
    }

    public Short getWx_age() {
        return wx_age;
    }

    public void setWx_age(Short wx_age) {
        this.wx_age = wx_age;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public Byte getFengkong_state() {
        return fengkong_state;
    }

    public void setFengkong_state(Byte fengkong_state) {
        this.fengkong_state = fengkong_state;
    }

    public Byte getApply_state() {
        return apply_state;
    }

    public void setApply_state(Byte apply_state) {
        this.apply_state = apply_state;
    }

    public Byte getApply_step() {
        return apply_step;
    }

    public void setApply_step(Byte apply_step) {
        this.apply_step = apply_step;
    }

    public Integer getMember_id() {
        return member_id;
    }

    public void setMember_id(Integer member_id) {
        this.member_id = member_id;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getBuy_type() {
        return buy_type;
    }

    public void setBuy_type(Byte buy_type) {
        this.buy_type = buy_type;
    }

    public Byte getHouse_type() {
        return house_type;
    }

    public void setHouse_type(Byte house_type) {
        this.house_type = house_type;
    }

    public Byte getHouse_caty() {
        return house_caty;
    }

    public void setHouse_caty(Byte house_caty) {
        this.house_caty = house_caty;
    }

    public Short getHouse_big() {
        return house_big;
    }

    public void setHouse_big(Short house_big) {
        this.house_big = house_big;
    }

    public BigDecimal getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(BigDecimal loan_amount) {
        this.loan_amount = loan_amount;
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

    public Byte getSocial_security() {
        return social_security;
    }

    public void setSocial_security(Byte social_security) {
        this.social_security = social_security;
    }

    public Byte getAccumulation_fund() {
        return accumulation_fund;
    }

    public void setAccumulation_fund(Byte accumulation_fund) {
        this.accumulation_fund = accumulation_fund;
    }

    public BigDecimal getJingdong_quto() {
        return jingdong_quto;
    }

    public void setJingdong_quto(BigDecimal jingdong_quto) {
        this.jingdong_quto = jingdong_quto;
    }

    public BigDecimal getMayijieb_quto() {
        return mayijieb_quto;
    }

    public void setMayijieb_quto(BigDecimal mayijieb_quto) {
        this.mayijieb_quto = mayijieb_quto;
    }

    public BigDecimal getHuabei_quto() {
        return huabei_quto;
    }

    public void setHuabei_quto(BigDecimal huabei_quto) {
        this.huabei_quto = huabei_quto;
    }

    public BigDecimal getDebit() {
        return debit;
    }

    public void setDebit(BigDecimal debit) {
        this.debit = debit;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public String getCar_brand() {
        return car_brand;
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public String getCar_lisence() {
        return car_lisence;
    }

    public void setCar_lisence(String car_lisence) {
        this.car_lisence = car_lisence;
    }

    public Byte getCar_property() {
        return car_property;
    }

    public void setCar_property(Byte car_property) {
        this.car_property = car_property;
    }

    public Byte getCar_driven() {
        return car_driven;
    }

    public void setCar_driven(Byte car_driven) {
        this.car_driven = car_driven;
    }

    public String getCar_owner() {
        return car_owner;
    }

    public void setCar_owner(String car_owner) {
        this.car_owner = car_owner;
    }

    public String getCar_code() {
        return car_code;
    }

    public void setCar_code(String car_code) {
        this.car_code = car_code;
    }

    public Date getBuy_date() {
        return buy_date;
    }

    public void setBuy_date(Date buy_date) {
        this.buy_date = buy_date;
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

    public BigDecimal getCar_insurance_amount() {
        return car_insurance_amount;
    }

    public void setCar_insurance_amount(BigDecimal car_insurance_amount) {
        this.car_insurance_amount = car_insurance_amount;
    }

    public BigDecimal getSlimit() {
        return slimit;
    }

    public void setSlimit(BigDecimal slimit) {
        this.slimit = slimit;
    }

    public BigDecimal getAlimit() {
        return alimit;
    }

    public void setAlimit(BigDecimal alimit) {
        this.alimit = alimit;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getDfront() {
        return dfront;
    }

    public void setDfront(String dfront) {
        this.dfront = dfront;
    }

    public String getDback() {
        return dback;
    }

    public void setDback(String dback) {
        this.dback = dback;
    }

    public String getJfront() {
        return jfront;
    }

    public void setJfront(String jfront) {
        this.jfront = jfront;
    }

    public String getJback() {
        return jback;
    }

    public void setJback(String jback) {
        this.jback = jback;
    }

    public String getAuditremark() {
        return auditremark;
    }

    public void setAuditremark(String auditremark) {
        this.auditremark = auditremark;
    }

    public Byte getEducation_state() {
        return education_state;
    }

    public void setEducation_state(Byte education_state) {
        this.education_state = education_state;
    }

    public Byte getEducation_time_state() {
        return education_time_state;
    }

    public void setEducation_time_state(Byte education_time_state) {
        this.education_time_state = education_time_state;
    }

    public Byte getCouple_name_state() {
        return couple_name_state;
    }

    public void setCouple_name_state(Byte couple_name_state) {
        this.couple_name_state = couple_name_state;
    }

    public Byte getCouple_mobile_state() {
        return couple_mobile_state;
    }

    public void setCouple_mobile_state(Byte couple_mobile_state) {
        this.couple_mobile_state = couple_mobile_state;
    }

    public Byte getCouple_idcard_state() {
        return couple_idcard_state;
    }

    public void setCouple_idcard_state(Byte couple_idcard_state) {
        this.couple_idcard_state = couple_idcard_state;
    }

    public Byte getCouple_edu_state() {
        return couple_edu_state;
    }

    public void setCouple_edu_state(Byte couple_edu_state) {
        this.couple_edu_state = couple_edu_state;
    }

    public Byte getAddress_state() {
        return address_state;
    }

    public void setAddress_state(Byte address_state) {
        this.address_state = address_state;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
