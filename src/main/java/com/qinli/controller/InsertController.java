package com.qinli.controller;

import com.qinli.pojo.RawUploadProject;
import com.qinli.service.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Cambria
 * @creat 2021/1/29 11:15
 */
@Controller
public class InsertController {

    @Autowired
    Insert insert;

    @RequestMapping(value = "insert")
    boolean insert(RawUploadProject rawUploadProject){
        return insert.insertOne(rawUploadProject);
    }

}
