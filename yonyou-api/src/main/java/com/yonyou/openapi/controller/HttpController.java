package com.yonyou.openapi.controller;

import com.yonyou.openapi.service.HttpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbsilent
 */
@RestController
@RequestMapping("/yy")
public class HttpController {

    @Autowired
    private HttpServices httpServices;

    @GetMapping("getToken")
    @PreAuthorize("hasAnyAuthority('getoken')")
    public String getToken(@RequestParam(name="appid")String appid, @RequestParam(name="secret")String secret) {
        return httpServices.getToken(appid,secret);
    }
}
