package cn.houhe.api.common.job;

import cn.com.iotrust.common.util.SpringContextHolder;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * Created by think on 2017/4/25.
 */
public class DefaultJob {
    public void doJob(String beanName, String methodName, String jsonParam){
        Object bean = SpringContextHolder.getBean(beanName);
        Method method = null;
        Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());
        for (Method method1 : methods) {//按名称找，不支持方法重载
            if (method1.getName().equals(methodName)){
                method = method1;
                break;
            }
        }
        Assert.notNull(method,"未找到所指定的方法");
        JSONObject param = JSONObject.parseObject(jsonParam);
        ReflectionUtils.invokeMethod(method,bean,param.values().toArray());
    }
}
