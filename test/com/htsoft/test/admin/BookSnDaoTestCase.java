package com.htsoft.test.admin;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.admin.BookSnDao;
import com.htsoft.oa.model.admin.BookSn;

public class BookSnDaoTestCase extends BaseTestCase {
	@Resource
	private BookSnDao bookSnDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		BookSn bookSn=new BookSn();
//		TODO

		bookSnDao.save(bookSn);
	}
}