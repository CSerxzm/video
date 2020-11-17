package com.xzm.video.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzm.video.bean.*;
import com.xzm.video.service.BarrageService;
import com.xzm.video.service.CommentService;
import com.xzm.video.service.TypeService;
import com.xzm.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Autowired
    BarrageService barrageService;

    @Autowired
    CommentService commentService;

    @GetMapping("/video/{id}")
    public String video(@PathVariable Integer id, ModelMap model) {
        Video video = videoService.selectByPrimaryKey(id);
        List<Video> videos_hot = videoService.selectHot(5);
        List <Barrage> barrages = barrageService.selectByVideoId(id);
        List<Comment> comments = commentService.selectByVideoId(id);
        model.put("video",video);
        model.put("videos_hot",videos_hot);
        model.put("barrages",barrages);
        model.put("comments",comments);
        return "video";
    }

    //根据种类选id
    @GetMapping("/type/{id}")
    public String videoByType(@RequestParam(value = "page", defaultValue = "1") Integer page, @PathVariable Integer id, ModelMap model) {
        List<Video> videos_hot = videoService.selectHotByTypeId(id,10);

        PageHelper.startPage(page, 9);
        List<Video> videos = videoService.selectByTypeId(id);
        PageInfo pageInfo = new PageInfo(videos, 5);
        model.addAttribute("pageInfo", pageInfo);

        model.put("videos_hot",videos_hot);
        model.put("type_id",id);
        return "type";
    }

    @GetMapping("/user/upload")
    public String toupload(){
        return "user/upload";
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