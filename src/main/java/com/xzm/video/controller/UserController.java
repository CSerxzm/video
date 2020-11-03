package com.xzm.video.controller;

import com.xzm.video.bean.User;
import com.xzm.video.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String tologin() {
        return "login";
    }

    @GetMapping("/regist")
    public String toregist() {
        return "regist";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes) {
        User user = userService.selectForLogin(new User(username,password));
        if(user!=null){
            user.setPassword(null);
            session.setAttribute("user",user);
            if(user.getUsertype()==1){
                return "success";
            }else{
                return "redirect:/";
            }
        }else{
            attributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:/login";
        }
    }

    @PostMapping("/regist")
    public String regist(User user,RedirectAttributes attributes){
        String username = user.getUsername();
        User res = userService.selectByUsername(username);
        if(res==null){
            user.setCreateTime(new Date());
            userService.insertSelective(user);
            return "redirect:/";
        }else{
            attributes.addFlashAttribute("message", "用户名已经被占用，请更换");
            return "redirect:/regist";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }
}
