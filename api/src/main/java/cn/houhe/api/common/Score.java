package cn.houhe.api.common;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 2017/5/10.
 * 风控评分分值配置
 */
public class Score {
    /*
    * 申请时间项分数key
    * */
    public static int applyTimeScoreKey;

    /*
    * 申请额度项分数key
    * */
    public static int wantedLimitScoreKey;

    /*
    * 期望还款期限项分数key
    * */
    public static int wantedPeriodScoreKey;

    /*
    * 期望还款日期项分数key
    * */
    public static int wantedRepayDayScoreKey;

    /*
    * 客户买车在25-40岁项分数key
    * */
    public static int buyCarAgeScoreKey;

    /*
    * 驾照地址与居住地址在同一城市项分数key
    * */
    public static int carLisenceScoreKey;

    /*
    * 非营运车辆项分数key
    * */
    public static int carPropertyScoreKey;

    /*
    * 购买时间在1年以上项分数key
    * */
    public static int buyDateAboveScoreKey;

    /*
    * 购买时间5年内的每增加一年项分数key
    * */
    public static int buyDateAboveAddScoreKey;

    /*
    * 家庭第一辆车且车辆购买价格在20万以内项分数key
    * */
    public static int countsScoreKey;

    /*
    * 车辆购买价格10-20w项分数key
    * */
    public static int priceScoreKey;

    /*
    * 购买保险金额在2000以上项分数key
    * */
    public static int carInsuranceAmountScoreKey;

    /*
    * 驾龄2年及以上项分数key
    * */
    public static int carDrivenScoreKey;

    /*
   * 允许读取通讯录分数key
   * */
    public static int allowContactScoreKey;

    /*
   * 允许读取通话记录项分数key
   * */
    public static int allowRecordScoreKey;

    /*
   * 允许读取短信项分数key
   * */
    public static int allowMessageScoreKey;

    /*
 * 允许读取定位项分数key
 * */
    public static int allowLocationScoreKey;

    /*
 * 房子月还款金额占收入比的70%以下项分数key
 * */
    public static int loanAmountIncomeScoreKey;

    /*
 * 房产平米在89以下的3-4口房子项分数key
 * */
    public static int houseAreaScoreKey;

    /*
 * 自有住房或租房时间在3年以上项分数key
 * */
    public static int houseAppraisementScoreKey;

    /*
 * 通过客户稳定性评估-百融项分数key
 * */
    public static int brStabilityScoreKey;

    /*
 * 身份证与手机号归属地一致项分数key
 * */
    public static int idPhoneLocaleScoreKey;

    /*
* 手机号身份证姓名一致性项分数key
* */
    public static int idPhoneNameScoreKey;

    /*
* 手机号码在网时间每超过1年项分数key
* */
    public static int phoneOnTimeScoreKey;

    /*
* 手机消费金额在50-100项分数key
* */
    public static int phoneCosts50ScoreKey;

    /*
* 手机消费金额在100-200项分数key
* */
    public static int phoneCosts100ScoreKey;

    /*
* 手机消费金额在200项分数key
* */
    public static int phoneCosts200ScoreKey;

    /*
    是否500强
    * */
    public  static int is500ScoreKey;

    //教育程度
    public static int educationLevelScoreKey;
    //通过学历验证的
    public static int edudgcheck_scoreScoreKey;
    //学制3年及以上
    public static int eduyear_scoreScoreKey;
    //读大学小于20岁且为本科以上
    public static int eduage_scoreScoreKey;
    //QQ及微信号码1年以上，每增加一年加1分
    public static int qqwxage_scoreScoreKey;
    //qq、wx使用时间在客户20-25岁期间或30-40岁期间
    public static int qqwxinage_scoreScoreKey;
    //紧急联系人是直系亲属且3个月内有通话记录且在通话名单中
    public static int linkphone_scoreScoreKey;
    //单位地址得到验证的 5
    public static int workadd_scoreScoreKey;
    //单位地址与居住地址在同一城市 10
    public static int workadd_home_scoreScoreKey;
    //工作时间一年以上5分，每增加1年加1分，10分满分
    public static int wkyear_scoreScoreKey;
    //收入5000-10000
    public static int income_scoreScoreKey;
    //选填社保缴纳基数5000以下 5
    public static int social_security_scoreScoreKey1;
    ///选填社保缴纳基数5000-10000 10
    public static int social_security_scoreScoreKey2;
    //选填公积金缴纳基数5000以下 5
    public static int accumulation_fund_scoreScoreKey1;
    ///选填、公积金缴纳基数5000-10000 10
    public static int accumulation_fund_scoreScoreKey2;
    //花呗、借呗、京东白条的授信额度，三者之一跟收入一致 10
    public static int income_compare_scoreScoreKey;
    //负债/收入低于70%
    public static int debit_score;


    public static int ageScoreKey;

    public  static int ageManOlderKey;

    public  static int ageDiffFiveKey;

    public  static int marriedScoreKey;

    public  static int educationEqualScoreKey;

    public  static int wifeEducationHigherScoreKey;

    public  static int wifeWorkingScoreKey;

    public  static int familyCount3ScoreKey;

    public  static int familyCount4ScoreKey;
    public  static int countryOriginScoreKey;

    //男孩7岁以上
    public static int boyGreatSevenKey;

    //双方生育孩子在25-25之间
    public static int birthAgeKey;

    //家里有两个孩子且有儿有女
    public static int boyAndGirlKey;

    //两个孩子年龄差距在10岁以上或差距在五岁以内
    public static int ageSubtractFiveOrTenKey;

    //居住地址正确
    public static int liveAddressKey;

    //房产地址正确
    public static int houseAddressKey;

    //户籍地址正确
    public static int addressKey;

    //居住时间在1年以上，每增加一年加一分，最高得分20分
    public static int liveTimeKey;

    //保费在5000-10000
    public static int payYearKey;

    //保费支出在年收入的30%以内
    public static int payIncomeRateKey;

    //女方学历通过验证的
    public static int girlDegreeKey;

    //社交关系评估中吻合客户性别的
    public static int societyRelationsexKey;

    public static int getScore(String key){
        return Integer.parseInt(properties.getProperty(key));
    }

    private  static Properties properties = new Properties();
    static {

        try {
            properties.load(Score.class.getClassLoader().getResourceAsStream("score.properties"));
            applyTimeScoreKey = Integer.parseInt(properties.getProperty("applyTimeScoreKey"));
            wantedLimitScoreKey = Integer.parseInt(properties.getProperty("wantedLimitScoreKey"));
            wantedPeriodScoreKey = Integer.parseInt(properties.getProperty("wantedPeriodScoreKey"));
            wantedRepayDayScoreKey = Integer.parseInt(properties.getProperty("wantedRepayDayScoreKey"));
            buyCarAgeScoreKey = Integer.parseInt(properties.getProperty("buyCarAgeScoreKey"));
            carLisenceScoreKey = Integer.parseInt(properties.getProperty("carLisenceScoreKey"));
            carPropertyScoreKey = Integer.parseInt(properties.getProperty("carPropertyScoreKey"));
            buyDateAboveScoreKey = Integer.parseInt(properties.getProperty("buyDateAboveScoreKey"));
            buyDateAboveAddScoreKey = Integer.parseInt(properties.getProperty("buyDateAboveAddScoreKey"));
            countsScoreKey = Integer.parseInt(properties.getProperty("countsScoreKey"));
            priceScoreKey = Integer.parseInt(properties.getProperty("priceScoreKey"));
            carInsuranceAmountScoreKey = Integer.parseInt(properties.getProperty("carInsuranceAmountScoreKey"));
            carDrivenScoreKey = Integer.parseInt(properties.getProperty("carDrivenScoreKey"));
            allowContactScoreKey=Integer.parseInt(properties.getProperty("allowContactScoreKey"));
            allowRecordScoreKey=Integer.parseInt(properties.getProperty("allowRecordScoreKey"));
            allowMessageScoreKey=Integer.parseInt(properties.getProperty("allowMessageScoreKey"));
            allowLocationScoreKey=Integer.parseInt(properties.getProperty("allowLocationScoreKey"));
            loanAmountIncomeScoreKey=Integer.parseInt(properties.getProperty("loanAmountIncomeScoreKey"));
            houseAreaScoreKey=Integer.parseInt(properties.getProperty("houseAreaScoreKey"));
            houseAppraisementScoreKey=Integer.parseInt(properties.getProperty("houseAppraisementScoreKey"));
            brStabilityScoreKey=Integer.parseInt(properties.getProperty("brStabilityScoreKey"));
            idPhoneLocaleScoreKey=Integer.parseInt(properties.getProperty("idPhoneLocaleScoreKey"));
            idPhoneNameScoreKey=Integer.parseInt(properties.getProperty("idPhoneNameScoreKey"));
            phoneOnTimeScoreKey=Integer.parseInt(properties.getProperty("phoneOnTimeScoreKey"));
            phoneCosts50ScoreKey=Integer.parseInt(properties.getProperty("phoneCosts50ScoreKey"));
            phoneCosts100ScoreKey=Integer.parseInt(properties.getProperty("phoneCosts100ScoreKey"));
            phoneCosts200ScoreKey=Integer.parseInt(properties.getProperty("phoneCosts200ScoreKey"));
            is500ScoreKey= Integer.parseInt(properties.getProperty("is500ScoreKey"));
            educationLevelScoreKey= Integer.parseInt(properties.getProperty("educationLevelScoreKey"));
            edudgcheck_scoreScoreKey= Integer.parseInt(properties.getProperty("edudgcheck_scoreScoreKey"));
            eduyear_scoreScoreKey= Integer.parseInt(properties.getProperty("eduyear_scoreScoreKey"));
            eduage_scoreScoreKey= Integer.parseInt(properties.getProperty("eduage_scoreScoreKey"));
            qqwxage_scoreScoreKey= Integer.parseInt(properties.getProperty("qqwxage_scoreScoreKey"));
            qqwxinage_scoreScoreKey= Integer.parseInt(properties.getProperty("qqwxinage_scoreScoreKey"));
            linkphone_scoreScoreKey= Integer.parseInt(properties.getProperty("linkphone_scoreScoreKey"));
            workadd_scoreScoreKey= Integer.parseInt(properties.getProperty("workadd_scoreScoreKey"));
            workadd_home_scoreScoreKey= Integer.parseInt(properties.getProperty("workadd_home_scoreScoreKey"));
            wkyear_scoreScoreKey= Integer.parseInt(properties.getProperty("wkyear_scoreScoreKey"));
            income_scoreScoreKey= Integer.parseInt(properties.getProperty("income_scoreScoreKey"));
            social_security_scoreScoreKey1= Integer.parseInt(properties.getProperty("social_security_scoreScoreKey1"));
            social_security_scoreScoreKey2= Integer.parseInt(properties.getProperty("social_security_scoreScoreKey2"));
            accumulation_fund_scoreScoreKey1= Integer.parseInt(properties.getProperty("accumulation_fund_scoreScoreKey1"));
            accumulation_fund_scoreScoreKey2= Integer.parseInt(properties.getProperty("accumulation_fund_scoreScoreKey2"));
            income_compare_scoreScoreKey= Integer.parseInt(properties.getProperty("income_compare_scoreScoreKey"));
            debit_score= Integer.parseInt(properties.getProperty("debit_score"));
            ageScoreKey=Integer.parseInt(properties.getProperty("ageScoreKey"));
            ageManOlderKey =Integer.parseInt(properties.getProperty("ageManOlderKey"));
            ageDiffFiveKey =Integer.parseInt(properties.getProperty("ageDiffFiveKey"));
            marriedScoreKey =Integer.parseInt(properties.getProperty("marriedKey"));
            educationEqualScoreKey =Integer.parseInt(properties.getProperty("educationEqualScoreKey"));
            wifeEducationHigherScoreKey =Integer.parseInt(properties.getProperty("wifeEducationHigherScoreKey"));
            wifeWorkingScoreKey =Integer.parseInt(properties.getProperty("wifeWorkingScoreKey"));
            familyCount3ScoreKey =Integer.parseInt(properties.getProperty("familyCount3ScoreKey"));
            familyCount4ScoreKey =Integer.parseInt(properties.getProperty("familyCount4ScoreKey"));
            countryOriginScoreKey =Integer.parseInt(properties.getProperty("countryOriginScoreKey"));
            boyGreatSevenKey =Integer.parseInt(properties.getProperty("boyGreatSevenKey"));
            birthAgeKey =Integer.parseInt(properties.getProperty("birthAgeKey"));
            boyAndGirlKey =Integer.parseInt(properties.getProperty("boyAndGirlKey"));
            ageSubtractFiveOrTenKey =Integer.parseInt(properties.getProperty("ageSubtractFiveOrTenKey"));
            liveAddressKey =Integer.parseInt(properties.getProperty("liveAddressKey"));
            houseAddressKey =Integer.parseInt(properties.getProperty("houseAddressKey"));
            addressKey =Integer.parseInt(properties.getProperty("addressKey"));
            liveTimeKey =Integer.parseInt(properties.getProperty("liveTimeKey"));
            payYearKey =Integer.parseInt(properties.getProperty("payYearKey"));
            payIncomeRateKey =Integer.parseInt(properties.getProperty("payIncomeRateKey"));
            girlDegreeKey =Integer.parseInt(properties.getProperty("girlDegreeKey"));
            societyRelationsexKey = Integer.parseInt(properties.getProperty("societyRelationsexKey"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
