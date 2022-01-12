package org.jiang.combo.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@MapperScan("org.jiang.combo.platform.mapper")
@EnableWebMvc
public class PlatformMain {
    public static void main(String[] args) {
        SpringApplication.run(PlatformMain.class, args);
    }
}
