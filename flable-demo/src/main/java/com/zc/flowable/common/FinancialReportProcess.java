package com.zc.flowable.common;

import lombok.RequiredArgsConstructor;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.impl.RepositoryServiceImpl;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.runtime.ProcessInstance;

/**
 * @author zhao.cheng
 * @date 2020/9/2 9:26
 */

public class FinancialReportProcess {

    public void deploy(RepositoryService repositoryService) {
        repositoryService.createDeployment()
                         .addClasspathResource("processes/FinancialReportProcess.bpmn20.xml")
                         .deploy();
    }

    public void start(RuntimeService runtimeService) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("financialReport");
    }

    public ProcessEngine createProcessEngine() {
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
                .setJdbcUsername("sa")
                .setJdbcPassword("")
                .setJdbcDriver("org.h2.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        return cfg.buildProcessEngine();
    }


}
