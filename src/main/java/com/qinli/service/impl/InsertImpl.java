package com.qinli.service.impl;

import com.qinli.mapper.ProjectMapper;
import com.qinli.pojo.RawUploadProject;
import com.qinli.service.Insert;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author Cambria
 * @creat 2021/1/29 11:59
 */
public class InsertImpl implements Insert {

    @Autowired
    ProjectMapper projectMapper;


    @Override
    public boolean insertOne(RawUploadProject rawUploadProject) {
        return projectMapper.insertOne(rawUploadProject);
    }
}
