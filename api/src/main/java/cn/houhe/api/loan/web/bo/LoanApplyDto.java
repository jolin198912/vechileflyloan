package cn.houhe.api.loan.web.bo;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * LoanApplyDto
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-01T09:04:30.957Z")

public class LoanApplyDto {
    @JsonProperty("face")
    private String face = null;

    /**
     * 头像资源的id
     */
    /*@JsonProperty
    private Integer faceId ;*/

    @NotNull(message = "会员id不能为空")
    @JsonProperty("memId")
    private Integer memId = null;


    @NotNull(message = "贷款类型不能为空")
    @JsonProperty
    private Integer loanType = 0;

    @NotNull(message = "贷款期限不能为空")
    @JsonProperty
    private Integer time = 7;

    /**
     * 贷款期限id
     */
   /* @JsonProperty
    private Integer timeId;*/

    /**
     * 贷款金额
     */
    @JsonProperty
    private Integer amount = 0;

    /**
     * 银行id
     */
   /* @JsonProperty
    private Integer bank;*/

   /* public Integer getFaceId() {
        return faceId;
    }

    public void setFaceId(Integer faceId) {
        this.faceId = faceId;
    }*/

    /**
     * 人脸图片
     * @return face
     **/
    @ApiModelProperty(value = "人脸图片")
    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }
    public LoanApplyDto memId(Integer memId) {
        this.memId = memId;
        return this;
    }

   /* public Integer getTimeId() {
        return timeId;
    }

    public void setTimeId(Integer timeId) {
        this.timeId = timeId;
    }*/



    /**
     * 用户id
     * @return memId
     **/
    @ApiModelProperty(value = "用户id")
    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }


    public Integer getAmount() {
        return amount;
    }

    public Integer getLoanType() {
        return loanType;
    }

    public void setLoanType(Integer loanType) {
        this.loanType = loanType;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /*public Integer getBank() {
        return bank;
    }

    public void setBank(Integer bank) {
        this.bank = bank;
    }*/
}


