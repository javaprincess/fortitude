package com.fox.it.erws.rest.api.pojos;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RGHTS_RSTRCN_CD_CHK_DTL")
public class RightsCheckRestrictionDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1242459132151174665L;

	@Id	
	@Column(name="RGHTS_RSTRCN_CD_CHK_DTL_ID")
	private Long rightsRestrictionCodeCheckDetailId;
	
	@Column(name="CRT_DT")
	private Date createDate;
	
	@Column(name="CRT_NM")
	 private String createName;
	
	@Column(name="UPD_DT")
	private Date updateDate;
	
	@Column(name="UPD_NM")
	private String updateName;
	
	@Column(name="FOX_VERSION_ID")
	private Long foxVersionId;
	
	@Column(name="QRY_ID")
	private Long queryId;
	
	@Column(name="PASS_FAIL_CHK_ID")
	 private Long passFailCheckId;
	
	@Column(name="COND_ID")
	 private Long conditionId;
	
	@Column(name="COND_PASS_FLG")
	 private String conditionPassFlag;
	
	@Column(name="RSTRCN_CD_ID")
	 private Long restrictionCodeId;

	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
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
