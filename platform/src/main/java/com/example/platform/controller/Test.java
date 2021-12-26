package com.example.platform.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class Test {

    @Resource
    private RestTemplate restTemplate;

    @Value("${config.info}")
    String configInfo;

    @GetMapping("/abc")
    public String index(){
        String str = restTemplate.getForObject("http://auth-server/test", String.class);
        return configInfo + ";" + "'platform'" + str;

//        return  "platform";
    }

    @GetMapping("/platform/abc")
    public String platformAbc(){
        return  "platform";
    }
}
