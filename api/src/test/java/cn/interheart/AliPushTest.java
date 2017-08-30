package cn.interheart;

import cn.houhe.api.common.AliTools;
import  cn.houhe.api.common.enums.PushMsgEnum;
import org.junit.Test;

/**
 * Created by Administrator on 2017/5/22.
 */
public class AliPushTest {

    /**
     * 群推
     */
    @Test
    public  void  TestAllPush() throws Exception
    {
        AliTools.pushGlobaMsg("dev",PushMsgEnum.SystemMsg.getIndex(),"群组","群组","群组");
    }

    /**
     * 单点
     */
    @Test
    public  void  TestSinglePush() throws Exception
    {
        AliTools.pushMsg("88_dev",PushMsgEnum.SystemMsg.getIndex(),"贷款通知__title","summary_______","body____________________");
    }
}
