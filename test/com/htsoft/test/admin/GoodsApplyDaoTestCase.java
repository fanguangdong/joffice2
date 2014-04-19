package com.htsoft.test.admin;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.admin.GoodsApplyDao;
import com.htsoft.oa.model.admin.GoodsApply;

public class GoodsApplyDaoTestCase extends BaseTestCase {
	@Resource
	private GoodsApplyDao goodsApplyDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		GoodsApply goodsApply=new GoodsApply();
//		TODO

		goodsApplyDao.save(goodsApply);
	}
}