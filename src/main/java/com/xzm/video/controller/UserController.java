package com.xzm.video.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzm.video.bean.History;
import com.xzm.video.bean.User;
import com.xzm.video.bean.Video;
import com.xzm.video.service.HistoryService;
import com.xzm.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-04-14 12:35
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private HistoryService historyService;

    @GetMapping("/upload")
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
    @PostMapping("/addvideo")
    public String addvideo(Video video, String tags,
                           HttpSession session,
                           HttpServletRequest request) throws IOException {
        User user = (User) session.getAttribute("user");
        video.setUser(user);
        video.setCreateTime(new Date());
        videoService.insertSelective(video,tags);
        return "success";
    }


    /**
     * 获得收藏记录
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/star")
    public String getUserStar(ModelMap model, HttpSession session){
        User user = (User) session.getAttribute("user");

        return "user/star";
    }

    /**
     * 获得历史记录
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/history")
    public String getUserHistory(@RequestParam(value = "page", defaultValue = "1") Integer page, ModelMap model, HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Video> videos_hot = videoService.selectHot(5);
        PageHelper.startPage(page, 9);
        List<History> histories = historyService.selectAllByUserId(user.getId());
        PageInfo pageInfo = new PageInfo(histories, 5);
        model.addAttribute("pageInfo", pageInfo);
        model.put("videos_hot",videos_hot);
        return "user/history";
    }
}
