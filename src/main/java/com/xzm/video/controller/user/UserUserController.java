package com.xzm.video.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzm.video.bean.Attention;
import com.xzm.video.bean.User;
import com.xzm.video.service.AttentionService;
import com.xzm.video.service.UserService;
import com.xzm.video.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-04-20 9:31
 */

@Controller
@RequestMapping("/user")
public class UserUserController {

    @Autowired
    private AttentionService attentionService;

    @Autowired
    private UserService userService;

    /**
     * 我的关注列表
     * @param page
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/myattention")
    public String myAttention(@RequestParam(value = "page", defaultValue = "1") Integer page, ModelMap model, HttpSession session){
        User user = (User) session.getAttribute("user");
        PageHelper.startPage(page, 9);
        List<Attention> attentions = attentionService.selectByUserId(user.getId());
        PageInfo pageInfo = new PageInfo(attentions, 5);
        model.addAttribute("pageInfo", pageInfo);
        return "user/myattention";
    }

    /**
     * 我的粉丝列表
     * @param page
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/myfans")
    public String myFans(@RequestParam(value = "page", defaultValue = "1") Integer page, ModelMap model, HttpSession session){
        User user = (User) session.getAttribute("user");
        PageHelper.startPage(page, 9);
        List<Attention> attentions = attentionService.selectByAttenUserId(user.getId());
        PageInfo pageInfo = new PageInfo(attentions, 5);
        model.addAttribute("pageInfo", pageInfo);
        return "user/myfans";
    }

    /**
     * 取消关注，个人中心专用
     * @param attenUserid
     * @param session
     * @return
     */
    @PostMapping("/delattention")
    public String delAttention(@RequestParam("attenUserid") Integer attenUserid,HttpSession session){
        User user = (User) session.getAttribute("user");
        userService.addAttention(user,attenUserid);
        return "redirect:/user/myattention";
    }

    /**
     * 个人详情界面
     * @param session
     * @param model
     * @return
     */
    @GetMapping("/myinfo")
    public String myInfo(HttpSession session,ModelMap model){
        User user = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        return "user/myinfo";
    }

    @PostMapping("/updateuser")
    @ResponseBody
    public ResultInfo updateUser(User user, HttpSession session){
        ResultInfo resultInfo = new ResultInfo(true);
        user = userService.updateUser(user);
        if(user!=null){
            session.setAttribute("user",user);
            resultInfo.setCode(200);
        }else{
            resultInfo.setSuccess(false);
        }
        return resultInfo;
    }
}
