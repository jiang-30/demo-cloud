package org.jiang.combo.common.config;

import lombok.RequiredArgsConstructor;
import org.passay.MessageResolver;
import org.passay.spring.SpringMessageResolver;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@RequiredArgsConstructor
@Configuration
public class WebMvcConfig extends WebMvcAutoConfiguration {

    private final MessageSource messageSource;

    /**
     * passay 校验国际化
     */
    @Bean
    public MessageResolver messageResolver() {
        return new SpringMessageResolver(messageSource);
    }

    /**
     * validation 国际化
     */
//    @Bean
//    public LocalValidatorFactoryBean localValidatorFactoryBean() {
//        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
//        localValidatorFactoryBean.setValidationMessageSource(messageSource);
//        return localValidatorFactoryBean;
//    }
}
