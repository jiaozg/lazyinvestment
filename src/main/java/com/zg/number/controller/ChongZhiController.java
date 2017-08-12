package com.zg.number.controller;

import com.zg.number.bean.AddCard;
import com.zg.number.bean.User;
import com.zg.number.service.ChongZhiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by 任彩雨 on 2017/8/11.
 */
@Controller
@RequestMapping("rcy")
public class ChongZhiController {

    @Autowired
    private ChongZhiService chongZhiService;

    @RequestMapping("toChongZhi")
    private String toChongZhi(HttpSession session, Model model) {
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser != null) {
            System.out.println("登录的用户：" + loginUser.getUserId());
            AddCard addCard = chongZhiService.selectCardYue(loginUser.getUserId());
            System.out.println("登录的用户的银行卡余额：" + addCard.getCardYue());
            model.addAttribute("cardAllYue", addCard.getCardYue());
            return "top/chongzhi";
        }
        return "top/chongzhi";
    }


}
