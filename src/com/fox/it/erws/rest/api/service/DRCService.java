package com.fox.it.erws.rest.api.service;

//This is the entry point for consumers interested accessing rights data from ERM
//This is a swagger resource

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fox.it.erws.rest.api.dao.AppKeyData;
import com.fox.it.erws.rest.api.dao.DRCDao;
import com.fox.it.erws.rest.api.model.drc.DRCRequest;
import com.fox.it.erws.rest.api.model.drc.DRCRequestError;
import com.fox.it.erws.rest.api.model.drc.DRCResponse;
import com.fox.it.erws.rest.api.model.drc.DRCRightsCheckRequiredRequest;
import com.fox.it.erws.rest.api.model.drc.DRCRightsCheckRequiredResponse;
import com.fox.it.erws.rest.api.pojos.Answer;
import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;
import com.fox.it.erws.rest.api.pojos.mtl.MTL;
import com.fox.it.erws.rest.api.processor.DRCRequestProducer;
import com.fox.it.erws.rest.api.util.ERMTime;
import com.fox.it.erws.rest.api.validation.AppKeyAccumulatorVisitor;
import com.fox.it.erws.rest.api.validation.AskType;
import com.fox.it.erws.rest.api.validation.ERWSValidator;
import com.fox.it.erws.rest.api.validation.ValidationResponse;
import com.wordnik.swagger.annotations.Api;


@Controller
@Api(value = "/drc", description = "make a request for access the DRC resource and its service layer with a valid access token")
public class DRCService<T extends MTL, A extends Answer, R extends DRCResponse<A>> {

	@Autowired
	private DRCRequestProducer drcRequestProducer;
	
	@Autowired 
	private DRCDao drcDao;
	
	
	@Autowired
	private ERWSValidator erwsValidator;
	

	private Collection<Long> runningAppSpecificIds = null;
	
	public DRCService() {
		if (this.runningAppSpecificIds == null) {
			System.out.println("timestamp --> initializing the AppSpecificId cache here: " + ERMTime.getTime());
			this.runningAppSpecificIds = new ArrayList<Long>();
			this.runningAppSpecificIds.add(-1L);
		}
		
	}
	
	
	@RequestMapping(value="/ask/required", method=RequestMethod.POST)
	public @ResponseBody DRCRightsCheckRequiredResponse isRightsCheckRequired( @RequestBody DRCRightsCheckRequiredRequest DRCRightsCheckRequiredRequest) {	
		DRCRightsCheckRequiredResponse drcRightsCheckRequiredResponse = null;
		AskType askType =  AskType.IS_RIGHTS_CHECK_REQUIRED;
		AppKeyAccumulatorVisitor appKeyAccumulator = new AppKeyAccumulatorVisitor();	
		
		List<AppControlParamRequiredFields> appControlParamRequiredFieldsList  = drcDao.findAllAppControlParamRequiredFields(DRCRightsCheckRequiredRequest.getConsumingApplicationName(), askType);
		
		//we have to validate that the applicationName exists in the request and in the DB before we can
		//process the request. This is the only field that requires this special treatment
		if (DRCRightsCheckRequiredRequest.getConsumingApplicationName() == null) { 
			return new DRCRightsCheckRequiredResponse("the request field: consumingApplicationName is missing.", true);
		}
		appControlParamRequiredFieldsList  = drcDao.findAllAppControlParamRequiredFields(DRCRightsCheckRequiredRequest.getConsumingApplicationName(), askType);
		ValidationResponse validationResponse = erwsValidator.isDRCRequestValid(DRCRightsCheckRequiredRequest, 
				appControlParamRequiredFieldsList, 
				askType,appKeyAccumulator);
	
		if (!validationResponse.isValid()) {
					return new DRCRightsCheckRequiredResponse(validationResponse.getErrorMessage(), true);
				} 
		AppKeyData appKeyData = appKeyAccumulator.getAppKeyData();
	
		drcRightsCheckRequiredResponse = new DRCRightsCheckRequiredResponse(drcRequestProducer.isRightsCheckRequired(DRCRightsCheckRequiredRequest, 
				drcDao, 
				appKeyData.getAppKeyValue()));
		return drcRightsCheckRequiredResponse;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/ask", method=RequestMethod.POST)
	@Valid
	public @ResponseBody <E extends DRCResponse<? extends A>> E askTheQuestion( @RequestBody DRCRequest drcRequest) {	
		E drcResponse = null;
		AskType askType =  AskType.DRC_CHECK;		
		List<AppControlParamRequiredFields> appControlParamRequiredFieldsList  = drcDao.findAllAppControlParamRequiredFields(drcRequest.getConsumingApplicationName(), askType);
		
//		AppKeyData appKeyData =  appKeyDataProvider.get(appControlParamRequiredFieldsList);		
		AppKeyAccumulatorVisitor appKeyAccumulator = new AppKeyAccumulatorVisitor();
		//we have to validate that the applicationName exists in the request and in the DB before we can
		//process the request. This is the only field that requires this special treatment
		if (drcRequest.getConsumingApplicationName() == null) 
			return (E) new DRCRequestError<A>("the request field: consumingApplicationName is missing.");
		else {
			
			ValidationResponse validationResponse = erwsValidator.isDRCRequestValid(drcRequest, appControlParamRequiredFieldsList,askType,appKeyAccumulator);
			
			if (!validationResponse.isValid()) {
				return (E) new DRCRequestError<A>(validationResponse.getErrorMessage());
			} 
			AppKeyData appKeyData = appKeyAccumulator.getAppKeyData();
			System.out.println("after validation appKeyField/appKeyValue: " + appKeyData.getAppKeyField() + "/" + appKeyData.getAppKeyValue());
		
		
			if (this.runningAppSpecificIds.contains(appKeyData.getAppKeyValue())) {
				return (E) new DRCRequestError<A>(appKeyData.getAppKeyField() + " " + appKeyData.getAppKeyValue()  + " is currently being processed.  Please submit another " + appKeyData.getAppKeyField() + " for a DRC.");
			} else
				this.runningAppSpecificIds.add(appKeyData.getAppKeyValue());
		
        
			System.out.println("timestamp --> start processing the request for requestId: " + drcRequest.getRequestId() + ": " + ERMTime.getTime());
			drcRequest.setResponseId(drcDao.getResponseId());
			drcResponse = (E) drcRequestProducer.processRequest(drcRequest, appKeyData);

			System.out.println("timestamp --> finish processing the request for requestId/responseId: " + drcRequest.getRequestId() + "/" + drcRequest.getResponseId() + ": " + ERMTime.getTime());
        
			//remove the running titleListId from the runningList
			System.out.println("removing appKeyValue: " + appKeyData.getAppKeyValue());
			this.runningAppSpecificIds.remove(appKeyData.getAppKeyValue());
			System.out.println("what does the runningAppSpecificIds contain after processing? " + runningAppSpecificIds.toString());
		}
		
        return drcResponse;
       
      
	}
	
	@RequestMapping(value="/cache", method=RequestMethod.POST)
	@Valid
	public @ResponseBody String cacheManagement( @RequestBody Long appKeyValue) {	
		String message = null;
		
		if (runningAppSpecificIds.contains(appKeyValue)) {
			this.runningAppSpecificIds.remove(appKeyValue);
			message = appKeyValue + " has been removed from the cache";
		} else
			message = appKeyValue + " does not exist in the cache";
		
		return message;
	}
	
	@RequestMapping(value="/cache/view", method=RequestMethod.GET)
	@Valid
	public @ResponseBody Collection<Long>  cacheManagementView() {	
		return runningAppSpecificIds;
	}
	
}
