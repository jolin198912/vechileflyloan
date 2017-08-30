package cn.houhe.api.member.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.member.entity.BankCard;
import cn.houhe.api.member.entity.Member;
import cn.houhe.api.member.mapper.BankCardMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：bank_card
 * @since 2017-03-30 10:12:39
 */
@Service("bankCardService")
public class BankCardService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private BankCardMapper bankCardMapper;

	public void insert(BankCard entity) throws ServiceException {
		try {
			bankCardMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void insertSelective(BankCard entity) throws ServiceException {
		try {
			bankCardMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(BankCard entity) throws ServiceException {
		try {
			bankCardMapper.deleteByPrimaryKey(entity.getBcid());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				bankCardMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(BankCard entity) throws ServiceException {
		try {
			bankCardMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(BankCard entity) throws ServiceException {
		try {
			bankCardMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public BankCard findByPrimaryKey(Integer bcid) throws ServiceException {
		try {
			return bankCardMapper.selectByPrimaryKey(bcid);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<BankCard> findPage(Criteria<BankCard> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(BankCard.class);
			}
			criteria.pagination(true);
			List<BankCard> list = bankCardMapper.selectByCriteria(criteria);
			return new Pager<BankCard>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<BankCard> findAll(Criteria<BankCard> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(BankCard.class);
			}
			criteria.pagination(false);
			return bankCardMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}