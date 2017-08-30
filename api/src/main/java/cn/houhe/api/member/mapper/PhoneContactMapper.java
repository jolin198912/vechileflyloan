package cn.houhe.api.member.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.member.entity.PhoneContact;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：phone_contact
 * @since 2017-05-03 15:07:07
 */
public interface PhoneContactMapper {
	/**
	 * 按主键删除
	 * @since 2017-05-03 15:07:07
	 */
	int deleteByPrimaryKey(Integer pcId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-05-03 15:07:07
	 */
	int insert(PhoneContact record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-05-03 15:07:07
	 */
	int insertSelective(PhoneContact record);

	/**
	 * 按主键查询
	 * @since 2017-05-03 15:07:07
	 */
	PhoneContact selectByPrimaryKey(Integer pcId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-05-03 15:07:07
	 */
	int updateByPrimaryKeySelective(PhoneContact record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-05-03 15:07:07
	 */
	int updateByPrimaryKey(PhoneContact record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-05-03 15:07:07
	 */
	List<PhoneContact> selectByCriteria(Criteria<PhoneContact> criteria);
}