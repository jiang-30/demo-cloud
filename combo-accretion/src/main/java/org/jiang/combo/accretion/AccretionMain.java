package org.jiang.combo.accretion;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"org.jiang.combo.accretion.salute.mapper", "org.jiang.combo.accretion.demo.mapper"})
public class AccretionMain {
    public static void main(String[] args) {
        SpringApplication.run(AccretionMain.class, args);
    }
}
