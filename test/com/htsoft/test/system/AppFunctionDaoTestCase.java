package com.htsoft.test.system;


import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.system.AppFunctionDao;
import com.htsoft.oa.model.system.AppFunction;

public class AppFunctionDaoTestCase extends BaseTestCase {
	@Resource
	private AppFunctionDao appFunctionDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		AppFunction appFunction=new AppFunction();
//		TODO
		
		 
		//map.containsKey(key)
		
		appFunctionDao.save(appFunction);
	}
}