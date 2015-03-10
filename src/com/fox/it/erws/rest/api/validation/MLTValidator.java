package com.fox.it.erws.rest.api.validation;

import com.fox.it.erws.rest.api.dao.MLTDao;
import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;


public abstract class MLTValidator  {
	
	public static MLTValidator getInstance(String mlt) {
		if (mlt.equals("mediaId"))
			return new MediaValidatorImpl(mlt);
		else if (mlt.equals("territoryId"))
			return new TerritoryValidatorImpl(mlt);
		else if (mlt.equals("languageId"))
			return new LanguageValidatorImpl(mlt);
		
		return null;
	}
	
	public boolean isValid(AppControlParamRequiredFields controlParamObj,
			MLTDao mltDao,
			Object value) {
		
		return MLTValidator.getInstance(controlParamObj.getWebServiceRequiredFieldName()).isValid(mltDao, value);
	}
	
	protected abstract boolean isValid(MLTDao mltDao,
			Object value);

}
