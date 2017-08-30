package cn.houhe.api.user.web;

import cn.houhe.api.common.RequestDto;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.user.service.UserinfoService;
import cn.houhe.api.user.web.bo.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by victorrrr on 2017/5/31.
 */
@Controller
@RequestMapping(value = "/user/boss")
public class UserBossAppAction {

    @Autowired
    private UserinfoService userinfoService;
    /**
     * 老板端APP登录
     */
    @RequestMapping(value = "/bossLogin", method = RequestMethod.POST)
    @ResponseBody
    public Object BossLogin(@RequestBody RequestDto<UserDto> param) {
        return userinfoService.findUserInfoByMobile(param);
    }
}
