package org.jiang.combo.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class PlatformMain {
    public static void main(String[] args) {
        SpringApplication.run(PlatformMain.class, args);
    }
}
