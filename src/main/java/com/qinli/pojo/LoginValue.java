package com.qinli.pojo;

import java.io.Serializable;

/**
 * @author supermantx
 * @time 2021/1/25 12:36
 *  登陆时返回的信息
 */
public class LoginValue implements Serializable {
    int staCode;
    User user;
    String token;
    public int getStaCode() {
        return staCode;
    }

    public void setStaCode(int staCode) {
        this.staCode = staCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "staCode=" + staCode +
                ", user=" + user +
                '}';
    }
}
