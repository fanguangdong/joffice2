package com.htsoft.oa.service.info.impl;
/*
 *  广州宏天软件有限公司 J.Office协同办公管理系统   -- http://www.jee-soft.cn
 *  Copyright (C) 2008-2010 GuangZhou HongTian Software Limited Company.
*/
import com.htsoft.core.service.impl.BaseServiceImpl;
import com.htsoft.oa.dao.info.SectionDao;
import com.htsoft.oa.model.info.Section;
import com.htsoft.oa.service.info.SectionService;

public class SectionServiceImpl extends BaseServiceImpl<Section> implements SectionService{
	@SuppressWarnings("unused")
	private SectionDao dao;
	
	public SectionServiceImpl(SectionDao dao) {
		super(dao);
		this.dao=dao;
	}

	@Override
	public Integer getLastColumn() {
		return dao.getLastColumn();
	}

}