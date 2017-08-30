package cn.houhe.api.loan.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.loan.entity.CreditChildren;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：credit_children
 * @since 2017-05-12 11:34:16
 */
public interface CreditChildrenMapper {
	/**
	 * 按主键删除
	 * @since 2017-05-12 11:34:16
	 */
	int deleteByPrimaryKey(Integer ccdId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-05-12 11:34:16
	 */
	int insert(CreditChildren record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-05-12 11:34:16
	 */
	int insertSelective(CreditChildren record);

	/**
	 * 按主键查询
	 * @since 2017-05-12 11:34:16
	 */
	CreditChildren selectByPrimaryKey(Integer ccdId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-05-12 11:34:16
	 */
	int updateByPrimaryKeySelective(CreditChildren record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-05-12 11:34:16
	 */
	int updateByPrimaryKey(CreditChildren record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-05-12 11:34:16
	 */
	List<CreditChildren> selectByCriteria(Criteria<CreditChildren> criteria);
}