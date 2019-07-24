package com.zryx.company.controller;

import com.zryx.company.common.web.BaseController;
import com.zryx.company.model.Chat;
import com.zryx.company.model.Users;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@RestController
public class ChatController extends BaseController {

    /**
     * 初始化聊天信息
     * @param session
     * @return
     */
    @PostMapping("/initChat")
    public String initChat(HttpSession session) {
        //根据session对象得到ServletContext对象。
        ServletContext application = session.getServletContext();
        //根据ServletContext对象的getAttribute方法得到用户列表。如果能够在此得到已经登录的用户列表。
        //那么肯定在此之前的某个地方已经向这个列表当中存过值。
        List<Users> users = (List<Users>)application.getAttribute("users");
        //取出当前用户
        Users user = (Users)session.getAttribute("user");
        //取出聊天信息
        Chat chat = (Chat)application.getAttribute("chat");
        //如果是第一个用户进来第一次聊天，chat是空的，那么就需要新建一个chat对象。以后就一直用这一个Chat对象
        if(chat == null) {
            chat = new Chat();
        }
        //将当前用户存入chat
        chat.setUser(user);
        //将当前登录的用户列表存入chat
        chat.setUsers(users);
        //将chat存入ServletContext对象
        application.setAttribute("chat",chat);
        //生成json
        String json = dealQueryResult(chat,chat);
        //返回json
        return json;
    }

    /**
     * 发送聊天信息
     * @param session
     * @param msg 聊天信息
     * @return
     */
    @PostMapping("/sendChat")
    public String sendChat(HttpSession session,String msg) {
        //得到ServeltContext对象
        ServletContext application = session.getServletContext();
        //从ServletContext对象中取出聊天对象
        Chat chat = (Chat)application.getAttribute("chat");
        //从聊天对象当中取出聊天列表
        LinkedList<String> chats = chat.getChats();
        //从session当中取出当前用户
        Users user = (Users)session.getAttribute("user");
        //向聊天对象当中添加聊天信息
        chats.addLast((user.getUserName()+"说："+msg));

        //生成个json返回
        return dealQueryResult(chat,chat);
    }
}
