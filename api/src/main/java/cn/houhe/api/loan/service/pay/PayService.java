package cn.houhe.api.loan.service.pay;

import cn.houhe.api.common.Configs;
import cn.houhe.api.common.job.CronUtil;
import cn.houhe.api.common.job.QuartzManager;
import cn.houhe.api.common.job.ScheduleJob;
import cn.houhe.api.loan.entity.*;
import cn.houhe.api.loan.mapper.PayRequestRecordMapper;
import cn.houhe.api.loan.service.*;
import cn.houhe.api.loan.service.pay.bean.PayBean;
import cn.houhe.api.loan.service.pay.encrypt.RSA;
import cn.houhe.api.loan.service.pay.encrypt.TripleDes;
import cn.houhe.api.loan.service.pay.util.Base64;
import cn.houhe.api.loan.service.pay.util.SslConnection;
import cn.houhe.api.loan.service.pay.util.Strings;
import cn.houhe.api.loan.service.pay.util.Util;
import cn.houhe.api.loan.service.pay.versionSMS.MsgBean;
import cn.houhe.api.loan.service.pay.versionSMS.MsgBody;
import cn.houhe.api.loan.web.bo.MsgBodyDto;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Service("payservice")
public class PayService {

	/*
	* 测试环境中，demo的user_name为:13423124211
     商户号sysMerchantNo ：010020000038
      商户密钥merchant_key ：18918A4E746348B5;
	* */

	private static Logger logger = Logger.getLogger(PayService.class.getName());

	private static String dna_pub_key = Configs.yl_dna_pub_key;
	private static String mer_pfx_key =  Configs.yl_mer_pfx_key.replace("/", System.getProperty("file.separator")).replace("\\", System.getProperty("file.separator"));;;//商户私钥
	private static String mer_pfx_pass = Configs.yl_mer_pfx_pass;//商户私钥密码
	private static String user_name= Configs.yl_user_name;//用户名
	private static String user_name_v= Configs.yl_user_name_v;//用户名(签权用户名)
	private static String merchant_no= Configs.yl_merchant_no;//商户号
	private  static  String merchant_no1=Configs.yl_merchant_no;//认证商户号
	private static String merchant_key= Configs.yl_merchant_key;//商户密钥
	private static String version= Configs.yl_version;
	private static String url = Configs.yl_url;//测试环境下单地址
//	private static String url = "https://agent.payeco.com/service";//生产环境下单地址

	@Resource
	private PayRequestRecordMapper payRequestRecordMapper;
	@Resource
	private LoanRecordExtService loanRecordExtService;
	@Resource
	private LoanRecordService loanRecordService;
	@Resource
	private ScheduleJobService scheduleJobService;
	@Resource
	private LoanPayService loanPayService;
	@Resource
    private DebitRcdService debitRcdService;
	@Resource
    private RepaymentsPlanService repaymentsPlanService;

	//认证
	public PayBean verify(MsgBean msgBean, Integer id) throws Exception {
		PayBean result=new PayBean();
		result.setCode("-1");
		result.setMsg("请求认证");
		msgBean.setVERSION(version);
		msgBean.setMSG_TYPE("300001");
		msgBean.setUSER_NAME(user_name_v);//系统后台登录名
		String res = sendAndRead(signANDencrypt(msgBean));
		MsgBean resBean = decryptANDverify(res);
		PayRequestRecord payRequestRecord = new PayRequestRecord();
		payRequestRecord.setBusinesCode("300001");
		payRequestRecord.setObjectId(id+"");
		payRequestRecord.setObjectType((byte)0);
		payRequestRecord.setAmount(1);
		if("0000".equals(resBean.getTRANS_STATE())) {//处理成功
			payRequestRecord.setStatus((byte) 1);
			if ("0000".equals(resBean.getBODYS().get(0).getPAY_STATE())) {
				result.setCode("0");
				result.setMsg(resBean.getBODYS().get(0).getREMARK());
			} else if ("00A4".equals(resBean.getTRANS_STATE()))//处理中
			{
				if ("00A4".equals(resBean.getBODYS().get(0).getPAY_STATE())) {
					result.setCode("2");
					result.setMsg(resBean.getBODYS().get(0).getREMARK());
				}
				payRequestRecord.setStatus((byte) 2);

			} else {                                   //处理失败
				payRequestRecord.setStatus((byte) 3);
				if ((!"0000".equals(resBean.getBODYS().get(0).getPAY_STATE())) && (!"00A4".equals(resBean.getBODYS().get(0).getPAY_STATE()))) {
					result.setCode("3");
					result.setMsg(resBean.getBODYS().get(0).getREMARK());
				}
			}
		}
		payRequestRecord.setRequestParam(msgBean.toXml());
		payRequestRecord.setFlownumber(msgBean.getBATCH_NO());
		payRequestRecord.setResponseParam(resBean.toXml());
		payRequestRecord.setResultCode(resBean.getTRANS_STATE());
		payRequestRecord.setResultMsg(resBean.getBODYS().get(0).getREMARK());
		payRequestRecordMapper.insertSelective(payRequestRecord);
		logger.info(resBean.toXml());
		return  result;
	}

	//查询银行卡所属银行
	public PayBean queryAccountInfo(MsgBean msgBean) throws Exception {
		PayBean result=new PayBean();
		result.setCode("0");
		result.setMsg("查询所属银行");
		msgBean.setVERSION(version);
		msgBean.setMSG_TYPE("400001");
		msgBean.setUSER_NAME(user_name);//系统后台登录名
		String res = sendAndRead(signANDencrypt(msgBean));
		MsgBean resBean = decryptANDverify(res);

		PayRequestRecord payRequestRecord = new PayRequestRecord();
		payRequestRecord.setBusinesCode("400001");
		payRequestRecord.setObjectId("0");
		payRequestRecord.setObjectType((byte)0);
		payRequestRecord.setAmount(1);
		payRequestRecord.setRequestDate(new Date());
		payRequestRecord.setResponseDate(new Date());
		if("0000".equals(resBean.getTRANS_STATE())) {//处理成功
			payRequestRecord.setStatus((byte)1);
		}else if("0001".equals(resBean.getTRANS_STATE()))//处理中
		{
			payRequestRecord.setStatus((byte)2);
		}else{                                   //处理失败
			payRequestRecord.setStatus((byte)3);
		}
		payRequestRecord.setRequestParam(msgBean.toXml());
		payRequestRecord.setFlownumber(msgBean.getBATCH_NO());
		payRequestRecord.setResponseParam(resBean.toXml());
		payRequestRecord.setResultCode(resBean.getTRANS_STATE());
		payRequestRecord.setResultMsg(resBean.getBODYS().get(0).getREMARK());
		payRequestRecordMapper.insert(payRequestRecord);

		if(firstRcdStatus(resBean))
		{
			String bankinfo = resBean.getBODYS().get(0).getRESERVE();
			if (bankinfo != null)
			{
				String[] tmps=bankinfo.split("\\|");
				if(tmps.length>1)
				{
					result.setData(new HashMap<String,String>());
					result.getData().put("bankname",tmps[0]);
					result.getData().put("cardtype",tmps[1]);
					result.setCode("0");
					result.setMsg("查询银行卡信息成功");
					return result;
				}
			}

		}
		result.setCode("-1");
		result.setMsg(resBean.getBODYS().get(0).getREMARK());
		logger.info(resBean.toXml());


		return result;
	}

	//发送短信验证码
	public PayBean sendMessage(MsgBean msgBean) throws Exception{
		PayBean result=new PayBean();
		msgBean.setVERSION(version);
		msgBean.setMSG_TYPE("500001");//发送短信
		msgBean.setBATCH_NO(new String(Base64.decode(Util.generateKey(99999,14))));//每笔订单不可重复，建议：公司简称缩写+yymmdd+流水号
		msgBean.setUSER_NAME(user_name_v);//系统后台登录名
		String res = sendAndRead(signANDencrypt(msgBean));
		MsgBean resBean = decryptANDverify(res);
		PayRequestRecord payRequestRecord = new PayRequestRecord();
		payRequestRecord.setBusinesCode("500001");
		payRequestRecord.setObjectId("0");
		payRequestRecord.setObjectType((byte)0);
		payRequestRecord.setAmount(1);
		payRequestRecord.setRequestDate(new Date());
		payRequestRecord.setResponseDate(new Date());
		if("0000".equals(resBean.getTRANS_STATE())) {//处理成功
			payRequestRecord.setStatus((byte)1);
		}else if("0001".equals(resBean.getTRANS_STATE()))//处理中
		{
			payRequestRecord.setStatus((byte)2);
		}else{                                   //处理失败
			payRequestRecord.setStatus((byte)3);
		}
		payRequestRecord.setRequestParam(msgBean.toXml());
		payRequestRecord.setFlownumber(msgBean.getBATCH_NO());
		payRequestRecord.setResponseParam(resBean.toXml());
		payRequestRecord.setResultCode(resBean.getTRANS_STATE());
		payRequestRecord.setResultMsg(resBean.getBODYS().get(0).getREMARK());
		payRequestRecordMapper.insert(payRequestRecord);
		if(firstRcdStatus(resBean))
		{
			result.setData(new HashMap<String, String>());
			result.setCode("0");
			result.getData().put("batchno",msgBean.getBATCH_NO());
			return result;
		}
		result.setCode("-1");
		result.setMsg(resBean.getBODYS().get(0).getREMARK());
		logger.info(resBean.toXml());



		return result;
	}

	//认证查询
	public PayBean verifyQuery(String accNo, String accName) throws Exception {
		PayBean result=new PayBean();
		int isband=0;
		MsgBean reqBean = new MsgBean();
		MsgBody msgBody = new MsgBody();
		msgBody.setACC_NO(accNo);
		msgBody.setACC_NAME(accName);
		msgBody.setID_NO("");
		msgBody.setID_TYPE("0");
		msgBody.setRESERVE("Y");
		reqBean.getBODYS().add(msgBody);

		reqBean.setVERSION(version);
		reqBean.setMSG_TYPE("300002");
		String flowNumber = new String(Base64.decode(Util.generateKey(99999,14)));
		reqBean.setBATCH_NO(flowNumber);
		reqBean.setUSER_NAME(user_name_v);//系统后台登录名
		String res = sendAndRead(signANDencrypt(reqBean));
		MsgBean resBean = decryptANDverify(res);
		if("0000".equals(resBean.getTRANS_STATE())) {
			String reserve=resBean.getBODYS().get(0).getRESERVE();
			if(reserve!=null)
			{
				String[] tmps=reserve.split("\\|");
				if(tmps.length>0)
				{
					String checkcode=tmps[0];
					if("0000".equals(checkcode))
					{
						isband=1;
					}else if("T437".equals(checkcode))
					{
						isband=0;
					}
				}
			}
		}
		result.setData(new HashMap<String, String>());
		result.getData().put("isband",isband+"");

		PayRequestRecord payRequestRecord = new PayRequestRecord();
		payRequestRecord.setBusinesCode("300002");
		payRequestRecord.setObjectId("0");
		payRequestRecord.setObjectType((byte)0);
		payRequestRecord.setAmount(1);
		payRequestRecord.setRequestDate(new Date());
		payRequestRecord.setResponseDate(new Date());
		if("0000".equals(resBean.getTRANS_STATE())) {//处理成功
			payRequestRecord.setStatus((byte)1);
		}else if("0001".equals(resBean.getTRANS_STATE()))//处理中
		{
			payRequestRecord.setStatus((byte)2);
		}else{                                   //处理失败
			payRequestRecord.setStatus((byte)3);
		}
		payRequestRecord.setRequestParam(reqBean.toXml());
		payRequestRecord.setFlownumber(reqBean.getBATCH_NO());
		payRequestRecord.setResponseParam(resBean.toXml());
		payRequestRecord.setResultCode(resBean.getTRANS_STATE());
		payRequestRecord.setResultMsg(resBean.getBODYS().get(0).getRESERVE());
		payRequestRecordMapper.insert(payRequestRecord);
		logger.info(resBean.toXml());
		return result;
	}

	//代收
	public PayBean gather(MsgBodyDto msgBodyDto) throws Exception {
		PayBean result = new PayBean();
		result.setMsg("代收");
		String batchNo = new String(Base64.decode(Util.generateKey(99999,14)));
		MsgBody msgBody = new MsgBody();
        msgBody.setSN(msgBodyDto.getObjectId());
		msgBody.setACC_NO(msgBodyDto.getAccNo());
		msgBody.setACC_NAME(msgBodyDto.getAccName());
		msgBody.setAMOUNT(msgBodyDto.getAmount()+"");
		msgBody.setBANK_NAME(msgBodyDto.getBankName());
		msgBody.setRETURN_URL(msgBodyDto.getReturnUrl());
		msgBody.setMOBILE_NO(msgBodyDto.getMobileNo());
		msgBody.setID_NO(msgBodyDto.getCardNo());

		MsgBean msgBean = new MsgBean();
		msgBean.getBODYS().add(msgBody);
		msgBean.setBATCH_NO(batchNo);
		msgBean.setVERSION(version);
		msgBean.setMSG_TYPE("200001");
		msgBean.setUSER_NAME(user_name);//系统后台登录名
		String res = sendAndRead(signANDencrypt(msgBean));
		MsgBean resBean = decryptANDverify(res);

		PayRequestRecord payRequestRecord = new PayRequestRecord();
		payRequestRecord.setBusinesCode("200001");
		payRequestRecord.setObjectId(msgBodyDto.getObjectId());
		payRequestRecord.setObjectType((byte)2);
		payRequestRecord.setAmount(1);
		payRequestRecord.setRequestDate(new Date());
		payRequestRecord.setResponseDate(new Date());
		if("0000".equals(resBean.getTRANS_STATE())) {//处理成功
			payRequestRecord.setStatus((byte)1);
		}else if("0001".equals(resBean.getTRANS_STATE()))//处理中
		{
			payRequestRecord.setStatus((byte)2);
		}else{                                   //处理失败
			payRequestRecord.setStatus((byte)3);
		}
		payRequestRecord.setRequestParam(msgBean.toXml());
		payRequestRecord.setFlownumber(msgBean.getBATCH_NO());
		payRequestRecord.setResponseParam(resBean.toXml());
		payRequestRecord.setResultCode(resBean.getTRANS_STATE());
		payRequestRecord.setResultMsg(resBean.getBODYS().get(0).getREMARK());
		payRequestRecordMapper.insert(payRequestRecord);
		logger.info(resBean.toXml());
		result.setBatchNo(batchNo);
		if("0000".equals(resBean.getBODYS().get(0).getPAY_STATE())) {
			result.setCode("1");
			result.setMsg("交易成功");
			logger.info("请求成功");
		}else if ("00A4".equals(resBean.getBODYS().get(0).getPAY_STATE())) {
			result.setCode("2");
			result.setMsg("交易正在处理中");
			logger.info("请求成功");
		} else {
			result.setCode("3");
			result.setMsg("交易失败");
			logger.info("请求失败");
		}
		return result;
	}

	//代收查询
	public PayBean gatherQuery(String flowNo, String gatherno) throws Exception {
		PayBean result=new PayBean();
		MsgBean reqBean = new MsgBean();
		reqBean.setVERSION(version);
		reqBean.setMSG_TYPE("200002");
		//String flowNumber = new String(Base64.decode(Util.generateKey(99999,14)));
		reqBean.setBATCH_NO(flowNo); //同代收交易请求的批次号
		reqBean.setUSER_NAME(user_name);//系统后台登录名
		String res = sendAndRead(signANDencrypt(reqBean));
		MsgBean resBean = decryptANDverify(res);
		PayRequestRecord payRequestRecord = new PayRequestRecord();
		payRequestRecord.setBusinesCode("200002");
		payRequestRecord.setObjectId(gatherno);
		payRequestRecord.setObjectType((byte)2);
		payRequestRecord.setAmount(1);
		payRequestRecord.setRequestDate(new Date());
		payRequestRecord.setResponseDate(new Date());
		if("0000".equals(resBean.getTRANS_STATE())) {//处理成功
			payRequestRecord.setStatus((byte)1);
		}else if("0001".equals(resBean.getTRANS_STATE()))//处理中
		{
			payRequestRecord.setStatus((byte)2);
		}else{                                   //处理失败
			payRequestRecord.setStatus((byte)3);
		}
		payRequestRecord.setRequestParam(reqBean.toXml());
		payRequestRecord.setFlownumber(reqBean.getBATCH_NO());
		payRequestRecord.setResponseParam(resBean.toXml());
		payRequestRecord.setResultCode(resBean.getTRANS_STATE());
		payRequestRecord.setResultMsg(resBean.getBODYS().get(0).getREMARK());
		payRequestRecordMapper.insert(payRequestRecord);
		if("0000".equals(resBean.getTRANS_STATE())) {
			if("0000".equals(resBean.getBODYS().get(0).getPAY_STATE()))
			{
				result.setCode("1");
			}else if("00A4".equals(resBean.getBODYS().get(0).getPAY_STATE()))
			{
				result.setCode("2");
			}else
			{
				result.setCode("3");
			}
			result.setMsg(resBean.getBODYS().get(0).getREMARK());
			logger.info("请求成功");
		}
		logger.info(resBean.toXml());
		return result;
	}

	//代付
	public PayBean pay(MsgBodyDto msgBodyDto) throws Exception {
		PayBean result = new PayBean();
		String batchNo = new String(Base64.decode(Util.generateKey(99999,14)));
		MsgBody msgBody = new MsgBody();
		msgBody.setSN(msgBodyDto.getObjectId());
		msgBody.setACC_NO(msgBodyDto.getAccNo());
		msgBody.setACC_NAME(msgBodyDto.getAccName());
		msgBody.setAMOUNT(msgBodyDto.getAmount()+"");
		msgBody.setBANK_NAME(msgBodyDto.getBankName());

		MsgBean msgBean = new MsgBean();
		msgBean.getBODYS().add(msgBody);
		msgBean.setBATCH_NO(batchNo);
		msgBean.setVERSION(version);
		msgBean.setMSG_TYPE("100001");
		msgBean.setUSER_NAME(user_name);//系统后台登录名
		String res = sendAndRead(signANDencrypt(msgBean));
		MsgBean resBean = decryptANDverify(res);
		PayRequestRecord payRequestRecord = new PayRequestRecord();
		payRequestRecord.setBusinesCode("100001");
		payRequestRecord.setObjectId(msgBodyDto.getObjectId());
		payRequestRecord.setObjectType((byte)1);
		payRequestRecord.setAmount(1);
		if("0000".equals(resBean.getTRANS_STATE())) {//处理成功
			payRequestRecord.setStatus((byte)1);
		}else if("0001".equals(resBean.getTRANS_STATE()))//处理中
		{
			payRequestRecord.setStatus((byte)2);
		}else{                                   //处理失败
			payRequestRecord.setStatus((byte)3);
		}
		payRequestRecord.setRequestParam(msgBean.toXml());
		payRequestRecord.setRequestDate(new Date());
		payRequestRecord.setResponseDate(new Date());
		payRequestRecord.setFlownumber(msgBean.getBATCH_NO());
		payRequestRecord.setResponseParam(resBean.toXml());
		payRequestRecord.setResultCode(resBean.getTRANS_STATE());
		payRequestRecord.setResultMsg(resBean.getBODYS().get(0).getREMARK());
		payRequestRecordMapper.insert(payRequestRecord);
		logger.info(resBean.toXml());

		result.setBatchNo(batchNo);
		if("0000".equals(resBean.getBODYS().get(0).getPAY_STATE())) {
			result.setCode("1");
			result.setMsg(resBean.getBODYS().get(0).getREMARK());
			logger.info("请求成功");
		}else if ("00A4".equals(resBean.getBODYS().get(0).getPAY_STATE())) {
			result.setCode("2");
			result.setMsg(resBean.getBODYS().get(0).getREMARK());
			logger.info("请求成功");
		} else {
			result.setCode("3");
			result.setMsg(resBean.getBODYS().get(0).getREMARK());
			logger.info("请求失败");
		}
		return result;
	}

	//代付查询
	public PayBean payQuery(String flowNO, String payno) throws Exception {
		PayBean result=new PayBean();
		MsgBean reqBean = new MsgBean();
		reqBean.setVERSION(version);
		reqBean.setMSG_TYPE("100002");
		reqBean.setBATCH_NO(flowNO); //同代收交易请求的批次号
		reqBean.setUSER_NAME(user_name);//系统后台登录名
		String res = sendAndRead(signANDencrypt(reqBean));
		MsgBean resBean = decryptANDverify(res);

        PayRequestRecord payRequestRecord = new PayRequestRecord();
        payRequestRecord.setBusinesCode("100002");
        payRequestRecord.setObjectId(payno);
        payRequestRecord.setObjectType((byte)1);
        payRequestRecord.setAmount(1);
        if("0000".equals(resBean.getTRANS_STATE())) {//处理成功
            payRequestRecord.setStatus((byte)1);
        }else if("0001".equals(resBean.getTRANS_STATE()))//处理中
        {
            payRequestRecord.setStatus((byte)2);
        }else{                                   //处理失败
            payRequestRecord.setStatus((byte)3);
        }
        payRequestRecord.setRequestParam(reqBean.toXml());
        payRequestRecord.setRequestDate(new Date());
        payRequestRecord.setResponseDate(new Date());
        payRequestRecord.setFlownumber(reqBean.getBATCH_NO());
        payRequestRecord.setResponseParam(resBean.toXml());
        payRequestRecord.setResultCode(resBean.getTRANS_STATE());
        payRequestRecord.setResultMsg(resBean.getBODYS().get(0).getREMARK());
        payRequestRecordMapper.insert(payRequestRecord);

		if("0000".equals(resBean.getTRANS_STATE())) {
			if("0000".equals(resBean.getBODYS().get(0).getPAY_STATE()))
			{
				result.setCode("1");
			}else if("00A4".equals(resBean.getBODYS().get(0).getPAY_STATE()))
			{
				result.setCode("2");
			}else
			{
				result.setCode("3");
			}
			result.setMsg(resBean.getBODYS().get(0).getREMARK());
			logger.info("请求成功");
		}
		logger.info(resBean.toXml());
		return result;
	}

	//解绑
	public PayBean deBand(String accno) throws Exception {
		PayBean result=new PayBean();
		MsgBean reqBean = new MsgBean();
		reqBean.setVERSION(version);
		reqBean.setMSG_TYPE("300004");
		String batchNo = new String(Base64.decode(Util.generateKey(99999,14)));
		reqBean.setBATCH_NO(batchNo); //同代收交易请求的批次号
		reqBean.setUSER_NAME(user_name_v);//系统后台登录名
		MsgBody msgBody = new MsgBody();
		msgBody.setACC_NO(accno);
		reqBean.getBODYS().add(msgBody);
		String res = sendAndRead(signANDencrypt(reqBean));
		MsgBean resBean = decryptANDverify(res);

		PayRequestRecord payRequestRecord = new PayRequestRecord();
		payRequestRecord.setBusinesCode("300004");
		payRequestRecord.setObjectId("0");
		payRequestRecord.setObjectType((byte)1);
		payRequestRecord.setAmount(1);
		if("0000".equals(resBean.getTRANS_STATE())) {//处理成功
			payRequestRecord.setStatus((byte)1);
		}else if("0001".equals(resBean.getTRANS_STATE()))//处理中
		{
			payRequestRecord.setStatus((byte)2);
		}else{                                   //处理失败
			payRequestRecord.setStatus((byte)3);
		}
		payRequestRecord.setRequestParam(reqBean.toXml());
		payRequestRecord.setRequestDate(new Date());
		payRequestRecord.setResponseDate(new Date());
		payRequestRecord.setFlownumber(reqBean.getBATCH_NO());
		payRequestRecord.setResponseParam(resBean.toXml());
		payRequestRecord.setResultCode(resBean.getTRANS_STATE());
		payRequestRecord.setResultMsg(resBean.getBODYS().get(0).getREMARK());
		payRequestRecordMapper.insert(payRequestRecord);

		if("0000".equals(resBean.getTRANS_STATE())) {
			if("0000".equals(resBean.getBODYS().get(0).getPAY_STATE()))
			{
				result.setCode("1");
			}else if("00A4".equals(resBean.getBODYS().get(0).getPAY_STATE()))
			{
				result.setCode("2");
			}else
			{
				result.setCode("3");
			}
			result.setMsg(resBean.getBODYS().get(0).getREMARK());
			logger.info("请求成功");
		}
		logger.info(resBean.toXml());
		return result;
	}

	private MsgBean decryptANDverify(String res) {
		String msg_sign_enc = res.split("\\|")[0];
		String key_3des_enc = res.split("\\|")[1];

		//解密密钥
		String key_3des = RSA.decrypt(key_3des_enc,mer_pfx_key,mer_pfx_pass);

		//解密报文
		String msg_sign = TripleDes.decrypt(key_3des, msg_sign_enc);
		MsgBean res_bean = new MsgBean();
		res_bean.toBean(msg_sign);
		logger.info("res:" + res_bean.toXml());

		//验签
		String dna_sign_msg = res_bean.getMSG_SIGN();
		res_bean.setMSG_SIGN("");
		String verify = Strings.isNullOrEmpty(res_bean.getVERSION())? res_bean.toXml(): res_bean.toSign() ;
		logger.info("verify:" + verify);
		if(!RSA.verify(dna_sign_msg, dna_pub_key, verify)) {
			logger.error("验签失败");
			res_bean.setTRANS_STATE("00A0");
		}
		return res_bean;
	}

	private String signANDencrypt(MsgBean req_bean) {

		//商户签名

		System.out.println("before sign xml =="+ req_bean.toSign());
		System.out.println("msg sign = "+ RSA.sign(req_bean.toSign(),mer_pfx_key,mer_pfx_pass));
		req_bean.setMSG_SIGN(RSA.sign(req_bean.toSign(),mer_pfx_key,mer_pfx_pass));
		logger.info("req:" + req_bean.toXml());

		//加密报文
		String key = Util.generateKey(9999,24);
		logger.info("key:" + key);
		String req_body_enc = TripleDes.encrypt(key, req_bean.toXml());
		logger.info("req_body_enc:" + req_body_enc);
		//加密密钥
		String req_key_enc = RSA.encrypt(key, dna_pub_key);
		logger.info("req_key_enc:" + req_key_enc);
		logger.info("signANDencrypt:" + req_body_enc+"|"+req_key_enc);
		return req_body_enc+"|"+req_key_enc;

	}

	public String sendAndRead(String req) {

		try {
			HttpURLConnection connect = new SslConnection().openConnection(url);

			connect.setReadTimeout(120000);
			connect.setConnectTimeout(30000);

			connect.setRequestMethod("POST");
			connect.setDoInput(true);
			connect.setDoOutput(true);
			connect.connect();

			byte[] put = req.getBytes("UTF-8");
			connect.getOutputStream().write(put);

			connect.getOutputStream().flush();
			connect.getOutputStream().close();
			String res = SslConnection.read(connect);

			connect.getInputStream().close();
			connect.disconnect();

//			String res = new SslConnection().connect(url);

			return res;
		} catch(Exception e) {
			logger.error(Strings.getStackTrace(e));
		}
		return "";
	}

	private static boolean firstRcdStatus(MsgBean msgBean)
	{
		if("0000".equals(msgBean.getTRANS_STATE())) {
			logger.info("请求成功");
			if("0000".equals(msgBean.getBODYS().get(0).getPAY_STATE())) {
				return true;
			}
		}
		return false;
	}

}
