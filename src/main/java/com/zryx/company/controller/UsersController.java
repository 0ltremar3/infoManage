package com.zryx.company.controller;

import com.zryx.company.common.exception.CustomException;
import com.zryx.company.common.web.BaseController;
import com.zryx.company.model.Users;
import com.zryx.company.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController extends BaseController {

    @Autowired
    UsersService usersService;

    @PostMapping("/getAllUsers")
    public String getAllUsers(){
        List<Users> users = usersService.getAllUsers();
        String json = dealQueryResult(users,users);
        logger.debug("Json-->" + json);
        return json;
    }

    @PostMapping("/findUser")
    public String findUser(String userName,String password){
        Users user = usersService.findUser(userName,password);
        String json = dealQueryResult(user,user);
        logger.debug("Json-->" + json);
        return json;
    }

    @PostMapping("/userRegister")
    public String userRegister(Users user){
        usersService.userRegister(user);
        return dealSuccessResutl("注册成功",null);
    }

    @PostMapping("/delUser")
    public String delUser(int userId){
        usersService.delUser(userId);
        return dealSuccessResutl("删除成功",null);
    }

    @PostMapping("/updUser")
    public String updUser(Users user){
        usersService.updUser(user);
        return dealSuccessResutl("修改成功",null);
    }

    @PostMapping("/isAdmin")
    public String isAdmin(String userName,String password){
        Users user = usersService.isAdmin(userName,password);
        if (user != null){
            return dealSuccessResutl("login success",null);
        }else {
            throw new CustomException(1400,"登录失败，无后台操作权限");
        }
    }
}
