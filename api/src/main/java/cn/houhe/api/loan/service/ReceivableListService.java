package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.ExcelUtil;
import cn.houhe.api.loan.entity.bo.ReceivableListObject;
import cn.houhe.api.loan.mapper.ReceivableListExtMapper;
import cn.houhe.api.loan.web.bo.ReceivableListDto;
import cn.houhe.api.loan.web.bo.ReceivableListExcelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/4/27.
 */
@Service("ReceivableListService")
public class ReceivableListService {
    private static final long serialVersionUID = 1L;

    @Resource
    private ReceivableListExtMapper receivableListExtMapper;

    @Autowired
    private ReceivableListService receivableListService;

    public Pager<ReceivableListObject> getReceivableList(ReceivableListDto dto) throws ServiceException {
        try {
            int total = receivableListExtMapper.selectReceivableListCount(dto);

            Pager<ReceivableListObject> page = new Pager<ReceivableListObject>(dto.page, dto.rows, total, new ArrayList<ReceivableListObject>());
            if (total > 0) {
                List<ReceivableListObject> list = receivableListExtMapper.selectReceivableList(dto);
                for (ReceivableListObject r : list) {
                    if(r.getRepay_state()==1||r.getRepay_state()==2){
                        r.setLastPrincipal(new BigDecimal(0));
                        r.setCurrentPrincipal(new BigDecimal(0));
                        continue;
                    }
                    if (r.getLoan_type() == 0) {
                        r.setLastPrincipal(new BigDecimal(0));
                        r.setCurrentPrincipal(r.getLoan_limit());
                    } else {
                        int day = r.getBill_day();
                        Calendar now = Calendar.getInstance();
                        Calendar currentmonth = Calendar.getInstance();
                        Calendar lastmonth = Calendar.getInstance();
            /*            if (day <= now.get(Calendar.DATE)) {
                            lastmonth.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), day);
                        } else {*/
                            lastmonth.add(Calendar.MONTH, -1);
                        //}

                        r.setCurrentPrincipal(r.getLoan_limit().subtract(receivableListExtMapper.getPaiedAmount(r.getLoan_id(),currentmonth.getTime())));
                        r.setLastPrincipal(r.getLoan_limit().subtract(receivableListExtMapper.getPaiedAmount(r.getLoan_id(),lastmonth.getTime())));
                    }
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
    public void importExcelFile(ReceivableListDto dto, OutputStream io){
        try {
            ExcelUtil<ReceivableListExcelDto> ex = new ExcelUtil<ReceivableListExcelDto>();
            String[] headers =
                    { "合同编号", "借款客户", "客户情况", "借款金额（¥）", "综合利率（%）", "借款期限", "逾期天数", "应收合计（¥）", "上月剩余本金（¥）", "本月剩余本金（¥）", "合同出借人" };
            List<ReceivableListExcelDto> dataset = new ArrayList<ReceivableListExcelDto>();
            dto.setPage(0);
            dto.setRows(100000);
            Pager<ReceivableListObject> list = receivableListService.getReceivableList(dto);
            BigDecimal totalfee = BigDecimal.ZERO;
            String memtypestr = "";
            String timesstr = "";
            BigDecimal rate = BigDecimal.ZERO;
            for (ReceivableListObject item: list.getList()){
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
                if(item.getLoan_type() == 0){
                    totalfee = item.getLoan_limit().add(item.getLate_fee()).add(item.getAdvance_repay_fee());
                }
                else if(item.getLoan_type() == 1){
                    totalfee = item.getLoan_limit().add(item.getInterestPayable()).add(item.getLate_fee()).add(item.getAdvance_repay_fee());
                }
                dataset.add(new ReceivableListExcelDto(item.getLoan_number(), item.getUsername(), memtypestr, item.getLoan_limit(), df.format(rate), timesstr, item.getDelayDays(), totalfee, item.getLastPrincipal(), item.getCurrentPrincipal()));
            }
            ex.exportExcel(headers, dataset, io);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
