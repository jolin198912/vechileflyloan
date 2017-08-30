package cn.houhe.api.log.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.log.entity.Message;
import cn.houhe.api.log.mapper.MessageMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：message
 * @since 2017-04-07 14:30:23
 */
@Service("messageService")
public class MessageService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private MessageMapper messageMapper;

	public void insert(Message entity) throws ServiceException {
		try {
			messageMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void insertSelective(Message entity) throws ServiceException {
		try {
			messageMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(Message entity) throws ServiceException {
		try {
			messageMapper.deleteByPrimaryKey(entity.getMid());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				messageMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(Message entity) throws ServiceException {
		try {
			messageMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(Message entity) throws ServiceException {
		try {
			messageMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Message findByPrimaryKey(Integer mid) throws ServiceException {
		try {
			return messageMapper.selectByPrimaryKey(mid);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<Message> findPage(Criteria<Message> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(Message.class);
			}
			criteria.pagination(true);
			List<Message> list = messageMapper.selectByCriteria(criteria);
			return new Pager<Message>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<Message> findAll(Criteria<Message> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(Message.class);
			}
			criteria.pagination(false);
			return messageMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}