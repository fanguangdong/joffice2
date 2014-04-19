package com.htsoft.test.personal;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.personal.DutyRegisterDao;
import com.htsoft.oa.model.personal.DutyRegister;

public class DutyRegisterDaoTestCase extends BaseTestCase {
	@Resource
	private DutyRegisterDao dutyRegisterDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		DutyRegister dutyRegister=new DutyRegister();
//		TODO

		dutyRegisterDao.save(dutyRegister);
	}
}