package com.fox.it.erws.rest.api.model.drc;

import java.io.Serializable;






public class  DRCRightsCheckRequiredResponse  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7247182647837496182L;
	
	private boolean isRightsCheckRequired;
	private String errorMessage;


	
	public DRCRightsCheckRequiredResponse() {
		
	}
	
	public DRCRightsCheckRequiredResponse(String errorMessage, boolean isCheckRequired) {
		setErrorMessage(errorMessage);
		setIsRightsCheckRequired(isCheckRequired);
	}
	
	
		
	public DRCRightsCheckRequiredResponse(boolean isRightsCheckRequired) {
		setIsRightsCheckRequired(isRightsCheckRequired);
	}



	public boolean isRightsCheckRequired() {
		return isRightsCheckRequired;
	}



	public void setIsRightsCheckRequired(boolean isRightsCheckRequired) {
		this.isRightsCheckRequired = isRightsCheckRequired;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
	
}
