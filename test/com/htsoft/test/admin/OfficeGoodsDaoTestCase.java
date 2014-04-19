package com.htsoft.test.admin;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.admin.OfficeGoodsDao;
import com.htsoft.oa.model.admin.OfficeGoods;

public class OfficeGoodsDaoTestCase extends BaseTestCase {
	@Resource
	private OfficeGoodsDao officeGoodsDao;
	
//	@Test
//	@Rollback(false)
//	public void add(){		
//		OfficeGoods officeGoods=new OfficeGoods();
////		TODO
//
//		officeGoodsDao.save(officeGoods);
//	}
	@Test
	public void test1(){
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssS");
		System.out.print(sdf.format(date));
	}
}