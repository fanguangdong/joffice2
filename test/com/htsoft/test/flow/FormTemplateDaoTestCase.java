package com.htsoft.test.flow;
/*
 *  广州宏天软件有限公司 J.Office协同办公管理系统   -- http://www.jee-soft.cn
 *  Copyright (C) 2008-2010 GuangZhou HongTian Software Limited Company.
*/
import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.flow.FormTemplateDao;
import com.htsoft.oa.model.flow.FormTemplate;

public class FormTemplateDaoTestCase extends BaseTestCase {
	@Resource
	private FormTemplateDao formTemplateDao;
	
	@Test
	@Rollback(false)
	public void add(){		
		FormTemplate formTemplate=new FormTemplate();
//		TODO

		formTemplateDao.save(formTemplate);
	}
}