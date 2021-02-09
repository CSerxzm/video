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
 * 视频上传接口
 */
@Controller
public class FileController {

    @PostMapping("/user/uploadvideo")
    @ResponseBody
    public String uploadvideo(@RequestParam("video") MultipartFile video,
                              HttpServletRequest request)
            throws IllegalStateException, IOException {

        String serverPath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + request.getContextPath() + "/file/";
        String path = request.getServletContext().getRealPath("/file/");
        String videoNameCode = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
        String videoName = video.getOriginalFilename();
        String[] videos = videoName.split("\\.");
        videoNameCode = videoNameCode + "." + videos[1];
        File filePath = new File(path, videoNameCode);
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
        }
        video.transferTo(filePath);
        System.out.println(filePath);
        return serverPath + videoNameCode;
    }

    @PostMapping("/user/uploadpic")
    @ResponseBody
    public String uploadpic(@RequestParam("pic") MultipartFile pic,
                            HttpServletRequest request)
            throws IllegalStateException, IOException {

        String serverPath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + request.getContextPath() + "/file/";
        String path = request.getServletContext().getRealPath("/file/");
        String picNameCode = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
        String picName = pic.getOriginalFilename();
        String[] videos = picName.split("\\.");
        picNameCode = picNameCode + "." + videos[1];
        File filePath = new File(path, picNameCode);
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
        }
        pic.transferTo(filePath);
        System.out.println(filePath);
        return serverPath + picNameCode;
    }
}
