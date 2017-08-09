package com.zg.number.controller;

import com.zg.number.bean.Invest;
import com.zg.number.service.RealizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by wrx on 2017/8/8.
 * 变现计划
 */
@Controller
@RequestMapping("wrx")
public class RealizeController {
    @Autowired
    private RealizeService realizeService;


    /**
     * 首页
     */
    @RequestMapping("")
    public String toindex() {
        return "index";
    }

    /**
     * 查询一锤定音表:实现变现计划======变现计划的项目列表Projectlist
     */
    @RequestMapping("selectInvest")
    public String selectInvest(Map<String, Object> map) {

        List<Invest> list = realizeService.selectInvest();
        for (Invest invest : list) {
            System.out.println(invest);
        }

        System.out.println("---------存一个对象--------");

        Invest invest1 = list.get(0);
        System.out.println(invest1);
        map.put("invest1", invest1);

        Invest invest2 = list.get(1);
        System.out.println(invest2);
        map.put("invest2",invest2);

        /**
         * 变现计划的项目列表Projectlist 将项目列表分页查询
         */
        map.put("list", list);

        return "menu/bianxian";

    }

    /**
     * 马上投资
     */
    @RequestMapping("mashang")
    public String projectstail(Integer id,Map<String ,Object> map){
        //根据id查询某个项目的详情
        System.out.println("========= 马上投资============"+id);
        Invest project = realizeService.projectstail(id);
        map.put("project",project);
        return "bianxianjiahua/investment";

    }



}
