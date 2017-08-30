package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.ExcelUtil;
import cn.houhe.api.loan.entity.bo.PaidListObject;
import cn.houhe.api.loan.mapper.PaidListExtMapper;
import cn.houhe.api.loan.web.bo.PaidListDto;
import cn.houhe.api.loan.web.bo.PaidListExcelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/27.
 */
@Service("PaidListService")
public class PaidListService {
    private static final long serialVersionUID = 1L;

    @Resource
    private PaidListExtMapper paidListExtMapper;

    @Autowired
    private PaidListService paidListService;

    public Pager<PaidListObject> getPaidList(PaidListDto dto) throws ServiceException {
        try {
            final BigDecimal cnt = new BigDecimal(30);
            int total = paidListExtMapper.selectPaidListCount(dto);

            Pager<PaidListObject> page = new Pager<PaidListObject>(dto.page, dto.rows, total, new ArrayList<PaidListObject>());
            if (total > 0) {
                List<PaidListObject> list = paidListExtMapper.selectPaidList(dto);
                for (PaidListObject r : list) {
                    if(r.getFq_rate() == null) r.setFq_rate(BigDecimal.ZERO);
                    if(r.getLoan_type() == 0){
                        r.setTotal_receivable(r.getLoan_limit().add(r.getLate_fee()).add(r.getAdvance_repay_fee()));
                    }
                    else if(r.getLoan_type() == 1){
                        r.setTotal_receivable(r.getLoan_limit().add(r.getInterest()).add(r.getLate_fee()).add(r.getAdvance_repay_fee()));
                    }
                    //r.setTotal_payable(r.getTotal_payable().add(r.getAdvance_repay_fee()));
                }
                page.setList(list);
            }
            return page;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * 导出excel
     */
    public void importExcelFile(PaidListDto dto, OutputStream io){
        try {
            ExcelUtil<PaidListExcelDto> ex = new ExcelUtil<PaidListExcelDto>();
            String[] headers =
                    { "合同编号", "借款客户", "客户情况", "借款日期", "合同到期日", "借款金额（¥）", "综合利率（%）", "借款期限", "逾期天数", "应收合计（¥）", "实收合计（¥）", "剩余合计（¥）", "合同出借人" };
            List<PaidListExcelDto> dataset = new ArrayList<PaidListExcelDto>();
            dto.setPage(0);
            dto.setRows(100000);
            Pager<PaidListObject> list = paidListService.getPaidList(dto);
            BigDecimal lasttotalfee = BigDecimal.ZERO;
            String memtypestr = "";
            String timesstr = "";
            BigDecimal rate = BigDecimal.ZERO;
            for (PaidListObject item: list.getList()){
                switch (item.getMem_situation_type()){
                    case 0:
                        memtypestr = "新增客户";
                        break;
                    case 1:
                        memtypestr = "结清再贷";
                        break;
                    case 2:
                        memtypestr = "增贷";
                        break;
                }
                switch (item.getLoan_type()){
                    case 0:
                        timesstr = item.getTime() + "天";
                        break;
                    case 1:
                        timesstr = item.getTime() + "个月";
                        break;
                }
                DecimalFormat df = new DecimalFormat("#.00");
                rate = item.getRate().multiply(new BigDecimal("100"));
                lasttotalfee = item.getTotal_receivable().subtract(item.getTotal_payable());
                dataset.add(new PaidListExcelDto(item.getLoan_number(), item.getUsername(), memtypestr, item.getStart_time(), item.getEnd_time(), item.getLoan_limit(), df.format(rate), timesstr, item.getDelay_days(), item.getTotal_receivable(), item.getTotal_payable(), lasttotalfee));
            }
            ex.exportExcel(headers, dataset, io);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
