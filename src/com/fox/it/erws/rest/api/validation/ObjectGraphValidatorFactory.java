package com.fox.it.erws.rest.api.validation;

import java.util.List;

import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;

public class ObjectGraphValidatorFactory {

	private List<Long> validMediaIds;
	private List<Long> validTerritoryIds;
	private List<Long> validLangiageIds;
	
	public ObjectGraphValidatorFactory(List<Long> validMediaIds,List<Long> validTerritoryIds,List<Long> validLanguageIds) {
		this.validMediaIds = validMediaIds;
		this.validLangiageIds = validLanguageIds;
		this.validTerritoryIds = validTerritoryIds;
	}
	
	public ObjectGraphValidator getInstance(AppControlParamRequiredFields a, AskType askType) {
		if (askType==null) return null;
		if ( (a.isBase() == true) &&
				( askType == AskType.DRC_CHECK) )
			return new BaseValidatorImpl();
		else if ( (a.isContract() == true) &&
			 	( askType == AskType.DRC_CHECK) )
			return new ContractValidatorImpl();
		else if ( (a.isTitle() == true) &&
				( askType == AskType.DRC_CHECK) )
			return new TitleValidatorImpl();
		else if ( (a.isStrand() == true) &&
				( askType == AskType.DRC_CHECK) )
			return new StrandValidatorImpl(validMediaIds,validTerritoryIds,validLangiageIds);
		else if ( (a.isAskType2() == true) &&
				( askType == AskType.IS_RIGHTS_CHECK_REQUIRED) )
			return new AskType2Impl();
		return null;
	}
	

}
