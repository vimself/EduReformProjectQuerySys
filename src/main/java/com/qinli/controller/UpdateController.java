package com.qinli.controller;

import com.qinli.pojo.Project;
import com.qinli.service.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 修改已有项目相关操作
 */
@Controller
public class UpdateController {

    @Autowired
    Update update;

    /**
     * 修改单个项目
     * @param project 修改后的项目信息
     * @return 操作状态
     */
    @RequestMapping(value = "update")
    @ResponseBody
    Map<String , Integer> update(Project project){
        boolean result = update.updateOne(project);

        Map<String , Integer> json = new HashMap<>();
        json.put("status",result?200:500);

        return json;
    }
}
