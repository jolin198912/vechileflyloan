package cn.houhe.api.loan.web.bo;

import cn.houhe.api.loan.entity.DebitRcd;

import java.util.List;

/**
 * Created by Administrator on 2017/5/13.
 */
public class DebitRcdListDto {
    private int totalPages;
    private List<DebitRcd> list;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<DebitRcd> getList() {
        return list;
    }

    public void setList(List<DebitRcd> list) {
        this.list = list;
    }
}
