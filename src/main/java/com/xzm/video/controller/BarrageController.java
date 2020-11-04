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

@Controller
public class BarrageController {

    @Autowired
    BarrageService barrageService;

    @GetMapping("/barrage/v3")
    @ResponseBody
    public Map<String,Object>  getBarrage(@RequestParam("id") Integer id){
        System.out.println("id="+id);
        List<List<Object>> barrages = barrageService.selectByVideoId_api(id);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("data",barrages);
        return map;
    }

    @ResponseBody
    @PostMapping("/barrage/v3")
    public String addBarrage(@RequestBody Map<String,String> param, HttpServletRequest request) throws Exception {
        Map map = new HashMap();
        System.out.println(param);
        barrageService.insertSelective(param);
        map.put("code",0);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(map);
        return jsonStr;
    }
}
