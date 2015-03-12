package com.fox.it.erws.rest.api.validation;

import java.sql.Timestamp;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.fox.it.erws.rest.api.dao.MLTDao;
import com.fox.it.erws.rest.api.model.drc.DRCRequest;
import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;

public  class AskType2Impl extends ObjectGraphValidator {


	public <T extends DRCRequest> boolean isValid(T DRCRightsCheckRequiredRequest,
			AppControlParamRequiredFields controlParamObj,
			ExpressionParser parser,
			MLTDao mltDao) {
		boolean isValid = true;
		
		StandardEvaluationContext askType2RequestContext = new StandardEvaluationContext(DRCRightsCheckRequiredRequest);
		
		Expression exp4 = parser.parseExpression(controlParamObj.getWebServiceRequiredFieldName());
		
		Object value = exp4.getValue(askType2RequestContext, Object.class);
		
		if (value == null) {
			System.out.println(controlParamObj.getRequiredErrorMessage());
			setErrorMessage(controlParamObj.getRequiredErrorMessage());
			return false;
			
		} else {
			System.out.println("value: " + value.toString());
			
			//make sure timestamp is not some time in the future.
			//if we don't do this then if an app asks for an isRightsRequiredCheck
			//with a date that is in the future, then the RCE will always return false
			if (controlParamObj.getWebServiceRequiredFieldName().equals("dateTimeOfLastCheck")) {
				Timestamp dateTimeInRequest = Timestamp.valueOf(value.toString());
				Timestamp now = new Timestamp(new java.util.Date().getTime());
				if (dateTimeInRequest.after(now)) {
					setErrorMessage(controlParamObj.getTagFieldName());
					return false;
				}
			}
			
			//set the appKeyField and value for the sake of downstream code
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
	
	public String getAppKeyField() {
		return this.appKeyField;
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
