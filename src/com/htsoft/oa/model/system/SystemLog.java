package com.htsoft.oa.model.system;
/*
 *  广州宏天软件有限公司 JOffice协同办公管理系统   -- http://www.jee-soft.cn
 *  Copyright (C) 2008-2009 GuangZhou HongTian Software Limited company.
*/
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * SystemLog Base Java Bean, base class for the.oa.model, mapped directly to database table
 * 
 * Avoid changing this file if not necessary, will be overwritten. 
 *
 * TODO: add class/table comments
 */
public class SystemLog extends com.htsoft.core.model.BaseModel {

    protected Long logId;
	protected String username;
	protected Long userId;
	protected java.util.Date createtime;
	protected String exeOperation;


	/**
	 * Default Empty Constructor for class SystemLog
	 */
	public SystemLog () {
		super();
	}
	
	/**
	 * Default Key Fields Constructor for class SystemLog
	 */
	public SystemLog (
		 Long in_logId
        ) {
		this.setLogId(in_logId);
    }

    

	/**
	 * 	 * @return Long
     * @hibernate.id column="logId" type="java.lang.Long" generator-class="native"
	 */
	public Long getLogId() {
		return this.logId;
	}
	
	/**
	 * Set the logId
	 */	
	public void setLogId(Long aValue) {
		this.logId = aValue;
	}	

	/**
	 * 用户名	 * @return String
	 * @hibernate.property column="username" type="java.lang.String" length="128" not-null="true" unique="false"
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * Set the username
	 * @spring.validator type="required"
	 */	
	public void setUsername(String aValue) {
		this.username = aValue;
	}	

	/**
	 * 用户ID	 * @return Long
	 * @hibernate.property column="userId" type="java.lang.Long" length="19" not-null="true" unique="false"
	 */
	public Long getUserId() {
		return this.userId;
	}
	
	/**
	 * Set the userId
	 * @spring.validator type="required"
	 */	
	public void setUserId(Long aValue) {
		this.userId = aValue;
	}	

	/**
	 * 执行时间	 * @return java.util.Date
	 * @hibernate.property column="createtime" type="java.util.Date" length="19" not-null="true" unique="false"
	 */
	public java.util.Date getCreatetime() {
		return this.createtime;
	}
	
	/**
	 * Set the createtime
	 * @spring.validator type="required"
	 */	
	public void setCreatetime(java.util.Date aValue) {
		this.createtime = aValue;
	}	

	/**
	 * 执行操作	 * @return String
	 * @hibernate.property column="exeOperation" type="java.lang.String" length="512" not-null="true" unique="false"
	 */
	public String getExeOperation() {
		return this.exeOperation;
	}
	
	/**
	 * Set the exeOperation
	 * @spring.validator type="required"
	 */	
	public void setExeOperation(String aValue) {
		this.exeOperation = aValue;
	}	

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof SystemLog)) {
			return false;
		}
		SystemLog rhs = (SystemLog) object;
		return new EqualsBuilder()
				.append(this.logId, rhs.logId)
				.append(this.username, rhs.username)
				.append(this.userId, rhs.userId)
				.append(this.createtime, rhs.createtime)
				.append(this.exeOperation, rhs.exeOperation)
				.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973)
				.append(this.logId) 
				.append(this.username) 
				.append(this.userId) 
				.append(this.createtime) 
				.append(this.exeOperation) 
				.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
				.append("logId", this.logId) 
				.append("username", this.username) 
				.append("userId", this.userId) 
				.append("createtime", this.createtime) 
				.append("exeOperation", this.exeOperation) 
				.toString();
	}



}
