package com.zryx.company.mapper;

import com.zryx.company.common.utils.User;
import com.zryx.company.model.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersMapper {

    List<Users> getAllUsers();
    /**
     * 根据用户名和密码查询用户
     * @param userName
     * @param password
     * @return
     */
    Users findUser(@Param("userName") String userName, @Param("password") String password);

    /**
     * 用户注册
     * @param
     * @return
     */
    int userRegister(Users user);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    int delUser(@Param("userId") int userId);

    /**userId
     * 修改用户
     * @param user
     * @return
     */
    int updUser(Users user);

    /**
     * 确认登录用户权限
     * @param
     * @return status=1为有后台登录权限
     */
    Users isAdmin(@Param("userName") String userName, @Param("password") String password);


}
