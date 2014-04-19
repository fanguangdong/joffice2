package com.htsoft.test.system;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.system.DiaryDao;
import com.htsoft.oa.model.system.Diary;

public class DiaryDaoTestCase extends BaseTestCase {
	@Resource
	private DiaryDao diaryDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		Diary diary=new Diary();
//		TODO

		diaryDao.save(diary);
	}
}