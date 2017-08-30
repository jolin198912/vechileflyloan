package cn.houhe.api.user.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.BaiqishiUtil;
import cn.houhe.api.common.tongdun.TongDunService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;


import cn.houhe.api.loan.service.score.BaiRongApi;
import cn.houhe.api.user.entity.VerifyThirdQuery;
import cn.houhe.api.user.mapper.VerifyThirdQueryExtMapper;
import cn.houhe.api.user.mapper.VerifyThirdQueryMapper;
import cn.houhe.api.user.web.bo.UserModel;
import cn.houhe.api.user.web.bo.VerifyThirdQueryDto;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - 表：verify_third_query
 *
 * @since 2017-06-06 14:31:52
 */
@Service("verifyThirdQueryService")
public class VerifyThirdQueryService implements Serializable {
    private static final long serialVersionUID = 1L;

    @Resource
    private VerifyThirdQueryMapper verifyThirdQueryMapper;
    @Autowired
    private VerifyThirdQueryExtMapper verifyThirdQueryExtMapper;

    public void insert(VerifyThirdQuery entity) throws ServiceException {
        try {
            verifyThirdQueryMapper.insertSelective(entity);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void delete(VerifyThirdQuery entity) throws ServiceException {
        try {
            verifyThirdQueryMapper.deleteByPrimaryKey(entity.getQid());
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Transactional
    public void batchDelete(List<Integer> ids) throws ServiceException {
        try {
            for (Integer id : ids) {
                verifyThirdQueryMapper.deleteByPrimaryKey(id);
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void update(VerifyThirdQuery entity) throws ServiceException {
        try {
            verifyThirdQueryMapper.updateByPrimaryKey(entity);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void updateSelective(VerifyThirdQuery entity) throws ServiceException {
        try {
            verifyThirdQueryMapper.updateByPrimaryKeySelective(entity);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public VerifyThirdQuery findByPrimaryKey(Integer id) throws ServiceException {
        try {
            return verifyThirdQueryMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public Pager<VerifyThirdQuery> findPage(Criteria<VerifyThirdQuery> criteria) throws ServiceException {
        try {
            if (criteria == null) {
                criteria = Criteria.create(VerifyThirdQuery.class);
            }
            criteria.pagination(true);
            List<VerifyThirdQuery> list = verifyThirdQueryMapper.selectByCriteria(criteria);
            return new Pager<VerifyThirdQuery>(criteria, list);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<VerifyThirdQuery> findAll(Criteria<VerifyThirdQuery> criteria) throws ServiceException {
        try {
            if (criteria == null) {
                criteria = Criteria.create(VerifyThirdQuery.class);
            }
            criteria.pagination(false);
            return verifyThirdQueryMapper.selectByCriteria(criteria);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * 查询第三方风控结果
     *
     * @param verifyThirdQuery
     */
    public VerifyThirdQuery query(VerifyThirdQueryDto verifyThirdQuery) throws Exception {
        JSONObject bqsParam = new JSONObject();
        bqsParam.put("certNo", verifyThirdQuery.getIdcardNo());
        bqsParam.put("name", verifyThirdQuery.getRealName());
        bqsParam.put("mobile", verifyThirdQuery.getMobile());
        VerifyThirdQuery query = new VerifyThirdQuery();
        //白骑士查询结果
        String bqiResult = BaiqishiUtil.decision(bqsParam);
        //同盾查询结果
        String tongdunResult = TongDunService.GetCheck(verifyThirdQuery.getRealName(), verifyThirdQuery.getIdcardNo(), verifyThirdQuery.getMobile(), null, 2);
        //百荣查询结果

        JSONObject reqData = new JSONObject();
        reqData.put("name", verifyThirdQuery.getRealName());
        reqData.put("id", verifyThirdQuery.getIdcardNo());
        JSONArray cells = new JSONArray();
        cells.add(verifyThirdQuery.getMobile());
        reqData.put("cell", cells);
        reqData.put("meal", "SpecialList_c");
        String specialResult=JSONObject.parseObject(new BaiRongApi().getData("BankServer3Api",reqData))+"";

        query.setIdcardNo(verifyThirdQuery.getIdcardNo());
        query.setMobile(verifyThirdQuery.getMobile());
        query.setRealName(verifyThirdQuery.getRealName());
        query.setUserinfoId(verifyThirdQuery.getUserId());
        query.setBaiqishi(bqiResult);
        query.setTongdun(tongdunResult);
        query.setBairong(specialResult);
        insert(query);
        return query;
    }

    /**
     * 查询历史
     * @param dto 参数
     * @return
     * @throws Exception
     */
    public Map<String,Object> queryList(VerifyThirdQueryDto dto) throws Exception
    {
       int total = verifyThirdQueryExtMapper.getCount(dto);
        dto.setPage((dto.getPage()-1)*dto.getRows());
        List<VerifyThirdQuery> list=verifyThirdQueryExtMapper.getList(dto);
        Map<String,Object> res=new HashedMap();
        res.put("total",total);
        res.put("rows",list);
        return res;
    }

    /**
     * 查询统计
     * @param dto 查询参数
     * @return
     * @throws Exception
     */
    public Map<String,Object> statics(VerifyThirdQueryDto dto) throws Exception
    {
        int total=verifyThirdQueryExtMapper.staticstotalcnt();
        dto.setPage((dto.getPage()-1)*dto.getRows());
        List<Map<String,String>> list=verifyThirdQueryExtMapper.statics(dto);
        Map<String,Object> res=new HashedMap();
        res.put("total",total);
        res.put("rows",list);
        res.put("code",1);
        return res;
    }


    /**
     * 查询历史
     * @param dto 参数
     * @return
     * @throws Exception
     */
    public VerifyThirdQuery querylast() throws Exception
    {
         return verifyThirdQueryExtMapper.getlast();
    }
}