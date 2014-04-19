package com.htsoft.test.flow;

import java.util.List;

import javax.annotation.Resource;

import org.jbpm.pvm.internal.task.TaskImpl;
import org.junit.Test;

import com.htsoft.oa.dao.flow.TaskDao;
import com.htsoft.test.BaseTestCase;

public class TaskDaoTestCase extends BaseTestCase{
	@Resource
	private TaskDao taskDao;
	
	@Test
	public void testPersonTask(){
		String userId= "1";
		
//		List<TaskImpl> list=taskDao.getTasksByUserId(userId);
//		
//		for(TaskImpl task:list){
//			System.out.println("task:" + task.getDbid() + " Name:" + task.getActivityName());
//		}
	}
}
