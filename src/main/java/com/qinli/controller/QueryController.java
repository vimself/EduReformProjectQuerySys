package com.qinli.controller;

import com.qinli.pojo.Project;
import com.qinli.service.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 请求根据各关键字项目列表
 */
@Controller
public class QueryController {

    @Autowired
    Query query;

    @RequestMapping(value = "query")
    @ResponseBody
    public Map<String, List<Project>> queryForList(int query_by , String key , HttpServletResponse response) throws IOException {
        List<Project> result = null;
        Map<String , List<Project>> json = new HashMap();

        switch (query_by){
            case 0:
                result = query.queryAll();
                break;

            case 1:
                result = query.queryByDepartment(key);
                break;

            case 2:
                result = query.queryBySalaryNum(key);
                break;

            case 3:
                result = query.queryByName(key);
                break;

            case 4:
                result = query.queryById(key);
                break;

            default:
                break;
        }

        json.put("list" , result);

        return json;
    }
}
