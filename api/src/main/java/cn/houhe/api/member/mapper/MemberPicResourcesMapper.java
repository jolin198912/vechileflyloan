package cn.houhe.api.member.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.member.entity.MemberPicResources;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：member_pic_resources
 * @since 2017-03-30 10:12:39
 */
public interface MemberPicResourcesMapper {
	/**
	 * 按主键删除
	 * @since 2017-03-30 10:12:39
	 */
	int deleteByPrimaryKey(Integer memresid);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-03-30 10:12:39
	 */
	int insert(MemberPicResources record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-03-30 10:12:39
	 */
	int insertSelective(MemberPicResources record);

	/**
	 * 按主键查询
	 * @since 2017-03-30 10:12:39
	 */
	MemberPicResources selectByPrimaryKey(Integer memresid);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-03-30 10:12:39
	 */
	int updateByPrimaryKeySelective(MemberPicResources record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-03-30 10:12:39
	 */
	int updateByPrimaryKey(MemberPicResources record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-03-30 10:12:39
	 */
	List<MemberPicResources> selectByCriteria(Criteria<MemberPicResources> criteria);
}