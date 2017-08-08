package com.zg.number.service.impl;

import com.zg.number.bean.User;
import com.zg.number.mapper.RegisterMapper;
import com.zg.number.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 任彩雨 on 2017/8/8.
 */
@Service
@Component
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public User register(User user) {
        User register = registerMapper.register(user);
        return register;
    }

    @Override
    public User login(User user) {
        User loginUser = registerMapper.login(user);
        return loginUser;
    }

    @Override
    public List<User> userNameOnly(String username) {
        List<User> userNameOnly = registerMapper.userNameOnly(username);
        return userNameOnly;
    }

    @Override
    public List<User> phoneOnly(String phone) {
        List<User> phoneOnly = registerMapper.phoneOnly(phone);
        return phoneOnly;
    }
}
