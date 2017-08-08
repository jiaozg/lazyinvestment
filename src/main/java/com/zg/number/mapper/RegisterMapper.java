package com.zg.number.mapper;

import com.zg.number.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 任彩雨 on 2017/8/8.
 */
@Component
@Mapper
public interface RegisterMapper {

    //注册
    void register(User user);

    List<User> userNameOnly(String username);//用户名唯一

    List<User> phoneOnly(String phone);//手机号唯一
}
