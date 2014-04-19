package com.htsoft.test.customer;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.customer.CusLinkmanDao;
import com.htsoft.oa.model.customer.CusLinkman;

public class CusLinkmanDaoTestCase extends BaseTestCase {
	@Resource
	private CusLinkmanDao cusLinkmanDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		CusLinkman cusLinkman=new CusLinkman();
//		TODO

		cusLinkmanDao.save(cusLinkman);
	}
}