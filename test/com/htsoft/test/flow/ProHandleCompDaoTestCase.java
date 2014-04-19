package com.htsoft.test.flow;
/*
 *  广州宏天软件有限公司 J.Office协同办公管理系统   -- http://www.jee-soft.cn
 *  Copyright (C) 2008-2010 GuangZhou HongTian Software Limited Company.
*/
import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.flow.ProHandleCompDao;
import com.htsoft.oa.model.flow.ProHandleComp;

public class ProHandleCompDaoTestCase extends BaseTestCase {
	@Resource
	private ProHandleCompDao proHandleCompDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		ProHandleComp proHandleComp=new ProHandleComp();
//		TODO

		proHandleCompDao.save(proHandleComp);
	}
}