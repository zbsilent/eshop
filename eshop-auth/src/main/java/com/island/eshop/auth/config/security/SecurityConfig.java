package com.island.eshop.auth.config.security;

import com.island.eshop.auth.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 〈security配置〉
 *
 * @author Curise
 * @create 2018/12/13
 * @since 1.0.0
 */
@Configuration
@EnableWebSecurity
@Order(2)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailService userDetailService;


    @Bean
    public PasswordEncoder passwordEncoder() {
        //return new BCryptPasswordEncoder();
        return new NoEncryptPasswordEncoder();
    }

    /**
     *  AuthenticationManagerBuilder
     *
     *  WebSecurityConfigurerAdapter 中通过重写
     *  protected void configure(AuthenticationManagerBuilder auth)
     *  实现Inmemory，LDAP，JDBC方式的认证，同时SpringBoot提供了默认的Login界面（DefaultLoginPageConfigurer<>()）
     */

    /**
     *  httpSecurity
     *
     *  WebSecurityConfigurerAdapter 中通过重写
     *  protected void configure(HttpSecurity http)
     *  实现CORS ，自定义登陆 / 登出界面，是否需要认证等自定义配置机能
     *             默认指定
     *
     *    http
     * 	.authorizeRequests().anyRequest().authenticated() //所有的request都需要认证
     * 	.and()
     * 	.formLogin()   // 缺省login界面认证
     * 	.and()
     * 	.httpBasic();  // Basic认证
     */
    /**
     * authorizeRequests()配置路径拦截，表明路径访问所对应的权限，角色，认证信息。
     * authorizeRequests请求认证
     * .anyRequest()   对于任何请求都需要认证
     * .authenticated();  认证通过了才能访问
     *
     * @param http
     * @throws Exception
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.requestMatchers().antMatchers("/oauth/**")
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/**").authenticated()
                .and()
                .csrf().disable();//关闭跨站请求伪造功能
    }


    /**
     * AuthenticationManagerBuilder用于创建AuthenticationManager。
     * 允许轻松构建内存身份验证，LDAP身份验证，
     * 基于JDBC的身份验证，
     * 添加UserDetailsService以及添加AuthenticationProvider
     * 这里采用无密码加密认证
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        DaoAuthenticationConfigurer<AuthenticationManagerBuilder, MyUserDetailService>
                daoAuthenticationConfigurer
                = auth.userDetailsService(userDetailService);

        daoAuthenticationConfigurer.passwordEncoder(passwordEncoder());
    }

    /**
     * 不定义没有password grant_type,密码模式需要AuthenticationManager支持
     *
     * @return
     * @throws Exception
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



}
