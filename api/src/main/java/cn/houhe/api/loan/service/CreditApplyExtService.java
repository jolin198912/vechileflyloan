package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.ServiceOperationException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.AliTools;
import cn.houhe.api.common.BaiqishiUtil;
import cn.houhe.api.common.Configs;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.common.enums.ApplyStateEnum;
import cn.houhe.api.common.enums.PushMsgEnum;
import cn.houhe.api.common.job.CronUtil;
import cn.houhe.api.common.job.QuartzManager;
import cn.houhe.api.common.job.ScheduleJob;
import cn.houhe.api.facade.ConfigFacade;
import cn.houhe.api.facade.MemberFacade;
import cn.houhe.api.loan.entity.*;
import cn.houhe.api.loan.entity.bo.CreditApplyInfo;
import cn.houhe.api.loan.entity.bo.CreditApplyList;
import cn.houhe.api.loan.entity.bo.ThirdPartyInfoObject;
import cn.houhe.api.loan.mapper.CreditApplyExtMapper;
import cn.houhe.api.loan.mapper.CreditApplyMapper;
import cn.houhe.api.loan.mapper.VerifyInfoMapper;
import cn.houhe.api.loan.service.score.BaiRongApi;
import cn.houhe.api.loan.service.score.ScoreDecision;
import cn.houhe.api.loan.web.bo.CreditApplyListDto;
import cn.houhe.api.log.entity.Message;
import cn.houhe.api.log.mapper.MessageMapper;
import cn.houhe.api.member.entity.PhoneContact;
import cn.houhe.api.member.service.PhoneContactService;
import com.alibaba.druid.sql.visitor.functions.If;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 业务实现层 - 表：credit_apply
 *
 * @since 2017-03-29 18:30:03
 */
@Service("creditApplyExtService")
public class CreditApplyExtService implements Serializable {
    private static final long serialVersionUID = 1L;

    private static Logger logger = LoggerFactory.getLogger(CreditApplyExtService.class);

    @Autowired
    private CreditApplyExtMapper creditApplyExtMapper;
    @Autowired
    private CreditinfoService creditinfoService;
    @Autowired
    private CreditApplyMapper creditApplyMapper;
    @Autowired
    private LoanAuditService loanAuditService;
    @Autowired
    private ConfigFacade configFacade;
    @Autowired
    private CreditChildrenService creditChildrenService;
    @Autowired
    private AuthorizeInfoService authorizeInfoService;
    @Autowired
    private PhoneContactService phoneContactService;
    @Autowired
    private ScheduleJobService scheduleJobService;
    @Autowired
    private MemberFacade memberFacade;
    @Autowired
    private ScoreDecision scoreDecision;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private VerifyInfoMapper verifyInfoMapper;
    @Autowired
    private RiskmanageScoresRecordService riskmanageScoresRecordService;

    @Autowired
    private VerifyThirdResultService verifyThirdResultService;
    public Pager<CreditApplyList> findPage(CreditApplyListDto dto) throws ServiceException {
//    	处理页面传过来的时间
    	if(dto.getAend()!=null) {
        	Date d=dto.getAend();
        	Calendar c=Calendar.getInstance();
        	c.setTime(d);
        	c.add(c.DATE, 1);
        	dto.setAend(c.getTime());
        }   	
    	try {           
        	int total = creditApplyExtMapper.selectCreditApplyListCount(dto);

            Pager<CreditApplyList> pager = new Pager<>(dto.getPage(), dto.getRows(), total, new ArrayList<CreditApplyList>());
            if (total == 0) {
                return pager;
            }
            List<CreditApplyList> list = creditApplyExtMapper.selectCreditApplyList(dto, pager.getStartRow(), pager.getPageSize());
            pager.setList(list);
            return pager;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * 查看信用申请的详情
     *
     * @param caid
     * @return
     */
    public CreditApplyInfo getCreditApplyInfo(Integer caid) {
        CreditApplyInfo infoObject = creditApplyExtMapper.getCreditApplyInfo(caid);
        if (infoObject == null) {
            throw new ServiceOperationException("未找到申请信息");
        }
        return infoObject;
    }

    /**
     * 查看授信申请风控评分的详情
     *
     * @param cdid
     * @return
     */
    public RiskmanageScoresRecord getCreditScoreInfo(Integer cdid) {
        RiskmanageScoresRecord infoObject = creditApplyExtMapper.getCreditScoreInfo(cdid);
        if (infoObject == null) {
            throw new ServiceOperationException("未找到授信申请风控评分信息");
        }
        return infoObject;
    }

    /**
     * 查看第三方接口信息的详情
     *
     * @param caid
     * @return
     */
    public ThirdPartyInfoObject getThirdPartyInfo(Integer caid) {
        ThirdPartyInfoObject infoObject = creditApplyExtMapper.getThirdPartyInfo(caid);
        if (infoObject == null) {
            throw new ServiceOperationException("未找到第三方接口信息");
        }
        return infoObject;
    }

    /**
     * 审核
     *
     * @param state  审核状态
     * @param caid   申请id
     * @param pid    审核人id
     * @param remark 备注
     */
    @Transactional
    public void approve(Integer caid, Integer pid, String pname, Integer state, Integer limit, String remark) throws ServiceOperationException {
        CreditApply apply = creditApplyMapper.selectByPrimaryKey(caid);

        if (apply == null) {
            throw new ServiceOperationException("未找到该申请信息");
        }

        if (!Arrays.asList(1, 2).contains(apply.getApplyState().intValue())) {
            throw new ServiceOperationException("不要重复审核");
        }

        List<LoanAudit> audits = loanAuditService.findAll(Criteria.create(LoanAudit.class)
                .add(ExpressionFactory.eq("creditApplyId", apply.getCaId())));

        LoanAudit audit = new LoanAudit();
        if (CollectionUtils.isEmpty(audits)) {
            audit.setCreditApplyId(apply.getCaId());
            loanAuditService.insert(audit);
        } else {
            audit = audits.get(0);
        }

        List<Creditinfo> creditinfos = creditinfoService.findAll(Criteria.create(Creditinfo.class)
                .add(ExpressionFactory.eq("memberId", apply.getMemberId())));
        Creditinfo creditinfo;

        if (CollectionUtils.isEmpty(creditinfos)) {
            creditinfo = new Creditinfo();
            creditinfo.setMemberId(apply.getMemberId());
            creditinfoService.insert(creditinfo);
        } else {
            creditinfo = creditinfos.get(0);
        }
        if (state == 0) {//通过
            creditinfo.setLoanLimitTotal(limit);
            //creditinfo.setPdlLoanLimitTotal(limit);
            if (apply.getApplyState() == 1) {//初审
                audit.setFirstAuditPerson(pname);
                audit.setFirstAuditTime(new Date());
                Map user = loanAuditService.getCreditLastPlanAuditPerson();
                audit.setPlanSapId((Integer) user.get("usid"));//分配终审人员
                audit.setPlanSecondAuditPerson((String) user.get("name"));
                apply.setApplyState((byte) 2);//初审通过
                creditinfo.setLoanLimitLeft(0);

            } else if (apply.getApplyState() == 2) {//终审
                audit.setSecondAuditPerson(pname);
                audit.setSecondAuditTime(new Date());
                apply.setApplyState((byte) 4);//终审通过
                creditinfo.setLoanLimitLeft(limit);

                ///终身通过，发送推送消息
                try {
                    String title = "授信";
                    String summary = "授信申请";
                    String body = "恭喜您，您的授信信息已经审核通过了。";
                    byte msgtype = (byte) PushMsgEnum.CreditOk.getIndex();
                    Map<String, String> sendres = AliTools.pushMsg(apply.getMemberId() + "_" + Configs.pushEv, msgtype, title, summary, body);
                    Message m = new Message();
                    m.setMemberId(apply.getMemberId());
                    m.setMsgType((byte)1);
                    m.setMsgContentType(msgtype);
                    m.setTitle(title);
                    m.setIsSend((byte)1);
                    m.setContent(body);
                    m.setCreatedon(new Date());
                    m.setRemark(sendres.get("responseId"));
                    messageMapper.insert(m);
                } catch (Exception ex) {
                   logger.error("发送短信",ex);
                }

            }

        } else {
            if (apply.getApplyState() == 1) {//初审
                audit.setFirstAuditPerson(pname);
                audit.setFirstAuditTime(new Date());
                apply.setApplyState((byte) 3);//初审不通过
            } else if (apply.getApplyState() == 2) {//终审
                audit.setSecondAuditPerson(pname);
                audit.setSecondAuditTime(new Date());
                apply.setApplyState((byte) 5);//终审不通过
            }
            creditinfo.setLoanLimitTotal(0);
            creditinfo.setLoanLimitLeft(0);
            creditinfo.setPdlLoanLimitTotal(0);
            creditinfo.setPdlLoanLimitLeft(0);
            audit.setRemark(remark);
            ///终审未通过，发送推送消息
            try {
                String title = "授信";
                String summary = "授信申请";
                String body = "对不起，您的授信信息未通过审核，请完善资料再次申请。";
                byte msgtype = (byte) PushMsgEnum.CreditNo.getIndex();
                Map<String, String> sendres = AliTools.pushMsg(apply.getMemberId() + "_" + Configs.pushEv, msgtype, title, summary, body);
                Message m = new Message();
                m.setMemberId(apply.getMemberId());
                m.setMsgType((byte)1);
                m.setMsgContentType(msgtype);
                m.setTitle(title);
                m.setIsSend((byte)1);
                m.setContent(body);
                m.setCreatedon(new Date());
                m.setRemark(sendres.get("responseId"));
                messageMapper.insert(m);
            } catch (Exception ex) {

            }
        }
        creditinfoService.updateSelective(creditinfo);
        loanAuditService.updateSelective(audit);
        creditApplyMapper.updateByPrimaryKeySelective(apply);
    }

    /**
     * 自动审批
     *
     * @param tokenKey
     * @param caId
     */
    @Transactional(rollbackFor = Exception.class)
    public void autoApprove(String tokenKey, Integer caId, Integer memberId) throws Exception {
        logger.debug("征信审批[" + caId + "]");
        CreditApply apply = creditApplyMapper.selectByPrimaryKey(caId);

        LoanAudit audit;
        List<LoanAudit> audits = loanAuditService.findAll(Criteria.create(LoanAudit.class)
                .add(ExpressionFactory.eq("creditApplyId", apply.getCaId())));
        if (CollectionUtils.isEmpty(audits)) {
            audit = new LoanAudit();
            audit.setCreditApplyId(apply.getCaId());
            loanAuditService.insert(audit);
        } else {
            audit = audits.get(0);
        }
        audit.setAuditTime(new Date());
        Map user = loanAuditService.getCreditFirstPlanAuditPerson();
        audit.setPlanFapId((Integer) user.get("usid"));
        audit.setPlanFirstAuditPerson((String) user.get("name"));
        loanAuditService.updateSelective(audit);
        Creditinfo creditinfo;
        List<Creditinfo> creditinfos = creditinfoService.findAll(Criteria.create(Creditinfo.class)
                .add(ExpressionFactory.eq("memberId", memberId)));
        if (CollectionUtils.isEmpty(creditinfos)) {
            creditinfo = new Creditinfo();
            creditinfo.setMemberId(memberId);
            creditinfoService.insert(creditinfo);
        } else {
            creditinfo = creditinfos.get(0);
        }
        JSONObject bqsParam = new JSONObject();
        Map memberInfo = memberFacade.getMemberInfo(memberId);
        bqsParam.put("tokenKey", tokenKey);//白骑士token key
        bqsParam.put("certNo", apply.getIdCard());
        bqsParam.put("name", apply.getName());
        bqsParam.put("address", apply.getDomicileDetail());
        bqsParam.put("mobile", memberInfo.get("mobileno"));
        try {
            JSONObject decision = JSONObject.parseObject(BaiqishiUtil.decision(bqsParam));
            String finalDecision = decision.getString("finalDecision");
            if ("Accept".equals(finalDecision) || "Review".equals(finalDecision)) {
//				creditinfo.setSystemLimitTotal(10000);//目前给1w
//				apply.setApplyState((byte) 1);

                //TODO 接入芝麻信用
            }/* else {
                creditinfo.setSystemLimitTotal(0);
                apply.setApplyState((byte) 7);
            }*/
            //保存白骑士，百融等反欺诈结果
            saveThirdPartyResult(apply, (String) memberInfo.get("mobileno"), decision.toJSONString());
            //风险决策评分
            riskmanageScoresRecord(caId, memberId, apply, creditinfo, memberInfo, finalDecision);

            apply.setFengkongState((byte) 1);
            creditinfo = creditinfoService.findByPrimaryKey(creditinfo.getCdId());
            int pdlLimitTotal = configFacade.judgeLoanLimit(0, creditinfo.getTotalScores());
            int loanLimitTotal = configFacade.judgeLoanLimit(1, creditinfo.getTotalScores());
            creditinfo.setLoanLimitTotal(loanLimitTotal);
            creditinfo.setLoanLimitLeft(loanLimitTotal);
            creditinfo.setPdlLoanLimitTotal(pdlLimitTotal);
            creditinfo.setPdlLoanLimitLeft(pdlLimitTotal);
            creditinfo.setSystemLimitTotal(loanLimitTotal);
            if (configFacade.canAutoCredit(creditinfo.getTotalScores())){//自动审批通过
                apply.setApplyState((byte) ApplyStateEnum.AUTO_APPROVAL_OK.getIndex());
			}else if (apply.getApplyState() == ApplyStateEnum.APPLYING.getIndex()){
                apply.setApplyState((byte) ApplyStateEnum.APPROVING.getIndex());
			}
            memberFacade.updateLevel(memberId, configFacade.getCreditLevel(1, creditinfo.getTotalScores()), configFacade.getCreditLevel(0, creditinfo.getTotalScores()));
            creditinfoService.updateSelective(creditinfo);
            creditApplyMapper.updateByPrimaryKeySelective(apply);
        } catch (Exception e) {
            logger.error("自动审批失败", e);
            creditinfo.setSystemLimitTotal(0);
        }


    }

    /**
     * 风险决策评分
     * @param caId
     * @param memberId
     * @param apply
     * @param creditinfo
     * @param memberInfo
     * @param finalDecision
     */
    private void riskmanageScoresRecord(Integer caId, Integer memberId, CreditApply apply, Creditinfo creditinfo, Map memberInfo, String finalDecision) {
        Map<String, Object> scoreParam = new HashMap<>();
        scoreParam.put("bqs", finalDecision);
        scoreParam.put("name", apply.getName());
        scoreParam.put("idcard", apply.getIdCard());
        scoreParam.put("mobileno", memberInfo.get("mobileno"));
        scoreParam.put("birthday", apply.getBirthday());
        scoreParam.put("sex",apply.getSex());
        scoreParam.put("coupleCard", apply.getCoupleCard());
        scoreParam.put("marriage", apply.getMarriage());
        scoreParam.put("educationLevel", apply.getEducation());
        scoreParam.put("high_edu_starttime", apply.getHighEduStarttime());
        scoreParam.put("high_edu_endtime", apply.getHighEduEndtime());
        scoreParam.put("coupleEducationLevel", apply.getCoupleEducation());
        scoreParam.put("coupleJob", apply.getCoupleJob());
        scoreParam.put("coupleName", apply.getCoupleName());
        scoreParam.put("coupleMobile", apply.getCoupleMobile());
        scoreParam.put("familyAmount", apply.getFamilyAmount());
        scoreParam.put("originType", apply.getOriginType());
        scoreParam.put("is500", apply.getIsCompanyFivehun());
        scoreParam.put("childAmount", apply.getChildAmount());
        scoreParam.put("domicileDetail", apply.getDomicileDetail());
        scoreParam.put("houseAddress", apply.getCity() + apply.getArea());
        scoreParam.put("domicileTime", apply.getDomicileTime());
        scoreParam.put("insurancePay", apply.getYearPay());
        scoreParam.put("income", apply.getIncome());
        scoreParam.put("children", creditChildrenService.findAll(Criteria.create(CreditChildren.class).add(ExpressionFactory.eq("creditApplyId", apply.getCaId()))));
        scoreParam.put("authorise", authorizeInfoService.findAll(Criteria.create(AuthorizeInfo.class).add(ExpressionFactory.eq("memberId", apply.getMemberId()))));
        scoreParam.put("contracts", phoneContactService.findAll(Criteria.create(PhoneContact.class).add(ExpressionFactory.eq("memberId", apply.getMemberId()))));
        scoreParam.put("qq_age", apply.getQqAge());
        scoreParam.put("wx_age", apply.getWxAge());
        scoreParam.put("social_security", apply.getSocialSecurity());
        scoreParam.put("jingdong_quto", apply.getJingdongQuto());
        scoreParam.put("mayijieb_quto", apply.getMayijiebQuto());
        scoreParam.put("huabei_quto", apply.getHuabeiQuto());
        scoreParam.put("debit", apply.getDebit());
        scoreParam.put("address", apply.getAddress());
        scoreParam.put("work_place", apply.getWorkPlace());
        scoreParam.put("apply_time", apply.getApplyTime());
        scoreParam.put("wantedLimit", apply.getWantedLimit());
        scoreParam.put("wantedPeriod", apply.getWantedPeriod());
        scoreParam.put("wantedRepayDay", apply.getWantedRepayDay());
        scoreParam.put("car_lisence", apply.getCarLisence());
        scoreParam.put("car_property", apply.getCarProperty());
        scoreParam.put("buy_date", apply.getBuyDate());
        scoreParam.put("counts", apply.getCounts());
        scoreParam.put("price", apply.getPrice());
        scoreParam.put("car_insurance_amount", apply.getCarInsuranceAmount());
        scoreParam.put("car_driven", apply.getCarDriven());
        scoreParam.put("city", apply.getCity());
        scoreParam.put("house_caty", apply.getHouseCaty() == 1 ? "别墅" : "住宅");
        scoreParam.put("filter", apply.getArea());
        scoreParam.put("house_big", apply.getHouseBig());
        scoreParam.put("is_allow_contact", apply.getIsAllowContact());
        scoreParam.put("is_allow_record", apply.getIsAllowRecord());
        scoreParam.put("is_allow_message", apply.getIsAllowMessage());
        scoreParam.put("is_allow_location", apply.getIsAllowLocation());
        scoreParam.put("loan_amount", apply.getLoanAmount());
        scoreParam.put("work_experience", apply.getWorkExperience());
        scoreParam.put("accumulation_fund", apply.getAccumulationFund());

        //更新信用分
        RiskmanageScoresRecord riskmanageScoresRecord = new RiskmanageScoresRecord();//风控评分记录模型
        List<RiskmanageScoresRecord> riskmanageScoresRecords = riskmanageScoresRecordService.findAll(Criteria.create(RiskmanageScoresRecord.class)
                .add(ExpressionFactory.eq("creditinfoId", creditinfo.getCdId())));
        if (CollectionUtils.isNotEmpty(riskmanageScoresRecords)) {
            riskmanageScoresRecord = riskmanageScoresRecords.get(0);
        }
        riskmanageScoresRecord.setCreditinfoId(creditinfo.getCdId());
        scoreParam.put("scoreRecord", riskmanageScoresRecord);

        //更新验证信息状态
        VerifyInfo verifyInfo = new VerifyInfo();
        List<VerifyInfo> verifies = verifyInfoMapper.selectByCriteria(Criteria.create(VerifyInfo.class).
                add(ExpressionFactory.eq("creditApplyId", caId)));
        if (CollectionUtils.isNotEmpty(verifies)) {
            verifyInfo = verifies.get(0);
        }
        verifyInfo.setCreditApplyId(caId);
        verifyInfo.setMemberId(memberId);
        scoreParam.put("verifyInfo",verifyInfo);

        updateScores(memberId, scoreParam);
        if (riskmanageScoresRecord.getRsrId() != null) {
            riskmanageScoresRecordService.updateSelective(riskmanageScoresRecord);
        } else {
            riskmanageScoresRecordService.insertSelective(riskmanageScoresRecord);
        }
        if (verifyInfo.getVfiId() != null) {
            verifyInfoMapper.updateByPrimaryKeySelective(verifyInfo);
        } else {
            verifyInfoMapper.insertSelective(verifyInfo);
        }
    }

    /**
     * 保存白骑士，百融等反欺诈结果
     * @param apply
     * @param mobile
     * @param bqsResult
     */
    private void saveThirdPartyResult(CreditApply apply, String mobile, String bqsResult) {
        JSONObject reqData = new JSONObject();
        reqData.put("name", apply.getName());
        reqData.put("id", apply.getIdCard());
        JSONArray cells = new JSONArray();
        cells.add(mobile);
        reqData.put("cell", cells);
        reqData.put("meal", "SpecialList_c");
        JSONObject specialResult=JSONObject.parseObject(new BaiRongApi().getData("BankServer3Api",reqData));

        VerifyThirdResult verifyThirdResult = new VerifyThirdResult();
        List<VerifyThirdResult> verifyThirdResults = verifyThirdResultService.findAll(Criteria.create(VerifyThirdResult.class).add(ExpressionFactory.eq("creditApplyId",apply.getCaId())));
        if (CollectionUtils.isNotEmpty(verifyThirdResults)){
            verifyThirdResult = verifyThirdResults.get(0);
        }
        verifyThirdResult.setCreditApplyId(apply.getCaId());
        verifyThirdResult.setBaiqishiResult(bqsResult);
        verifyThirdResult.setBairongResult(specialResult.toJSONString());
        if (verifyThirdResult.getVtrId() == null) {
            verifyThirdResultService.insert(verifyThirdResult);
        }else {
            verifyThirdResultService.updateSelective(verifyThirdResult);
        }
    }


    /**
     * 提交审核任务
     *
     * @param tokenKey
     * @param caId
     * @param memberId
     */
    public void autoApproveJob(String tokenKey, Integer caId, Integer memberId) {
        ScheduleJob job = new ScheduleJob();
        job.setJobName("征信审批" + caId);
        job.setJobGroup("征信");
        job.setClassPath("cn.houhe.api.common.job.DefaultJob.doJob()");
        job.setJobStatus("1");
        job.setCronExpression(CronUtil.laterOneTime(TimeUnit.MINUTES, 5));//2分钟后执行
//		job.setCronExpression("0 0/2 * * * ?");//5分钟执行一次
        job.setDescription("审核会员id为[" + memberId + "], 申请id[" + caId + "]的征信申请");
        JSONObject param = new JSONObject();
        param.put("beanName", "creditApplyExtService");
        param.put("methodName", "autoApprove");
        param.put("tokenKey", tokenKey);
        param.put("caId", caId);
        param.put("memberId", memberId);
        job.setExecuteParam(param.toJSONString());
        QuartzManager.addJob(job, scheduleJobService);
        cn.houhe.api.loan.entity.ScheduleJob scheduleJob = new cn.houhe.api.loan.entity.ScheduleJob();
        try {
            BeanUtils.copyProperties(scheduleJob, job);
            scheduleJob.setIsRepeat((byte) 0);//重复运行
            scheduleJobService.insert(scheduleJob);
        } catch (Exception e) {
            logger.error("提交任务失败", e);
        }
    }


    /**
     * 更新信用分
     * @param memId
     * @param param
     */
    public void updateScores(Integer memId, Map param) {

        int totalScore = scoreDecision.decisionScore(param);

        List<Creditinfo> creditinfos = creditinfoService.findAll(Criteria.create(Creditinfo.class)
                .add(ExpressionFactory.eq("memberId", memId)));
        if (CollectionUtils.isNotEmpty(creditinfos)) {
            Creditinfo creditinfo = creditinfos.get(0);
            creditinfo.setTotalScores(totalScore);
            creditinfoService.updateSelective(creditinfo);
        }
    }

    /**
     * 根据会员性别统计人数
     * @return
     */
    public List<HashMap> findMemCountBySex() {
        return creditApplyExtMapper.selectMemCountBySex();
    }

    /**
     * 根据会员年龄统计人数
     * @return
     */
    public List<HashMap> findMemCountByAge() {
        return creditApplyExtMapper.selectMemCountByAge();
    }

    /**
     * 根据会员婚姻状况统计人数
     * @return
     */
    public List<HashMap> findMemCountByMarriage() {
        return creditApplyExtMapper.selectMemCountByMarriage();
    }

    /**
     * 根据地域状况统计人数
     * @return
     */
    public List<HashMap> findMemCountByDomicileProvince() {
        List<HashMap> list = creditApplyExtMapper.selectMemCountByDomicileProvince();
        if (CollectionUtils.isNotEmpty(list)) {
            baseProvince(list);
        }
        return list;
    }

    /**
     * 根据籍贯状况统计人数
     * @return
     */
    public List<HashMap> findMemCountByNativeProvince() {
        List<HashMap> list = creditApplyExtMapper.selectMemCountByNativeProvince();
        if (CollectionUtils.isNotEmpty(list)) {
            baseProvince(list);
        }
        return list;
    }

    private void baseProvince(List<HashMap> list) {
        long totalCount = (long) list.get(0).get("totalCount");
        long count = 0;
        for (int i = 0; i < list.size(); i++) {
            count += (long) list.get(i).get("provinceCount");
        }
        Long resCount = totalCount - count;
        if (resCount > 0) {
            HashMap map = new HashMap();
            map.put("province","其他");
            map.put("provinceCount",resCount);
            map.put("totalCount",totalCount);
            list.add(map);
        }
    }
    /**
     * 获得百融特殊名单项
     * @return
     */
    public Map<String, String> findSpecialList() {
        HashMap<String, String> map = new HashMap<>();
        map.put("sl_id_abnormal","通过身份证号查询高危行为");
        map.put("sl_id_phone_overdue","通过身份证号查询电信欠费");
        map.put("sl_id_court_bad","通过身份证号查询法院失信人");
        map.put("sl_id_court_executed","通过身份证号查询法院被执行人");
        map.put("sl_id_bank_bad","通过身份证号查询银行(含信用卡)不良");
        map.put("sl_id_bank_overdue","通过身份证号查询银行(含信用卡)短时逾期");
        map.put("sl_id_bank_fraud","通过身份证号查询银行(含信用卡)资信不佳");
        map.put("sl_id_bank_lost","通过身份证号查询银行(含信用卡)失联");
        map.put("sl_id_bank_refuse","通过身份证号查询银行(含信用卡)拒绝");
        map.put("sl_id_p2p_bad","通过身份证号查询非银(含全部非银类型)不良");
        map.put("sl_id_p2p_overdue","通过身份证号查询非银(含全部非银类型)短时逾期");
        map.put("sl_id_p2p_fraud","通过身份证号查询非银(含全部非银类型)资信不佳");
        map.put("sl_id_p2p_lost","通过身份证号查询非银(含全部非银类型)失联");
        map.put("sl_id_p2p_refuse","通过身份证号查询非银(含全部非银类型)拒绝");
        map.put("sl_id_nbank_p2p_bad","通过身份证号查询非银-P2P不良");
        map.put("sl_id_nbank_p2p_overdue","通过身份证号查询非银-P2P短时逾期");
        map.put("sl_id_nbank_p2p_fraud","通过身份证号查询非银-P2P资信不佳");
        map.put("sl_id_nbank_p2p_lost","通过身份证号查询非银-P2P失联");
        map.put("sl_id_nbank_p2p_refuse","通过身份证号查询非银-P2P拒绝");
        map.put("sl_id_nbank_mc_bad","通过身份证号查询非银-小贷不良");
        map.put("sl_id_nbank_mc_overdue","通过身份证号查询非银-小贷短时逾期");
        map.put("sl_id_nbank_mc_fraud","通过身份证号查询非银-小贷资信不佳");
        map.put("sl_id_nbank_mc_lost","通过身份证号查询非银-小贷失联");
        map.put("sl_id_nbank_mc_refuse","通过身份证号查询非银-小贷拒绝");
        map.put("sl_id_nbank_ca_bad","通过身份证号查询非银-现金类分期不良");
        map.put("sl_id_nbank_ca_overdue","通过身份证号查询非银-现金类分期短时逾期");
        map.put("sl_id_nbank_ca_fraud","通过身份证号查询非银-现金类分期资信不佳");
        map.put("sl_id_nbank_ca_lost","通过身份证号查询非银-现金类分期失联");
        map.put("sl_id_nbank_ca_refuse","通过身份证号查询非银-现金类分期拒绝");
        map.put("sl_id_nbank_com_bad","通过身份证号查询非银-代偿类分期不良");
        map.put("sl_id_nbank_com_overdue","通过身份证号查询非银-代偿类分期短时逾期");
        map.put("sl_id_nbank_com_fraud","通过身份证号查询非银-代偿类分期资信不佳");
        map.put("sl_id_nbank_com_lost","通过身份证号查询非银-代偿类分期失联");
        map.put("sl_id_nbank_com_refuse","通过身份证号查询非银-代偿类分期拒绝");
        map.put("sl_id_nbank_cf_bad","通过身份证号查询非银-消费类分期不良");
        map.put("sl_id_nbank_cf_overdue","通过身份证号查询非银-消费类分期短时逾期");
        map.put("sl_id_nbank_cf_fraud","通过身份证号查询非银-消费类分期资信不佳");
        map.put("sl_id_nbank_cf_lost","通过身份证号查询非银-消费类分期失联");
        map.put("sl_id_nbank_cf_refuse","通过身份证号查询非银-消费类分期拒绝");
        map.put("sl_id_nbank_other_bad","通过身份证号查询非银-其他不良");
        map.put("sl_id_nbank_other_overdue","通过身份证号查询非银-其他短时逾期");
        map.put("sl_id_nbank_other_fraud","通过身份证号查询非银-其他资信不佳");
        map.put("sl_id_nbank_other_lost","通过身份证号查询非银-其他失联");
        map.put("sl_id_nbank_other_refuse","通过身份证号查询非银-其他拒绝");
        map.put("sl_cell_abnormal","通过手机号查询高危行为");
        map.put("sl_cell_phone_overdue","通过手机号查询电信欠费");
        map.put("sl_cell_bank_bad","通过手机号查询银行(含信用卡)不良");
        map.put("sl_cell_bank_overdue","通过手机号查询银行(含信用卡)短时逾期");
        map.put("sl_cell_bank_fraud","通过手机号查询银行(含信用卡)资信不佳");
        map.put("sl_cell_bank_lost","通过手机号查询银行(含信用卡)失联");
        map.put("sl_cell_bank_refuse","通过手机号查询银行(含信用卡)拒绝");
        map.put("sl_cell_p2p_bad","通过手机号查询非银(含全部非银类型)不良");
        map.put("sl_cell_p2p_overdue","通过手机号查询非银(含全部非银类型)短时逾期");
        map.put("sl_cell_p2p_fraud","通过手机号查询非银(含全部非银类型)资信不佳");
        map.put("sl_cell_p2p_lost","通过手机号查询非银(含全部非银类型)失联");
        map.put("sl_cell_p2p_refuse","通过手机号查询非银(含全部非银类型)拒绝");
        map.put("sl_cell_nbank_p2p_bad","通过手机号查询非银-P2P不良");
        map.put("sl_cell_nbank_p2p_overdue","通过手机号查询非银-P2P短时逾期");
        map.put("sl_cell_nbank_p2p_fraud","通过手机号查询非银-P2P资信不佳");
        map.put("sl_cell_nbank_p2p_lost","通过手机号查询非银-P2P失联");
        map.put("sl_cell_nbank_p2p_refuse","通过手机号查询非银-P2P拒绝");
        map.put("sl_cell_nbank_mc_bad","通过手机号查询非银-小贷不良");
        map.put("sl_cell_nbank_mc_overdue","通过手机号查询非银-小贷短时逾期");
        map.put("sl_cell_nbank_mc_fraud","通过手机号查询非银-小贷资信不佳");
        map.put("sl_cell_nbank_mc_lost","通过手机号查询非银-小贷失联");
        map.put("sl_cell_nbank_mc_refuse","通过手机号查询非银-小贷拒绝");
        map.put("sl_cell_nbank_ca_bad","通过手机号查询非银-现金类分期不良");
        map.put("sl_cell_nbank_ca_overdue","通过手机号查询非银-现金类分期短时逾期");
        map.put("sl_cell_nbank_ca_fraud","通过手机号查询非银-现金类分期资信不佳");
        map.put("sl_cell_nbank_ca_lost","通过手机号查询非银-现金类分期失联");
        map.put("sl_cell_nbank_ca_refuse","通过手机号查询非银-现金类分期拒绝");
        map.put("sl_cell_nbank_com_bad","通过手机号查询非银-代偿类分期不良");
        map.put("sl_cell_nbank_com_overdue","通过手机号查询非银-代偿类分期短时逾期");
        map.put("sl_cell_nbank_com_fraud","通过手机号查询非银-代偿类分期资信不佳");
        map.put("sl_cell_nbank_com_lost","通过手机号查询非银-代偿类分期失联");
        map.put("sl_cell_nbank_com_refuse","通过手机号查询非银-代偿类分期拒绝");
        map.put("sl_cell_nbank_cf_bad","通过手机号查询非银-消费类分期不良");
        map.put("sl_cell_nbank_cf_overdue","通过手机号查询非银-消费类分期短时逾期");
        map.put("sl_cell_nbank_cf_fraud","通过手机号查询非银-消费类分期资信不佳");
        map.put("sl_cell_nbank_cf_lost","通过手机号查询非银-消费类分期失联");
        map.put("sl_cell_nbank_cf_refuse","通过手机号查询非银-消费类分期拒绝");
        map.put("sl_cell_nbank_other_bad","通过手机号查询非银-其他不良");
        map.put("sl_cell_nbank_other_overdue","通过手机号查询非银-其他短时逾期");
        map.put("sl_cell_nbank_other_fraud","通过手机号查询非银-其他资信不佳");
        map.put("sl_cell_nbank_other_lost","通过手机号查询非银-其他失联");
        map.put("sl_cell_nbank_other_refusen","通过手机号查询非银-其他拒绝");
        map.put("sl_lm_cell_abnormal","通过联系人手机查询高危行为");
        map.put("sl_lm_cell_phone_overdue","通过联系人手机查询电信欠费");
        map.put("sl_lm_cell_bank_bad","通过联系人手机查询银行(含信用卡)不良");
        map.put("sl_lm_cell_bank_overdue","通过联系人手机查询银行(含信用卡)短时逾期");
        map.put("sl_lm_cell_bank_fraud","通过联系人手机查询银行(含信用卡)资信不佳");
        map.put("sl_lm_cell_bank_lost","通过联系人手机查询银行(含信用卡)失联");
        map.put("sl_lm_cell_bank_refuse","通过联系人手机查询银行(含信用卡)拒绝");
        map.put("sl_lm_cell_nbank_p2p_bad","通过联系人手机查询非银-P2P不良");
        map.put("sl_lm_cell_nbank_p2p_overdue","通过联系人手机查询非银-P2P短时逾期");
        map.put("sl_lm_cell_nbank_p2p_fraud","通过联系人手机查询非银-P2P资信不佳");
        map.put("sl_lm_cell_nbank_p2p_lost","通过联系人手机查询非银-P2P失联");
        map.put("sl_lm_cell_nbank_p2p_refuse","通过联系人手机查询非银-P2P拒绝");
        map.put("sl_lm_cell_nbank_mc_bad","通过联系人手机查询非银-小贷不良");
        map.put("sl_lm_cell_nbank_mc_overdue","通过联系人手机查询非银-小贷短时逾期");
        map.put("sl_lm_cell_nbank_mc_fraud","通过联系人手机查询非银-小贷资信不佳");
        map.put("sl_lm_cell_nbank_mc_lost","通过联系人手机查询非银-小贷失联");
        map.put("sl_lm_cell_nbank_mc_refuse","通过联系人手机查询非银-小贷拒绝");
        map.put("sl_lm_cell_nbank_ca_bad","通过联系人手机查询非银-现金类分期不良");
        map.put("sl_lm_cell_nbank_ca_overdue","通过联系人手机查询非银-现金类分期短时逾期");
        map.put("sl_lm_cell_nbank_ca_fraud","通过联系人手机查询非银-现金类分期资信不佳");
        map.put("sl_lm_cell_nbank_ca_lost","通过联系人手机查询非银-现金类分期失联");
        map.put("sl_lm_cell_nbank_ca_refuse","通过联系人手机查询非银-现金类分期拒绝");
        map.put("sl_lm_cell_nbank_com_bad","通过联系人手机查询非银-代偿类分期不良");
        map.put("sl_lm_cell_nbank_com_overdue","通过联系人手机查询非银-代偿类分期短时逾期");
        map.put("sl_lm_cell_nbank_com_fraud","通过联系人手机查询非银-代偿类分期资信不佳");
        map.put("sl_lm_cell_nbank_com_lost","通过联系人手机查询非银-代偿类分期失联");
        map.put("sl_lm_cell_nbank_com_refuse","通过联系人手机查询非银-代偿类分期拒绝");
        map.put("sl_lm_cell_nbank_cf_bad","通过联系人手机查询非银-消费类分期不良");
        map.put("sl_lm_cell_nbank_cf_overdue","通过联系人手机查询非银-消费类分期短时逾期");
        map.put("sl_lm_cell_nbank_cf_fraud","通过联系人手机查询非银-消费类分期资信不佳");
        map.put("sl_lm_cell_nbank_cf_lost","通过联系人手机查询非银-消费类分期失联");
        map.put("sl_lm_cell_nbank_cf_refuse","通过联系人手机查询非银-消费类分期拒绝");
        map.put("sl_lm_cell_nbank_other_bad","通过联系人手机查询非银-其他不良");
        map.put("sl_lm_cell_nbank_other_overdue","通过联系人手机查询非银-其他短时逾期");
        map.put("sl_lm_cell_nbank_other_fraud","通过联系人手机查询非银-其他资信不佳");
        map.put("sl_lm_cell_nbank_other_lost","通过联系人手机查询非银-其他失联");
        map.put("sl_lm_cell_nbank_other_refuse","通过联系人手机查询非银-其他拒绝");
        return map;
    }
}