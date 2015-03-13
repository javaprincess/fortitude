package com.fox.it.erws.rest.api.validation;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.fox.it.erws.rest.api.model.drc.DRCRequest;
import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;

public class BaseValidatorImpl extends ObjectGraphValidator {

	
	

	public ValidationResponse isValid(DRCRequest drcRequest,
			AppControlParamRequiredFields controlParamObj,
			ExpressionParser parser, NodeVisitor nodeVisitor) {
		ValidationResponse validationResponse = ValidationResponse.getValid();
		
		StandardEvaluationContext drcRequestContext = new StandardEvaluationContext(drcRequest);
		
		Expression exp4 = parser.parseExpression(controlParamObj.getWebServiceRequiredFieldName());
			
			
		Object value = exp4.getValue(drcRequestContext, Object.class);
		
		
		if (value == null) {
			System.out.println(controlParamObj.getRequiredErrorMessage());
			return ValidationResponse.getInvalid(controlParamObj.getRequiredErrorMessage());
			
		} else {
			nodeVisitor.visit(controlParamObj, value);
		}
		
		return validationResponse;
	}

	
	
	

	



}
