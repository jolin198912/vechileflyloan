package cn.houhe.api.loan.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.loan.entity.PayRequestRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：pay_request_record
 * @since 2017-05-03 15:31:46
 */
@Repository
public interface PayRequestRecordMapper {
	/**
	 * 按主键删除
	 * @since 2017-05-03 15:31:46
	 */
	int deleteByPrimaryKey(Integer prId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-05-03 15:31:46
	 */
	int insert(PayRequestRecord record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-05-03 15:31:46
	 */
	int insertSelective(PayRequestRecord record);

	/**
	 * 按主键查询
	 * @since 2017-05-03 15:31:46
	 */
	PayRequestRecord selectByPrimaryKey(Integer prId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-05-03 15:31:46
	 */
	int updateByPrimaryKeySelective(PayRequestRecord record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-05-03 15:31:46
	 */
	int updateByPrimaryKey(PayRequestRecord record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-05-03 15:31:46
	 */
	List<PayRequestRecord> selectByCriteria(Criteria<PayRequestRecord> criteria);
}