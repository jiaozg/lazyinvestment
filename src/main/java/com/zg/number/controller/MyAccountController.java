package com.zg.number.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 任彩雨 on 2017/8/7.
 * 我的账户控制层
 */
@Controller
@RequestMapping("rcy")
public class MyAccountController {

    @RequestMapping("toMyAccount")
    public String toMyAccount() {
        return "menu/wodezhanghu";
    }

}
