package org.jiang.combo.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class Knife4jConfig {
    Boolean swaggerEnabled=true;

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30)
                .enable(swaggerEnabled)
                .apiInfo(apiInfo())
                .groupName("combo-platform")
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.jiang.combo.platform.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("项目接口文档")
                .description("项目描述")
                .contact(new Contact("作者", "作者URL", "作者Email"))
                .version("1.0")
                .build();
    }
}
