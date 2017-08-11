package com.zg.number.bean;

import lombok.Data;

/**
 * Created by lenovo on 2017/8/11.
 * 分页参数的封装类
 */
@Data
public class Pagelimit {
    private Integer firstPage;
    private Integer lastPage;
    private Integer nextPage;
    private Integer proPage;
}