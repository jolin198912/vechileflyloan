package cn.houhe.api.loan.web.bo;

import cn.houhe.api.loan.entity.LoanContract;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * CreditApplyInfoDto
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-01T09:57:34.833Z")

public class CreditApplyInfo {
  @JsonProperty("memId")
  private Integer memberId = null;

  @JsonProperty("state")
  private Integer applyState = 0;


  @JsonProperty("step")
  private Integer applyStep = 1;

  /** apply_time -- 申请时间 */
  private Date applyTime;

  /**
   * 芝麻信用openId
   */
  private String authAlOpenId = "";

  public CreditApplyInfo memId(Integer memId) {
    this.memberId = memId;
    return this;
  }

  /**
   * 正面
   */
  private String front;

  /**
   * 反面
   */
  private String back;

  /**
   * 脸部
   */
  private String face;

  /** name -- 姓名 */
  private String name;

  /** id_card -- 身份证号码 */
  private String idCard;

  /** domicile -- 长居城市 */
  private String domicile;

  /** domicile_detail -- 详细地址 */
  private String domicileDetail;

  /** education -- 文化程度 */
  private Byte education;

  /** family_income -- 家庭月收入 */
  @NotNull(message="repay.CreditApply.familyIncome.NotNull")
  private BigDecimal familyIncome;

  /** company_type -- 单位性质 */
  @Length(max=50,message="repay.CreditApply.companyType.Length")
  private String companyType;

  /** company_name -- 单位名称 */
  @Length(max=100,message="repay.CreditApply.companyName.Length")
  private String companyName;

  /** job -- 职务 */
  @Length(max=50,message="repay.CreditApply.job.Length")
  private String job;

  /** work_time_start -- 参加工作时间 */
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date workTimeStart;

  /** work_time_current -- 现单位入职时间 */
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date workTimeCurrent;

  /** marriage -- 婚姻状态 */
  private Byte marriage;

  /** child_amount -- 子女个数 */
  private Byte childAmount;

  private String reg ;
  private String loan ;
  private String creditQuery ;
  private String collection ;

  /**
   * 行驶证正面
   */
  @JsonProperty
  private String dfront;

  /**
   * 行驶证副页
   */
  private String dback;


  private Integer authAl = 0;

  private Integer authCr = 0;

  private Integer authOp = 0;

  private List<LoanContract> contracts = new ArrayList<>();

  public List<LoanContract> getContracts() {
    return contracts;
  }

  public void setContracts(List<LoanContract> contracts) {
    this.contracts = contracts;
  }

  public Integer getAuthAl() {
    return authAl;
  }

  public void setAuthAl(Integer authAl) {
    this.authAl = authAl;
  }

  public Integer getAuthCr() {
    return authCr;
  }

  public void setAuthCr(Integer authCr) {
    this.authCr = authCr;
  }

  public Integer getAuthOp() {
    return authOp;
  }

  public void setAuthOp(Integer authOp) {
    this.authOp = authOp;
  }

  @ApiModelProperty(value = "行驶证正面")
  public String getDfront() {
    return dfront;
  }

  public void setDfront(String dfront) {
    this.dfront = dfront;
  }

  @ApiModelProperty(value = "行驶证副页")
  public String getDback() {
    return dback;
  }

  public void setDback(String dback) {
    this.dback = dback;
  }


  @ApiModelProperty(value = "用户注册协议")
  public String getReg() {
    return reg;
  }

  public void setReg(String reg) {
    this.reg = reg;
  }
  @ApiModelProperty(value = "额度借款合同")
  public String getLoan() {
    return loan;
  }

  public void setLoan(String loan) {
    this.loan = loan;
  }
  @ApiModelProperty(value = "征信查询")
  public String getCreditQuery() {
    return creditQuery;
  }

  public void setCreditQuery(String creditQuery) {
    this.creditQuery = creditQuery;
  }
  @ApiModelProperty(value = "委托代收")
  public String getCollection() {
    return collection;
  }

  public void setCollection(String collection) {
    this.collection = collection;
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

  public String getCompanyType() {
    return companyType;
  }

  public void setCompanyType(String companyType) {
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


  public String getFace() {
    return face;
  }

  public void setFace(String face) {
    this.face = face;
  }

  /**
   * 用户id
   * @return memId
  **/
  @ApiModelProperty(value = "用户id")
  public Integer getMemberId() {
    return memberId;
  }

  public void setMemberId(Integer memId) {
    this.memberId = memId;
  }

  /**
   * 状态
   * @return applyStep
   **/
  @ApiModelProperty(value = "审核状态（0：填写资料申请中，1：填写完资料初审中，2：初审通过3初审不通过，4：终审通过，5：终审不通过）")
  public Integer getApplyState() {
    return applyState;
  }

  public void setApplyState(Integer applyState) {
    this.applyState = applyState;
  }


  public Date getApplyTime() {
    return applyTime;
  }

  public void setApplyTime(Date applyTime) {
    this.applyTime = applyTime;
  }

  /**
   * 步骤
   * @return applyStep
   **/
  @ApiModelProperty(value = "审核步骤（1：填写身份证）")
  public Integer getApplyStep() {
    return applyStep;
  }

  public void setApplyStep(Integer applyStep) {
    this.applyStep = applyStep;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreditApplyInfo apllyCreditInfoDto = (CreditApplyInfo) o;
    return Objects.equals(this.memberId, apllyCreditInfoDto.memberId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(memberId);
  }

  @Override
  public String toString() {
    return "CreditApplyInfo{" +
            "memberId=" + memberId +
            ", applyState=" + applyState +
            ", applyStep=" + applyStep +
            ", applyTime=" + applyTime +
            ", front='" + front + '\'' +
            ", back='" + back + '\'' +
            ", face='" + face + '\'' +
            ", name='" + name + '\'' +
            ", idCard='" + idCard + '\'' +
            ", domicile='" + domicile + '\'' +
            ", domicileDetail='" + domicileDetail + '\'' +
            ", education=" + education +
            ", familyIncome=" + familyIncome +
            ", companyType='" + companyType + '\'' +
            ", companyName='" + companyName + '\'' +
            ", job='" + job + '\'' +
            ", workTimeStart=" + workTimeStart +
            ", workTimeCurrent=" + workTimeCurrent +
            ", marriage=" + marriage +
            ", childAmount=" + childAmount +
            ", reg='" + reg + '\'' +
            ", loan='" + loan + '\'' +
            ", creditQuery='" + creditQuery + '\'' +
            ", collection='" + collection + '\'' +
            '}';
  }

  public void setAuthAlOpenId(String authAlOpenId) {
    this.authAlOpenId = authAlOpenId;
  }

  public String getAuthAlOpenId() {
    return authAlOpenId;
  }
}

