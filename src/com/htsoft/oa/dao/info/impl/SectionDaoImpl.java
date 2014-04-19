package com.htsoft.oa.dao.info.impl;
/*
 *  广州宏天软件有限公司 J.Office协同办公管理系统   -- http://www.jee-soft.cn
 *  Copyright (C) 2008-2010 GuangZhou HongTian Software Limited Company.
*/
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.htsoft.core.dao.impl.BaseDaoImpl;
import com.htsoft.oa.dao.info.SectionDao;
import com.htsoft.oa.model.info.Section;

@SuppressWarnings("unchecked")
public class SectionDaoImpl extends BaseDaoImpl<Section> implements SectionDao{

	public SectionDaoImpl() {
		super(Section.class);
	}

	@Override
	public Integer getLastColumn() {
		final String hql = "select max(st.rowNumber) from Section st where st.colNumber = ? ";
		
		Integer maxRow = (Integer)getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery(hql);
				query.setInteger(0,Section.COLUMN_ONE);
				return query.uniqueResult();
			}
		});
		if(maxRow == null){
			maxRow = 1;//为空是返回1
		}
		return maxRow;
	}

}