package cn.houhe.api.loan.web;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.loan.entity.DebitRcd;
import cn.houhe.api.loan.entity.RepaymentsPlan;
import cn.houhe.api.loan.entity.bo.LoanRecordInfoObject;
import cn.houhe.api.loan.entity.bo.RepaymentDto;
import cn.houhe.api.loan.entity.bo.RepaymentDtoApp;
import cn.houhe.api.loan.service.RepaymentsPlanExtService;
import cn.houhe.api.loan.service.RepaymentsPlanService;
import cn.houhe.api.loan.web.bo.MemberDto;
import cn.houhe.api.loan.web.bo.RepaymentsDto;
import cn.houhe.api.loan.web.bo.SelectDto;
import com.sun.org.apache.regexp.internal.REUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Spring MVC Controler - 表：repayments_plan
 * @since 2017-03-29 18:30:03
 */
@Controller
@RequestMapping(value = "/repayplan")
public class RepaymentsPlanAction {
	private static final Logger logger = LoggerFactory.getLogger(RepaymentsPlanAction.class);

	@Autowired
	private RepaymentsPlanService repaymentsPlanService;

	@Autowired
	private RepaymentsPlanExtService repaymentsPlanExtService;

	/**
	 * 催收列表
	 */
	@RequestMapping(value = "/repaymentsplanlist", method=RequestMethod.POST)
	@ResponseBody
	public Object repaymentsplanlist(RepaymentsDto dto) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			if(dto.getRealpayEnd() != null){
				Calendar cal = Calendar.getInstance();
				cal.setTime(dto.getRealpayEnd());
				cal.setTimeInMillis(cal.getTimeInMillis()+23*60*60*1000 + 59*60*1000 + 59*1000);
				Date timef = cal.getTime();
				dto.setRealpayEnd(timef);
			}
			dto.page=(dto.page-1)*dto.rows;
			Pager<RepaymentDto> pager=repaymentsPlanService.findPaymentPage(dto);
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
	 * 导出催收列表excel
	 */
	@RequestMapping(value = "/importexcel", method=RequestMethod.GET)
	@ResponseBody
	public void importExcel(RepaymentsDto dto, HttpServletResponse response){
		try {
			if(dto.getPayend() != null){
				Calendar cal = Calendar.getInstance();
				cal.setTime(dto.getPayend());
				cal.setTimeInMillis(cal.getTimeInMillis()+23*60*60*1000 + 59*60*1000 + 59*1000);
				Date timef = cal.getTime();
				dto.setPayend(timef);
			}
			String status = "";
			switch (dto.getStatus()){
				case 0:
					status = "催收（催收中）_";
					break;
				case 1:
					status = "催收（已完成）_";
					break;
				case 2:
					status = "催收（坏账）_";
					break;
				case 3:
					status = "催收（待分配）_";
					break;
			}
			SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
			String ctime = formatter.format(new Date());
			response.setContentType("application/force-download");// 设置强制下载不打开
			response.addHeader("Content-Disposition","attachment;fileName=" + new String((status).getBytes("GB2312"),"iso8859-1") + ctime + ".xls");// 设置文件名
			repaymentsPlanExtService.importExcelFile(dto, response.getOutputStream());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * 逾期清单
	 */
	@RequestMapping(value = "/overduelist", method=RequestMethod.POST)
	@ResponseBody
	public Object overdueList(RepaymentsDto dto) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			if(dto.getRealpayEnd() != null){
				Calendar cal = Calendar.getInstance();
				cal.setTime(dto.getRealpayEnd());
				cal.setTimeInMillis(cal.getTimeInMillis()+23*60*60*1000 + 59*60*1000 + 59*1000);
				Date timef = cal.getTime();
				dto.setRealpayEnd(timef);
			}
			dto.page=(dto.page-1)*dto.rows;
			Pager<RepaymentDto> pager=repaymentsPlanService.getOverdueList(dto);
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
	 * 导出逾期清单excel
	 */
	@RequestMapping(value = "/overdueimportexcel", method=RequestMethod.GET)
	@ResponseBody
	public void overdueImportExcel(RepaymentsDto dto, HttpServletResponse response){
		try {
			if(dto.getRealpayEnd() != null){
				Calendar cal = Calendar.getInstance();
				cal.setTime(dto.getRealpayEnd());
				cal.setTimeInMillis(cal.getTimeInMillis()+23*60*60*1000 + 59*60*1000 + 59*1000);
				Date timef = cal.getTime();
				dto.setRealpayEnd(timef);
			}
			SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
			String ctime = formatter.format(new Date());
			response.setContentType("application/force-download");// 设置强制下载不打开
			response.addHeader("Content-Disposition","attachment;fileName=" + new String(("逾期清单").getBytes("GB2312"),"iso8859-1") + ctime + ".xls");// 设置文件名
			repaymentsPlanExtService.importExcelFileOverdue(dto, response.getOutputStream());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * 获取还款计划
	 * @param requestDto
	 * @return
	 */
	@RequestMapping(value = "/repaymentsplan", method = RequestMethod.POST)
	@ResponseBody
	public ResultDto<List<RepaymentsPlan>> getPlanByLoanId(@RequestBody RequestDto<LoanRecordInfoObject> requestDto) {
		ResultDto<List<RepaymentsPlan>> resultDto = new ResultDto<>("0", "获取成功");
		try {
			Criteria<RepaymentsPlan> criteria=Criteria.create(RepaymentsPlan.class);
			criteria.add(ExpressionFactory.eq("loanRecordId",requestDto.getData().getLoanId()));
			criteria.sortIfEmpty(Sort.asc("payDate"));
			List<RepaymentsPlan> lst= repaymentsPlanService.findAll(criteria);
			if(lst!=null&&lst.size()>0) {
                RepaymentsPlan res = Collections.max(lst, new Comparator<RepaymentsPlan>() {
                    @Override
                    public int compare(RepaymentsPlan s1, RepaymentsPlan s2) {
                        return s1.getCurrentTerm() - s2.getCurrentTerm();
                    }
                });
                //最后一期不收利息
                BigDecimal totalpay = res.getTotalPay().subtract(res.getInterest());
                res.setTotalPay(totalpay);
                res.setRealPay(totalpay);
                res.setRealTotalPay(totalpay);
                resultDto.setData(lst);
            }else
            {
                resultDto.setData(new ArrayList<RepaymentsPlan>());
            }
		} catch (Exception e) {
			resultDto.setCode("1");
			resultDto.setMsg(e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultDto;
	}

	/**
	 * 根据会员id获取会员应还款列表
	 * @param requestDto
	 * @return
	 */
	@RequestMapping(value = "/getnotpaylist", method = RequestMethod.POST)
	@ResponseBody
	public ResultDto<List<RepaymentDtoApp>> getNotPayList(@RequestBody RequestDto<MemberDto> requestDto) {
		ResultDto<List<RepaymentDtoApp>> resultDto = new ResultDto<>("0", "获取成功");
		try {
			MemberDto dto=requestDto.getData();
			Calendar calendar=Calendar.getInstance();
			calendar.add(Calendar.DATE,30);
			dto.setEndate(calendar.getTime());
			resultDto.setData(repaymentsPlanExtService.getNotPayList(dto));
		} catch (Exception e) {
			resultDto.setCode("1");
			resultDto.setMsg(e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultDto;
	}

	/**
	 * 逾期还款
	 * @param requestDto
	 * @return
	 */
	@RequestMapping(value = "/overduePay", method = RequestMethod.POST)
	@ResponseBody
	public ResultDto overduePay(@RequestBody RequestDto<DebitRcd> requestDto) {
		ResultDto resultDto = new ResultDto<>("0", "获取成功");
		try {
			int res= repaymentsPlanExtService.overduePay(requestDto.getData());
			if(res==1) {
				return  resultDto;
			}else
			{
				resultDto.setCode("1");
				resultDto.setMsg("利息正在计算中，请稍后重试");
			}
		} catch (Exception e) {
			resultDto.setCode("1");
			resultDto.setMsg(e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultDto;
	}

	/**
	 * 催收人员列表
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/getpersonnellist", method = RequestMethod.POST)
	@ResponseBody
	public ResultDto getPersonnelList(){
		ResultDto resultDto = new ResultDto<>("0", "获取成功");
		try {
			List<SelectDto> personnellst = repaymentsPlanExtService.findPersonnelList();
			resultDto.setData(personnellst);
		} catch (Exception e) {
			resultDto.setCode("-1");
			resultDto.setMsg(e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultDto;
	}
}