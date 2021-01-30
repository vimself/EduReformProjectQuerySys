package com.qinli.controller;

import com.qinli.service.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DeleteController {

    @Autowired
    Delete delete;

    @RequestMapping(value = "delete")
    @ResponseBody
    Map<String , Integer> delete(String[] del){
        Map<String , Integer> json = new HashMap<String, Integer>();

        for (String s : del){
            if (!delete.deleteById(s)) {
                json.put("status" , 500);
                return json;
            }
        }

        json.put("status" , 200);
        return json;
    }
}
