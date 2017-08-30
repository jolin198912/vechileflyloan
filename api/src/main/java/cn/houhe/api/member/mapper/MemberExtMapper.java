package cn.houhe.api.member.mapper;

import cn.houhe.api.member.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：member
 * @since 2017-03-30 10:12:39
 */
@Repository
public interface MemberExtMapper {
	/**
	 * 按手机号查询
	 * @since 2017-03-30 10:12:39
	 */
	MemberExt selectByMobile(String mobile);

	/**
	 * 查询联系人列表
	 * @since 2017-03-30 10:12:39
	 */
	List<PhoneContact> selectPhoneContact(@Param("memid") Integer memid);

	/**
	 * 按手机号查询
	 * @since 2017-03-30 10:12:39
	 */
	MemLoanInfoExt selectMemLoanInfoByMobile(String mobile);

	/**
	 * 按手机号查询
	 * @since 2017-03-30 10:12:39
	 */
	MemLoanInfoExt selectMemLoanInfoByMobile(Integer memid);

	/**
	 * 按手机号查询
	 * @since 2017-03-30 10:12:39
	 */
	Member selectMemInfoByMobile(String mobile);

	/**
	 * 查询贷款利率(已登录)
	 * @since 2017-03-30 10:12:39
	 */
	List<LoanRatesExt> selectLoanRates(@Param("memid") Integer memid, @Param("type") Byte type);

	/**
	 * 查询贷款利率（未登录）
	 * @since 2017-03-30 10:12:39
	 */
	List<LoanRatesExt> selectLoanRatesByNOLogin(@Param("level_id") Integer level_id, @Param("type") Byte type);

	/*
	* 会员列表
	*/
	List<MemberListExt> findPageData(MemberListExt memberListExt);

	Integer getCount(MemberListExt memberListExt);

	/*
	* 会员详细信息
	*/
	MemberDetailInfoExt getMemberDetailInfo(@Param("memid") Integer memid);

	/*
	* 会员贷款记录
	*/
	List<LoanRecordListExt> getLoanRecordList(@Param("memid") Integer memid);

	/*
	* 会员授信合同
	*/
	List<LoanContractExt> getCreditContractFile(@Param("memid") Integer memid);

	/*
	* 会员贷款合同
	*/
	List<LoanContractExt> getLoanCreditContractFile(@Param("loanrecordid") Integer loanrecordid);

	/*
	* 会员还款记录
	*/
	List<DebitRecordListExt> findDebitRecordPageData(DebitRecordListExt debitRecordListExt);

	Integer getDebitRecordCount(DebitRecordListExt debitRecordListExt);

	/*
	* 会员逾期还款记录
	*/
	List<OverdueRecordListExt> getOverdueRecordList(@Param("memid") Integer memid);

	/*
	* 会员催收记录
	*/
	List<RemainderRecoadListExt> findRemainderRecoadPageData(RemainderRecoadListExt remainderRecoadListExt);

	Integer getRemainderRecoadCount(RemainderRecoadListExt remainderRecoadListExt);

	/*
	* 会员邀请记录
	*/
	List<MemberListExt> findInviteRecordPageData(MemberListExt memberListExt);

	Integer getInviteRecordCount(MemberListExt memberListExt);

	MemberPressDetailExt getMemberPressDetail(@Param("memid") Integer memid);

	String getUserNameByMemId(@Param("memid") Integer memid);



}