package com.htsoft.test.hrm;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.hrm.SalaryItemDao;
import com.htsoft.oa.model.hrm.SalaryItem;

public class SalaryItemDaoTestCase extends BaseTestCase {
	@Resource
	private SalaryItemDao salaryItemDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		SalaryItem salaryItem=new SalaryItem();
//		TODO

		salaryItemDao.save(salaryItem);
	}
}