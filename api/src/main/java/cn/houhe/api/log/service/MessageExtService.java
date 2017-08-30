package cn.houhe.api.log.service;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.log.entity.Message;
import cn.houhe.api.log.entity.MessageExt;
import cn.houhe.api.log.mapper.MessageExtMapper;
import cn.houhe.api.log.web.MessageAction;
import cn.houhe.api.log.web.bo.MessageListDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 业务实现层 - 表：message
 * @since 2017-05-06 15:11:19
 */
@Service("messageExtService")
public class MessageExtService implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(MessageAction.class);

	/*@Resource
	private MessageExtMapper messageExtMapper;*/
	@Autowired
	private MessageService messageService;

	/**
	 * 获取通知消息列表
	 */
	public ResultDto getMessageListSer(RequestDto<MessageExt> param){
		ResultDto result = new ResultDto("0", "获取通知消息列表成功");
		try {
			/*List<MessageExt> msglst = messageExtMapper.selectMessageList(param.getData());
			result.setData(msglst);*/
			if (param.getData().getMemberId() <= 0) {
				result.setCode("-1");
				result.setMsg("会员id不合法");
				return result;
			}
			Criteria<Message> criteria = Criteria.create(Message.class);
			criteria.add(ExpressionFactory.and(ExpressionFactory.or(ExpressionFactory.eq("memberId", param.getData().getMemberId()), ExpressionFactory.eq("memberId", 0)), ExpressionFactory.eq("isSend", 1)));
			criteria.setPageSize(param.getData().getRows());
			criteria.setCurrentPage(param.getData().getPage());
			criteria.sortIfEmpty(Sort.desc("createdon"));
			Pager<Message> pager = messageService.findPage(criteria);
			MessageListDto messageListDto =new MessageListDto();
			messageListDto.setMessageList(pager.getList());
			messageListDto.setTotalPages(pager.getTotalPages());
			result.setData(messageListDto);
		} catch (Exception e) {
			result.setCode("-1");
			result.setMsg("查询异常");
			logger.error(e.getMessage(), e);
		}
		return result;
	}
}