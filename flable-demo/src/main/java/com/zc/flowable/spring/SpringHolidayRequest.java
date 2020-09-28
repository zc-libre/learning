package com.zc.flowable.spring;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;

/**
 * @author zhao.cheng
 * @date 2020/9/1 14:27
 */
public class SpringHolidayRequest {

    public void init() {
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
                .setJdbcUsername("sa")
                .setJdbcPassword("")
                .setJdbcDriver("org.h2.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        // 初始化流程引擎对象
        ProcessEngine processEngine = cfg.buildProcessEngine();

        // 流程引擎配置
         cfg = ProcessEngineConfiguration
                // 根据文件名获取配置文件
                //.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
                // 获取默认配置文件，默认的就是 activiti.cfg.xml
                .createProcessEngineConfigurationFromResourceDefault()
                // 初始化基础表，不需要的可以改为 DB_SCHEMA_UPDATE_FALSE
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
// 初始化流程引擎对象

    }
}
