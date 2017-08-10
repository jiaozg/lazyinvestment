package com.zg.number.service.impl;

import com.zg.number.bean.Invest;
import com.zg.number.bean.Record;
import com.zg.number.bean.User;
import com.zg.number.mapper.LanRenMapper;
import com.zg.number.service.LanRenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengshuo on 2017/8/8.
 */
@Service
@Component
public class LanRenServiceImp implements LanRenService {

    @Autowired
    private LanRenMapper lanRenMapper;

    //懒人计划总查询
    @Override
    public List<Invest> selectLanRen(){
        return lanRenMapper.selectLanRen();
    }

    //投资风云榜
    @Override
    public List<User> selectUserAndRecord() {
        List<User> list=  lanRenMapper.selectUserAndRecord();
        int i = 1;
        for (User u: list) {
            String sb = u.getUserName();
            String name = sb.replace(sb.substring(1,sb.length()-1),"***");
            u.setUserName(name);
            u.setUserId(i);
            i++;
        }
        return list;
    }

    @Override
    public void insertRecord(Record record) {
        lanRenMapper.insertRecord(record);
    }

    ;
}
