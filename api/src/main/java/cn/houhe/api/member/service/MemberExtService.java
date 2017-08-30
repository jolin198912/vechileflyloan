package cn.houhe.api.member.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.ServiceOperationException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.houhe.api.common.*;
import cn.houhe.api.common.enums.ApplyStateEnum;
import cn.houhe.api.member.entity.*;
import cn.houhe.api.member.mapper.MemberExtMapper;
import cn.houhe.api.member.mapper.MemberMapper;
import cn.houhe.api.member.mapper.RegisterRecordExtMapper;
import cn.houhe.api.member.mapper.RegisterRecordMapper;
import cn.houhe.api.member.web.MemberAction;
import cn.houhe.api.member.web.bo.LoanRatesDto;
import cn.houhe.api.member.web.bo.MemberDto;
import com.alibaba.druid.sql.visitor.functions.If;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务实现�- 表：member
 *
 * @since 2017-03-30 10:12:39
 */
@Service("memberExtService")
public class MemberExtService implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(MemberAction.class);

	@Autowired
	private MemberExtMapper memberExtMapper;
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private MemberService memberService;
	@Autowired
	private RegisterRecordMapper registerRecordMapper;
	@Autowired
	private RegisterRecordExtMapper registerRecordExtMapper;
	@Autowired
	private StringRedisTemplate redisTemplate;

	public MemberExt findByMobile(String mobile) throws ServiceException {
		try {
			return memberExtMapper.selectByMobile(mobile);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<PhoneContact> findPhoneContact(Integer memid) throws ServiceException {
		try {
			return memberExtMapper.selectPhoneContact(memid);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public MemLoanInfoExt findMemLoanInfoByMobile(String mobile) throws ServiceException {
		try {
			return memberExtMapper.selectMemLoanInfoByMobile(mobile);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public MemLoanInfoExt findMemLoanInfoByMobile(Integer memid) throws ServiceException {
		try {
			return memberExtMapper.selectMemLoanInfoByMobile(memid);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Member findByMemInfoMobile(String mobile) throws ServiceException {
		try {
			return memberExtMapper.selectMemInfoByMobile(mobile);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<LoanRatesExt> findLoanRates(Integer memid, Byte type) throws ServiceException {
		try {
			return memberExtMapper.selectLoanRates(memid, type);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<LoanRatesExt> findLoanRatesByNOLogin(Integer level_id, Byte type) throws ServiceException {
		try {
			return memberExtMapper.selectLoanRatesByNOLogin(level_id, type);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<MemberListExt> findPageExt(MemberListExt memberListExt) throws ServiceException {
		try {
			List<MemberListExt> list = memberExtMapper.findPageData(memberListExt);
			return list;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Integer getCount(MemberListExt memberListExt) throws ServiceException {
		try {
			return memberExtMapper.getCount(memberListExt);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * 查看会员详细信息
	 *
	 * @param memid
	 * @return
	 */
	public MemberDetailInfoExt getMemberDetailInfo(Integer memid) {
		MemberDetailInfoExt infoObject = memberExtMapper.getMemberDetailInfo(memid);
		if (infoObject == null) {
			throw new ServiceOperationException("未找到申请信息");
		}
		return infoObject;
	}

	/**
	 * 查看会员授信合同
	 *
	 * @param memid
	 * @return
	 */
	public List<LoanContractExt> getCreditContractFileList(Integer memid) {
		List<LoanContractExt> infoObject = memberExtMapper.getCreditContractFile(memid);
		if (infoObject == null) {
			throw new ServiceOperationException("未找到授信合同");
		}
		return infoObject;
	}

	/**
	 * 查看会员贷款记录
	 *
	 * @param memid
	 * @return
	 */
	public List<LoanRecordListExt> getLoanRecord(Integer memid) {
		List<LoanRecordListExt> infoObject = memberExtMapper.getLoanRecordList(memid);
		if (infoObject == null) {
			throw new ServiceOperationException("未找到贷款记录");
		}
		return infoObject;
	}

	/**
	 * 查看会员贷款合同
	 *
	 * @param loanrecordid
	 * @return
	 */
	public List<LoanContractExt> getLoanCreditContractFileList(Integer loanrecordid) {
		List<LoanContractExt> infoObject = memberExtMapper.getLoanCreditContractFile(loanrecordid);
		if (infoObject == null) {
			throw new ServiceOperationException("未找到贷款合同");
		}
		return infoObject;
	}

	/**
	 * 查看会员还款记录
	 *
	 * @param debitRecordListExt
	 * @return
	 */
	public List<DebitRecordListExt> findDebitRecordPageExt(DebitRecordListExt debitRecordListExt) throws ServiceException {
		try {
			List<DebitRecordListExt> list = memberExtMapper.findDebitRecordPageData(debitRecordListExt);
			return list;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Integer getDebitRecordCount(DebitRecordListExt debitRecordListExt) throws ServiceException {
		try {
			return memberExtMapper.getDebitRecordCount(debitRecordListExt);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * 查看逾期还款记录
	 *
	 * @param memid
	 * @return
	 */
	public List<OverdueRecordListExt> getOverdueRecord(Integer memid) {
		List<OverdueRecordListExt> infoObject = memberExtMapper.getOverdueRecordList(memid);
		if (infoObject == null) {
			throw new ServiceOperationException("未找到贷款记录");
		}
		return infoObject;
	}

	/**
	 * 查看会员催收记录
	 *
	 * @param remainderRecoadListExt
	 * @return
	 */
	public List<RemainderRecoadListExt> findRemainderRecoadPageExt(RemainderRecoadListExt remainderRecoadListExt) throws ServiceException {
		try {
			List<RemainderRecoadListExt> list = memberExtMapper.findRemainderRecoadPageData(remainderRecoadListExt);
			return list;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Integer getRemainderRecoadCount(RemainderRecoadListExt remainderRecoadListExt) throws ServiceException {
		try {
			return memberExtMapper.getRemainderRecoadCount(remainderRecoadListExt);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * 查看会员邀请记录
	 *
	 * @param memberListExt
	 * @return
	 */
	public List<MemberListExt> findInviteRecordPageExt(MemberListExt memberListExt) throws ServiceException {
		try {
			List<MemberListExt> list = memberExtMapper.findInviteRecordPageData(memberListExt);
			return list;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Integer getInviteRecordCount(MemberListExt memberListExt) throws ServiceException {
		try {
			return memberExtMapper.getInviteRecordCount(memberListExt);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * 验证用户是否已注册
	 * @param param
	 * @return
	 */
	public ResultDto isRegisterSer(RequestDto<MemberDto> param) {
		ResultDto result = new ResultDto();
		result.setMsg("验证用户是否已注册");
		try {
			String mobile = param.getData().getMobile();
			Member memberinfo = findByMemInfoMobile(mobile);
			if(memberinfo == null) { result.setCode("0"); } else { result.setCode("1"); }
		} catch (Exception e) {
			result.setCode("-1");
			result.setMsg("查询异常");
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 用户登录
	 * @param param
	 * @return
	 */
	public ResultDto userLoginSer(RequestDto<MemberDto> param) {
		ResultDto result = new ResultDto();
		result.setMsg("用户登录");
		try {
			String mobile = param.getData().getMobile();
			String loginpsw = param.getData().getLoginpsw();
			MemberExt memberinfo = findByMobile(mobile);
			if(memberinfo != null){
				List<PhoneContact> phonecontactlst = findPhoneContact(memberinfo.getMemid());
				if(mobile.equals(memberinfo.getMobileno()) && loginpsw.equals(memberinfo.getLoginpsw())) {
					if(memberinfo.getTradingpsw().length() > 0) { memberinfo.setTradingpswstatus((byte)1); } else { memberinfo.setTradingpswstatus((byte)0); }
					memberinfo.setAlias(memberinfo.getMemid() + "_" + Configs.pushEv);
					memberinfo.setPushTag( Configs.pushEv);
					memberinfo.setPhoneContacts(phonecontactlst);
					result.setData(memberinfo);
					result.setCode("0");
					result.setMsg("登录成功");
				}else{
					result.setCode("1");
					result.setMsg("密码错误，请核对后重新输入");
				}
			}else{
				result.setCode("2");
				result.setMsg("该用户不存在");
			}
		} catch (Exception e) {
			result.setCode("-1");
			result.setMsg("登录失败，请重试");
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 获取用户贷款相关信息
	 * @param param
	 * @return
	 */
	public ResultDto getMemLoanInfoSer(RequestDto<MemberDto> param) {
		ResultDto result = new ResultDto();
		result.setMsg("获取用户贷款相关信息");
		try {
			String mobile = param.getData().getMobile();
			MemLoanInfoExt memloaninfo = findMemLoanInfoByMobile(mobile);
			if(memloaninfo != null){
				result.setData(memloaninfo);
				result.setCode("0");
			}else{
				result.setCode("1");
				result.setMsg("未查询到该用户的贷款相关信息");
			}
		} catch (Exception e) {
			result.setCode("-1");
			result.setMsg("查询异常");
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 用户注册
	 * @param param
	 * @return
	 */
	public ResultDto userRegisterSer(RequestDto<MemberDto> param) {
		ResultDto result = new ResultDto();
		result.setMsg("用户注册");
		try {
			String mobile = param.getData().getMobile();
			String verificode = param.getData().getVerificode();
			String loginpsw = param.getData().getLoginpsw();
			String invitecode = param.getData().getInvitecode();
			Member memberinfo = findByMemInfoMobile(mobile);
			if(memberinfo != null){
				result.setCode("1");
				result.setMsg("注册用户已存在");
				return result;
			}
			String code = redisTemplate.opsForValue().get(mobile);
			if(code == null){ code = ""; }
			if (code.equals(verificode)){
				Member memdto = new Member();
				memdto.setMobileno(mobile);
				memdto.setLoginpsw(loginpsw);
				memdto.setInvitecode(invitecode);
				memberMapper.insertSelective(memdto);

				RegisterRecordExt record = registerRecordExtMapper.selectRecordByMobile(mobile);
				RegisterRecord registerRecord = new RegisterRecord();
				registerRecord.setRrId(record.getRrId());
				registerRecord.setIsSuccess((byte)1);
				registerRecordMapper.updateByPrimaryKeySelective(registerRecord);
				result.setCode("0");
				result.setMsg("注册成功");
			}
			else {
				result.setCode("2");
				result.setMsg("验证码错误，请重新输入");
			}
		} catch (Exception e) {
			result.setCode("-1");
			result.setMsg("注册失败，请重试");
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 修改登录密码
	 * @param param
	 * @return
	 */
	public ResultDto updateLoginPswSer(RequestDto<MemberDto> param) {
		ResultDto result = new ResultDto();
		result.setMsg("修改登录密码");
		try {
			String mobile = param.getData().getMobile();
			Byte updatepswtype = param.getData().getUpdatepswtype();
			String verificode = param.getData().getVerificode();
			String oldloginpsw = param.getData().getLoginpsw();
			String newloginpsw = param.getData().getNewloginpsw();
			Member memberinfo = findByMemInfoMobile(mobile);
			if(memberinfo == null){
				result.setCode("1");
				result.setMsg("该用户不存在");
				return result;
			}
			if(newloginpsw.equals(memberinfo.getTradingpsw()))
			{
				result.setCode("3");
				result.setMsg("新的登录密码不能与交易密码相同");
				return result;
			}
			Member memdto = new Member();
			memdto.setMemid(memberinfo.getMemid());
			memdto.setLoginpsw(newloginpsw);
			switch (updatepswtype){
				case 0:
					//发送短信验证码
					//验证输入的验证码是否正确
					String code = redisTemplate.opsForValue().get(mobile);
					if (code.equals(verificode)) {
						memberService.updateSelective(memdto);
						result.setCode("0");
						result.setMsg("登录密码找回成功");
					}
					else{
						result.setCode("4");
						result.setMsg("验证码错误，请重新输入");
					}
					break;
				case 1:
					if(oldloginpsw.equals(memberinfo.getLoginpsw())){
						memberService.updateSelective(memdto);
						result.setCode("0");
						result.setMsg("登录密码修改成功");
					}
					else{
						result.setCode("2");
						result.setMsg("原登录密码输入错误");
					}
					break;
			}
		} catch (Exception e) {
			result.setCode("-1");
			result.setMsg("登录密码修改失败，请重试");
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 修改交易密码
	 * @param param
	 * @return
	 */
	public ResultDto updateTradingPswSer(RequestDto<MemberDto> param) {
		ResultDto result = new ResultDto();
		result.setMsg("修改交易密码");
		try {
			String mobile = param.getData().getMobile();
			String oldtradingpsw = param.getData().getTradingpsw();
			String newtradingpsw = param.getData().getNewtradingpsw();
			Member memberinfo = findByMemInfoMobile(mobile);
			if(memberinfo == null){
				result.setCode("1");
				result.setMsg("该用户不存在");
				return result;
			}
			if(newtradingpsw.equals(memberinfo.getLoginpsw()))
			{
				result.setCode("3");
				result.setMsg("新的交易密码不能与登录密码相同");
				return result;
			}
			if(oldtradingpsw.equals(memberinfo.getTradingpsw())){
				Member memdto = new Member();
				memdto.setMemid(memberinfo.getMemid());
				memdto.setTradingpsw(newtradingpsw);
				memberService.updateSelective(memdto);
				result.setCode("0");
				result.setMsg("交易密码修改成功");
			}
			else{
				result.setCode("2");
				result.setMsg("原交易密码输入错误");
			}
		}catch (Exception e){
			result.setCode("-1");
			result.setMsg("交易密码修改失败，请重试");
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 设置交易密码
	 * @param param
	 * @return
	 */
	public ResultDto setTradingPswSer(RequestDto<MemberDto> param) {
		ResultDto result = new ResultDto();
		result.setMsg("设置交易密码");
		try {
			String mobile = param.getData().getMobile();
			String loginpsw = param.getData().getLoginpsw();
			String tradingpsw = param.getData().getTradingpsw();
			Member memberinfo = findByMemInfoMobile(mobile);
			if(memberinfo == null){
				result.setCode("1");
				result.setMsg("该用户不存在");
				return result;
			}
			if(tradingpsw.equals(memberinfo.getLoginpsw()))
			{
				result.setCode("3");
				result.setMsg("设置的交易密码不能与登录密码相同");
				return result;
			}
			if(mobile.equals(memberinfo.getMobileno()) && loginpsw.equals(memberinfo.getLoginpsw())){
				Member memdto = new Member();
				memdto.setMemid(memberinfo.getMemid());
				memdto.setTradingpsw(tradingpsw);
				memberService.updateSelective(memdto);
				result.setCode("0");
				result.setMsg("交易密码设置成功");
			}
			else{
				result.setCode("2");
				result.setMsg("登录密码输入错误");
			}
		}catch (Exception e){
			result.setCode("-1");
			result.setMsg("交易密码设置失败，请重试");
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 忘记交易密码
	 * @param param
	 * @return
	 */
	public ResultDto forgetTradingPswSer(RequestDto<MemberDto> param) {
		ResultDto result = new ResultDto();
		result.setMsg("忘记交易密码");
		try {
			Byte nextstep = param.getData().getNextstep();
			String mobile = param.getData().getMobile();
			Member memberinfo = findByMemInfoMobile(mobile);
			if(memberinfo == null){
				result.setCode("1");
				result.setMsg("该用户不存在");
				return result;
			}
			switch (nextstep){
				case 0:
					String name = param.getData().getRealname();
					String idcard = param.getData().getIdcardno();
					String loginpsw = param.getData().getLoginpsw();
					if(!name.equals(memberinfo.getRealname()) || !idcard.equals(memberinfo.getIdcardno()) || !loginpsw.equals(memberinfo.getLoginpsw()))
					{
						result.setCode("2");
						result.setMsg("信息有错误，请核对后再输入");
						return result;
					}
					break;
				case 1:
					String newtradingpsw = param.getData().getNewtradingpsw();
					if(newtradingpsw.equals(memberinfo.getLoginpsw()))
					{
						result.setCode("3");
						result.setMsg("新的交易密码不能与登录密码相同");
						return result;
					}
					Member memdto = new Member();
					memdto.setMemid(memberinfo.getMemid());
					memdto.setTradingpsw(newtradingpsw);
					memberService.updateSelective(memdto);
					result.setMsg("交易密码修改成功");
					break;
			}
			result.setCode("0");
		}catch (Exception e){
			result.setCode("-1");
			result.setMsg("交易密码找回失败，请重试");
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 注册发送短信验证码
	 * @param param
	 * @return
	 */
	public ResultDto sendVerificodeSer(RequestDto<MemberDto> param) {
		ResultDto result = new ResultDto();
		result.setMsg("注册发送短信验证码");
		try {
			String mobile = param.getData().getMobile();
			//发送手机短信验证码
			String code = BasePubMethodService.sendMobileVerificode(mobile);
			RegisterRecordExt regrecord = registerRecordExtMapper.selectRecordByMobile(mobile);
			int count = 0;
			if (regrecord != null) {
				count = regrecord.getIdCodeCount();
			}
			count++;
			redisTemplate.opsForValue().set(mobile,code);
			if(regrecord == null){
				RegisterRecordExt registerRecordExt = new RegisterRecordExt();
				registerRecordExt.setMobile(mobile);
				registerRecordExt.setIdCode(code);
				registerRecordExt.setIdCodeCount((short)count);
				registerRecordExt.setIsSuccess(Byte.parseByte("0"));
				registerRecordExtMapper.insert(registerRecordExt);
			} else {
				RegisterRecord registerRecord = new RegisterRecord();
				registerRecord.setRrId(regrecord.getRrId());
				registerRecord.setMobile(mobile);
				registerRecord.setIdCode(code);
				registerRecord.setIdCodeCount((short)count);
				registerRecord.setIsSuccess(Byte.parseByte("0"));
				registerRecordMapper.updateByPrimaryKeySelective(registerRecord);
			}
			result.setCode("0");
			result.setMsg("注册短信验证码发送成功");
		}catch (Exception e){
			result.setCode("-1");
			result.setMsg("注册短信验证码发送失败，请重试");
			logger.error(e.getMessage(), e);
		}
		return result;
	}

    /**
     * 修改登录密码时发送短信验证码
     * @param param
     * @return
     */
	public ResultDto updateLoginPwdSendCodeSer(RequestDto<MemberDto> param) {
		ResultDto result = new ResultDto();
		result.setMsg("修改登录密码发送短信验证码");
		try {
			String mobile = param.getData().getMobile();
			//发送手机短信验证码
			String code = BasePubMethodService.sendMobileVerificode(mobile);
			redisTemplate.opsForValue().set(mobile,code);
			result.setCode("0");
			result.setMsg("修改登录密码短信验证码发送成功");
		}catch (Exception e){
			result.setCode("-1");
			result.setMsg("修改登录密码短信验证码发送失败，请重试");
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 查询贷款利率和贷款方案
	 * @param param
	 * @return
	 */
	public ResultDto getLoanRatesSer(RequestDto<LoanRatesDto> param) {
		ResultDto result = new ResultDto();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		result.setMsg("查询贷款利率和贷款方案");
		try {
			Integer memberid = param.getData().getMemberId();
			Byte type = 0;
			MemLoanInfoExt memloaninfo = findMemLoanInfoByMobile(memberid);
			if(memberid > 0) {
				List<LoanRatesExt> loanateslist0 = findLoanRates(memberid, type);
				List<LoanRatesExt> loanateslist1 = findLoanRates(memberid, type = 1);
				resultMap.put("daytype", loanateslist0);
				resultMap.put("yeartype", loanateslist1);
				result.setData(resultMap);
			}
			else if(memberid <= 0 || (memloaninfo.getApplyState() == ApplyStateEnum.TRIAL_NO.getIndex() || memloaninfo.getApplyState() == ApplyStateEnum.FINAL_NO.getIndex() || memloaninfo.getApplyState() == ApplyStateEnum.AutoApprovalNo.getIndex())){
				List<LoanRatesExt> loanateslist0 = findLoanRatesByNOLogin(1, type);
				List<LoanRatesExt> loanateslist1 = findLoanRatesByNOLogin(1, type = 1);
				resultMap.put("daytype", loanateslist0);
				resultMap.put("yeartype", loanateslist1);
				result.setData(resultMap);
			}
			result.setCode("0");
		}catch (Exception e){
			result.setCode("-1");
			result.setMsg("查询异常");
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 验证交易密码
	 * @param param
	 * @return
	 */
	public ResultDto validationTradingPswSer(RequestDto<MemberDto> param) {
		ResultDto result = new ResultDto();
		result.setMsg("验证交易密码");
		try {
			String mobile = param.getData().getMobile();
			String tradingpsw = param.getData().getTradingpsw();
			Member memberinfo = findByMemInfoMobile(mobile);
			if(memberinfo == null){
				result.setCode("1");
				result.setMsg("该用户不存在");
				return result;
			}
			if(tradingpsw.equals(memberinfo.getTradingpsw())){
				result.setCode("0");
				result.setMsg("交易密码验证通过");
			}
			else{
				result.setCode("2");
				result.setMsg("交易密码输入错误");
			}
		}catch (Exception e){
			result.setCode("-1");
			result.setMsg("交易密码验证异常");
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	public MemberPressDetailExt getMemberPressDetail(Integer memid) throws ServiceException {
		try {
			return memberExtMapper.getMemberPressDetail(memid);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
	public  String getUserNameByMemId(@Param("memid") Integer memid)
	{
		try {
			return  memberExtMapper.getUserNameByMemId(memid);
		}catch (Exception e)
		{
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 *统计会员人数
	 */

}