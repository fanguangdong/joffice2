package com.htsoft.test.admin;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.admin.CartRepairDao;
import com.htsoft.oa.model.admin.CartRepair;

public class CartRepairDaoTestCase extends BaseTestCase {
	@Resource
	private CartRepairDao cartRepairDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		CartRepair cartRepair=new CartRepair();
//		TODO

		cartRepairDao.save(cartRepair);
	}
}