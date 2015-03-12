package com.fox.it.erws.rest.api.validation;

import java.util.List;

public class MTLValidatorFactory {

	private final List<Long> validMediaIds;
	private final List<Long> validTerritoryIds; 
	private final List<Long> validLanguageIds;
	
	
	public MTLValidatorFactory(List<Long> validMediaIds,List<Long> validTerritoryIds, List<Long> validLanguageIds) {
		this.validLanguageIds = validLanguageIds;
		this.validTerritoryIds = validTerritoryIds;
		this.validMediaIds = validMediaIds;
	}
	
	public  MLTValidator getInstance(String mlt) {
		if (mlt.equals("mediaId"))
			return new MLTValidator(validMediaIds);
		else if (mlt.equals("territoryId"))
			return new MLTValidator(validTerritoryIds);
		else if (mlt.equals("languageId"))
			return new MLTValidator(validLanguageIds);
		
		return null;
	}

}
