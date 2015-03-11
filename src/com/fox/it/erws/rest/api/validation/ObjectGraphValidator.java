package com.fox.it.erws.rest.api.validation;

import org.apache.log4j.Logger;
import org.springframework.expression.ExpressionParser;

import com.fox.it.erws.rest.api.dao.MLTDao;
import com.fox.it.erws.rest.api.model.drc.DRCRequest;
import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;


public abstract class ObjectGraphValidator extends ERWSValidator{
	
	protected Logger log = Logger.getLogger(ERWSValidatorImpl.class);

	
	public static ObjectGraphValidator getInstance(AppControlParamRequiredFields a, AskType askType) {
	//public static ObjectGraphValidator getInstance(AppControlParamRequiredFields a, Integer askType) {
		if ( (a.isBase() == true) &&
				( askType.getType() == 1) )
			return new BaseValidatorImpl();
		else if ( (a.isContract() == true) &&
			 	( askType.getType() == 1) )
			return new ContractValidatorImpl();
		else if ( (a.isTitle() == true) &&
				( askType.getType() == 1) )
			return new TitleValidatorImpl();
		else if ( (a.isStrand() == true) &&
				( askType.getType() == 1) )
			return new StrandValidatorImpl();
		else if ( (a.isAskType2() == true) &&
				( askType.getType() == 2) )
			return new AskType2Impl();
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
	protected <T extends DRCRequest> boolean isValid(T drcRequest,
			AppControlParamRequiredFields controlParamObj,
			ExpressionParser parser,
			MLTDao mltDao) {
		return false;
	}

}
