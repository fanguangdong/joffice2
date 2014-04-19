package com.htsoft.test.system;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.system.RegionDao;
import com.htsoft.oa.model.system.Region;

public class RegionDaoTestCase extends BaseTestCase {
	@Resource
	private RegionDao regionDao;
	
	@Test
	@Rollback(false)
	public void add(){		
//		Region region=new Region();
////		TODO
//
//		regionDao.save(region);
		System.out.println(regionDao.getProvince().size());
		System.out.println(regionDao.getCity(20l).size());
	}
}