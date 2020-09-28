package com.zc.flowable.common;

import org.flowable.engine.*;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.task.api.Task;

import java.util.List;

/**
 * @author zhao.cheng
 */
public class TenMinuteTutorial {

  public static void main(String[] args) {

    // 创建Flowable流程引擎
    ProcessEngine processEngine = ProcessEngineConfiguration
      .createStandaloneProcessEngineConfiguration()
      .buildProcessEngine();

    // 获取Flowable服务
    RepositoryService repositoryService = processEngine.getRepositoryService();
    RuntimeService runtimeService = processEngine.getRuntimeService();

    // 部署流程定义
    repositoryService.createDeployment()
      .addClasspathResource("FinancialReportProcess.bpmn20.xml")
      .deploy();

    // 启动流程实例
    String procId = runtimeService.startProcessInstanceByKey("financialReport").getId();

    // 获取第一个任务
    TaskService taskService = processEngine.getTaskService();
    List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("accountancy").list();
    for (Task task : tasks) {
      System.out.println("Following task is available for accountancy group: " + task.getName());

      // 申领任务
      taskService.claim(task.getId(), "fozzie");
    }

    // 验证Fozzie获取了任务
    tasks = taskService.createTaskQuery().taskAssignee("fozzie").list();
    for (Task task : tasks) {
      System.out.println("Task for fozzie: " + task.getName());

      // 完成任务
      taskService.complete(task.getId());
    }

    System.out.println("Number of tasks for fozzie: "
            + taskService.createTaskQuery().taskAssignee("fozzie").count());

    // 获取并申领第二个任务
    tasks = taskService.createTaskQuery().taskCandidateGroup("management").list();
    for (Task task : tasks) {
      System.out.println("Following task is available for management group: " + task.getName());
      taskService.claim(task.getId(), "kermit");
    }

    // 完成第二个任务并结束流程
    for (Task task : tasks) {
      taskService.complete(task.getId());
    }

    // 验证流程已经结束
    HistoryService historyService = processEngine.getHistoryService();
    HistoricProcessInstance historicProcessInstance =
      historyService.createHistoricProcessInstanceQuery().processInstanceId(procId).singleResult();
    System.out.println("Process instance end time: " + historicProcessInstance.getEndTime());
  }
}