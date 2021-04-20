package com.xzm.video.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzm.video.bean.*;
import com.xzm.video.service.FavoriteService;
import com.xzm.video.service.HistoryService;
import com.xzm.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-04-20 9:32
 */

@Controller
@RequestMapping("/user")
public class UserVideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private HistoryService historyService;

    /**
     * 收藏记录
     * @param page
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/mystar")
    public String myStar(@RequestParam(value = "page", defaultValue = "1") Integer page, ModelMap model, HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Video> videos_hot = videoService.selectHot(5);
        PageHelper.startPage(page, 9);
        List<Favorite> favorites = favoriteService.selectAllByUserId(user.getId());
        PageInfo pageInfo = new PageInfo(favorites, 5);
        model.addAttribute("pageInfo", pageInfo);
        model.put("videos_hot",videos_hot);
        return "user/mystar";
    }

    /**
     * 历史记录
     * @param page
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/myhistory")
    public String myHistory(@RequestParam(value = "page", defaultValue = "1") Integer page, ModelMap model, HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Video> videos_hot = videoService.selectHot(5);
        PageHelper.startPage(page, 9);
        List<History> histories = historyService.selectAllByUserId(user.getId());
        PageInfo pageInfo = new PageInfo(histories, 5);
        model.addAttribute("pageInfo", pageInfo);
        model.put("videos_hot",videos_hot);
        return "user/myhistory";
    }

    /**
     * 获得投稿记录
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/myupload")
    public String myUpload(@RequestParam(value = "page", defaultValue = "1") Integer page, ModelMap model, HttpSession session){
        User user = (User) session.getAttribute("user");
        PageHelper.startPage(page, 9);
        List<Video> videos = videoService.selectByUserId(user.getId());
        PageInfo pageInfo = new PageInfo(videos, 5);
        model.addAttribute("pageInfo", pageInfo);
        return "user/myupload";
    }

    /**
     * 删除视频
     * @param id
     * @return
     */
    @DeleteMapping("/video/{id}")
    public String delUser(@PathVariable("id") Integer id){
        videoService.deleteByPrimaryKey(id);
        return "redirect:/user/myupload";
    }
}
