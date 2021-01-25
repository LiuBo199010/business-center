package com.txj.business.servicedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author lenovo
 */
@RefreshScope
@RestController
@RequestMapping("/demo")
public class ServiceAController {

    @Value("${name:unknown}")
    private String name;

    @Autowired
    EurekaDiscoveryClient discoveryClient;

    @GetMapping(value = "/")
    public String printServiceA() {
        return null;
    }


    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping(path = "/current")
    public Principal getCurrentAccount(Principal principal) {
        return principal;
    }
}