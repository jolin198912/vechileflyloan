package cn.houhe.api.config.web.bo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/31.
 */
public class AdvertisementDto implements Serializable {
    private Integer adId;

    private Byte status;

    private int page=1;
    private int rows=20;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
