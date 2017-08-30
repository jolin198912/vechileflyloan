package cn.houhe.api.common;

/**
 * Created by Administrator on 2017/3/29.
 * 请求模型
 *
 */
public class RequestDto<T> {
    private T data;
    private  String platform;
    private  String version;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
