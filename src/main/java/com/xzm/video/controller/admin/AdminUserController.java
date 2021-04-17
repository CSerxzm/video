package com.xzm.video.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzm.video.bean.*;
import com.xzm.video.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author xiangzhimin
 * @Description 后台审批待开发
 * @create 2021-04-15 14:25
 */

@Controller
@RequestMapping("/admin")
class AdminUserController {

    @Autowired
    private UserService userService;

    /**
     * 后台主页
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return "admin/index";
    }

    /**
     * 用户列表
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/user")
    public String toUserPage(@RequestParam(value = "page", defaultValue = "1") Integer page,ModelMap model){
        PageHelper.startPage(page, 10);
        List<User> users = userService.selectAll();
        PageInfo pageInfo = new PageInfo(users, 5);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/user";
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/user/{id}")
    public String delUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return "redirect:/admin/user";
    }

    /**
     * 更新用户，主要用于更改用户的权限
     * @param user
     * @return
     */
    @PostMapping("/updateuser")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/admin/user";
    }

}
