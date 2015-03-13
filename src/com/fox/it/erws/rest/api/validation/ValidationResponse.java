package com.fox.it.erws.rest.api.validation;

public class ValidationResponse {
	private String errorMessage;
	
	public ValidationResponse() {
	}
	
	public ValidationResponse(String message) {
		this.errorMessage = message;
	}
	

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String message) {
		this.errorMessage = message;
	}
	
	public boolean isValid() {
		if (errorMessage==null) return true;
		return false;
	}
	
	public static ValidationResponse getValid() {
		return new ValidationResponse();
	}
	
	public static ValidationResponse getInvalid() {
		return getInvalid("Invalid request");
	}
	
	
	public static ValidationResponse getInvalid(String message) {
		return new ValidationResponse(message);
	}
	
	
	

}
