package com.yonyou.openapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * EnableDiscoveryClient 其他注册中心用
 * @author zbsilent
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableTransactionManagement
public class YonyouApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(YonyouApiApplication.class, args);
    }

}
