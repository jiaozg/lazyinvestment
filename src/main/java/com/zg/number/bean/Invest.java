package com.zg.number.bean;

import lombok.Data;

/**
 * Created by 任彩雨 on 2017/8/5.
 * 投资表
 */
@Data
public class Invest {
    private int investId;
    private int surplusMoney;//剩余金额
    private int projectTime;//
    private double revenueMoney;//年化收益项目期限
    private String planName;//计划名称
    private double planMoney;//预计年化
    private double WanYuanEarnings;//预计万元收益
    private String endtime;//到期日
    private Integer touzi;//投资的金额
    //private double captailMoney;//余额

}
