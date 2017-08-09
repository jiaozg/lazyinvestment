package com.zg.number.controller;

import com.zg.number.bean.User;
import com.zg.number.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by 任彩雨 on 2017/8/7.
 * 登录的Controller
 */
@Controller
@RequestMapping("rcy")
public class LoginController {

    @Autowired
    private LoginService loginService;

    //到登录界面
    @RequestMapping("toLogin")
    public String toLogin() {
        return "top/login";
    }

    @RequestMapping("login")
    public String login(User user, Model model, HttpSession session) {
        System.out.println("登陆的用户:" + user.getPhone());
        User loginUser = loginService.login(user);
        System.out.println("登陆过后的用户:" + loginUser.getUserName());
        if (loginUser != null) {
            session.setAttribute("loginUser",loginUser);
            return "top/loginSuccess";
        }
        model.addAttribute("msg", "用户名或密码错误");
        return "forward:toLogin";
    }


}
