package cn.houhe.api.common.enums;

/**
 * Created by think on 2017/5/6.
 */
public enum CreditApplyStep {
    ID_CARD("身份认证",1),
    FACE("人脸识别",2),
    CAR("车辆信息",3),
    PERSONAL_INFO("个人信息",4),
    AUTHORISE("授权",5),
    CONTRACT("合同",6),
    COMPLETE("填写完成",7);


    private final String name;
    private final int step;

    CreditApplyStep(String name, int step) {
        this.name = name;
        this.step = step;
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }


}
