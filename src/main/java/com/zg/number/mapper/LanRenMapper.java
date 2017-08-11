package com.zg.number.mapper;

import com.zg.number.bean.Invest;
import com.zg.number.bean.Record;
import com.zg.number.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by fengshuo on 2017/8/8.
 */
@Mapper
@Component
public interface LanRenMapper {

    List<Invest> selectLanRen();//懒人计划总查询

    List<User> selectUserAndRecord();//投资风云榜

    void insertRecord(Record record);//投资记录表添加数据

    Invest selectRecordSurplusMoney(int uId);//根据id查询Record表剩余Money

    void updateRecordSurplusMoney(int money,int uId);//根据id修改Record表Money

}
