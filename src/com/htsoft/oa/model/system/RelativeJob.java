package com.htsoft.oa.model.system;
/*
 *  广州宏天软件有限公司 JOffice协同办公管理系统   -- http://www.jee-soft.cn
 *  Copyright (C) 2008-2009 GuangZhou HongTian Software Limited company.
*/
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * @description 相对岗位管理
 * @author 宏天软件
 * @company www.jee-soft.cn
 * @data 2010-12-13PM
 *
 */
@SuppressWarnings("serial")
public class RelativeJob extends com.htsoft.core.model.BaseModel {

    protected Long reJobId;
	protected String jobName;
	protected String jobCode;
	protected Long parent;
	protected String path;
	protected Integer depath;


	/**
	 * Default Empty Constructor for class RelativeJob
	 */
	public RelativeJob () {
		super();
	}
	
	/**
	 * Default Key Fields Constructor for class RelativeJob
	 */
	public RelativeJob (
		 Long in_reJobId
        ) {
		this.setReJobId(in_reJobId);
    }

    

	/**
	 * 	 * @return Long
     * @hibernate.id column="reJobId" type="java.lang.Long" generator-class="native"
	 */
	public Long getReJobId() {
		return this.reJobId;
	}
	
	/**
	 * Set the reJobId
	 */	
	public void setReJobId(Long aValue) {
		this.reJobId = aValue;
	}	

	/**
	 * 	 * @return String
	 * @hibernate.property column="jobName" type="java.lang.String" length="128" not-null="true" unique="false"
	 */
	public String getJobName() {
		return this.jobName;
	}
	
	/**
	 * Set the jobName
	 * @spring.validator type="required"
	 */	
	public void setJobName(String aValue) {
		this.jobName = aValue;
	}	

	/**
	 * 	 * @return String
	 * @hibernate.property column="jobCode" type="java.lang.String" length="256" not-null="false" unique="false"
	 */
	public String getJobCode() {
		return this.jobCode;
	}
	
	/**
	 * Set the jobCode
	 */	
	public void setJobCode(String aValue) {
		this.jobCode = aValue;
	}	

	/**
	 * 	 * @return Long
	 * @hibernate.property column="parent" type="java.lang.Long" length="19" not-null="false" unique="false"
	 */
	public Long getParent() {
		return this.parent;
	}
	
	/**
	 * Set the parent
	 */	
	public void setParent(Long aValue) {
		this.parent = aValue;
	}	

	/**
	 * 	 * @return String
	 * @hibernate.property column="path" type="java.lang.String" length="128" not-null="false" unique="false"
	 */
	public String getPath() {
		return this.path;
	}
	
	/**
	 * Set the path
	 */	
	public void setPath(String aValue) {
		this.path = aValue;
	}	

	/**
	 * 	 * @return Integer
	 * @hibernate.property column="depath" type="java.lang.Integer" length="10" not-null="false" unique="false"
	 */
	public Integer getDepath() {
		return this.depath;
	}
	
	/**
	 * Set the depath
	 */	
	public void setDepath(Integer aValue) {
		this.depath = aValue;
	}	

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof RelativeJob)) {
			return false;
		}
		RelativeJob rhs = (RelativeJob) object;
		return new EqualsBuilder()
				.append(this.reJobId, rhs.reJobId)
				.append(this.jobName, rhs.jobName)
				.append(this.jobCode, rhs.jobCode)
				.append(this.parent, rhs.parent)
				.append(this.path, rhs.path)
				.append(this.depath, rhs.depath)
				.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973)
				.append(this.reJobId) 
				.append(this.jobName) 
				.append(this.jobCode) 
				.append(this.parent) 
				.append(this.path) 
				.append(this.depath) 
				.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
				.append("reJobId", this.reJobId) 
				.append("jobName", this.jobName) 
				.append("jobCode", this.jobCode) 
				.append("parent", this.parent) 
				.append("path", this.path) 
				.append("depath", this.depath) 
				.toString();
	}



}
