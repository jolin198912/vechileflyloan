package cn.houhe.api.user.web;

import cn.com.iotrust.common.ValidatorException;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.user.entity.Userinfo;
import cn.houhe.api.user.service.UserinfoService;
import cn.houhe.api.user.web.bo.LoginModel;
import cn.houhe.api.user.web.bo.UserAddDto;
import cn.houhe.api.user.web.bo.UserDto;
import cn.houhe.api.user.web.bo.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Spring MVC Controler - �：userinfo
 *
 * @since 2017-03-30 13:50:02
 */
@Controller
@RequestMapping(value = "/user")
public class UserAction {
    private static final Logger logger = LoggerFactory.getLogger(UserAction.class);

    @Autowired
    private UserinfoService userinfoService;

    /**
     * 列表数据
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Object listData(UserDto param) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("msg", "获取账号列表");
        try {
            Pager<UserModel> pager = userinfoService.selectForUser(param);
            Integer total=userinfoService.selectForUserCount(param);
            dataMap.put("code", 0);
            dataMap.put("total", pager.getTotalRecords());
            dataMap.put("rows", pager.getList());
        } catch (Exception e) {

            dataMap.put("code", -1);
            dataMap.put("msg", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return dataMap;
    }

    /**
     * 新增保存
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Object doAdd(@RequestBody RequestDto<UserAddDto> param) {
        ResultDto result = new ResultDto("添加用户");
        Userinfo userinfo=new Userinfo();
        try {
            UserAddDto dto=param.getData();
            List<UserModel> unamecheck = userinfoService.userNameCheck(dto.getAccount());

            if(unamecheck.size() > 0){
                result.setMsg("您输入的账号已存在，请重新输入");
                result.setCode("3");
                return result;
            }

            if (!dto.getPassword().equals(dto.getPassword2()))
            {
                result.setMsg("密码不一致");
                result.setCode("1");
                return result;
            }

            if (dto.getRoleIds()==null&&dto.getRoleIds()=="")
            {
                result.setMsg("角色不能为空");
                result.setCode("2");
                return result;
            }

            if(dto.getPhone()!=""&&dto.getPhone()!=null)
                userinfo.setPhone(dto.getPhone());
            if(dto.getAccount()!=""&&dto.getAccount()!=null)
                userinfo.setUsername(dto.getAccount());
            if(dto.getPassword()!=""&&dto.getPassword()!=null)
                userinfo.setPassword(cn.houhe.api.common.MD5Utils.EncoderByMd5(dto.getPassword()));
            if(dto.getDepartment()!=""&&dto.getDepartment()!=null)
                userinfo.setDepartment(dto.getDepartment());
            if(dto.getName()!=""&&dto.getName()!=null)
                userinfo.setName(dto.getName());

            userinfo.setIsBoss((byte)dto.getIsboss());
            userinfo.setCreatedon(new Date());
            userinfo.setCreatedby("admin");
            userinfo.setIsDisabled((byte)0);
            userinfoService.insert(userinfo,dto.getRoleIds());
            result.setMsg("新增成功");
            result.setCode("0");
        } catch (ValidatorException ve) {
            result.setMsg("新增失败");
            result.setCode("-1");
            logger.error(ve.getMessage(), ve);
        } catch (Exception e) {
            result.setMsg("服务器异常");
            result.setCode("-2");
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 编辑时候根据ID 获取用户信息，包括角色
     */
    @RequestMapping(value = "/get", method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Object doGet(@RequestBody RequestDto<UserAddDto> param) {
        ResultDto result = new ResultDto("根据ID获取用户信息");
        try {
            LoginModel userModel =userinfoService.findByUsid(param.getData().getId());
            result.setCode("0");
            result.setData(userModel);
        } catch (Exception e) {
            result.setMsg("服务器异常");
            result.setCode("-1");
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 修改保存
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Object doEdit(@RequestBody RequestDto<UserAddDto> param) {
        ResultDto result = new ResultDto("编辑用户");
        Userinfo userinfo=new Userinfo();
        try {
            UserAddDto dto=param.getData();
            if (!dto.getPassword().equals(dto.getPassword2()))
            {
                result.setMsg("密码不一致");
                result.setCode("1");
                return result;
            }

            if (dto.getRoleIds()==null&&dto.getRoleIds()=="")
            {
                result.setMsg("角色不能为空");
                result.setCode("2");
                return result;
            }

            userinfo.setUsid(dto.getId());
            if(dto.getPhone()!=""&&dto.getPhone()!=null)
                userinfo.setPhone(dto.getPhone());
            if(dto.getAccount()!=""&&dto.getAccount()!=null)
                userinfo.setUsername(dto.getAccount());
            if(dto.getPassword()!=""&&dto.getPassword()!=null)
                userinfo.setPassword(cn.houhe.api.common.MD5Utils.EncoderByMd5(dto.getPassword()));
            if(dto.getDepartment()!=""&&dto.getDepartment()!=null)
                userinfo.setDepartment(dto.getDepartment());
            if(dto.getName()!=""&&dto.getName()!=null)
                userinfo.setName(dto.getName());

            userinfo.setIsBoss((byte)dto.getIsboss());
            userinfo.setIsDisabled((byte)0);
            userinfo.setModifiedon(new Date());
            userinfo.setModifiedby("admin");
            userinfoService.updateSelective(userinfo,dto.getRoleIds());
            result.setMsg("编辑成功");
            result.setCode("0");
        } catch (ValidatorException ve) {
            result.setMsg("编辑失败");
            logger.error(ve.getMessage(), ve);
            result.setCode("-1");
        } catch (Exception e) {
            result.setMsg("服务器异常");
            result.setCode("-2");
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Object doDelete(List<Integer> ids) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            userinfoService.batchDelete(ids);
            resultMap.put("result", 1);
        } catch (Exception e) {
            resultMap.put("result", 0);
            resultMap.put("message", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultMap;
    }

    /**
     * 用户登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object doLogin(UserDto dto) {
        ResultDto result = new ResultDto("获取账号列表");
        String pwd="";
        try {
            if (dto.password!=null)
                pwd=cn.houhe.api.common.MD5Utils.EncoderByMd5(dto.password);
            LoginModel userModel = userinfoService.findByPwd(dto.account.trim(),pwd.trim(),result);
            if(result.getCode().equals("-4"))
            {
                return result;
            }
            if(userModel == null){
                result.setCode("-2");
            }else {
                if(userModel.getStatus().equals("1")){
                    result.setCode("-3");
                }else {
                    result.setCode("0");
                }
            }
            result.setData(userModel);
        } catch (Exception e) {
            result.setCode("-1");
            result.setMsg(e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 禁用、启用
     */
    @RequestMapping(value = "/enableordisable", method = RequestMethod.POST)
    @ResponseBody
    public Object doDelete(@RequestBody RequestDto<UserDto> param) {
        ResultDto result = new ResultDto("禁用/启用用户");
        Userinfo userinfo=new Userinfo();
        try {
            UserDto dto=param.getData();
            if (dto.getId()==0)
            {
                result.setMsg("用户ID不能为空");
                result.setCode("1");
                return result;
            }
            userinfo.setUsid(dto.getId());
            userinfo.setIsDisabled((byte)dto.getStatus());
            userinfoService.updateSelective(userinfo, "");
            result.setCode("0");
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            result.setCode("-1");
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 修改密码
     */
    @RequestMapping(value = "/changepassword", method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Object changePassword(@RequestBody RequestDto<UserAddDto> param){
        ResultDto result = new ResultDto("修改密码");
        try {
            String oldpwd = param.getData().getPassword();
            String newpwd = "";
            String newpwdparm = param.getData().getPassword2();

            if((oldpwd == null || oldpwd.equals("")) || (newpwdparm == null || newpwdparm.equals(""))){
                result.setMsg("密码不能为空");
                result.setCode("2");
                return result;
            }

            LoginModel userModel = userinfoService.findByUpdatePwd(param.getData().getId());

            if(userModel == null){
                result.setMsg("该用户不存在");
                result.setCode("1");
            }else {
                if (oldpwd != null)
                    oldpwd = cn.houhe.api.common.MD5Utils.EncoderByMd5(oldpwd);

                if(!oldpwd.equals(userModel.getPassword())){
                    result.setMsg("原密码错误，请重新输入");
                    result.setCode("3");
                    return result;
                }

                if (newpwdparm != null)
                    newpwd = cn.houhe.api.common.MD5Utils.EncoderByMd5(newpwdparm);

                Userinfo userinfo = new Userinfo();
                userinfo.setUsid(param.getData().getId());
                userinfo.setPassword(newpwd);
                userinfoService.updateSelective(userinfo, "");
                result.setCode("0");
            }
        }catch (ValidatorException ve) {
            result.setMsg("密码修改失败");
            logger.error(ve.getMessage(), ve);
            result.setCode("-1");
        } catch (Exception e) {
            result.setMsg("服务器异常");
            result.setCode("-2");
            logger.error(e.getMessage(), e);
        }
        return result;
    }
}