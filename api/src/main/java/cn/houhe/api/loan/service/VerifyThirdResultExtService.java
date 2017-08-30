package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.houhe.api.loan.entity.VerifyThirdResult;
import cn.houhe.api.loan.mapper.VerifyThirdResultExtMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/24.
 */
@Service("verifyThirdResultExtService")
public class VerifyThirdResultExtService implements VerifyThirdResultExtMapper {

    @Resource
    VerifyThirdResultExtMapper verifyThirdResultExtMapper;
    @Resource
    VerifyThirdResultService verifyThirdResultService;
    @Override
    public boolean addResult(VerifyThirdResult entity) {
        try {
            VerifyThirdResult tmpentity=  findByApplyId(entity.getCreditApplyId());
            if(tmpentity!=null)
            {
                if(entity.getTongdunResult()!=null&&!entity.getTongdunResult().equals("")) {
                    tmpentity.setTongdunResult(entity.getTongdunResult());
                }
                if(entity.getBaiqishiResult()!=null&&!entity.getBaiqishiResult().equals("")) {
                    tmpentity.setBaiqishiResult(entity.getBaiqishiResult());
                }
                if(entity.getBairongResult()!=null&&!entity.getBairongResult().equals("")) {
                    tmpentity.setBairongResult(entity.getTongdunResult());
                }
                verifyThirdResultService.update(tmpentity);
                return true;
            }else
            {
                entity.setCreatedon(new Date());
                verifyThirdResultService.insert(entity);
                return true;
            }
        }catch (Exception ex)
        {

        }

        return  false;
    }
    @Override
    public  VerifyThirdResult findByApplyId(int applyid)
    {
        return verifyThirdResultExtMapper.findByApplyId(applyid);
    }
}
