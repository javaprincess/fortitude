package com.fox.it.erws.rest.api.pojos;

import java.io.Serializable;
import java.util.Collection;


public class RightsCheckRestrictionDetailDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1242459132151174665L;

	private Long rightsRestrictionCodeCheckDetailId;

	private Long foxVersionId;

	private Long queryId;

	private Long passFailCheckId;

	private Long conditionId;
	
	private String conditionPassFlag;
	
	private Long restrictionCodeId;


	public RightsCheckRestrictionDetailDTO(
			Collection<RightsCheckRestrictionDetailDTO> rightsCheckRestrictionDetail) {
		// TODO Auto-generated constructor stub
	}

	public RightsCheckRestrictionDetailDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getFoxVersionId() {
		return foxVersionId;
	}

	public void setFoxVersionId(Long foxVersionId) {
		this.foxVersionId = foxVersionId;
	}

	public Long getQueryId() {
		return queryId;
	}

	public void setQueryId(Long queryId) {
		this.queryId = queryId;
	}

	public Long getPassFailCheckId() {
		return passFailCheckId;
	}

	public void setPassFailCheckId(Long passFailCheckId) {
		this.passFailCheckId = passFailCheckId;
	}

	public Long getConditionId() {
		return conditionId;
	}

	public void setConditionId(Long conditionId) {
		this.conditionId = conditionId;
	}

	public String getConditionPassFlag() {
		return conditionPassFlag;
	}

	public void setConditionPassFlag(String conditionPassFlag) {
		this.conditionPassFlag = conditionPassFlag;
	}

	public Long getRestrictionCodeId() {
		return restrictionCodeId;
	}

	public void setRestrictionCodeId(Long restrictionCodeId) {
		this.restrictionCodeId = restrictionCodeId;
	}

	public Long getRightsRestrictionCodeCheckDetailId() {
		return rightsRestrictionCodeCheckDetailId;
	}

	public void setRightsRestrictionCodeCheckDetailId(
			Long rightsRestrictionCodeCheckDetailId) {
		this.rightsRestrictionCodeCheckDetailId = rightsRestrictionCodeCheckDetailId;
	}
}
