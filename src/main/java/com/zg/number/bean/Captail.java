package com.zg.number.bean;

import lombok.Data;

/**
 * Created by lenovo on 2017/8/10.
 * 资产表
 */
@Data
public class Captail {
    private int captailId;
    private double captailMoney;//余额
    private int userId;//用户外键
}
