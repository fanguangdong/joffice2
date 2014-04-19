package com.htsoft.oa.model.admin;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.htsoft.core.model.BaseModel;
import com.htsoft.oa.model.system.FileAttach;

/**
 * @description ConfAttach
 * @author YHZ
 * @data 2010-10-11
 * 
 */
@SuppressWarnings("serial")
public class ConfAttach extends BaseModel {

	private Conference confId;
	private FileAttach fileId;

	public ConfAttach() {
	}

	public Conference getConfId() {
		return confId;
	}

	public void setConfId(Conference confId) {
		this.confId = confId;
	}

	public FileAttach getFileId() {
		return fileId;
	}

	public void setFileId(FileAttach fileId) {
		this.fileId = fileId;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof ConfAttach)) {
			return false;
		}
		ConfAttach rhs = (ConfAttach) obj;
		return new EqualsBuilder().append(this.confId, rhs.confId).append(
				this.fileId, rhs.fileId).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973).append(this.confId)
				.append(this.fileId).hashCode();
	}

	public String toString() {
		return new ToStringBuilder(this).append("confId", this.confId).append(
				"fileId", this.fileId).toString();
	}
}
