package com.zg.number.service;

import com.zg.number.bean.Invest;

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

}
