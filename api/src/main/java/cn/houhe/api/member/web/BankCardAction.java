package cn.houhe.api.member.web;

import cn.houhe.api.common.AliTools;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.common.enums.PushMsgEnum;
import cn.houhe.api.loan.service.CreditApplyExtService;
import cn.houhe.api.loan.service.RepaymentsPlanExtService;
import cn.houhe.api.loan.service.pay.PayService;
import cn.houhe.api.member.service.BankCardExtService;

import cn.houhe.api.member.web.bo.BankCardDto;
import jdk.nashorn.internal.ir.CatchNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.util.resources.cldr.tg.CalendarData_tg_Cyrl_TJ;


/**
 * Spring MVC Controler - 表：bank_card
 * @since 2017-03-30 10:12:39
 */
@Controller
@RequestMapping(value = "/bankcard")
public class BankCardAction {
	@Autowired
	private BankCardExtService bankCardExtService;

	@Autowired
	CreditApplyExtService creditApplyExtService;
	@Autowired
	RepaymentsPlanExtService repaymentsPlanExtService;
	@Autowired
	PayService payService;

	/*
    使用场景说明：获取银行卡列表接口，APP端根据此接口返回值展示银行卡列表页
    参数定义：memberId 会员id
    code值定义：0 获取成功
                -1 银行卡列表异常
    */
	@RequestMapping(value = "/getbankcardlist", method=RequestMethod.POST,produces = "application/json")
	@ResponseBody()
	public Object getBankCardList(@RequestBody RequestDto<BankCardDto> param){
		return bankCardExtService.getBankCardListSer(param);
	}

	/*
    使用场景说明：添加银行卡接口，APP端根据此接口发送手机验证码并添加银行卡，返回值判断是否添加成功，成功则跳转到银行卡列表页，失败则提示添加失败
    参数定义：
    		  memberId 会员id
    		  cardholder 持卡人
    		  bankcardno 银行卡号
    		  collectingbank 收款银行
    		  reservedmobile 银行预留手机号
              verificode 验证码
    code值定义：0 添加成功
                1 添加的银行卡已存在
                2 验证码错误，请重新输入
                -1 银行卡添加失败，请重试
    */
	@RequestMapping(value = "/addbankcard", method= RequestMethod.POST,produces = "application/json")
	@ResponseBody()
	public Object addBankCard(@RequestBody RequestDto<BankCardDto> param){
		return bankCardExtService.addBankCardSer(param);
	}

	/*
    使用场景说明：获取银行卡信息接口
    参数定义：
              memberId  会员id
    		  bankcardno 银行卡号
    code值定义：0 查询成功
    			1 银行卡信息有误
                -1 查询异常
    */
	@RequestMapping(value = "/getbankcardinfo", method= RequestMethod.POST,produces = "application/json")
	@ResponseBody()
	public Object getBankCardInfo(@RequestBody RequestDto<BankCardDto> param) {
		return bankCardExtService.getBankCardInfoSer(param);
	}

	/*
    使用场景说明：发送短信验证码
    参数定义：
    		  memberId  会员id
    		  bankcardno 银行卡号
    		  reservedmobile 银行预留手机号
    code值定义：0 发送成功
                -1 发送异常
    */
	@RequestMapping(value = "/sendverificode", method= RequestMethod.POST,produces = "application/json")
	@ResponseBody()
	public Object sendVerifiCode(@RequestBody RequestDto<BankCardDto> param) {
		return bankCardExtService.sendMessage(param);
	}

	/*
    使用场景说明：认证
    参数定义：
              memberId  会员id
    		  bankcardno 银行卡号
    		  reservedmobile 银行预留手机号
    		  msgcode 验证码
    		  batchno 请求流水号
    code值定义：0 认证成功
                -1 认证异常
    */
	@RequestMapping(value = "/verify", method= RequestMethod.POST,produces = "application/json")
	@ResponseBody()
	public Object verify(@RequestBody RequestDto<BankCardDto> param) {
		return bankCardExtService.verify(param);
	}

    /*
    使用场景说明：查询会员银行卡信息接口
    参数定义：memberId 会员id
    code值定义：0 获取成功
                -1 查询异常
    */
    @RequestMapping(value = "/getmerbankcard", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody()
    public Object getMerBankCard(@RequestBody RequestDto<BankCardDto> param) {
        return bankCardExtService.getMerBankCardInfo(param.getData().getMemberId());
    }

	/*
      使用场景说明：绑定银行卡前查询银行卡，是否已经绑定（是否已经跟我们签权）
       参数定义：
          memberId  会员id
          bankcardno 银行卡号
       code值定义：0 查询成功
            1 银行卡信息有误
            -1 查询异常
     */
	@RequestMapping(value = "/cardisband", method= RequestMethod.POST,produces = "application/json")
	@ResponseBody()
	public Object checkCardisBand(@RequestBody RequestDto<BankCardDto> param) {
		return bankCardExtService.verifyQuery(param);
	}
	@RequestMapping(value = "/debandcard", method= RequestMethod.GET,produces = "application/json")
	@ResponseBody()
	public Object deBandCard(String cardno)
	{
		try {
			return payService.deBand(cardno);
		}catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return "faile";
	}
}