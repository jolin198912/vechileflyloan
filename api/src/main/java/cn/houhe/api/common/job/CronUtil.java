package cn.houhe.api.common.job;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * Created by think on 2017/4/26.
 */
public class CronUtil {
    public static String laterOneTime(TimeUnit unit, int time){
        Calendar calendar = Calendar.getInstance();
        StringBuilder sb = new StringBuilder();
        if (TimeUnit.MINUTES.equals(unit)){
            calendar.add(Calendar.MINUTE, time);
            sb.append("0 ").append(calendar.get(Calendar.MINUTE))
                    .append(" ")
                    .append(calendar.get(Calendar.HOUR_OF_DAY))
                    .append(" ")
                    .append(calendar.get(Calendar.DAY_OF_MONTH))
                    .append(" ")
                    .append(calendar.get(Calendar.MONTH) + 1)
                    .append(" ")
                    .append(" ?")
                    .append(" ")
                    .append(calendar.get(Calendar.YEAR));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(laterOneTime(TimeUnit.MINUTES,3));
    }
}
