package com.zg.number.interceptor;

import com.zg.number.bean.Captail;
import com.zg.number.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by ${hanwenjian} on 2017/8/11.
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("------拦截器----");
        String url = request.getRequestURI();
        if(url.indexOf("toLogin")>=0){
            return true;
        }
        if(url.indexOf("index")>=0){
            return true;
        }
         if(url.indexOf("login")>=0){
                return true;
         }
       /* if(url.indexOf("selectInvest")>=0){
            return true;
        }*/

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");
        if(user == null){
            request.getRequestDispatcher("/rcy/toLogin").forward(request,response);
            System.out.println("loginUser");
            return false;
        }
       /* Captail captailMoney = (Captail) session.getAttribute("captailMoney");
        if(captailMoney == null){
            request.getRequestDispatcher("toLogin").forward(request,response);
            System.out.println("captailMoney");
            return false;
        }*/

        //response.sendRedirect("loginuser.html");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {


    }
}
