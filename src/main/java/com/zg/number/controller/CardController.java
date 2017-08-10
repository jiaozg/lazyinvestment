package com.zg.number.controller;

import com.zg.number.bean.AddCard;
import com.zg.number.bean.User;
import com.zg.number.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by ${hanwenjian} on 2017/8/9.
 */
@Controller
@RequestMapping("hwj")
public class CardController {

    @Autowired
    private CardService cardService;
    //我的账户页面
    @RequestMapping("myCard")
    public String myCard() {
        return "menu/wodezhanghu";
    }
    //添加银行卡页面
    @RequestMapping("addCard")
    public String addCard(HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        int userId = loginUser.getUserId();
        System.out.println(userId);
        return "centre/yinhang";
    }
    //添加银行卡信息
    @RequestMapping("addcardxinxi")
    public String addCardXinXi(AddCard addCard, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        int userId = loginUser.getUserId();
        System.out.println(userId);
        addCard.setUid(userId);
        System.out.println(addCard);
        cardService.addcardxinxi(addCard);
        return "forward:myCard";
    }

}
