package com.htsoft.oa.model.flow;
/*
 *  广州宏天软件有限公司 JOffice协同办公管理系统   -- http://www.jee-soft.cn
 *  Copyright (C) 2008-2009 GuangZhou HongTian Software Limited company.
*/
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * TaskSignData Base Java Bean, base class for the.oa.model, mapped directly to database table
 * 
 * Avoid changing this file if not necessary, will be overwritten. 
 *
 * TODO: add class/table comments
 */
public class TaskSignData extends com.htsoft.core.model.BaseModel {
	/**
	 * 投票同意
	 */
	public static final Short IS_AGREE=1;
	/**
	 * 投票拒绝
	 */
	public static final Short IS_NOT_AGREE=2;
	
    protected Long dataId;
	protected Long voteId;
	protected String voteName;
	protected java.util.Date voteTime;
	protected String taskId;
	protected Short isAgree;


	/**
	 * Default Empty Constructor for class TaskSignData
	 */
	public TaskSignData () {
		super();
	}
	
	/**
	 * Default Key Fields Constructor for class TaskSignData
	 */
	public TaskSignData (
		 Long in_dataId
        ) {
		this.setDataId(in_dataId);
    }

    

	/**
	 * 	 * @return Long
     * @hibernate.id column="dataId" type="java.lang.Long" generator-class="native"
	 */
	public Long getDataId() {
		return this.dataId;
	}
	
	/**
	 * Set the dataId
	 */	
	public void setDataId(Long aValue) {
		this.dataId = aValue;
	}	

	/**
	 * 投票人	 * @return Long
	 * @hibernate.property column="voteId" type="java.lang.Long" length="19" not-null="true" unique="false"
	 */
	public Long getVoteId() {
		return this.voteId;
	}
	
	/**
	 * Set the voteId
	 * @spring.validator type="required"
	 */	
	public void setVoteId(Long aValue) {
		this.voteId = aValue;
	}	

	/**
	 * 投票人名	 * @return String
	 * @hibernate.property column="voteName" type="java.lang.String" length="64" not-null="false" unique="false"
	 */
	public String getVoteName() {
		return this.voteName;
	}
	
	/**
	 * Set the voteName
	 */	
	public void setVoteName(String aValue) {
		this.voteName = aValue;
	}	

	/**
	 * 投票时间	 * @return java.util.Date
	 * @hibernate.property column="voteTime" type="java.util.Date" length="19" not-null="true" unique="false"
	 */
	public java.util.Date getVoteTime() {
		return this.voteTime;
	}
	
	/**
	 * Set the voteTime
	 * @spring.validator type="required"
	 */	
	public void setVoteTime(java.util.Date aValue) {
		this.voteTime = aValue;
	}	

	/**
	 * 任务Id	 * @return Long
	 * @hibernate.property column="taskId" type="java.lang.String" length="64" not-null="true" unique="false"
	 */
	public String getTaskId() {
		return this.taskId;
	}
	
	/**
	 * Set the taskId
	 * @spring.validator type="required"
	 */	
	public void setTaskId(String aValue) {
		this.taskId = aValue;
	}	

	/**
	 * 是否同意
            1=同意
            0=拒绝	 * @return Short
	 * @hibernate.property column="isAgree" type="java.lang.Short" length="5" not-null="true" unique="false"
	 */
	public Short getIsAgree() {
		return this.isAgree;
	}
	
	/**
	 * Set the isAgree
	 * @spring.validator type="required"
	 */	
	public void setIsAgree(Short aValue) {
		this.isAgree = aValue;
	}	

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof TaskSignData)) {
			return false;
		}
		TaskSignData rhs = (TaskSignData) object;
		return new EqualsBuilder()
				.append(this.dataId, rhs.dataId)
				.append(this.voteId, rhs.voteId)
				.append(this.voteName, rhs.voteName)
				.append(this.voteTime, rhs.voteTime)
				.append(this.taskId, rhs.taskId)
				.append(this.isAgree, rhs.isAgree)
				.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973)
				.append(this.dataId) 
				.append(this.voteId) 
				.append(this.voteName) 
				.append(this.voteTime) 
				.append(this.taskId) 
				.append(this.isAgree) 
				.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
				.append("dataId", this.dataId) 
				.append("voteId", this.voteId) 
				.append("voteName", this.voteName) 
				.append("voteTime", this.voteTime) 
				.append("taskId", this.taskId) 
				.append("isAgree", this.isAgree) 
				.toString();
	}



}
