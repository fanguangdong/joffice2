package com.htsoft.test.personal;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.personal.HolidayRecordDao;
import com.htsoft.oa.model.personal.HolidayRecord;

public class HolidayRecordDaoTestCase extends BaseTestCase {
	@Resource
	private HolidayRecordDao holidayRecordDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		HolidayRecord holidayRecord=new HolidayRecord();
//		TODO

		holidayRecordDao.save(holidayRecord);
	}
}