package com.zc.account.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhao.cheng
 */
@MapperScan("com.zc.account.mapper")
@Configuration
@EnableTransactionManagement
public class MyBatisPlusConfig {

  @Bean
    public SqlLogInterceptor sqlLogInterceptor() {
      return new SqlLogInterceptor();
  }
}
