package cn.houhe.api.loan.web.bo;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * ApllyCreditDto
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-01T09:04:30.957Z")

public class CreditApplyContractDto {

    @NotNull(message = "会员id不能为空")
    @JsonProperty("memId")
    private Integer memId = null;

    private String tokenKey;

    /** is_allow_contact -- 是否允许读取通讯录0否1是 */
    private Byte isAllowContact = 0;

    /** is_allow_record -- 是否允许读取通话记录0否1是 */
    private Byte isAllowRecord = 0;

    /** is_allow_message -- 允许读取短信0否1是 */
    private Byte isAllowMessage = 0;

    /** is_allow_location -- 允许读取定位0否1是 */
    private Byte isAllowLocation = 0;

    //模板id
    private String tid;


    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    /**
     * 白骑士tokenKey
     * @return tokenKey
     **/
    @ApiModelProperty(value = "白骑士tokenKey")
    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }

    public CreditApplyContractDto memId(Integer memId) {
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

    @ApiModelProperty(value = "是否允许读取通讯录0否1是")
    public Byte getIsAllowContact() {
        return isAllowContact;
    }

    public void setIsAllowContact(Byte isAllowContact) {
        this.isAllowContact = isAllowContact;
    }

    @ApiModelProperty(value = "是否允许读取通话记录0否1是")
    public Byte getIsAllowRecord() {
        return isAllowRecord;
    }

    public void setIsAllowRecord(Byte isAllowRecord) {
        this.isAllowRecord = isAllowRecord;
    }

    @ApiModelProperty(value = "允许读取短信0否1是")
    public Byte getIsAllowMessage() {
        return isAllowMessage;
    }

    public void setIsAllowMessage(Byte isAllowMessage) {
        this.isAllowMessage = isAllowMessage;
    }

    @ApiModelProperty(value = "允许读取定位0否1是")
    public Byte getIsAllowLocation() {
        return isAllowLocation;
    }

    public void setIsAllowLocation(Byte isAllowLocation) {
        this.isAllowLocation = isAllowLocation;
    }
}


