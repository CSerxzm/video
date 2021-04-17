package com.xzm.video.controller;

import com.xzm.video.bean.Comment;
import com.xzm.video.bean.User;
import com.xzm.video.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     *
     * @param videoId
     * @param model
     * @return
     */
    @GetMapping("/comments/{videoId}")
    public String comments(@PathVariable Integer videoId, Model model) {
        model.addAttribute("comments", commentService.selectByVideoId(videoId));
        return "video :: commentList";
    }

    /**
     *
     * @param comment
     * @param session
     * @return
     */
    @PostMapping("/user/addComment")
    public String addComment(Comment comment, HttpSession session){
        //后期使用安全框架修改
        User user = (User)session.getAttribute("user");
        int videoId = comment.getVideoId();
        if(user==null){
            //未登录
        }else{
            comment.setUser(user);
            comment.setCreateTime(new Date());
            System.out.println(comment);
            commentService.insertSelective(comment);
        }
        return "redirect:/comments/" + videoId;
    }
}
