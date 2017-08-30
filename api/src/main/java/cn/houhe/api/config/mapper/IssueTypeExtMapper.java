package cn.houhe.api.config.mapper;

import cn.houhe.api.config.entity.IssueTypeExt;
import cn.houhe.api.config.web.bo.IssueAppDto;
import cn.houhe.api.config.web.bo.IssueCatDto;
import cn.houhe.api.config.web.bo.IssueDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：issue_type
 * @since 2017-03-30 10:04:06
 */
public interface IssueTypeExtMapper {
	/**
	 * 获取所有未删除且类别下有问题的类别
	 * @since 2017-03-30 10:04:06
	 */
	List<IssueTypeExt> GetAll();
	List<IssueCatDto> getCatIssues(@Param("tid") Integer id);
	List<IssueTypeExt> GetIssuesTypeUsing(@Param("tid") Short id);
}