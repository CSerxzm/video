package com.xzm.video.controller;

import com.google.gson.Gson;
import com.xzm.video.service.BarrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 弹幕的相关接口
 */
@Controller
public class BarrageController {

    @Autowired
    private BarrageService barrageService;

    /**
     * 得到某视频的弹幕列表
     * @param id
     * @return
     */
    @GetMapping("/barrage/v3")
    @ResponseBody
    public Map<String,Object>  getBarrage(@RequestParam("id") Integer id){
        List<List<Object>> barrages = barrageService.selectByVideoId_api(id);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("data",barrages);
        return map;
    }

    /**
     * 添加弹幕
     * @param param
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping("/barrage/v3")
    public String addBarrage(@RequestBody Map<String,String> param, HttpServletRequest request) throws Exception {
        Map map = new HashMap();
        barrageService.insertSelective(param);
        map.put("code",0);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(map);
        return jsonStr;
    }
}
