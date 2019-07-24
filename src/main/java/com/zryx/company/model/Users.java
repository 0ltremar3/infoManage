package com.zryx.company.model;

import com.zryx.company.common.utils.User;

public class Users {
    private int userId;
    private String userName;
    private String password;
    private int status;

    public Users() {
    }

    public Users(int userId, String userName, String password, int status) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
//    默认的equals方法时比较两个对象的存储位置是否一致，以确定相等，这显然不符合业务需要
    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o instanceof Users){
            Users cur = (Users)o;
            return this.userId == cur.userId;
        }

        return false;

    }
}
