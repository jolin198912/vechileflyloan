package cn.houhe.api.loan.web.bo;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * ApllyCreditDto
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-01T09:04:30.957Z")

public class CreditApplyIdCard {

    @JsonProperty("address")
    private String address = null;


    @JsonProperty("name")
    private String name = null;

    @JsonProperty("idCard")
    private String id_card_number = null;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_card_number() {
        return id_card_number;
    }

    public void setId_card_number(String id_card_number) {
        this.id_card_number = id_card_number;
    }

    @Override
    public String toString() {
        return "CreditApplyIdCard{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", id_card_number='" + id_card_number + '\'' +
                '}';
    }
}


