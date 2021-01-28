package com.qinli.service;

import com.qinli.pojo.Project;

import java.util.List;

/**
 * 各种查询请求
 */
public interface Query {
    List<Project> queryAll();
    List<Project> queryByDepartment(String department);
    List<Project> queryBySalaryNum(String salaryNum);
    List<Project> queryByName(String name);
    List<Project> queryById(String id);
}
