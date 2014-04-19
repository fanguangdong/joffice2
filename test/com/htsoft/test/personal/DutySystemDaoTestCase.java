package com.htsoft.test.personal;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.personal.DutySystemDao;
import com.htsoft.oa.model.personal.DutySystem;

public class DutySystemDaoTestCase extends BaseTestCase {
	@Resource
	private DutySystemDao dutySystemDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		DutySystem dutySystem=new DutySystem();
//		TODO

		dutySystemDao.save(dutySystem);
	}
}