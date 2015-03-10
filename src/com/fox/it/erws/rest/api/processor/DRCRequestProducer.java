package com.fox.it.erws.rest.api.processor;


import java.util.Collection;

import org.springframework.stereotype.Component;

import com.fox.it.erws.rest.api.dao.AppKeyData;
import com.fox.it.erws.rest.api.dao.DRCDao;
import com.fox.it.erws.rest.api.model.drc.DRCRequest;
import com.fox.it.erws.rest.api.model.drc.DRCResponse;
import com.fox.it.erws.rest.api.model.drc.DRCRightsRequiredChecker;
import com.fox.it.erws.rest.api.model.drc.response.ProductAnswer;

@Component
public class DRCRequestProducer  {
	
	private String errorMessage = null;
	
    private DRCResponse<ProductAnswer> drcResponse;

   
    public DRCRequestProducer() {}
    
   
    
    public boolean isRightsCheckRequired(DRCRightsRequiredChecker drcRightsRequiredChecker,
    		DRCDao drcDao) {
    	System.out.println("drcRightsRequiredChecker's date of last request: " + drcRightsRequiredChecker.getDateTimeOfLastCheck());
    	return drcDao.isRightsCheckRequired(drcRightsRequiredChecker);
    }
    

	public DRCResponse<ProductAnswer> processRequest(DRCRequest drcRequest,
    		AppKeyData appKeyData) {

    	Collection<ProductAnswer> answerCollection = null;

    	
    	try {
    	
    		answerCollection = new DRCProcBean().harmonize(drcRequest, appKeyData);
    		this.drcResponse = new DRCResponse<ProductAnswer>();
    		
    		this.drcResponse.setResponseId(drcRequest.getResponseId());
    		this.drcResponse.setAnswer(answerCollection);
    		
    		
    	} catch (Exception jmsException) {
    		
			setErrorMessage("Contact ERM IT.  A severe error has occurred.");
		    
    		System.out.println(jmsException.getMessage());
    	}
    	
    	
    	return drcResponse;
    	
    }


	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
