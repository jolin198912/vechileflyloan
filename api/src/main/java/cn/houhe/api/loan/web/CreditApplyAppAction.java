package cn.houhe.api.loan.web;

import cn.houhe.api.common.ResultDto;
import cn.houhe.api.loan.service.CreditApplyExtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by victorrrr on 2017/5/26.
 */
@Controller
@RequestMapping(value = "/credit/app")
public class CreditApplyAppAction {

    @Autowired
    private CreditApplyExtService creditApplyExtService;

    @RequestMapping(value = "/statistics/getMemCountBySex",method = RequestMethod.POST)
    @ResponseBody
    public ResultDto getMemCountBySex() {
        return new ResultDto<>().data(creditApplyExtService.findMemCountBySex());
    }

    @RequestMapping(value = "/statistics/getMemCountByAge",method = RequestMethod.POST)
    @ResponseBody
    public ResultDto getMemCountByAge() {
        return new ResultDto<>().data(creditApplyExtService.findMemCountByAge());
    }

    @RequestMapping(value = "/statistics/getMemCountByMarriage",method = RequestMethod.POST)
    @ResponseBody
    public ResultDto getMemCountByMarriage() {
        return new ResultDto<>().data(creditApplyExtService.findMemCountByMarriage());
    }

    @RequestMapping(value = "/statistics/getMemCountByDomPro",method = RequestMethod.POST)
    @ResponseBody
    public ResultDto selectMemCountByDomicileProvince() {
        return new ResultDto<>().data(creditApplyExtService.findMemCountByDomicileProvince());
    }

    @RequestMapping(value = "/statistics/getMemCountByNative",method = RequestMethod.POST)
    @ResponseBody
    public ResultDto selectMemCountByNative() {
        return new ResultDto<>().data(creditApplyExtService.findMemCountByNativeProvince());
    }
}
