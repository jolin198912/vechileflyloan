package cn.houhe.api.loan.service.score;

import org.apache.commons.lang3.time.DateUtils;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by victorrrr on 2017/7/18.
 */
public class CalcTime {

    /**
     * 获取申请时间的小时部分
     * @param applytime
     * @return
     */
    public static int getHours(Date applytime) {
        int hour = 0;
        if (applytime != null) {
            Calendar birthCal = Calendar.getInstance();
            birthCal.setTime(applytime);
            hour = birthCal.get(Calendar.HOUR_OF_DAY);
        }
        return hour;
    }

    /**
     * 得到年份
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        int year = 0;
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            year = calendar.get(Calendar.YEAR);
        }
        return year;
    }

    /**
     * 获取日期之间年差值
     * @param birth
     * @return
     */
    public static int getYearDiff(Date birth) {
        return Calendar.getInstance().get(Calendar.YEAR) - getYear(birth);
    }

    /**
     * 获取日期之间年差值
     * @param start
     * @param end
     * @return
     */
    public static int getYearDiff(Date start, int end)
    {
        return end - getYear(start);
    }

    /**
     * 获取日期之间年差值
     * @param start
     * @param end
     * @return
     */
    public static int getYearDiff(Date start, Date end) {
        return getYear(end) - getYear(start);
    }
    /**
     * 通过身份证计算年龄
     * @param idcard
     * @return
     */
    public static int getAge(String idcard) {
        int age = 0;
        Date birth = null;
        try {
            if (idcard.length() == 15) {
                birth = DateUtils.parseDate(idcard.substring(6,12),"yyMMdd");
            }else if (idcard.length() == 18){
                birth = DateUtils.parseDate(idcard.substring(6,14),"yyyyMMdd");
            }
            age = getYearDiff(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return age;
    }
}
