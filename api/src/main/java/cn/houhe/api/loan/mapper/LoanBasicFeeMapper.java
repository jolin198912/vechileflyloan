package cn.houhe.api.loan.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.loan.entity.LoanBasicFee;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：loan_basic_fee
 * @since 2017-05-06 17:45:27
 */
public interface LoanBasicFeeMapper {
	/**
	 * 按主键删除
	 * @since 2017-05-06 17:45:27
	 */
	int deleteByPrimaryKey(Integer lbaId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-05-06 17:45:27
	 */
	int insert(LoanBasicFee record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-05-06 17:45:27
	 */
	int insertSelective(LoanBasicFee record);

	/**
	 * 按主键查询
	 * @since 2017-05-06 17:45:27
	 */
	LoanBasicFee selectByPrimaryKey(Integer lbaId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-05-06 17:45:27
	 */
	int updateByPrimaryKeySelective(LoanBasicFee record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-05-06 17:45:27
	 */
	int updateByPrimaryKey(LoanBasicFee record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-05-06 17:45:27
	 */
	List<LoanBasicFee> selectByCriteria(Criteria<LoanBasicFee> criteria);
}