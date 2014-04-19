package com.htsoft.oa.dao.info;
/*
 *  广州宏天软件有限公司 OA办公管理系统   --  http://www.jee-soft.cn
 *  Copyright (C) 2008-2009 GuangZhou HongTian Software Company
*/
import java.util.List;

import com.htsoft.core.dao.BaseDao;
import com.htsoft.core.web.paging.PagingBean;
import com.htsoft.oa.model.info.News;

public interface NewsDao extends BaseDao<News>{
	public List<News> findByTypeId(Long typeId,PagingBean pb);

	public List<News> findBySearch(Short isNotice,String searchContent,PagingBean pb);
	/**
	 * 查找图片新闻
	 * @param pb
	 * @return
	 */
	public List<News> findImageNews(Long sectionId,PagingBean pb);
}
