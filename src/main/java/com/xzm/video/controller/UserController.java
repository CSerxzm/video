package com.xzm.video.controller;

import com.xzm.video.bean.User;
import com.xzm.video.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
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

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken
                (username,password);
        try {
            subject.login(token);
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            session.setAttribute("user",user);
            return "redirect:/";
        } catch (UnknownAccountException e) {
            attributes.addFlashAttribute("message", "用户名出错,请检查后重试");
        }catch (IncorrectCredentialsException e) {
            attributes.addFlashAttribute("message", "密码出错,请检查后重试");
        }  catch (Exception e) {
            attributes.addFlashAttribute("message", "未知错误,请联系管理员");
        }
        return "redirect:/login";
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
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            try{
                subject.logout();
            }catch(Exception ex){
            }
        }
        return "redirect:/";
    }
}
