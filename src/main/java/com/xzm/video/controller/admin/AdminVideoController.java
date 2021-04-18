package com.xzm.video.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzm.video.bean.*;
import com.xzm.video.service.BarrageService;
import com.xzm.video.service.CommentService;
import com.xzm.video.service.TagService;
import com.xzm.video.service.VideoService;
import com.xzm.video.utils.ResultInfo;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-04-17 20:32
 */

@Controller
@RequestMapping("/admin")
@RequiresRoles(value = {"admin"})
public class AdminVideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private BarrageService barrageService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private TagService tagService;

    /***
     * 视频的列表，后台
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/video")
    public String toVideoPage(@RequestParam(value = "page", defaultValue = "1") Integer page, ModelMap model){
        PageHelper.startPage(page, 10);
        List<Video> videos = videoService.selectAllAdmin();
        PageInfo pageInfo = new PageInfo(videos, 5);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/video";
    }

    /**
     * 视频的审核
     * @param session
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/video/{id}")
    public String video(HttpSession session, @PathVariable Integer id, ModelMap model) {
        Video video = videoService.selectByPrimaryKeyAdmin(id);
        List<Comment> comments = commentService.selectByVideoId(id);
        List<Tag> tags = tagService.selectByVideoId(id);
        model.put("video",video);
        model.put("tags",tags);
        model.put("comments",comments);
        return "admin/videocheck";
    }

    /**
     * 删除视频
     * @param id
     * @return
     */
    @DeleteMapping("/video/{id}")
    public String delUser(@PathVariable("id") Integer id){
        videoService.deleteByPrimaryKey(id);
        return "redirect:/admin/video";
    }

    /**
     * 更新视频，主要用于审核
     * @param video
     * @return
     */
    @PostMapping("/updatevideo")
    public String updateUser(Video video){
        videoService.updateByPrimaryKeySelective(video);
        return "redirect:/admin/video";
    }


    /**
     * 弹幕列表
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/barrage")
    public String toBarragePage(@RequestParam(value = "page", defaultValue = "1") Integer page, ModelMap model){
        PageHelper.startPage(page, 10);
        List <Barrage> barrages = barrageService.selectAllAdmin();
        PageInfo pageInfo = new PageInfo(barrages, 5);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/barrage";
    }

    /**
     * 删除弹幕，主要是对于不合格的弹幕
     * @param id
     * @return
     */
    @DeleteMapping("/barrage/{id}")
    public String delBarrage(@PathVariable("id") Integer id){
        barrageService.deleteByPrimaryKey(id);
        return "redirect:/admin/barrage";
    }

    /**
     * 弹幕的审核,其实也是跳转到视频页面
     * @param session
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/barrage/{id}")
    public String barrage(HttpSession session, @PathVariable Integer id, ModelMap model) {
        Video video = videoService.selectByPrimaryKeyAdmin(id);
        List<Comment> comments = commentService.selectByVideoId(id);
        List<Tag> tags = tagService.selectByVideoId(id);
        model.put("video",video);
        model.put("tags",tags);
        model.put("comments",comments);
        return "admin/barragecheck";
    }

    /**
     * 更新弹幕，主要用于审核
     * @param barrage
     * @return
     */
    @PostMapping("/updatebarrage")
    @ResponseBody
    public ResultInfo updateBarrage(Barrage barrage){
        ResultInfo resultInfo = barrageService.updateByPrimaryKey(barrage);
        return resultInfo;
    }

    /**
     * 评论列表
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/comment")
    public String toCommentPage(@RequestParam(value = "page", defaultValue = "1") Integer page, ModelMap model){
        PageHelper.startPage(page, 10);
        List <Comment> comments = commentService.selectAllAdmin();
        PageInfo pageInfo = new PageInfo(comments, 5);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/comment";
    }

    /**
     * 删除评论，主要是对于不合格的评论
     * @param id
     * @return
     */
    @DeleteMapping("/comment/{id}")
    public String delComment(@PathVariable("id") Integer id){
        commentService.deleteByPrimaryKey(id);
        return "redirect:/admin/comment";
    }

    /**
     * 更新评论，主要用于审核
     * @param comment
     * @return
     */
    @PostMapping("/updatecomment")
    @ResponseBody
    public ResultInfo updateComment(Comment comment){
        ResultInfo resultInfo = commentService.updateByPrimaryKeySelective(comment);
        return resultInfo;
    }
}
