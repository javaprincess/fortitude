package com.fox.it.erws.rest.api.validation;


import java.util.Collection;

import com.fox.it.erws.rest.api.dao.MLTDao;
import com.fox.it.erws.rest.api.model.drc.DRCRequest;
import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;


public abstract class ERWSValidator {
	protected String errorMessage = null;
	protected String appKeyField = null;
	protected Long appKeyValue = null;
	protected String appKeyDBName = null;
	
	/**
	 * Default implementation
	 * @param drcRequest
	 * @param appControlParamRequiredFieldsList
	 * @param mltDao
	 * @return false
	 */
	public  <T extends DRCRequest> boolean isDRCRequestValid(T drcRequest, 
			Collection<AppControlParamRequiredFields> appControlParamRequiredFieldsList,
			MLTDao mltDao,
			Integer askType) {
		return false;
	}

	

public String getAppKeyDBName() {
	return this.appKeyDBName;
} 

public String getAppKeyField() {
	return this.appKeyField;
}

public Long getAppKeyValue() {
	return this.appKeyValue;
}


public String getErrorMessage() {
	return this.errorMessage;
}


public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}

	
}
