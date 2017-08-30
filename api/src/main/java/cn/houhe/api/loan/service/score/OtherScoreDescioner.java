package cn.houhe.api.loan.service.score;

import cn.houhe.api.loan.entity.RiskmanageScoresRecord;
import cn.houhe.api.common.Score;
import cn.houhe.api.member.entity.PhoneContact;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Created by think on 2017/5/5.
 */
public class OtherScoreDescioner implements ScoreDecisioner {
    @Override
    public int decisionScore(Map param) {
        RiskmanageScoresRecord riskmanageScoresRecord = (RiskmanageScoresRecord) param.get("scoreRecord");//风控评分记录模型
        int score = 0;
        //申请时间，设置申请时段（9-18），在此区间进行征信则 +10分
        if (param.containsKey("apply_time")) {
            Date applytime = (Date) param.get("apply_time");
            int hours = CalcTime.getHours(applytime);
            if(hours >= 9 && hours <= 18) {
                score += Score.applyTimeScoreKey;
                riskmanageScoresRecord.setApplyTimeScore(Score.applyTimeScoreKey);
            }
        }
        //申请额度 +5分
        if (param.containsKey("wantedLimit")) {
            Integer wantedlimit = (Integer) param.get("wantedLimit");
            if (wantedlimit > 0) {
                score += Score.wantedLimitScoreKey;
                riskmanageScoresRecord.setWantedLimitScore(Score.wantedLimitScoreKey);
            }
        }
        //期望还款期限 +5分
        if (param.containsKey("wantedPeriod")) {
            Byte wantedperiod = (Byte) param.get("wantedPeriod");
            if (wantedperiod > 0) {
                score += Score.wantedPeriodScoreKey;
                riskmanageScoresRecord.setWantedPeriodScore(Score.wantedPeriodScoreKey);
            }
        }
        //期望还款日期 +5分
        if (param.containsKey("wantedRepayDay")) {
            Byte wantedrepayday = (Byte) param.get("wantedRepayDay");
            if (wantedrepayday > 0) {
                score += Score.wantedRepayDayScoreKey;
                riskmanageScoresRecord.setWantedRepayDayScore(Score.wantedRepayDayScoreKey);
            }
        }
        //是否500强 +5
        if (param.containsKey("is500")) {
            if ((byte)param.get("is500") == 1) {
                score+=Score.is500ScoreKey;
                riskmanageScoresRecord.setIs500Score(Score.is500ScoreKey);
            }
        }
        //大专及以上或客户年龄在35岁以上的初中以上学历  +20
        if (param.containsKey("educationLevel") || param.containsKey("birthday")) {
            int age = CalcTime.getYearDiff((Date) param.get("birthday"), new Date());
            if (((Byte)param.get("educationLevel")) >= 2 || age >= 35) {
                score += Score.educationLevelScoreKey;
                riskmanageScoresRecord.setEducationlevelScore(Score.educationLevelScoreKey);
            }
        }
        //QQ及微信号码1年以上，每增加一年加1分,最多10分
        if (param.containsKey("qq_age") && param.containsKey("wx_age")) {
            //qq,wx 使用年限之和
            int year = (Short)param.get("qq_age")+(Short)param.get("wx_age");
            int qqwxscore = (Score.qqwxage_scoreScoreKey * year >= 10 ? 10 : Score.qqwxage_scoreScoreKey*year);
            score += qqwxscore;
            riskmanageScoresRecord.setQqwxageScore(qqwxscore);
        }
        //QQ或微信使用时间在客户20-25岁期间或30-40岁期间 5
        if (param.containsKey("qq_age") && param.containsKey("wx_age") && param.containsKey("birthday")) {
            int age=CalcTime.getYearDiff((Date) param.get("birthday"), new Date());
            int qquseage = age - (Short)param.get("qq_age");
            int wxuserage = age - (Short)param.get("wx_age");
            if ((qquseage >= 20 && qquseage <= 25) || (qquseage >= 30 && qquseage <= 40) || (wxuserage >= 20 && wxuserage <= 25) || (wxuserage >= 30 && wxuserage <= 40)) {
                score += Score.qqwxinage_scoreScoreKey;
                riskmanageScoresRecord.setQqwxinageScore(Score.qqwxinage_scoreScoreKey);
            }
        }
        //紧急联系人是直系亲属
        if (param.containsKey("contracts")) {
            List<PhoneContact> contracts = (List<PhoneContact>) param.get("contracts");
            if (CollectionUtils.isNotEmpty(contracts)) {
                if (contracts.get(0).getRelationType() == 5 && contracts.get(1).getRelationType() == 5) {
                    score += Score.linkphone_scoreScoreKey;
                    riskmanageScoresRecord.setLinkphoneScore(Score.linkphone_scoreScoreKey);
                }
            }
        }
        //单位地址 10
        if (param.containsKey("work_place")) {
                score += Score.workadd_home_scoreScoreKey;
                riskmanageScoresRecord.setWorkaddHomeScore(Score.workadd_home_scoreScoreKey);
        }
        //工作时间一年以上5分，每增加1年加1分，10分满分
        if (param.containsKey("work_experience")) {
            int wkyear = Integer.parseInt(param.get("work_experience").toString());
            if (wkyear > 0) {
                int tmpscore = Score.wkyear_scoreScoreKey;
                tmpscore += wkyear > 5 ? 5 : tmpscore - 1;
                score += tmpscore;
                riskmanageScoresRecord.setWkyearScore(tmpscore);
            }
        }
        //收入5000-10000 5
        if (param.containsKey("income")) {
            int incomeMin = ((BigDecimal) param.get("income")).compareTo(new BigDecimal(5000));
            int incomeMax = ((BigDecimal) param.get("income")).compareTo(new BigDecimal(10000));
            if (incomeMin == 1 && incomeMax == -1) {
                score += Score.income_scoreScoreKey;
                riskmanageScoresRecord.setIncomeScore(Score.income_scoreScoreKey);
            }
        }
        //选填社保缴纳基数5000以下  5
        //收入5000-10000 10
        if (param.containsKey("social_security")) {
            int socialScore = 0;
            if ((Byte)param.get("social_security") == 0) {
                socialScore = Score.social_security_scoreScoreKey1;
            } else if ((Byte)param.get("social_security") == 1) {
                socialScore = Score.social_security_scoreScoreKey2;
            }
            score += socialScore;
            riskmanageScoresRecord.setSocialSecurityScore(socialScore);
        }
        //选填公积金缴纳基数5000以下  5
        //收入5000-10000 10
        if (param.containsKey("accumulation_fund")) {
            int accumulationScore = 0;
            if ((Byte)param.get("accumulation_fund") == 0) {
                accumulationScore = Score.accumulation_fund_scoreScoreKey1;
            } else if ((Byte)param.get("accumulation_fund") == 1) {
                accumulationScore = Score.accumulation_fund_scoreScoreKey2;
            }
            score += accumulationScore;
            riskmanageScoresRecord.setAccumulationFundScore(accumulationScore);
        }
        //花呗、借呗、京东白条的授信额度，三者之一跟收入一致 10
        if (param.containsKey("income") && param.containsKey("jingdong_quto") && param.containsKey("mayijieb_quto") && param.containsKey("huabei_quto")) {
                BigDecimal income = (BigDecimal)param.get("income");
                BigDecimal jingdong_quto = (BigDecimal)param.get("jingdong_quto");
                BigDecimal huabei_quto = (BigDecimal)param.get("huabei_quto");
                BigDecimal mayijieb_quto = (BigDecimal)param.get("mayijieb_quto");
                if (income.compareTo(jingdong_quto) == 0 || income.compareTo(huabei_quto) == 0 ||income.compareTo(mayijieb_quto) == 0 ) {
                    score += Score.income_compare_scoreScoreKey;
                    riskmanageScoresRecord.setIncomeCompareScore(Score.income_compare_scoreScoreKey);
                }
        }

        //负债/收入低于70%  +10
        if (param.containsKey("income") && param.containsKey("debit"))  {
            BigDecimal income = (BigDecimal)param.get("income");
            BigDecimal debit = (BigDecimal)param.get("debit");
            BigDecimal rate = new BigDecimal(100.00) ;
            BigDecimal incomeYear = (income.multiply(new BigDecimal(12)));
            incomeYear = incomeYear.compareTo(new BigDecimal(0)) == 0 ? new BigDecimal(1) : incomeYear;
            if (((debit.multiply(rate)).divide(incomeYear, RoundingMode.CEILING).compareTo(new BigDecimal(70)) == -1)) {
                score += Score.debit_score;
                riskmanageScoresRecord.setDebitScore(Score.debit_score);
            }
        }
        return score;
    }
}
