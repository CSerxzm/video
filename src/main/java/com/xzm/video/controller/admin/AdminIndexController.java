package com.xzm.video.controller.admin;

import com.xzm.video.service.BarrageService;
import com.xzm.video.service.CommentService;
import com.xzm.video.service.UserService;
import com.xzm.video.service.VideoService;
import com.xzm.video.utils.HashMapComparator;
import com.xzm.video.utils.RedisUtils;
import com.xzm.video.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

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

    @Autowired
    private RedisUtils redisUtils;

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
        resultInfo.setData("piedata",getCountByStatus());
        resultInfo.setData("days",getSevenDaysViews());
        return resultInfo;
    }

    /**
     * 获得用户、视频、评论、以及弹幕的相关信息
     * @return
     */
    private Map< String, List<Map<String,String>> > getCountByStatus(){
        List<Map<String, String>> users = userService.countByRole();
        List<Map<String, String>> videos = videoService.countByStatus();
        List<Map<String, String>> comments = commentService.countByStatus();
        List<Map<String, String>> barrages = barrageService.countByStatus();
        Map< String, List<Map<String,String>> > data = new HashMap<>();
        data.put("用户数据",users);
        data.put("视频数据",videos);
        data.put("评论数据",comments);
        data.put("弹幕数据",barrages);
        return data;
    }

    /**
     * 获得网页中视频近七天的浏览量
     * @return
     */
    private List< Map<String,String> >getSevenDaysViews(){
        List<Map<String,String>> list = new ArrayList<>();
        Set<String> keys = redisUtils.getKeys("video:views:*");
        for(String key:keys){
            String  day = key.split(":")[2];
            String count = String.valueOf(redisUtils.get(key));
            HashMap<String,String> map = new HashMap<>();
            map.put("day",day);
            map.put("count",count);
            list.add(map);
        }
        Collections.sort(list,new HashMapComparator());
        return list;
    }
}
