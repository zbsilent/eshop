package com.yonyou.openapi.controller;

import com.alibaba.fastjson.JSONObject;
import com.yonyou.openapi.service.HttpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author zbsilent
 */
@RestController
@RequestMapping("/yy")
public class HttpController {

    private static final Boolean TRUE = true;
    private static final Boolean FALSE = false;
    private static final String INDEX_URL ="index";
    @Autowired
    private HttpServices httpServices;

    /**
     * @RequestMapping(value="/selectByName/{name}",method=RequestMethod.GET)
     * selectByUserName(@PathVariable String name, ModelMap map){
     *
     * @param appid 友空间ID
     * @param secret 友空间其他
     * @param modelMap
     * @return
     */
    @GetMapping("getToken")
    @PreAuthorize("hasAnyAuthority('getoken')")
    public String getToken(@RequestParam(name = "appid") String appid, @RequestParam(name = "secret") String secret, ModelMap modelMap) {
        String token = httpServices.getToken(appid, secret);

        if(checkResult(token)){
            modelMap.addAttribute("token",JSONObject.parseObject(token).getString("data"));
        }
        if(modelMap.containsKey("token")){
             return JSONObject.parseObject(modelMap.getAttribute("token").toString()).getString("access_token");
        }else{
            return "查询异常";
        }

    }


    private Boolean checkResult(String res) {
        JSONObject jsonObject = JSONObject.parseObject(res);

        Integer code = jsonObject.getInteger("code");
        if (code == 0) {
            return TRUE;
        } else{
            return FALSE;
        }
    }
}
