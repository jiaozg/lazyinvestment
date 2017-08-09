package com.zg.number.service.impl;

import com.zg.number.bean.AddCard;
import com.zg.number.mapper.CardMapper;
import com.zg.number.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ${hanwenjian} on 2017/8/9.
 */
@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardMapper cardMapper;

    @Override
    public void addcardxinxi(AddCard addCard) {
        cardMapper.addcardxinxi(addCard);
    }
}
