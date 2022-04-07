package org.jiang.combo.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 资源文件 默认 static；并且不需要添加 /static 前缀
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * swagger-bootstrap-ui
         */
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * 默认在 templates 下查找；添加后缀 .html
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {}

}
