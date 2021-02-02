package com.qinli.service.impl;

import com.qinli.mapper.ProjectMapper;
import com.qinli.pojo.Project;
import com.qinli.pojo.RawUploadProject;
import com.qinli.service.Insert;
import com.qinli.util.ProjectClassPackUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Cambria
 * @creat 2021/1/29 11:59
 */
@Service
public class InsertImpl implements Insert {

    @Autowired
    ProjectMapper projectMapper;


    @Override
    public boolean insertOne(Project project) {
        try {
            projectMapper.insertOne(new RawUploadProject(project));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean insertOne(RawUploadProject rawUploadProject) {
        try {
            projectMapper.insertOne(rawUploadProject);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
