package cn.houhe.api.loan.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.loan.entity.LoanBankCard;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：loan_bank_card
 * @since 2017-05-05 16:09:35
 */
public interface LoanBankCardMapper {
	/**
	 * 按主键删除
	 * @since 2017-05-05 16:09:35
	 */
	int deleteByPrimaryKey(Integer lbcId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-05-05 16:09:35
	 */
	int insert(LoanBankCard record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-05-05 16:09:35
	 */
	int insertSelective(LoanBankCard record);

	/**
	 * 按主键查询
	 * @since 2017-05-05 16:09:35
	 */
	LoanBankCard selectByPrimaryKey(Integer lbcId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-05-05 16:09:35
	 */
	int updateByPrimaryKeySelective(LoanBankCard record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-05-05 16:09:35
	 */
	int updateByPrimaryKey(LoanBankCard record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-05-05 16:09:35
	 */
	List<LoanBankCard> selectByCriteria(Criteria<LoanBankCard> criteria);
}