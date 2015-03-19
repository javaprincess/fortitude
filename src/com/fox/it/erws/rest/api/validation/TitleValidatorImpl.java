package com.fox.it.erws.rest.api.validation;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.fox.it.erws.rest.api.model.drc.DRCRequest;
import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;
import com.fox.it.erws.rest.api.pojos.Title;

public class TitleValidatorImpl extends ObjectGraphValidator {

	public ValidationResponse isValid(DRCRequest drcRequest,
			AppControlParamRequiredFields controlParamObj,
			ExpressionParser parser,NodeVisitor nodeVisitor) {
		ValidationResponse validationResponse = ValidationResponse.getValid();
		Collection<Title> titleCollection = drcRequest.getContract().getTitles();
		Iterator<Title> titleIter = titleCollection.iterator();
		while (titleIter.hasNext() ) {
			Title title = titleIter.next();
			StandardEvaluationContext titleContext = new StandardEvaluationContext(title);
			
			Expression exp4 = parser.parseExpression(controlParamObj.getWebServiceRequiredFieldName());
				
				
			Object value = exp4.getValue(titleContext, Object.class);
			
			
			if (value == null ||
			   (value instanceof String && ((String)value).trim().isEmpty())) {
				validationResponse.setErrorMessage(controlParamObj.getRequiredErrorMessage()); 
				validationResponse.setErrorMessage(controlParamObj.getRequiredErrorMessage());
				break;
			} else {
				nodeVisitor.visit(controlParamObj, value);
			}
		} 
		
		return validationResponse;
	}


}
