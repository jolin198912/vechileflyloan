package cn.houhe.api.facade;

import cn.houhe.api.user.service.RoleService;
import cn.houhe.api.user.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by think on 2017/4/1.
 */
@Component
public class UserFacade {

    @Autowired
    private UserinfoService userService;

    @Autowired
    private RoleService  roleService;


    public void AddUser() {

    }
}
