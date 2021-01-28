package com.qinli.service.impl;

import com.qinli.mapper.ProjectMapper;
import com.qinli.service.Delete;
import org.apache.ibatis.session.SqlSessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class DeleteImpl implements Delete {

    @Autowired
    ProjectMapper projectMapper;

    @Override
    public boolean deleteById(String id) {

        try{
            projectMapper.deleteById(id);
        } catch (SqlSessionException e){
            return false;
        }

        return true;
    }
}
