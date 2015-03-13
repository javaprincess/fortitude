package com.fox.it.erws.rest.api.validation;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Repository;

import com.fox.it.erws.rest.api.dao.MLTDao;
import com.fox.it.erws.rest.api.model.drc.DRCRequest;
import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;


@Repository
public class ERWSValidatorImpl extends ERWSValidator {


	@Autowired
	private MLTDao mtlDao;
	
	
	private List<Long> getValidMediaIds() {
		return mtlDao.findMediaList();
	}
	
	private List<Long> getValidTerritoryIds() {
		return mtlDao.findTerritoryList();
	}
	
	private List<Long> getValidLanguageIds() {
		return mtlDao.findLanguageList();
	}
	

	
	public <T extends DRCRequest> ValidationResponse isDRCRequestValid(T request, 
			Collection<AppControlParamRequiredFields> appControlParamRequiredFieldsList, 
			AskType askType,NodeVisitor nodeVisitor) {
		
		ValidationResponse validationResponse = ValidationResponse.getValid();
		
		ExpressionParser parser = new SpelExpressionParser();

		Iterator<AppControlParamRequiredFields> iterator = appControlParamRequiredFieldsList.iterator();
		List<Long> validMediaIds = getValidMediaIds();
		List<Long> validTerritoryIds = getValidTerritoryIds();
		List<Long> validLanguageIds = getValidLanguageIds();
		ObjectGraphValidatorFactory objectGraphValidatorFactory = new ObjectGraphValidatorFactory(validMediaIds, validTerritoryIds, validLanguageIds);
		
		while (iterator.hasNext()) {
					AppControlParamRequiredFields controlParamObj = iterator.next();
					ObjectGraphValidator o = objectGraphValidatorFactory.getInstance(controlParamObj, askType);
					if (o!=null) {
						validationResponse = o.isValid(request,
								controlParamObj,
								parser,nodeVisitor);
						if (!validationResponse.isValid()) {
							break;
						}
					}

		}
				
			
		return validationResponse;
			
	}
	
	
	
}

