package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.houhe.api.loan.mapper.RemainderPlanExtMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;

/**
 * 业务实现层 - 表：remainder_plan
 * @since 2017-05-24 18:33:37
 */
@Service("remainderPlanExtService")
public class RemainderPlanExtService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private RemainderPlanExtMapper remainderPlanExtMapper;

	public void insertSelective(String loanRecordIds , String repaymentsPlanIds, Integer remainderId, String remainder, String remark, Date createdon) throws ServiceException {
		try {
			String str1[] = loanRecordIds.split(",");
			String str2[] = repaymentsPlanIds.split(",");
			for(int i=0;i<str1.length;i++){
				remainderPlanExtMapper.insertSelective(Integer.parseInt(str1[i]),Integer.parseInt(str2[i]),remainderId,remainder, remark, createdon);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}