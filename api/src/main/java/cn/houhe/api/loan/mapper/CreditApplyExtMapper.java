package cn.houhe.api.loan.mapper;

import cn.houhe.api.loan.entity.RiskmanageScoresRecord;
import cn.houhe.api.loan.entity.bo.CreditApplyInfo;
import cn.houhe.api.loan.entity.bo.CreditApplyList;
import cn.houhe.api.loan.entity.bo.ThirdPartyInfoObject;
import cn.houhe.api.loan.web.bo.CreditApplyListDto;
import cn.houhe.api.loan.web.bo.MemberExtDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：credit_apply
 * @since 2017-04-06 15:17:13
 */
@Repository
public interface CreditApplyExtMapper {

	int selectCreditApplyListCount(@Param("dto") CreditApplyListDto dto);

	List<CreditApplyList> selectCreditApplyList(@Param("dto") CreditApplyListDto dto, @Param("start") int start, @Param("size") int size);

	CreditApplyInfo getCreditApplyInfo(@Param("caid") Integer caid);

	RiskmanageScoresRecord getCreditScoreInfo(@Param("cdid") Integer cdid);

	ThirdPartyInfoObject getThirdPartyInfo(@Param("caid") Integer caid);

	/*
	根据会员性别统计人数
	 */
	List<HashMap> selectMemCountBySex();
	/*
	根据会员年龄统计人数
	 */
	List<HashMap> selectMemCountByAge();
	/*
	根据会员婚姻状况统计人数
	 */
	List<HashMap> selectMemCountByMarriage();
	/*
	根据地域情况统计人数
	 */
	List<HashMap> selectMemCountByDomicileProvince();
	/*
	根据籍贯情况统计人数
	 */
	List<HashMap> selectMemCountByNativeProvince();
}