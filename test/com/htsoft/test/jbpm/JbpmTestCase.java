package com.htsoft.test.jbpm;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import oracle.net.aso.r;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.jbpm.api.Execution;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;
import org.jbpm.api.cmd.Environment;
import org.jbpm.api.model.Transition;
import org.jbpm.api.task.Task;
import org.jbpm.pvm.internal.env.EnvironmentFactory;
import org.jbpm.pvm.internal.env.EnvironmentImpl;
import org.jbpm.pvm.internal.model.ActivityImpl;
import org.jbpm.pvm.internal.model.ExecutionImpl;
import org.jbpm.pvm.internal.model.ProcessDefinitionImpl;
import org.jbpm.pvm.internal.svc.TaskServiceImpl;
import org.jbpm.pvm.internal.task.TaskImpl;
import org.junit.Test;

import com.htsoft.core.util.XmlUtil;
import com.htsoft.oa.dao.flow.TaskDao;
import com.htsoft.oa.model.flow.ProDefinition;
import com.htsoft.oa.service.flow.JbpmService;
import com.htsoft.oa.service.flow.ProDefinitionService;
import com.htsoft.test.BaseTestCase;

public class JbpmTestCase extends BaseTestCase{
	@Resource
	private ProcessEngine processEngine;
	@Resource
	private RepositoryService repositoryService;
	
	@Resource
	private ExecutionService executionService;
	
	@Resource
	private TaskService taskService;
	
	@Resource
	private ProDefinitionService proDefinitionService;
	@Resource
	private JbpmService jbpmService;
	
	//@Test
	public void deploy(){
		String id=repositoryService.createDeployment().addResourceFromClasspath("com/htsoft/test/jbpm/test.jpdl.xml").deploy();
		System.out.println("deployId:"+id);
	}
	//@Test
	public void deploySignAll(){
		String id=repositoryService.createDeployment().addResourceFromClasspath("com/htsoft/test/jbpm/signAll2.jpdl.xml").deploy();
		System.out.println("deployId:"+id);
	}
	
	//@Test
	public void getByTaskId(){
		String taskId="68";
		TaskImpl task=(TaskImpl)taskService.getTask(taskId);
		EnvironmentFactory environmentFactory = (EnvironmentFactory) processEngine;
        EnvironmentImpl env = environmentFactory.openEnvironment();
        try{
        	ProcessDefinitionImpl pd=(ProcessDefinitionImpl)task.getProcessInstance().getProcessDefinition();
    		ActivityImpl activityFind = pd.findActivity("任务1");
    		
    		if(activityFind!=null){
    			List list=activityFind.getOutgoingTransitions();
    			System.out.println("size:" + list.size());
    		}
    		
        }finally{
        	env.close();
        }
		
		
	}
	
	
	
	public void getExecutionId(){
		String exeId2="pd6717864949166496642.43.连线2";
		//String exeId="pd6717864949166496642.40.连线2";
//		Execution execution= executionService.findExecutionById(exeId2);
//		
//		System.out.println("exeId:" + execution.getId() );
		
		TaskImpl task=(TaskImpl)taskService.getTask("58");
		String deployId="";
		 EnvironmentFactory environmentFactory = (EnvironmentFactory) processEngine;
	        EnvironmentImpl env = environmentFactory.openEnvironment();

	        try {
	        	deployId=task.getProcessInstance().getProcessDefinition().getDeploymentId();
	    		
	    		System.out.println("dpId:" + deployId);

	            
	        } finally {
	            env.close();
	        }
		
		ProDefinition pd=proDefinitionService.getByDeployId(deployId);
		
		System.out.println("taskName:" +task.getActivityName());
		
		System.out.println("pdxml:" + pd.getDefXml());
		Document doc=XmlUtil.stringToDocument(pd.getDefXml());
		
		Element rootEl=doc.getRootElement();
		
		Element taskEl=(Element)rootEl.selectSingleNode("/process/task[@name='"+task.getActivityName()+"']");
		
		if(taskEl!=null){
			List<Node> trans=taskEl.selectNodes("./transition");
			for(int i=0;i<trans.size();i++){
				Element el=(Element)trans.get(i);
				System.out.println("transiton name:" + el.attributeValue("name"));
			}
		}
		
		
		//ProcessDefinition pd=
		//pi.getProcessDefinitionId()
		
		
		
//		EnvironmentFactory environmentFactory = (EnvironmentFactory) processEngine;
//        Environment env = environmentFactory.openEnvironment();

//        try {
//            ExecutionImpl executionImpl = (ExecutionImpl) task;
//            Activity activity = executionImpl.getActivity();
//            
//            System.out.println("name:" + activity.getName());
//            
//            //return activity.getOutgoingTransitions();
//        } finally {
//            env.close();
//        }
        
        
		
	}
	
	/**
	 * deployId=4
	 */
	//@Test
	public void test(){

		//ProcessDefinition pd=repositoryService.createProcessDefinitionQuery().deploymentId("4").uniqueResult();
		
		//ProcessInstance pi=executionService.startProcessInstanceById(pd.getId());
		
		//System.out.println("piId:" + pi.getId());
		//PIID=testSign.3
//		String piId="testSign.3";
//		
//		ProcessInstance pi=executionService.findProcessInstanceById(piId);
//		
//		
//		Set<String> activityNames=pi.findActiveActivityNames();
//		
//		Iterator<String> actIt=activityNames.iterator();
//		
//		while(actIt.hasNext()){
//			
//			String taskName=actIt.next();
//			System.out.println("activyName:" + taskName);
//			
//			
//		}
//		
//		Task task=taskService.createTaskQuery().processInstanceId(pi.getId()).activityName("会签").uniqueResult();
//		
//		if(task!=null){
//			System.out.println("会签");
//			TaskServiceImpl taskServiceImpl=(TaskServiceImpl)taskService;
//			
//			Task newTask=taskService.newTask(task.getId());
//			newTask.setName(task.getName() + "-1");
//			newTask.setAssignee("1");
//			newTask.setDescription(task.getName()+ "-1");
//			
//			taskServiceImpl.saveTask(newTask);
//		}
		
//		List<Task> taskList=taskService.createTaskQuery().processInstanceId(pi.getId()).list();
//		
//		for(Task tk:taskList){
//			System.out.println("task:" + tk.getName());
//		}
		
//		List<Task> taskList=taskService.findPersonalTasks("1");
		
//		for(Task tk:taskList){
//			//taskService.
//			//System.out.println("task:" + tk.getName());
//		}
		
	}
	
	//@Test
	public void completTask(){
		String taskId="122";
		
//		TaskImpl taskImpl=(TaskImpl)taskService.getTask(taskId);
//		
//		TaskImpl superTask=taskImpl.getSuperTask();
//		
//		ProcessInstance pi=superTask.getProcessInstance();
//		
//		System.out.println("pi:" + pi.getName());
		System.out.println("before instance:");
		
		taskService.completeTask(taskId);
		System.out.println("complet task");
	}
	
	
	//@Test
	public void signAll(){
		String deployId="69";
//		ProcessDefinition pd=repositoryService.createProcessDefinitionQuery().deploymentId(deployId).uniqueResult();
//		ProcessInstance pi=executionService.startProcessInstanceById(pd.getId());
//		
//		System.out.println("pid:" + pi.getId());
		
		String piId="signAll2.74";
		
//		List<Task> taskList=taskService.createTaskQuery().processInstanceId(piId).list();
//		
//		for(Task task:taskList){
//			System.out.println("task name:" + task.getActivityName());
//			//taskService.assignTask(task.getId(), "3");
//			
//			jbpmService.newTask(task.getId(), "5,6");
//		}
		
		List<Task> userTaskList=taskService.findPersonalTasks("3");
		
		for(Task tk:userTaskList){
			//taskService.
			System.out.println("userid 1:  task:" + tk.getName() +  " taskId:" + tk.getId());
		}
		
//		List<Task> userTaskList5=taskService.findPersonalTasks("5");
//		
//		for(Task tk:userTaskList5){
//			//taskService.
//			System.out.println("userid 5:  task:" + tk.getName() + " taskId:" + tk.getId());
//		}

	    List<Task> userTaskList6=taskService.findPersonalTasks("6");
		
		for(Task tk:userTaskList6){
			//taskService.
			System.out.println("userid 6:  task:" + tk.getName() + " taskId:" + tk.getId());
			
			TaskImpl tm=(TaskImpl)taskService.getTask(tk.getId());
			
			if(tm!=null){
				System.out.println("sub task:" + tm.getName());
			}else{
				System.out.println(" task is null");
			}
			List<Transition> transitions=jbpmService.getTransitionsByTaskId(tm.getId());
			
			System.out.println("size:" + transitions.size());
			
//			for(Transition tran:transitions){
//				
//			}
		}
		
	}
	
	//@Test
	public void unDeploy(){
		System.out.println("delete---------------");
		processEngine.getRepositoryService().deleteDeployment("2");
		System.out.println("delete- success--------------");
	}
	
	public void topAssign(){
		//taskService.
		
	}
	
	@Resource
	private TaskDao taskDao;
	
	//@Test
	public void testGetValue(){
		List list=taskDao.getByActivityNameVarKeyLongVal("发文分发", "archives.archivesId",12l );
		
		System.out.println("size:" + list.size());
	}
	
	public void getTaskImpl(){
		String piId="250006";
	}
	
}
