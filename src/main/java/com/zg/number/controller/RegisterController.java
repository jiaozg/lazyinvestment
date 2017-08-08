package com.zg.number.controller;

import com.zg.number.bean.User;
import com.zg.number.service.RegisterService;
import com.zg.number.utils.PhoneCheckCode;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 任彩雨 on 2017/8/7.
 */
@Controller
@RequestMapping("hwj")
public class RegisterController {
    @Autowired
    private RegisterService registerService;


    @RequestMapping("toRegister")
    public String toRegister() {
        System.out.println("-------到注册界面的方法-------");
        return "top/register";
    }

    //注册
    @RequestMapping("register")
    public String register(User user) {
        System.out.println("---------register------");
        registerService.register(user);
        return "forward:hwj/tologin";
    }

    //用户名验证唯一
    @RequestMapping("usernameOnly")
    @ResponseBody
    public String usernameOnly(String username) {
        System.out.println("---------only------");
        List<User> only = registerService.userNameOnly(username);
        for (User user : only) {
            System.out.println(user.getUrgentName());
        }
        if (only.size() > 0) {
            return "true";
        } else {
            return "false";
        }
    }

    //手机号验证唯一
    @RequestMapping("phoneOnly")
    @ResponseBody
    public String phoneOnly(String phone) {
        System.out.println("---------only------");
        List<User> only = registerService.phoneOnly(phone);
        for (User user : only) {
            System.out.println(user.getPhone());
        }
        if (only.size() > 0) {
            return "true";
        } else {
            return "false";
        }
    }


    //手机验证
    @RequestMapping("validate")
    public User validate(User user) {
        System.out.println("ddddd333");
        String sendPhoneCheakCode = PhoneCheckCode.sendPhoneCheakCode(user.getPhone());
        System.out.println("向用户手机发送的验证码：" + sendPhoneCheakCode);
        return null;
    }


}
