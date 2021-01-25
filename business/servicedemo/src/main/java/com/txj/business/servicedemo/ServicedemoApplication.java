package com.txj.business.servicedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lenovo
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServicedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicedemoApplication.class, args);
    }

}
