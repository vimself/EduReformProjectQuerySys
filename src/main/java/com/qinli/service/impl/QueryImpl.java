package com.qinli.service.impl;

import com.qinli.mapper.ProjectMapper;
import com.qinli.pojo.Project;
import com.qinli.service.Query;
import com.qinli.util.ProjectClassPackUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QueryImpl implements Query {

    @Autowired
    ProjectMapper projectMapper;

    /**
     * 各种查询方法，tomcat部署项目好像没办法让util调用Autowired资源，只能把封装写进这里了
     * 以后改springboot部署的话应该能直接return projectClassPack(projectMapper.selectAll());
     *
     * @return 一个List，内容为各个项目
     */
    @Override
    public List<Project> queryAll() {
        return ProjectClassPackUtil.projectClassPack(projectMapper.selectAll() , projectMapper);
    }

    @Override
    public List<Project> queryByDepartment(String department) {
        return ProjectClassPackUtil.projectClassPack(projectMapper.selectByDepartment(department) , projectMapper);
    }

    @Override
    public List<Project> queryBySalaryNum(String salaryNum) {
        return ProjectClassPackUtil.projectClassPack(projectMapper.selectBySalaryNum(salaryNum) , projectMapper);
    }

    @Override
    public List<Project> queryByName(String name) {
        return ProjectClassPackUtil.projectClassPack(projectMapper.selectByName(name) , projectMapper);
    }

    @Override
    public List<Project> queryById(String id) {
        return ProjectClassPackUtil.projectClassPack(projectMapper.selectById(id) , projectMapper);
    }
}
