package com.htsoft.oa.dao.info.impl;
/*
 *  广州宏天软件有限公司 JOffice协同办公管理系统   -- http://www.jee-soft.cn
 *  Copyright (C) 2008-2009 GuangZhou HongTian Software Limited company.
*/
import java.util.List;

import com.htsoft.core.dao.impl.BaseDaoImpl;
import com.htsoft.oa.dao.info.AppTipsDao;
import com.htsoft.oa.model.info.AppTips;

public class AppTipsDaoImpl extends BaseDaoImpl<AppTips> implements AppTipsDao{

	public AppTipsDaoImpl() {
		super(AppTips.class);
	}

	@Override
	public List<AppTips> findByName(String name) {
		String hql="from AppTips vo where vo.tipsName=?";
		return findByHql(hql,new Object[]{name});
	}

}