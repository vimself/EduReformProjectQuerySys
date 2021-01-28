package com.qinli.mapper;

import com.qinli.pojo.Project;

import java.util.List;

public interface ProjectMapper {
    List<Project> selectAll();
    List<Project> selectByDepartment(String department);
    List<Project> selectBySalaryNum(String salaryNum);
    List<Project> selectByName(String name);
    List<Project> selectById(String id);

    void deleteById(String id);

    String selectMember(String id);
    String selectRank(String id);
    String selectSalaryNumber(String id);

}
