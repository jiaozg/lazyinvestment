package com.zg.number.mapper;

import com.zg.number.bean.Invest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by WangHongChuan on 2017/8/8.
 * 主页查询的短期灵活和中期稳健和长期猛赚
 */
@Mapper
@Component
public interface IndexMapper {
    //获取主页上面的懒计划数据
    List<Invest> findIndexData();
}
