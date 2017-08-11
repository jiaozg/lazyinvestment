package com.zg.number.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 任彩雨 on 2017/8/11.
 */
@Controller
@RequestMapping("rcy")
public class ChongZhiController {

    @RequestMapping("toChongZhi")
    private String toChongZhi() {
        return "top/chongzhi";
    }

}
