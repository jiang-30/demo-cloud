package org.jiang.combo.admin;

import org.jiang.combo.admin.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@EnableConfigurationProperties(value= AppProperties.class)
@SpringBootApplication
public class ComboAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ComboAdminApplication.class, args);
    }
}
