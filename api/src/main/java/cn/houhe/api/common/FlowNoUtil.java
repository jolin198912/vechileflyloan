package cn.houhe.api.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by think on 2017/4/27.
 */
public class FlowNoUtil {
    private static final DateFormat FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    public static String next(){
        return  FORMAT.format(new Date())+System.currentTimeMillis();
    }
}
