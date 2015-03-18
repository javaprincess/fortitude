package com.fox.it.erws.rest.api.service;

//This is the entry point for consumers interested accessing rights data from ERM
//This is a swagger resource

import java.util.List;
import java.util.Set;

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
	

	private RunningQueries runningQueries = new RunningQueries();
	
	public DRCService() {
		
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
		String applicationName = drcRequest.getConsumingApplicationName();		
		AppKeyAccumulatorVisitor appKeyAccumulator = new AppKeyAccumulatorVisitor();
		//we have to validate that the applicationName exists in the request and in the DB before we can
		//process the request. This is the only field that requires this special treatment
		if ( applicationName == null||applicationName.isEmpty()) 
			return (E) new DRCRequestError<A>("the request field: consumingApplicationName is missing.");
		else {
			
			ValidationResponse validationResponse = erwsValidator.isDRCRequestValid(drcRequest, appControlParamRequiredFieldsList,askType,appKeyAccumulator);
			
			if (!validationResponse.isValid()) {
				return (E) new DRCRequestError<A>(validationResponse.getErrorMessage());
			} 
			AppKeyData appKeyData = appKeyAccumulator.getAppKeyData();
			System.out.println("after validation appKeyField/appKeyValue: " + appKeyData.getAppKeyField() + "/" + appKeyData.getAppKeyValue());

			//validate that only one request per id is running
			ApplicationQuery applicationQuery = AppKeyDataToRunningQueryConverter.get(applicationName, appKeyData);
			if (runningQueries.isRunning(applicationQuery)) {
				return (E) new DRCRequestError<A>(appKeyData.getAppKeyField() + " " + appKeyData.getAppKeyValue()  + " is currently being processed.  Please submit another " + appKeyData.getAppKeyField() + " for a DRC.");
			} else {
				runningQueries.setAsRunning(applicationQuery);
			}
			try {
				System.out.println("timestamp --> start processing the request for requestId: " + drcRequest.getRequestId() + ": " + ERMTime.getTime());
				drcRequest.setResponseId(drcDao.getResponseId());
				drcResponse = (E) drcRequestProducer.processRequest(drcRequest, appKeyData);
				System.out.println("timestamp --> finish processing the request for requestId/responseId: " + drcRequest.getRequestId() + "/" + drcRequest.getResponseId() + ": " + ERMTime.getTime());
			} finally {
				runningQueries.remove(applicationQuery);
			}
			

		}
		
        return drcResponse;
       
      
	}
	
	@RequestMapping(value="/cache/remove", method=RequestMethod.POST)
	@Valid
	public @ResponseBody String cacheManagement( @RequestBody ApplicationQuery appKeyValue) {	
		String message = null;
		if (runningQueries.isRunning(appKeyValue)) {
			runningQueries.remove(appKeyValue);
			message = appKeyValue + " has been removed from the cache";
		} else
			message = appKeyValue + " does not exist in the cache";
		
		return message;
	}
	
	@RequestMapping(value="/cache/view", method=RequestMethod.GET)
	@Valid
	public @ResponseBody Set<ApplicationQuery>  cacheManagementView() {	
		return runningQueries.getAll();
	}
	
}
