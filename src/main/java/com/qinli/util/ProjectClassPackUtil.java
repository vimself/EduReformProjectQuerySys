package com.qinli.util;

import com.qinli.mapper.ProjectMapper;
import com.qinli.pojo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProjectClassPackUtil {


    public static List<Project> projectClassPack(List<Project> projects , ProjectMapper projectMapper){
        Iterator<Project> i = projects.iterator();
        Project tempp;
        String temps;


        ArrayList temppMember = new ArrayList();
        while (i.hasNext()){
            tempp = i.next();
            temppMember.clear();
            temps = projectMapper.selectMember(tempp.getId());
            String[] tempa = temps.split("/");
            int count = 1;
            for (String s : tempa){
                Map<String , String> tempm = new HashMap();
                tempm.put("id" , Integer.toString(count++));
                tempm.put("info" , s);
                temppMember.add(tempm);
            }
            tempp.setMember(temppMember);
        }

        return projects;
    }
}
