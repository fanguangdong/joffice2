package com.htsoft.test.communicate;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.communicate.PhoneGroupDao;
import com.htsoft.oa.model.communicate.PhoneGroup;

public class PhoneGroupDaoTestCase extends BaseTestCase {
	@Resource
	private PhoneGroupDao phoneGroupDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		PhoneGroup phoneGroup=new PhoneGroup();
//		TODO

		phoneGroupDao.save(phoneGroup);
	}
}