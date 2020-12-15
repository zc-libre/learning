package com.zc.flowable;


import org.flowable.ui.modeler.conf.ApplicationConfiguration;
import org.flowable.ui.modeler.conf.DatabaseConfiguration;
import org.flowable.ui.modeler.servlet.AppDispatcherServletConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @author zhao.cheng
 * @date 2020/9/1 14:33
 */
//启用全局异常拦截器
@Import(value={
        // 引入修改的配置
        ApplicationConfiguration.class,
        AppDispatcherServletConfiguration.class,
        // 引入 DatabaseConfiguration 表更新转换
        DatabaseConfiguration.class})
@MapperScan("com.zc.flowable.mapper")
@ComponentScan(basePackages = "com.zc")
@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class FlowableApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlowableApplication.class, args);
    }
}
