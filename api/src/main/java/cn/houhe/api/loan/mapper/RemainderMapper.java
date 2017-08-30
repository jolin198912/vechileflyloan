package cn.houhe.api.loan.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.loan.entity.Remainder;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：remainder
 * @since 2017-04-25 16:44:11
 */
public interface RemainderMapper {
	/**
	 * 按主键删除
	 * @since 2017-04-25 16:44:11
	 */
	int deleteByPrimaryKey(Integer rmdId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-04-25 16:44:11
	 */
	int insert(Remainder record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-04-25 16:44:11
	 */
	int insertSelective(Remainder record);

	/**
	 * 按主键查询
	 * @since 2017-04-25 16:44:11
	 */
	Remainder selectByPrimaryKey(Integer rmdId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-04-25 16:44:11
	 */
	int updateByPrimaryKeySelective(Remainder record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-04-25 16:44:11
	 */
	int updateByPrimaryKey(Remainder record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-04-25 16:44:11
	 */
	List<Remainder> selectByCriteria(Criteria<Remainder> criteria);
}