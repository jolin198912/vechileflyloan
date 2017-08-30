package cn.houhe.api.loan.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.loan.entity.VerifyInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：verify_info
 * @since 2017-05-23 11:06:38
 */
@Repository
public interface VerifyInfoMapper {
	/**
	 * 按主键删除
	 * @since 2017-05-23 11:06:38
	 */
	int deleteByPrimaryKey(Integer vfiId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-05-23 11:06:38
	 */
	int insert(VerifyInfo record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-05-23 11:06:38
	 */
	int insertSelective(VerifyInfo record);

	/**
	 * 按主键查询
	 * @since 2017-05-23 11:06:38
	 */
	VerifyInfo selectByPrimaryKey(Integer vfiId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-05-23 11:06:38
	 */
	int updateByPrimaryKeySelective(VerifyInfo record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-05-23 11:06:38
	 */
	int updateByPrimaryKey(VerifyInfo record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-05-23 11:06:38
	 */
	List<VerifyInfo> selectByCriteria(Criteria<VerifyInfo> criteria);
}