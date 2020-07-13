package com.yonyou.yapi.bj.controller;
import com.open.util.LogUtils;
import com.yonyou.yapi.service.TestSservice;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/dd")
public class controller {


    @Autowired
    private TestSservice testSservice;

    @GetMapping("query")
    @PreAuthorize("hasAnyAuthority('query')")
    public String query() throws Exception{
        String xx = null;
        try{
            Logger log = LogUtils.getBussinessLogger();
            log.info("esadfsfadfasdfa**********");
            xx =  testSservice.query();
        }catch (Exception e){
            e.printStackTrace();
            xx = e.getMessage();
        }
       return xx;
    }
}
