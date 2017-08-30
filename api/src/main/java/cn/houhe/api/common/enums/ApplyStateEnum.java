package cn.houhe.api.common.enums;

public enum ApplyStateEnum {
    //授信申请审核状态（0填写资料申请中1提交完资料审批中2初审通过3初审不通过4终审通过5终审不通过6自动审批通过7自动审批不通过）
    APPLYING("填写资料申请中", 0),
    APPROVING("提交完资料审批中", 1),
    TRIAL_OK("初审通过", 2),
    TRIAL_NO("初审不通过", 3),
    FINAL_OK("终审通过", 4),
    FINAL_NO("终审不通过", 5),
    AUTO_APPROVAL_OK("自动审批通过", 6),
    AutoApprovalNo("自动审批不通过", 7);
    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private ApplyStateEnum(String name, int index) {
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
