package cn.houhe.api.common;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by think on 2017/5/27.
 */
public class FormulaUtil {
    private  static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
    public static Number eval(final String exp, Map<String,Number> param) throws ScriptException {
        /*for (Map.Entry<String, Number> entry : param.entrySet()) {
            exp = exp.replaceAll("#\\{"+entry.getKey()+"\\}",entry.getValue().toString());
        }*/
        StringBuilder stringBuilder = new StringBuilder(exp);
        param.forEach((s, number) -> {
            String tmp = stringBuilder.toString();
            stringBuilder.delete(0,stringBuilder.length());
            stringBuilder.append(tmp.replaceAll("#\\{"+s+"\\}",number.toString()));
        });
        return (Number) jse.eval(stringBuilder.toString());
    }


    public static void main(String[] args) throws ScriptException {
        Map<String,Number> param = new HashMap<>();
        param.put("limit",1000);
        param.put("loanRate",0.044);
        param.put("withdrawRate",0.002);
        param.put("quotaManageRate",0.001);
        param.put("time",7);
        System.out.println("formula: "+FormulaUtil.eval("#{limit}*(1-(#{loanRate}/30*#{time}+#{withdrawRate}+#{quotaManageRate}))",param));
    }
}
