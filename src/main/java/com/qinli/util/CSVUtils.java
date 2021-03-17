package com.qinli.util;

import com.qinli.pojo.RawUploadProject;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 操作csv格式文件所需工具
 * @Author Cambria
 * @creat 2021/3/17 9:31
 */
public class CSVUtils {
    /**
     * 读取csv
     * @param path 文件目录
     * @return 封装完成的project对象的链表
     * @throws IOException 讲道理应该不会出这错误
     */
    public static List<RawUploadProject> readCsv(String path) throws IOException {
        List<RawUploadProject> projects = new ArrayList<>();
        //readline()方法比较方便，就直接拿BufferedReader读数据了(效率？啥是效率？前端都让我那么封装数据了还用在乎效率？)
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)), "utf-8"));
        br.readLine();
        String project = null;
        boolean flag = true;
        while ((project = br.readLine()) != null) {
            //System.out.println(project);
            String[] temp = project.split(",");

            //占位符置为空
            for (int i = 0 ; i < 15 ; i++){
                if (temp[i].equals("x")) {
                    temp[i] = "";
                }
            }

            //两个if和一个try catch作简单的数据校验，验证id非空，成员格式、日期格式合法
            if (temp[0].toString().equals("")) {
                flag = false;
                break;
            }

            String[] splited = temp[4].toString().split("/|-");
            if (splited.length % 3 != 0) {
                flag = false;
                break;
            }

            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

                simpleDateFormat.parse(temp[5].toString());
                simpleDateFormat.parse(temp[6].toString());

                Integer.parseInt(temp[8].toString());
            } catch (Exception e) {
                flag = false;
                break;
            }

            //验证通过后加入链表中
            projects.add(new RawUploadProject(temp[0] , temp[1] , temp[2] , temp[3] , temp[4] , temp[5] , temp[6] , temp[7] , temp[8] , temp[8] , temp[10] , temp[11] , temp[12] , temp[13] , temp[14]));
        }

        if (!flag){
            //校验失败则不入库
            return null;
        }

        return projects;
    }
}
