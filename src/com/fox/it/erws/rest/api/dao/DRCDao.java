package com.fox.it.erws.rest.api.dao;

import java.util.Collection;
import java.util.List;

import com.fox.it.erws.rest.api.model.drc.DRCRightsRequiredChecker;
import com.fox.it.erws.rest.api.pojos.Answer;
import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;
import com.fox.it.erws.rest.api.pojos.ConsumingApplication;
import com.fox.it.erws.rest.api.pojos.ConsumingApplicationPOJO;
import com.fox.it.erws.rest.api.pojos.RightsCheckDetail;
import com.fox.it.erws.rest.api.pojos.RightsCheckRestrictionDetail;


public interface DRCDao {
	
	
	public void save(Collection<ConsumingApplicationPOJO> pojoCollection);
	public void remove(AppKeyData appKeyData, String consumingApplicationName);
	public <K extends ConsumingApplication> List<K> find(AppKeyData appKeyData);
	public Long findRunId(AppKeyData appKeyData, String consumingApplicationName);
	public Long getResponseId();
	//public RightsCheckSummary findRightsCheckSummary(Long queryId);
	public Collection<RightsCheckRestrictionDetail> findRightsCheckRestrictionDetail(Long queryId);
	public Collection<RightsCheckDetail> findRightsCheckDetail(Long queryId);
	public <A extends Answer> Collection<A> findAnswer(AppKeyData appKeyData);
	public <K extends ConsumingApplication> void rightsCheck(Long appKeyValue, String withinThroughoutFlag, String consumingApplicationName);
	public List<Long> findProductIds(AppKeyData appKeyData);
	public boolean isRightsCheckRequired(DRCRightsRequiredChecker drcRightsRequiredChecker,Long appKeyValue);
	public Collection<AppControlParamRequiredFields> findAllAppControlParamRequiredFields(String appName);
	public Collection<AppControlParamRequiredFields> findAllAppControlParamRequiredFields(String appName, Integer askType);
	
}
