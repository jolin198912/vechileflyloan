package cn.houhe.api.loan.web;

import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.loan.entity.bo.SettleListObject;
import cn.houhe.api.loan.service.SettleListService;
import cn.houhe.api.loan.web.bo.SettleListDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/27.
 */
@Controller
@RequestMapping(value = "/settle")
public class SettleListAction {
    private static final Logger logger = LoggerFactory.getLogger(AuthorizeInfoAction.class);

    @Autowired
    private SettleListService settleListService;

    /**
     * 结清清单
     */
    @RequestMapping(value = "/list", method= RequestMethod.POST)
    @ResponseBody
    public Object overdueList(SettleListDto dto) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        try {
            dto.page=(dto.page-1)*dto.rows;
            Pager<SettleListObject> pager=settleListService.getSettleList(dto);
            resultMap.put("total", pager.getTotalRecords());
            resultMap.put("rows", pager.getList());
        } catch (Exception e) {
            resultMap.put("total", -1);
            resultMap.put("rows", null);
            logger.error(e.getMessage(), e);
        }
        return resultMap;
    }
}
