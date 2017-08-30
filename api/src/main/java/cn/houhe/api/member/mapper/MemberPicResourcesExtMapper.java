package cn.houhe.api.member.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.member.entity.MemberPicResources;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：member_pic_resources
 * @since 2017-03-30 10:12:39
 */
public interface MemberPicResourcesExtMapper {
	/**
	 * 按会员id查询
	 * @since 2017-03-30 10:12:39
	 */
	MemberPicResources selectPicByMemberId(Integer memberId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-03-30 10:12:39
	 */
	int insertHeadPic(MemberPicResources record);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-03-30 10:12:39
	 */
	int updateHeadPicByMemberId(MemberPicResources record);
}