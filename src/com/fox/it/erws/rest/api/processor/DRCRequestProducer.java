package com.fox.it.erws.rest.api.processor;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fox.it.erws.rest.api.dao.AppKeyData;
import com.fox.it.erws.rest.api.dao.DRCDao;
import com.fox.it.erws.rest.api.model.drc.DRCRequest;
import com.fox.it.erws.rest.api.model.drc.DRCResponse;
import com.fox.it.erws.rest.api.model.drc.DRCRightsCheckRequiredRequest;
import com.fox.it.erws.rest.api.model.drc.response.ProductAnswer;
import com.fox.it.erws.rest.api.service.ERWSException;

@Component
public class DRCRequestProducer  {
    @Autowired
	private DRCProcBean drcProcBean;
	
    public DRCRequestProducer() {}
    
   
    
    public boolean isRightsCheckRequired(DRCRightsCheckRequiredRequest DRCRightsCheckRequiredRequest,
    		DRCDao drcDao,
    		Long appKeyValue) {
    	return drcDao.isRightsCheckRequired(DRCRightsCheckRequiredRequest, appKeyValue);
    }
    

	public DRCResponse<ProductAnswer> processRequest(DRCRequest drcRequest,
    		AppKeyData appKeyData) throws ERWSException {

		DRCResponse<ProductAnswer> drcResponse = new DRCResponse<ProductAnswer>();		
    	
		Collection<ProductAnswer> answerCollection = drcProcBean.harmonize(drcRequest, appKeyData); 
		
		drcResponse.setResponseId(drcRequest.getResponseId());
		drcResponse.setAnswer(answerCollection);
    		
    		

    	
    	
    	return drcResponse;
    	
    }



}
