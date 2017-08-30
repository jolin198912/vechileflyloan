package cn.houhe.api.loan.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.loan.entity.AuditPerson;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：audit_person
 * @since 2017-04-07 18:44:32
 */
public interface AuditPersonMapper {
	/**
	 * 按主键删除
	 * @since 2017-04-07 18:44:32
	 */
	int deleteByPrimaryKey(Integer apId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-04-07 18:44:32
	 */
	int insert(AuditPerson record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-04-07 18:44:32
	 */
	int insertSelective(AuditPerson record);

	/**
	 * 按主键查询
	 * @since 2017-04-07 18:44:32
	 */
	AuditPerson selectByPrimaryKey(Integer apId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-04-07 18:44:32
	 */
	int updateByPrimaryKeySelective(AuditPerson record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-04-07 18:44:32
	 */
	int updateByPrimaryKey(AuditPerson record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-04-07 18:44:32
	 */
	List<AuditPerson> selectByCriteria(Criteria<AuditPerson> criteria);
}