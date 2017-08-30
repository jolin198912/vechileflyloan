package cn.houhe.api.log.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.log.entity.MessageSms;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：message_sms
 * @since 2017-05-25 14:44:55
 */
public interface MessageSmsMapper {
	/**
	 * 按主键删除
	 * @since 2017-05-25 14:44:55
	 */
	int deleteByPrimaryKey(Integer mid);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-05-25 14:44:55
	 */
	int insert(MessageSms record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-05-25 14:44:55
	 */
	int insertSelective(MessageSms record);

	/**
	 * 按主键查询
	 * @since 2017-05-25 14:44:55
	 */
	MessageSms selectByPrimaryKey(Integer mid);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-05-25 14:44:55
	 */
	int updateByPrimaryKeySelective(MessageSms record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-05-25 14:44:55
	 */
	int updateByPrimaryKey(MessageSms record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-05-25 14:44:55
	 */
	List<MessageSms> selectByCriteria(Criteria<MessageSms> criteria);
}