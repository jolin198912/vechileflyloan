package cn.houhe.api.loan.service.score;

import cn.houhe.api.loan.entity.RiskmanageScoresRecord;
import cn.houhe.api.common.Score;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * Created by think on 2017/5/5.
 */
public class CarScoreDecisioner implements ScoreDecisioner {
    @Override
    public int decisionScore(Map param) {
        RiskmanageScoresRecord riskmanageScoresRecord = (RiskmanageScoresRecord) param.get("scoreRecord");//风控评分记录模型
        int score = 0;
        int age = 0;

        //客户买车在25-40岁 +5分
        if (param.containsKey("idcard")) {
            if (param.get("idcard") != null) {
                age = CalcTime.getAge((String) param.get("idcard"));
                if (!param.containsKey("age")){
                    param.put("age",age);
                }
            }
            if(age >= 25 && age <= 40){
                score += Score.buyCarAgeScoreKey;
                riskmanageScoresRecord.setBuyCarAgeScore(Score.buyCarAgeScoreKey);
            }
        }
        //驾照地址 +10分
        if (param.containsKey("car_lisence")) {
            score += Score.carLisenceScoreKey;
            riskmanageScoresRecord.setCarLisenceScore(Score.carLisenceScoreKey);
        }
        //非营运车辆 +10分
        if (param.containsKey("car_property")) {
            byte carproperty = (byte) param.get("car_property");
            if(carproperty == 0) {
                score += Score.carPropertyScoreKey;
                riskmanageScoresRecord.setCarPropertyScore(Score.carPropertyScoreKey);
            }
        }
        if (param.containsKey("buy_date")) {
            Date buydate = (Date) param.get("buy_date");
            int buyyears = CalcTime.getYearDiff(buydate);
            //购买时间在1年以上 +5分
            if(buyyears > 1) {
                score += Score.buyDateAboveScoreKey;
                riskmanageScoresRecord.setBuyDateAboveScore(Score.buyDateAboveScoreKey);
            }
            //购买时间5年内的每增加一年 +1分
            if(buyyears < 5) {
                int addScore = Score.buyDateAboveAddScoreKey * buyyears;
                score += addScore;
                riskmanageScoresRecord.setBuyDateAboveAddScore(addScore);
            }
        }
        //家庭第一辆车且车辆购买价格在20万以内 +5分
        if (param.containsKey("counts")) {
            Short counts = (Short) param.get("counts");
            BigDecimal price = (BigDecimal)MapUtils.getNumber(param,"price",0);
            BigDecimal minPrice = new BigDecimal(200000);
            if(counts == 0 && price.compareTo(minPrice) == -1) {
                score += Score.countsScoreKey;
                riskmanageScoresRecord.setCountsScore(Score.countsScoreKey);
            }
        }
        //车辆购买价格10-20w +5分
        if (param.containsKey("price")) {
            BigDecimal price =(BigDecimal)MapUtils.getNumber(param,"price",0);
            BigDecimal minprice = new BigDecimal(100000);
            BigDecimal maxprice = new BigDecimal(200000);
            if(price.compareTo(minprice) > -1 && price.compareTo(maxprice) < 1) {
                score += Score.priceScoreKey;
                riskmanageScoresRecord.setPriceScore(Score.priceScoreKey);
            }
        }
        //购买保险金额在2000以上 +5分，每增加1000元 +2分，最多 +10分
        if (param.containsKey("car_insurance_amount")) {
            BigDecimal carinsuranceamount =(BigDecimal)MapUtils.getNumber(param,"car_insurance_amount",0);
            BigDecimal minamount = new BigDecimal(2000);
            BigDecimal upamount = new BigDecimal(1000);
            if(carinsuranceamount.compareTo(minamount) == 1) {
                int addScore = Score.carInsuranceAmountScoreKey;
                BigDecimal val = carinsuranceamount.subtract(minamount).divide(upamount, RoundingMode.DOWN);
                if (val.intValue()  > 5){
                    addScore += 10;
                } else {
                    addScore += val.intValue() * 2;
                }
                score += addScore;
                riskmanageScoresRecord.setCarInsuranceAmountScore(addScore);
            }
        }
        //驾龄2年 +5分，每增加一年驾龄 +1分
        if (param.containsKey("car_driven")) {
            Byte cardriven = (Byte) param.get("car_driven");
            if(cardriven >= 2) {
                int addScore = (cardriven - 2) + Score.carDrivenScoreKey;
                if (addScore > 20) {
                    addScore = 20;
                }
                score += addScore;
                riskmanageScoresRecord.setCarDrivenScore(addScore);
            }
        }
        return score;
    }
}
