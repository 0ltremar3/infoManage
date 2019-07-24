package com.zryx.company.service.imp;

import com.zryx.company.common.exception.CustomException;
import com.zryx.company.common.utils.User;
import com.zryx.company.mapper.UsersMapper;
import com.zryx.company.model.Users;
import com.zryx.company.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<Users> getAllUsers() {
        List<Users> users = usersMapper.getAllUsers();
        return users;
    }

    @Override
    public Users findUser(String userName, String password) {
        Users user = usersMapper.findUser(userName, password);
        return user;
    }

    @Override
    public void userRegister(Users user) {
        int row = usersMapper.userRegister(user);
        if (row > 0) {
            System.out.println("注册成功");
        } else {
            throw new CustomException(100, "用户注册失败");
        }
    }

    @Override
    public void delUser(int userId) {
        int row = usersMapper.delUser(userId);
        if (row > 0) {
            System.out.println("删除成功");
        } else {
            throw new CustomException(100, "删除失败");
        }
    }

    @Override
    public void updUser(Users user) {
        int row = usersMapper.updUser(user);
        if (row > 0) {
            System.out.println("修改成功");
        } else {
            throw new CustomException(100, "修改失败");
        }
    }

    @Override
    public Users isAdmin(String userName, String password) {
        Users user = usersMapper.isAdmin(userName, password);
        return user;
    }

    @Override
    public boolean isLogout(HttpSession session) {
        //怎么移除ServletContext中users集合里的user？
        //先取得当前用户，再从ServletContext中删除
        Users user = (Users) session.getAttribute("user");
        ServletContext application = session.getServletContext();
        List<Users> users = (List<Users>) application.getAttribute("users");

        boolean isRemove = users.remove(user);
        System.out.println("当前用户：" + user.toString());
        System.out.println("当前用户列表：" + users.toString());
        if (isRemove) {
            session.removeAttribute("user");
            session.invalidate();
            return true;
        }else {
            System.out.println("退出失败");
        }

        return false;
    }

    @Override
    public boolean Login(HttpSession session, Users user) {
        Users dbUser = usersMapper.findUser(user.getUserName(), user.getPassword());
        if (dbUser != null) {
            //向session当中存储了当前的用户
            session.setAttribute("user", dbUser);
            //我们存来没有向ServletContext当中存储数据的时候，users就是空的
            List<Users> users = (List<Users>) session.getServletContext().getAttribute("users");
            if (users == null) {
                users = new ArrayList<Users>();
            }
            //如果列表中没有当前用户，再添加
            if (!users.contains(dbUser)) {
                //导致删除失败的罪魁祸首是这句！！！
                users.add(dbUser);
            }else {//有这个用户就是登过
                throw new CustomException(1900,"已登录过！");
            }
            //ServletContext存所有在这个界面上的用户
            session.getServletContext().setAttribute("users", users);
            return true;
        }
        return false;
    }
}
