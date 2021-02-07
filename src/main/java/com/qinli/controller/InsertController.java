package com.qinli.controller;

import com.qinli.pojo.Project;
import com.qinli.pojo.RawUploadProject;
import com.qinli.service.Insert;
import com.qinli.util.HSSFUtil;
import com.qinli.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author Cambria
 * @creat 2021/1/29 11:15
 * 添加项目相关操作
 */
@Controller
public class InsertController {

    @Autowired
    Insert insert;

    /**
     * 添加单个项目
     * @param project 要添加的项目
     * @return 操作状态
     */
    @RequestMapping(value = "insert" )
    @ResponseBody
    Map<String , Integer> insert(Project project){
        boolean result = insert.insertOne(project);

        Map<String , Integer> json = new HashMap<>();
        json.put("status",result?200:500);

        return json;
    }

    /**
     * 文件上传至服务端并从文件中读取项目信息，存入数据库
     * @param file 上传的文件
     * @return 操作状态
     * @throws IOException 讲道理应该不会抛出来这个错误
     */
    @RequestMapping(value = "uploadXls")
    @ResponseBody
    Map<String , Integer> uploadXls(MultipartFile file) throws IOException {
        Map <String , Integer> json = new HashMap<>();
        //标记操作是否成功
        boolean flag = false;

        //仅文件大小大于0且后缀为xls才会执行保存和读取操作
        if (file.getSize() > 0 && file.getOriginalFilename().endsWith("xls")) {
            //以当前毫秒数命名文件，防止重名
            String filename = String.valueOf(System.currentTimeMillis());
            String path = Utils.getProjectPath() + File.pathSeparator + "xls" + File.pathSeparator + filename + ".xls";

            file.transferTo(new File(path));

            //读取xls文件内容，每一行为一个project对象
            List<RawUploadProject> projects = HSSFUtil.readXls(path);
            System.out.println(projects.toString());

            //依次将每个project存入数据库中
            Iterator<RawUploadProject> iterator = projects.iterator();
            while (iterator.hasNext()) {
                RawUploadProject rawUploadProject = iterator.next();
                System.out.println(rawUploadProject.toString());
                if (!insert.insertOne(rawUploadProject)) {
                    System.out.println("GG");
                    json.put("status" , 500);
                    return json;
                }
            }

            flag = true;
        }

        json.put("status" , flag?200:500);
        return json;
    }

}
