package com.zg.number.mapper;

import com.zg.number.bean.AddCard;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by 任彩雨 on 2017/8/11.
 */
@Component
@Mapper
public interface ChongZhiMapper {

    AddCard selectCardYue(Integer uid);//通过用户的ID去查看银行卡的余额
}
