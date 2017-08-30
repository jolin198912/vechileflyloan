package cn.interheart;

import cn.houhe.api.common.carcheck.CarCheckService;
import cn.houhe.api.common.carcheck.util.CarInfoModel;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/5/19.
 */
public class ChekCarTest {

    @Test
    public  void  GetBalance()
    {
       BigDecimal balance= CarCheckService.GetBalance(1);
    }

    @Test
    public  void  GetCarCheck()
    {
        CarInfoModel res= CarCheckService.GetCheck  ("粤L2031A","02");
    }
}
