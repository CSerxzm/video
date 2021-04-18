package com.xzm.video.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzm.video.bean.*;
import com.xzm.video.constant.Status;
import com.xzm.video.service.FavoriteService;
import com.xzm.video.service.HistoryService;
import com.xzm.video.service.UserService;
import com.xzm.video.service.VideoService;
import com.xzm.video.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private UserService userService;

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
    public String addvideo(Video video, String tags,Integer typeId,
                           HttpSession session,
                           HttpServletRequest request) throws IOException {
        User user = (User) session.getAttribute("user");
        video.setUser(user);
        video.setCreateTime(new Date());
        video.setStatus(Status.UNPASS.getCode());
        Type type = new Type();
        type.setId(typeId);
        video.setType(type);
        videoService.insertSelective(video,tags);
        return "user/success";
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

    /**
     * 收藏
     * @param session
     * @param id
     * @return
     */
    @PostMapping("/addfavoritenum")
    @ResponseBody
    public ResultInfo addFavoriteNum(HttpSession session, Integer id){
        User user = (User) session.getAttribute("user");
        return videoService.addFavoriteNum(user,id);
    }

    /**
     * 获得收藏记录
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/star")
    public String getUserStar(@RequestParam(value = "page", defaultValue = "1") Integer page,ModelMap model, HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Video> videos_hot = videoService.selectHot(5);
        PageHelper.startPage(page, 9);
        List<Favorite> favorites = favoriteService.selectAllByUserId(user.getId());
        PageInfo pageInfo = new PageInfo(favorites, 5);
        model.addAttribute("pageInfo", pageInfo);
        model.put("videos_hot",videos_hot);
        return "user/star";
    }

    /**
     * 投币
     * @param session
     * @param id
     * @return
     */
    @PostMapping("/addcoinnum")
    @ResponseBody
    public ResultInfo addCoinNum(HttpSession session, Integer id){
        User user = (User) session.getAttribute("user");
        return videoService.addCoinNum(user,id);
    }

    /**
     * 点赞
     * @param session
     * @param id
     * @return
     */
    @PostMapping("/addlikenum")
    @ResponseBody
    public ResultInfo addLikeNum(HttpSession session,Integer id){
        User user = (User) session.getAttribute("user");
        return videoService.addLikeNum(user,id);
    }

    /**
     * 关注用户
     * @param session
     * @param id
     * @return
     */
    @RequestMapping("/attention")
    @ResponseBody
    public ResultInfo addAttention(HttpSession session,Integer id){
        User user = (User) session.getAttribute("user");
        return userService.addAttention(user,id);
    }
}
