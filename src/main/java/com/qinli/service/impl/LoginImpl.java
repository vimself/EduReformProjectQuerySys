package com.qinli.service.impl;

import com.qinli.mapper.UserMapper;
import com.qinli.pojo.User;
import com.qinli.service.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author supermantx
 * @time 2021/1/25 13:01
 * 登陆的服务层实现
 */
@Service
public class LoginImpl implements Login {


    @Autowired
    UserMapper userMapper;

    @Override
    public boolean isExist(String username) {
        User user = null;
        try {
            user = userMapper.isExist(username);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public User selectUser(String username, String pwd) {
        User user = null;
        boolean isExist = true;
        try {
            user = userMapper.isExist(username);
        } catch (Exception e){
            isExist = false;
        }

        if (!isExist) {
            return null;
        }

        user = userMapper.selectUser(username, pwd);
        return user;
    }
}
