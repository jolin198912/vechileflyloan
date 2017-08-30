package cn.houhe.api.loan.web.bo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-01T09:04:30.957Z")

public class CreditApplyDrivingDto {
    @NotNull(message = "正面照不能为空")
    @JsonProperty("dfront")
    private String dfront = null;

    @JsonProperty("dback")
    private String dback = null;

    @NotNull(message = "行驶证正面照不能为空")
    @JsonProperty("cfront")
    private String cfront = null;


    @NotNull(message = "行驶证背面照不能为空")
    @JsonProperty("cback")
    private String cback = null;

    @NotNull(message = "会员id不能为空")
    @JsonProperty("memId")
    private Integer memId = null;

    /** car_number -- 车牌号 */
    private String carNumber;

    /** car_brand -- 车辆品牌 */
    private String carBrand;

    /** car_lisence -- 驾照登记地址 */
    private String carLisence;

    /** car_property -- 车辆性质（非运营0运营1） */
    private Byte carProperty;

    /** car_driven -- 驾龄 */
    private Byte carDriven;

    /** car_owner -- 车辆所有人 */
    private String carOwner;

    /** car_code -- 车辆识别代码 */
    private String carCode;

    /** buy_date -- 购买日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date buyDate;

    /** counts -- 第几辆车（0第一辆，1第二辆，2第三辆，3第四辆及以上） */
    private Short counts;

    /** price -- 购买价格 */
    private BigDecimal price;

    /** car_insurance_amount -- 保费金额 */
    private BigDecimal carInsuranceAmount;


    /**
     * 正面照
     * @return front
     **/
    @ApiModelProperty(value = "正面照")
    public String getDfront() {
        return dfront;
    }

    public void setDfront(String dfront) {
        this.dfront = dfront;
    }

    public CreditApplyDrivingDto back(String back) {
        this.dback = back;
        return this;
    }

    /**
     * 反面照
     * @return back
     **/
    @ApiModelProperty(value = "反面照")
    public String getDback() {
        return dback;
    }

    public void setDback(String back) {
        this.dback = back;
    }

    public CreditApplyDrivingDto memId(Integer memId) {
        this.memId = memId;
        return this;
    }

    /**
     * 用户id
     * @return memId
     **/
    @ApiModelProperty(value = "用户id")
    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    @ApiModelProperty(value = "车牌号")
    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @ApiModelProperty(value = "车辆品牌")
    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }
    @ApiModelProperty(value = "驾照登记地址")
    public String getCarLisence() {
        return carLisence;
    }

    public void setCarLisence(String carLisence) {
        this.carLisence = carLisence;
    }
    @ApiModelProperty(value = "车辆性质（非运营0运营1）")
    public Byte getCarProperty() {
        return carProperty;
    }

    public void setCarProperty(Byte carProperty) {
        this.carProperty = carProperty;
    }
    @ApiModelProperty(value = "驾龄")
    public Byte getCarDriven() {
        return carDriven;
    }

    public void setCarDriven(Byte carDriven) {
        this.carDriven = carDriven;
    }
    @ApiModelProperty(value = "车辆所有人")
    public String getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner;
    }
    @ApiModelProperty(value = "车辆识别代码")
    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }
    @ApiModelProperty(value = "购买日期")
    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }
    @ApiModelProperty(value = "第几辆车")
    public Short getCounts() {
        return counts;
    }

    public void setCounts(Short counts) {
        this.counts = counts;
    }
    @ApiModelProperty(value = "购买价格")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @ApiModelProperty(value = "保费金额")
    public BigDecimal getCarInsuranceAmount() {
        return carInsuranceAmount;
    }

    public void setCarInsuranceAmount(BigDecimal carInsuranceAmount) {
        this.carInsuranceAmount = carInsuranceAmount;
    }
    @ApiModelProperty(value = "行驶证正面照")
    public String getCfront() {
        return cfront;
    }

    public void setCfront(String cfront) {
        this.cfront = cfront;
    }
    @ApiModelProperty(value = "行驶证背面")
    public String getCback() {
        return cback;
    }

    public void setCback(String cback) {
        this.cback = cback;
    }
}


