package cn.houhe.api.member.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.member.entity.BankCard;
import cn.houhe.api.member.entity.BankCardExt;
import cn.houhe.api.member.entity.MemberExt;
import cn.houhe.api.member.entity.MerBankCardExt;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：bank_card
 * @since 2017-03-30 10:12:39
 */
@Repository
public interface BankCardExtMapper {
	/**
	 * 按主键查询
	 * @since 2017-03-30 10:12:39
	 */
	List<BankCardExt> selectByMemberId(Integer member_id);

	/**
	 * 按银行卡号查询
	 * @since 2017-03-30 10:12:39
	 */
	BankCard selectByBankCardNo(String bankcardno);

	/*
	* 会员银行卡信息
	*/
	MerBankCardExt getMerBankCardInfo(@Param("memberId") Integer memberId);
}