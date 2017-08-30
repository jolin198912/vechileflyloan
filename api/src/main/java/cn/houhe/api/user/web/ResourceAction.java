package cn.houhe.api.user.web;

import cn.houhe.api.common.RequestDto;
import cn.houhe.api.user.entity.ResourceExt;
import cn.houhe.api.user.service.ResourceService;
import cn.houhe.api.user.service.RoleService;
import cn.houhe.api.user.web.bo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Spring MVC Controler - 表：resource
 *
 * @since 2017-04-10 16:42:07
 */
@Controller
@RequestMapping(value = "/resource")
public class ResourceAction {
    private static final Logger logger = LoggerFactory.getLogger(ResourceAction.class);

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private RoleService roleService;

    /**
     * 获取角色资源列表数据
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Object listData(@RequestBody RequestDto<RoleDto> requestDto) {
        try {
            List<ResourceExt> list = resourceService.findAllResource();
            RoleResouDto role = roleService.selectForRole(requestDto.getData().getId());
            List<Integer> reslist = new ArrayList<>();
            for (ResDto item : role.getResList()) {
                reslist.add(item.getRes_id());
            }
            List<ResourceDto> list1 = new ArrayList<ResourceDto>();
            for (ResourceExt resourceExt : list) {
                ResourceDto dto = new ResourceDto();
                dto.setId(resourceExt.getResId());
                dto.setCode(resourceExt.getResCode());
                dto.setText(resourceExt.getResName());
                dto.setAttribute(new AttributeDto(resourceExt.getIsSingle(), resourceExt.getParentId() + ""));
                if (resourceExt.getChildList().size() > 0) {
                    for (ResourceExt resourceExt1 : resourceExt.getChildList()) {
                        ResourceDto dto1 = new ResourceDto();
                        dto1.setId(resourceExt1.getResId());
                        dto1.setCode(resourceExt1.getResCode());
                        dto1.setText(resourceExt1.getResName());
                        dto1.setAttribute(new AttributeDto(resourceExt1.getIsSingle(), resourceExt1.getParentId() + ""));
                        if (resourceExt1.getChildList().size() > 0) {
                            for (ResourceExt resourceExt2 : resourceExt1.getChildList()) {
                                ResourceDto dto2 = new ResourceDto();
                                dto2.setId(resourceExt2.getResId());
                                dto2.setCode(resourceExt2.getResCode());
                                dto2.setText(resourceExt2.getResName());
                                dto2.setAttribute(new AttributeDto(resourceExt2.getIsSingle(), resourceExt2.getParentId() + ""));
                                dto2.setChecked(reslist.contains(resourceExt2.getResId()));
                                dto1.children.add(dto2);
                            }
                        } else {
                            dto1.setChecked(reslist.contains(resourceExt1.getResId()));
                        }
                        dto.children.add(dto1);
                    }
                } else {
                    dto.setChecked(reslist.contains(resourceExt.getResId()));
                }
                list1.add(dto);
            }
            return list1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }
}