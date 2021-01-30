package com.qinli.controller;

import com.qinli.pojo.Project;
import com.qinli.service.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UpdateController {

    @Autowired
    Update update;

    @RequestMapping(value = "update")
    @ResponseBody
    Map<String , Integer> update(Project project){
        boolean result = update.updateOne(project);

        Map<String , Integer> json = new HashMap<>();
        json.put("status",result?200:500);

        return json;
    }
}
