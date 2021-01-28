package com.qinli.controller;

import com.qinli.pojo.Project;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class UpdateController {

    @RequestMapping(value = "update")
    @ResponseBody
    Map<String , Integer> update(Project project){
        return null;
    }
}
