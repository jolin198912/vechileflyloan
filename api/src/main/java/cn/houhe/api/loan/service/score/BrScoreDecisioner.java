package cn.houhe.api.loan.service.score;

import cn.houhe.api.common.Configs;
import cn.houhe.api.loan.entity.RiskmanageScoresRecord;
import cn.houhe.api.common.Score;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

/**
 * Created by think on 2017/4/24.
 */
@Component
public class BrScoreDecisioner implements ScoreDecisioner {
    private static Logger logger = LoggerFactory.getLogger(BrScoreDecisioner.class);
    @Override
    public int decisionScore(Map param) {
        //风控评分记录模型
        RiskmanageScoresRecord riskmanageScoresRecord = (RiskmanageScoresRecord) param.get("scoreRecord");
        int score = 0;
        if (param.containsKey("city") && param.containsKey("house_caty") && param.containsKey("filter") && param.containsKey("house_big")) {
            JSONObject reqData = new JSONObject();
            reqData.put("meal", "Inquiry");
            reqData.put("city_name", MapUtils.getString(Configs.CityMap, MapUtils.getString(param,"city")));//城市拼音
            reqData.put("house_type", MapUtils.getString(param,"house_caty"));//住宅；别墅
            reqData.put("filter", MapUtils.getString(param,"filter"));//小区
            reqData.put("area", MapUtils.getIntValue(param,"house_big"));//面积
            try {
                String portrait_result =  new BaiRongApi().getData("HainaApi", reqData);
                JSONObject result=JSONObject.parseObject(portrait_result);
                 /* 房屋预估总结需要查询百融接口获得*/
                 if (result.getString("product") != null ) {
                     JSONObject product = (JSONObject) result.get("product");
                     JSONObject data = (JSONObject) product.get("Data");
                     String totalprice = data.getString("totalprice");
                     BigDecimal house_total = new BigDecimal(totalprice);//万元
                     int addscore = 0;
                     if (house_total.compareTo(new BigDecimal("50")) > 0) {
                    /*房产估价50-100万，+10,每多20万加1分。20分封顶*/
                         addscore += 10;
                     }
                     if (house_total.compareTo(new BigDecimal("100")) > 0) {
                         BigDecimal val = house_total.subtract(new BigDecimal("100")).divide(new BigDecimal("20"), RoundingMode.DOWN);
                         if (val.intValue() > 10) {
                             addscore += 10;
                         } else {
                             addscore += val.intValue();
                         }
                         score += addscore;
                         riskmanageScoresRecord.setHouseAppraisementScore(addscore);
                     }
                 }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }

        if(param.containsKey("name") && param.containsKey("idcard") && param.containsKey("mobileno")) {
            String id_card=MapUtils.getString(param,"idcard");
            String mobilenos = MapUtils.getString(param, "mobileno");
            String name=MapUtils.getString(param,"name");

            JSONObject reqData = new JSONObject();
            JSONArray cells = new JSONArray();
            cells.add(mobilenos);
            try {
                 /* 通过客户稳定性评估-百融*/
                reqData.put("meal", "Stability_c");
                reqData.put("id", id_card);//身份证
                reqData.put("cell", cells);//手机号
                reqData.put("name", name);//姓名
                String portrait_result = new BaiRongApi().getData("BankServer3Api", reqData);
                JSONObject result = JSONObject.parseObject(portrait_result);
                if ( "1" .equals(result.getString("flag_stability_c"))) {
                    score += Score.brStabilityScoreKey;
                    //风控评分记录模型赋值
                    riskmanageScoresRecord.setBrStabilityScore(Score.brStabilityScoreKey);
                }
            }catch (Exception e) {
                logger.error(e.getMessage());
            }
            try {
                reqData.clear();
                /*身份证与手机号归属地一致*/
                reqData.put("meal", "KeyAttribution");//手机三要素
                reqData.put("id", id_card);//身份证
                reqData.put("cell", cells);//手机号
                reqData.put("name", name);//姓名
                String portrait_result = new BaiRongApi().getData("BankServer3Api", reqData);
                JSONObject result = JSONObject.parseObject(portrait_result);
                if ("1".equals(result.getString("flag_keyattribution"))) {
                    score += Score.idPhoneLocaleScoreKey;
                    riskmanageScoresRecord.setIdPhoneLocaleScore(Score.idPhoneLocaleScoreKey);
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
            try {
                reqData.clear();
                  /*手机号身份证姓名一致性*/
                reqData.put("meal", "TelCheck");//手机三要素
                reqData.put("id", id_card);//身份证
                reqData.put("cell", mobilenos);//手机号
                reqData.put("name", name);//姓名
                String portrait_result = new BaiRongApi().getData("HainaApi", reqData);
                JSONObject result = JSONObject.parseObject(portrait_result);
                if (result.getString("product") != null) {
                    JSONObject product = (JSONObject) result.get("product");
                    String res = product.getString("result");
                    if ("1".equals(res)) {
                    /*0为查无此号或手机非实名认证 1均一致 2均不一致 3姓名手机号一致，姓名身份证号不一致*/
                        score += Score.idPhoneNameScoreKey;
                        riskmanageScoresRecord.setIdPhoneNameScore(Score.idPhoneNameScoreKey);
                    }
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
            try {
                reqData.clear();
                //社交关系评估中吻合客户性别的
                reqData.put("meal", "SocietyRelation");
                reqData.put("id", id_card);//身份证
                reqData.put("cell", cells);//手机号
                reqData.put("name", name);//姓名
                String portrait_result = new BaiRongApi().getData("BankServer3Api", reqData);
                JSONObject result = JSONObject.parseObject(portrait_result);
                if (param.containsKey("sex")) {
                    if (JSONPath.read(portrait_result,"$.Flag.societyrelation").equals("1")) {
                        if (JSONPath.read(portrait_result, "$.SocietyRelation.gendar") != null) {
                            String  gendar = "0";
                            if (JSONPath.read(portrait_result, "$.SocietyRelation.gendar").equals("F")) {
                                gendar = "1";
                            }
                            if (param.get("sex").equals(gendar)) {
                                score += Score.societyRelationsexKey;
                                //todo
                            }
                        }
                    }
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
            try {
                reqData.clear();
                //商品消费评估
                reqData.put("meal", "Consumption_c");
                reqData.put("id", id_card);//身份证
                reqData.put("cell", cells);//手机号
                reqData.put("name", name);//姓名
                String portrait_result = new BaiRongApi().getData("BankServer3Api", reqData);
                JSONObject result = JSONObject.parseObject(portrait_result);
                if (param.containsKey("income")) {
                    if (JSONPath.read(portrait_result,"$.Flag.consumption_c").equals("1")) {
                        if (JSONPath.read(portrait_result, "$.Consumption_c.total.month12.pay") != null) {
                            //todo
                        }
                    }
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
        return score;
    }
}
