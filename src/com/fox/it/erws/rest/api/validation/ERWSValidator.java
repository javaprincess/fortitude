package com.fox.it.erws.rest.api.validation;


import java.util.Collection;


import com.fox.it.erws.rest.api.model.drc.DRCRequest;
import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;


public abstract class ERWSValidator {
	
	/**
	 * Default implementation
	 * @param drcRequest
	 * @param appControlParamRequiredFieldsList
	 * @param mltDao
	 * @return false
	 */
	public  <T extends DRCRequest> ValidationResponse isDRCRequestValid(T drcRequest, 
			Collection<AppControlParamRequiredFields> appControlParamRequiredFieldsList,
			AskType askType,NodeVisitor nodeVisitor) {
		return ValidationResponse.getInvalid();
	}

	
}
