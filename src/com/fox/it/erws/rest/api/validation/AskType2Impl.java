package com.fox.it.erws.rest.api.validation;

import java.sql.Timestamp;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.fox.it.erws.rest.api.model.drc.DRCRequest;
import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;

public  class AskType2Impl extends ObjectGraphValidator {


	public <T extends DRCRequest> ValidationResponse isValid(T DRCRightsCheckRequiredRequest,
			AppControlParamRequiredFields controlParamObj,
			ExpressionParser parser,NodeVisitor nodeVisitor) {
		ValidationResponse validationResponse = ValidationResponse.getValid();
		
		StandardEvaluationContext askType2RequestContext = new StandardEvaluationContext(DRCRightsCheckRequiredRequest);
		
		Expression exp4 = parser.parseExpression(controlParamObj.getWebServiceRequiredFieldName());
		
		Object value = exp4.getValue(askType2RequestContext, Object.class);
		
		if (value == null) {
			System.out.println(controlParamObj.getRequiredErrorMessage());
			validationResponse.setErrorMessage(controlParamObj.getRequiredErrorMessage());
			return validationResponse;
			
		} else {
			System.out.println("value: " + value.toString());
			nodeVisitor.visit(controlParamObj, value);
			//make sure timestamp is not some time in the future.
			//if we don't do this then if an app asks for an isRightsRequiredCheck
			//with a date that is in the future, then the RCE will always return false
			if (controlParamObj.getWebServiceRequiredFieldName().equals("dateTimeOfLastCheck")) {
				Timestamp dateTimeInRequest = Timestamp.valueOf(value.toString());
				Timestamp now = new Timestamp(new java.util.Date().getTime());
				if (dateTimeInRequest.after(now)) {
					validationResponse.setErrorMessage(controlParamObj.getTagFieldName());
					return validationResponse;
				}
			}
			
		}
		
		return validationResponse;
	}

	
	


}
