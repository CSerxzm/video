package com.xzm.video.controller.admin;

import com.xzm.video.service.BarrageService;
import com.xzm.video.service.CommentService;
import com.xzm.video.service.UserService;
import com.xzm.video.service.VideoService;
import com.xzm.video.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-04-19 10:20
 */

@Controller
@RequestMapping("/admin")
public class AdminIndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private VideoService videoService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private BarrageService barrageService;



    /**
     * 后台主页
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(ModelMap model){
        return "admin/index";
    }

    /**
     * 获得后端主页可视化数据
     * @return
     */
    @RequestMapping("/getdata")
    @ResponseBody
    public ResultInfo getData(){
        ResultInfo resultInfo = new ResultInfo(true);
        List<Map<String, String>> users = userService.countByRole();
        List<Map<String, String>> videos = videoService.countByStatus();
        List<Map<String, String>> comments = commentService.countByStatus();
        List<Map<String, String>> barrages = barrageService.countByStatus();
        Map< String, List<Map<String,String>> > data = new HashMap<>();
        data.put("用户数据",users);
        data.put("视频数据",videos);
        data.put("评论数据",comments);
        data.put("弹幕数据",barrages);
        resultInfo.setData("piedata",data);
        return resultInfo;
    }
}
