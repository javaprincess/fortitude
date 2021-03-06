package com.fox.it.erws.rest.api.dao;

import java.util.Collection;
import java.util.List;

import com.fox.it.erws.rest.api.model.drc.DRCRightsCheckRequiredRequest;
import com.fox.it.erws.rest.api.pojos.Answer;
import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;
import com.fox.it.erws.rest.api.pojos.ConsumingApplication;
import com.fox.it.erws.rest.api.pojos.ConsumingApplicationPOJO;
import com.fox.it.erws.rest.api.pojos.RightsCheckDetail;
import com.fox.it.erws.rest.api.pojos.RightsCheckRestrictionDetail;
import com.fox.it.erws.rest.api.validation.AskType;


public interface DRCDao {
	
	
	public void save(Collection<ConsumingApplicationPOJO> pojoCollection);
	public void remove(AppKeyData appKeyData, String consumingApplicationName);
	public <K extends ConsumingApplication> List<K> find(AppKeyData appKeyData);
	public Long findRunId(String applicationName,Long applicationValue);
	public Long getResponseId();
	//public RightsCheckSummary findRightsCheckSummary(Long queryId);
	public Collection<RightsCheckRestrictionDetail> findRightsCheckRestrictionDetail(Long queryId);
	public Collection<RightsCheckDetail> findRightsCheckDetail(Long queryId);
	public <A extends Answer> Collection<A> findAnswer(String applicationName,Long applicationValue);
	public <K extends ConsumingApplication> void rightsCheck(Long appKeyValue, String withinThroughoutFlag, String consumingApplicationName);
	
//	public List<Long> findProductIds(String applicationName,String applicationKeyFieldName,Long applicationValue);
	public boolean isRightsCheckRequired(DRCRightsCheckRequiredRequest DRCRightsCheckRequiredRequest,Long appKeyValue);
	public List<AppControlParamRequiredFields> findAllAppControlParamRequiredFields(String appName);
	public List<AppControlParamRequiredFields> findAllAppControlParamRequiredFields(String appName, AskType askType);
	
	public List<RightsCheckDetail> getRightsCheckDetailByQueryIds(List<Long> ids);
	public List<RightsCheckRestrictionDetail> findRightsCheckRestrictionDetailByQueryIds(List<Long> ids);	
	
}
