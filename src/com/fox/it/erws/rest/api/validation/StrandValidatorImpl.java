package com.fox.it.erws.rest.api.validation;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.fox.it.erws.rest.api.model.drc.DRCRequest;
import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;
import com.fox.it.erws.rest.api.pojos.Strand;
import com.fox.it.erws.rest.api.pojos.Title;

public class StrandValidatorImpl extends ObjectGraphValidator {

	
	
	private MTLValidatorFactory mtlValidationFactory;
	
	public StrandValidatorImpl(List<Long> validMediaIds,List<Long> validTerritoryIds, List<Long> validLanguageIds) {
		mtlValidationFactory = new MTLValidatorFactory(validMediaIds, validTerritoryIds, validLanguageIds);
	}

	private String getFieldValueDesrciptionForMessage( String fieldName, Object fieldValue) {
		String message = fieldName + " with value " + fieldValue;
		return message;
	}
	
	private String getDetailMessage(String fieldName, Object fieldValue,String dbMessage) {
		String fieldValueDescription = getFieldValueDesrciptionForMessage(fieldName, fieldValue);
		return dbMessage + " "  + fieldValueDescription;
	}
	
	public ValidationResponse isValid(DRCRequest drcRequest,
			AppControlParamRequiredFields controlParamObj,
			ExpressionParser parser,NodeVisitor nodeVisitor) {
		
		Collection<Title> titleCollection = drcRequest.getContract().getTitles();
		Iterator<Title> titleIter = titleCollection.iterator();
		ValidationResponse validationResponse = ValidationResponse.getValid();
		while (titleIter.hasNext() ) {
			
			Collection<Strand> strandCollection = titleIter.next().getStrands();
			Iterator<Strand> strandIter = strandCollection.iterator();
			
			while (strandIter.hasNext()) {
				StandardEvaluationContext strandContext = new StandardEvaluationContext(strandIter.next());
			
				Expression exp4 = parser.parseExpression(controlParamObj.getWebServiceRequiredFieldName());

				Object value = exp4.getValue(strandContext, Object.class);
				if ((controlParamObj.isMlt() == true)) {
					if (!isMltValid(controlParamObj, (Long)value)) {
						String message = getDetailMessage(controlParamObj.getWebServiceRequiredFieldName(), value,controlParamObj.getMltErrorMessage());
						validationResponse.setErrorMessage(message);
						break;
					}
					
				}
				
				if (value == null) {
					validationResponse.setErrorMessage(controlParamObj.getRequiredErrorMessage());
					break;
				} else {
					nodeVisitor.visit(controlParamObj, value);
				}
				
			}
		}
		
		return validationResponse;
	}
	
	private boolean isMltValid(AppControlParamRequiredFields controlParamObj, Long value) {

		return mtlValidationFactory.getInstance(controlParamObj.getWebServiceRequiredFieldName())
				.isValid(controlParamObj, value);
		
	}

	

}
