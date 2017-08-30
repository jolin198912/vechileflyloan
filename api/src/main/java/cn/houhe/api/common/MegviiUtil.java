package cn.houhe.api.common;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.ServiceOperationException;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.net.URLConnection;

/**
 * Created by think on 2017/4/7.
 */
public class MegviiUtil {

    private static Logger logger = LoggerFactory.getLogger(MegviiUtil.class);
    private static final String API_URL = "https://api.megvii.com/faceid/v2/verify";

    /**
     * face ++ 有源对比
     * @param faceUrl
     * @param idCardName
     * @param idCardNum
     * @param comparator
     * @return
     * @throws Exception
     */
    public static boolean compareFaceWithOrigin(String faceUrl, String idCardName, String idCardNum, FaceComparator comparator) throws Exception{
        HttpPost httpPost = new HttpPost(API_URL);
        httpPost.setHeader("User-Agent","SOHUWapRebot");
        httpPost.setHeader("Accept-Language","zh-cn,zh;q=0.5");
        httpPost.setHeader("Accept-Charset","GBK,utf-8;q=0.7,*;q=0.7");
        httpPost.setHeader("Connection","keep-alive");
        MultipartEntityBuilder multiEntity = MultipartEntityBuilder.create();
        URLConnection imgConn = new URL(faceUrl).openConnection();
        multiEntity.addPart("image", new InputStreamBody(imgConn.getInputStream(),"image"));
        multiEntity.addPart("api_key",new StringBody(Configs.FACE_APPKEY, ContentType.TEXT_PLAIN));
        multiEntity.addPart("api_secret",new StringBody(Configs.FACE_APPSecret, ContentType.TEXT_PLAIN));
        multiEntity.addPart("comparison_type",new StringBody("1", ContentType.TEXT_PLAIN));
        multiEntity.addPart("face_image_type",new StringBody("raw_image", ContentType.TEXT_PLAIN));
        multiEntity.addPart("idcard_name",new StringBody(idCardName, ContentType.parse("text/plain;charset=UTF-8")));
        multiEntity.addPart("idcard_number",new StringBody(idCardNum, ContentType.parse("text/plain;charset=UTF-8")));


        httpPost.setEntity(multiEntity.build());
        HttpResponse httpResponse = HttpClients.createDefault().execute(httpPost);
        HttpEntity httpEntity =  httpResponse.getEntity();
        String content = EntityUtils.toString(httpEntity);
        JSONObject result = JSONObject.parseObject(content);
        if (result.getString("error_message")!=null){
            logger.error("对比失败:"+result.getString("error_message"));
            throw new ServiceException("对比失败");
        }
        comparator.compare(result);
        JSONObject faceId = result.getJSONObject("result_faceid");
        return faceId.getFloat("confidence") > faceId.getJSONObject("thresholds").getFloat("1e-5");
    }

    /**
     *
     * 无源对比
     * @param face 待检测
     * @param faceComparator
     * @param imageRefs 参考图片
     * @return boolean 对比结果
     * @throws Exception
     */
    public static boolean compareFaceWithoutOrigin(String  uuid,String face, FaceComparator faceComparator,String... imageRefs) throws Exception{
        HttpPost httpPost = new HttpPost(API_URL);
        httpPost.setHeader("User-Agent","SOHUWapRebot");
        httpPost.setHeader("Accept-Language","zh-cn,zh;q=0.5");
        httpPost.setHeader("Accept-Charset","GBK,utf-8;q=0.7,*;q=0.7");
        httpPost.setHeader("Connection","keep-alive");
        MultipartEntityBuilder multiEntity = MultipartEntityBuilder.create();
        URLConnection imgConn = new URL(face).openConnection();
        multiEntity.addPart("image", new InputStreamBody(imgConn.getInputStream(),"image"));
        multiEntity.addPart("api_key",new StringBody(Configs.FACE_APPKEY, ContentType.TEXT_PLAIN));
        multiEntity.addPart("api_secret",new StringBody(Configs.FACE_APPSecret, ContentType.TEXT_PLAIN));
        multiEntity.addPart("comparison_type",new StringBody("0", ContentType.TEXT_PLAIN));
        multiEntity.addPart("face_image_type",new StringBody("raw_image", ContentType.TEXT_PLAIN));
        multiEntity.addPart("uuid",new StringBody(uuid, ContentType.TEXT_PLAIN));
        for (int i=0 ;imageRefs != null && i< imageRefs.length;i++) {
            multiEntity.addPart("image_ref"+i, new InputStreamBody(new URL(imageRefs[i]).openConnection().getInputStream(), "image_ref"+i));
        }
        httpPost.setEntity(multiEntity.build());
        HttpResponse httpResponse = HttpClients.createDefault().execute(httpPost);
        HttpEntity httpEntity =  httpResponse.getEntity();
        String content = EntityUtils.toString(httpEntity);
        JSONObject result = JSONObject.parseObject(content);
        if (result.getString("error_message")!=null){
            logger.error("对比失败:"+result.getString("error_message"));
            throw new ServiceOperationException("对比失败");
        }
        JSONObject faceId = result.getJSONObject("result_faceid");

        return faceId.getFloat("confidence") > faceId.getJSONObject("thresholds").getFloat("1e-5");
    }

    public static interface FaceComparator {
        void compare(JSONObject result);
    }

    public class FaceInfo {

        private String request_id;
        private JSONObject result_faceid;

        private String error_message;

        public String getRequest_id() {
            return request_id;
        }

        public void setRequest_id(String request_id) {
            this.request_id = request_id;
        }

        public JSONObject getResult_faceid() {
            return result_faceid;
        }

        public void setResult_faceid(JSONObject result_faceid) {
            this.result_faceid = result_faceid;
        }

        public String getError_message() {
            return error_message;
        }

        public void setError_message(String error_message) {
            this.error_message = error_message;
        }
    }
}
