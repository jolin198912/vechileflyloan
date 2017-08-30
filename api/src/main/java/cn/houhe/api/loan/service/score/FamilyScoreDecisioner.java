package cn.houhe.api.loan.service.score;

import cn.houhe.api.common.Score;
import cn.houhe.api.common.enums.Constants;
import cn.houhe.api.loan.entity.CreditChildren;
import cn.houhe.api.loan.entity.RiskmanageScoresRecord;
import cn.houhe.api.loan.entity.VerifyInfo;
import cn.houhe.api.loan.mapper.VerifyInfoMapper;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.*;

/**
 * Created by think on 2017/5/5.
 */
@Component
public class FamilyScoreDecisioner implements ScoreDecisioner {
    @Override
    public int decisionScore(Map param) {
        int score = 0;
        RiskmanageScoresRecord riskmanageScoresRecord = (RiskmanageScoresRecord) param.get("scoreRecord");//风控评分记录模型
        VerifyInfo verifyInfo = (VerifyInfo) param.get("verifyInfo");  //风控记录信息验证模型
        JSONObject jsonEdu = checkeducationDegree(param.get("idcard") + "", param.get("name") + "", param.get("mobileno") + "");
        //通过学历验证的 20
        if (jsonEdu != null) {
            int enrolDate = Integer.parseInt(jsonEdu.getString("enrolDate"));
            int graduateTime = Integer.parseInt(jsonEdu.getString("garauateTime"));
            if (param.containsKey("high_edu_starttime") && param.containsKey("high_edu_endtime")) {
                String high_edu_starttime = CalcTime.getYear((Date) param.get("high_edu_starttime")) + "";
                String high_edu_endtime = CalcTime.getYear((Date) param.get("high_edu_endtime")) + "";
                if (!high_edu_starttime.equals(enrolDate + "") || !high_edu_endtime.equals(graduateTime + "")) {
                    verifyInfo.setEducationTimeState((byte)1);
                }
            }
            //学制3年及以上 5
            if (graduateTime - enrolDate >= 3) {
                score+=Score.eduyear_scoreScoreKey;
                riskmanageScoresRecord.setEduyearScore(Score.eduyear_scoreScoreKey);
            }
            String educationLevel = Constants.EducationLevel.values()[(Byte) param.get("educationLevel")].getName();
            if((jsonEdu.getString("educationDegree")).contains(educationLevel)) {
                score += Score.edudgcheck_scoreScoreKey;
                riskmanageScoresRecord.setEdudgcheckScore(Score.edudgcheck_scoreScoreKey);
                //客户读大学年龄小于20岁且学历为本科以上的。 5
                if(param.containsKey("birthday")) {
                    Date birthday = (Date) param.get("birthday");
                    if(CalcTime.getYearDiff(birthday, enrolDate) <= 20 && (Byte)param.get("educationLevel") >= 3) {
                        score += Score.eduage_scoreScoreKey;
                        riskmanageScoresRecord.setEduageScore(Score.eduage_scoreScoreKey);
                    }
                }
            }
        } else {
            verifyInfo.setEducationState((byte)1);
            verifyInfo.setEducationTimeState((byte)1);
        }
        //结婚
        if (param.containsKey("marriage")){
            byte marriage = (byte) param.get("marriage");

            JSONObject jsonCoupleEdu = checkeducationDegree(param.get("coupleCard") + "", param.get("coupleName") + "", param.get("coupleMobile") + "");
            //已婚
            if (marriage == 3){
                score += Score.marriedScoreKey;
                riskmanageScoresRecord.setMarriedScore(Score.marriedScoreKey);
            }
            //女方学历验证
            if (jsonCoupleEdu != null) {
                if (jsonCoupleEdu.getString("educationDegree").contains(Constants.EducationLevel.values()[(Byte)param.get("coupleEducationLevel")].getName())) {
                    score += Score.girlDegreeKey;
                    riskmanageScoresRecord.setGirlDegreeScore(Score.girlDegreeKey);
                }
            } else {
                verifyInfo.setCoupleEduState((byte)1);
                verifyInfo.setCoupleIdcardState((byte)1);
                verifyInfo.setCoupleMobileState((byte)1);
                verifyInfo.setCoupleNameState((byte)1);
            }

            if (jsonEdu != null && jsonCoupleEdu != null) {
                //男女双方学历相同
                if (jsonEdu.getString("educationDegree").equals(jsonCoupleEdu.getString("educationDegree"))) {//学历相同
                    score += Score.educationEqualScoreKey;
                    riskmanageScoresRecord.setEducationEqualScore(Score.educationEqualScoreKey);
                }
                //女方学历高
                if ((Byte)param.get("coupleEducationLevel") > (Byte)param.get("educationLevel")) {
                    score += Score.wifeEducationHigherScoreKey;
                    riskmanageScoresRecord.setWifeEducationHigherScore(Score.wifeEducationHigherScoreKey);
                }
            }

            //女方上班
            byte coupleJob = MapUtils.getByteValue(param,"coupleJob", (byte) 1);
            if (coupleJob == 1) {
                score += Score.wifeWorkingScoreKey;
                riskmanageScoresRecord.setWifeWorkingScore(Score.wifeWorkingScoreKey);
            }
            //小孩
            byte childAmount = MapUtils.getByteValue(param, "childAmount", (byte) 0);
            if (childAmount > 0) {
                List<CreditChildren> children = (List<CreditChildren>) MapUtils.getObject(param, "children", new ArrayList<>());
                //有两个小孩，且一男一女 5分
                if (children.size() == 2 && (children.get(0).getSex() + children.get(1).getSex()) == 1) {
                    score += Score.boyAndGirlKey;
                    riskmanageScoresRecord.setBoyAndGirlScore(Score.boyAndGirlKey);
                }
                List<Integer> ages = new ArrayList();
                Integer maxAge = 0;
                boolean flag = true;
                for (CreditChildren child : children) {
                    int age = CalcTime.getYearDiff(child.getBirth());
                    if (age > maxAge) {
                        maxAge = age;
                    }
                    ages.add(age);
                    if (child.getSex() == 0) {
                        //男孩大于7岁10分
                        if (age > 7 && flag) {
                            score += Score.boyGreatSevenKey;
                            riskmanageScoresRecord.setBoyGreatSevenScore(Score.boyGreatSevenKey);
                            flag = false;
                        }
                    }
                }
                //双方生育孩子年龄在25-35岁的5分
                int bearAge = CalcTime.getAge((String) param.get("idcard")) - maxAge;
                if (bearAge >= 25 && bearAge <= 35) {
                    int coupleBearAge = CalcTime.getAge((String) param.get("coupleCard")) - maxAge;
                    if (coupleBearAge >= 25 && coupleBearAge <= 35) {
                        score += Score.birthAgeKey;
                        riskmanageScoresRecord.setBirthAgeScore(Score.birthAgeKey);
                    }
                }
                //两个孩子年龄差距在10岁以上或差距在五岁以内
                boolean flag1 = true;
                for (int i = 0; i < ages.size() && flag1; i++) {
                    for (int j = i + 1; j < ages.size(); j++) {
                        int diffAge = Math.abs(ages.get(i) - ages.get(j));
                        if (diffAge >= 10 || diffAge <= 5) {
                            score += Score.ageSubtractFiveOrTenKey;
                            riskmanageScoresRecord.setAgeSubtractScore(Score.ageSubtractFiveOrTenKey);
                            flag1 = false;
                            break;
                        }
                    }
                }
            }
        }
        //家庭人口数
        if (param.containsKey("familyAmount")) {
            byte familyAmount = MapUtils.getByteValue(param, "familyAmount", (byte) 0);
            int familyScore = 0;
            if (familyAmount == 3) {
                familyScore = Score.getScore("familyCount3ScoreKey");
            }
            if (familyAmount == 4) {
                familyScore = Score.getScore("familyCount4ScoreKey");
            }
            if (familyAmount >= 5 ) {
                familyScore = (9 - familyAmount) > 0 ? 9 - familyAmount : 0;
            }
            score += familyScore;
            riskmanageScoresRecord.setFamilyCountScore(familyScore);
        }
        //城镇
        byte originType = MapUtils.getByteValue(param, "originType", (byte) 1);
        if (originType == 0) {
            score += Score.getScore("cityOriginAge30ScoreKey");
            riskmanageScoresRecord.setCityOriginAge30Score(Score.getScore("cityOriginAge30ScoreKey"));
        }
        //年龄在30~45
        if(param.get("age") != null) {
            int age = (int) param.get("age");
            if (age > 30 && age < 45) {
                score += Score.getScore("countryOriginScoreKey");
                riskmanageScoresRecord.setCountryOriginScore(Score.getScore("countryOriginScoreKey"));
            }
        }
        return score;
    }

    /**
     * 验证输入学历是否匹配
     * @param idcard
     * @param name
     * @param mobile
     * @return
     */
    public JSONObject checkeducationDegree(String idcard,String name,String mobile) {
        JSONObject reqData = new JSONObject();
        reqData.put("meal", "EduLevel");
        reqData.put("id", idcard);
        reqData.put("name",name);
        reqData.put("cell", mobile);
        String portrait_result = new BaiRongApi().getData("HainaApi", reqData);
        JSONObject result = JSONObject.parseObject(portrait_result);
        if(result.getString("product") != null) {
            JSONObject json = (JSONObject) JSONPath.read(portrait_result, "$.product.data.info");
            return json;
        }
        return null;
    }
}
