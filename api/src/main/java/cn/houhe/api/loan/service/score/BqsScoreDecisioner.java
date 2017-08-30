package cn.houhe.api.loan.service.score;

import cn.houhe.api.common.Score;
import cn.houhe.api.loan.entity.RiskmanageScoresRecord;

import java.util.Map;

/**
 * Created by think on 2017/4/24.
 */
public class BqsScoreDecisioner implements ScoreDecisioner {
    @Override
    public int decisionScore(Map param) {
        if (param.containsKey("bqs")){
            //风控评分记录模型
            RiskmanageScoresRecord riskmanageScoresRecord = (RiskmanageScoresRecord) param.get("scoreRecord");
            String decision = (String) param.get("bqs");
            if ("Accept".equals(decision)){
                riskmanageScoresRecord.setBqsScore(Score.getScore("bqsKey"));
                return Score.getScore("bqsKey");
            }
        }
        return 0;
    }
}
