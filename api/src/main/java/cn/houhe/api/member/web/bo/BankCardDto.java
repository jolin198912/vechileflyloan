package cn.houhe.api.member.web.bo;

/**
 * Created by Administrator on 2017/4/1.
 */
public class BankCardDto {
    /** member_id -- 会员id */
    private Integer memberId;
    /** cardholder -- 持卡人 */
    private String cardholder;
    /** bankcardno -- 银行卡号 */
    private String bankcardno;
    /** collectingbank -- 收款银行 */
    private String collectingbank;
    /** reservedmobile -- 银行预留手机号 */
    private String reservedmobile;
    /** verificode -- 验证码 */
    private String verificode;
    /* idcardno -- 身份证号*/
    private String idcardno;
    /* msgcode -- 短信验证码*/
    private String msgcode;
    /* batchno -- 请求流水号*/
    private String batchno;

    /** 获取会员id */
    public Integer getMemberId() {
        return memberId;
    }

    /** 设置会员id */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /** 获取持卡人 */
    public String getCardholder() {
        return cardholder;
    }

    /** 设置持卡人 */
    public void setCardholder(String cardholder) {
        this.cardholder = cardholder == null ? null : cardholder.trim();
    }

    /** 获取银行卡号 */
    public String getBankcardno() {
        return bankcardno;
    }

    /** 设置银行卡号 */
    public void setBankcardno(String bankcardno) {
        this.bankcardno = bankcardno == null ? null : bankcardno.trim();
    }

    /** 获取收款银行 */
    public String getCollectingbank() {
        return collectingbank;
    }

    /** 设置收款银行 */
    public void setCollectingbank(String collectingbank) {
        this.collectingbank = collectingbank == null ? null : collectingbank.trim();
    }

    /** 获取银行预留手机号 */
    public String getReservedmobile() {
        return reservedmobile;
    }

    /** 设置银行预留手机号 */
    public void setReservedmobile(String reservedmobile) {
        this.reservedmobile = reservedmobile == null ? null : reservedmobile.trim();
    }

    /** 获取验证码 */
    public String getVerificode() {
        return verificode;
    }

    /** 设置验证码 */
    public void setVerificode(String verificode) {
        this.verificode = verificode;
    }

    public String getIdcardno() {
        return idcardno;
    }

    public void setIdcardno(String idcardNo) {
        this.idcardno = idcardNo;
    }

    public String getMsgcode() {
        return msgcode;
    }

    public void setMsgcode(String msgcode) {
        this.msgcode = msgcode;
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno;
    }
}
