package com.xzm.video.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzm.video.bean.Barrage;
import com.xzm.video.bean.Comment;
import com.xzm.video.bean.Tag;
import com.xzm.video.bean.Video;
import com.xzm.video.service.BarrageService;
import com.xzm.video.service.CommentService;
import com.xzm.video.service.TagService;
import com.xzm.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-04-17 20:32
 */

@Controller
@RequestMapping("/admin")
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
        Video video = videoService.selectByPrimaryKey(id);
        List <Barrage> barrages = barrageService.selectByVideoId(id);
        List<Comment> comments = commentService.selectByVideoId(id);
        List<Tag> tags = tagService.selectByVideoId(id);
        model.put("video",video);
        model.put("tags",tags);
        model.put("comments",comments);
        return "admin/videocheck";
    }

    @RequestMapping("/barrage")
    public String toBarragePage(){
        return "admin/barrage";
    }

    @RequestMapping("/comment")
    public String toCommentPage(){
        return "admin/comment";
    }
}
