package com.qinli.mapper;

import com.qinli.pojo.Project;
import com.qinli.pojo.RawUploadProject;

import java.util.List;

public interface ProjectMapper {
    List<Project> selectAll();
    List<Project> selectByDepartment(String department);
    List<Project> selectBySalaryNum(String salaryNum);
    List<Project> selectByName(String name);
    List<Project> selectById(String id);

    Boolean insertOne(RawUploadProject rawUploadProject);

    void deleteById(String id);

    String selectMember(String id);
    String selectRank(String id);
    String selectSalaryNumber(String id);

}
