package com.htsoft.test.admin;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.admin.CarApplyDao;
import com.htsoft.oa.model.admin.CarApply;

public class CarApplyDaoTestCase extends BaseTestCase {
	@Resource
	private CarApplyDao carApplyDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		CarApply carApply=new CarApply();
//		TODO

		carApplyDao.save(carApply);
	}
}