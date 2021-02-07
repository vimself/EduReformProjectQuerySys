package com.qinli.controller;

import com.qinli.pojo.LoginUser;
import com.qinli.pojo.User;
import com.qinli.service.Login;
import com.qinli.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/login")
    public LoginUser loginJud(String username , String pwd){
        LoginUser loginUser = new LoginUser();
        User user = null;
        if (true/*ct.equals("application/x-www-form-urlencoded")*/){
            if(login.isExist(username)){
                if ((user = login.selectUser(username, pwd)) != null){
                    loginUser.setStatus(200);
                    Map<String , String> userInfo = new HashMap<>();
                    userInfo.put("token" , JWTUtils.getToken(username , user.getAuthority()));
                    userInfo.put("authority" , user.getAuthority());
                    loginUser.setUserStatus(userInfo);
                }else{
                    loginUser.setStatus(500);
                }
            }else{
                loginUser.setStatus(400);
            }
        }else{
            loginUser.setStatus(500);
        }
        return loginUser;
    }
}
