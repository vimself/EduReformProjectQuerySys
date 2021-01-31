package com.qinli.service;

import com.qinli.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author supermantx
 * @time 2021/1/25 12:58
 * 登陆的服务层
 */
public interface Login {

    User selectUser(String username , String pwd);
    boolean isExist(String username);
}
