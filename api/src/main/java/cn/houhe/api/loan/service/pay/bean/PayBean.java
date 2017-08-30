package cn.houhe.api.loan.service.pay.bean;



import java.util.Map;

/**
 * Created by victorrrr on 2017/5/2.
 */
public class PayBean {

    private String batchNo;
    private String code;
    private String msg;
    private Map<String,String> data;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
