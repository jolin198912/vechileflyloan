package cn.houhe.api.loan.service.score;

import cn.houhe.api.common.Score;
import cn.houhe.api.loan.entity.RiskmanageScoresRecord;
import cn.houhe.api.loan.entity.VerifyInfo;
import cn.houhe.api.loan.mapper.VerifyInfoMapper;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Administrator on 2017/5/9.
 */
@Component
public class AddressScoreDecisioner implements ScoreDecisioner {

    /*
    调用示例：地址校验
    * */
    @Override
    public int decisionScore(Map param) {
        RiskmanageScoresRecord riskmanageScoresRecord = (RiskmanageScoresRecord) param.get("scoreRecord");//风控评分记录模型
        VerifyInfo verifyInfo = (VerifyInfo) param.get("verifyInfo");  //风控记录信息验证模型
        int score = 0;
        JSONObject reqData = new JSONObject();
        reqData.put("meal", "Location");
        reqData.put("id", param.get("idcard"));
        reqData.put("name", param.get("name"));
        JSONArray cells = new JSONArray();
        cells.add(param.get("mobileno"));
        reqData.put("cell", cells);
        reqData.put("biz_addr", param.get("work_place"));
        reqData.put("home_addr", param.get("houseAddress"));
        reqData.put("per_addr", param.get("address"));
        reqData.put("apply_addr", param.get("domicileDetail"));
        String portrait_result = new BaiRongApi().getData("BankServer3Api", reqData);
        if (!portrait_result.equals("")) {
            JSONObject result = JSONObject.parseObject(portrait_result);
            if ("00".equals(result.get("code")) && "1".equals(result.get("flag_location"))) {
                double biz_addr1 = (double) result.get("location_biz_addr1");
                double biz_addr2 = (double) result.get("location_biz_addr2");
                double biz_addr3 = (double) result.get("location_biz_addr3");
                double biz_addr4 = (double) result.get("location_biz_addr4");
                double biz_addr5 = (double) result.get("location_biz_addr5");
                double home_addr1 = (double) result.get("location_home_addr1");
                double home_addr2 = (double) result.get("location_home_addr2");
                double home_addr3 = (double) result.get("location_home_addr3");
                double home_addr4 = (double) result.get("location_home_addr4");
                double home_addr5 = (double) result.get("location_home_addr5");
                double per_addr1 = (double) result.get("location_per_addr1");
                double per_addr2 = (double) result.get("location_per_addr2");
                double per_addr3 = (double) result.get("location_per_addr3");
                double per_addr4 = (double) result.get("location_per_addr4");
                double per_addr5 = (double) result.get("location_per_addr5");
                double apply_addr1 = (double) result.get("location_apply_addr1");
                double apply_addr2 = (double) result.get("location_apply_addr2");
                double apply_addr3 = (double) result.get("location_apply_addr3");
                double apply_addr4 = (double) result.get("location_apply_addr4");
                double apply_addr5 = (double) result.get("location_apply_addr5");
                if (biz_addr1 < 20 || biz_addr2 < 20 || biz_addr3 < 20 || biz_addr4 < 20 || biz_addr5 < 20)//居住地址正确5分
                {
                    score += Score.liveAddressKey;
                    riskmanageScoresRecord.setLiveAddressScore(Score.liveAddressKey);
                }
                if (home_addr1 < 20 || home_addr2 < 20 || home_addr3 < 20 || home_addr4 < 20 || home_addr5 < 20)//房产地址正确10分
                {
                    score += Score.houseAddressKey;
                    riskmanageScoresRecord.setHouseAddressScore(Score.houseAddressKey);
                }
                if (per_addr1 < 20 || per_addr2 < 20 || per_addr3 < 20 || per_addr4 < 20 || per_addr5 < 20)//户口地址正确10分
                {
                    score += Score.addressKey;
                    riskmanageScoresRecord.setAddressScore(Score.addressKey);
                }
                if (apply_addr1 < 20 || apply_addr2 < 20 || apply_addr3 < 20 || apply_addr4 < 20 || apply_addr5 < 20)//工作单位加5分
                {
                    score+=Score.workadd_scoreScoreKey;
                    riskmanageScoresRecord.setWorkaddScore(Score.workadd_scoreScoreKey);
                } else {
                    verifyInfo.setAddressState((byte)1);
                }
            } else {
                verifyInfo.setAddressState((byte)1);
            }
        }
        return score;
    }
}
