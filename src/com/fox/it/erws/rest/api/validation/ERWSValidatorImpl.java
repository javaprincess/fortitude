package com.fox.it.erws.rest.api.validation;


import java.util.Collection;
import java.util.Iterator;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Repository;

import com.fox.it.erws.rest.api.dao.MLTDao;

import com.fox.it.erws.rest.api.model.drc.DRCRequest;

import com.fox.it.erws.rest.api.model.drc.DRCResponse;
import com.fox.it.erws.rest.api.pojos.Answer;



import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;


@Repository
public class ERWSValidatorImpl<T extends DRCResponse<A>, A extends Answer> extends ERWSValidator {
	
	private String appKeyField;
	private Long appKeyValue;
	private String errorMessage;
	
	public boolean isDRCRequestValid(DRCRequest drcRequest, 
			Collection<AppControlParamRequiredFields> appControlParamRequiredFieldsList,
			MLTDao mltDao) {
		
		boolean isValid = true;
		
		ExpressionParser parser = new SpelExpressionParser();

		Iterator<AppControlParamRequiredFields> iterator = appControlParamRequiredFieldsList.iterator();
				
		while (iterator.hasNext()) {
					AppControlParamRequiredFields controlParamObj = iterator.next();
					ObjectGraphValidator o = ObjectGraphValidator.getInstance(controlParamObj);
					
					isValid = o.isValid(drcRequest,
							controlParamObj,
							parser,
							mltDao);
					
					if (!isValid) {
						setErrorMessage(o.getErrorMessage());
						break;
					}
					
					if (o.getAppKeyField() != null) {
						this.setAppKeyField(o.getAppKeyField());
						this.setAppKeyValue(o.getAppKeyValue());
					}

		}
				
			
		return isValid;
			
	}
	
	public void setAppKeyField(String appKeyField) {
		this.appKeyField = appKeyField;
	}
	
	public String getAppKeyField() {
		return this.appKeyField;
	}
	
	public Long getAppKeyValue() {
		return this.appKeyValue;
	}
	
	public void setAppKeyValue(Long appKeyValue) {
		this.appKeyValue = appKeyValue;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return this.errorMessage;
	}

}

