package com.zg.number.controller;

import com.zg.number.bean.Invest;
import com.zg.number.service.LanRenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by fengshuo on 2017/8/8.
 */
@RequestMapping("fs")
@Controller
public class LanRenController {

    @Autowired
    private LanRenService lanRenService;

    //懒人计划页面
    @RequestMapping("lanRen")
    public String selectLanRenAll(ModelMap modelMap){
        List<Invest> lanRenAll = lanRenService.selectLanRen();
        System.out.println(lanRenAll);
        modelMap.addAttribute("lanRenAll",lanRenAll);
        return "menu/lanren";
    }
}
