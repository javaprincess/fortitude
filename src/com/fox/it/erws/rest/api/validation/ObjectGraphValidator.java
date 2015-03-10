package com.fox.it.erws.rest.api.validation;

import org.apache.log4j.Logger;
import org.springframework.expression.ExpressionParser;

import com.fox.it.erws.rest.api.dao.MLTDao;
import com.fox.it.erws.rest.api.model.drc.DRCRequest;
import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;


public abstract class ObjectGraphValidator extends ERWSValidator{
	
	protected Logger log = Logger.getLogger(ERWSValidatorImpl.class);

	
	public static ObjectGraphValidator getInstance(AppControlParamRequiredFields a) {
		if (a.isBase() == true)
			return new BaseValidatorImpl();
		else if (a.isContract() == true)
			return new ContractValidatorImpl();
		else if (a.isTitle() == true)
			return new TitleValidatorImpl();
		else if (a.isStrand() == true)
			return new StrandValidatorImpl();
		
		return null;
	}
	

	
	
	

	/**
	 * Default implementation of isValid.
	 * 
	 * @param drcRequest
	 * @param controlParamObj
	 * @param parser
	 * @param mltDao
	 * @return false always
	 */
	protected boolean isValid(DRCRequest drcRequest,
			AppControlParamRequiredFields controlParamObj,
			ExpressionParser parser,
			MLTDao mltDao) {
		return false;
	}

}
