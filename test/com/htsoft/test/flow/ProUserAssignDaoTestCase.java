package com.htsoft.test.flow;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.flow.ProUserAssignDao;
import com.htsoft.oa.model.flow.ProUserAssign;

public class ProUserAssignDaoTestCase extends BaseTestCase {
	@Resource
	private ProUserAssignDao proUserAssignDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		ProUserAssign proUserAssign=new ProUserAssign();
//		TODO

		proUserAssignDao.save(proUserAssign);
	}
}