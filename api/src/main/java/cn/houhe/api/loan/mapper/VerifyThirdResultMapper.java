package cn.houhe.api.loan.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.loan.entity.VerifyThirdResult;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：verify_third_result
 * @since 2017-05-23 19:42:13
 */
public interface VerifyThirdResultMapper {
	/**
	 * 按主键删除
	 * @since 2017-05-23 19:42:13
	 */
	int deleteByPrimaryKey(Integer vtrId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-05-23 19:42:13
	 */
	int insert(VerifyThirdResult record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-05-23 19:42:13
	 */
	int insertSelective(VerifyThirdResult record);

	/**
	 * 按主键查询
	 * @since 2017-05-23 19:42:13
	 */
	VerifyThirdResult selectByPrimaryKey(Integer vtrId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-05-23 19:42:13
	 */
	int updateByPrimaryKeySelective(VerifyThirdResult record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-05-23 19:42:13
	 */
	int updateByPrimaryKey(VerifyThirdResult record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-05-23 19:42:13
	 */
	List<VerifyThirdResult> selectByCriteria(Criteria<VerifyThirdResult> criteria);
}