package cn.houhe.api.loan.web.bo;

import cn.houhe.api.loan.entity.LoanRecord;

import java.util.List;

/**
 * Created by Administrator on 2017/5/13.
 */
public class LoanRecordListDto {
    private int totalPages;
    private List<LoanRecord> recordList;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<LoanRecord> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<LoanRecord> recordList) {
        this.recordList = recordList;
    }
}
