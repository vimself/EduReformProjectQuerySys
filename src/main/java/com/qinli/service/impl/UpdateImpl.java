package com.qinli.service.impl;

import com.qinli.mapper.ProjectMapper;
import com.qinli.pojo.Project;
import com.qinli.pojo.RawUploadProject;
import com.qinli.service.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Cambria
 * @creat 2021/1/30 17:23
 */
@Service
public class UpdateImpl implements Update {
    @Autowired
    ProjectMapper projectMapper;

    @Override
    public boolean updateOne(Project project) {
        try {
            projectMapper.updateOne(new RawUploadProject(project));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
