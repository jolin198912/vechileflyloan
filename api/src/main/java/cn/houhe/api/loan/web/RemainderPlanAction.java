package cn.houhe.api.loan.web;

import cn.com.iotrust.common.ValidatorException;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.loan.entity.RemainderPlanExt;
import cn.houhe.api.loan.service.RemainderPlanExtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring MVC Controler - 表：remainder_plan
 * @since 2017-05-24 18:33:37
 */
@Controller
@RequestMapping(value = "/loan")
public class RemainderPlanAction {
	private static final Logger logger = LoggerFactory.getLogger(RemainderPlanAction.class);

	@Autowired
	private RemainderPlanExtService remainderPlanExtService;

	/**
	 * 分配催收人员
	 */
	@RequestMapping(value = "/insertdistriution", method = RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public Object doAdd(@RequestBody RequestDto<RemainderPlanExt> param) {
		ResultDto result = new ResultDto( "0","分配催收人员");
		try {
			RemainderPlanExt dto = param.getData();
			remainderPlanExtService.insertSelective(dto.loanRecordIds, dto.repaymentsPlanIds, dto.remainderId, dto.remainder, dto.remark, dto.createdon);
		} catch (ValidatorException ve) {
			result.setMsg("分配失败");
			result.setCode("-1");
			logger.error(ve.getMessage(), ve);
		} catch (Exception e) {
			result.setMsg("服务器异常");
			result.setCode("-2");
			logger.error(e.getMessage(), e);
		}
		return result;
	}
}