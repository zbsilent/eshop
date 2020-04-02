package com.island.eshop.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 开启服务注册中心
 * @author zbsilent
 */
@SpringBootApplication
@EnableEurekaServer
public class EshopServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopServerApplication.class, args);
    }

}
