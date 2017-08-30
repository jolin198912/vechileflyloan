package cn.houhe.api.user.web.bo;

/**
 * Created by Administrator on 2017/3/30.
 */
public class ResModel {


    /**
     * ID
     */
    public int res_id;
    /**
     * 名字
     */
    public int parent_id;



    public String res_name;
    public String res_code;

    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }
    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getRes_code() {
        return res_code;
    }

    public void setRes_code(String res_code) {
        this.res_code = res_code;
    }
    public String getRes_name() {
        return res_name;
    }

    public void setRes_name(String res_name) {
        this.res_name = res_name;
    }


}


