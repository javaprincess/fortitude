package com.fox.it.erws.rest.api.validation;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.fox.it.erws.rest.api.dao.MLTDao;
import com.fox.it.erws.rest.api.model.drc.DRCRequest;
import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;
import com.fox.it.erws.rest.api.pojos.Strand;
import com.fox.it.erws.rest.api.pojos.Title;

public class StrandValidatorImpl extends ObjectGraphValidator {

	private Long appKeyValue;
	private String appKeyField;
	private String errorMessage;
	private String appKeyDBName;
	
	public boolean isValid(DRCRequest drcRequest,
			AppControlParamRequiredFields controlParamObj,
			ExpressionParser parser,
			MLTDao mltDao) {
		boolean isValid = true;
		
		Collection<Title> titleCollection = drcRequest.getContract().getTitles();
		Iterator<Title> titleIter = titleCollection.iterator();
		while (titleIter.hasNext() ) {
			
			Collection<Strand> strandCollection = titleIter.next().getStrands();
			Iterator<Strand> strandIter = strandCollection.iterator();
			
			while (strandIter.hasNext()) {
				StandardEvaluationContext strandContext = new StandardEvaluationContext(strandIter.next());
			
				Expression exp4 = parser.parseExpression(controlParamObj.getWebServiceRequiredFieldName());

				Object value = exp4.getValue(strandContext, Object.class);
			
				//TODO: MLT value validation
				if ((controlParamObj.isMlt() == true)) {
					System.out.println("strandValue: " + value);
					if (!isMltValid(controlParamObj, value, mltDao)) {
						setErrorMessage(controlParamObj.getMltErrorMessage());
						isValid = false;
						break;
					}
					
				}
				
				if (value == null) {
					System.out.println(controlParamObj.getRequiredErrorMessage());
					setErrorMessage(controlParamObj.getRequiredErrorMessage());
					isValid = false;
					break;
				} else {
					System.out.println("The fieldName: " + controlParamObj.getWebServiceRequiredFieldName());
					System.out.println("The keyFlag: " + controlParamObj.getAppKeyFieldFlag());
					//set the appKeyField and value
					setAppKey(controlParamObj, value);
					
				}
				
			}
		}
		
		return isValid;
	}
	
	private boolean isMltValid(AppControlParamRequiredFields controlParamObj, Object value, MLTDao mltDao) {

		return MLTValidator.getInstance(controlParamObj.getWebServiceRequiredFieldName())
				.isValid(controlParamObj, mltDao, value);
		
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
