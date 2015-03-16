package com.fox.it.erws.rest.api.pojos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;



@Entity
@Table(name="APP_RGHTS_CHK_REQ")
@NamedNativeQuery(name = "findMeByTitleListId", query = "SELECT * "
	    + "FROM APP_RGHTS_CHK_REQ m "
	    + "WHERE ((m.TITLE_LIST_ID = ?)", resultClass = ConsumingApplicationPOJO.class)
public class ConsumingApplicationPOJO implements Serializable {
	//COLUMNS -- BEGIN
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//TODO: performance test for the sweet spot of the allocation size
	//TODO: try using a trigger here and use a combination of fields for the id
	@Id
	@SequenceGenerator(name="appSeq", sequenceName="APP_RGHTS_CHK_REQ_SEQ", allocationSize=1000)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="appSeq")	
	@Column(name="APP_RGHTS_CHK_REQ_ID")
	private Long id;
	
	@Column(name="ERM_RESPONSE_ID")
	private Long responseId;
	
	@Column(name="APP_REQ_ID")
	private Long requestId;
	
	@Column(name="CONTRACT_ID")
	private Long contractId;
	
	@Column(name="TITLE_LIST_ID")
	private Long titleListId;
	
	@Column(name="TITLE_LIST_MAP_ID")
	private Long titleListMapId;
	
	@Column(name="PRODUCT_ID")
	private Long reqProductId;
	
	@Column(name="FOX_VERSION_ID")
	private Long reqFoxVersionId;
	
	@Column(name="FOX_ID")
	private Long reqFoxId;
	
	@Column(name="FIN_PROD_ID")
	private String reqFinProdId;
	
	@Column(name="TITLE_LICENSE_RIGHT_ID")
	private Long titleLicenseRightId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FROM_DATE")
	private Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TO_DATE")
	private Date endDate;
	
	@Column(name="MLT_GROUP_ID")
	private Long mltGroupId;
	
	@Column(name="MEDIA_ID")
	private Long mediaId;
	
	@Column(name="TERRITORY_ID")
	private Long territoryId;
	
	@Column(name="LANGUAGE_ID")
	private Long languageId;
	
	@Column(name="MOBILE_CELLULAR_WIRELESS")
	private String mobileCellWirelessIndicator;
	
	@Column(name="INTERNET_OPEN")
	private String internetOpenIndicator;
	
	@Column(name="INTERNET_CLOSED")
	private String internetClosedIndicator;

	@Column(name="APP_NM")
	private String consumingApplicationName;
	//AMV 3/15/2015
//	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	@JoinColumn(name="APP_RGHTS_CHK_REQ_ID",insertable=false, updatable=false)
//	private Answer answer;
	
	@Transient
	private Long runId;

	//COLUMNS -- END
	
	
	
	
	public Long getResponseId() {
		return responseId;
	}
	public void setResponseId(Long responseId) {
		this.responseId = responseId;
	}
	
	public Long getContractId() {
		return contractId;
	}
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}
	public Long getTitleListId() {
		return titleListId;
	}
	public void setTitleListId(Long titleListId) {
		this.titleListId = titleListId;
	}
	
	public Long getTitleListMapId() {
		return titleListMapId;
	}
	public void setTitleListMapId(Long titleListMapId) {
		this.titleListMapId = titleListMapId;
	}
	public Long getReqProductId() {
		return reqProductId;
	}
	public void setReqProductId(Long reqProductId) {
		this.reqProductId = reqProductId;
	}
	public Long getReqFoxVersionId() {
		return reqFoxVersionId;
	}
	public void setReqFoxVersionId(Long reqFoxVersionId) {
		this.reqFoxVersionId = reqFoxVersionId;
	}
	public Long getTitleLicenseRightId() {
		return titleLicenseRightId;
	}
	public void setTitleLicenseRightId(Long titleLicenseRightId) {
		this.titleLicenseRightId = titleLicenseRightId;
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
	public Long getMltGroupId() {
		return mltGroupId;
	}
	public void setMltGroupId(Long mltGroupId) {
		this.mltGroupId = mltGroupId;
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
	public String getMobileCellWirelessIndicator() {
		return mobileCellWirelessIndicator;
	}
	public void setMobileCellWirelessIndicator(String mobileCellWirelessIndicator) {
		this.mobileCellWirelessIndicator = mobileCellWirelessIndicator;
	}
	public String getInternetOpenIndicator() {
		return internetOpenIndicator;
	}
	public void setInternetOpenIndicator(String internetOpenIndicator) {
		this.internetOpenIndicator = internetOpenIndicator;
	}
	public String getInternetClosedIndicator() {
		return internetClosedIndicator;
	}
	public void setInternetClosedIndicator(String internetClosedIndicator) {
		this.internetClosedIndicator = internetClosedIndicator;
	} 
	public String getConsumingApplicationName() {
		return consumingApplicationName;
	}
	public void setConsumingApplicationName(String consumingApplicationName) {
		this.consumingApplicationName = consumingApplicationName;
	}
	public Long getRunId() {
		return runId;
	}
	public void setRunId(Long runId) {
		this.runId = runId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

	
	@Override
	public String toString() {
		 StringBuilder result = new StringBuilder();
		 String NEW_LINE = System.getProperty("line.separator");

		 result.append(this.getClass().getName());
		 result.append("  {" + NEW_LINE);
		 result.append("     consumingApplicationName: " + this.consumingApplicationName);
		 result.append(NEW_LINE);
		 result.append("     mediaId: " + this.mediaId);
		 result.append(NEW_LINE);
		 result.append("     territoryId: " + this.territoryId);
		 result.append(NEW_LINE);
		 result.append("     languageId: " + this.languageId);
		 result.append(NEW_LINE);
		 result.append("     mltGroupId: " + this.mltGroupId);
		 result.append(NEW_LINE);
		 result.append("     titleListMapId: " + this.titleListMapId);
		 result.append(NEW_LINE);
		 result.append("     titleLicenseRightId: " + this.titleLicenseRightId);
		 result.append(NEW_LINE);
		 result.append("     contractId: " + this.contractId);
		 result.append(NEW_LINE);
		 result.append("     reqFoxVersionId: " + this.reqFoxVersionId);
		 result.append(NEW_LINE);
		 result.append("     reqFoxId: " + this.reqFoxId);
		 result.append(NEW_LINE);
		 result.append("     reqFinProdId: " + this.reqFinProdId);
		 result.append(NEW_LINE);
		 result.append("     startDate: " + this.startDate);
		 result.append(NEW_LINE);
		 result.append("     endDate: " + this.endDate);
		 result.append(NEW_LINE);
		 result.append("     mobileCellWirelessIndicator: " + this.mobileCellWirelessIndicator);
		 result.append(NEW_LINE);
		 result.append("     internetOpenIndicator: " + this.internetOpenIndicator);
		 result.append(NEW_LINE);
		 result.append("     internetClosedIndicator: " + this.internetClosedIndicator);
		 result.append(NEW_LINE);
		 result.append("     reqProductId: " + this.reqProductId);
		 result.append(NEW_LINE);
		 result.append("}");
		 
		 return result.toString();
	}
	public Long getReqFoxId() {
		return reqFoxId;
	}
	public void setReqFoxId(Long foxId) {
		this.reqFoxId = foxId;
	}
	public String getReqFinProdId() {
		return reqFinProdId;
	}
	public void setReqFinProdId(String finProdId) {
		this.reqFinProdId = finProdId;
	}
	public Long getRequestId() {
		return requestId;
	}
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

}
