package com.zg.number.controller;

import com.zg.number.bean.User;
import com.zg.number.service.UserService;
import com.zg.number.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 任彩雨 on 2017/8/5.
 */
@Controller
public class UserController {
    //到主界面
    @RequestMapping("")
    public String toIndex() {
        return "index";
    }

}
