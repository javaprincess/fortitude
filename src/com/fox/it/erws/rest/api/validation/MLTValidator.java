package com.fox.it.erws.rest.api.validation;

import java.util.List;

import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;


public class MLTValidator  {
	private final List<Long> validValues;
	
	public MLTValidator(List<Long> validValues) {
		this.validValues = validValues;
	}
	
	
	public boolean isValid(AppControlParamRequiredFields controlParamObj,
			Long value) {		
		return isValid(value);
	}
	
	protected boolean isValid(Long value) {
		if (validValues==null||validValues.isEmpty()) return false;
		return validValues.contains(value);
	}

}
