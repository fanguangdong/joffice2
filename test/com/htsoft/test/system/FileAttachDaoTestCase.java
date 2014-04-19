package com.htsoft.test.system;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.system.FileAttachDao;
import com.htsoft.oa.model.system.FileAttach;

public class FileAttachDaoTestCase extends BaseTestCase {
	@Resource
	private FileAttachDao fileAttachDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		FileAttach fileAttach=new FileAttach();
//		TODO

//		fileAttachDao.save(fileAttach);
		fileAttachDao.removeByPath("communicate/mail/200910/2a4367669a1a4ea2b811013ceed199ce.png");
	}
}