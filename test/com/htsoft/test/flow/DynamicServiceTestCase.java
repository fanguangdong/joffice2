package com.htsoft.test.flow;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;


import com.htsoft.core.dao.impl.DynamicDaoImpl;
import com.htsoft.oa.entity.GeneralEntity;
import com.htsoft.test.BaseTestCase;

public class DynamicServiceTestCase extends BaseTestCase{
	@Resource(name="sessionFactoryEntity")
	SessionFactory sessionFactoryEntity;
	
	@Test
	@Rollback(false)
	public void testDynamicGetObject(){
		
		
	}
	
}
