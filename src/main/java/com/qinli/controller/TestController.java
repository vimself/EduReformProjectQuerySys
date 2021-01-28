package com.qinli.controller;

import com.qinli.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "asdk")
    public void test(HttpServletResponse response) throws IOException {
        System.out.println(testService.getUsers().toString());
        return;
    }
}
