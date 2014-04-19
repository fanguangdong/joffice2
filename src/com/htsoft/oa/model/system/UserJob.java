package com.htsoft.oa.model.system;

/*
 *  广州宏天软件有限公司 JOffice协同办公管理系统   -- http://www.jee-soft.cn
 *  Copyright (C) 2008-2009 GuangZhou HongTian Software Limited company.
 */
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

import com.google.gson.annotations.Expose;

/**
 * @description 员工职位管理
 * @class UserJob
 * @author 宏天软件
 * @company www.jee-soft.cn
 * @updater YHZ
 * @data 2011-1-11PM
 * 
 */
@SuppressWarnings("serial")
public class UserJob extends com.htsoft.core.model.BaseModel {

	/**
	 * 主职位,isMain=1
	 */
	public static final Short ISMIAN = 1;

	@Expose
	protected Long userJobId;
	@Expose
	protected Short isMain;
	@Expose
	protected com.htsoft.oa.model.hrm.Job job;
	@Expose
	protected com.htsoft.oa.model.system.AppUser appUser;

	/**
	 * Default Empty Constructor for class UserJob
	 */
	public UserJob() {
		super();
	}

	/**
	 * Default Key Fields Constructor for class UserJob
	 */
	public UserJob(Long in_userJobId) {
		this.setUserJobId(in_userJobId);
	}

	public com.htsoft.oa.model.hrm.Job getJob() {
		return job;
	}

	public void setJob(com.htsoft.oa.model.hrm.Job in_job) {
		this.job = in_job;
	}

	public com.htsoft.oa.model.system.AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(com.htsoft.oa.model.system.AppUser in_appUser) {
		this.appUser = in_appUser;
	}

	/**
	 * * @return Long
	 * 
	 * @hibernate.id column="userJobId" type="java.lang.Long"
	 *               generator-class="native"
	 */
	public Long getUserJobId() {
		return this.userJobId;
	}

	/**
	 * Set the userJobId
	 */
	public void setUserJobId(Long aValue) {
		this.userJobId = aValue;
	}

	/**
	 * 是否主职位 * @return Short
	 * 
	 * @hibernate.property column="isMain" type="java.lang.Short" length="10"
	 *                     not-null="false" unique="false"
	 */
	public Short getIsMain() {
		return this.isMain;
	}

	/**
	 * Set the isMain
	 */
	public void setIsMain(Short aValue) {
		this.isMain = aValue;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof UserJob)) {
			return false;
		}
		UserJob rhs = (UserJob) object;
		return new EqualsBuilder().append(this.userJobId, rhs.userJobId)
				.append(this.isMain, rhs.isMain).append(this.job, rhs.job)
				.append(this.appUser, rhs.appUser).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973)
				.append(this.userJobId).append(this.isMain).append(this.job)
				.append(this.appUser).toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("userJobId", this.userJobId)
				.append("isMain", this.isMain).append("job", this.job).append(
						"appUser", this.appUser).toString();
	}

}
