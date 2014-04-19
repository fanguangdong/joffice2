package com.htsoft.test.flow;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.flow.ProcessFormDao;
import com.htsoft.oa.model.flow.ProcessForm;

public class ProcessFormDaoTestCase extends BaseTestCase {
	@Resource
	private ProcessFormDao processFormDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		ProcessForm processForm=new ProcessForm();
//		TODO

		processFormDao.save(processForm);
	}
}