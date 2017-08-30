package cn.houhe.api.loan.entity.bo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by think on 2017/4/10.
 */
public class CreditApplyInfoObject implements Serializable{
    /** name -- 姓名 */
    private String name;

    /** id_card -- 身份证号码 */
    private String idCard;

    /** domicile -- 长居城市 */
    private String domicile;

    /** plate_number -- 车牌号 */
    private String plateNumber;

    /** car_type -- 车辆类型 */
    private String carType;

    /** car_brand -- 车辆品牌 */
    private String carBrand;

    /** car_property -- 车辆性质 */
    private String carProperty;

    /** car_owner -- 车辆所有人 */
    private String carOwner;

    /** domicile_detail -- 详细地址 */
    private String domicileDetail;

    /** education -- 文化程度(0高中及以下1中专2大专3本科4硕士5博士) */
    private Byte education;

    /** family_income -- 家庭月收入 */
    private BigDecimal familyIncome;

    /** company_type -- 单位性质(0事业单位，1私营企业2合资企业3外资企业4国有控股企业5国有企业6国家行政机关) */
    private Byte companyType;

    /** company_name -- 单位名称 */
    private String companyName;

    /** job -- 职务 */
    private String job;

    @JsonFormat(pattern = "yyyy-MM-dd")
    /** work_time_start -- 参加工作时间 */
    private Date workTimeStart;

    @JsonFormat(pattern = "yyyy-MM-dd")
    /** work_time_current -- 现单位入职时间 */
    private Date workTimeCurrent;

    /** marriage -- 婚姻状态(0未婚，1已婚未育，2已婚已育3离异) */
    private Byte marriage;

    /** child_amount -- 子女个数 */
    private Byte childAmount;

    /** apply_time -- 申请时间 */
    private Date applyTime;

    /** apply_state -- 审核状态（0填写资料申请中1填写完资料审批中2初审通过3初审不通过4终审通过5终审不通过6自动审批通过7自动审批不通过） */
    private Byte applyState;


    /** member_id -- 用户id */
    private Integer memberId;

    /**
     * 身份证正面
     */
    private String front;

    /**
     * 身份证反面
     */
    private String back;

    /**
     * 身份证脸部
     */
    private String face;

    /**
     * 系统授信额度
     */
    private int slimit;

    /**
     * 审核额度
     */
    private int alimit;


    /**
     * 电话
     */
    private String mobile;

    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getDomicile() {
        return domicile;
    }

    public void setDomicile(String domicile) {
        this.domicile = domicile;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarProperty() {
        return carProperty;
    }

    public void setCarProperty(String carProperty) {
        this.carProperty = carProperty;
    }

    public String getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner;
    }

    public String getDomicileDetail() {
        return domicileDetail;
    }

    public void setDomicileDetail(String domicileDetail) {
        this.domicileDetail = domicileDetail;
    }

    public Byte getEducation() {
        return education;
    }

    public void setEducation(Byte education) {
        this.education = education;
    }

    public BigDecimal getFamilyIncome() {
        return familyIncome;
    }

    public void setFamilyIncome(BigDecimal familyIncome) {
        this.familyIncome = familyIncome;
    }

    public Byte getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Byte companyType) {
        this.companyType = companyType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getWorkTimeStart() {
        return workTimeStart;
    }

    public void setWorkTimeStart(Date workTimeStart) {
        this.workTimeStart = workTimeStart;
    }

    public Date getWorkTimeCurrent() {
        return workTimeCurrent;
    }

    public void setWorkTimeCurrent(Date workTimeCurrent) {
        this.workTimeCurrent = workTimeCurrent;
    }

    public Byte getMarriage() {
        return marriage;
    }

    public void setMarriage(Byte marriage) {
        this.marriage = marriage;
    }

    public Byte getChildAmount() {
        return childAmount;
    }

    public void setChildAmount(Byte childAmount) {
        this.childAmount = childAmount;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Byte getApplyState() {
        return applyState;
    }

    public void setApplyState(Byte applyState) {
        this.applyState = applyState;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
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

    public int getSlimit() {
        return slimit;
    }

    public void setSlimit(int slimit) {
        this.slimit = slimit;
    }

    public int getAlimit() {
        return alimit;
    }

    public void setAlimit(int alimit) {
        this.alimit = alimit;
    }

    @Override
    public String toString() {
        return "CreditApplyInfoObject{" +
                "name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", domicile='" + domicile + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", carType='" + carType + '\'' +
                ", carBrand='" + carBrand + '\'' +
                ", carProperty='" + carProperty + '\'' +
                ", carOwner='" + carOwner + '\'' +
                ", domicileDetail='" + domicileDetail + '\'' +
                ", education=" + education +
                ", familyIncome=" + familyIncome +
                ", companyType=" + companyType +
                ", companyName='" + companyName + '\'' +
                ", job='" + job + '\'' +
                ", workTimeStart=" + workTimeStart +
                ", workTimeCurrent=" + workTimeCurrent +
                ", marriage=" + marriage +
                ", childAmount=" + childAmount +
                ", applyTime=" + applyTime +
                ", applyState=" + applyState +
                ", memberId=" + memberId +
                ", front='" + front + '\'' +
                ", back='" + back + '\'' +
                ", face='" + face + '\'' +
                ", slimit=" + slimit +
                ", alimit=" + alimit +
                ", applyTime=" + applyTime +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
