package com.xzm.video.Interceptor;

import com.xzm.video.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    private static final String [] URL={"/user","/admin"};
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        boolean flag=true;//放行请求
        String url = request.getRequestURI();
        for(String temp:URL){
            if(url.indexOf(temp)>=0){
                flag=false;
                break;
            }
        }
        System.out.println("flag="+flag+"url="+url);
        if(!flag){
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user != null) {
                return true;
            }
        }else{
            return true;
        }
        request.setAttribute("message", "您还没有登录，请先登录！");
        request.getRequestDispatcher("/login").forward(request, response);
        return false;
    }
}
