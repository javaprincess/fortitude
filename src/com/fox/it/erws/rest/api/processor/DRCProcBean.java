package com.fox.it.erws.rest.api.processor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fox.it.erws.rest.api.dao.AppKeyData;
import com.fox.it.erws.rest.api.dao.DRCDao;
import com.fox.it.erws.rest.api.dao.DRCDaoImpl;
import com.fox.it.erws.rest.api.model.drc.DRCRequest;
import com.fox.it.erws.rest.api.model.drc.response.ProductAnswer;
import com.fox.it.erws.rest.api.pojos.Answer;
import com.fox.it.erws.rest.api.pojos.ConsumingApplicationPOJO;
import com.fox.it.erws.rest.api.pojos.Product;
import com.fox.it.erws.rest.api.pojos.Title;
import com.fox.it.erws.rest.api.util.ERMTime;
import com.fox.it.erws.rest.api.util.Normalizer;



@Service
public class DRCProcBean { 
 
	 protected static Long tLId;
	 protected static String consumingApplicationName;
	 protected static Long appKeyValue;
	 protected static String appKeyField;
	 
	 @Autowired
	 protected static DRCDao drcDao;
	
	 protected Logger log = Logger.getLogger(DRCDaoImpl.class);
	 

  
	 public Collection<ProductAnswer> harmonize(DRCRequest drcRequest, 
			 AppKeyData appKeyData) {
		   
		   Collection<ConsumingApplicationPOJO> consumingAppCollection = null;
		  
		   consumingAppCollection = new Normalizer().denormalize(drcRequest);
		    		 
		   drcDao.remove(appKeyData, drcRequest.getConsumingApplicationName());
    	
		   drcDao.save(consumingAppCollection);
        	
		   System.out.println("timestamp --> start rightsCheck for requestId/responseId: " + drcRequest.getRequestId() + "/" + drcRequest.getResponseId() + " : " + ERMTime.getTime());
        
		   //withinThroughoutFlag is at the title level.  There is a collection of titles per contract
		   Collection<Title> titleCollection = drcRequest.getContract().getTitles();
		   Iterator<Title> titleIter = titleCollection.iterator();
		   while (titleIter.hasNext()) {
			   Title title = titleIter.next();
			   drcDao.rightsCheck(appKeyData.getAppKeyValue(), 
            		title.getWithinThroughoutFlag(), 
            		drcRequest.getConsumingApplicationName());
		   }
      	
		   System.out.println("timestamp --> finished rightsCheck for requestId/responseId: " + drcRequest.getRequestId() + "/" + drcRequest.getResponseId() + " : " + ERMTime.getTime());

		   return new DRCResponseProducer(drcRequest, appKeyData).answerCreation();
          
      }

  
	 static public  class DRCResponseProducer extends DRCProcBean {
		 

    	 private static Long responseId;
    	 private static AppKeyData appKeyData;
    	
    	 public DRCResponseProducer() {
    		 
    	 }
    	 
    	 public DRCResponseProducer(DRCRequest drcRequest,
    			 AppKeyData appKeyData) {
    		 
    		    setConsumingApplicationName(drcRequest.getConsumingApplicationName());
    		    setResponseId(drcRequest.getResponseId());
    		    setAppKeyData(appKeyData);
    	 }
    	 
    	 public Collection<ProductAnswer> answerCreation() { //throws JMSException {
    		 Collection<ProductAnswer> answerCollection = null;
    		 Long runId = 0L;

    		 runId = drcDao.findRunId(appKeyData, getConsumingApplicationName());
    		 
    		 System.out.println("**************************  RUN ID: " + runId + " ******************************");
    		
    		 
    		 if (runId > 0) {
    	    	 Collection<Answer> dbAnswerCollection =   dbAnswerCollection = drcDao.findAnswer(appKeyData,getConsumingApplicationName());
    		    
    		
    		   if (dbAnswerCollection.size() > 0) {
    		  
    		    			
    		    		    Normalizer normalizer = new Normalizer();
    		    		    List<Long> productIdList = null;
    		    		    
    		    		    
    		    		    try {
    		    			    productIdList = drcDao.findProductIds(appKeyData);
    		    			   
    		    		        Collection<Product> productList = new ArrayList<Product>();
    		    		        for (Long productId : productIdList) {
    		    		        	Product product = new Product("productId", productId);
    		    		        	productList.add(product);
    		    		        } 
  
   		    		          answerCollection = normalizer.normalize(productList, 
   		    		        		  dbAnswerCollection, 
   		    		        		  drcDao);
   
    		    		      System.out.println("answerCollectionElement in the DRCProcBean: " + answerCollection.toString()); 
    		    		    	
    		    		     
    		    			  
    		    				
    		    					
    		    			} catch (Exception e) {
    		    				System.out.println("error in creating the message to send" + e.getMessage());
    		    				e.printStackTrace();
    		    			}
    		    		            
    		    			
    	 		      
    		    } //if there is an answer

    	    } //if there is a runId
    		 
 
		    	
    		 return answerCollection;
    		 
    	}  //sendMessage
    	 


		 private static void setAppKeyData(AppKeyData appKeyData) {
			 DRCResponseProducer.appKeyData = appKeyData;
		 }
		 
		 
		 private static String getConsumingApplicationName() {
			 return DRCResponseProducer.consumingApplicationName;
		 }
    
    	 private static void setConsumingApplicationName(String consumingApplicationName) {
    		 DRCResponseProducer.consumingApplicationName = consumingApplicationName;
 		}

		public static Long getResponseId() {
			return responseId;
		}

		public static void setResponseId(Long responseId) {
			DRCResponseProducer.responseId = responseId;
		}
    	
     }
   
  

	public static DRCDao getDrcDao() {
		return drcDao;
	}

	public static void setDrcDao(DRCDao drcDao) {
		DRCProcBean.drcDao = drcDao;
	}

	
	
}