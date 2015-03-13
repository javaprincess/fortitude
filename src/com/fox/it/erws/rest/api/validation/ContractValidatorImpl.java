package com.fox.it.erws.rest.api.validation;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.fox.it.erws.rest.api.model.drc.DRCRequest;
import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;
import com.fox.it.erws.rest.api.pojos.Contract;

public class ContractValidatorImpl extends ObjectGraphValidator {


	public ValidationResponse isValid(DRCRequest drcRequest,
			AppControlParamRequiredFields controlParamObj,
			ExpressionParser parser,NodeVisitor nodeVisitor) {
		ValidationResponse validationResponse = ValidationResponse.getValid();
		Contract contract = drcRequest.getContract();
		
		StandardEvaluationContext contractContext = new StandardEvaluationContext(contract);
		
		Expression exp4 = parser.parseExpression(controlParamObj.getWebServiceRequiredFieldName());
			
		Object value = exp4.getValue(contractContext, Object.class);
		
		if (value == null) {
			System.out.println(controlParamObj.getRequiredErrorMessage());
			validationResponse.setErrorMessage(controlParamObj.getRequiredErrorMessage());
			return validationResponse;
		} else {
			nodeVisitor.visit(controlParamObj, value);
		}
		
		return validationResponse;
	}

	
//	public void setAppKey(AppControlParamRequiredFields controlParamObj, Object value) {
//		if (controlParamObj.getAppKeyFieldFlag().equals("Y")) {
//			setAppKeyField(controlParamObj.getWebServiceRequiredFieldName());
//			System.out.println("getAppKeyField: " + getAppKeyField());
//			
//			setAppKeyValue(new Long(value.toString()));
//			setAppKeyDBName(controlParamObj.getFieldName());
//		}
//	}
	

	
}
