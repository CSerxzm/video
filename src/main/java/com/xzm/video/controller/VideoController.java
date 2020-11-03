package com.xzm.video.controller;

import com.xzm.video.bean.Type;
import com.xzm.video.bean.User;
import com.xzm.video.bean.Video;
import com.xzm.video.service.TypeService;
import com.xzm.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class VideoController {

    @Autowired
    VideoService videoService;

    @Autowired
    TypeService typeService;

    @GetMapping("/video/{id}")
    public String video(@PathVariable Integer id, ModelMap model) {
        Video video = videoService.selectByPrimaryKey(id);
        List<Video> videos_hot = videoService.selectHot(5);
        model.put("video",video);
        model.put("videos_hot",videos_hot);
        return "video";
    }

    //根据种类选id
    @GetMapping("/type/{id}")
    public String videoByType(@PathVariable Integer id, ModelMap model) {
        List<Video> videos = videoService.selectByType(id);
        model.put("videos",videos);
        return "type";
    }

    @GetMapping("/user/upload")
    public String toupload(){
        return "upload";
    }

    @PostMapping("/user/addvideo")
    public String addvideo(Video video,
                           HttpSession session,
                           HttpServletRequest request) throws IOException {
        User user = (User) session.getAttribute("user");
        video.setUser(user);
        video.setCreateTime(new Date());
        videoService.insertSelective(video);
        return "success";
    }

}