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

//    int count ();//总页数

    List<User> selectUserAndAssest();//投资风云榜

}
