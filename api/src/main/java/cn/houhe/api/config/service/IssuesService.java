package cn.houhe.api.config.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.config.entity.IssueTypeExt;
import cn.houhe.api.config.entity.Issues;
import cn.houhe.api.config.entity.IssuesExt;
import cn.houhe.api.config.mapper.IssuesExtMapper;
import cn.houhe.api.config.mapper.IssuesMapper;
import cn.houhe.api.config.web.IssuesAction;
import cn.houhe.api.config.web.bo.IssueDto;
import cn.houhe.api.config.web.bo.IssueTypeDto;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 业务实现层 - 表：issues
 * @since 2017-03-30 10:04:06
 */
@Service("issuesService")
public class IssuesService implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(IssuesAction.class);

	@Resource
	private IssuesMapper issuesMapper;

	@Resource
	private IssuesExtMapper issuesExtMapper;

	@Autowired
	private IssueTypeService issueTypeService;

	public void insert(Issues entity) throws ServiceException {
		try {
			issuesMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void insertSelective(Issues entity) throws ServiceException {
		try {
			issuesMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(Issues entity) throws ServiceException {
		try {
			issuesMapper.deleteByPrimaryKey(entity.getIuId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Short> ids) throws ServiceException {
		try {
			for (Short id : ids) {
				issuesMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(Issues entity) throws ServiceException {
		try {
			issuesMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(Issues entity) throws ServiceException {
		try {
			issuesMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Issues findByPrimaryKey(Short iuId) throws ServiceException {
		try {
			return issuesMapper.selectByPrimaryKey(iuId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<Issues> findPage(Criteria<Issues> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(Issues.class);
			}
			criteria.pagination(true);
			List<Issues> list = issuesMapper.selectByCriteria(criteria);
			return new Pager<Issues>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<Issues> findAll(Criteria<Issues> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(Issues.class);
			}
			criteria.pagination(false);
			return issuesMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<IssuesExt> findAll() throws ServiceException {
		try {
			return issuesExtMapper.selectAll();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<IssuesExt> findPageExt(IssuesExt issuesExt) throws ServiceException {
		try {
			List<IssuesExt> list = issuesExtMapper.findPageData(issuesExt);
			return list;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Integer getCount(IssuesExt issuesExt) throws ServiceException {
		try {
			return  issuesExtMapper.getCount(issuesExt);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateEnable(IssuesExt issuesExt) throws ServiceException {
		try {
			issuesExtMapper.updateEanble(issuesExt);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

    public IssuesExt findIssuesFeedback(Short iuId) throws ServiceException {
        try {
            return issuesExtMapper.selectIssuesFeedback(iuId);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

	/**
	 * 获取所有上架问题
	 */
	public ResultDto getAllIssuesSer(){
		ResultDto result = new ResultDto("0", "获取问题列表成功");
		try {
			List<IssueTypeExt> typelist = issueTypeService.GetAll();
			List<IssuesExt> issuelist = findAll();
			List<IssueTypeDto> newlist = new ArrayList<IssueTypeDto>();
			for (IssueTypeExt item : typelist) {
				IssueTypeDto dto = new IssueTypeDto();
				dto.setItId(item.getItId());
				dto.setName(item.getName());
				List<IssueDto> issueDtoList = new ArrayList<IssueDto>();
				for (IssuesExt ie : issuelist) {
					if (ie.getIssueTypeId() == item.getItId()) {
						IssueDto issueDto = new IssueDto();
						BeanUtils.copyProperties(issueDto, ie);
						issueDtoList.add(issueDto);
					}
				}
				dto.setIssuelist(issueDtoList);
				newlist.add(dto);
			}
			result.setData(newlist);
		} catch (Exception e) {
			result.setCode("-1");
			result.setMsg("查询异常");
			logger.error(e.getMessage(), e);
		}
		return result;
	}

    /**
     * 问题反馈
     */
	public ResultDto issuesFeedbackSer(RequestDto<IssueDto> param) {
        ResultDto result = new ResultDto("0", "问题反馈成功");
        try {
            int solvecount = 0;
            int unsolvecount = 0;
            Byte issolve = param.getData().getIsSolve();
            Short iuid = param.getData().getIuId();
            IssuesExt issuesinfo = findIssuesFeedback(iuid);
            if(issuesinfo == null){
                result.setCode("1");
                result.setMsg("该问题不存在");
                return result;
            }
            if(issolve == 0) {
                solvecount = issuesinfo.getSolveCount() + 1;
            } else if(issolve == 1) {
                unsolvecount= issuesinfo.getUnsolveCount() + 1;
            }

            IssuesExt issuesExt = new IssuesExt();
            issuesExt.setIsSolve(issolve);
            issuesExt.setIuId(iuid);
            issuesExt.setSolveCount(solvecount);
            issuesExt.setUnsolveCount(unsolvecount);
            issuesExtMapper.updateIssuesFeedback(issuesExt);
        }
        catch (Exception e) {
            result.setCode("-1");
            result.setMsg("问题反馈失败");
            logger.error(e.getMessage(), e);
        }
        return result;
    }

	/**
	 * 获取问题详情
	 * @param id 问题id
	 * @return
	 */
	public  ResultDto getDetials(int id)
	{
		ResultDto dto=new ResultDto("查询成功");
		dto.setData(issuesExtMapper.getDetials(id));
		return  dto;
	}
}