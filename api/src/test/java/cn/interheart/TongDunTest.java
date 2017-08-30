package cn.interheart;

import cn.houhe.api.common.tongdun.TongDunService;
import org.junit.Test;

/**
 * Created by Administrator on 2017/5/26.
 */
public class TongDunTest {
    @Test
    public  void  GetResult()
    {
        String res= TongDunService.GetCheck("皮晴晴","370404199006301915","15961718173",null,0);
    }
}
