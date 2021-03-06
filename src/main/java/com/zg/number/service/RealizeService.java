package com.zg.number.service;

import com.zg.number.bean.Captail;
import com.zg.number.bean.Invest;
import com.zg.number.bean.Record;

import java.util.List;

/**
 * Created by wrx on 2017/8/7.
 */
public interface RealizeService {

    /**
     * 查询一锤定音表:实现变现计划
     */
    public List<Invest> selectInvest();
    /**
     * 马上投资:根据id查询项目的详细信息
     */
    public Invest projectstail(Integer id);
    /**
     * 余额查询
     */
    public Captail selectYvE(Integer id);
    /**
     * 将投资信息注入到投资记录表
     */
    public void addRecord(Record record);
    /**
     * 修改资产表的账户余额
     */
    public void updateCaptail(Captail captail);
    /**
     * 修改一锤定音表的剩余金额
     */
    public void updateSurplusMoney(Invest invest);

}
