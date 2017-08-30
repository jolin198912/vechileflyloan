package cn.houhe.api.config.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.ServiceOperationException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.config.entity.DistributionConfig;
import cn.houhe.api.config.mapper.DistributionConfigMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 业务实现层 - 表：distribution__config
 * @since 2017-05-24 11:08:35
 */
@Service("distributionConfigExtService")
public class DistributionConfigExtService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private DistributionConfigMapper distributionConfigMapper;

	@Transactional
	public void addOrUpdate(DistributionConfig dto) throws ServiceException {
		try {
			dto.setDistributionType(Byte.parseByte("0"));
			dto.setType(Byte.parseByte("0"));
			if (dto.getPcId() != null && dto.getPcId() > 0) {//更新
				distributionConfigMapper.updateByPrimaryKeySelective(dto);
			}else {//新增
				distributionConfigMapper.insertSelective(dto);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public DistributionConfig getById() throws ServiceException {
		try {
			Criteria<DistributionConfig> criteria = Criteria.create(DistributionConfig.class);
			criteria.setPageSize(2);
			criteria.setCurrentPage(1);
			List<DistributionConfig> list = distributionConfigMapper.selectByCriteria(criteria);
			DistributionConfig distconfig = distributionConfigMapper.selectByPrimaryKey(list.get(0).getPcId());
			if (distconfig == null)
				throw new ServiceOperationException("参数配置信息不存在");
			return distconfig;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}