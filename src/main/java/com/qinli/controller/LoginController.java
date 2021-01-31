package com.qinli.controller;

import com.qinli.pojo.LoginValue;
import com.qinli.pojo.User;
import com.qinli.service.Login;
import com.qinli.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author supermantx
 * @time 2021/1/25 12:11
 * 登陆部分的控制器
 * 半年没碰java后的杰作(啥也不是)
 */

@Controller
public class LoginController {

    @Autowired
    Login login;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String , Object> loginJud(@RequestHeader("Content-Type")String ct, String username, String pwd){
        Map<String , Object> json = new HashMap<>();
        final User user = new User(username, pwd);
        if (ct.equals("application/x-www-form-urlencoded")){
            if(login.isExist(username)){
                if (login.selectUser(username, pwd) != null){
                    json.put("status" , 200);
                    class LoginUser {
                        String token = JWTUtils.getToken(user);
                        String authority = user.getAuthority();
                    }
                    json.put("user" , new LoginUser());
                }else{
                    json.put("status" , 500);
                }
            }else{
                json.put("status" , 400);
            }
        }else{
            json.put("status" , 500);
        }
        return json;
    }
}
