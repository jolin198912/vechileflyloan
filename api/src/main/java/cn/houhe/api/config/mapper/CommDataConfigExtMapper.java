package cn.houhe.api.config.mapper;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：comm_data_config
 * @since 2017-04-13 11:30:10
 */
@Repository public interface CommDataConfigExtMapper {
	/**
	 * 按照菜单类型查找菜单项
	 */
	List<HashMap> selectMenuItems(Byte menuType);
}