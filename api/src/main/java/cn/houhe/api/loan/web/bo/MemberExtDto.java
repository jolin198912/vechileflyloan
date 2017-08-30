package cn.houhe.api.loan.web.bo;

import java.math.BigDecimal;

/**
 * Created by victorrrr on 2017/5/24.
 */
public class MemberExtDto {

    private Integer totalCount;//总会员人数

    private Integer mCount;//男会员
    private Integer fCount;//女会员
    private BigDecimal mCountRate;//男会员占比
    private BigDecimal fCountRate;//女会员占比

    private Integer lessThan25Count;//小于25岁会员
    private Integer _25_35Count;//25到35岁会员
    private Integer _36_45Count;//36到45岁会员
    private Integer moreThan45Count;//大于45岁会员
    private BigDecimal lessThan25CountRate;//小于25岁会员占比
    private BigDecimal _25_35CountRate;//25到35岁会员占比
    private BigDecimal _36_45CountRate;//36到45岁会员占比
    private BigDecimal moreThan45CountRate;//大于45岁会员占比

    private Integer marriedCount;//结婚的会员
    private Integer unmarriedCount;//单身的会员
    private Integer divorceCount;//离异的会员
    private Integer widowedCount;//丧偶的会员
    private BigDecimal marriedCountRate;//结婚的会员占比
    private BigDecimal unmarriedCountRate;//单身的会员占比
    private BigDecimal divorceCountRate;//离异的会员占比
    private BigDecimal widowedCountRate;//丧偶的会员占比


    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getmCount() {
        return mCount;
    }

    public void setmCount(Integer mCount) {
        this.mCount = mCount;
    }

    public Integer getfCount() {
        return fCount;
    }

    public void setfCount(Integer fCount) {
        this.fCount = fCount;
    }

    public BigDecimal getmCountRate() {
        return mCountRate;
    }

    public void setmCountRate(BigDecimal mCountRate) {
        this.mCountRate = mCountRate;
    }

    public BigDecimal getfCountRate() {
        return fCountRate;
    }

    public void setfCountRate(BigDecimal fCountRate) {
        this.fCountRate = fCountRate;
    }

    public Integer getLessThan25Count() {
        return lessThan25Count;
    }

    public void setLessThan25Count(Integer lessThan25Count) {
        this.lessThan25Count = lessThan25Count;
    }

    public Integer get_25_35Count() {
        return _25_35Count;
    }

    public void set_25_35Count(Integer _25_35Count) {
        this._25_35Count = _25_35Count;
    }

    public Integer get_36_45Count() {
        return _36_45Count;
    }

    public void set_36_45Count(Integer _36_45Count) {
        this._36_45Count = _36_45Count;
    }

    public Integer getMoreThan45Count() {
        return moreThan45Count;
    }

    public void setMoreThan45Count(Integer moreThan45Count) {
        this.moreThan45Count = moreThan45Count;
    }

    public BigDecimal getLessThan25CountRate() {
        return lessThan25CountRate;
    }

    public void setLessThan25CountRate(BigDecimal lessThan25CountRate) {
        this.lessThan25CountRate = lessThan25CountRate;
    }

    public BigDecimal get_25_35CountRate() {
        return _25_35CountRate;
    }

    public void set_25_35CountRate(BigDecimal _25_35CountRate) {
        this._25_35CountRate = _25_35CountRate;
    }

    public BigDecimal get_36_45CountRate() {
        return _36_45CountRate;
    }

    public void set_36_45CountRate(BigDecimal _36_45CountRate) {
        this._36_45CountRate = _36_45CountRate;
    }

    public BigDecimal getMoreThan45CountRate() {
        return moreThan45CountRate;
    }

    public void setMoreThan45CountRate(BigDecimal moreThan45CountRate) {
        this.moreThan45CountRate = moreThan45CountRate;
    }

    public Integer getMarriedCount() {
        return marriedCount;
    }

    public void setMarriedCount(Integer marriedCount) {
        this.marriedCount = marriedCount;
    }

    public Integer getUnmarriedCount() {
        return unmarriedCount;
    }

    public void setUnmarriedCount(Integer unmarriedCount) {
        this.unmarriedCount = unmarriedCount;
    }

    public Integer getDivorceCount() {
        return divorceCount;
    }

    public void setDivorceCount(Integer divorceCount) {
        this.divorceCount = divorceCount;
    }

    public Integer getWidowedCount() {
        return widowedCount;
    }

    public void setWidowedCount(Integer widowedCount) {
        this.widowedCount = widowedCount;
    }

    public BigDecimal getMarriedCountRate() {
        return marriedCountRate;
    }

    public void setMarriedCountRate(BigDecimal marriedCountRate) {
        this.marriedCountRate = marriedCountRate;
    }

    public BigDecimal getUnmarriedCountRate() {
        return unmarriedCountRate;
    }

    public void setUnmarriedCountRate(BigDecimal unmarriedCountRate) {
        this.unmarriedCountRate = unmarriedCountRate;
    }

    public BigDecimal getDivorceCountRate() {
        return divorceCountRate;
    }

    public void setDivorceCountRate(BigDecimal divorceCountRate) {
        this.divorceCountRate = divorceCountRate;
    }

    public BigDecimal getWidowedCountRate() {
        return widowedCountRate;
    }

    public void setWidowedCountRate(BigDecimal widowedCountRate) {
        this.widowedCountRate = widowedCountRate;
    }

}
