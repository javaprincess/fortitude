package com.fox.it.erws.rest.api.model.drc;

import java.io.Serializable;

public class DRCRightsRequiredChecker implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7247182647837496182L;
	
	private String consumingApplicationName;

	private Long titleListId; 
	
	private String dateTimeOfLastCheck;
	
	public DRCRightsRequiredChecker() {
		
	}
	
	//public DRCRequest(Long requestId, String consumingAppName, Contract contract) {
		
	public DRCRightsRequiredChecker(Long titleListId, String consumingApplicationName, String dateTimeOfLastCheck) {
			setProductListId(titleListId);
			setConsumingApplicationName(consumingApplicationName);
			setDateTimeOfLastCheck(dateTimeOfLastCheck);
	}

	public String getConsumingApplicationName() {
		return consumingApplicationName;
	}

	public void setConsumingApplicationName(String consumingApplicationName) {
		this.consumingApplicationName = consumingApplicationName;
	}

	public Long getProductListId() {
		return titleListId;
	}

	public void setProductListId(Long titleListId) {
		this.titleListId = titleListId;
	}

	public String getDateTimeOfLastCheck() {
		return dateTimeOfLastCheck;
	}

	public void setDateTimeOfLastCheck(String dateTimeOfLastCheck) {
		this.dateTimeOfLastCheck = dateTimeOfLastCheck;
	}
	
}
