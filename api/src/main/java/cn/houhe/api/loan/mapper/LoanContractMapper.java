package cn.houhe.api.loan.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.loan.entity.LoanContract;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：loan_contract
 * @since 2017-05-10 12:16:19
 */
public interface LoanContractMapper {
	/**
	 * 按主键删除
	 * @since 2017-05-10 12:16:19
	 */
	int deleteByPrimaryKey(Integer lcId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-05-10 12:16:19
	 */
	int insert(LoanContract record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-05-10 12:16:19
	 */
	int insertSelective(LoanContract record);

	/**
	 * 按主键查询
	 * @since 2017-05-10 12:16:19
	 */
	LoanContract selectByPrimaryKey(Integer lcId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-05-10 12:16:19
	 */
	int updateByPrimaryKeySelective(LoanContract record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-05-10 12:16:19
	 */
	int updateByPrimaryKey(LoanContract record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-05-10 12:16:19
	 */
	List<LoanContract> selectByCriteria(Criteria<LoanContract> criteria);
}