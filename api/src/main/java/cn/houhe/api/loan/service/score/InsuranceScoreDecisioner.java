package cn.houhe.api.loan.service.score;

import cn.houhe.api.common.Score;
import cn.houhe.api.loan.entity.RiskmanageScoresRecord;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/8.
 */
public class InsuranceScoreDecisioner implements ScoreDecisioner {
    @Override
    public int decisionScore(Map param) {
        RiskmanageScoresRecord riskmanageScoresRecord = (RiskmanageScoresRecord) param.get("scoreRecord");//风控评分记录模型
        int score = 0;
        if (param.containsKey("insurancePay")) {
            BigDecimal insurancepay = (BigDecimal) param.get("insurancePay");
            if (insurancepay.intValue() != 0) {
                //保费在5000-10000加10分
                if (insurancepay.compareTo(new BigDecimal(5000)) >= 0 && insurancepay.compareTo(new BigDecimal(10000)) <= 0) {
                    score += Score.payYearKey;
                    riskmanageScoresRecord.setPayYearScore(Score.payYearKey);
                }
            }
            if (param.containsKey("income")) {
                BigDecimal income = (BigDecimal) param.get("income");
                if (income.intValue() > 0) {
                    //保费支出在年收入的30%以内
                    BigDecimal proportion = insurancepay.divide(income.multiply(new BigDecimal(12)), RoundingMode.CEILING);
                    if (proportion.compareTo(new BigDecimal(0.3)) <= 0) {
                        score += Score.payIncomeRateKey;
                        riskmanageScoresRecord.setPayIncomeRateScore(Score.payIncomeRateKey);
                    }
                }

            }
        }
        return score;
    }
}
