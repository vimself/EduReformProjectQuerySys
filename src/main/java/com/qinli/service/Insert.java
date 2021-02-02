package com.qinli.service;

import com.qinli.pojo.Project;
import com.qinli.pojo.RawUploadProject;

/**
 * @Author Cambria
 * @creat 2021/1/29 11:58
 */
public interface Insert {

    boolean insertOne(Project project);
    boolean insertOne(RawUploadProject rawUploadProject);

}
