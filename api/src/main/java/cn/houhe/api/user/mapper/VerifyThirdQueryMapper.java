package cn.houhe.api.user.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.user.entity.VerifyThirdQuery;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：verify_third_query
 * @since 2017-06-07 10:58:25
 */
public interface VerifyThirdQueryMapper {
	/**
	 * 按主键删除
	 * @since 2017-06-07 10:58:25
	 */
	int deleteByPrimaryKey(Integer qid);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-06-07 10:58:25
	 */
	int insert(VerifyThirdQuery record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-06-07 10:58:25
	 */
	int insertSelective(VerifyThirdQuery record);

	/**
	 * 按主键查询
	 * @since 2017-06-07 10:58:25
	 */
	VerifyThirdQuery selectByPrimaryKey(Integer qid);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-06-07 10:58:25
	 */
	int updateByPrimaryKeySelective(VerifyThirdQuery record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-06-07 10:58:25
	 */
	int updateByPrimaryKey(VerifyThirdQuery record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-06-07 10:58:25
	 */
	List<VerifyThirdQuery> selectByCriteria(Criteria<VerifyThirdQuery> criteria);
}