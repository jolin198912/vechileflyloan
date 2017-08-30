package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.loan.entity.LoanAudit;
import cn.houhe.api.loan.mapper.LoanAuditMapper;
import java.io.Serializable;
import java.util.*;
import javax.annotation.Resource;

import cn.houhe.api.user.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：loan_audit
 * @since 2017-04-10 14:50:44
 */
@Service("loanAuditService")
public class LoanAuditService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private LoanAuditMapper loanAuditMapper;

	@Autowired
	private UserinfoService userinfoService;

	public void insert(LoanAudit entity) throws ServiceException {
		try {
			loanAuditMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(LoanAudit entity) throws ServiceException {
		try {
			loanAuditMapper.deleteByPrimaryKey(entity.getLaId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				loanAuditMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(LoanAudit entity) throws ServiceException {
		try {
			loanAuditMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(LoanAudit entity) throws ServiceException {
		try {
			loanAuditMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public LoanAudit findByPrimaryKey(Integer laId) throws ServiceException {
		try {
			return loanAuditMapper.selectByPrimaryKey(laId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<LoanAudit> findPage(Criteria<LoanAudit> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(LoanAudit.class);
			}
			criteria.pagination(true);
			List<LoanAudit> list = loanAuditMapper.selectByCriteria(criteria);
			return new Pager<LoanAudit>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<LoanAudit> findAll(Criteria<LoanAudit> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(LoanAudit.class);
			}
			criteria.pagination(false);
			return loanAuditMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * 返回审核分配人
	 * @return
	 */
	public Map getLoanFirstPlanAuditPerson() {
		return Optional.ofNullable(getPlanAuditPerson("loan_approve_first")).orElse(getPlanAuditPerson("loan_approve_admin")) ;
	}

	public Map getLoanLastPlanAuditPerson() {
		return  Optional.ofNullable(getPlanAuditPerson("loan_approve_last")).orElse(getPlanAuditPerson("loan_approve_admin")) ;
	}

	public Map getCreditFirstPlanAuditPerson() {
		return  Optional.ofNullable(getPlanAuditPerson("credit_approve_first")).orElse(getPlanAuditPerson("credit_approve_admin")) ;
	}

	public Map getCreditLastPlanAuditPerson() {
		return  Optional.ofNullable(getPlanAuditPerson("credit_approve_last")).orElse(getPlanAuditPerson("credit_approve_admin")) ;
	}


	private Map getPlanAuditPerson(String... resCode){
		List<Map> users = new ArrayList<>();
		for (String s : resCode) {
			users.addAll(userinfoService.getAuditPerson(s));
		}
		int size = users.size();
		if (size == 0){//没有审核人时，分配为管理员
			return null;
		}
		Random random = new Random();
		int index = random.nextInt(size);
		if (index >= size){
			index = index - 1;
		}
		return users.get(index);
	}
}