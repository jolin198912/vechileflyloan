package cn.houhe.api.loan.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.loan.entity.AuthorizeInfo;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：authorize_info
 * @since 2017-04-20 16:50:02
 */
public interface AuthorizeInfoMapper {
	/**
	 * 按主键删除
	 * @since 2017-04-20 16:50:02
	 */
	int deleteByPrimaryKey(Integer aiId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-04-20 16:50:02
	 */
	int insert(AuthorizeInfo record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-04-20 16:50:02
	 */
	int insertSelective(AuthorizeInfo record);

	/**
	 * 按主键查询
	 * @since 2017-04-20 16:50:02
	 */
	AuthorizeInfo selectByPrimaryKey(Integer aiId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-04-20 16:50:02
	 */
	int updateByPrimaryKeySelective(AuthorizeInfo record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-04-20 16:50:02
	 */
	int updateByPrimaryKey(AuthorizeInfo record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-04-20 16:50:02
	 */
	List<AuthorizeInfo> selectByCriteria(Criteria<AuthorizeInfo> criteria);
}