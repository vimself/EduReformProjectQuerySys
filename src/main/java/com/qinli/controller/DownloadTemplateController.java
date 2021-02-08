package com.qinli.controller;

import com.qinli.util.Utils;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author Cambria
 * @creat 2021/2/8 15:14
 */
@Controller
public class DownloadTemplateController {

    /**
     * 暂未使用的文件下载服务
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(path = "/downloadTemplate")
    public void downloadTemplate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("download template");

        String path = Utils.getProjectPath() + File.pathSeparator + "xls" + File.pathSeparator + "template.xls";  // doenLoadPath是文件路径(一般指服务器上的磁盘位置)
        File file = new File(path);
        if(file.exists()){
            //response.setContentType("application/vnd.ms-excel");
            //设置Content-Disposition

            InputStream in = new FileInputStream(file);
            OutputStream out = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            //循环取出流中的数据
            while((len = in.read(buffer)) != -1){
                out.write(buffer,0,len);
            }

            in.close();
            out.close();
        }

        return;
    }

}
