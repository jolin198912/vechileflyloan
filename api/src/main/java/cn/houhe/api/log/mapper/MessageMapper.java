package cn.houhe.api.log.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.log.entity.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：message
 * @since 2017-04-10 11:10:03
 */
@Repository
public interface MessageMapper {
	/**
	 * 按主键删除
	 * @since 2017-04-10 11:10:03
	 */
	int deleteByPrimaryKey(Integer mid);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-04-10 11:10:03
	 */
	int insert(Message record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-04-10 11:10:03
	 */
	int insertSelective(Message record);

	/**
	 * 按主键查询
	 * @since 2017-04-10 11:10:03
	 */
	Message selectByPrimaryKey(Integer mid);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-04-10 11:10:03
	 */
	int updateByPrimaryKeySelective(Message record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-04-10 11:10:03
	 */
	int updateByPrimaryKey(Message record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-04-10 11:10:03
	 */
	List<Message> selectByCriteria(Criteria<Message> criteria);
}