package com.qinli.controller;

import com.qinli.pojo.Project;
import com.qinli.service.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 根据各关键字请求项目列表
 */
@Controller
public class QueryController {

    @Autowired
    Query query;

    /**
     * 查询项目
     * @param query_by 查询选项，0所有；1根据部门查询；2根据工资号查询；3根据主持人姓名查询；4根据项目号查询
     * @param key 查询关键字
     * @return 查询结果的List对象
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Map<String, Object> queryForList(int query_by , String key) {
        List<Project> result = null;
        Map<String , Object> json = new HashMap();

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
        json.put("status" , 200);

        return json;
    }
}
