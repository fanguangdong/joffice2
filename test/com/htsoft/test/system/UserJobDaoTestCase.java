package com.htsoft.test.system;
/*
 *  广州宏天软件有限公司 J.Office协同办公管理系统   -- http://www.jee-soft.cn
 *  Copyright (C) 2008-2010 GuangZhou HongTian Software Limited Company.
*/
import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.system.UserJobDao;
import com.htsoft.oa.model.system.UserJob;

public class UserJobDaoTestCase extends BaseTestCase {
	@Resource
	private UserJobDao userJobDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		UserJob userJob=new UserJob();
//		TODO

		userJobDao.save(userJob);
	}
}