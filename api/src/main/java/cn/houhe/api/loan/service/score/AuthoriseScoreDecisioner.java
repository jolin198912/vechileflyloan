package cn.houhe.api.loan.service.score;

import cn.houhe.api.common.Score;
import cn.houhe.api.loan.entity.AuthorizeInfo;
import cn.houhe.api.loan.entity.RiskmanageScoresRecord;
import org.apache.commons.collections.MapUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by think on 2017/5/8.
 */
public class AuthoriseScoreDecisioner implements ScoreDecisioner{
    @Override
    public int decisionScore(Map param) {
        int score = 0;
        //风控评分记录模型
        RiskmanageScoresRecord riskmanageScoresRecord = (RiskmanageScoresRecord) param.get("scoreRecord");
        if (param.containsKey("authorise")) {
            List<AuthorizeInfo> authorizeInfos = (List<AuthorizeInfo>) MapUtils.getObject(param,"authorise");
            for (AuthorizeInfo authorizeInfo : authorizeInfos) {
                if (authorizeInfo.getIsAliyAuthorize() == 1) {
                    score +=  Score.getScore("alAuthorizeKey");
                    riskmanageScoresRecord.setAlAuthScore(Score.getScore("alAuthorizeKey"));
                }
                if (authorizeInfo.getIsCreditAuthorize() == 1 ) {
                    score += Score.getScore("creditAuthorizeKey");
                    riskmanageScoresRecord.setCreditAuthScore(Score.getScore("creditAuthorizeKey"));
                }
                if (authorizeInfo.getIsOperateAuthorize() == 1) {
                    score += Score.getScore("opAuthorizeKey");
                    riskmanageScoresRecord.setOpAuthScore(Score.getScore("opAuthorizeKey"));
                }
            }
        }
        return score;
    }
}
