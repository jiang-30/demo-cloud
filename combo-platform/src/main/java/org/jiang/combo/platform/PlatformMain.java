package org.jiang.combo.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlatformMain {

//    @Bean
//    @LoadBalanced
//    public RestTemplate getRestTemplate(){
//        return new RestTemplate();
//    }

    public static void main(String[] args) {
        SpringApplication.run(PlatformMain.class, args);
    }
}
