package cn.houhe.api.loan.service.score;

import cn.houhe.api.common.BaiqishiUtil;
import cn.houhe.api.common.Score;
import cn.houhe.api.loan.entity.RiskmanageScoresRecord;
import cn.houhe.api.loan.service.CreditApplyExtService;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * Created by think on 2017/5/5.
 */
@Component
public class PhoneScoreDecisioner implements ScoreDecisioner {
    private static Logger logger = LoggerFactory.getLogger(PhoneScoreDecisioner.class);

    @Override
    public int decisionScore(Map param) {
        //风控评分记录模型
        RiskmanageScoresRecord riskmanageScoresRecord = (RiskmanageScoresRecord) param.get("scoreRecord");
        int score = 0;
        if (param.containsKey("is_allow_contact")) {
            /*允许读取通讯录*/
            byte flag = (byte) param.get("is_allow_contact");
            if (flag == 1) {
                score += Score.allowContactScoreKey;
                riskmanageScoresRecord.setIsAllowContactScore(Score.allowContactScoreKey);
            }
        }
        if (param.containsKey("is_allow_record")) {
            /*允许读取通话记录*/
            byte flag = (byte) param.get("is_allow_record");
            if (flag == 1) {
                score += Score.allowRecordScoreKey;
                riskmanageScoresRecord.setIsAllowRecordScore(Score.allowRecordScoreKey);
            }
        }
        if (param.containsKey("is_allow_message")) {
            /*允许读取短信*/
            byte flag = (byte) param.get("is_allow_message");
            if (flag == 1) {
                score += Score.allowMessageScoreKey;
                riskmanageScoresRecord.setIsAllowMessageScore(Score.allowMessageScoreKey);
            }
        }
        if (param.containsKey("is_allow_location")) {
            /*允许读取定位*/
            byte flag = (byte) param.get("is_allow_location");
            if (flag == 1) {
                score += Score.allowLocationScoreKey;
                riskmanageScoresRecord.setIsAllowLocationScore(Score.allowLocationScoreKey);
            }
        }

        if (param.containsKey("name") && param.containsKey("idcard") && param.containsKey("mobileno")) {
            JSONObject json = new JSONObject();
            json.put("name", MapUtils.getString(param, "name"));
            json.put("certNo", MapUtils.getString(param, "idcard"));
            json.put("mobile", MapUtils.getString(param, "mobileno"));

            JSONObject jsonObject = JSONObject.parseObject(BaiqishiUtil.decisionClweb(json));
            String data = jsonObject.getString("data");

            if ("CCOM1000".equals(jsonObject.getString("resultCode"))) {
                //1 手机号码在网时间每超过1年 +5
                try {
                    long startTime = Long.parseLong(JSONPath.read(data, "$.mnoDetail.mnoPersonalInfo.openTime").toString());
                    int workTime = (int) ((new Date().getTime() - startTime) / 1000 / 3600 / 24 / 365);
                    int addScore = Score.phoneOnTimeScoreKey * workTime;
                    if (addScore > 20) {
                        addScore = 20;
                    }
                    score += addScore;
                    riskmanageScoresRecord.setPhoneOnTimeScore(addScore);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                //2 手机消费金额在50-100、100-200、200(5/8/10)
                try {
                    Object read = JSONPath.read(data, "$.mnoDetail.mnoBillRecords[0].dueFee");
                    int dueIn50 = new BigDecimal(read.toString()).compareTo(new BigDecimal("50"));
                    int dueIn100 = new BigDecimal(read.toString()).compareTo(new BigDecimal("100"));
                    int dueIn200 = new BigDecimal(read.toString()).compareTo(new BigDecimal("200"));
                    if (dueIn50 > -1 && dueIn100 < 0) {
                        score += Score.phoneCosts50ScoreKey;
                        riskmanageScoresRecord.setPhoneCostsScore(Score.phoneCosts50ScoreKey);
                    }
                    if (dueIn100 > -1 && dueIn200 < 0) {
                        score += Score.phoneCosts100ScoreKey;
                        riskmanageScoresRecord.setPhoneCostsScore(Score.phoneCosts100ScoreKey);
                    }
                    if (dueIn200 > -1) {
                        score += Score.phoneCosts200ScoreKey;
                        riskmanageScoresRecord.setPhoneCostsScore(Score.phoneCosts200ScoreKey);
                    }
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
                //3 居住地址与手机归属地相同

            }
        }

        if (param.containsKey("name") && param.containsKey("idcard") && param.containsKey("mobileno")) {
            JSONObject json = new JSONObject();
            json.put("name", MapUtils.getString(param, "name"));
            json.put("certNo", MapUtils.getString(param, "idcard"));
            json.put("mobile", MapUtils.getString(param, "mobileno"));
        }
        return score;
    }
}
