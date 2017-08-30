package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.ServiceOperationException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.AliTools;
import cn.houhe.api.common.FacePPUtil;
import cn.houhe.api.common.IDCardUtil;
import cn.houhe.api.common.MegviiUtil;
import cn.houhe.api.common.enums.ApplyStateEnum;
import cn.houhe.api.common.enums.CreditApplyStep;
import cn.houhe.api.facade.MemberFacade;
import cn.houhe.api.loan.entity.*;
import cn.houhe.api.loan.entity.bo.CreditInfo;
import cn.houhe.api.loan.mapper.CreditApplyExtMapper;
import cn.houhe.api.loan.mapper.CreditApplyMapper;
import cn.houhe.api.loan.web.bo.*;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

/**
 * 业务实现层 - 表：credit_apply
 * @since 2017-03-29 18:30:03
 */
@Service("creditApplyService")
public class CreditApplyService implements Serializable {
	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(CreditApplyService.class);

	@Resource
	private CreditApplyMapper creditApplyMapper;

	private NumberFormat monthFormat = new DecimalFormat("00");

	@Autowired
	private LoanContractService loanContractService;

	@Autowired
	private CreditApplyExtService creditApplyExtService;

	@Autowired
	private MemberFacade memberFacade;

	@Autowired
	private CreditinfoService creditinfoService;

	@Autowired
	private AuthorizeInfoService authorizeInfoService;

	@Autowired
	private CreditApplyExtMapper creditApplyExtMapper;

	@Autowired
	private CreditChildrenService creditChildrenService;

	public void insert(CreditApply entity) throws ServiceException {
		try {
			creditApplyMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(CreditApply entity) throws ServiceException {
		try {
			creditApplyMapper.deleteByPrimaryKey(entity.getCaId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				creditApplyMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(CreditApply entity) throws ServiceException {
		try {
			creditApplyMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(CreditApply entity) throws ServiceException {
		try {
			creditApplyMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public CreditApply findByPrimaryKey(Integer caId) throws ServiceException {
		try {
			return creditApplyMapper.selectByPrimaryKey(caId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<CreditApply> findPage(Criteria<CreditApply> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(CreditApply.class);
			}
			criteria.pagination(true);
			List<CreditApply> list = creditApplyMapper.selectByCriteria(criteria);
			return new Pager<CreditApply>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<CreditApply> findAll(Criteria<CreditApply> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(CreditApply.class);
			}
			criteria.pagination(false);
			return creditApplyMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * 先调用face++进行身份证识别
	 * 将用户的身份证信息与用户进行关联
	 */


	@Transactional(rollbackFor = Exception.class)
	public CreditApplyIdCard applyIdCard(CreditApplyIdCardDto apply) throws Exception{


		FacePPUtil.FacePPIDCardInfo front = null;

		//保存全路径
		apply.setFront(AliTools.ossPrefix + apply.getFront());
		apply.setBack(AliTools.ossPrefix + apply.getBack());
		apply.setFace(AliTools.ossPrefix + apply.getFace());
		try {
			front = FacePPUtil.getIDCard(apply.getFront());
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new ServiceOperationException("身份证识别失败");
		}
		if(StringUtils.isEmpty(front.getName()))
		{
			throw new ServiceOperationException("身份证识别信息不全，请重新识别");
		}
		String idCardNumber = front.getId_card_number();
		String year = front.getBirthday().getString("year");
		String day = front.getBirthday().getString("day");
		String month = front.getBirthday().getString("month");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, Integer.parseInt(year));
		calendar.set(Calendar.MONTH, Integer.parseInt(month) - 1);
		calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
		List<CreditApply> creditApplies =  creditApplyMapper.selectByCriteria(Criteria.create(CreditApply.class)
				.add(ExpressionFactory.eq("idCard",idCardNumber)));
		if (CollectionUtils.isNotEmpty(creditApplies)) {
			throw new ServiceOperationException("该身份证已授信，不能再次申请");
		}

		CreditApply creditApply = new CreditApply();
		creditApply.setApplyState((byte) ApplyStateEnum.APPLYING.getIndex());
		//上传之后为2
		creditApply.setApplyStep((byte) CreditApplyStep.FACE.getStep());
		creditApply.setApplyTime(new Date());
		creditApply.setIdCard(idCardNumber);
		creditApply.setName(front.getName());
		creditApply.setMemberId(apply.getMemId());
		creditApply.setAddress(front.getAddress());
		creditApply.setBirthday(calendar.getTime());
		creditApply.setNation(front.getRace());
		creditApply.setSex((byte) ("男".equals(front.getGender())? 0 : IDCardUtil.sex(front.getId_card_number())));
		creditApply.setNativePlace(IDCardUtil.nativePlace(front.getId_card_number()));
		creditApplyMapper.insertSelective(creditApply);
		memberFacade.insertCreditApplyIdCard(apply,creditApply.getCaId());

		CreditApplyIdCard card = new CreditApplyIdCard();
		BeanUtils.copyProperties(card,front);
		return card;
	}

	/**
	 * 查询用户的授信状态信息
	 * @param info
	 * @return
	 * @throws Exception
	 */
	public CreditApplyInfo applyInfo(CreditApplyInfoDto info) throws Exception{
		List<CreditApply> creditApplies =  creditApplyMapper.selectByCriteria(Criteria.create(CreditApply.class).add(ExpressionFactory.eq("memberId",info.getMemId())));
		CreditApplyInfo applyInfo = new CreditApplyInfo();
		if (CollectionUtils.isEmpty(creditApplies)) {
			applyInfo.setApplyStep(CreditApplyStep.ID_CARD.getStep());
			applyInfo.setMemberId(info.getMemId());
			return applyInfo;
		}

		CreditApply apply = creditApplies.get(0);
		BeanUtils.copyProperties(applyInfo,apply);

		if (apply.getApplyStep() != CreditApplyStep.ID_CARD.getStep()) {//非第一步时查身份证图片
			CreditApplyInfo idCardPic = memberFacade.getIDCardImg(info.getMemId(), apply.getCaId());
			applyInfo.setFront(idCardPic.getFront());
			applyInfo.setBack(idCardPic.getBack());
		}

		if (apply.getApplyStep() > CreditApplyStep.CAR.getStep()){//第3步返回行驶证
			CreditApplyInfo drivingImg = memberFacade.getDrivingImg(info.getMemId(), apply.getCaId());
			applyInfo.setDfront(drivingImg.getDfront());
			applyInfo.setDback(drivingImg.getDback());
		}


		//授权状态
		List<AuthorizeInfo> auths = authorizeInfoService.findAll(Criteria.create(AuthorizeInfo.class).add(ExpressionFactory.eq("memberId",info.getMemId())));
		if (CollectionUtils.isNotEmpty(auths)) {
			AuthorizeInfo authorizeInfo = auths.get(0);
			applyInfo.setAuthAl(authorizeInfo.getIsAliyAuthorize().intValue());
			applyInfo.setAuthCr(authorizeInfo.getIsCreditAuthorize().intValue());
			applyInfo.setAuthOp(authorizeInfo.getIsOperateAuthorize().intValue());
			applyInfo.setAuthAlOpenId((String) memberFacade.getMemberInfo(info.getMemId()).get("bqsOpenId"));
		}

		if (apply.getApplyStep() > CreditApplyStep.FACE.getStep()) {// 第5步返回头像
			CreditApplyInfo faceImg = memberFacade.getFaceImg(info.getMemId(), apply.getCaId());
			applyInfo.setFace(faceImg.getFace());
		}

		List<LoanContract> contracts = loanContractService.findAll(Criteria.create(LoanContract.class).add(ExpressionFactory.eq("creditinfoId",apply.getCaId())));
		applyInfo.setContracts(contracts);
		return applyInfo;
	}


	/**
	 * 信用申请个人信息
	 * @param info
	 */
	@Transactional
	public void applyPersonalInfo(CreditApplyPersonalInfoDto info) throws Exception{

		List<CreditApply> creditApplies =  creditApplyMapper.selectByCriteria(Criteria.create(CreditApply.class)
				.add(ExpressionFactory.eq("memberId",info.getMemId())));
		if (CollectionUtils.isEmpty(creditApplies)) {
			throw new ServiceOperationException("请先上传身份证");
		}

		CreditApply apply = creditApplies.get(0);
		if (apply.getApplyStep() != CreditApplyStep.PERSONAL_INFO.getStep()){
			throw new ServiceOperationException("当前不在填写个人信息步骤");
		}

		BeanUtils.copyProperties(apply,info);
		memberFacade.updatePersonalInfo(apply, info);

        for (CreditChildrenDto creditChildrenDto : info.getChildren()){
            CreditChildren creditChildren = new CreditChildren();
            creditChildren.setBirth(creditChildrenDto.getBirth());
            creditChildren.setCreditApplyId(apply.getCaId());
            creditChildren.setSex(creditChildrenDto.getSex());
            creditChildrenService.insert(creditChildren);
        }
        apply.setChildAmount((byte) info.getChildren().size());
		apply.setApplyStep((byte) CreditApplyStep.AUTHORISE.getStep());//第5步
		creditApplyMapper.updateByPrimaryKeySelective(apply);
	}

	/**
	 * 上传活体头像
	 * @param info
	 */

	@Transactional(rollbackFor = Exception.class)
	public void face(CreditApplyFaceDto info) throws Exception{
		List<CreditApply> creditApplies =  creditApplyMapper.selectByCriteria(Criteria.create(CreditApply.class)
				.add(ExpressionFactory.eq("memberId",info.getMemId())));
		if (CollectionUtils.isEmpty(creditApplies)) {
			throw new ServiceOperationException("请先上传身份证");
		}
		info.setFace(AliTools.ossPrefix + info.getFace());

		CreditApply apply = creditApplies.get(0);
		if (apply.getApplyStep() != CreditApplyStep.FACE.getStep()){
			throw new ServiceOperationException("当前不在上传头像步骤");
		}

		if (!MegviiUtil.compareFaceWithOrigin(info.getFace(), apply.getName(), apply.getIdCard(), new MegviiUtil.FaceComparator() {
			@Override
			public void compare(JSONObject result) {}
		})){
			throw new ServiceOperationException("头像不匹配");
		}
		apply.setApplyStep((byte) CreditApplyStep.CAR.getStep());//第3步
		memberFacade.insertCreditApplyFace(info,apply.getCaId());
		creditApplyMapper.updateByPrimaryKeySelective(apply);

	}

	/**
	 * 签约合同
	 */
	@Transactional(rollbackFor = Exception.class)
	public void contract(CreditApplyContractDto contract) throws Exception{
		List<CreditApply> creditApplies =  creditApplyMapper.selectByCriteria(Criteria.create(CreditApply.class)
				.add(ExpressionFactory.eq("memberId",contract.getMemId())));
		if (CollectionUtils.isEmpty(creditApplies)) {
			throw new ServiceOperationException("请先上传身份证");
		}

		CreditApply apply = creditApplies.get(0);
		if (apply.getApplyStep() != CreditApplyStep.CONTRACT.getStep()){
			throw new ServiceOperationException("当前不在签约步骤");
		}

		BeanUtils.copyProperties(apply,contract);
		apply.setApplyStep((byte) 7);//签约完成

		/*LoanContract regContract = new LoanContract();
		regContract.setContractName("用户注册协议");
		regContract.setCreditinfoId(apply.getCaId());
		regContract.setContractFileUrl("");
		regContract.setContractNumber("CA" + FlowNoUtil.next());
		loanContractService.insertSelective(regContract);

		LoanContract loanContract = new LoanContract();
		loanContract.setContractName("额度借款合同");
		loanContract.setCreditinfoId(apply.getCaId());
		loanContract.setContractFileUrl("");
		loanContract.setContractNumber("CA" + FlowNoUtil.next());
		loanContractService.insertSelective(loanContract);

		LoanContract creditQueryContract = new LoanContract();
		creditQueryContract.setContractName("征信查询授权书");
		creditQueryContract.setCreditinfoId(apply.getCaId());
		creditQueryContract.setContractFileUrl("");
		creditQueryContract.setContractNumber("CA" + FlowNoUtil.next());
		loanContractService.insertSelective(creditQueryContract);

		LoanContract collectionContract = new LoanContract();
		collectionContract.setContractName("委托代收授权书");
		collectionContract.setCreditinfoId(apply.getCaId());
		collectionContract.setContractFileUrl("");
		collectionContract.setContractNumber("CA" + FlowNoUtil.next());
		loanContractService.insertSelective(collectionContract);
*/

        apply.setApplyState((byte) 1);//提交审批

		/*if (creditApplyExtService.autoApprove(contract.getTokenKey(),apply.getCaId(),apply.getMemberId())) {
			apply.setApplyState((byte) 1);//提交审批
		}else {
			apply.setApplyState((byte) 7);//自动审批不通过
		}*/


		creditApplyMapper.updateByPrimaryKeySelective(apply);
		//creditApplyExtService.approve(apply.getCaId(),1,"管理员",0,8000,"");
		//creditApplyExtService.approve(apply.getCaId(),1,"管理员",0,5000,"");

		creditApplyExtService.autoApproveJob(contract.getTokenKey(),apply.getCaId(),apply.getMemberId());
	}

	/**
	 * 是否授信
	 * @param memId
	 * @return
	 */
	public CreditInfo isCredited(Integer memId) throws Exception{
		List<CreditApply>	applies = creditApplyMapper.selectByCriteria(Criteria.create(CreditApply.class)
				.add(ExpressionFactory.eq("memberId",memId))
				.add(ExpressionFactory.in("applyState",ApplyStateEnum.FINAL_OK.getIndex())));
		if (CollectionUtils.isNotEmpty(applies)) {

			List<Creditinfo> creditInfos = creditinfoService.findAll(Criteria.create(Creditinfo.class).add(ExpressionFactory.eq("memberId",memId)));
			if (CollectionUtils.isNotEmpty(creditInfos)){
				CreditInfo info = new CreditInfo();
				BeanUtils.copyProperties(info,creditInfos.get(0));
				return info;
			}
		}
		return null;
	}

	/**
	 * 关联行驶证
	 * @param apply
	 */
	@Transactional(rollbackFor = Exception.class)
	public void applyDriving(CreditApplyDrivingDto apply) throws Exception{
		List<CreditApply> creditApplies =  creditApplyMapper.selectByCriteria(Criteria.create(CreditApply.class)
				.add(ExpressionFactory.eq("memberId",apply.getMemId())));
		if (CollectionUtils.isEmpty(creditApplies)) {
			throw new ServiceOperationException("请先上传身份证");
		}

		CreditApply creditApply = creditApplies.get(0);
		if (creditApply.getApplyStep() != CreditApplyStep.CAR.getStep()){
			throw new ServiceOperationException("当前不在填写上传行驶证步骤");
		}

		BeanUtils.copyProperties(creditApply,apply);
		apply.setDfront(AliTools.ossPrefix + apply.getDfront());
		apply.setDback(AliTools.ossPrefix + apply.getDback());
		apply.setCfront(AliTools.ossPrefix + apply.getCfront());
		apply.setCback(AliTools.ossPrefix + apply.getCback());
		memberFacade.insertCreditApplyDriving(apply,creditApply.getCaId());

		creditApply.setApplyStep((byte) CreditApplyStep.PERSONAL_INFO.getStep());//第4步
		creditApplyMapper.updateByPrimaryKeySelective(creditApply);
	}


	/**
	 * 保存授权时间
	 * @param data
	 */
	public void applyAuth(CreditApplyAuthDto data) throws Exception{
		List<CreditApply> creditApplies =  creditApplyMapper.selectByCriteria(Criteria.create(CreditApply.class)
				.add(ExpressionFactory.eq("memberId",data.getMemId())));
		if (CollectionUtils.isEmpty(creditApplies)) {
			throw new ServiceOperationException("请先上传身份证");
		}

		CreditApply apply = creditApplies.get(0);
		if (apply.getApplyStep() != CreditApplyStep.AUTHORISE.getStep()){
			throw new ServiceOperationException("当前不在授权步骤");
		}

		List<AuthorizeInfo> authorizeInfos = authorizeInfoService.findAll(Criteria.create(AuthorizeInfo.class)
		.add(ExpressionFactory.eq("memberId",data.getMemId())));
		AuthorizeInfo info = new AuthorizeInfo();
		if (CollectionUtils.isNotEmpty(authorizeInfos)){
			info = authorizeInfos.get(0);
		}
		info.setMemberId(data.getMemId());
		info.setIsAliyAuthorize(data.getAl().byteValue());
		info.setAliyAuthorizeTime(new Date());
		info.setOpertateAuthorizeTime(new Date());
		info.setIsOperateAuthorize(data.getOp().byteValue());
		info.setCreditAuthorizeTime(new Date());
		info.setIsCreditAuthorize(data.getCr().byteValue());
		//if (data.getAl() + data.getCr() + data.getOp() == 3) {//全部授权完成跳到下一步
		apply.setApplyStep((byte) CreditApplyStep.CONTRACT.getStep());//人脸
		//}
		if (info.getAiId() == null) {
			authorizeInfoService.insert(info);
		}else {
			authorizeInfoService.updateSelective(info);
		}

		String alOpenId = data.getAlOpenId();
		if (StringUtils.isNoneBlank(alOpenId)){
			memberFacade.updateAlOpenId(data.getMemId(),alOpenId);
		}

		Map memberInfo = memberFacade.getMemberInfo(apply.getMemberId());
		Map<String,String> param = new HashMap<>();
		param.put("realname", apply.getName());
		param.put("realname_end", apply.getName());
		param.put("idcard", apply.getIdCard());
		param.put("mobile", (String) memberInfo.get("mobileno"));
		Calendar calendar = Calendar.getInstance();
		param.put("date", DateFormatUtils.format(new Date(),"yyyy年MM月dd日"));
		param.put("year", String.valueOf(calendar.get(Calendar.YEAR)));
		param.put("day", monthFormat.format(calendar.get(Calendar.DAY_OF_MONTH)));
		param.put("month", monthFormat.format(calendar.get(Calendar.MONTH )+1));

		loanContractService.generateAndSignCreditApplyContract(apply.getCaId(),param);
		List<LoanContract> contracts = loanContractService.findAll(Criteria.create(LoanContract.class).add(ExpressionFactory.eq("creditinfoId",apply.getCaId())));
		data.setContracts(contracts);
		creditApplyMapper.updateByPrimaryKeySelective(apply);
	}

}