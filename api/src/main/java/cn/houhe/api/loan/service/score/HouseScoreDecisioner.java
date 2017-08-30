package cn.houhe.api.loan.service.score;

import cn.houhe.api.common.Score;
import cn.houhe.api.loan.entity.RiskmanageScoresRecord;
import org.apache.commons.collections.MapUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/8.
 */
public class HouseScoreDecisioner implements ScoreDecisioner {
    @Override
    public int decisionScore(Map param) {
        RiskmanageScoresRecord riskmanageScoresRecord = (RiskmanageScoresRecord) param.get("scoreRecord");//风控评分记录模型
        int score = 0;
        if (param.containsKey("domicileTime")) {
            byte domiciletime = (Byte) param.get("domicileTime");
            //居住时间在1年以上，每增加一年加一分，最高得分20分
            if (domiciletime > 1) {
                score += domiciletime - 1 > 20 ? 20 : domiciletime - 1;
                riskmanageScoresRecord.setLiveTimeScore(domiciletime - 1 > 20 ? 20 : domiciletime - 1);
            }
        }
        if (param.containsKey("loan_amount") && param.containsKey("income")) {
            BigDecimal loan_amount = (BigDecimal)MapUtils.getNumber(param,"loan_amount",0);
            BigDecimal income = (BigDecimal) MapUtils.getNumber(param,"income",0);
            //房子月还款金额占收入比的70%以下
            if (income.intValue() > 0) {
                if (loan_amount.divide(income, RoundingMode.CEILING).compareTo(new BigDecimal("0.7"))<0) {
                    score += Score.loanAmountIncomeScoreKey;
                    riskmanageScoresRecord.setLoanAmountIncomeScore(Score.loanAmountIncomeScoreKey);
                }
            }
        }
        if (param.containsKey("house_big")) {
            short house_big = MapUtils.getShort(param,"house_big",(short)0);
            //房产平米在89以下的3-4口房子
            if (house_big <= 89) {
                score += Score.houseAreaScoreKey;
                riskmanageScoresRecord.setHouseAreaScore(Score.houseAreaScoreKey);
            }
        }
        if (param.containsKey("domicileTime")) {
            short domicile_time = MapUtils.getShort(param,"domicileTime",(short)0);
            //自有住房或租房时间在3年以上
            if (domicile_time >= 3) {
                score += Score.houseAppraisementScoreKey;
                riskmanageScoresRecord.setLengthOfResidenceScore(Score.houseAppraisementScoreKey);
            }
        }
        return score;
    }
}
