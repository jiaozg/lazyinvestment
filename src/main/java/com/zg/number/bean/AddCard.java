package com.zg.number.bean;

import lombok.Data;

/**
 * Created by 任彩雨 on 2017/8/5.
 *
 * @Action 银行卡类--
 * 一个用户可以有多个银行卡，一对多关系的多发
 */
@Data
public class AddCard {
    private int cardId;
    private String cardName;
    private String caerdNum;
    private String cardCard;
    private String cardPhone;
    private String cardPwd;
    private User user;//User实体类
}
