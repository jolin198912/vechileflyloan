package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.ExcelUtil;
import cn.houhe.api.loan.entity.bo.PayListObject;
import cn.houhe.api.loan.mapper.PayListExtMapper;
import cn.houhe.api.loan.web.bo.PayListDto;
import cn.houhe.api.loan.web.bo.PayListExcelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/27.
 */
@Service("PayListService")
public class PayListService {
    private static final long serialVersionUID = 1L;

    @Resource
    private PayListExtMapper payListExtMapper;

    @Autowired
    private PayListService payListService;

    public Pager<PayListObject> getPayList(PayListDto dto) throws ServiceException
    {
        try {
            int total= payListExtMapper.selectPayListCount(dto);

            Pager<PayListObject> page=new Pager<PayListObject>(dto.page,dto.rows,total,new ArrayList<PayListObject>());
            if(total>0)
            {
                page.setList(payListExtMapper.selectPayList(dto));
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
    public void importExcelFile(PayListDto dto, OutputStream io){
        try {
            ExcelUtil<PayListExcelDto> ex = new ExcelUtil<PayListExcelDto>();
            String[] headers =
                    { "订单号", "借款客户", "手机号", "贷款金额（¥）", "放款金额（¥）", "支付平台", "打款时间", "订单状态" };
            List<PayListExcelDto> dataset = new ArrayList<PayListExcelDto>();
            dto.setPage(0);
            dto.setRows(100000);
            Pager<PayListObject> list = payListService.getPayList(dto);
            //String platformstr = "";
            String statusstr = "";
            for (PayListObject item: list.getList()){
                /*switch (item.getPay_platform()){
                    case 0:
                        platformstr = "微众银行";
                        break;
                    case 1:
                        platformstr = "易联";
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
                dataset.add(new PayListExcelDto(item.getNumber(), item.getUsername(), item.getUser_mobile(), item.getLoan_limit(), item.getAmount(), item.getPay_platform(), item.getPaytime(), statusstr));
            }
            ex.exportExcel(headers, dataset, io);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
