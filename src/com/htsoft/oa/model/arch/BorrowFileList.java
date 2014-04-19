package com.htsoft.oa.model.arch;
/*
 *  广州宏天软件有限公司 JOffice协同办公管理系统   -- http://www.jee-soft.cn
 *  Copyright (C) 2008-2009 GuangZhou HongTian Software Limited company.
*/
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

import com.google.gson.annotations.Expose;

/**
 * BorrowFileList Base Java Bean, base class for the.oa.model, mapped directly to database table
 * 
 * Avoid changing this file if not necessary, will be overwritten. 
 *
 * TODO: add class/table comments
 */
public class BorrowFileList extends com.htsoft.core.model.BaseModel {
	@Expose
    protected Long listId;
	@Expose
    protected String listType;
	@Expose
    protected String afNo;
	@Expose
    protected String afName;
	@Expose
    protected String rollNo;
	@Expose
    protected String rolllName;
	@Expose
    protected String fileNo;
	@Expose
    protected String fileName;
	@Expose
    protected com.htsoft.oa.model.arch.RollFile rollFile;
	@Expose
    protected com.htsoft.oa.model.arch.ArchRoll archRoll;
	@Expose
    protected com.htsoft.oa.model.arch.ArchFond archFond;
	@Expose
    protected com.htsoft.oa.model.arch.BorrowRecord borrowRecord;


	/**
	 * Default Empty Constructor for class BorrowFileList
	 */
	public BorrowFileList () {
		super();
	}
	
	/**
	 * Default Key Fields Constructor for class BorrowFileList
	 */
	public BorrowFileList (
		 Long in_listId
        ) {
		this.setListId(in_listId);
    }

	
	public com.htsoft.oa.model.arch.RollFile getRollFile () {
		return rollFile;
	}	
	
	public void setRollFile (com.htsoft.oa.model.arch.RollFile in_rollFile) {
		this.rollFile = in_rollFile;
	}
	
	public com.htsoft.oa.model.arch.ArchRoll getArchRoll () {
		return archRoll;
	}	
	
	public void setArchRoll (com.htsoft.oa.model.arch.ArchRoll in_archRoll) {
		this.archRoll = in_archRoll;
	}
	
	public com.htsoft.oa.model.arch.ArchFond getArchFond () {
		return archFond;
	}	
	
	public void setArchFond (com.htsoft.oa.model.arch.ArchFond in_archFond) {
		this.archFond = in_archFond;
	}
	
	public com.htsoft.oa.model.arch.BorrowRecord getBorrowRecord () {
		return borrowRecord;
	}	
	
	public void setBorrowRecord (com.htsoft.oa.model.arch.BorrowRecord in_borrowRecord) {
		this.borrowRecord = in_borrowRecord;
	}
    

	/**
	 * 	 * @return Long
     * @hibernate.id column="listId" type="java.lang.Long" generator-class="native"
	 */
	public Long getListId() {
		return this.listId;
	}
	
	/**
	 * Set the listId
	 */	
	public void setListId(Long aValue) {
		this.listId = aValue;
	}	

	/**
	 * 	 * @return Long
	 */
	public Long getRecordId() {
		return this.getBorrowRecord()==null?null:this.getBorrowRecord().getRecordId();
	}
	
	/**
	 * Set the recordId
	 */	
	public void setRecordId(Long aValue) {
	    if (aValue==null) {
	    	borrowRecord = null;
	    } else if (borrowRecord == null) {
	        borrowRecord = new com.htsoft.oa.model.arch.BorrowRecord(aValue);
	        borrowRecord.setVersion(new Integer(0));//set a version to cheat hibernate only
	    } else {
			borrowRecord.setRecordId(aValue);
	    }
	}	

	/**
	 * 0:全宗
            1:案卷
            2:文件	 * @return Short
	 * @hibernate.property column="listType" type="java.lang.Short" length="5" not-null="false" unique="false"
	 */
	public String getListType() {
		return this.listType;
	}
	
	/**
	 * Set the listType
	 */	
	public void setListType(String aValue) {
		this.listType = aValue;
	}	

	/**
	 * 	 * @return Long
	 */
	public Long getArchFondId() {
		return this.getArchFond()==null?null:this.getArchFond().getArchFondId();
	}
	
	/**
	 * Set the archFondId
	 */	
	public void setArchFondId(Long aValue) {
	    if (aValue==null) {
	    	archFond = null;
	    } else if (archFond == null) {
	        archFond = new com.htsoft.oa.model.arch.ArchFond(aValue);
	        archFond.setVersion(new Integer(0));//set a version to cheat hibernate only
	    } else {
			archFond.setArchFondId(aValue);
	    }
	}	

	/**
	 * 全宗号	 * @return String
	 * @hibernate.property column="afNo" type="java.lang.String" length="64" not-null="false" unique="false"
	 */
	public String getAfNo() {
		return this.afNo;
	}
	
	/**
	 * Set the afNo
	 */	
	public void setAfNo(String aValue) {
		this.afNo = aValue;
	}	

	/**
	 * 全宗名	 * @return String
	 * @hibernate.property column="afName" type="java.lang.String" length="128" not-null="false" unique="false"
	 */
	public String getAfName() {
		return this.afName;
	}
	
	/**
	 * Set the afName
	 */	
	public void setAfName(String aValue) {
		this.afName = aValue;
	}	

	/**
	 * 	 * @return Long
	 */
	public Long getRollId() {
		return this.getArchRoll()==null?null:this.getArchRoll().getRollId();
	}
	
	/**
	 * Set the rollId
	 */	
	public void setRollId(Long aValue) {
	    if (aValue==null) {
	    	archRoll = null;
	    } else if (archRoll == null) {
	        archRoll = new com.htsoft.oa.model.arch.ArchRoll(aValue);
	        archRoll.setVersion(new Integer(0));//set a version to cheat hibernate only
	    } else {
			archRoll.setRollId(aValue);
	    }
	}	

	/**
	 * 	 * @return String
	 * @hibernate.property column="rollNo" type="java.lang.String" length="64" not-null="false" unique="false"
	 */
	public String getRollNo() {
		return this.rollNo;
	}
	
	/**
	 * Set the rollNo
	 */	
	public void setRollNo(String aValue) {
		this.rollNo = aValue;
	}	

	/**
	 * 	 * @return String
	 * @hibernate.property column="rolllName" type="java.lang.String" length="128" not-null="false" unique="false"
	 */
	public String getRolllName() {
		return this.rolllName;
	}
	
	/**
	 * Set the rolllName
	 */	
	public void setRolllName(String aValue) {
		this.rolllName = aValue;
	}	

	/**
	 * 	 * @return Long
	 */
	public Long getRollFileId() {
		return this.getRollFile()==null?null:this.getRollFile().getRollFileId();
	}
	
	/**
	 * Set the rollFileId
	 */	
	public void setRollFileId(Long aValue) {
	    if (aValue==null) {
	    	rollFile = null;
	    } else if (rollFile == null) {
	        rollFile = new com.htsoft.oa.model.arch.RollFile(aValue);
	        rollFile.setVersion(new Integer(0));//set a version to cheat hibernate only
	    } else {
			rollFile.setRollFileId(aValue);
	    }
	}	

	/**
	 * 文件编号	 * @return String
	 * @hibernate.property column="fileNo" type="java.lang.String" length="64" not-null="false" unique="false"
	 */
	public String getFileNo() {
		return this.fileNo;
	}
	
	/**
	 * Set the fileNo
	 */	
	public void setFileNo(String aValue) {
		this.fileNo = aValue;
	}	

	/**
	 * 文件题名	 * @return String
	 * @hibernate.property column="fileName" type="java.lang.String" length="128" not-null="false" unique="false"
	 */
	public String getFileName() {
		return this.fileName;
	}
	
	/**
	 * Set the fileName
	 */	
	public void setFileName(String aValue) {
		this.fileName = aValue;
	}	

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof BorrowFileList)) {
			return false;
		}
		BorrowFileList rhs = (BorrowFileList) object;
		return new EqualsBuilder()
				.append(this.listId, rhs.listId)
						.append(this.listType, rhs.listType)
						.append(this.afNo, rhs.afNo)
				.append(this.afName, rhs.afName)
						.append(this.rollNo, rhs.rollNo)
				.append(this.rolllName, rhs.rolllName)
						.append(this.fileNo, rhs.fileNo)
				.append(this.fileName, rhs.fileName)
				.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973)
				.append(this.listId) 
						.append(this.listType) 
						.append(this.afNo) 
				.append(this.afName) 
						.append(this.rollNo) 
				.append(this.rolllName) 
						.append(this.fileNo) 
				.append(this.fileName) 
				.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
				.append("listId", this.listId) 
						.append("listType", this.listType) 
						.append("afNo", this.afNo) 
				.append("afName", this.afName) 
						.append("rollNo", this.rollNo) 
				.append("rolllName", this.rolllName) 
						.append("fileNo", this.fileNo) 
				.append("fileName", this.fileName) 
				.toString();
	}



}
