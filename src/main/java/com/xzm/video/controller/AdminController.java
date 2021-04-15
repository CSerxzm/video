package com.xzm.video.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiangzhimin
 * @Description 后台审批待开发
 * @create 2021-04-15 14:25
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/")
    public String index(){
        return "admin/index";
    }
}
