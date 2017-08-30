package cn.houhe.api.config.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.config.entity.IssueType;
import cn.houhe.api.config.entity.IssueTypeExt;
import cn.houhe.api.config.mapper.IssueTypeExtMapper;
import cn.houhe.api.config.mapper.IssueTypeMapper;
import cn.houhe.api.config.mapper.IssuesExtMapper;
import cn.houhe.api.config.web.bo.IssueAppDto;
import cn.houhe.api.config.web.bo.IssueCatDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 业务实现层 - 表：issue_type
 *
 * @since 2017-03-30 10:04:06
 */
@Service("issueTypeService")
public class IssueTypeService implements Serializable {
    private static final long serialVersionUID = 1L;

    @Resource
    private IssueTypeMapper issueTypeMapper;

    @Resource
    private IssueTypeExtMapper issueTypeExtMapper;

    @Resource
    private IssuesExtMapper issuesExtMapper;

    public void insert(IssueType entity) throws ServiceException {
        try {
            issueTypeMapper.insert(entity);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void insertSelective(IssueType entity) throws ServiceException {
        try {
            issueTypeMapper.insertSelective(entity);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void delete(IssueType entity) throws ServiceException {
        try {
            issueTypeMapper.deleteByPrimaryKey(entity.getItId());
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Transactional
    public void batchDelete(List<Short> ids) throws ServiceException {
        try {
            for (Short id : ids) {
                issueTypeMapper.deleteByPrimaryKey(id);
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void update(IssueType entity) throws ServiceException {
        try {
            issueTypeMapper.updateByPrimaryKey(entity);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void updateSelective(IssueType entity) throws ServiceException {
        try {
            issueTypeMapper.updateByPrimaryKeySelective(entity);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public IssueType findByPrimaryKey(Short itId) throws ServiceException {
        try {
            return issueTypeMapper.selectByPrimaryKey(itId);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public Pager<IssueType> findPage(Criteria<IssueType> criteria) throws ServiceException {
        try {
            if (criteria == null) {
                criteria = Criteria.create(IssueType.class);
            }
            criteria.pagination(true);
            List<IssueType> list = issueTypeMapper.selectByCriteria(criteria);
            return new Pager<IssueType>(criteria, list);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<IssueType> findAll(Criteria<IssueType> criteria) throws ServiceException {
        try {
            if (criteria == null) {
                criteria = Criteria.create(IssueType.class);
            }
            criteria.pagination(false);
            return issueTypeMapper.selectByCriteria(criteria);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<IssueTypeExt> GetAll() throws ServiceException {
        try {
            return issueTypeExtMapper.GetAll();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<IssueTypeExt> GetIssuesTypeUsing(Short id) throws ServiceException {
        try {
            return issueTypeExtMapper.GetIssuesTypeUsing(id);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * 获取所有问题分类（每个分类下面返回两条）
     *
     * @return
     */
    public ResultDto getCatIsuessLimit2() {
        ResultDto dto = new ResultDto("0", "查询问题列表");
        List<IssueCatDto> res = issueTypeExtMapper.getCatIssues(0);
        for (IssueCatDto item : res) {
            IssueAppDto wdto = new IssueAppDto();
            wdto.issueTypeId = item.id;
            wdto.page = 0;
            wdto.rows = 2;
            item.list = issuesExtMapper.findCatIssue(wdto);
        }
        dto.setData(res);
        return dto;
    }

    /**
     * 获取某个分类下所有问题（app）
     * @param id 分类id
     * @return
     */
    public ResultDto getAllIsuessByCatId(Integer id) {
        ResultDto dto = new ResultDto("0", "查询问题列表");
        IssueCatDto item = issueTypeExtMapper.getCatIssues(id).get(0);
        IssueAppDto wdto = new IssueAppDto();
        wdto.issueTypeId = item.id;
        wdto.page = 0;
        wdto.rows = 10000;
        item.list = issuesExtMapper.findCatIssue(wdto);
        dto.setData(item);
        return dto;
    }
}