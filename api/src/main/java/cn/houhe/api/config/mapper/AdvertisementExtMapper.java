package cn.houhe.api.config.mapper;

import cn.houhe.api.config.entity.Advertisement;
import cn.houhe.api.config.entity.AdvertisementExt;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：advertisement
 * @since 2017-03-30 10:04:06
 */
public interface AdvertisementExtMapper {
	/**
	 * 上下架广告
	 * @since 2017-03-30 10:04:06
	 */
	int updateStatus(AdvertisementExt record);

	/**
	 * 广告列表
	 * @since 2017-03-30 10:04:06
	 */
	List<AdvertisementExt> selectAdvList();
}