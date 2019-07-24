package com.zryx.company.model;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

public class Chat {
    //参与聊天的用户列表
    private List<Users> users;
    //当前用户
    private Users user;
    //聊天列表
    private LinkedList<String> chats = new LinkedList<>();

    public Chat() {

    }

    public Chat(List<Users> users, LinkedList<String> chats) {
        this.users = users;
        this.chats = chats;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }


    public LinkedList<String> getChats() {
        return chats;
    }

    public void setChats(LinkedList<String> chats) {
        this.chats = chats;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
