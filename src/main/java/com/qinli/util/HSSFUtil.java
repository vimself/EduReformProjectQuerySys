package com.qinli.util;


import com.qinli.pojo.RawUploadProject;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Cambria
 * @creat 2021/2/2 10:05
 */
public class HSSFUtil {

    public static List<RawUploadProject> readXls(String path) throws IOException {
        HSSFWorkbook workbook;
        try {
            workbook = new HSSFWorkbook(new FileInputStream(path));
        } catch (IOException e) {
            //找不到文件
            return null;
        }

        HSSFSheet sheet = workbook.getSheetAt(0);

        int lastRowNum = sheet.getLastRowNum();

        List<RawUploadProject> projects = new ArrayList<RawUploadProject>();

        boolean flag = true;
        for (int i = 1; i <= lastRowNum; i++) {
            System.out.println("lastRowNum:" + lastRowNum);
            HSSFRow row = sheet.getRow(i);

            if (row.getCell(0).toString().equals("")) {
                flag = false;
                break;
            }

            String[] splited = row.getCell(4).toString().split("/|-");
            if (splited.length % 3 != 0) {
                flag = false;
                break;
            }

            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                simpleDateFormat.parse(row.getCell(5).toString());
                simpleDateFormat.parse(row.getCell(6).toString());

                Integer.parseInt(row.getCell(8).toString());
            } catch (Exception e) {
                flag = false;
                break;
            }

            projects.add(convertProject(row));

        }

        if (!flag) {
            //System.out.println("JXGG");
            return null;
        }

        return projects;
    }

    static RawUploadProject convertProject(HSSFRow row){
        RawUploadProject rawUploadProject = new RawUploadProject();

        rawUploadProject.setId(row.getCell(0).toString());

        rawUploadProject.setTitle(row.getCell(1).toString());

        rawUploadProject.setHost(row.getCell(2).toString());

        rawUploadProject.setDepartment(row.getCell(3).toString());

        rawUploadProject.setMember(row.getCell(4).toString());

        rawUploadProject.setStart_time(row.getCell(5).toString());

        rawUploadProject.setEnd_time(row.getCell(6).toString());

        rawUploadProject.setProject_status(row.getCell(7).toString());

        rawUploadProject.setFunds(row.getCell(8).toString());

        rawUploadProject.setLevel(row.getCell(9).toString());

        try {
            rawUploadProject.setHost_school(row.getCell(10).toString());
        } catch (Exception e) {
            rawUploadProject.setHost_school(null);
        }

        try {
            rawUploadProject.setCoop_school(row.getCell(11).toString());
        } catch (Exception e) {
            rawUploadProject.setCoop_school(null);
        }

        rawUploadProject.setGuide_id(row.getCell(12).toString());

        try {
            rawUploadProject.setRecommend(row.getCell(13).toString());
        } catch (Exception e) {
            rawUploadProject.setRecommend(null);
        }

        try {
            rawUploadProject.setCode(row.getCell(14).toString());
        } catch (Exception e) {
            rawUploadProject.setCode(null);
        }

        return rawUploadProject;
    }

}
