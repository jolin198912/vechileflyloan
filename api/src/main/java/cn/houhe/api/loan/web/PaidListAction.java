package cn.houhe.api.loan.web;

import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.loan.entity.bo.PaidListObject;
import cn.houhe.api.loan.service.PaidListService;
import cn.houhe.api.loan.web.bo.PaidListDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/27.
 */
@Controller
@RequestMapping(value = "/paid")
public class PaidListAction {
    private static final Logger logger = LoggerFactory.getLogger(AuthorizeInfoAction.class);

    @Autowired
    private PaidListService paidListService;

    /**
     * 实收账单
     */
    @RequestMapping(value = "/list", method= RequestMethod.POST)
    @ResponseBody
    public Object receivableList(PaidListDto dto) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        try {
            if(dto.getEndDate() != null){
                Calendar cal = Calendar.getInstance();
                cal.setTime(dto.getEndDate());
                cal.setTimeInMillis(cal.getTimeInMillis()+23*60*60*1000 + 59*60*1000 + 59*1000);
                Date timef = cal.getTime();
                dto.setEndDate(timef);
            }
            dto.page=(dto.page-1)*dto.rows;
            Pager<PaidListObject> pager=paidListService.getPaidList(dto);
            resultMap.put("total", pager.getTotalRecords());
            resultMap.put("rows", pager.getList());
        } catch (Exception e) {
            resultMap.put("total", -1);
            resultMap.put("rows", null);
            logger.error(e.getMessage(), e);
        }
        return resultMap;
    }

    /**
     * 导出实收账单excel
     */
    @RequestMapping(value = "/importexcel", method=RequestMethod.GET)
    @ResponseBody
    public void importExcel(PaidListDto dto, HttpServletResponse response){
        try {
            if(dto.getEndDate() != null){
                Calendar cal = Calendar.getInstance();
                cal.setTime(dto.getEndDate());
                cal.setTimeInMillis(cal.getTimeInMillis()+23*60*60*1000 + 59*60*1000 + 59*1000);
                Date timef = cal.getTime();
                dto.setEndDate(timef);
            }
            SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
            String ctime = formatter.format(new Date());
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition","attachment;fileName=" + new String(("实收账单").getBytes("GB2312"),"iso8859-1") + ctime + ".xls");// 设置文件名
            paidListService.importExcelFile(dto, response.getOutputStream());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
