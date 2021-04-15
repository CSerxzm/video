package com.xzm.video.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 文件上传接口
 */
@Controller
public class FileController {

    @PostMapping("/user/uploadvideo")
    @ResponseBody
    public String uploadVideo(@RequestParam("video") MultipartFile video,
                         HttpServletRequest request){
        return transfer(video,request);
    }

    @PostMapping("/user/uploadpic")
    @ResponseBody
    public String uploadPic(@RequestParam("pic") MultipartFile pic,
                         HttpServletRequest request){
        return transfer(pic,request);
    }

    @PostMapping("/uploadpicwithoutlogin")
    @ResponseBody
    public String uploadPicWithoutLogin(@RequestParam("pic") MultipartFile pic,
                            HttpServletRequest request){
        return transfer(pic,request);
    }

    public String transfer(MultipartFile file,HttpServletRequest request){
        String serverPath = request.getScheme() + "://"+request.getServerName()+":" +
                request.getServerPort() + request.getContextPath() + "/file/";
        String path = request.getServletContext().getRealPath("/file/");
        String picNameCode = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
        String picName = file.getOriginalFilename();
        String [] videos = picName.split("\\.");
        picNameCode=picNameCode+"."+videos[1];
        File filePath = new File(path, picNameCode);
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
        }
        try {
            file.transferTo(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return serverPath+picNameCode;
    }
}
