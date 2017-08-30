package cn.houhe.api.member.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.member.entity.RegisterRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：register_record
 * @since 2017-04-14 11:59:03
 */
@Repository
public interface RegisterRecordMapper {
	/**
	 * 按主键删除
	 * @since 2017-04-14 11:59:03
	 */
	int deleteByPrimaryKey(Integer rrId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-04-14 11:59:03
	 */
	int insert(RegisterRecord record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-04-14 11:59:03
	 */
	int insertSelective(RegisterRecord record);

	/**
	 * 按主键查询
	 * @since 2017-04-14 11:59:03
	 */
	RegisterRecord selectByPrimaryKey(Integer rrId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-04-14 11:59:03
	 */
	int updateByPrimaryKeySelective(RegisterRecord record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-04-14 11:59:03
	 */
	int updateByPrimaryKey(RegisterRecord record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-04-14 11:59:03
	 */
	List<RegisterRecord> selectByCriteria(Criteria<RegisterRecord> criteria);
}