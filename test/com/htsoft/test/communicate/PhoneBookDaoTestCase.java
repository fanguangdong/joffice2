package com.htsoft.test.communicate;

import java.util.List;

import javax.annotation.Resource;



import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.google.gson.JsonSerializer;
import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.communicate.PhoneBookDao;
import com.htsoft.oa.model.communicate.PhoneBook;

import flexjson.JSONSerializer;

public class PhoneBookDaoTestCase extends BaseTestCase {
	@Resource
	private PhoneBookDao phoneBookDao;
//	
//	@Test
//	@Rollback(false)
//	public void add(){		
//		PhoneBook phoneBook=new PhoneBook();
////		TODO
//
//		phoneBookDao.save(phoneBook);
//	}
	
	@Test
	public void test(){
		
	       //Gson gson=new Gson();
		List<PhoneBook> phoneBook=phoneBookDao.getAll();

		JSONSerializer serializer=new JSONSerializer();

//	    /System.out.println("josn:" + serializer.exclude(new String[]{"class","phoneGroup","appUser.department"}).prettyPrint(phoneBook));
	
	}
}