package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.loan.entity.bo.RepaymentDto;
import cn.houhe.api.loan.entity.bo.SettleListObject;
import cn.houhe.api.loan.mapper.SettleListExtMapper;
import cn.houhe.api.loan.web.bo.SettleListDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/27.
 */
@Service("SettleListService")
public class SettleListService {
    private static final long serialVersionUID = 1L;

    @Resource
    private SettleListExtMapper settleListExtMapper;

    public Pager<SettleListObject> getSettleList(SettleListDto dto) throws ServiceException
    {
        try {
            int total=settleListExtMapper.selectSettleListCount(dto);

            Pager<SettleListObject> page=new Pager<SettleListObject>(dto.page,dto.rows,total,new ArrayList<SettleListObject>());
            if(total>0)
            {
                page.setList(settleListExtMapper.selectSettleList(dto));
            }
            return  page;
        }catch (Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
