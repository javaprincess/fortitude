package com.fox.it.erws.rest.api.validation;

import com.fox.it.erws.rest.api.dao.MLTDao;


public class MediaValidatorImpl extends MLTValidator {
	private String validatorName;
	
	public MediaValidatorImpl(String  name) {
		setValidatorName(name);
	}
	public boolean isValid(MLTDao mltDao,
			Long value) {
		return mltDao.isValidMedia(value);
	}
	
	public void setValidatorName(String name) {
		this.validatorName = name;
	}
	
	public String getValidatorName() {
		return this.validatorName;
	}

}
