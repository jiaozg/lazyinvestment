package com.zg.number.controller;

import com.zg.number.bean.Captail;
import com.zg.number.bean.Invest;
import com.zg.number.bean.Record;
import com.zg.number.service.RealizeService;
import javafx.scene.media.SubtitleTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
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
    @RequestMapping("index")
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
    public String projectstail(Integer id,Map<String ,Object> map,HttpSession session){
        //根据id查询某个项目的详情
        System.out.println("========= 马上投资============"+id);
        Invest project = realizeService.projectstail(id);
        //根据用户id查询余额
        Captail captail = realizeService.selectYvE(id);
        Double captailMoney = captail.getCaptailMoney();
        session.setAttribute("captailMoney",captailMoney);
        map.put("project",project);
        map.put("captail",captail);
        return "bianxianjiahua/investment";

    }

    /**
     * 将投资人投资的信息添加到记录表中
     */
    @RequestMapping("addRecord")
    public String addRecord(Integer touzi, HttpSession session){
        System.out.println(touzi);
         //封装一个投资记录表的对象
        Record record = new Record();
        //创建一个资产表的对象
        Captail captail = new Captail();
        record.setIrecordTime(""+new Date());
        Object obj = session.getAttribute("uId");

        if(obj!=null){
            int i = Integer.parseInt(String.valueOf(obj));
            record.setUid(i);
            System.out.println(record.getUid());
            captail.setUserId(i);
        }
       // System.out.println("===========>>"+i);


        record.setRecordMoney(touzi);
        Object loginUser = session.getAttribute("loginUser");

        record.setRecordName(String.valueOf(loginUser));
        //将投资信息注入到投资记录表
        realizeService.addRecord(record);

        System.out.println("===========kk=============");
        //调用根据用户id修改资产表中的余额信息
        //获取session中的余额
        Object captailMoney1 = session.getAttribute("captailMoney");
        double captailMoney =   Double.parseDouble(String.valueOf(captailMoney1));
        //计算新的账户余额
        System.out.println("====>"+captailMoney);
        double ye = captailMoney-touzi;
        System.out.println(ye);
        captail.setCaptailMoney(ye);

        //修改该用户的资产信息
        realizeService.updateCaptail(captail);

        return "redirect:selectInvest";
    }



}
