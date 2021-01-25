package com.txj.business.registry;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  注册中心
 *
 * @author lenovo
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistryApplication {

    @Value("${server.port}")
    String port;

    public static void main(String[] args) {
        SpringApplication.run(RegistryApplication.class, args);
    }

    @RequestMapping("/")
    public String home() {
        return "服务端口号为：" + port;
    }

}
