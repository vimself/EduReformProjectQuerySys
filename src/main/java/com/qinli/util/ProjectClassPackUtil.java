package com.qinli.util;

import com.qinli.mapper.ProjectMapper;
import com.qinli.pojo.Project;
import com.qinli.pojo.RawUploadProject;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 工具类，格式化project对象，使其成为前端要求的数据格式
 */
@Component
public class ProjectClassPackUtil {


    /**
     * 封装Project对象的member属性
     * @param projects 将返回的project对象
     * @param projectMapper 查询接口
     * @return 封装好的Project对象
     */
    public static List<Project> projectClassPack(List<Project> projects , ProjectMapper projectMapper){
        //使用迭代器遍历所有的project对象
        Iterator<Project> i = projects.iterator();

        while (i.hasNext()){
            //读入一个project对象
            Project tempp = i.next();
            //重置缓存的memberList
            List<Map<String , String>> temppMember = new ArrayList();
            //从数据库中查询到字符串形式的member记录
            String temps = projectMapper.selectMember(tempp.getId());

            //切分字符串，存入List
            String[] tempa = temps.split("/");
            int count = 1;
            for (String s : tempa){
                Map<String , String> tempm = new HashMap();
                tempm.put("id" , Integer.toString(count++));
                tempm.put("info" , s);
                temppMember.add(tempm);
            }
            //以封装好的member设置project对象中的member
            tempp.setMember(temppMember);
        }

        return projects;
    }
}
