package com.fox.it.erws.rest.api.service;

//This is the entry point for consumers interested accessing rights data from ERM
//This is a swagger resource

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fox.it.erws.rest.api.dao.AppKeyData;
import com.fox.it.erws.rest.api.dao.DRCDao;
import com.fox.it.erws.rest.api.dao.MLTDao;
import com.fox.it.erws.rest.api.model.drc.DRCRequest;
import com.fox.it.erws.rest.api.model.drc.DRCRequestError;
import com.fox.it.erws.rest.api.model.drc.DRCResponse;
import com.fox.it.erws.rest.api.model.drc.DRCRightsCheckRequiredResponse;
import com.fox.it.erws.rest.api.model.drc.DRCRightsRequiredChecker;
import com.fox.it.erws.rest.api.pojos.Answer;
import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;
import com.fox.it.erws.rest.api.pojos.mtl.MLT;
import com.fox.it.erws.rest.api.processor.DRCRequestProducer;
import com.fox.it.erws.rest.api.util.ERMTime;
import com.fox.it.erws.rest.api.validation.ERWSValidator;
import com.wordnik.swagger.annotations.Api;


@Controller
@Api(value = "/drc", description = "make a request for access the DRC resource and its service layer with a valid access token")
public class DRCService<T extends MLT, A extends Answer, R extends DRCResponse<A>> {

	@Autowired
	private DRCRequestProducer drcRequestProducer;
	
	@Autowired 
	private DRCDao drcDao;
	
	@Autowired
	private MLTDao mltDao;
	
	@Autowired
	private ERWSValidator erwsValidator;
	
//	private Logger log = Logger.getLogger(DRCService.class);

	private Collection<Long> runningAppSpecificIds = null;
	
	public DRCService() {
		if (this.runningAppSpecificIds == null) {
			System.out.println("timestamp --> initializing the AppSpecificId cache here: " + ERMTime.getTime());
			this.runningAppSpecificIds = new ArrayList<Long>();
			this.runningAppSpecificIds.add(-1L);
		}
		
	}
	
	
	@RequestMapping(value="/ask/required", method=RequestMethod.POST)
	public @ResponseBody DRCRightsCheckRequiredResponse isRightsCheckRequired( @RequestBody DRCRightsRequiredChecker drcRightsRequiredChecker) {	
	//public @ResponseBody <E extends DRCResponse<? extends A>> E isRightsCheckRequired( @RequestBody DRCRightsRequiredChecker drcRightsRequiredChecker) {	
		
		return new DRCRightsCheckRequiredResponse(drcRequestProducer.isRightsCheckRequired(drcRightsRequiredChecker, drcDao));
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/ask", method=RequestMethod.POST)
	@Valid
	public @ResponseBody <E extends DRCResponse<? extends A>> E askTheQuestion( @RequestBody DRCRequest drcRequest) {	
		E drcResponse = null;
		
		Collection<AppControlParamRequiredFields> appControlParamRequiredFieldsList  = null;
		
		//we have to validate that the applicationName exists in the request and in the DB before we can
		//process the request. This is the only field that requires this special treatment
		if (drcRequest.getConsumingApplicationName() == null) 
			return (E) new DRCRequestError<A>("the request field: consumingApplicationName is missing.");
		else {
			appControlParamRequiredFieldsList  = drcDao.findAllAppControlParamRequiredFields(drcRequest.getConsumingApplicationName());
			AppKeyData appKeyData =  null;
		
			if (!erwsValidator.isDRCRequestValid(drcRequest, 
					appControlParamRequiredFieldsList,
					mltDao)) {
				return (E) new DRCRequestError<A>(erwsValidator.getErrorMessage());
			} else {
				appKeyData = new AppKeyData(erwsValidator.getAppKeyValue(), 
						erwsValidator.getAppKeyField(),
						erwsValidator.getAppKeyDBName());
			
			
				System.out.println("after validation appKeyField/appKeyValue: " + appKeyData.getAppKeyField() + "/" + appKeyData.getAppKeyValue());
			}
		
			//TODO: DRCRequest Validation -- use Bean Validation JSR 303
		
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
