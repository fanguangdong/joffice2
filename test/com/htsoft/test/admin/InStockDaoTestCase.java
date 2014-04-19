package com.htsoft.test.admin;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.admin.InStockDao;
import com.htsoft.oa.model.admin.InStock;

public class InStockDaoTestCase extends BaseTestCase {
	@Resource
	private InStockDao inStockDao;
	
	
	@Test
	public void test1(){
		Integer inCount=inStockDao.findInCountByBuyId(1l);
		System.out.println(inCount);
	}
//	@Rollback(false)
//	public void add(){		
//		InStock inStock=new InStock();
////		TODO
//
//		inStockDao.save(inStock);
//	}
}