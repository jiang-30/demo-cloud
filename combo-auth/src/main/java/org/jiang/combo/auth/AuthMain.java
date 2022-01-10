package org.jiang.combo.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthMain {
    public static void main(String[] args) {
        SpringApplication.run(AuthMain.class, args);
    }
}
