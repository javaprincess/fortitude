package com.fox.it.erws.rest.api.pojos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="APP_PROD_LIST_MLT_QRY")
public class Answer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4105737567869951864L;

	@Id	
	@Column(name="APP_PROD_LIST_MLT_QRY_ID")
	private Long appProductListQueryId;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CRT_DT")
	private Date createDate;
	
	@JsonIgnore
	@Column(name="CRT_NM")
	 private String createName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	@Column(name="UPD_DT")
	private Date updateDate;
	
	@JsonIgnore
	@Column(name="UPD_NM")
	private String updateName;
	
	@Column(name="RUN_ID")
	 private Long runId;
	
	@Column(name="CNTRCT_ID")
	 private Long contractId;
	
	@Column(name="TTL_LIST_MAP_ID")
	 private Long titleListMapId;
	
	@Column(name="TTL_LCNS_RGHT_ID")
	 private Long titleLicenseRightId;
	
	@Column(name="MLT_GRP_ID")
	private Long mltGroupId;
	
	@Column(name="REQ_FOX_VERSION_ID")
	private Long reqFoxVersionId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FROM_DT")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="PST")	
	private Date fromDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TO_DT")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="PST")
	private Date toDate;
	
	@Column(name="MEDIA_ID")
	 private Long mediaId;
	
	@Column(name="TRRTRY_ID")
	 private Long territoryId;
	
	@Column(name="LNGG_ID")
	private Long languageId;
	
	@Column(name="MOB_FLG")
	private String mobFlag;
	
	@Column(name="OPN_INET_FLG")
	private String openInternetFlag;
	
	@Column(name="CLSD_INET_FLG")
	private String closedInternetFlag;
	
	@Column(name="WTHN_THRU_FLG")
	private String withinThroughoutFlag;
	
	@Column(name="QRY_ID")
	private Long queryId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="STRT_TM")
	 private Date startTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="END_TM")
	private Date endTime;
	
	@Column(name="STS_DESC")
	 private String statusDescription;
	
	@Column(name="PROD_LIST_ID")
	 private Long productListId;
	
	@Column(name="TTL_LIST_ID")
	 private Long titleListId;
	
	@Column(name="WPR_PROD_ID")
	 private Long wprId;

	@Column(name="APP_INTRFC_PROD_ID")
	private String applicationInterfaceProductId;
	
	@Column(name="APP_RGHTS_CHK_REQ_ID")
	private Long appRightsCheckRequestId;

	
//	@OneToOne(optional=false)
//	@JoinColumn(name="QRY_ID", referencedColumnName="QRY_ID", insertable=false, updatable=false)
//	private RightsCheckSummary rightsCheckSummary;
//	
//	
//	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	@JoinColumn(name="APP_RGHTS_CHK_REQ_ID", insertable=false, updatable=false)
//	private ConsumingApplicationPOJO consumingApplication;
	
//	@Transient
	private Collection<RightsCheckDetail> rightsCheckDetail;
	
	@Column(name="MOT_INFO_CODES")
	private String  motRestrictionCodes;
	
	@Column(name="LICENSING_INFO_CODES")
	private String licensingRestrictionCodes;
	
	@Column(name="GENERAL_INFO_CODES")
	private String generalRestrictionCodes;
	
	@Column(name="INFO_CODES")
	private String restrictionCodes;
	
	@Column(name="FOX_VERSION_ID")	
	private Long foxVersionId;
	
	@Column(name="REQ_FOX_ID")
	private Long reqFoxId;
	
	@Column(name="REQ_PRODUCT_ID")
	private Long reqProductId;
	
	@Column(name="REQ_FIN_PROD_ID")	
	private String reqFinProdId;
	
	@Column(name="PASS_FLG")
	private int passFlag;
	
	
	@Column(name="RSN_TXT")
	private String reasonText;
	
	@Temporal(TemporalType.TIMESTAMP)	
	@Column(name="RIGHTS_START_DATE")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="PST")
	private Date startDate;
	
	
	@Column(name="RIGHTS_START_DATE_CODE")
	private String startDateCode;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="RIGHTS_END_DATE")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="PST")	
	private Date endDate;
	

	@Column(name="RIGHTS_END_DATE_CODE")
	private String endDateCode;
	
	public Answer() {}
	
	public Answer(Long appProductListQueryId) {
		setAppProductListQueryId(appProductListQueryId);
	}
	
	public Answer(Long appProductListQueryId,
			Long queryId, 
			Long productListId, 
			Long appRightsCheckRequestId, 
			Date createDate, 
			String createName, 
			String updateName, 
			Date updateDate, 
			Long runId, 
			Long contractId, 
			Long titleListMapId, 
			Long titleLicenseRightId, 
			Long mltGroupId, 
			Long reqFoxVersionId, 
			Long reqFoxId,
			String reqFinProdId,
			Date fromDate, 
			Date toDate, 
			Long mediaId, 
			Long territoryId, 
			Long languageId, 
			String mobFlag,
			String openInternetFlag, 
			String closedInternetFlag, 
			String withinThroughoutFlag, 
			Date startTime, 
			Date endTime, 
			String statusDescription,
			String applicationInterfaceProductId,
			Long titleListId,
			Long reqProductId, 
			int passFlag, 
			String reasonText,
			Long foxVersionId,
			//Long foxId,
			//String finProdId,
			Date startDate, 
			String startDateCode,
			Date endDate,
			String endDateCode,
			String generalRestrictionCodes,
			String licensingRestrictionCodes,
			String motRestrictionCodes,
			String restrictionCodes) {
		setAppProductListQueryId(appProductListQueryId);
		setQueryId(queryId);
		setProductListId(productListId); 
		setApplicationRightsCheckRequestId(appRightsCheckRequestId);
		setCreateDate(createDate);
		setCreateName(createName);
		setUpdateName(updateName); 
		setUpdateDate(updateDate);
		setRunId(runId);
		setContractId(contractId); 
		setTitleListMapId(titleListMapId); 
		setTitleLicenseRightId(titleLicenseRightId); 
		setMltGroupId(mltGroupId);
		setReqFoxVersionId(reqFoxVersionId);
		setFoxVersionId(foxVersionId);
		setReqFinProdId(reqFinProdId);
		setReqFoxId(reqFoxId);
		setFromDate(fromDate); 
		setToDate(toDate);
		setMediaId(mediaId); 
		setTerritoryId(territoryId);
		setLanguageId(languageId);
		setMobFlag(mobFlag);
		setOpenInternetFlag(openInternetFlag); 
		setClosedInternetFlag(closedInternetFlag);
		setWithinThroughoutFlag(withinThroughoutFlag);
		setStartTime(startTime);
		setEndTime(endTime);
		setStatusDescription(statusDescription);
		setApplicationInterfaceProductId(applicationInterfaceProductId); 
		//setFoxId(foxId);
		setTitleListId(titleListId);
		setReqProductId(reqProductId);
		//setFinProdId(finProdId);
		setPassFlag(passFlag);
		setReasonText(reasonText);
		setStartDate(startDate); 
		setStartDateCode(startDateCode);
		setEndDate(endDate);
		setEndDateCode(endDateCode);
		setGeneralRestrictionCodes(generalRestrictionCodes);
		setLicensingRestrictionCodes(licensingRestrictionCodes);
		setMotRestrictionCodes(motRestrictionCodes);
		setRestrictionCodes(restrictionCodes);
	}
	
	
	
//	public void setRightsCheckDetail(Collection<RightsCheckDetail> rightsCheckDetail) {
//		if (rightsCheckDetail==null) return;		
//		Collection<RightsCheckDetailDTO> newCollection = new ArrayList<RightsCheckDetailDTO>();
//
//		Iterator<RightsCheckDetail> rCDIter = rightsCheckDetail.iterator();
//		while (rCDIter.hasNext()) {
//			RightsCheckDetail rCD = rCDIter.next();
//			RightsCheckDetailDTO newRCD = new RightsCheckDetailDTO();
//			newRCD.setComment(rCD.getComment());
//			newRCD.setQueryId(rCD.getQueryId());
//			newRCD.setFoxVersionId(rCD.getFoxVersionId());
//			newRCD.setRightsCheckDetailId(rCD.getRightsCheckDetailId());
//			newRCD.setPassFailCheckId(rCD.getPassFailCheckId());
//			newRCD.setCheckPassFlag(rCD.getCheckPassFlag());
//			newRCD.setRightsCheckRestrictionDetailDTO((rCD.getRightsCheckRestrictionDetail()));
//			
//			newCollection.add(newRCD);
//		}
//		
//		this.rightsCheckDetail = newCollection;
//		
//		
//	}
	
	public void setRightsCheckDetail(Collection<RightsCheckDetail> rightsCheckDetail) {
		this.rightsCheckDetail = rightsCheckDetail;
	}

	public Collection<RightsCheckDetail> getRightsCheckDetail() {
		return this.rightsCheckDetail;
	}
	
	private void setReqFoxId(Long reqFoxId) {
		this.reqFoxId = reqFoxId;
	}
	
	private void setTitleListId(Long titleListId) {
		this.titleListId = titleListId;
	}

	
	public Long getTitleListId() {
		return this.titleListId;
	}
	
	private void setReqFinProdId(String reqFinProdId) {
		this.reqFinProdId = reqFinProdId;
		
	}
	
	public String getReqFinProdId() {
		return this.reqFinProdId;
	}

	public void setMotRestrictionCodes(String motRestrictionCodes) {
		this.motRestrictionCodes = motRestrictionCodes;
		
	}

	public void setLicensingRestrictionCodes(String licensingRestrictionCodes) {
		this.licensingRestrictionCodes = licensingRestrictionCodes;
		
		
	}

	public void setGeneralRestrictionCodes(String generalRestrictionCodes) {
		this.generalRestrictionCodes = generalRestrictionCodes;
		
	}

	public void setEndDateCode(String endDateCode) {
		this.endDateCode = endDateCode;
		
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
		
	}

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="PST")	
	public Date getEndDate() {
		return this.endDate;
	}

	public String getEndDateCode() {
		return this.endDateCode;
	}
	
	private void setStartDateCode(String startDateCode) {
		this.startDateCode = startDateCode;
		
	}

	private void setStartDate(Date startDate) {
		this.startDate = startDate;
		
	}


	public void setReasonText(String reasonText) {
		this.reasonText = reasonText;
	}

	
	public void setPassFlag(int passFlag) {
		this.passFlag = passFlag;
		
	}


	public void setReqProductId(Long reqProductId) {
		this.reqProductId = reqProductId;
		
	}


	public Long getAppProductListQueryId() {
		return appProductListQueryId;
	}

	public void setAppProductListQueryId(Long appProductListQueryId) {
		this.appProductListQueryId = appProductListQueryId;
	}


	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public void setCreateName(String createName) {
		this.createName = createName;
	}


	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	//public String getUpdateName() {
	//	return updateName;
	//}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public Long getRunId() {
		return runId;
	}

	public void setRunId(Long runId) {
		this.runId = runId;
	}

	public Long getContractId() {
		return contractId;
	}

	
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public Long getTitleListMapId() {
		return titleListMapId;
	}

	public void setTitleListMapId(Long titleListMapId) {
		this.titleListMapId = titleListMapId;
	}

	public Long getTitleLicenseRightId() {
		return titleLicenseRightId;
	}

	public void setTitleLicenseRightId(Long titleLicenseRightId) {
		this.titleLicenseRightId = titleLicenseRightId;
	}

	public Long getMltGroupId() {
		return mltGroupId;
	}

	public void setMltGroupId(Long mltGroupId) {
		this.mltGroupId = mltGroupId;
	}

	public Long getFoxVersionId() {
		return foxVersionId;
	}

	public void setFoxVersionId(Long foxVersionId) {
		this.foxVersionId = foxVersionId;
	}

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="PST")
	public Date getFromDate() {
		return fromDate;
	}

	
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="PST")
	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Long getMediaId() {
		return mediaId;
	}

	public void setMediaId(Long mediaId) {
		this.mediaId = mediaId;
	}

	public Long getTerritoryId() {
		return territoryId;
	}

	public void setTerritoryId(Long territoryId) {
		this.territoryId = territoryId;
	}

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public String getMobFlag() {
		return mobFlag;
	}

	public void setMobFlag(String mobFlag) {
		this.mobFlag = mobFlag;
	}

	public String getOpenInternetFlag() {
		return openInternetFlag;
	}

	public void setOpenInternetFlag(String openInternetFlag) {
		this.openInternetFlag = openInternetFlag;
	}

	public String getClosedInternetFlag() {
		return closedInternetFlag;
	}

	public void setClosedInternetFlag(String closedInternetFlag) {
		this.closedInternetFlag = closedInternetFlag;
	}

	public String getWithinThroughoutFlag() {
		return withinThroughoutFlag;
	}

	public void setWithinThroughoutFlag(String withinThroughoutFlag) {
		this.withinThroughoutFlag = withinThroughoutFlag;
	}


	public Long getQueryId() {
	//protected Long getQueryId() {
		return queryId;
	}

	public void setQueryId(Long queryId) {
		this.queryId = queryId;
	}

	//public Date getStartTime() {
	//	return startTime;
	//}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	//public Date getEndTime() {
	//	return endTime;
	//}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		if (statusDescription == null) 
			this.statusDescription = "No status description available";
		else
			this.statusDescription = statusDescription;
	}

	public Long getProductListId() {
		return productListId;
	}

	public void setProductListId(Long productListId) {
		this.productListId = productListId;
	}

	public Long getReqFoxId() {
		return this.reqFoxId;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		 StringBuilder result = new StringBuilder();
		 String NEW_LINE = System.getProperty("line.separator");

		 result.append(this.getClass().getName());
		 result.append(" Object Details {" + NEW_LINE);
		 result.append("     wprId: " + this.wprId);
		 result.append(NEW_LINE);
		 result.append("     foxVersionId: " + this.foxVersionId);
		 result.append(NEW_LINE);
		 result.append("     reqFoxVersionId: " + this.reqFoxVersionId);
		 result.append(NEW_LINE);
		 result.append("     reqFoxId: " + this.reqFoxId);
		 result.append(NEW_LINE);
		 result.append("     reqFinProdId: " + this.reqFinProdId);
		 result.append(NEW_LINE);
		 result.append("     reqProductId: " + this.reqProductId);
		 result.append(NEW_LINE);
		 result.append("     productListId: " + this.productListId);
		 result.append(NEW_LINE);
		 result.append("     statusDescription: " + this.statusDescription);
		 result.append(NEW_LINE);
		 result.append("     queryId: " + this.queryId);
		 result.append(NEW_LINE);
		 result.append("     startTime: " + this.startTime);
		 result.append(NEW_LINE);
		 result.append("     endTime: " + this.endTime);
		 result.append(NEW_LINE);
		 result.append("     closedInternetFlag: " + this.closedInternetFlag);
		 result.append(NEW_LINE);
		 result.append("     mediaId: " + this.mediaId);
		 result.append(NEW_LINE);
		 result.append("     openInternetFlag: " + this.openInternetFlag);
		 result.append(NEW_LINE);
		 result.append("     languageId: " + this.languageId);
		 result.append(NEW_LINE);
		 result.append("     applicationInterfaceProductId: " + this.applicationInterfaceProductId);
		 result.append(NEW_LINE);
		 result.append("     appRightsCheckRequestId: " + this.appRightsCheckRequestId);
		 result.append(NEW_LINE);
		 result.append("  }");
		    
		 return result.toString();
	}
	
	/*public String getRightsCheckSummaryHref() {
		return rightsCheckDetailHref;
	}

	public void setRightsCheckSummaryHref(String rightsCheckDetailHref) {
		this.rightsCheckDetailHref = rightsCheckDetailHref;
	} 

	public String getApplicationInterfaceProductId() {
		return applicationInterfaceProductId;
	}*/

	public void setApplicationInterfaceProductId(
			String applicationInterfaceProductId) {
		this.applicationInterfaceProductId = applicationInterfaceProductId;
	}

	public Long getApplicationRightsCheckRequestId() {
		return appRightsCheckRequestId;
	}

	public void setApplicationRightsCheckRequestId(
			Long appRightsCheckRequestId) {
		this.appRightsCheckRequestId = appRightsCheckRequestId;
	}



	/*public String getRightsCheckDetailHref() {
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

	public Long getAppRightsCheckRequestId() {
		return appRightsCheckRequestId;
	}*/

	public void setAppRightsCheckRequestId(Long appRightsCheckRequestId) {
		this.appRightsCheckRequestId = appRightsCheckRequestId;
	}

	public String getMotRestrictionCodes() {
		return motRestrictionCodes;
	}

	public String getLicensingRestrictionCodes() {
		return licensingRestrictionCodes;
	}

	public String getGeneralRestrictionCodes() {
		return generalRestrictionCodes;
	}

	/*public Long getFoxId() {
		return foxId;
	} */

	public Long getReqProductId() {
		return reqProductId;
	}

	/*public String getFinProdId() {
		return finProdId;
	}*/

	public int getPassFlag() {
		return passFlag;
	}

	public String getReasonText() {
		System.out.println("passFlag: " + this.passFlag);
		System.out.println("rightsCheckDetail: " + this.rightsCheckDetail);
		System.out.println("foxVersionId: " + this.foxVersionId);
		System.out.println("reasonText: " + this.reasonText);
		
		//TODO include which one is the field that was wrong
		if (this.foxVersionId == null) {
			setReasonText("The requested productId: " + this.reqProductId + " was not found.");
		}
		return reasonText;
	}

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="PST")
	public Date getStartDate() {
		return startDate;
	}

	public String getStartDateCode() {
		return startDateCode;
	}

	public String getRestrictionCodes() {
		return restrictionCodes;
	}

	public void setRestrictionCodes(String restrictionCodes) {
		this.restrictionCodes = restrictionCodes;
	}

	public Long getReqFoxVersionId() {
		return this.reqFoxVersionId;
	}

	public void setReqFoxVersionId(Long reqFoxVersionId) {
		this.reqFoxVersionId = reqFoxVersionId;
	}


	
	
}
