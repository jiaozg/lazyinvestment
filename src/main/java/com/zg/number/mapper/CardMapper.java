package com.zg.number.mapper;

import com.zg.number.bean.AddCard;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by ${hanwenjian} on 2017/8/9.
 */
@Component
@Mapper
public interface CardMapper {

    void addcardxinxi(AddCard addCard);
}
