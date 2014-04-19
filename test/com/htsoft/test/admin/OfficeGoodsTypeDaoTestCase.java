package com.htsoft.test.admin;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.admin.OfficeGoodsTypeDao;
import com.htsoft.oa.model.admin.OfficeGoodsType;

public class OfficeGoodsTypeDaoTestCase extends BaseTestCase {
	@Resource
	private OfficeGoodsTypeDao officeGoodsTypeDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		OfficeGoodsType officeGoodsType=new OfficeGoodsType();
//		TODO

		officeGoodsTypeDao.save(officeGoodsType);
	}
}