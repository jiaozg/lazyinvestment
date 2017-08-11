package com.zg.number.service;

import com.zg.number.bean.AddCard;

/**
 * Created by 任彩雨 on 2017/8/11.
 */
public interface ChongZhiService {

    AddCard selectCardYue(Integer uid);//通过用户的ID去查看银行卡的余额
}
