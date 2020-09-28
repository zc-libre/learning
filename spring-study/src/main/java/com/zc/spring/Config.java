package com.zc.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

/**
 * @author zhao.cheng
 * @date 2020/9/4 10:44
 */
@Configuration
public class Config {

    @Bean
    public BeanA beanA() {
        return new BeanA();
    }
}
