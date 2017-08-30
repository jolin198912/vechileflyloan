package cn.houhe.api.log.mapper;

import cn.houhe.api.log.entity.MessageExt;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：message
 * @since 2017-05-06 15:11:19
 */
public interface MessageExtMapper {
	/**
	 * 获取通知消息列表
	 * @since 2017-05-06 15:11:19
	 */
	List<MessageExt> selectMessageList(MessageExt message);
}