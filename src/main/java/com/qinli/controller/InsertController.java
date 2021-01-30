package com.qinli.controller;

import com.qinli.pojo.Project;
import com.qinli.pojo.RawUploadProject;
import com.qinli.service.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Cambria
 * @creat 2021/1/29 11:15
 */
@Controller
public class InsertController {

    @Autowired
    Insert insert;

    @RequestMapping(value = "insert")
    @ResponseBody
    Map<String , Integer> insert(@RequestBody Project project){
        boolean result = insert.insertOne(project);

        Map<String , Integer> json = new HashMap<>();
        json.put("status",result?200:500);

        return json;
    }

}
