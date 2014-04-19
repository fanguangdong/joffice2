package com.htsoft.test.admin;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.admin.DepreRecordDao;
import com.htsoft.oa.model.admin.DepreRecord;

public class DepreRecordDaoTestCase extends BaseTestCase {
	@Resource
	private DepreRecordDao depreRecordDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		DepreRecord depreRecord=new DepreRecord();
//		TODO

		depreRecordDao.save(depreRecord);
	}
}