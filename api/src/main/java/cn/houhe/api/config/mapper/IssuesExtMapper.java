package cn.houhe.api.config.mapper;

import cn.houhe.api.config.entity.IssuesExt;
import cn.houhe.api.config.web.bo.IssueAppDto;
import cn.houhe.api.config.web.bo.IssueDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：issues
 * @since 2017-03-30 10:04:06
 */
public interface IssuesExtMapper {
	/**
	 * 获取所有上线广告
	 * @since 2017-03-30 10:04:06
	 */
	List<IssuesExt> selectAll();

	List<IssuesExt> findPageData(IssuesExt issuesExt);

	Integer getCount(IssuesExt issuesExt);

	void updateEanble(IssuesExt issuesExt);

	void updateIssuesFeedback(IssuesExt issuesExt);

	IssuesExt selectIssuesFeedback(Short iuId);

    List<IssueAppDto> findCatIssue(@Param("dto")IssueAppDto dto);

	IssueAppDto getDetials(@Param("iid") Integer id);

}