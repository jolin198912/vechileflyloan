package cn.houhe.api.config.service;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.houhe.api.config.entity.Rates;
import cn.houhe.api.config.mapper.RatesMapper;
import cn.houhe.api.loan.service.CreditinfoService;
import cn.houhe.api.member.entity.Member;
import cn.houhe.api.member.service.MemberService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 业务实现层 - 表：rates
 * @since 2017-03-30 10:04:06
 */
@Service
public class RatesExtService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private RatesMapper ratesMapper;

	@Autowired
	private MemberService memberService;

	/**
	 * 取贷款综合利率
	 * @param memberId
	 * @param lpId
	 *@param loanType
	 * @param time   @return
	 */
	public BigDecimal getLoanRate(Integer memberId, Short lpId, Byte loanType, Short time) {
		BigDecimal rate =new BigDecimal( 0.0005);
		/*Member member =  memberService.findByPrimaryKey(memberId);
		List<Rates> ratess = ratesMapper.selectByCriteria(Criteria.create(Rates.class)
		.add(ExpressionFactory.eq("levelId",member.getLevelId()))
		.add(ExpressionFactory.eq("type",loanType)));
//		Creditinfo creditinfo = creditinfoService.findAll(Criteria.create(Creditinfo.class).add(ExpressionFactory.eq("memberId",memberId))).get(0);
		if (CollectionUtils.isNotEmpty(ratess)){
			Rates rates = ratess.get(0);
			rate = rates.getFirstLoanRate();
		}*/
		Rates	rates = getRate(memberId, loanType);
		if (rates != null){
			return rates.getFirstLoanRate();
		}
		return rate;
	}

	/**
	 * 获取滞纳金率
	 * @param memberId
	 * @param lpId
	 *@param loanType
	 * @param time   @return
	 */
	public BigDecimal getLoanLateRate(Integer memberId, Short lpId, Byte loanType, Short time) {
		BigDecimal rate =new BigDecimal( 0.0005);
		Rates	rates = getRate(memberId, loanType);
		if (rates != null){
			return rates.getDelayRate();
		}
		return rate;
	}


	/**
	 * 获取催收费率
	 * @param memberId
	 * @param lpId
	 *@param loanType
	 * @param time   @return
	 */
	public BigDecimal getLoanRemindFee(Integer memberId, Short lpId, Byte loanType, Short time) {
		BigDecimal rate =new BigDecimal( 20);
		Rates	rates = getRate(memberId, loanType);
		if (rates != null){
			return rates.getRemindFee();
		}
		return rate;
	}




	public Rates getRate(Integer memberId, Byte loanType) {
		Member member =  memberService.findByPrimaryKey(memberId);
		int levelId = loanType == 0 ? member.getPdlLevelId() : member.getLevelId();
		List<Rates> ratess = ratesMapper.selectByCriteria(Criteria.create(Rates.class)
				.add(ExpressionFactory.eq("levelId",levelId))
				.add(ExpressionFactory.eq("type",loanType)));
		if (CollectionUtils.isNotEmpty(ratess)){
			return ratess.get(0);
		}
		return null;
	}
}