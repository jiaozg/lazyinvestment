package com.zg.number.service;

import com.zg.number.bean.Invest;

import java.util.List;

/**
 * Created by WangHongChuan on 2017/8/8.
 */
public interface IndexService {
    //获取主页上面的懒计划数据
    List<Invest> findIndexData();
}
