package cn.houhe.api.loan.service.score;

import cn.houhe.api.common.Score;
import cn.houhe.api.loan.entity.RiskmanageScoresRecord;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * Created by think on 2017/4/24.
 */
public class AgeScoreDecisioner implements ScoreDecisioner {
    @Override
    public int decisionScore(Map param) {
        //风控评分记录模型
        RiskmanageScoresRecord riskmanageScoresRecord = (RiskmanageScoresRecord) param.get("scoreRecord");
        int score = 0;
        int age = 0;
        int coupleAge = 0;
        if (param.get("idcard") != null) {
            age = CalcTime.getAge((String) param.get("idcard"));
            if (!param.containsKey("age")) {
                param.put("age", age);
            }
        }
        if (age > 21 && age < 45) {
            score = Score.ageScoreKey;
            if (age >= 21 && age < 25) {
                score -= (25 - age) * 0.5;
            }
            if (age >= 25 && age < 35) {
                score += (age - 25);
            }
            if (age >= 35 && age <45) {
                score -= (age - 35) * 0.5;
            }
            riskmanageScoresRecord.setAgeScore(score);
        }
        if (param.get("coupleCard") != null) {
            coupleAge = CalcTime.getAge((String) param.get("coupleCard"));
        }
        if (age > coupleAge) {
            score += Score.ageManOlderKey;
            riskmanageScoresRecord.setAgeManOlderScore(Score.ageManOlderKey);
        }
        if (age - coupleAge > 0 && age - coupleAge < 5) {
            score += Score.ageDiffFiveKey;
            riskmanageScoresRecord.setAgeDiffFiveScore(Score.ageDiffFiveKey);
        }
        return score;
    }
}
