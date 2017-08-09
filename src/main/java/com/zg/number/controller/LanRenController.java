package com.zg.number.controller;

import com.zg.number.bean.Invest;
import com.zg.number.bean.Record;
import com.zg.number.bean.User;
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
        modelMap.addAttribute("lanRenAll",lanRenAll);
        return "forward:selectUserAndAssest";
    }

    //投资风云榜
    @RequestMapping("selectUserAndAssest")
    private String selectUserAndAssest(ModelMap modelMap){
        List<User> list = lanRenService.selectUserAndAssest();
        modelMap.addAttribute("list",list);
        return "menu/lanren";
    }
}
