package com.htsoft.test.flow;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.flow.ProcessRunDao;
import com.htsoft.oa.model.flow.ProcessRun;

public class ProcessRunDaoTestCase extends BaseTestCase {
	@Resource
	private ProcessRunDao processRunDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		ProcessRun processRun=new ProcessRun();
//		TODO

		processRunDao.save(processRun);
	}
}