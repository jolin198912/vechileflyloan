package cn.houhe.api.facade;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.ServiceOperationException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.util.BeanUtil;
import cn.houhe.api.config.entity.CommDataConfig;
import cn.houhe.api.config.service.CommDataConfigService;
import cn.houhe.api.loan.entity.CreditApply;
import cn.houhe.api.loan.web.bo.*;
import cn.houhe.api.member.entity.BankCard;
import cn.houhe.api.member.entity.Member;
import cn.houhe.api.member.entity.MemberPicResources;
import cn.houhe.api.member.entity.PhoneContact;
import cn.houhe.api.member.mapper.MemberPicResourcesMapper;
import cn.houhe.api.member.service.BankCardService;
import cn.houhe.api.member.service.MemberService;
import cn.houhe.api.member.service.PhoneContactService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by think on 2017/4/1.
 */
@Component
public class MemberFacade {

    private static Logger logger = LoggerFactory.getLogger(MemberFacade.class);

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberPicResourcesMapper memberPicResourcesMapper;

    @Autowired
    private CommDataConfigService commDataConfigService;


    @Autowired
    private BankCardService bankCardService;

    @Autowired
    private PhoneContactService phoneContactService;

    @Transactional
    public void insertCreditApplyIdCard(CreditApplyIdCardDto apply, Integer applyID) {


        try {
            // 关联正面
            MemberPicResources front = new MemberPicResources();
            front.setMemberId(apply.getMemId());
            front.setObjectId(applyID);
            front.setPictype((short) 1);
            front.setUrl(apply.getFront());
            front.setObjectType((byte) 2);
            memberPicResourcesMapper.insertSelective(front);
            //关联反面
            MemberPicResources back = new MemberPicResources();
            back.setMemberId(apply.getMemId());
            back.setObjectId(applyID);
            back.setPictype((short) 2);
            back.setUrl(apply.getBack());
            back.setObjectType((byte) 2);
            memberPicResourcesMapper.insertSelective(back);

            //关联反面
            MemberPicResources face = new MemberPicResources();
            face.setMemberId(apply.getMemId());
            face.setObjectId(applyID);
            face.setPictype((short) 4);
            face.setUrl(apply.getFace());
            face.setObjectType((byte) 2);
            memberPicResourcesMapper.insertSelective(face);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new ServiceException("操作失败");
        }
    }


    /**
     * 获取信用申请时的身份证图片
     * @param memId
     * @param applyId
     * @return
     */
    public CreditApplyInfo getIDCardImg(Integer memId,Integer applyId){
        List<MemberPicResources> pics = memberPicResourcesMapper.selectByCriteria(Criteria.create(MemberPicResources.class)
                .add(ExpressionFactory.eq("memberId",memId))
                .add(ExpressionFactory.in("pictype",1,2))
                .add(ExpressionFactory.eq("objectType",2))
                .add(ExpressionFactory.eq("objectId",applyId)).sort(Sort.asc("memberId")));
        if (CollectionUtils.isEmpty(pics)){
            throw new ServiceException("未找到身份证图片");
        }

        CreditApplyInfo info = new CreditApplyInfo();
        info.setFront(pics.get(0).getUrl());
        info.setBack(pics.get(1).getUrl());
        return info;
    }

    public CreditApplyInfo getFaceImg(Integer memId, Integer applyId) {
        List<MemberPicResources> pics = memberPicResourcesMapper.selectByCriteria(Criteria.create(MemberPicResources.class)
                .add(ExpressionFactory.eq("memberId",memId))
                .add(ExpressionFactory.eq("pictype",3))
                .add(ExpressionFactory.eq("objectType",2))
                .add(ExpressionFactory.eq("objectId",applyId)).sort(Sort.asc("memberId")));
        if (CollectionUtils.isEmpty(pics)){
            throw new ServiceException("未找到头像");
        }

        CreditApplyInfo info = new CreditApplyInfo();
        info.setFace(pics.get(0).getUrl());
        return info;
    }

    /**
     * 关联用户头像
     * @param apply
     * @param applyId
     */
    public void insertCreditApplyFace(CreditApplyFaceDto apply, Integer applyId) {
        // 关联头像
        MemberPicResources face = new MemberPicResources();
        face.setMemberId(apply.getMemId());
        face.setObjectId(applyId);
        face.setPictype((short) 3);
        face.setUrl(apply.getFace());
        face.setObjectType((byte) 2);
        memberPicResourcesMapper.insertSelective(face);
    }


    /**
     * 判断是不是管理员，用在授信申请列表查询时作判断
     * @param personId
     * @return
     */
    public boolean isAdmin(int personId) {
        return false;
    }

    /**
     * 提交征信时更新个人信息
     * @param info
     * @param creditApplyPersonalInfoDto
     */
    @Transactional(rollbackFor = Exception.class)
    public void updatePersonalInfo(CreditApply info, CreditApplyPersonalInfoDto creditApplyPersonalInfoDto) {

        List<CommDataConfig> educations = commDataConfigService.findAll(Criteria.create(CommDataConfig.class)
            .add(ExpressionFactory.eq("menuType","0"))
            .add(ExpressionFactory.eq("value",info.getEducation())));
        String education = "";
        if (CollectionUtils.isNotEmpty(educations)){
            education = educations.get(0).getMenuItem();
        }

        List<CommDataConfig> companies = commDataConfigService.findAll(Criteria.create(CommDataConfig.class)
            .add(ExpressionFactory.eq("menuType","1")));
        String company = "";
        if (CollectionUtils.isNotEmpty(companies)){
            company = companies.get(0).getMenuItem();
        }

        Member member = memberService.findByPrimaryKey(info.getMemberId());
        member.setRealname(info.getName());
        member.setIdcardno(info.getIdCard());
        member.setBirthday(info.getBirthday());
//        member.setLongtimecity(info.getWorkTimeStart());
        member.setDetailaddr(info.getDomicileDetail());
        member.setLeveleducation(education);
//        member.setFamilyincome(info.getFamilyIncome());
        member.setUnitnature(company);
        member.setUnitname(info.getCompanyName());
//        member.setPosition(info.getJob());
        member.setMaritalstatus(info.getMarriage());
        member.setChildrennumber(info.getChildAmount().shortValue());
        memberService.updateSelective(member);


        for (PhoneContactDto contact : creditApplyPersonalInfoDto.getContacts()) {
            PhoneContact phoneContact = new PhoneContact();
            phoneContact.setMobile(contact.getMobile());
            phoneContact.setRelationType(contact.getRelationType());
            phoneContact.setMemberId(info.getMemberId());
            phoneContact.setName(contact.getName());
            phoneContactService.insert(phoneContact);
        }
    }


    public Map getBankCard(Integer memId) throws Exception {
        List<BankCard> bankCards = bankCardService.findAll(Criteria.create(BankCard.class)
        .add(ExpressionFactory.eq("memberId",memId)));
        if (CollectionUtils.isEmpty(bankCards)){
            throw new ServiceOperationException("请先绑卡");
        }

        return BeanUtil.convertBean(bankCards.get(0));
    }

    public void insertCreditApplyDriving(CreditApplyDrivingDto apply, Integer applyId) {
        // 关联驾驶证
        MemberPicResources dfront = new MemberPicResources();
        dfront.setMemberId(apply.getMemId());
        dfront.setObjectId(applyId);
        dfront.setPictype((short) 8);//驾驶证背面
        dfront.setUrl(apply.getDback());
        dfront.setObjectType((byte) 2);
        memberPicResourcesMapper.insertSelective(dfront);

        // 关联驾驶证
        MemberPicResources dback = new MemberPicResources();
        dback.setMemberId(apply.getMemId());
        dback.setObjectId(applyId);
        dback.setPictype((short) 5);//驾驶证正面
        dback.setUrl(apply.getDfront());
        dback.setObjectType((byte) 2);
        memberPicResourcesMapper.insertSelective(dback);

        // 关联行驶证
        MemberPicResources cfront = new MemberPicResources();
        cfront.setMemberId(apply.getMemId());
        cfront.setObjectId(applyId);
        cfront.setPictype((short) 6);//行驶证正面
        cfront.setUrl(apply.getCfront());
        cfront.setObjectType((byte) 2);
        memberPicResourcesMapper.insertSelective(cfront);

        // 关联行驶证
        MemberPicResources cback = new MemberPicResources();
        cback.setMemberId(apply.getMemId());
        cback.setObjectId(applyId);
        cback.setPictype((short) 7);//行驶证背面
        cback.setUrl(apply.getCback());
        cback.setObjectType((byte) 2);
        memberPicResourcesMapper.insertSelective(cback);
    }

    /**
     * 获取行驶证
     * @param memId
     * @param applyId
     * @return
     */
    public CreditApplyInfo getDrivingImg(Integer memId, Integer applyId) {
        List<MemberPicResources> pics = memberPicResourcesMapper.selectByCriteria(Criteria.create(MemberPicResources.class)
                .add(ExpressionFactory.eq("memberId",memId))
                .add(ExpressionFactory.in("pictype",6,7))
                .add(ExpressionFactory.eq("objectType",2))
                .add(ExpressionFactory.eq("objectId",applyId)).sort(Sort.asc("memberId")));
        if (CollectionUtils.isEmpty(pics)){
            throw new ServiceException("未找到行驶证");
        }

        CreditApplyInfo info = new CreditApplyInfo();
        info.setDfront(pics.get(0).getUrl());
        info.setDback(pics.get(1).getUrl());
        return info;
    }

    /**
     * 获取身份证头像
     * @param memId
     * @param caId
     * @return
     */
    public String getIDCardFaceImg(Integer memId, Integer caId) {
        List<MemberPicResources> pics = memberPicResourcesMapper.selectByCriteria(Criteria.create(MemberPicResources.class)
                .add(ExpressionFactory.eq("memberId",memId))
                .add(ExpressionFactory.eq("pictype",4))//身份证头像
                .add(ExpressionFactory.eq("objectType",2))
                .add(ExpressionFactory.eq("objectId",caId)).sort(Sort.asc("memberId")));
        if (CollectionUtils.isEmpty(pics)){
            throw new ServiceOperationException("未找到头像");
        }
        return pics.get(0).getUrl();
    }

    public Map getMemberInfo(Integer memberId) throws Exception{
        Map map = new HashMap();
        Member member = memberService.findByPrimaryKey(memberId);
        if (member != null ){
            map =  BeanUtil.convertBean(member);
        }
        return map;
    }

    /**
     * 贷款头像
     * @param apply
     * @param laId
     */
    public void insertLoanApplyFace(CreditApplyFaceDto apply, Integer laId) {
        // 关联头像
        MemberPicResources face = new MemberPicResources();
        face.setMemberId(apply.getMemId());
        face.setObjectId(laId);
        face.setPictype((short) 3);
        face.setUrl(apply.getFace());
        face.setObjectType((byte) 1);
        memberPicResourcesMapper.insertSelective(face);
    }

    public void updateAlOpenId(Integer memId, String alOpenId) {
        Member member = memberService.findByPrimaryKey(memId);
        if (member != null ){
            member.setBqsOpenId(alOpenId);
            memberService.updateSelective(member);
        }
    }

    /**
     * 更新信用等级
     * @param memberId
     * @param level
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateLevel(Integer memberId, int level, int pdlLevel) {
        Member member = memberService.findByPrimaryKey(memberId);
        Assert.notNull(member,"会员不存在");
        member.setLevelId((short) level);
        member.setPdlLevelId((short) pdlLevel);
        memberService.updateSelective(member);
    }
}
