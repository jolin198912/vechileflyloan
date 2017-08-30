package cn.houhe.api.loan.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.loan.entity.Creditinfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：creditinfo
 * @since 2017-04-20 16:30:33
 */
@Repository
public interface CreditinfoMapper {
	/**
	 * 按主键删除
	 * @since 2017-04-20 16:30:33
	 */
	int deleteByPrimaryKey(Integer cdId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-04-20 16:30:33
	 */
	int insert(Creditinfo record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-04-20 16:30:33
	 */
	int insertSelective(Creditinfo record);

	/**
	 * 按主键查询
	 * @since 2017-04-20 16:30:33
	 */
	Creditinfo selectByPrimaryKey(Integer cdId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-04-20 16:30:33
	 */
	int updateByPrimaryKeySelective(Creditinfo record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-04-20 16:30:33
	 */
	int updateByPrimaryKey(Creditinfo record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-04-20 16:30:33
	 */
	List<Creditinfo> selectByCriteria(Criteria<Creditinfo> criteria);
}