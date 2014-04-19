package com.htsoft.oa.service.info;
/*
 *  广州宏天软件有限公司 JOffice协同办公管理系统   -- http://www.jee-soft.cn
 *  Copyright (C) 2008-2009 GuangZhou HongTian Software Limited company.
*/
import com.htsoft.core.service.BaseService;
import com.htsoft.oa.model.info.AppTips;

public interface AppTipsService extends BaseService<AppTips>{
	/**
	 * 根据名称去查找TIP
	 */
	public AppTips findByName(String name);
}


