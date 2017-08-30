package cn.houhe.api.user.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.MD5Utils;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.user.entity.Userinfo;
import cn.houhe.api.user.mapper.UserinfoMapper;
import cn.houhe.api.user.mapper.UserinfoExtMapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import cn.houhe.api.user.web.UserAction;
import cn.houhe.api.user.web.bo.LoginDto;
import cn.houhe.api.user.web.bo.LoginModel;
import cn.houhe.api.user.web.bo.UserDto;
import cn.houhe.api.user.web.bo.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务实现层 - �：userinfo
 *
 * @since 2017-03-30 13:50:02
 */
@Service("userinfoService")
public class UserinfoService implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(UserAction.class);
    private static final long serialVersionUID = 1L;

    @Resource
    private UserinfoMapper userinfoMapper;

    @Resource
    private UserinfoExtMapper userinfoExtMapper;

    public Pager<UserModel> selectForUser(UserDto dto) throws ServiceException {
        try {
            int total = userinfoExtMapper.selectForUserCount(dto);

            Pager<UserModel> pager = new Pager<>(dto.getPage(), dto.getRows(), total, new ArrayList<UserModel>());
            if (total == 0) {
                return pager;
            }
            List<UserModel> list = userinfoExtMapper.selectForUser(dto, pager.getStartRow(), pager.getPageSize());
            pager.setList(list);
            return pager;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public Integer selectForUserCount(UserDto dto) throws ServiceException {
        Integer count = 0;
        try {
            count=  userinfoExtMapper.selectForUserCount(dto);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return count;
    }

    public void insert(Userinfo entity ,String roleIds) throws ServiceException {
        try {
            userinfoMapper.insertSelective(entity);
            String str[] = roleIds.split(",");
            for(int i=0;i<str.length;i++){
                userinfoExtMapper.addRolesToUser(entity.getUsid(),Integer.parseInt(str[i]));
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void delete(Userinfo entity) throws ServiceException {
        try {
            userinfoMapper.deleteByPrimaryKey(entity.getUsid());
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Transactional
    public void batchDelete(List<Integer> ids) throws ServiceException {
        try {
            for (Integer id : ids) {
                userinfoMapper.deleteByPrimaryKey(id);
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void update(Userinfo entity) throws ServiceException {
        try {
            userinfoMapper.updateByPrimaryKey(entity);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void updateSelective(Userinfo entity ,String roleIds) throws ServiceException {
        try {
            if(roleIds != ""){
                userinfoExtMapper.deleteUserRole(entity.getUsid());
                String str[] = roleIds.split(",");
                for(int i=0;i<str.length;i++){
                    userinfoExtMapper.addRolesToUser(entity.getUsid(),Integer.parseInt(str[i]));
                }
            }
            userinfoMapper.updateByPrimaryKeySelective(entity);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public Userinfo findByPrimaryKey(Integer usid) throws ServiceException {
        try {
            return userinfoMapper.selectByPrimaryKey(usid);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public Pager<Userinfo> findPage(Criteria<Userinfo> criteria) throws ServiceException {
        try {
            if (criteria == null) {
                criteria = Criteria.create(Userinfo.class);
            }
            criteria.pagination(true);
            List<Userinfo> list = userinfoMapper.selectByCriteria(criteria);
            return new Pager<Userinfo>(criteria, list);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<Userinfo> findAll(Criteria<Userinfo> criteria) throws ServiceException {
        try {
            if (criteria == null) {
                criteria = Criteria.create(Userinfo.class);
            }
            criteria.pagination(false);
            return userinfoMapper.selectByCriteria(criteria);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /*登录验证账号和密码，通过之后返回用户模型、角色、权限*/
    public LoginModel findByPwd(String account, String pwd,ResultDto dto) throws ServiceException {
        try {
            UserModel userModel= userinfoExtMapper.findByAccountAndPwd(account,pwd);
           if (userModel!=null) {
               LoginModel obj = userinfoExtMapper.findByUid(userModel.getId());
               if(obj==null)
               {
                   dto.setCode("-4");
               }
               return obj;
           }
           else{
               return null;
        }} catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    /* 获取用户信息*/
    public LoginModel findByUsid(Integer usid) throws ServiceException {
        try {
            LoginModel userModel= userinfoExtMapper.findByURole(usid);
            return userModel;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public LoginModel findByUpdatePwd(Integer usid) throws ServiceException {
        try {
            LoginModel userModel= userinfoExtMapper.findByUpdatePwd(usid);
            return userModel;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<Map> getAuditPerson(String resCode){
        return userinfoExtMapper.getAuditPerson(resCode);
    }

    public ResultDto findUserInfoByMobile(RequestDto<UserDto> requestDto) {
        ResultDto result = new ResultDto();
        result.setMsg("老板端登录");
        try {
            UserDto data = requestDto.getData();
            HashMap map = userinfoExtMapper.selectUserInfoByMobile(data.getAccount());
            if (map != null) {
                if (data.getPassword().equals(map.get("password"))) {
                    result.setCode("0");
                    result.setMsg("登录成功");
                    result.setData(map);
                } else {
                    result.setMsg("密码错误");
                    result.setCode("1");
                }
            } else {
                result.setCode("2");
                result.setMsg("用户不存在或权限不够");
            }
        } catch (Exception e) {
            result.setCode("-1");
            result.setMsg("登录失败,请重试");
            logger.error(e.getMessage(),e);
        }
        return result;
    }

    public void deleteUserRole(Integer usid) throws ServiceException {
        try {
            userinfoExtMapper.deleteUserRole(usid);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /*用户名校验*/
    public List<UserModel> userNameCheck(String account) throws ServiceException {
        try {
            List<UserModel> userModel = userinfoExtMapper.userNameCheck(account);
            return userModel;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}