package com.htsoft.oa.model.admin;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.htsoft.core.model.BaseModel;

/**
 * @description 会议状态BoardState
 * @author YHZ
 * @date 2010-9-26 PM
 * 
 */
@SuppressWarnings("serial")
public class BoardState extends BaseModel {

	private Integer stateId;

	private String stateName;

	public BoardState() {
	}

	public BoardState(Integer in_stateId) {
		this.stateId = in_stateId;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973).append(this.stateId)
				.append(this.stateName).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof BoardType)) {
			return false;
		}
		BoardState bs = (BoardState) obj;
		return new EqualsBuilder().append(this.stateId, bs.stateId).append(
				this.stateName, bs.stateName).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("stateId", this.stateId)
				.append("stateName", this.stateName).toString();
	}
}
