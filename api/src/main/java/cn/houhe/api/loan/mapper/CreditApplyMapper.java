package cn.houhe.api.loan.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.loan.entity.CreditApply;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：credit_apply
 * @since 2017-06-05 10:38:33
 */
@Repository
public interface CreditApplyMapper {
	/**
	 * 按主键删除
	 * @since 2017-06-05 10:38:33
	 */
	int deleteByPrimaryKey(Integer caId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-06-05 10:38:33
	 */
	int insert(CreditApply record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-06-05 10:38:33
	 */
	int insertSelective(CreditApply record);

	/**
	 * 按主键查询
	 * @since 2017-06-05 10:38:33
	 */
	CreditApply selectByPrimaryKey(Integer caId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-06-05 10:38:33
	 */
	int updateByPrimaryKeySelective(CreditApply record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-06-05 10:38:33
	 */
	int updateByPrimaryKey(CreditApply record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-06-05 10:38:33
	 */
	List<CreditApply> selectByCriteria(Criteria<CreditApply> criteria);
}