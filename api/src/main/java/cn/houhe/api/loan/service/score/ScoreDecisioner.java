package cn.houhe.api.loan.service.score;

import java.util.Map;

/**
 * Created by think on 2017/4/24.
 */
public interface ScoreDecisioner {
    /**
     *
     * @param param
     * @return 分数
     */
    int decisionScore(Map param);
}
