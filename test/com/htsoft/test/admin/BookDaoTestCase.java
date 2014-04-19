package com.htsoft.test.admin;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import com.google.gson.Gson;
import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.admin.BookDao;
import com.htsoft.oa.model.admin.Book;

public class BookDaoTestCase extends BaseTestCase {
	@Resource
	private BookDao bookDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		Book book=new Book();
		//TODO
		//...
		bookDao.save(book);
	}
	@Test
	public void Testt(){
		java.util.List<Book> list=bookDao.getAll();
		Gson gson=new Gson();
		System.out.println(gson.toJson(list));
	}
}