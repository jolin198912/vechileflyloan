package cn.houhe.api.common.enums;

/**
 * Created by Administrator on 2017/4/10.
 */
public enum  PushMsgEnum {
    //内容类型（0注册成功，1授信申请通过，2授信申请未通过，3贷款申请通过，4贷款申请未通过，5还款提前通知，6还款成功，7逾期未还，8逾期已还，9结清贷款，10系统通知）
    RegeistOk("注册成功", 0),
    CreditOk("授信申请通过", 1),
    CreditNo("授信申请未通过", 2),
    LoanOk("贷款申请通过", 3),
    LoanNo("贷款申请未通过", 4),
    RePayRemaind("款提前通知", 5),
    RePayOk("还款成功", 6),
    RePayNo("逾期未还", 7),
    RePayOverOk("逾期已还", 8),
    RePayAll("结清贷款", 9),
    SystemMsg("系统通知", 10),
    LoanPayOk("打款成功通知", 11),
    LoanPayNo("打款失败通知", 12);
    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private PushMsgEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }
    //覆盖方法
    @Override
    public String toString() {
        return this.name;
    }
    public int getIndex() {
        return this.index;
    }
}