package com.fox.it.erws.rest.api.validation;

import org.apache.log4j.Logger;
import org.springframework.expression.ExpressionParser;

import com.fox.it.erws.rest.api.model.drc.DRCRequest;
import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;


public abstract class ObjectGraphValidator extends ERWSValidator{
	
	protected Logger log = Logger.getLogger(ERWSValidatorImpl.class);

	

	
	
	

	/**
	 * Default implementation of isValid.
	 * 
	 * @param drcRequest
	 * @param controlParamObj
	 * @param parser
	 * @param mltDao
	 * @return false always
	 */
	protected <T extends DRCRequest> boolean isValid(T drcRequest,
			AppControlParamRequiredFields controlParamObj,
			ExpressionParser parser) {
		return false;
	}

}
