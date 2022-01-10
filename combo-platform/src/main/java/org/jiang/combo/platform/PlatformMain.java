package org.jiang.combo.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.jiang.combo.platform.mapper")
public class PlatformMain {
    public static void main(String[] args) {
        SpringApplication.run(PlatformMain.class, args);
    }
}
