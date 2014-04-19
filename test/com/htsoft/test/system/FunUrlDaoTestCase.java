package com.htsoft.test.system;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.system.FunUrlDao;
import com.htsoft.oa.model.system.FunUrl;

public class FunUrlDaoTestCase extends BaseTestCase {
	@Resource
	private FunUrlDao funUrlDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		FunUrl funUrl=new FunUrl();
//		TODO

		funUrlDao.save(funUrl);
	}
}