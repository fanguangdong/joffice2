package com.htsoft.oa.model.system;

/*
 *  广州宏天软件有限公司 J.Office协同办公管理系统   -- http://www.jee-soft.cn
 *  Copyright (C) 2008-2010 GuangZhou HongTian Software Limited Company.
 */
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * @description 部门员工信息[DepUsers]
 * @class DepUsers
 * @author 宏天软件
 * @updater YHZ
 * @company www.jee-soft.cn
 * @createtime 2011-1-15AM
 * 
 */
@SuppressWarnings("serial")
public class DepUsers extends com.htsoft.core.model.BaseModel {

	/**
	 * 主部门,isMain=1
	 */
	public static final Short ISMAIN = 1;

	protected Long depUserId;
	protected Short isMain;
	protected Integer sn;
	protected com.htsoft.oa.model.system.Department department;
	protected com.htsoft.oa.model.system.AppUser appUser;

	/**
	 * Default Empty Constructor for class DepUsers
	 */
	public DepUsers() {
		super();
	}

	/**
	 * Default Key Fields Constructor for class DepUsers
	 */
	public DepUsers(Long in_depUserId) {
		this.setDepUserId(in_depUserId);
	}

	public com.htsoft.oa.model.system.Department getDepartment() {
		return department;
	}

	public void setDepartment(
			com.htsoft.oa.model.system.Department in_department) {
		this.department = in_department;
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
	 * @hibernate.id column="depUserId" type="java.lang.Long"
	 *               generator-class="native"
	 */
	public Long getDepUserId() {
		return this.depUserId;
	}

	/**
	 * Set the depUserId
	 */
	public void setDepUserId(Long aValue) {
		this.depUserId = aValue;
	}

	/**
	 * * @return Long
	 */
	public Long getUserid() {
		return this.getAppUser() == null ? null : this.getAppUser().getUserId();
	}

	/**
	 * Set the userid
	 */
	public void setUserid(Long aValue) {
		if (aValue == null) {
			appUser = null;
		} else if (appUser == null) {
			appUser = new com.htsoft.oa.model.system.AppUser(aValue);
			appUser.setVersion(new Integer(0));// set a version to cheat
			// hibernate only
		} else {
			appUser.setUserId(aValue);
		}
	}

	/**
	 * * @return Long
	 */
	public Long getDepid() {
		return this.getDepartment() == null ? null : this.getDepartment()
				.getDepId();
	}

	/**
	 * Set the depid
	 */
	public void setDepid(Long aValue) {
		if (aValue == null) {
			department = null;
		} else if (department == null) {
			department = new com.htsoft.oa.model.system.Department(aValue);
			department.setVersion(new Integer(0));// set a version to cheat
			// hibernate only
		} else {
			department.setDepId(aValue);
		}
	}

	/**
	 * * @return Short
	 * 
	 * @hibernate.property column="isMain" type="java.lang.Short" length="5"
	 *                     not-null="false" unique="false"
	 */
	public Short getIsMain() {
		return this.isMain;
	}

	/**
	 * Set the ismain
	 */
	public void setIsMain(Short aValue) {
		this.isMain = aValue;
	}

	/**
	 * * @return Integer
	 * 
	 * @hibernate.property column="sn" type="java.lang.Integer" length="10"
	 *                     not-null="false" unique="false"
	 */
	public Integer getSn() {
		return this.sn;
	}

	/**
	 * Set the sn
	 */
	public void setSn(Integer aValue) {
		this.sn = aValue;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof DepUsers)) {
			return false;
		}
		DepUsers rhs = (DepUsers) object;
		return new EqualsBuilder().append(this.depUserId, rhs.depUserId)
				.append(this.isMain, rhs.isMain).append(this.sn, rhs.sn)
				.append(this.department, rhs.department).append(this.appUser,
						rhs.appUser).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973)
				.append(this.depUserId).append(this.isMain).append(this.sn)
				.append(this.department).append(this.appUser).toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("depUserId", this.depUserId)
				.append("isMain", this.isMain).append("sn", this.sn).append(
						"department", this.department).append("appUser",
						this.appUser).toString();
	}

}
