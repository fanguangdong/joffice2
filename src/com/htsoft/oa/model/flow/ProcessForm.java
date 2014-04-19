package com.htsoft.oa.model.flow;
/*
 *  广州宏天软件有限公司 OA办公管理系统   --  http://www.jee-soft.cn
 *  Copyright (C) 2008-2009 GuangZhou HongTian Software Company
*/

import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * ProcessForm Base Java Bean, base class for the.oa.model, mapped directly to database table
 * 
 * Avoid changing this file if not necessary, will be overwritten. 
 *
 * 
 */
public class ProcessForm extends com.htsoft.core.model.BaseModel {
	/**
	 * 驳回状态
	 */
	public static final Short STATUS_BACK=-1;
	/**
	 * 初始状态
	 */
	public static final Short STATUS_INIT=0;
	/**
	 * 通过状态
	 */
	public static final Short STATUS_PASS=1;
	
	
    protected Long formId;
	protected String activityName;
	protected Date createtime;
	
	protected Long creatorId;
	protected String creatorName;
	//2.0 add the fields below for the process history
	protected Date endtime;
	protected long durTimes;
	protected String fromTask;
	protected String fromTaskId;
	protected String taskId;
	protected String transTo;
	protected Short status;
	
	protected String comments;
	
	protected Long preFormId;
	
	protected com.htsoft.oa.model.flow.ProcessRun processRun;

	//protected java.util.Set formDatas = new java.util.HashSet();
	protected java.util.Set formFiles = new java.util.HashSet();

	
	public Date getCreatetime() {
		if(createtime==null){
			createtime=new Date();
		}
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * Default Empty Constructor for class ProcessForm
	 */
	public ProcessForm () {
		super();
	}
	
	/**
	 * Default Key Fields Constructor for class ProcessForm
	 */
	public ProcessForm (
		 Long in_formId
        ) {
		this.setFormId(in_formId);
    }

	
	public com.htsoft.oa.model.flow.ProcessRun getProcessRun () {
		return processRun;
	}	
	
	public void setProcessRun (com.htsoft.oa.model.flow.ProcessRun in_processRun) {
		this.processRun = in_processRun;
	}

//	public java.util.Set getFormDatas () {
//		return formDatas;
//	}	
//	
//	public void setFormDatas (java.util.Set in_formDatas) {
//		this.formDatas = in_formDatas;
//	}

	public java.util.Set getFormFiles () {
		return formFiles;
	}	
	
	public void setFormFiles (java.util.Set in_formFiles) {
		this.formFiles = in_formFiles;
	}
    

	/**
	 * 	 * @return Long
     * @hibernate.id column="formId" type="java.lang.Long" generator-class="native"
	 */
	public Long getFormId() {
		return this.formId;
	}
	
	/**
	 * Set the formId
	 */	
	public void setFormId(Long aValue) {
		this.formId = aValue;
	}	

	/**
	 * 所属运行流程	 * @return Long
	 */
	public Long getRunId() {
		return this.getProcessRun()==null?null:this.getProcessRun().getRunId();
	}
	
	/**
	 * Set the runId
	 */	
	public void setRunId(Long aValue) {
	    if (aValue==null) {
	    	processRun = null;
	    } else if (processRun == null) {
	        processRun = new com.htsoft.oa.model.flow.ProcessRun(aValue);
	        processRun.setVersion(new Integer(0));//set a version to cheat hibernate only
	    } else {
			processRun.setRunId(aValue);
	    }
	}	

	/**
	 * 活动或任务名称	 * @return String
	 * @hibernate.property column="activityName" type="java.lang.String" length="128" not-null="true" unique="false"
	 */
	public String getActivityName() {
		return this.activityName;
	}
	
	/**
	 * Set the activityName
	 * @spring.validator type="required"
	 */	
	public void setActivityName(String aValue) {
		this.activityName = aValue;
	}	

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof ProcessForm)) {
			return false;
		}
		ProcessForm rhs = (ProcessForm) object;
		return new EqualsBuilder()
				.append(this.formId, rhs.formId)
						.append(this.activityName, rhs.activityName)
				.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973)
				.append(this.formId) 
						.append(this.activityName) 
				.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
				.append("formId", this.formId) 
						.append("activityName", this.activityName) 
				.toString();
	}


	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public long getDurTimes() {
		return durTimes;
	}

	public void setDurTimes(long durTimes) {
		this.durTimes = durTimes;
	}

	public String getFromTask() {
		return fromTask;
	}

	public void setFromTask(String fromTask) {
		this.fromTask = fromTask;
	}

	public String getFromTaskId() {
		return fromTaskId;
	}

	public void setFromTaskId(String fromTaskId) {
		this.fromTaskId = fromTaskId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTransTo() {
		return transTo;
	}

	public void setTransTo(String transTo) {
		this.transTo = transTo;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Long getPreFormId() {
		return preFormId;
	}

	public void setPreFormId(Long preFormId) {
		this.preFormId = preFormId;
	}
	
	

}
