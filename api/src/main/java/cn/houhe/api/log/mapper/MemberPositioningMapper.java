package cn.houhe.api.log.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.log.entity.MemberPositioning;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：member_positioning
 * @since 2017-04-10 11:10:03
 */
public interface MemberPositioningMapper {
	/**
	 * 按主键删除
	 * @since 2017-04-10 11:10:03
	 */
	int deleteByPrimaryKey(Integer memposid);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-04-10 11:10:03
	 */
	int insert(MemberPositioning record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-04-10 11:10:03
	 */
	int insertSelective(MemberPositioning record);

	/**
	 * 按主键查询
	 * @since 2017-04-10 11:10:03
	 */
	MemberPositioning selectByPrimaryKey(Integer memposid);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-04-10 11:10:03
	 */
	int updateByPrimaryKeySelective(MemberPositioning record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-04-10 11:10:03
	 */
	int updateByPrimaryKey(MemberPositioning record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-04-10 11:10:03
	 */
	List<MemberPositioning> selectByCriteria(Criteria<MemberPositioning> criteria);
}