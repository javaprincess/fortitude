package com.fox.it.erws.rest.api.model.drc;





public class DRCRequestError<A> extends DRCResponse<A> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5158875658864154491L;
	private String errorMessage;
	
	
	public DRCRequestError() {}
	
	
	public DRCRequestError(String errorMessage) {
		setErrorMessage(errorMessage);
	}
	
	public String getErrorMessage() {
		return errorMessage;

	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	

}
