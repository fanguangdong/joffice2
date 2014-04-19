package com.htsoft.test.hrm;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.hrm.StandSalaryItemDao;
import com.htsoft.oa.model.hrm.StandSalaryItem;

public class StandSalaryItemDaoTestCase extends BaseTestCase {
	@Resource
	private StandSalaryItemDao standSalaryItemDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		StandSalaryItem standSalaryItem=new StandSalaryItem();
//		TODO

		standSalaryItemDao.save(standSalaryItem);
	}
}