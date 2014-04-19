package com.htsoft.test.system;
/*
 *  广州宏天软件有限公司 J.Office协同办公管理系统   -- http://www.jee-soft.cn
 *  Copyright (C) 2008-2010 GuangZhou HongTian Software Limited Company.
*/
import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.system.DepUsersDao;
import com.htsoft.oa.model.system.AppUser;
import com.htsoft.oa.model.system.DepUsers;
import com.htsoft.oa.model.system.Department;

public class DepUsersDaoTestCase extends BaseTestCase {
	@Resource
	private DepUsersDao depUsersDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		for(int i=0;i<5;i++){
		DepUsers depUsers=new DepUsers();
		depUsers.setAppUser(new AppUser(new Long(i)));
		depUsers.setDepartment(new Department(new Long(i)));
		depUsers.setSn(i);
		//depUsers.setIsmain(new Short("0"));
//		TODO

		depUsersDao.save(depUsers);
		}
	}
}