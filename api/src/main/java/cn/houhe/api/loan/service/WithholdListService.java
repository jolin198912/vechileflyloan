package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.ExcelUtil;
import cn.houhe.api.loan.entity.bo.WithholdListObject;
import cn.houhe.api.loan.mapper.WithholdListExtMapper;
import cn.houhe.api.loan.web.bo.WithholdListDto;
import cn.houhe.api.loan.web.bo.WithholdListExcelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/27.
 */
@Service("WithholdListService")
public class WithholdListService {
    private static final long serialVersionUID = 1L;

    @Resource
    private WithholdListExtMapper withholdListExtMapper;

    @Autowired
    private WithholdListService withholdListService;

    public Pager<WithholdListObject> getWithholdList(WithholdListDto dto) throws ServiceException
    {
        try {
            int total= withholdListExtMapper.selectWithholdListCount(dto);

            Pager<WithholdListObject> page=new Pager<WithholdListObject>(dto.page,dto.rows,total,new ArrayList<WithholdListObject>());
            if(total>0)
            {
                page.setList(withholdListExtMapper.selectWithholdList(dto));
            }
            return  page;
        }catch (Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * 导出excel
     */
    public void importExcelFile(WithholdListDto dto, OutputStream io){
        try {
            ExcelUtil<WithholdListExcelDto> ex = new ExcelUtil<WithholdListExcelDto>();
            String[] headers =
                    { "订单号", "借款客户", "手机号", "扣款金额（¥）", "支付平台", "扣款时间", "订单状态" };
            List<WithholdListExcelDto> dataset = new ArrayList<WithholdListExcelDto>();
            dto.setPage(0);
            dto.setRows(100000);
            Pager<WithholdListObject> list = withholdListService.getWithholdList(dto);
            //String platformstr = "";
            String statusstr = "";
            for (WithholdListObject item: list.getList()){
                /*switch (item.getPay_platform()){
                    case 0:
                        platformstr = "微众银行";
                        break;
                    case 1:
                        platformstr = "易联收付";
                        break;
                }*/
                switch (item.getStatus()){
                    case 0:
                        statusstr = "待扣款";
                        break;
                    case 1:
                        statusstr = "已扣款";
                        break;
                    case 2:
                        statusstr = "扣款中";
                        break;
                    case 3:
                        statusstr = "扣款失败";
                        break;
                }
                dataset.add(new WithholdListExcelDto(item.getNumber(), item.getBank_user_name(), item.getUser_mobile(), item.getRepay_amount(), item.getPay_platform(), item.getPay_time(), statusstr));
            }
            ex.exportExcel(headers, dataset, io);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
