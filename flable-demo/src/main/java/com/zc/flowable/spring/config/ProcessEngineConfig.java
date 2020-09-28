package com.zc.flowable.spring.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.*;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 流程引擎配置文件
 *
 * @author zhao.cheng*/
@Slf4j
@Configuration
@RequiredArgsConstructor
public class ProcessEngineConfig {

     private final DataSourceProperties datasourceProperties;

    /**
     * 初始化流程引擎
     * @return /
     */
    @Primary
    @Bean(name = "processEngine")
    public ProcessEngine initProcessEngine() {
        log.info("=============================ProcessEngineBegin=============================");
        // 流程引擎配置
        ProcessEngineConfiguration cfg = null;
        try {
            cfg = new StandaloneProcessEngineConfiguration()
                    .setJdbcUrl(datasourceProperties.getUrl())
                    .setJdbcUsername(datasourceProperties.getUsername())
                    .setJdbcPassword(datasourceProperties.getPassword())
                    .setJdbcDriver(datasourceProperties.getDriverClassName())
                    // 初始化基础表，不需要的可以改为 DB_SCHEMA_UPDATE_FALSE
                    .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
                    // 默认邮箱配置
                    // 发邮件的主机地址，先用 QQ 邮箱
                    .setMailServerHost("smtp.qq.com")
                    // POP3/SMTP服务的授权码
                    .setMailServerPassword("xvhkwdvsnuvgbgdf")
                    // 默认发件人
                    .setMailServerDefaultFrom("504879189@qq.com")
                    // 设置发件人用户名
                    .setMailServerUsername("管理员")
                    // 解决流程图乱码
                    .setActivityFontName("宋体")
                    .setLabelFontName("宋体")
                    .setAnnotationFontName("宋体");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 初始化流程引擎对象
        assert cfg != null;
        ProcessEngine processEngine = cfg.buildProcessEngine();
        log.info("=============================ProcessEngineEnd=============================");
        return processEngine;
    }
   

}