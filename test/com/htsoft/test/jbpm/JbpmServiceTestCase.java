package com.htsoft.test.jbpm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.jbpm.api.ExecutionService;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.TaskService;
import org.jbpm.pvm.internal.env.EnvironmentFactory;
import org.jbpm.pvm.internal.env.EnvironmentImpl;
import org.jbpm.pvm.internal.model.ActivityImpl;
import org.jbpm.pvm.internal.model.ExecutionImpl;
import org.jbpm.pvm.internal.model.ProcessDefinitionImpl;
import org.jbpm.pvm.internal.task.TaskDefinitionImpl;
import org.jbpm.pvm.internal.task.TaskImpl;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.oa.service.flow.JbpmService;
import com.htsoft.test.BaseTestCase;

public class JbpmServiceTestCase extends  BaseTestCase{
	@Resource
	private ProcessEngine processEngine;
	@Resource
	private JbpmService jbpmService;
	@Resource
	private TaskService taskService;
	@Resource
	private ExecutionService executionService;
	
	@Test
	@Rollback(false)
	public void createTask(){
		EnvironmentImpl env=null;
		String taskId="430018";
		String taskName="开始";
		try{
			env=((EnvironmentFactory) processEngine).openEnvironment();
			ProcessInstance pi=jbpmService.getProcessInstanceByTaskId(taskId);
			
			ProcessDefinitionImpl pd=(ProcessDefinitionImpl)jbpmService.getProcessDefinitionByTaskId(taskId);
			
			TaskDefinitionImpl taskDef= pd.getTaskDefinition(taskName);
			
			if(taskDef==null){
				//查看其是否为开始任务
				//String startName=jbpmService.getStartNodeName();
				TaskDefinitionImpl taskDefinition = new TaskDefinitionImpl();
			    taskDefinition.setName(taskName);
			    taskDefinition.setPriority(1);
			    
			    taskDefinition.setProcessDefinition(pd);
			    
			    ActivityImpl startActivityImpl=pd.findActivity(taskName);
			    
			    ActivityImpl startTaskImpl=pd.createActivity();
			    startTaskImpl.setName(taskName);
			    List outTrans=new ArrayList();
			    outTrans.addAll(startActivityImpl.getOutgoingTransitions());
			    startTaskImpl.setOutgoingTransitions(outTrans);
			    
			}
			System.out.println("pi:" + pi);
			ExecutionImpl exeImpl=(ExecutionImpl)pi;
			
			exeImpl.setActivity(pd.findActivity(taskName));
			
			//产生新的回退任务
			TaskImpl task=(TaskImpl)taskService.newTask();
			task.setDescription(taskName);
			
			task.setProcessInstance((ExecutionImpl)pi);
			task.setName(taskName);
			task.setActivityName(taskName);
			task.setExecution(exeImpl.getExecution());
			task.setAssignee("1");
			task.setCreateTime(new Date());
			task.setNew(true);	
			if(taskDef!=null){
				task.setTaskDefinition(taskDef);
			}
			taskService.saveTask(task);
			
			//加上流程任务的定义
		}finally{
			if(env!=null)env.close();
		}
	}
}
