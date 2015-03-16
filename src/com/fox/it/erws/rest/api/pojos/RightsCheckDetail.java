package com.fox.it.erws.rest.api.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name="RGHTS_CHK_DTL")
public class RightsCheckDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3597780010237726480L;

	@Id	
	@Column(name="RGHTS_CHK_DTL_ID")
	private Long rightsCheckDetailId;
	
	@Column(name="FOX_VERSION_ID")
	private Long foxVersionId;
	
	@Column(name="PASS_FAIL_CHK_ID")
	private Long passFailCheckId;
	
	@Column(name="QRY_ID")
	private Long queryId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CRT_DT")
	private Date createDate;
	
	@Column(name="CRT_NM")
	 private String createName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPD_DT")
	private Date updateDate;
	
	@Column(name="UPD_NM")
	private String updateName;

	@Column(name="CMNT")
	private String comment;
	
	@Column(name="CHK_PASS_FLG")
	 private String checkPassFlag;
	
	@Transient
	private Collection<RightsCheckRestrictionDetail> rightsCheckRestrictionDetail;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		 StringBuilder result = new StringBuilder();
		 String NEW_LINE = System.getProperty("line.separator");

		 result.append(this.getClass().getName());
		 result.append(" Object Details {" + NEW_LINE);
		 result.append("     checkPassFlag: " + this.checkPassFlag);
		 result.append(NEW_LINE);
		 result.append("     foxVersionId: " + this.foxVersionId);
		 result.append(NEW_LINE);
		 result.append("     queryId: " + this.queryId);
		 result.append(NEW_LINE);
		 result.append("     passFailCheckId: " + this.passFailCheckId);
		 result.append(NEW_LINE);
		 result.append("  }");
		    
		 return result.toString();
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

	public Long getRightsCheckDetailId() {
		return rightsCheckDetailId;
	}

	public void setRightsCheckDetailId(Long rightsCheckDetailId) {
		this.rightsCheckDetailId = rightsCheckDetailId;
	}

	public Long getPassFailCheckId() {
		return passFailCheckId;
	}

	public void setPassFailCheckId(Long passFailCheckId) {
		this.passFailCheckId = passFailCheckId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCheckPassFlag() {
		return checkPassFlag;
	}

	public void setCheckPassFlag(String checkPassFlag) {
		this.checkPassFlag = checkPassFlag;
	}

	public Collection<RightsCheckRestrictionDetail> getRightsCheckRestrictionDetail() {
		if (rightsCheckRestrictionDetail==null) {
			rightsCheckRestrictionDetail = new ArrayList<>();
		}
		return rightsCheckRestrictionDetail;
	}

	public void setRightsCheckRestrictionDetail(
			Collection<RightsCheckRestrictionDetail> rightsCheckRestrictionDetail) {
		this.rightsCheckRestrictionDetail = rightsCheckRestrictionDetail;
	}

	
	
//	public Collection<RightsCheckRestrictionDetailDTO> getRightsCheckRestrictionDetail() {
//		return this.rightsCheckRestrictionDetail;
//	}
	
//	public void setRightsCheckRestrictionDetail(Collection<RightsCheckRestrictionDetail> rightsCheckRestrictionDetail) {
//		//this.rightsCheckRestrictionDetail = rightsCheckRestrictionDetail;
//		
//		Collection<RightsCheckRestrictionDetailDTO> newCollection = new ArrayList<RightsCheckRestrictionDetailDTO>();
//		
//		Iterator<RightsCheckRestrictionDetail> rCDIter = rightsCheckRestrictionDetail.iterator();
//		while (rCDIter.hasNext()) {
//			RightsCheckRestrictionDetail rCD = rCDIter.next();
//			RightsCheckRestrictionDetailDTO newRCD = new RightsCheckRestrictionDetailDTO();
//			newRCD.setQueryId(rCD.getQueryId());
//			newRCD.setFoxVersionId(rCD.getFoxVersionId());
//			newRCD.setRightsRestrictionCodeCheckDetailId(rCD.getRightsRestrictionCodeCheckDetailId());
//			newRCD.setPassFailCheckId(rCD.getPassFailCheckId());
//			newRCD.setConditionPassFlag(rCD.getConditionPassFlag());
//			newRCD.setRestrictionCodeId(rCD.getRestrictionCodeId());
//			newCollection.add(newRCD);
//		}
//		
//		this.rightsCheckRestrictionDetail = newCollection;
//	}
	
}
