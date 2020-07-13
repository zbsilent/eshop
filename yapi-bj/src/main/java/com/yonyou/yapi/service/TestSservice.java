package com.yonyou.yapi.service;
import com.yonyou.yapi.bj.mapper.YApiIndexDao;
import com.yonyou.yapi.entity.YApiIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestSservice {

    @Autowired
    private YApiIndexDao yApiIndexDao;


    public String query(){
        return yApiIndexDao.findAll().toString();
    }

}
