package com.fox.it.erws.rest.api.processor;

import java.util.Collection;
import java.util.List;

import com.fox.it.erws.rest.api.dao.DRCDao;
import com.fox.it.erws.rest.api.model.drc.response.ProductAnswer;
import com.fox.it.erws.rest.api.pojos.Answer;

public  class DRCResponseProducer  {
	 
	 private final DRCDao drcDao;
	 private final  AnswerResponseConverter answerResponseConverter;	
	
	 public DRCResponseProducer(DRCDao drcDao) {
		 this.drcDao = drcDao;
		 answerResponseConverter = new AnswerResponseConverter(drcDao);		 
	 }

	 public Collection<ProductAnswer> answerCreation(String applicationName, String applicationFieldName,Long applicationValue) { 
		 // answerCollection = null;

		 Long runId = drcDao.findRunId(applicationName, applicationValue);
		 
		
		 
		 if (runId > 0) {
	    	 Collection<Answer> dbAnswerCollection = drcDao.findAnswer(applicationName,applicationValue);
		    
		
		   if (dbAnswerCollection.size() > 0) {
			   List<ProductAnswer> productAnswers =answerResponseConverter.convert(dbAnswerCollection);
			   return productAnswers;
		    			
	 		      
		    } //if there is an answer

	    } //if there is a runId
		 return null;
		 
	} 

	 
	 
//	 public Collection<ProductAnswer> answerCreation(String applicationName, String applicationFieldName,Long applicationValue) { 
//		 // answerCollection = null;
//
//		 Long runId = drcDao.findRunId(applicationName, applicationValue);
//		 
//		
//		 
//		 if (runId > 0) {
//	    	 Collection<Answer> dbAnswerCollection = drcDao.findAnswer(applicationName,applicationValue);
//		    
//		
//		   if (dbAnswerCollection.size() > 0) {
//		  
//		    			
//		    		    Normalizer normalizer = new Normalizer();
//		    		    List<Long> productIdList = null;
//		    		    
//		    		    
//		    		    try {
//		    			    productIdList = drcDao.findProductIds(applicationName,applicationFieldName,applicationValue);
//		    			   
//		    		        Collection<Product> productList = new ArrayList<Product>();
//		    		        for (Long productId : productIdList) {
//		    		        	Product product = new Product("productId", productId);
//		    		        	productList.add(product);
//		    		        } 
//
//		    		        Collection<ProductAnswer>  answerCollection = normalizer.normalize(productList, 
//		    		        		  dbAnswerCollection, 
//		    		        		  drcDao);
//
//		    		      System.out.println("answerCollectionElement in the DRCProcBean: " + answerCollection.toString()); 
//		    		    	
//		    		      return answerCollection;
//		    			  
//		    				
//		    					
//		    			} catch (Exception e) {
//		    				System.out.println("error in creating the message to send" + e.getMessage());
//		    				e.printStackTrace();
//		    			}
//		    		            
//		    			
//	 		      
//		    } //if there is an answer
//
//	    } //if there is a runId
//		 
//
//	    	
//		 return null;
//		 
//	}  //sendMessage
	
}
