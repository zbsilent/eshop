package com.yonyou.openapi.service;

import feign.hystrix.FallbackFactory;

/**
 *
 * @author zbsilent
 */
public class HostServiceFallbackFactory implements FallbackFactory<HttpServices> {
    @Override
    public HttpServices create(Throwable throwable) {
        return new HttpServices() {
            @Override
            public String getToken(String appid, String secret) {
                return "服务异常，启动熔断,HelloWorld";
            }
        };
    }
}
