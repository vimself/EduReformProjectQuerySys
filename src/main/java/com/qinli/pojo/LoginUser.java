package com.qinli.pojo;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author Cambria
 * @creat 2021/2/1 15:22
 * 储存已登录用户的登陆状态、用户名、权限
 */
public class LoginUser implements Serializable {
    private int status;
    private Map<String , String> userStatus;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, String> getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Map<String, String> userStatus) {
        this.userStatus = userStatus;
    }
}
