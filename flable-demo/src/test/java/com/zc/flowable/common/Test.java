package com.zc.flowable.common;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;

import java.util.List;

/**
 * @author zhao.cheng
 * @date 2020/9/2 9:38
 */
public class Test {
    public static void main(String[] args) {
        FinancialReportProcess financialReportProcess = new FinancialReportProcess();
        ProcessEngine processEngine = financialReportProcess.createProcessEngine();
        financialReportProcess.deploy(processEngine.getRepositoryService());
        financialReportProcess.start(processEngine.getRuntimeService());

        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("accountancy").list();
        tasks.forEach(task -> {
            taskService.claim(task.getId(), "fozzie");
        });

        System.out.println(taskService.createTaskQuery().taskAssignee("fozzie").list());

    }
}
