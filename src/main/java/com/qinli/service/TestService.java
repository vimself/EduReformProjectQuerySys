package com.qinli.service;

import com.qinli.mapper.UserMapper;
import com.qinli.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    UserMapper userMapper;

    public User getUsers(){
        return userMapper.selectUser("123");
    }
}
