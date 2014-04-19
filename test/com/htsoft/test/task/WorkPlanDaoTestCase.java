package com.htsoft.test.task;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.task.WorkPlanDao;
import com.htsoft.oa.model.task.WorkPlan;

public class WorkPlanDaoTestCase extends BaseTestCase {
	@Resource
	private WorkPlanDao workPlanDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		WorkPlan workPlan=new WorkPlan();
//		TODO

		workPlanDao.save(workPlan);
	}
}