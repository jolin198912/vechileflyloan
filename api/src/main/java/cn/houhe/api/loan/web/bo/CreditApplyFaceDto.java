package cn.houhe.api.loan.web.bo;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * ApllyCreditDto
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-01T09:04:30.957Z")

public class CreditApplyFaceDto {
    @NotNull(message = "头像不能为空")
    @JsonProperty("face")
    private String face = null;

    /**
     *
     */
    private Integer faceId;

    @NotNull(message = "会员id不能为空")
    @JsonProperty("memId")
    private Integer memId = null;



    @JsonProperty
    private Float confidence = 0f;

    public Integer getFaceId() {
        return faceId;
    }

    public void setFaceId(Integer faceId) {
        this.faceId = faceId;
    }

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

    public CreditApplyFaceDto memId(Integer memId) {
        this.memId = memId;
        return this;
    }

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

    public Float getConfidence() {
        return confidence;
    }

    public void setConfidence(Float confidence) {
        this.confidence = confidence;
    }
}


