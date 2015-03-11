package com.fox.it.erws.rest.api.validation;

import com.fox.it.erws.rest.api.dao.MLTDao;


public class LanguageValidatorImpl extends MLTValidator {
	
	private String validatorName;
	public LanguageValidatorImpl(String name) {
		setValidatorName(name);
	}
	public boolean isValid(MLTDao mltDao, Object value) {
		System.out.println("value: " + value.toString());
		System.out.println("isValid language: " + mltDao.isValidLanguage(value));
	
		return mltDao.isValidLanguage(value);
	}
	
	public void setValidatorName(String name) {
		validatorName = name;
	}
	
	public String getValidatorName() {
		return validatorName;
	}

}
