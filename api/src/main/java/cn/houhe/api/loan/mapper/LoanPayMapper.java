package cn.houhe.api.loan.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.loan.entity.LoanPay;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：loan_pay
 * @since 2017-05-05 09:36:25
 */
@Repository
public interface LoanPayMapper {
	/**
	 * 按主键删除
	 * @since 2017-05-05 09:36:25
	 */
	int deleteByPrimaryKey(Integer lpId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-05-05 09:36:25
	 */
	int insert(LoanPay record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-05-05 09:36:25
	 */
	int insertSelective(LoanPay record);

	/**
	 * 按主键查询
	 * @since 2017-05-05 09:36:25
	 */
	LoanPay selectByPrimaryKey(Integer lpId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-05-05 09:36:25
	 */
	int updateByPrimaryKeySelective(LoanPay record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-05-05 09:36:25
	 */
	int updateByPrimaryKey(LoanPay record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-05-05 09:36:25
	 */
	List<LoanPay> selectByCriteria(Criteria<LoanPay> criteria);
}