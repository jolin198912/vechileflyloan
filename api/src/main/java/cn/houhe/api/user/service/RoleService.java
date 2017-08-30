package cn.houhe.api.user.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.Expression;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.user.entity.Role;
import cn.houhe.api.user.entity.RoleResourceExt;
import cn.houhe.api.user.mapper.RoleMapper;
import cn.houhe.api.user.mapper.RoleExtMapper;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;

import cn.houhe.api.user.web.bo.RoleResouDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - ：role
 *
 * @since 2017-03-30 13:50:02
 */
@Service("roleService")
public class RoleService implements Serializable {
    private static final long serialVersionUID = 1L;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RoleExtMapper roleExtMapper;

    public void insert(Role entity) throws ServiceException {
        try {
            roleMapper.insert(entity);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void insertSelective(Role entity) throws ServiceException {
        try {
            roleMapper.insertSelective(entity);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void delete(Role entity) throws ServiceException {
        try {
            roleMapper.deleteByPrimaryKey(entity.getRoleid());
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Transactional
    public void batchDelete(List<Integer> ids) throws ServiceException {
        try {
            for (Integer id : ids) {
                roleMapper.deleteByPrimaryKey(id);
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void update(Role entity) throws ServiceException {
        try {
            roleMapper.updateByPrimaryKey(entity);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void updateSelective(Role entity) throws ServiceException {
        try {
            roleMapper.updateByPrimaryKeySelective(entity);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public Role findByPrimaryKey(Integer roleid) throws ServiceException {
        try {
            return roleMapper.selectByPrimaryKey(roleid);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public RoleResouDto selectForRole(Integer role_id) throws ServiceException {
        try {
            return roleExtMapper.selectForRole(role_id);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }


    public Pager<Role> findPage(Criteria<Role> criteria) throws ServiceException {
        try {
            if (criteria == null) {
                criteria = Criteria.create(Role.class);
            }
            criteria.pagination(true);
            List<Role> list = roleMapper.selectByCriteria(criteria);
            return new Pager<Role>(criteria, list);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<Role> findAll(Criteria<Role> criteria) throws ServiceException {
        try {
            if (criteria == null) {
                criteria = Criteria.create(Role.class);
            }
            criteria.pagination(false);
            return roleMapper.selectByCriteria(criteria);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Transactional
    public void assignResource(Integer roleid, List<RoleResourceExt> list) throws ServiceException {
        try {
            roleExtMapper.deleteResource(roleid);
            roleExtMapper.batchAssignRes(list);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}