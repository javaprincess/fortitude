package com.fox.it.erws.rest.api.validation;

import org.apache.log4j.Logger;
import org.springframework.expression.ExpressionParser;

import com.fox.it.erws.rest.api.dao.MLTDao;
import com.fox.it.erws.rest.api.model.drc.DRCRequest;
import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;


public abstract class ObjectGraphValidator extends ERWSValidator{
	
	protected Logger log = Logger.getLogger(ERWSValidatorImpl.class);

	
	public static ObjectGraphValidator getInstance(AppControlParamRequiredFields a, AskType askType) {
		String fieldName = a.getWebServiceRequiredFieldName();
		System.out.println("Validating " + fieldName);
		if (askType==null) return null;
		if ( (a.isBase() == true) &&
				( askType == AskType.DRC_CHECK) )
			return new BaseValidatorImpl();
		else if ( (a.isContract() == true) &&
			 	( askType == AskType.DRC_CHECK) )
			return new ContractValidatorImpl();
		else if ( (a.isTitle() == true) &&
				( askType == AskType.DRC_CHECK) )
			return new TitleValidatorImpl();
		else if ( (a.isStrand() == true) &&
				( askType == AskType.DRC_CHECK) )
			return new StrandValidatorImpl();
		else if ( (a.isAskType2() == true) &&
				( askType == AskType.IS_RIGHTS_CHECK_REQUIRED) )
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
