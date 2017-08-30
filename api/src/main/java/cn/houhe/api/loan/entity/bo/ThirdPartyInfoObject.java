package cn.houhe.api.loan.entity.bo;

/**
 * Created by Administrator on 2017/5/26.
 */
public class ThirdPartyInfoObject {
    /** baiqishi_result -- 白骑士返回结果 */
    private String baiqishiResult;

    /** tongdun_result -- 同盾返回结果 */
    private String tongdunResult;

    /** bairong_result -- 百荣返回结果 */
    private String bairongResult;

    public String getBaiqishiResult() {
        return baiqishiResult;
    }

    public void setBaiqishiResult(String baiqishiResult) {
        this.baiqishiResult = baiqishiResult;
    }

    public String getTongdunResult() {
        return tongdunResult;
    }

    public void setTongdunResult(String tongdunResult) {
        this.tongdunResult = tongdunResult;
    }

    public String getBairongResult() {
        return bairongResult;
    }

    public void setBairongResult(String bairongResult) {
        this.bairongResult = bairongResult;
    }
}
