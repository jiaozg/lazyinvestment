package com.zg.number.bean;

import lombok.Data;

/**
 * Created by 任彩雨 on 2017/8/5.
 * 投资记录表
 */
@Data
public class Record {
    private int recordId;
    private String recordName;//投资人
    private int recordMoney;//投资的金额
    private String irecordTime;//投资时间
    private String investType;//投资方式
    private String recordStatus;//状态
    private User user;
    private int uid;//用户的主键
}
