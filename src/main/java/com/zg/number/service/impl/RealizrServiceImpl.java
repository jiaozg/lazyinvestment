package com.zg.number.service.impl;

import com.zg.number.bean.Captail;
import com.zg.number.bean.Invest;
import com.zg.number.mapper.RealizeMapper;
import com.zg.number.service.RealizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2017/8/8.
 */
@Service
@Component
public class RealizrServiceImpl implements RealizeService {

    @Autowired
    private RealizeMapper realizeMapper;

    /**
     * 查询一锤定音表:实现变现计划
     */
    @Override
    public List<Invest> selectInvest() {
        List<Invest> invests = realizeMapper.selectInvest();
        if(invests!=null&&invests.size()>0){
            for (Invest t:invests){
                System.out.println(t);
           }
        }
        return invests;
    }
    /**
     * 马上投资:根据id查询项目的详细信息
     */
    @Override
    public Invest projectstail(Integer id) {
        Invest project = realizeMapper.projectstail(id);
        System.out.println(project);

        return project;
    }
    /**
     * 余额查询
     */
    @Override
    public Captail selectYvE(Integer id) {
        Captail captail = realizeMapper.selectYvE(id);
        System.out.println(captail);
        return captail;
    }
}
