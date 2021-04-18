package com.xzm.video.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 上传视频
     * @param video
     * @param request
     * @return
     */
    @PostMapping("/user/uploadvideo")
    @ResponseBody
    public String uploadVideo(@RequestParam("video") MultipartFile video,
                         HttpServletRequest request){
        return transfer("mp4",video,request);
    }

    /**
     * 上传视频封面
     * @param pic
     * @param request
     * @return
     */
    @PostMapping("/user/uploadpic")
    @ResponseBody
    public String uploadPic(@RequestParam("pic") MultipartFile pic,
                         HttpServletRequest request){
        return transfer("pic",pic,request);
    }

    /**
     * 上传人物头像
     * @param pic
     * @param request
     * @return
     */
    @PostMapping("/uploadpicwithoutlogin")
    @ResponseBody
    public String uploadPicWithoutLogin(@RequestParam("pic") MultipartFile pic,
                            HttpServletRequest request){
        return transfer("head",pic,request);
    }

    public String transfer(String folder,MultipartFile file,HttpServletRequest request){
        folder = "/"+folder+"/";
        String serverPath = request.getScheme() + "://"+request.getServerName()+":" +
                request.getServerPort() + request.getContextPath() + folder;
        String path = request.getServletContext().getRealPath(folder);
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
        String resPath = serverPath+picNameCode;
        logger.info("文件的路径：{}",resPath);
        return resPath;
    }
}
