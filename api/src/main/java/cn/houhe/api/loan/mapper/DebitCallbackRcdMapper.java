package cn.houhe.api.loan.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.loan.entity.DebitCallbackRcd;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：debit_callback_rcd
 * @since 2017-04-27 10:38:09
 */
public interface DebitCallbackRcdMapper {
	/**
	 * 按主键删除
	 * @since 2017-04-27 10:38:09
	 */
	int deleteByPrimaryKey(Integer dcrId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-04-27 10:38:09
	 */
	int insert(DebitCallbackRcd record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-04-27 10:38:09
	 */
	int insertSelective(DebitCallbackRcd record);

	/**
	 * 按主键查询
	 * @since 2017-04-27 10:38:09
	 */
	DebitCallbackRcd selectByPrimaryKey(Integer dcrId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-04-27 10:38:09
	 */
	int updateByPrimaryKeySelective(DebitCallbackRcd record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-04-27 10:38:09
	 */
	int updateByPrimaryKey(DebitCallbackRcd record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-04-27 10:38:09
	 */
	List<DebitCallbackRcd> selectByCriteria(Criteria<DebitCallbackRcd> criteria);
}