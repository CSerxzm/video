package com.xzm.video.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzm.video.bean.*;
import com.xzm.video.service.*;
import com.xzm.video.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-04-19 19:11
 */

@Controller
@RequestMapping("/user")
public class UserIndexController {

    @Autowired
    private AttentionService attentionService;

    @Autowired
    private VideoService videoService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private BarrageService barrageService;

    @RequestMapping("/index")
    public String index(){
        return "user/index";
    }

    /**
     * 获得后端主页可视化数据
     * @return
     */
    @RequestMapping("/getdata")
    @ResponseBody
    public ResultInfo getData(HttpSession session){
        User user = (User) session.getAttribute("user");
        ResultInfo resultInfo = new ResultInfo(true);
        resultInfo.setData("polarAreaData1",getCountByStatus1(user.getId()));
        resultInfo.setData("polarAreaData2",getCountByStatus2(user.getId()));
        return resultInfo;
    }

    /**
     * 获得用户的投稿数.评论数和弹幕数
     * @param userId
     * @return
     */
    private Map<String,Integer> getCountByStatus1(Integer userId){
        //视频的投稿数
        Integer videoCount = videoService.getSumByUserId(userId);
        //评论数
        Integer commentCount = commentService.countSumByVideoUserId(userId);
        //弹幕数
        Integer barrageCount = barrageService.countSumByVideoUserId(userId);
        Map< String,Integer > data = new HashMap<>();
        data.put("投稿数",videoCount);
        data.put("评论数",commentCount);
        data.put("弹幕数",barrageCount);
        return data;
    }

    private Map<String,Integer> getCountByStatus2(Integer userId){
        //获得粉丝数
        Integer attentionCount = attentionService.countSumByAttenUserId(userId);
        Integer userCount = attentionService.countSumByUserId(userId);
        Map< String,Integer > data = new HashMap<>();
        data.put("粉丝数",attentionCount);
        data.put("关注数",userCount);
        return data;
    }

}
