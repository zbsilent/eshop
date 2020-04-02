package com.island.eshop.auth.controller;

import com.island.eshop.auth.service.MyUserDetailService;
import com.island.eshop.common.entity.Result;
import com.island.eshop.common.enumeration.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * 〈会员Controller〉
 *
 * @author Curise
 * @create 2018/12/13
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api")
public class MemberController {

    @Autowired
    private MyUserDetailService userDetailService;

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    /**
     * 获取当前认证用户(authenticated principal)最简单的方式是通过SecurityContextHolder类的静态方法
     * Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
     * String currentPrincipalName = authentication.getName();
     * UserDetails userDetails = (UserDetails) authentication.getPrincipal();
     *
     * 在@Controller 注解的bean里，有额外的选项。principal 可以直接作为方法参数，框架会自动赋值。
     *
     * 这个对象通常是UserDetails的实例
     */
    @GetMapping("/member")
    public Principal user(Principal member) {
        return member;
    }

    @DeleteMapping(value = "/exit")
    public Result revokeToken(String access_token) {
        Result result = new Result();
        if (consumerTokenServices.revokeToken(access_token)) {
            result.setCode(ResultCode.SUCCESS.getCode());
            result.setMessage("注销成功");
        } else {
            result.setCode(ResultCode.FAILED.getCode());
            result.setMessage("注销失败");
        }
        return result;
    }
}
