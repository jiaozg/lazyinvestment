package com.zg.number.service;

import com.zg.number.bean.Invest;
import com.zg.number.bean.User;

import java.util.List;

/**
 * Created by fengshuo on 2017/8/8.
 */
public interface LanRenService {

    List<Invest> selectLanRen();//懒人计划总查询

//    int count ();//总页数

    List<User> selectUserAndAssest();//投资风云榜
}
