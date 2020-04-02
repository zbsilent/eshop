package com.yonyou.openapi.service;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 /**
 * @author zbsilent
 */
@Service
@FeignClient(name = "getToken",url = "https://openapi.yonyoucloud.com",fallbackFactory = HostServiceFallbackFactory.class)
public interface HttpServices {


//    String URL = "https://openapi.yonyoucloud.com/token?appid=xxx&secret=xxx";
    //String URL  = "";

    @RequestMapping(value = "/token",method = RequestMethod.GET)
    @CachePut(value = "tokenjson",key = "#secret")
    String getToken(@RequestParam(name="appid")String appid, @RequestParam(name="secret")String secret) ;

}
