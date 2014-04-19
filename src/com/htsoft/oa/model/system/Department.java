package com.htsoft.oa.model.system;

/*
 *  广州宏天软件有限公司 OA办公管理系统   --  http://www.jee-soft.cn
 *  Copyright (C) 2008-2009 GuangZhou HongTian Software Company
 */

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.htsoft.core.model.BaseModel;

/**
 * @description 部门管理
 * @class Department
 * @author 宏天软件
 * @updater YHZ
 * @company www.jee-soft.cn
 * @createtime 2011-1-18AM
 * 
 */
@SuppressWarnings("serial")
public class Department extends BaseModel {

	@Expose
	protected Long depId;
	@Expose
	protected String depName;
	@Expose
	protected String depDesc;
	@Expose
	protected Integer depLevel;
	@Expose
	protected Long parentId;
	@Expose
	protected String path;

	public Department() {

	}

	public Department(Long depId) {
		this.setDepId(depId);
	}

	public Long getDepId() {
		return depId;
	}

	public void setDepId(Long depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getDepDesc() {
		return depDesc;
	}

	public void setDepDesc(String depDesc) {
		this.depDesc = depDesc;
	}

	public Integer getDepLevel() {
		return depLevel;
	}

	public void setDepLevel(Integer depLevel) {
		this.depLevel = depLevel;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973).append(this.depId)
				.append(this.depName).append(this.depDesc)
				.append(this.depLevel).append(this.parentId).append(this.path)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Department))
			return false;
		Department dep = (Department) obj;
		return new EqualsBuilder().append(this.depId, dep.depId).append(
				this.depName, dep.depName).append(this.depDesc, dep.depDesc)
				.append(this.depLevel, dep.depLevel).append(this.parentId,
						dep.parentId).append(this.path, dep.path).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("depId", this.depId).append(
				"depName", this.depName).append("depDesc", this.depDesc)
				.append("depLevel", this.depLevel).append("parentId",
						this.parentId).append("path", this.path).toString();
	}

}
