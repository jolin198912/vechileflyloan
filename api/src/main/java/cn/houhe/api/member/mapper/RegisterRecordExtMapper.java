package cn.houhe.api.member.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.member.entity.RegisterRecord;
import cn.houhe.api.member.entity.RegisterRecordExt;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：register_record
 * @since 2017-04-14 11:59:03
 */
@Repository
public interface RegisterRecordExtMapper {
	/*
	* 未注册成功的用户列表
	*/
	List<RegisterRecordExt> findPageData(RegisterRecordExt registerRecordExt);

	Integer getCount(RegisterRecordExt registerRecordExt);

	/**
	 * 插入 - 保存非null字段
	 * @since 2017-04-14 11:59:03
	 */
	int insert(RegisterRecordExt record);

	/**
	 * 按手机号查询
	 * @since 2017-04-14 11:59:03
	 */
	RegisterRecordExt selectByMobile(@Param("mobile") String mobile);

	RegisterRecordExt selectRecordByMobile(@Param("mobile") String mobile);
}