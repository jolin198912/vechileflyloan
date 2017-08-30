package cn.houhe.api.member.web.bo;

/**
 * Created by Administrator on 2017/4/6.
 */
public class LoanRatesDto {
    /** member_id -- 会员id */
    private Integer memberId;

    /** 获取会员id */
    public Integer getMemberId() {
        return memberId;
    }

    /** 设置会员id */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /** type -- 贷款期限类型（0：30天内还款，1：一年内还款） */
    private Byte type;

    /** type -- 获取贷款期限类型（0：30天内还款，1：一年内还款） */
    public Byte getType() {
        return type;
    }

    /** type -- 设置贷款期限类型（0：30天内还款，1：一年内还款） */
    public void setType(Byte type) {
        this.type = type;
    }
}
