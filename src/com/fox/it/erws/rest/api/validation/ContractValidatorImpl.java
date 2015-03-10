package com.fox.it.erws.rest.api.validation;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.fox.it.erws.rest.api.dao.MLTDao;
import com.fox.it.erws.rest.api.model.drc.DRCRequest;
import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;
import com.fox.it.erws.rest.api.pojos.Contract;

public class ContractValidatorImpl extends ObjectGraphValidator {


	public boolean isValid(DRCRequest drcRequest,
			AppControlParamRequiredFields controlParamObj,
			ExpressionParser parser,
			MLTDao mltDao) {
		boolean isValid = true;
		Contract contract = drcRequest.getContract();
		
		StandardEvaluationContext contractContext = new StandardEvaluationContext(contract);
		
		Expression exp4 = parser.parseExpression(controlParamObj.getWebServiceRequiredFieldName());
			
		Object value = exp4.getValue(contractContext, Object.class);
		
		if (value == null) {
			System.out.println(controlParamObj.getRequiredErrorMessage());
			setErrorMessage(controlParamObj.getRequiredErrorMessage());
			return false;
		}
		else {
			//set the appKeyField and value
			System.out.println("The fieldName: " + controlParamObj.getWebServiceRequiredFieldName());
			System.out.println("The keyFlag: " + controlParamObj.getAppKeyFieldFlag());
			setAppKey(controlParamObj, value);
			
		}
		
		return isValid;
	}

	
	public void setAppKey(AppControlParamRequiredFields controlParamObj, Object value) {
		if (controlParamObj.getAppKeyFieldFlag().equals("Y")) {
			setAppKeyField(controlParamObj.getWebServiceRequiredFieldName());
			System.out.println("getAppKeyField: " + getAppKeyField());
			
			setAppKeyValue(new Long(value.toString()));
			setAppKeyDBName(controlParamObj.getFieldName());
		}
	}
	
	public String getAppKeyField() {
		return this.appKeyField;
	}
	public void setAppKeyValue(Long appKeyValue) {
		this.appKeyValue = appKeyValue;
	}
	
	public void setAppKeyField(String appKeyField) {
		this.appKeyField = appKeyField;
	}
	
	public void setAppKeyDBName(String appKeyDBName) {
		this.appKeyDBName = appKeyDBName;
	}
	
	public String getAppKeyDBName() {
		return this.appKeyDBName;
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
