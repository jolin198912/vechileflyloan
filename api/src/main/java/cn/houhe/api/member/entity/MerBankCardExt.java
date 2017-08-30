package cn.houhe.api.member.entity;

/**
 * Created by Administrator on 2017/4/26.
 */
public class MerBankCardExt {
    /** realName -- 持卡人 */
    private String realName;
    /** mobileNo -- 手机号 */
    private String mobileNo;
    /** idcardno -- 身份证号 */
    private String idCardNo;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    @Override
    public String toString() {
        return "MerBankCardExt{" +
                "realName='" + realName + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", idCardNo='" + idCardNo + '\'' +
                '}';
    }
}
