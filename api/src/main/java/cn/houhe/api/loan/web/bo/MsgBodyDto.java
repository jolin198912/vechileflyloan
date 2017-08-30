package cn.houhe.api.loan.web.bo;


import java.math.BigDecimal;

/**
 * Created by victorrrr on 2017/4/24.
 */
public class MsgBodyDto {

    private Integer userId;//用户id
    private String accNo;//银行卡号
    private String accName;//银行卡户主名
    private String mobileNo;//户主手机号（预留手机号）
    private String msgCode;//
    private Double amount;//收款或打款金额
    private  String bankName;//银行名称
    private  String returnUrl;//异步通知地址
    private  String objectId;//收款或打款流水号
    private  String batchNo;//请求批次号
    private  Integer rcdId;//收款，或打款记录id
    private String cardNo;//身份证号码

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Integer getRcdId() {
        return rcdId;
    }

    public void setRcdId(Integer rcdId) {
        this.rcdId = rcdId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
