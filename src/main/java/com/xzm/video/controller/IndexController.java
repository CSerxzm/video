package com.xzm.video.controller;

import com.xzm.video.bean.Type;
import com.xzm.video.bean.Video;
import com.xzm.video.service.TypeService;
import com.xzm.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private VideoService videoService;
    @Autowired
    private TypeService typeService;

    @RequestMapping( "/" )
    public String index(ModelMap model, HttpSession session) {
        List<Type> types = typeService.selectAll();
        Map<String, List<Video>> videos_new = videoService.selectNewByType(3);
        Map<String, List<Video>> videos_hot = videoService.selectHotByType(6);
        session.setAttribute("types",types);
        model.put("videos_new",videos_new);
        model.put("videos_hot",videos_hot);
        return "index";
    }

}