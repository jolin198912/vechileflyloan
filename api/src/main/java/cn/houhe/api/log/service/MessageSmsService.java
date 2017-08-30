package cn.houhe.api.log.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.FlowNoUtil;
import cn.houhe.api.common.liandong.SendSmsService;
import cn.houhe.api.log.entity.MessageSms;
import cn.houhe.api.log.mapper.MessageSmsMapper;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：message_sms
 * @since 2017-05-25 14:44:55
 */
@Service("messageSmsService")
public class MessageSmsService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private MessageSmsMapper messageSmsMapper;

	public void insert(MessageSms entity) throws ServiceException {
		try {
			messageSmsMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(MessageSms entity) throws ServiceException {
		try {
			messageSmsMapper.deleteByPrimaryKey(entity.getMid());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				messageSmsMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(MessageSms entity) throws ServiceException {
		try {
			messageSmsMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(MessageSms entity) throws ServiceException {
		try {
			messageSmsMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public MessageSms findByPrimaryKey(Integer mid) throws ServiceException {
		try {
			return messageSmsMapper.selectByPrimaryKey(mid);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<MessageSms> findPage(Criteria<MessageSms> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(MessageSms.class);
			}
			criteria.pagination(true);
			List<MessageSms> list = messageSmsMapper.selectByCriteria(criteria);
			return new Pager<MessageSms>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<MessageSms> findAll(Criteria<MessageSms> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(MessageSms.class);
			}
			criteria.pagination(false);
			return messageSmsMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * 发送短信方法
	 * @param content 短信内容
	 * @param mobileno 短信手机号
	 * @param membid   发送的会员id
	 * @param type     系统发送（0，群发），用户发送1（单发）
	 * @param contenttype 短信业务类型
	 */
	public  void SendSms(String content,String mobileno,int membid,int type,int contenttype)
	{
		MessageSms s=new MessageSms();
		s.setContent(content);
		s.setMemberId(membid);
		s.setMsgType((byte)type);
		s.setMsgContentType((byte)contenttype);
		s.setTitle("");
		s.setIsSend((byte)0);
		s.setCreatedon(new Date());
		try {

		int id=	messageSmsMapper.insert(s);
		Map<String,String> map= SendSmsService.SendMsg(content,mobileno,id+"");
		if(map!=null&&map.get("status").equals("0"))
		{
			s.setIsSend((byte)1);
			s.setRemark(map.get("msgId"));
			update(s);
		}

		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}