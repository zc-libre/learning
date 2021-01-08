package com.zc.order.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhao.cheng
 * @date 2020/12/17 9:06
 */
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level logger() {
        return Logger.Level.FULL;
    }

}
