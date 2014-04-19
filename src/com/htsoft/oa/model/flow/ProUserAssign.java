package com.htsoft.oa.model.flow;

/*
 *  广州宏天软件有限公司 OA办公管理系统   --  http://www.jee-soft.cn
 *  Copyright (C) 2008-2009 GuangZhou HongTian Software Company
 */

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * @description 流程人员设置管理
 * @class ProUserAssign
 * @author 宏天软件
 * @updater YHZ
 * @company www.jee-soft.cn
 * @data 2010-12-30AM
 * 
 */
@SuppressWarnings("serial")
public class ProUserAssign extends com.htsoft.core.model.BaseModel {
	/**
	 * 会签任务
	 */
	public final static Short IS_SIGNED_TASK=1;
	/**
	 * 非会签任务
	 */
	public final static Short IS_NOT_SIGNED_TASK=1;
	
	protected Long assignId;
	protected String deployId;
	protected String activityName;
	protected String roleId;
	protected String roleName;
	protected String userId;
	protected String username;

	protected Short isSigned;
	protected String jobId;
	protected String jobName;
	protected String reJobId;
	protected String reJobName;

	/**
	 * Default Empty Constructor for class ProUserAssign
	 */
	public ProUserAssign() {
		super();
	}

	/**
	 * Default Key Fields Constructor for class ProUserAssign
	 */
	public ProUserAssign(Long in_assignId) {
		this.setAssignId(in_assignId);
	}

	public Short getIsSigned() {
		return isSigned;
	}

	public void setIsSigned(Short isSigned) {
		this.isSigned = isSigned;
	}

	/**
	 * 授权ID * @return Long
	 * 
	 * @hibernate.id column="assignId" type="java.lang.Long"
	 *               generator-class="native"
	 */
	public Long getAssignId() {
		return this.assignId;
	}

	/**
	 * Set the assignId
	 */
	public void setAssignId(Long aValue) {
		this.assignId = aValue;
	}

	/**
	 * jbpm流程定义的id * @return String
	 * 
	 * @hibernate.property column="deployId" type="java.lang.String"
	 *                     length="128" not-null="true" unique="false"
	 */
	public String getDeployId() {
		return this.deployId;
	}

	/**
	 * Set the deployId
	 * 
	 * @spring.validator type="required"
	 */
	public void setDeployId(String aValue) {
		this.deployId = aValue;
	}

	/**
	 * 流程节点名称 * @return String
	 * 
	 * @hibernate.property column="activityName" type="java.lang.String"
	 *                     length="128" not-null="true" unique="false"
	 */
	public String getActivityName() {
		return this.activityName;
	}

	/**
	 * Set the activityName
	 * 
	 * @spring.validator type="required"
	 */
	public void setActivityName(String aValue) {
		this.activityName = aValue;
	}

	/**
	 * 角色Id * @return String
	 * 
	 * @hibernate.property column="roleId" type="java.lang.String" length="128"
	 *                     not-null="false" unique="false"
	 */
	public String getRoleId() {
		return this.roleId;
	}

	/**
	 * Set the roleId
	 */
	public void setRoleId(String aValue) {
		this.roleId = aValue;
	}

	/**
	 * 用户ID * @return String
	 * 
	 * @hibernate.property column="userId" type="java.lang.String" length="128"
	 *                     not-null="false" unique="false"
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * Set the userId
	 */
	public void setUserId(String aValue) {
		this.userId = aValue;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getReJobId() {
		return reJobId;
	}

	public void setReJobId(String reJobId) {
		this.reJobId = reJobId;
	}

	public String getReJobName() {
		return reJobName;
	}

	public void setReJobName(String reJobName) {
		this.reJobName = reJobName;
	}

	/**
	 * Return the name of the first key column
	 */
	public String getFirstKeyColumnName() {
		return "assignId";
	}

	/**
	 * Return the Id (pk) of the entity, must be Integer
	 */
	public Long getId() {
		return assignId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof ProUserAssign)) {
			return false;
		}
		ProUserAssign rhs = (ProUserAssign) object;
		return new EqualsBuilder().append(this.assignId, rhs.assignId).append(
				this.deployId, rhs.deployId).append(this.activityName,
				rhs.activityName).append(this.roleId, rhs.roleId).append(
				this.userId, rhs.userId).append(this.jobId, rhs.jobId).append(
				this.jobName, rhs.jobName).append(this.reJobId, rhs.reJobId)
				.append(this.reJobName, rhs.reJobName).append(this.isSigned,
						rhs.isSigned).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973).append(this.assignId)
				.append(this.deployId).append(this.activityName).append(
						this.roleId).append(this.userId).append(this.jobId)
				.append(this.jobName).append(this.reJobId).append(
						this.reJobName).append(this.isSigned).toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("assignId", this.assignId)
				.append("deployId", this.deployId).append("activityName",
						this.activityName).append("roleId", this.roleId)
				.append("userId", this.userId).append("jobId", this.jobId)
				.append("jobName", this.jobName)
				.append("reJobId", this.reJobId).append("reJobName",
						this.reJobName).append("isSigned", this.isSigned)
				.toString();
	}

}
