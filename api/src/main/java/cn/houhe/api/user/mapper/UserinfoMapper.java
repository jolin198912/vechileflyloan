package cn.houhe.api.user.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.user.entity.Userinfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 鐢ㄦ埛琛�：userinfo
 * @since 2017-03-30 13:50:02
 */
@Repository
public interface UserinfoMapper {
	/**
	 * 按主键删除
	 * @since 2017-03-30 13:50:02
	 */
	int deleteByPrimaryKey(Integer usid);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-03-30 13:50:02
	 */
	int insert(Userinfo record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-03-30 13:50:02
	 */
	int insertSelective(Userinfo record);

	/**
	 * 按主键查询
	 * @since 2017-03-30 13:50:02
	 */
	Userinfo selectByPrimaryKey(Integer usid);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-03-30 13:50:02
	 */
	int updateByPrimaryKeySelective(Userinfo record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-03-30 13:50:02
	 */
	int updateByPrimaryKey(Userinfo record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-03-30 13:50:02
	 */
	List<Userinfo> selectByCriteria(Criteria<Userinfo> criteria);
}