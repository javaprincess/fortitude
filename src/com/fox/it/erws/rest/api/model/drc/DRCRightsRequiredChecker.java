package com.fox.it.erws.rest.api.model.drc;

import java.io.Serializable;
import java.sql.Date;

public class DRCRightsRequiredChecker implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7247182647837496182L;
	
	private String consumingApplicationName;

	private Long productListId; 
	
	private Date dateOfLastCheck;
	
	public DRCRightsRequiredChecker() {
		
	}
	
	//public DRCRequest(Long requestId, String consumingAppName, Contract contract) {
		
	public DRCRightsRequiredChecker(Long productListId, String consumingApplicationName, Date dateOfLastCheck) {
			setProductListId(productListId);
			setConsumingApplicationName(consumingApplicationName);
			setDateOfLastCheck(dateOfLastCheck);
	}

	public String getConsumingApplicationName() {
		return consumingApplicationName;
	}

	public void setConsumingApplicationName(String consumingApplicationName) {
		this.consumingApplicationName = consumingApplicationName;
	}

	public Long getProductListId() {
		return productListId;
	}

	public void setProductListId(Long productListId) {
		this.productListId = productListId;
	}

	public Date getDateOfLastCheck() {
		return dateOfLastCheck;
	}

	public void setDateOfLastCheck(Date dateOfLastCheck) {
		this.dateOfLastCheck = dateOfLastCheck;
	}
	
}
