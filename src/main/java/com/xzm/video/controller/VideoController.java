package com.xzm.video.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzm.video.bean.*;
import com.xzm.video.dao.TagMapper;
import com.xzm.video.service.*;
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
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private BarrageService barrageService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private TagService tagService;

    @GetMapping("/{id}")
    public String video(HttpSession session,@PathVariable Integer id, ModelMap model) {
        User user = (User) session.getAttribute("user");
        if(user!=null){
            historyService.addHistory(user.getId(),id);
        }
        Video video = videoService.selectByPrimaryKey(id);
        List<Video> videos_hot = videoService.selectHot(5);
        List <Barrage> barrages = barrageService.selectByVideoId(id);
        List<Comment> comments = commentService.selectByVideoId(id);
        List<Tag> tags = tagService.selectByVideoId(id);
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
        Type type = typeService.selectByPrimaryKey(id);

        PageHelper.startPage(page, 9);
        List<Video> videos = videoService.selectByTypeId(id);
        PageInfo pageInfo = new PageInfo(videos, 5);
        model.addAttribute("pageInfo", pageInfo);

        model.put("videos_hot",videos_hot);
        model.put("type",type);
        return "type";
    }

    @RequestMapping("/search")
    public String videoSearch(@RequestParam(value = "page", defaultValue = "1") Integer page,String query,ModelMap model){
        List<Video> videos_hot = videoService.selectHot(5);
        PageHelper.startPage(page, 9);
        List<Video> videos = videoService.selectByTitleLike(query);
        PageInfo pageInfo = new PageInfo(videos, 5);
        model.addAttribute("pageInfo", pageInfo);
        model.put("videos_hot",videos_hot);
        model.put("query",query);
        return "search";
    }
    /**
     * 收藏
     * @param id
     * @return
     */
    @PostMapping("/addstarnum")
    @ResponseBody
    public ResultInfo addStarNum(Integer id){
        return videoService.addStarNum(id);
    }

    /**
     * 投币
     * @param id
     * @return
     */
    @PostMapping("/addcoinnum")
    @ResponseBody
    public ResultInfo addCoinNum(Integer id){
        return videoService.addCoinNum(id);
    }

    /**
     * 点赞
     * @param id
     * @return
     */
    @PostMapping("/addlikenum")
    @ResponseBody
    public ResultInfo addLikeNum(Integer id){
        return videoService.addLikeNum(id);
    }

}