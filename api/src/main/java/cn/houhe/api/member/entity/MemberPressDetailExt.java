package cn.houhe.api.member.entity;

/**
 * Created by Administrator on 2017/4/25.
 */
public class MemberPressDetailExt {
    /** memid -- 用户id */
    private Integer memId;
    /** realname -- 姓名 */
    private String realName;
    /** idcardno -- 身份证号 */
    private String idCardNo;
    /** mobileno -- 手机号 */
    private String mobileNo;
    /** longtimecity -- 长居城市 */
    private String longTimeCity;
    /** detailaddr -- 详细地址 */
    private String detailAddr;
    /** url -- 身份证正面照片 */
    private String idCardFrontPic;
    /** url -- 身份证反面照片 */
    private String idCardReversePic;
    /** url -- 人脸识别照片 */
    private String faceRecognitionPic;
    /** linkman -- 联系人 */
    private String linkMan;
    /** linkphone -- 联系人电话 */
    private String linkPhone;

    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getLongTimeCity() {
        return longTimeCity;
    }

    public void setLongTimeCity(String longTimeCity) {
        this.longTimeCity = longTimeCity;
    }

    public String getDetailAddr() {
        return detailAddr;
    }

    public void setDetailAddr(String detailAddr) {
        this.detailAddr = detailAddr;
    }

    public String getIdCardFrontPic() {
        return idCardFrontPic;
    }

    public void setIdCardFrontPic(String idCardFrontPic) {
        this.idCardFrontPic = idCardFrontPic;
    }

    public String getIdCardReversePic() {
        return idCardReversePic;
    }

    public void setIdCardReversePic(String idCardReversePic) {
        this.idCardReversePic = idCardReversePic;
    }

    public String getFaceRecognitionPic() {
        return faceRecognitionPic;
    }

    public void setFaceRecognitionPic(String faceRecognitionPic) {
        this.faceRecognitionPic = faceRecognitionPic;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }
}
