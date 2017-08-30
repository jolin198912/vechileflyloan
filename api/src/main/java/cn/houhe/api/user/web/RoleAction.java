package cn.houhe.api.user.web;

import cn.com.iotrust.common.ValidatorException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.user.entity.Role;
import cn.houhe.api.user.entity.RoleResourceExt;
import cn.houhe.api.user.service.RoleService;
import cn.houhe.api.user.web.bo.RoleDto;
import cn.houhe.api.user.web.bo.RoleResouDto;
import cn.houhe.api.user.web.bo.RoleResouModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Spring MVC Controler - �：role
 *
 * @since 2017-03-30 13:50:02
 */
@Controller
@RequestMapping(value = "/role")
public class RoleAction {
    private static final Logger logger = LoggerFactory.getLogger(RoleAction.class);

    @Autowired
    private RoleService roleService;

    /**
     * 列表数据
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object listData(RoleDto roleDto) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            Criteria<Role> criteria = Criteria.create(Role.class);
            criteria.setPageSize(roleDto.getRows());
            criteria.setCurrentPage(roleDto.getPage());
            criteria.sortIfEmpty(Sort.desc("createdon"));
            Pager<Role> pager = roleService.findPage(criteria);
            if (roleDto.getRows() > 100)
                return pager.getList();
            resultMap.put("total", pager.getTotalRecords());
            resultMap.put("rows", pager.getList());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            if (roleDto.getRows() > 100)
                return null;
            resultMap.put("total", -1);
            resultMap.put("rows", null);
        }
        return resultMap;

    }

    /**
     * 新增保存
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object doAdd(@RequestBody RequestDto<Role> role) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            //ValidatorUtil.validate(role);
            roleService.insertSelective(role.getData());
            resultMap.put("result", 1);
        } catch (ValidatorException ve) {
            resultMap.put("result", 0);
            resultMap.put("message", ve.getMessage());
        } catch (Exception e) {
            resultMap.put("result", 0);
            resultMap.put("message", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultMap;
    }

    /**
     * 获取角色资源
     */
    @RequestMapping(value = "/get/{roleid}", method = RequestMethod.GET, produces = "application/json")
    public Object editPage(@PathVariable Integer roleid) {
        ResultDto result = new ResultDto("获取角色信息");
        try {
            Role role = roleService.findByPrimaryKey(roleid);
            result.setData(role);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    @RequestMapping(value = "/getrole/{roleid}", method = RequestMethod.GET, produces = "application/json")
    public Object getRole(@PathVariable Integer roleid) {
        ResultDto result = new ResultDto("获取角色资源信息");
        try {
            RoleResouDto role = roleService.selectForRole(roleid);
            result.setCode("0");
            result.setData(role);
        } catch (Exception e) {
            result.setCode("-1");
            result.setMsg(e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 修改保存
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Object doEdit(Role role) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            roleService.update(role);
            resultMap.put("result", 1);
        } catch (ValidatorException ve) {
            resultMap.put("result", 0);
            resultMap.put("message", ve.getMessage());
        } catch (Exception e) {
            resultMap.put("result", 0);
            resultMap.put("message", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultMap;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Object doDelete(List<Integer> ids) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            roleService.batchDelete(ids);
            resultMap.put("result", 1);
        } catch (Exception e) {
            resultMap.put("result", 0);
            resultMap.put("message", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultMap;
    }

    /**
     * 保存角色资源
     *
     * @param requestDto
     * @return
     */
    @RequestMapping(value = "/saveresource", method = RequestMethod.POST)
    @ResponseBody
    public Object saveResource(@RequestBody RequestDto<RoleResouModel> requestDto) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            RoleResouModel model = requestDto.getData();
            if (model.getRoleid() <= 0 || model.getResids().equals("")) {
                resultMap.put("result", 0);
                resultMap.put("message", "参数有误");
                return  resultMap;
            }
            String[] resids=model.getResids().split(",");
            List<RoleResourceExt> list = new ArrayList<RoleResourceExt>();
            for (String str:resids){
                if(str.equals(""))
                    continue;;
                RoleResourceExt r=new RoleResourceExt();
                r.setResId(Integer.parseInt(str));
                r.setRoleid(model.getRoleid());
                list.add(r);
            }

            roleService.assignResource(model.getRoleid(),list);
            resultMap.put("result", 1);
        } catch (Exception e) {
            resultMap.put("result", 0);
            resultMap.put("message", "系统异常");
            logger.error(e.getMessage(), e);
        }
        return resultMap;
    }
}