package com.htsoft.test.system;
/*
 *  广州宏天软件有限公司 JOffice协同办公管理系统   -- http://www.jee-soft.cn
 *  Copyright (C) 2008-2009 GuangZhou HongTian Software Limited company.
*/
import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.system.SystemLogDao;
import com.htsoft.oa.model.system.SystemLog;

public class SystemLogDaoTestCase extends BaseTestCase {
	@Resource
	private SystemLogDao systemLogDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		SystemLog systemLog=new SystemLog();
//		TODO

		systemLogDao.save(systemLog);
	}
}