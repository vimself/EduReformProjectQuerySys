package com.qinli.test;

import com.qinli.mapper.UserMapper;
import com.qinli.pojo.User;
import com.qinli.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Test01 {

    @Autowired
    TestService testService;
    @Test
    void test01() {
        System.out.println(testService.getUsers().toString());
    }
}
