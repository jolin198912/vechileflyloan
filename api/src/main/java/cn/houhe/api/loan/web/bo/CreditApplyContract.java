package cn.houhe.api.loan.web.bo;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * ApllyCreditDto
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-01T09:04:30.957Z")

public class CreditApplyContract {

    private String reg = null;
    private String loan = null;
    private String creditQuery = null;
    private String collection = null;

    @ApiModelProperty(value = "用户注册协议")
    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }
    @ApiModelProperty(value = "额度借款合同")
    public String getLoan() {
        return loan;
    }

    public void setLoan(String loan) {
        this.loan = loan;
    }
    @ApiModelProperty(value = "征信查询")
    public String getCreditQuery() {
        return creditQuery;
    }

    public void setCreditQuery(String creditQuery) {
        this.creditQuery = creditQuery;
    }
    @ApiModelProperty(value = "委托代收")
    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }


    @Override
    public String toString() {
        return "CreditApplyContract{" +
                "reg='" + reg + '\'' +
                ", loan='" + loan + '\'' +
                ", creditQuery='" + creditQuery + '\'' +
                ", collection='" + collection + '\'' +
                '}';
    }
}


