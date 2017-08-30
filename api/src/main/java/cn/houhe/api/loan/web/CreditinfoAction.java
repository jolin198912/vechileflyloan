package cn.houhe.api.loan.web;

import cn.com.iotrust.common.ValidatorException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.common.tongdun.TongDunService;
import cn.houhe.api.loan.entity.CreditApply;
import cn.houhe.api.loan.entity.Creditinfo;
import cn.houhe.api.loan.entity.VerifyThirdResult;
import cn.houhe.api.loan.service.CreditApplyService;
import cn.houhe.api.loan.service.CreditinfoService;
import cn.houhe.api.loan.service.VerifyThirdResultExtService;
import cn.houhe.api.loan.web.bo.TongDunDto;
import cn.houhe.api.member.entity.Member;
import cn.houhe.api.member.service.MemberService;
import cn.houhe.api.member.web.bo.BankCardDto;
import com.sun.org.apache.regexp.internal.REUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Spring MVC Controler - 表：creditinfo
 * @since 2017-03-29 18:30:03
 */
@Controller
@RequestMapping(value = "/repay")
public class CreditinfoAction {
	private static final Logger logger = LoggerFactory.getLogger(CreditinfoAction.class);

	@Autowired
	private CreditinfoService creditinfoService;

	@Autowired
	private VerifyThirdResultExtService verifyThirdResultExtService;
	@Autowired
	private CreditApplyService creditApplyService;
	@Autowired
	private MemberService memberService;
	/**
	 * 列表页面
	 */
	@RequestMapping(value = "/creditinfo", method=RequestMethod.GET)
	public Object listPage() {
		return "creditinfo";
	}

	/**
	 * 列表数据
	 */
	@RequestMapping(value = "/creditinfo", method=RequestMethod.POST)
	@ResponseBody
	public Object listData(HttpServletRequest request) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Criteria<Creditinfo> criteria = Criteria.create(Creditinfo.class);
			criteria.buildFromRequest(request);
			criteria.sortIfEmpty(Sort.asc("cdId"));
			Pager<Creditinfo> pager = creditinfoService.findPage(criteria);
			resultMap.put("result", 1);
			resultMap.put("total", pager.getTotalRecords());
			resultMap.put("rows", pager.getList());
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}

	/**
	 * 新增页面
	 */
	@RequestMapping(value = "/creditinfoadd", method=RequestMethod.GET)
	public Object addPage() {
		return "creditinfo_add";
	}

	/**
	 * 新增保存
	 */
	@RequestMapping(value = "/creditinfoadd", method=RequestMethod.POST)
	@ResponseBody
	public Object doAdd( Creditinfo creditinfo) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			creditinfoService.insert(creditinfo);
			resultMap.put("result", 1);
		} catch (ValidatorException ve) {
			resultMap.put("result", 0);
			resultMap.put("message", ve.getMessage());
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}

	/**
	 * 修改页面
	 */
	@RequestMapping(value = "/creditinfoedit", method=RequestMethod.GET)
	public Object editPage(Integer cdId) {
		ModelAndView model = new ModelAndView();
		try {
			Creditinfo creditinfo = creditinfoService.findByPrimaryKey(cdId);
			model.addObject("creditinfo", creditinfo);
			model.setViewName("creditinfo_edit");
		} catch (Exception e) {
			model.addObject("exception", e.getMessage());
			model.setViewName("/error");
			logger.error(e.getMessage(), e);
		}
		return model;
	}

	/**
	 * 修改保存
	 */
	@RequestMapping(value = "/creditinfoedit", method=RequestMethod.POST)
	@ResponseBody
	public Object doEdit( Creditinfo creditinfo) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			 
			creditinfoService.update(creditinfo);
			resultMap.put("result", 1);
		} catch (ValidatorException ve) {
			resultMap.put("result", 0);
			resultMap.put("message", ve.getMessage());
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/creditinfodelete", method=RequestMethod.POST)
	@ResponseBody
	public Object doDelete( List<Integer> ids) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			creditinfoService.batchDelete(ids);
			resultMap.put("result", 1);
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}
	/**
	 * 同盾校驗
	 */
	@RequestMapping(value = "/tdcheck", method=RequestMethod.POST)
	@ResponseBody
	public Object tdCheck(@RequestBody RequestDto<TongDunDto> param) {
		ResultDto result = new ResultDto();
		result.setMsg("同盾征信验证");
		TongDunDto dto=param.getData();
		Criteria<CreditApply> condition=Criteria.create(CreditApply.class);
		condition.add(ExpressionFactory.eq("memberId",dto.membid));
		CreditApply ca= creditApplyService.findAll(condition).get(0);
		Member m= memberService.findByPrimaryKey(ca.getMemberId());
		String jsonres= TongDunService.GetCheck(ca.getName(),ca.getIdCard(),m.getMobileno(),null,2);
		VerifyThirdResult vtr=new VerifyThirdResult();
		vtr.setCreditApplyId(ca.getCaId());
		vtr.setTongdunResult(jsonres);
		if(verifyThirdResultExtService.addResult(vtr))
		{
		    Map<String,String> map=new HashMap<>();
		    map.put("name",ca.getName());
            map.put("Mobileno",m.getMobileno());
            map.put("IdCard",ca.getIdCard());
		    result.setData(map);

			result.setCode("0");
		}else
		{
			result.setCode("1");
		}
		return  result;
	}

}