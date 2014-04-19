package com.htsoft.test.dynamic;

import org.junit.Test;

import com.htsoft.core.service.DynamicService;
import com.htsoft.core.util.BeanUtil;

import com.htsoft.test.BaseTestCase;

public class DynamicBeanTestCase extends BaseTestCase{
	
	@Test
	public void testSessionFactoryBean() throws Exception{
		DynamicService dynamicService=BeanUtil.getDynamicServiceBean("com.htsoft.oa.entity.Order");
		
		Object obj=dynamicService.get(new Long(1l));
		
		System.out.println("order details:" + obj.toString() );
	}
}
