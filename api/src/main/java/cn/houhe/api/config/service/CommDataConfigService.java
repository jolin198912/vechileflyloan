package cn.houhe.api.config.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.config.entity.CommDataConfig;
import cn.houhe.api.config.mapper.CommDataConfigExtMapper;
import cn.houhe.api.config.mapper.CommDataConfigMapper;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：comm_data_config
 * @since 2017-04-13 11:30:10
 */
@Service("commDataConfigService")
public class CommDataConfigService implements Serializable {
	private static final long serialVersionUID = 1L;

	private Logger logger = LoggerFactory.getLogger(CommDataConfig.class);

	@Resource
	private CommDataConfigMapper commDataConfigMapper;

	@Resource
	private CommDataConfigExtMapper commDataConfigExtMapper;

	public ResultDto findMenuItems(Byte menuType) throws ServiceException {
		ResultDto result = new ResultDto();
		result.setMsg("获取文化程度或单位性质");
		try {
			List<HashMap> menuItems = commDataConfigExtMapper.selectMenuItems(menuType);
			if (CollectionUtils.isNotEmpty(menuItems)) {
				result.setCode("0");
				result.setData(menuItems);
			}else {
				result.setCode("1");
				result.setMsg("未获取到菜单项相关信息");
			}
		}catch (Exception e) {
			result.setCode("-1");
			result.setMsg(e.getMessage());
			logger.error(e.getMessage(),e);
		}
		return result;
	}

	public void insert(CommDataConfig entity) throws ServiceException {
		try {
			commDataConfigMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(CommDataConfig entity) throws ServiceException {
		try {
			commDataConfigMapper.deleteByPrimaryKey(entity.getMenuId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Short> ids) throws ServiceException {
		try {
			for (Short id : ids) {
				commDataConfigMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(CommDataConfig entity) throws ServiceException {
		try {
			commDataConfigMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(CommDataConfig entity) throws ServiceException {
		try {
			commDataConfigMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public CommDataConfig findByPrimaryKey(Short menuId) throws ServiceException {
		try {
			return commDataConfigMapper.selectByPrimaryKey(menuId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<CommDataConfig> findPage(Criteria<CommDataConfig> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(CommDataConfig.class);
			}
			criteria.pagination(true);
			List<CommDataConfig> list = commDataConfigMapper.selectByCriteria(criteria);
			return new Pager<CommDataConfig>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<CommDataConfig> findAll(Criteria<CommDataConfig> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(CommDataConfig.class);
			}
			criteria.pagination(false);
			return commDataConfigMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}