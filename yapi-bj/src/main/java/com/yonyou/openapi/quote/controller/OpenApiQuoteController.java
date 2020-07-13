package com.yonyou.openapi.quote.controller;
import com.open.util.LogUtils;
import com.yonyou.openapi.quote.service.OpenApiQuoteSservice;
 import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/dd")
public class OpenApiQuoteController {


    @Autowired
    private OpenApiQuoteSservice openApiQuoteSservice;

    @GetMapping("query")
    @PreAuthorize("hasAnyAuthority('query')")
    public String query(Integer id) throws Exception{
        String xx = null;
        try{
            Logger log = LogUtils.getBussinessLogger();
            log.info("esadfsfadfasdfa**********");
            xx =  openApiQuoteSservice.query(id);
        }catch (Exception e){
            e.printStackTrace();
            xx = e.getMessage();
        }
       return xx;
    }


    @GetMapping("queryItem")
    @PreAuthorize("hasAnyAuthority('queryItem')")
    public String queryItem(Integer id) throws Exception{
        String xx = null;
        try{
            Logger log = LogUtils.getBussinessLogger();
            log.info("esadfsfadfasdfa**********");
            xx =  openApiQuoteSservice.queryByQuoteId(id);
        }catch (Exception e){
            e.printStackTrace();
            xx = e.getMessage();
        }
        return xx;
    }
}
