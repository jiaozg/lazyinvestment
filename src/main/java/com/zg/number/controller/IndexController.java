package com.zg.number.controller;

import com.zg.number.bean.Invest;
import com.zg.number.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by WangHongChuan on 2017/8/8.
 */
@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;

    @RequestMapping("index")
    public String index(Model model) {
        List<Invest> list = indexService.findIndexData();
        for (Invest invest : list) {
            System.out.print(invest.toString());
        }
        Invest invest = list.get(0);
        Invest invest1 = list.get(1);
        Invest invest2 = list.get(2);
        model.addAttribute("data1", invest);
        model.addAttribute("data2", invest1);
        model.addAttribute("data3", invest2);
        return "index";
    }

    @RequestMapping("findInvestData")
    public String findInvestData(Model model, Integer id) {
        Invest oneInvestData = indexService.findOneInvestData(id);
        model.addAttribute("oneInvestData", oneInvestData);
        System.out.print("拿到id了。。。。。" + oneInvestData.getInvestId() + oneInvestData.getPlanName());
        return "lanrenjihua/mashangtouzi";
    }

    @RequestMapping("toLoginSuccess")
    public String toLoginSuccess(Model model){
        List<Invest> list = indexService.findIndexData();
        for (Invest invest : list) {
            System.out.print(invest.toString());
        }
        Invest invest = list.get(0);
        Invest invest1 = list.get(1);
        Invest invest2 = list.get(2);
        model.addAttribute("data1", invest);
        model.addAttribute("data2", invest1);
        model.addAttribute("data3", invest2);
        return "top/loginSuccess.html";
    }




}
