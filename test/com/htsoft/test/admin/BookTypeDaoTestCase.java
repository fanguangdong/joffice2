package com.htsoft.test.admin;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.admin.BookTypeDao;
import com.htsoft.oa.model.admin.BookType;

public class BookTypeDaoTestCase extends BaseTestCase {
	@Resource
	private BookTypeDao bookTypeDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		BookType bookType=new BookType();
//		TODO

		bookTypeDao.save(bookType);
	}
}