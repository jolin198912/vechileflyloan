package cn.houhe.api.member.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.member.entity.BankCard;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：bank_card
 * @since 2017-03-30 10:12:39
 */
public interface BankCardMapper {
	/**
	 * 按主键删除
	 * @since 2017-03-30 10:12:39
	 */
	int deleteByPrimaryKey(Integer bcid);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-03-30 10:12:39
	 */
	int insert(BankCard record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-03-30 10:12:39
	 */
	int insertSelective(BankCard record);

	/**
	 * 按主键查询
	 * @since 2017-03-30 10:12:39
	 */
	BankCard selectByPrimaryKey(Integer bcid);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-03-30 10:12:39
	 */
	int updateByPrimaryKeySelective(BankCard record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-03-30 10:12:39
	 */
	int updateByPrimaryKey(BankCard record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-03-30 10:12:39
	 */
	List<BankCard> selectByCriteria(Criteria<BankCard> criteria);
}