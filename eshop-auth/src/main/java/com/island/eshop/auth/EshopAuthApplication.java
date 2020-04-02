package com.island.eshop.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zbsilent
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.island.eshop.auth.dao")
public class EshopAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopAuthApplication.class, args);
    }

}
