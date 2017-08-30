package cn.houhe.api.loan.service.score;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by think on 2017/4/24.
 */
public class ScoreDecision {
    private static Logger logger = LoggerFactory.getLogger(ScoreDecision.class);
    private Map<String,ScoreDecisioner> decisioners = new HashMap<>();
    public ScoreDecision(Map<String, ScoreDecisioner> decisioners) {
        this.decisioners = decisioners;
    }

    public int decisionScore(Map param){
        int score = 0;
        Set<String> keys = decisioners.keySet();
        for (String key : keys) {
            try {
                ScoreDecisioner decisioner = decisioners.get(key);
                int singleScore = decisioner.decisionScore(param);
                score += singleScore;
            } catch (Exception e) {
                logger.error("征信打分",e);
            }
        }
        return score;
    }
}
