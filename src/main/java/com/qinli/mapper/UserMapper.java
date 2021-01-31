package com.qinli.mapper;

import com.qinli.pojo.User;

public interface UserMapper {

    User selectUser(String username , String pwd);
    User isExist(String username);
}
