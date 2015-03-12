package com.fox.it.erws.rest.api.validation;

import com.fox.it.erws.rest.api.dao.MLTDao;

public class TerritoryValidatorImpl extends MLTValidator {

	private String validatorName;
	
	public TerritoryValidatorImpl(String name) {
		setValidatorName(name);
	}
	public boolean isValid(MLTDao mltDao, Long value) {
		return mltDao.isValidTerritory(value);
	}
	
	public void setValidatorName(String name) {
		this.validatorName = name;
	}

	public String getValidatorName() {
		return this.validatorName;
	}
}
