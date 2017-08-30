package cn.houhe.api.config.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.config.entity.Advertisement;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：advertisement
 * @since 2017-03-30 10:04:06
 */
public interface AdvertisementMapper {
	/**
	 * 按主键删除
	 * @since 2017-03-30 10:04:06
	 */
	int deleteByPrimaryKey(Integer adId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-03-30 10:04:06
	 */
	int insert(Advertisement record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-03-30 10:04:06
	 */
	int insertSelective(Advertisement record);

	/**
	 * 按主键查询
	 * @since 2017-03-30 10:04:06
	 */
	Advertisement selectByPrimaryKey(Integer adId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-03-30 10:04:06
	 */
	int updateByPrimaryKeySelective(Advertisement record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-03-30 10:04:06
	 */
	int updateByPrimaryKey(Advertisement record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-03-30 10:04:06
	 */
	List<Advertisement> selectByCriteria(Criteria<Advertisement> criteria);
}