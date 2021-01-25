package com.txj.business.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author lenovo
 *
 * 统一入口
 * 鉴权校验
 * 动态路由
 * 减少客户端与服务端的耦合：服务可以独立发展，通过网关层来做映射
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

}
