package com.htsoft.oa.service.info;
/*
 *  广州宏天软件有限公司 J.Office协同办公管理系统   -- http://www.jee-soft.cn
 *  Copyright (C) 2008-2010 GuangZhou HongTian Software Limited Company.
*/
import com.htsoft.core.service.BaseService;
import com.htsoft.oa.model.info.Section;

public interface SectionService extends BaseService<Section>{
	public Integer getLastColumn();
}


