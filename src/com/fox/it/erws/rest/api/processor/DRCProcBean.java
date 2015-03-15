package com.fox.it.erws.rest.api.processor;

import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fox.it.erws.rest.api.dao.AppKeyData;
import com.fox.it.erws.rest.api.dao.DRCDao;
import com.fox.it.erws.rest.api.dao.DRCDaoImpl;
import com.fox.it.erws.rest.api.model.drc.DRCRequest;
import com.fox.it.erws.rest.api.model.drc.response.ProductAnswer;
import com.fox.it.erws.rest.api.pojos.ConsumingApplicationPOJO;
import com.fox.it.erws.rest.api.pojos.Title;
import com.fox.it.erws.rest.api.util.ERMTime;
import com.fox.it.erws.rest.api.util.Normalizer;



@Service
public class DRCProcBean { 
 
	 
	 @Autowired
	 protected  DRCDao drcDao;
	
	 protected Logger log = Logger.getLogger(DRCDaoImpl.class);
	 
	 private void prepareDRCCheck(String applicationName,AppKeyData appKeyData) {
		   drcDao.remove(appKeyData, applicationName);
		 
	 }
	 
	 private void saveQuery(DRCRequest drcRequest) {
		   Collection<ConsumingApplicationPOJO> consumingAppCollection = new Normalizer().denormalize(drcRequest);	    	
		   drcDao.save(consumingAppCollection);
		 
	 }
	 
	 private void doDrc(DRCRequest drcRequest,Long appKeyValue) {
		   //withinThroughoutFlag is at the title level.  There is a collection of titles per contract
		   Collection<Title> titleCollection = drcRequest.getContract().getTitles();
		   Iterator<Title> titleIter = titleCollection.iterator();
		   while (titleIter.hasNext()) {
			   Title title = titleIter.next();
			   drcDao.rightsCheck(appKeyValue, 
          		title.getWithinThroughoutFlag(), 
          		drcRequest.getConsumingApplicationName());
		   }
    	
		   System.out.println("timestamp --> finished rightsCheck for requestId/responseId: " + drcRequest.getRequestId() + "/" + drcRequest.getResponseId() + " : " + ERMTime.getTime());
	 }
	 

	 private Collection<ProductAnswer> getResponse(String applicationName,String appKeyFieldName,Long applicationValue) {
		 DRCResponseProducer responseProducer = new DRCResponseProducer(drcDao);
		 return responseProducer.answerCreation(applicationName, appKeyFieldName,applicationValue);
		 
	 }
	 
	 public Collection<ProductAnswer> harmonize(DRCRequest drcRequest, 
			 AppKeyData appKeyData) {
		    Long applicationValue = appKeyData.getAppKeyValue(); 
		    String applicationName = drcRequest.getConsumingApplicationName();
		    String appKeyFieldName = appKeyData.getAppKeyField();
		    prepareDRCCheck(drcRequest.getConsumingApplicationName(), appKeyData);
		    saveQuery(drcRequest);
        	
		    System.out.println("timestamp --> start rightsCheck for requestId/responseId: " + drcRequest.getRequestId() + "/" + drcRequest.getResponseId() + " : " + ERMTime.getTime());
		    doDrc(drcRequest, applicationValue);
		    
		    Collection<ProductAnswer> response = getResponse(applicationName,appKeyFieldName,applicationValue);
		    return response;
      }

	public DRCDao getDrcDao() {
		return drcDao;
	}

	public void setDrcDao(DRCDao drcDao) {
		this.drcDao = drcDao;
	}

  
  
	
	
}