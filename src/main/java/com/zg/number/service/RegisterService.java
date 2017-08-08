package com.zg.number.service;

import com.zg.number.bean.User;

import java.util.List;

/**
 * Created by 任彩雨 on 2017/8/8.
 */
public interface RegisterService {

    User register(User user);

    User login(User user);

    List<User> userNameOnly(String username);//用户名唯一

    List<User> phoneOnly(String phone);//手机号唯一
}
