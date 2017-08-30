package cn.houhe.api.loan.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.loan.entity.DebitRcd;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：debit_rcd
 * @since 2017-05-06 17:24:46
 */
@Repository
public interface DebitRcdMapper {
	/**
	 * 按主键删除
	 * @since 2017-05-06 17:24:46
	 */
	int deleteByPrimaryKey(Integer drId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-05-06 17:24:46
	 */
	int insert(DebitRcd record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-05-06 17:24:46
	 */
	int insertSelective(DebitRcd record);

	/**
	 * 按主键查询
	 * @since 2017-05-06 17:24:46
	 */
	DebitRcd selectByPrimaryKey(Integer drId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-05-06 17:24:46
	 */
	int updateByPrimaryKeySelective(DebitRcd record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-05-06 17:24:46
	 */
	int updateByPrimaryKey(DebitRcd record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-05-06 17:24:46
	 */
	List<DebitRcd> selectByCriteria(Criteria<DebitRcd> criteria);
}