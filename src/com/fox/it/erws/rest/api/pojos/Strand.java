package com.fox.it.erws.rest.api.pojos;

import java.io.Serializable;
import java.sql.Date;

public class Strand implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4372700562139466647L;
	public static final int strandCount = new java.util.Random().nextInt();
	
	private Long mediaId;
	private Long territoryId;
	private Long languageId;
	private Long titleListMapId;
	private Long titleLicenseRightId;
	private Long mltGroupId;
	private String mobileCellWirelessIndicator;
	private String internetOpenIndicator;
	private String internetClosedIndicator;
	private Date endDate;
	private Date startDate;
	
	
	//private String rightsCheckSummaryHref;

	public Strand() {
		
	}
	
	public Strand(Long titleListMapId,
			Long mediaId, 
			Long territoryId, 
			Long languageId,
			Long titleLicenseRightId,
			Long mltGroupId,
			String mobileCellWirelessIndicator,
			String internetOpenIndicator,
			String internetClosedIndicator,
			Date startDate,
			Date endDate) {
		setMediaId(mediaId);
		setTerritoryId(territoryId);
		setLanguageId(languageId);
		setTitleListMapId(titleListMapId);
		setTitleLicenseRightId(titleLicenseRightId);
		setMltGroupId(mltGroupId);
		setMobileCellWirelessIndicator(mobileCellWirelessIndicator);
		setInternetOpenIndicator(internetOpenIndicator);
		setInternetClosedIndicator(internetClosedIndicator);
		setStartDate(startDate);
		setEndDate(endDate);
	}

	public static final int getNumber() {
		return strandCount;
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
	
	@Override
	public String toString() {
		 StringBuilder result = new StringBuilder();
		 String NEW_LINE = System.getProperty("line.separator");

		 result.append(this.getClass().getName());
		 result.append("  {" + NEW_LINE);
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
		 //result.append("     rightsCheckSummaryHref: " + this.rightsCheckSummaryHref);
		 //result.append(NEW_LINE);
		 result.append("}");
		 
		 return result.toString();
	}


	/*public String getRightsCheckSummaryHref() {
		return rightsCheckSummaryHref;
	}

	public void setRightsCheckSummaryHref(String rightsCheckSummaryHref) {
		this.rightsCheckSummaryHref = rightsCheckSummaryHref;
	} */

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

	public String getMobileCellWirelessIndicator() {
		return mobileCellWirelessIndicator;
	}

	public void setMobileCellWirelessIndicator(String mobileCellWirelessIndicator) {
		this.mobileCellWirelessIndicator = mobileCellWirelessIndicator;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}
