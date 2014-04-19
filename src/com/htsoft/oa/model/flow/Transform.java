package com.htsoft.oa.model.flow;
/*
 *  广州宏天软件有限公司 OA办公管理系统   --  http://www.jee-soft.cn
 *  Copyright (C) 2008-2009 GuangZhou HongTian Software Company
*/

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbpm.api.model.Activity;
import org.jbpm.api.model.Transition;


/**
 * 
 * @author csx
 *
 */
public class Transform {
	private static final Log logger=LogFactory.getLog(Transform.class);
	/**
	 * 转换器名称 
	 */
	private String name;
	
	/**
	 * 目标名称
	 */
	private String destination;
	
	/**
	 * 源名称
	 */
	private String source;
	/**
	 * 目标节点类型(task,end等）
	 */
	private String destType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	
	public Transform() {
		
	}
	
	public Transform(Transition jbpmtran){
		try{
			this.name=jbpmtran.getName();
			this.source=jbpmtran.getSource().getName();
			Activity destAct=jbpmtran.getDestination();
			this.destination=destAct.getName();
			destType=destAct.getType();
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
	}

	public String getDestType() {
		return destType;
	}

	public void setDestType(String destType) {
		this.destType = destType;
	}
	
	
	
}
