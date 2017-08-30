package cn.houhe.api.loan.web.bo;

/**
 * Created by Administrator on 2017/4/25.
 */
public class RemindDto {
    private Integer memberId;
    private Integer repaymentsPlanId;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getRepaymentsPlanId() {
        return repaymentsPlanId;
    }

    public void setRepaymentsPlanId(Integer repaymentsPlanId) {
        this.repaymentsPlanId = repaymentsPlanId;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    private  Integer rows=10;
    private Integer page=1;
}
