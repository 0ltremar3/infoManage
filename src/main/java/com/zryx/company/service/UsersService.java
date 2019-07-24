package com.zryx.company.service;

import com.zryx.company.model.Users;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UsersService {

    /**
     * 查所有用户
     * @return
     */
    List<Users> getAllUsers();

    /**
     * 根据用户名密码查询用户
     * @param userName
     * @param password
     * @return
     */
    Users findUser(String userName,String password);

    /**
     * 用户注册（添加）
     * @param user
     */
    void userRegister(Users user);

    /**
     * 根据userId删除用户
     * @param userId
     */
    void delUser(int userId);

    /**
     * 修改用户信息
     * @param user
     */
    void updUser(Users user);

    Users isAdmin(String userName,String password);

    boolean isLogout(HttpSession session);

    boolean Login(HttpSession session,Users user);

}
