package com.fox.it.erws.rest.api.pojos;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="RGHTS_CHK_SMRY")
public class RightsCheckSummary implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3868512792241940211L;

	@Id	
	@Column(name="RGHTS_CHK_SMRY_ID")
	private Long righsCheckSummaryId;
	
	@Column(name="CRT_DT")
	private Date createDate;
	
	@Column(name="CRT_NM")
	 private String createName;
	
	@Column(name="UPD_DT")
	private Date updateDate;
	
	@Column(name="UPD_NM")
	private String updateName;
	
	@Column(name="STRT_DT")
	private Date startDate;
	
	@Column(name="END_DT")
	private Date endDate;
	
	@Column(name="STRT_DT_CD")
	 private String startDateCode;
	
	@Column(name="END_DT_CD")
	 private String endDateCode;
	
	@Column(name="PASS_FLG")
	 private int passFlag;
	
	@Column(name="RSN_TXT")
	 private String reasonText;
	
	@Column(name="GNRL_RSTRCN_CDS")
	 private String generalRestrictionCodes;

	@Column(name="LCNSNG_RSTRCN_CDS") 
	private String licensingRestrictionCodes;
	
	@Column(name="MOT_RSTRCN_CDS") 
	private String motRestrictionCodes;
	
	@Column(name="FOX_VERSION_ID")
	private Long foxVersionId;
	
	@Column(name="QRY_ID")
	private Long queryId;
	
	
	@Column(name="RSTRCN_CDS")
	 private String restrictionCodes;
	

	
	@Column(name="DPTH_LVL")
	 private int depthLevel;
	
	@Column(name="TAG")
	 private int tag;
	
	@Transient 
	private String rightsCheckDetailHref;
	
	@Transient 
	private String rightsCheckRestrictionDetailHref;
	
	@OneToOne(optional=false)
	@JoinColumn(name="QRY_ID", insertable=false, updatable=false)
	private Answer answer;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		 StringBuilder result = new StringBuilder();
		 String NEW_LINE = System.getProperty("line.separator");

		 result.append(this.getClass().getName());
		 result.append(" Object Details {" + NEW_LINE);
		 result.append("     foxVersionId: " + this.foxVersionId);
		 result.append(NEW_LINE);
		 result.append("     generalRestrictionCodes: " + this.generalRestrictionCodes);
		 result.append(NEW_LINE);
		 result.append("     licensingRestrictionCodes: " + this.licensingRestrictionCodes);
		 result.append(NEW_LINE);
		 result.append("     queryId: " + this.queryId);
		 result.append(NEW_LINE);
		 result.append("     motRestrictionCodes: " + this.motRestrictionCodes);
		 result.append(NEW_LINE);
		 result.append("     passFlag: " + this.passFlag);
		 result.append(NEW_LINE);
		 result.append("     depthLevel: " + this.depthLevel);
		 result.append(NEW_LINE);
		 result.append("     tag: " + this.tag);
		 result.append(NEW_LINE);
		 result.append("  }");
		    
		 return result.toString();
	}

	public Long getRighsCheckSummaryId() {
		return this.righsCheckSummaryId;
	}

	public void setRighsCheckSummaryId(Long righsCheckSummaryId) {
		this.righsCheckSummaryId = righsCheckSummaryId;
	}

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStartDateCode() {
		return startDateCode;
	}

	public void setStartDateCode(String startDateCode) {
		this.startDateCode = startDateCode;
	}

	public String getEndDateCode() {
		return endDateCode;
	}

	public void setEndDateCode(String endDateCode) {
		this.endDateCode = endDateCode;
	}

	public int getPassFlag() {
		return passFlag;
	}

	public void setPassFlag(int passFlag) {
		this.passFlag = passFlag;
	}

	public String getReasonText() {
		return reasonText;
	}

	public void setReasonText(String reasonText) {
		this.reasonText = reasonText;
	}

	public String getGeneralRestrictionCodes() {
		return generalRestrictionCodes;
	}

	public void setGeneralRestrictionCodes(String generalRestrictionCodes) {
		if (generalRestrictionCodes == null) 
			this.generalRestrictionCodes = "N/A";
		else
			this.generalRestrictionCodes = generalRestrictionCodes;
	}

	public String getLicensingRestrictionCodes() {
		
		return licensingRestrictionCodes;
	}

	public void setLicensingRestrictionCodes(String licensinglRestrictionCodes) {
		if (licensingRestrictionCodes == null)
			this.licensingRestrictionCodes = "N/A";
		else
			this.licensingRestrictionCodes = licensinglRestrictionCodes;
	}

	public String getMotRestrictionCodes() {
		return motRestrictionCodes;
	}

	public void setMotRestrictionCodes(String motRestrictionCodes) {
		if (motRestrictionCodes == null)
			this.motRestrictionCodes = "N/A";
		else
			this.motRestrictionCodes = motRestrictionCodes;
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


	public String getRestrictionCodes() {
		return restrictionCodes;
	}

	public void setRestrictionCodes(String restrictionCodes) {
		this.restrictionCodes = restrictionCodes;
	}

	public int getDepthLevel() {
		return depthLevel;
	}

	public void setDepthLevel(int depthLevel) {
		this.depthLevel = depthLevel;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public String getRightsCheckDetailHref() {
		return rightsCheckDetailHref;
	}

	public void setRightsCheckDetailHref(String rightsCheckDetailHref) {
		this.rightsCheckDetailHref = rightsCheckDetailHref;
	}

	public String getRightsCheckRestrictionDetailHref() {
		return rightsCheckRestrictionDetailHref;
	}

	public void setRightsCheckRestrictionDetailHref(
			String rightsCheckRestrictionDetailHref) {
		this.rightsCheckRestrictionDetailHref = rightsCheckRestrictionDetailHref;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	
}
