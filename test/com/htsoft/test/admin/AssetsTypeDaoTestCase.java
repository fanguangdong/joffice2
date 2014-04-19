package com.htsoft.test.admin;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.admin.AssetsTypeDao;
import com.htsoft.oa.model.admin.AssetsType;

public class AssetsTypeDaoTestCase extends BaseTestCase {
	@Resource
	private AssetsTypeDao assetsTypeDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		AssetsType assetsType=new AssetsType();
//		TODO

		assetsTypeDao.save(assetsType);
	}
}