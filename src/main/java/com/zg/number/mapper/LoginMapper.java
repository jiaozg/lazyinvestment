package com.zg.number.mapper;

import com.zg.number.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by 任彩雨 on 2017/8/7.
 */
@Component
@Mapper
public interface LoginMapper {
    User login(User user);
}
