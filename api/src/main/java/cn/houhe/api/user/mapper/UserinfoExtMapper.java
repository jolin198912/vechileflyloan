package cn.houhe.api.user.mapper;

import cn.houhe.api.user.entity.Userinfo;
import cn.houhe.api.user.web.bo.LoginModel;
import cn.houhe.api.user.web.bo.UserDto;
import cn.houhe.api.user.web.bo.UserModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MyBatis Mapper 接口 - ：userinfo
 * @since 2017-03-30 13:50:02
 */
@Repository
public interface UserinfoExtMapper {
	List<UserModel> selectForUser(@Param("dto") UserDto dto, @Param("page") int start, @Param("rows") int size);
	Integer selectForUserCount(@Param("dto") UserDto dto);
	UserModel findByAccountAndPwd(@Param("account") String account, @Param("pwd") String pwd);
	LoginModel findByUid(Integer uid);
	void addRolesToUser(@Param("uid")Integer uid,@Param("rid")Integer rid);
    List<Map> getAuditPerson(@Param("resCode") String resCode);
	HashMap selectUserInfoByMobile(@Param("account")String account);
	LoginModel findByURole(Integer uid);
	LoginModel findByUpdatePwd(Integer uid);

    /**
     * 按主键删除
     * @since 2017-03-30 13:50:02
     */
    int deleteUserRole(Integer usid);
	List<UserModel> userNameCheck(@Param("account") String account);
}
