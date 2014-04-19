package com.htsoft.test.admin;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.admin.BookBorRetDao;
import com.htsoft.oa.model.admin.BookBorRet;

public class BookBorRetDaoTestCase extends BaseTestCase {
	@Resource
	private BookBorRetDao bookBorRetDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		BookBorRet bookBorRet=new BookBorRet();
//		TODO

		bookBorRetDao.save(bookBorRet);
	}
}