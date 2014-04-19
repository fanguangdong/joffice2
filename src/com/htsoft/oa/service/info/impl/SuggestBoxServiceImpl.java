package com.htsoft.oa.service.info.impl;
/*
 *  广州宏天软件有限公司 JOffice协同办公管理系统   -- http://www.jee-soft.cn
 *  Copyright (C) 2008-2009 GuangZhou HongTian Software Limited company.
*/
import com.htsoft.core.service.impl.BaseServiceImpl;
import com.htsoft.oa.dao.info.SuggestBoxDao;
import com.htsoft.oa.model.info.SuggestBox;
import com.htsoft.oa.service.info.SuggestBoxService;

public class SuggestBoxServiceImpl extends BaseServiceImpl<SuggestBox> implements SuggestBoxService{
	private SuggestBoxDao dao;
	
	public SuggestBoxServiceImpl(SuggestBoxDao dao) {
		super(dao);
		this.dao=dao;
	}

}