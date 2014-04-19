package com.htsoft.test.customer;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.customer.CustomerDao;
import com.htsoft.oa.model.customer.Customer;

public class CustomerDaoTestCase extends BaseTestCase {
	@Resource
	private CustomerDao customerDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		Customer customer=new Customer();
		customer.setCustomerName("Customer1");
		customerDao.save(customer);
	}
}