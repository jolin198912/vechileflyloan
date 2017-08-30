package cn.houhe.api.loan.web.bo;

import cn.houhe.api.loan.entity.LoanContract;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Digits;
import java.util.List;

/**
 * Created by think on 2017/4/6.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-01T09:04:30.957Z")

public class CreditApplyAuthDto {


    /** member_id -- 用户id */
    @JsonProperty("memId")
    private Integer memId;

    /**
     * 支付宝是否授权
     */
    private Integer al = 0;

    private List<LoanContract> contracts;

    /**
     * 芝麻信用openid
     */
    private String alOpenId;
    /**
     * 人行征信
     */
    private Integer cr = 0;

    /**
     * 运营商
     */
    @Digits(integer = 1,fraction = 1)
    private Integer op = 0;

    public List<LoanContract> getContracts() {
        return contracts;
    }

    public void setContracts(List<LoanContract> contracts) {
        this.contracts = contracts;
    }

    public String getAlOpenId() {
        return alOpenId;
    }

    public void setAlOpenId(String alOpenId) {
        this.alOpenId = alOpenId;
    }

    @ApiModelProperty(value = "用户id",name = "memId")
    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    @ApiModelProperty(value = "阿里授权",name = "al")
    public Integer getAl() {
        return al;
    }

    public void setAl(Integer al) {
        this.al = al;
    }

    public Integer getCr() {
        return cr;
    }

    public void setCr(Integer cr) {
        this.cr = cr;
    }

    public Integer getOp() {
        return op;
    }

    public void setOp(Integer op) {
        this.op = op;
    }
}
