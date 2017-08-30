package cn.houhe.api.loan.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.loan.entity.LoanAudit;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：loan_audit
 * @since 2017-04-20 16:33:40
 */
public interface LoanAuditMapper {
	/**
	 * 按主键删除
	 * @since 2017-04-20 16:33:40
	 */
	int deleteByPrimaryKey(Integer laId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-04-20 16:33:40
	 */
	int insert(LoanAudit record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-04-20 16:33:40
	 */
	int insertSelective(LoanAudit record);

	/**
	 * 按主键查询
	 * @since 2017-04-20 16:33:40
	 */
	LoanAudit selectByPrimaryKey(Integer laId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-04-20 16:33:40
	 */
	int updateByPrimaryKeySelective(LoanAudit record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-04-20 16:33:40
	 */
	int updateByPrimaryKey(LoanAudit record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-04-20 16:33:40
	 */
	List<LoanAudit> selectByCriteria(Criteria<LoanAudit> criteria);
}