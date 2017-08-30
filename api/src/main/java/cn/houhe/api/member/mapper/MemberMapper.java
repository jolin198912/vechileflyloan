package cn.houhe.api.member.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.member.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：member
 * @since 2017-05-11 19:05:33
 */
@Repository
public interface MemberMapper {
	/**
	 * 按主键删除
	 * @since 2017-05-11 19:05:33
	 */
	int deleteByPrimaryKey(Integer memid);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-05-11 19:05:33
	 */
	int insert(Member record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-05-11 19:05:33
	 */
	int insertSelective(Member record);

	/**
	 * 按主键查询
	 * @since 2017-05-11 19:05:33
	 */
	Member selectByPrimaryKey(Integer memid);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-05-11 19:05:33
	 */
	int updateByPrimaryKeySelective(Member record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-05-11 19:05:33
	 */
	int updateByPrimaryKey(Member record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-05-11 19:05:33
	 */
	List<Member> selectByCriteria(Criteria<Member> criteria);
}