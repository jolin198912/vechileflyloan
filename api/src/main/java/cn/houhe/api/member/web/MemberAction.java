package cn.houhe.api.member.web;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.Configs;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.common.carcheck.CarCheckService;
import cn.houhe.api.common.carcheck.util.CarInfoModel;
import cn.houhe.api.member.entity.*;
import cn.houhe.api.member.service.MemberExtService;
import cn.houhe.api.member.service.MemberService;
import cn.houhe.api.member.web.bo.CheckCarDto;
import cn.houhe.api.member.web.bo.LoanRatesDto;
import cn.houhe.api.member.web.bo.MemberDto;
import cn.houhe.api.member.web.bo.MemberListDto;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.DatagramPacket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Spring MVC Controler - 表：member
 *
 * @since 2017-03-30 10:12:39
 */
@Controller
@RequestMapping(value = "/member")
public class MemberAction {
    private static final Logger logger = LoggerFactory.getLogger(MemberAction.class);

    @Autowired
    private MemberExtService memberExtService;

    @Autowired
    private MemberService memberService;

    /*
    使用场景说明：验证用户是否已注册接口，APP端根据此接口返回值判断下一步是跳转到登录页还是注册页
    参数定义：mobile 手机号
    code值定义：0 未注册
                1 已注册
                -1 接口异常
    */
    @RequestMapping(value = "/isregister", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody()
    public Object isRegister(@RequestBody RequestDto<MemberDto> param) {
        return memberExtService.isRegisterSer(param);
    }

    /*
    使用场景说明：登录接口，APP端根据此接口返回值判断是否登录成功，成功则跳转到首页或设置手势密码页，失败则提示密码错误，登录失败
    参数定义：mobile 手机号
              loginpsw 登录密码
    code值定义：0 登录成功
                1 登录失败（密码错误，请核对后重新输入）
                2 该用户不存在
                -1 登录失败，请重试
    */
    @RequestMapping(value = "/userlogin", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody()
    public Object userLogin(@RequestBody RequestDto<MemberDto> param) {
        return memberExtService.userLoginSer(param);
    }

    /*
    使用场景说明：获取用户贷款相关信息接口
    参数定义：mobile 手机号
    code值定义：0 查询成功
                1 未查询到该用户的贷款相关信息
                -1 查询异常
    */
    @RequestMapping(value = "/getmemloaninfo", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody()
    public Object getMemLoanInfo(@RequestBody RequestDto<MemberDto> param) {
        return memberExtService.getMemLoanInfoSer(param);
    }

    /*
    使用场景说明：注册接口，APP端根据此接口发送手机验证码，返回值判断是否注册成功，成功则跳转到首页或设置手势密码页，失败则提示注册失败
    参数定义：mobile 手机号
              verificode 验证码
              loginpsw 登录密码
              invitecode 邀请码
    code值定义：0 注册成功
                1 注册用户已存在
                2 验证码错误，请重新输入
                -1 注册失败，请重试
    */
    @RequestMapping(value = "/userregister", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody()
    public Object userRegister(@RequestBody RequestDto<MemberDto> param) {
        return memberExtService.userRegisterSer(param);
    }

    /*
    使用场景说明：修改忘记登录密码接口，APP端根据此接口修改用户的登录密码，返回值判断是否修改成功，成功则发送短信通知并跳转到登录页，失败则提示登录密码修改失败
    参数定义：mobile 手机号
              updatepswtype 修改登录密码类型（0：忘记登录密码 1：修改登录密码）
              verificode 验证码（忘记密码时需传）
              loginpsw 原登录密码（修改密码时需传）
              newloginpsw 新登录密码
    code值定义：0 登录密码修改成功
                1 该用户不存在
                2 原登录密码输入错误
                3 新的登录密码不能与交易密码相同
                4 验证码错误，请重新输入
                -1 登录密码修改失败，请重试
    */
    @RequestMapping(value = "/updateloginpsw", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody()
    public Object updateLoginPsw(@RequestBody RequestDto<MemberDto> param) {
        return memberExtService.updateLoginPswSer(param);
    }

    /*
    使用场景说明：修改交易密码接口，APP端根据此接口修改用户的交易密码，返回值判断是否修改成功，成功则提示交易密码修改成功，失败则提示交易密码修改失败
    参数定义：mobile 手机号
              tradingpsw 原交易密码
              newtradingpsw 新交易密码
    code值定义：0 交易密码修改成功
                1 该用户不存在
                2 原交易密码输入错误
                3 新的交易密码不能与登录密码相同
                -1 交易密码修改失败，请重试
    */
    @RequestMapping(value = "/updatetradingpsw", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody()
    public Object updateTradingPsw(@RequestBody RequestDto<MemberDto> param) {
        return memberExtService.updateTradingPswSer(param);
    }

    /*
    使用场景说明：设置交易密码接口，APP端根据此接口设置用户的交易密码，返回值判断是否设置成功，成功则提示交易密码设置成功，失败则提示交易密码设置失败
    参数定义：mobile 手机号
              loginpsw 登录密码
              tradingpsw 交易密码
    code值定义：0 设置成功
                1 该用户不存在
                2 登录密码错误
                3 设置的交易密码不能与登录密码相同
                -1 交易密码设置失败，请重试
    */
    @RequestMapping(value = "/settradingpsw", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody()
    public Object setTradingPsw(@RequestBody RequestDto<MemberDto> param) {
        return memberExtService.setTradingPswSer(param);
    }

    /*
    使用场景说明：忘记交易密码接口，APP端根据此接口修改用户的交易密码，返回值判断是否修改成功，成功则提示交易密码修改成功，失败则提示交易密码修改失败
    参数定义：mobile 手机号
              realname 姓名（下一步用户信息校验时需传）
              idcardno 身份证号（下一步用户信息校验时需传）
              loginpsw 登录密码（下一步用户信息校验时需传）
              newtradingpsw 新交易密码（设置新交易密码时需传）
              nextstep 下一步操作 设置交易密码操作类型（0：校验用户信息 1：修改交易密码）
    code值定义：0 用户信息校验成功/交易密码修改成功
                1 该用户不存在
                2 信息有错误，请核对后再输入
                3 新的交易密码不能与登录密码相同
                -1 接口异常，用户信息校验失败/交易密码修改失败
    */
    @RequestMapping(value = "/forgettradingpsw", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody()
    public Object forgetTradingPsw(@RequestBody RequestDto<MemberDto> param) {
        return memberExtService.forgetTradingPswSer(param);
    }

    /*
    使用场景说明：注册时发送短信验证码接口，APP端根据此接口发送手机短信验证码
    参数定义：mobile 手机号
    code值定义：0 短信验证码发送成功
                -1 短信验证码发送失败，请重试
    */
	@RequestMapping(value = "/sendverificode", method= RequestMethod.POST,produces = "application/json")
	@ResponseBody()
	public Object sendVerificode(@RequestBody RequestDto<MemberDto> param){
		return memberExtService.sendVerificodeSer(param);
	}

    /*
    使用场景说明：修改登录密码时发送短信验证码接口，APP端根据此接口发送手机短信验证码
    参数定义：mobile 手机号
    code值定义：0 短信验证码发送成功
                -1 短信验证码发送失败，请重试
    */
    @RequestMapping(value = "/updateLoginPwdSendCode", method= RequestMethod.POST,produces = "application/json")
    @ResponseBody()
    public Object UpdateLoginPwdSendCode(@RequestBody RequestDto<MemberDto> param){
        return memberExtService.updateLoginPwdSendCodeSer(param);
    }

    /*
    使用场景说明：查询贷款利率和贷款方案接口，APP端根据此接口返回值实现贷款计算器
    参数定义：memberId 会员id
    code值定义：0 获取成功
                -1 查询异常
    */
    @RequestMapping(value = "/getrloanates", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody()
    public Object getLoanRates(@RequestBody RequestDto<LoanRatesDto> param) {
        return memberExtService.getLoanRatesSer(param);
    }

    /*
    使用场景说明：验证交易密码接口
    参数定义：mobile 手机号
              tradingpsw 交易密码
    code值定义：0 验证通过
                1 用户不存在
                2 输入的交易密码不匹配，验证不通过
                -1 交易密码验证异常
    */
    @RequestMapping(value = "/validationtradingpsw", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody()
    public Object validationTradingPsw(@RequestBody RequestDto<MemberDto> param) {
        return memberExtService.validationTradingPswSer(param);
    }

    /**
     * 列表数据(后台使用)
     */
    @RequestMapping(value = "/getmemberlist", method = RequestMethod.POST)
    @ResponseBody
    public Object listData(MemberListDto requestDto) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            MemberListExt memberlistExt = new MemberListExt();
            BeanUtils.copyProperties(memberlistExt, requestDto);
            memberlistExt.setPage((memberlistExt.getPage() - 1) * memberlistExt.getRows());
            resultMap.put("result", 1);
            resultMap.put("total", memberExtService.getCount(memberlistExt));
            resultMap.put("rows", memberExtService.findPageExt(memberlistExt));
        } catch (Exception e) {
            resultMap.put("result", 0);
            resultMap.put("message", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultMap;
    }

    /**
     * 会员详细信息(后台使用)
     */
    @RequestMapping(value = "/getmemberdetailinfo", method = RequestMethod.POST)
    @ResponseBody
    public Object detailInfo(@RequestBody RequestDto<MemberListDto> requestDto) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            Integer memid = requestDto.getData().getMemId();
            List<LoanContractExt> contractlst = memberExtService.getCreditContractFileList(memid);
            MemberDetailInfoExt memdetail = memberExtService.getMemberDetailInfo(memid);
            memdetail.setCreditContractFileUrl(contractlst);
            resultMap.put("data", memdetail);
            resultMap.put("code", 0);
        } catch (Exception e) {
            resultMap.put("result", 0);
            resultMap.put("message", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultMap;
    }

    /*
    使用场景说明：获取贷款记录列表（后台使用)
    参数定义：memid 会员id
    */
    @RequestMapping(value = "/getloanrecordlist", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody()
    public Object getLoanRecordList(@RequestBody RequestDto<MemberListDto> requestDto) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            Integer memid = requestDto.getData().getMemId();
            List<LoanRecordListExt> loanreclst = memberExtService.getLoanRecord(memid);
            for(int i = 0; i < loanreclst.size(); i++){
                LoanRecordListExt item = loanreclst.get(i);
                List<LoanContractExt> contractlst = memberExtService.getLoanCreditContractFileList(item.getLoanId());
                item.setLoanContractFileUrl(contractlst);
            }
            resultMap.put("data", loanreclst);
            resultMap.put("code", 0);
        } catch (Exception e) {
            resultMap.put("result", 0);
            resultMap.put("message", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultMap;
    }

    /**
     * 使用场景说明：获取还款记录列表（后台使用)
     * 参数定义：memid 会员id
     */
    @RequestMapping(value = "/getdebitrecordlist", method = RequestMethod.POST)
    @ResponseBody
    public Object getDebitRecordList(MemberListDto requestDto) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            DebitRecordListExt debitRecordListExt = new DebitRecordListExt();
            BeanUtils.copyProperties(debitRecordListExt, requestDto);
            debitRecordListExt.setPage((debitRecordListExt.getPage() - 1) * debitRecordListExt.getRows());
            resultMap.put("result", 1);
            resultMap.put("total", memberExtService.getDebitRecordCount(debitRecordListExt));
            resultMap.put("rows", memberExtService.findDebitRecordPageExt(debitRecordListExt));
        } catch (Exception e) {
            resultMap.put("result", 0);
            resultMap.put("message", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultMap;
    }

    /*
    使用场景说明：获取逾期还款记录列表(后台使用)
    参数定义：memid 会员id
    */
    @RequestMapping(value = "/getoverduerecordlist", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody()
    public Object getOverdueRecordList(@RequestBody RequestDto<MemberListDto> requestDto) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            resultMap.put("data", memberExtService.getOverdueRecord(requestDto.getData().getMemId()));
            resultMap.put("code", 0);
        } catch (Exception e) {
            resultMap.put("result", 0);
            resultMap.put("message", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultMap;
    }

    /**
     * 使用场景说明：获取催收记录列表（后台使用)
     * 参数定义：memid 会员id
     */
    @RequestMapping(value = "/getremainderrecoadlist", method = RequestMethod.POST)
    @ResponseBody
    public Object getRemainderRecoadList(MemberListDto requestDto) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            RemainderRecoadListExt remainderRecoadListExt = new RemainderRecoadListExt();
            BeanUtils.copyProperties(remainderRecoadListExt, requestDto);
            remainderRecoadListExt.setPage((remainderRecoadListExt.getPage() - 1) * remainderRecoadListExt.getRows());
            resultMap.put("result", 1);
            resultMap.put("total", memberExtService.getRemainderRecoadCount(remainderRecoadListExt));
            resultMap.put("rows", memberExtService.findRemainderRecoadPageExt(remainderRecoadListExt));
        } catch (Exception e) {
            resultMap.put("result", 0);
            resultMap.put("message", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultMap;
    }

    /**
     * 使用场景说明：获取邀请记录列表（后台使用)
     * 参数定义：invitecode 邀请码
     */
    @RequestMapping(value = "/getinviterecordlist", method = RequestMethod.POST)
    @ResponseBody
    public Object getInviteRecordList(MemberListDto requestDto) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            MemberListExt memberlistExt = new MemberListExt();
            BeanUtils.copyProperties(memberlistExt, requestDto);
            memberlistExt.setPage((memberlistExt.getPage() - 1) * memberlistExt.getRows());
            resultMap.put("result", 1);
            resultMap.put("total", memberExtService.getInviteRecordCount(memberlistExt));
            resultMap.put("rows", memberExtService.findInviteRecordPageExt(memberlistExt));
        } catch (Exception e) {
            resultMap.put("result", 0);
            resultMap.put("message", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultMap;
    }

    /**
     * 使用场景说明：获取用户详情，催收展示
     */
    @RequestMapping(value = "/getMemberPressDetail", method = RequestMethod.POST)
    @ResponseBody
    public Object getMemberPressDetail(@RequestBody RequestDto<MemberListDto> requestDto) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            resultMap.put("result", 1);
            resultMap.put("data", memberExtService.getMemberPressDetail(requestDto.getData().getMemId()));
        } catch (Exception e) {
            resultMap.put("result", 0);
            resultMap.put("message", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultMap;
    }

    /**
     * 使用场景说明：加入黑名单/释放黑名单
     */
    @RequestMapping(value = "/addblacklist", method = RequestMethod.POST)
    @ResponseBody
    public Object addBacklist(@RequestBody RequestDto<MemberListDto> requestDto) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            Member m = new Member();
            m.setMemid(requestDto.getData().getMemId());
            m.setIsEnable(requestDto.getData().getIsenable());
            memberService.updateSelective(m);
            resultMap.put("result", 1);
        } catch (Exception e) {
            resultMap.put("result", 0);
            resultMap.put("message", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultMap;
    }

    /**
     * 使用场景说明：黑名单列表
     */
    @RequestMapping(value = "/blacklist", method = RequestMethod.POST)
    @ResponseBody
    public Object backList(Member member) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            Criteria<Member> criteria = Criteria.create(Member.class);
            //criteria.buildFromRequest(request);
            criteria.add(ExpressionFactory.eq("isEnable", member.getIsEnable()));
            if (member.getRealname() != null)
                criteria.add(ExpressionFactory.like("realname", "%" + member.getRealname() + "%"));
            if (member.getIdcardno() != null)
                criteria.add(ExpressionFactory.like("idcardno", "%" + member.getIdcardno() + "%"));
            criteria.sortIfEmpty(Sort.desc("createdon"));
            Pager<Member> pager = memberService.findPage(criteria);
            resultMap.put("result", 1);
            resultMap.put("total", pager.getTotalRecords());
            resultMap.put("rows", pager.getList());
        } catch (Exception e) {
            resultMap.put("result", 0);
            resultMap.put("total", -1);
            resultMap.put("rows", null);
            logger.error(e.getMessage(), e);
        }
        return resultMap;
    }
    @RequestMapping(value = "/carinfo", method = RequestMethod.POST)
    @ResponseBody
    public  Object checkCarInfo(@RequestBody RequestDto<CheckCarDto> requestDto)
    {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        CheckCarDto dto = requestDto.getData();
        if(!Configs.chejd_isopen.equals("1")) {
            Map<String, String> datamaptest = new HashMap<>();
            datamaptest.put("hpzl", "02");
            datamaptest.put("clpp1", "法拉利");
            datamaptest.put("clxh", "FLL492L8");
            datamaptest.put("syxz", "0");
            datamaptest.put("syr", "黄青平");
            datamaptest.put("clsbdh", "LDNL78YH240090942");
            resultMap.put("code", "0");
            resultMap.put("data", datamaptest);
            return resultMap;
        }else {
            String username = memberExtService.getUserNameByMemId(dto.memid);
            CarInfoModel carinfo = CarCheckService.GetCheck(dto.carno, "02");
            if(carinfo!=null&&carinfo.code=="-1")
            {
                resultMap.put("code", "1");
                resultMap.put("msg", carinfo.msg);
                return resultMap;
            }

            if (carinfo != null && carinfo.syr.equals(username)) {
                Map<String, String> datamap = new HashMap<>();
                datamap.put("hpzl", carinfo.hpzl);
                datamap.put("clpp1", carinfo.clpp1);
                datamap.put("clxh", carinfo.clxh);
                datamap.put("syxz", carinfo.syxz.equals("A") ? "0" : "1");
                datamap.put("syr", carinfo.syr);
                datamap.put("clsbdh", carinfo.clsbdh);
                resultMap.put("code", "0");
                resultMap.put("data", datamap);
            } else if (carinfo == null) {
                resultMap.put("code", "1");
                resultMap.put("msg", "未找到车辆信息");
            } else {
                resultMap.put("code", "1");
                resultMap.put("msg", "车主和身份证名称不匹配");
            }
            return resultMap;
        }
    }
}