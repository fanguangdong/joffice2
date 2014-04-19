package com.htsoft.test.personal;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.personal.DutySectionDao;
import com.htsoft.oa.model.personal.DutySection;

public class DutySectionDaoTestCase extends BaseTestCase {
	@Resource
	private DutySectionDao dutySectionDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		DutySection dutySection=new DutySection();
//		TODO

		dutySectionDao.save(dutySection);
	}
}