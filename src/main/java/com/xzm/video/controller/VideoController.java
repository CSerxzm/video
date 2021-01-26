package com.xzm.video.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzm.video.bean.*;
import com.xzm.video.dao.TagMapper;
import com.xzm.video.service.BarrageService;
import com.xzm.video.service.CommentService;
import com.xzm.video.service.TypeService;
import com.xzm.video.service.VideoService;
import com.xzm.video.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * video的相关接口
 */

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

    @Autowired
    TagMapper tagMapper;

    @GetMapping("/video/{id}")
    public String video(@PathVariable Integer id, ModelMap model) {
        Video video = videoService.selectByPrimaryKey(id);
        List<Video> videos_hot = videoService.selectHot(5);
        List <Barrage> barrages = barrageService.selectByVideoId(id);
        List<Comment> comments = commentService.selectByVideoId(id);
        List<Tag> tags = tagMapper.selectByVideoId(id);
        model.put("video",video);
        model.put("tags",tags);
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

    /**
     * 添加视频，此时保存数据中视频的链接
     * @param video
     * @param session
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/user/addvideo")
    public String addvideo(Video video,String tags,
                           HttpSession session,
                           HttpServletRequest request) throws IOException {
        User user = (User) session.getAttribute("user");
        video.setUser(user);
        video.setCreateTime(new Date());
        videoService.insertSelective(video,tags);
        return "success";
    }

    /**
     * 收藏
     * @param id
     * @return
     */
    @PostMapping("/video/addstarnum")
    @ResponseBody
    public ResultInfo addStarNum(Integer id){
        return videoService.addStarNum(id);
    }

    /**
     * 投币
     * @param id
     * @return
     */
    @PostMapping("/video/addcoinnum")
    @ResponseBody
    public ResultInfo addCoinNum(Integer id){
        return videoService.addCoinNum(id);
    }

    /**
     * 点赞
     * @param id
     * @return
     */
    @PostMapping("/video/addlikenum")
    @ResponseBody
    public ResultInfo addLikeNum(Integer id){
        return videoService.addLikeNum(id);
    }

}