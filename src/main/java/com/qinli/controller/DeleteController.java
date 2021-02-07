package com.qinli.controller;

import com.qinli.service.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 删除相关操作
 */
@Controller
public class DeleteController {

    @Autowired
    Delete delete;

    /**
     * 根据要删除的项目id逐个删除
     * @param del 要删除的项目id列表
     * @return 操作状态
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    Map<String , Integer> delete(String del){
        Map<String , Integer> json = new HashMap<String, Integer>();

        if (!delete.deleteById(del)) {
            json.put("status" , 500);
            return json;
        }

        json.put("status" , 200);
        return json;
    }
}
