package com.qinli.mapper;

import com.qinli.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User selectUser(@Param("username") String username , @Param("pwd") String pwd);
    User isExist(String username);
}
