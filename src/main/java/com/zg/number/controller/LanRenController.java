package com.zg.number.controller;

import com.zg.number.bean.Captail;
import com.zg.number.bean.Invest;
import com.zg.number.bean.Record;
import com.zg.number.bean.User;
import com.zg.number.service.IndexService;
import com.zg.number.service.LanRenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by fengshuo on 2017/8/8.
 */
@RequestMapping("fs")
@Controller
public class LanRenController {

    @Autowired
    private LanRenService lanRenService;

    @Autowired
    private IndexService indexService;

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
        List<User> list = lanRenService.selectUserAndRecord();
        modelMap.addAttribute("list",list);
        return "menu/lanren";
    }

    //投资详情页面数据获取
    @RequestMapping("touzi")
    public String findInvestData(Model model, Integer id,HttpSession session,ModelMap modelMap){
        session.setAttribute("id",id);
        Invest oneInvestData = indexService.findOneInvestData(id);
        model.addAttribute("oneInvestData",oneInvestData);
        Object obj = session.getAttribute("uId");
        int ids = 0;
        if(obj!=null){
            ids = Integer.parseInt(String.valueOf(obj));
        }
        Captail captail1 = lanRenService.selectCaptail(ids);
        modelMap.addAttribute("captail1",captail1);
        return "lanrenjihua/mashangtouzi";
    }

    //投资记录表添加数据
    @RequestMapping("insertRecord")
    private String insertRecord(Record record, HttpSession session){
        Object obj = session.getAttribute("uId");
        session.setAttribute("money",record.getRecordMoney());
        int id = 0;
        if(obj!=null){
            id = Integer.parseInt(String.valueOf(obj));
        }
        record.setUid(id);
        lanRenService.insertRecord(record);
        return "redirect:updateSurplusMoney";
    }

    @RequestMapping("updateSurplusMoney")
    private String selectRecordSurplusMoney(HttpSession session,Invest invest){
        Object obj = session.getAttribute("id");
        Object object = session.getAttribute("money");
        int id = 0;
        int money = 0;
        if(obj!=null){
            id = Integer.parseInt(String.valueOf(obj));
        }
        if(object!=null){
            money = Integer.parseInt(String.valueOf(object));
        }
        Invest in = lanRenService.selectRecordSurplusMoney(id);
        invest.setInvestId(id);
        invest.setSurplusMoney(money);
        lanRenService.updateRecordSurplusMoney(invest);
        return "redirect:updateCaptailMoney";
    }

    @RequestMapping("updateCaptailMoney")
    private String updateCaptail(HttpSession session, Captail captail){
        Object obj = session.getAttribute("uId");
        Object object = session.getAttribute("money");
        int id = 0;
        int money = 0;
        if(obj!=null){
            id = Integer.parseInt(String.valueOf(obj));
        }
        if(object!=null){
            money = Integer.parseInt(String.valueOf(object));
        }
//        Captail captail1 = lanRenService.selectCaptail(id);
        captail.setUserId(id);
        captail.setCaptailMoney(money);
        lanRenService.updateCaptail(captail);
        return "redirect:lanRen";
    }


}
