package com.fox.it.erws.rest.api.util;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.fox.it.erws.rest.api.dao.DRCDao;
import com.fox.it.erws.rest.api.model.drc.DRCRequest;
import com.fox.it.erws.rest.api.model.drc.response.ProductAnswer;
import com.fox.it.erws.rest.api.pojos.Answer;
import com.fox.it.erws.rest.api.pojos.ConsumingApplicationPOJO;
import com.fox.it.erws.rest.api.pojos.Contract;
import com.fox.it.erws.rest.api.pojos.Product;
import com.fox.it.erws.rest.api.pojos.RightsCheckDetail;
import com.fox.it.erws.rest.api.pojos.Strand;
import com.fox.it.erws.rest.api.pojos.Title;

public class Normalizer {

	   public Collection<ConsumingApplicationPOJO> denormalize(DRCRequest drcRequest) {
		   
		   String consumingApplicationName = drcRequest.getConsumingApplicationName();
		   Long requestId = drcRequest.getRequestId();
		   Long responseId = drcRequest.getResponseId();

		   Collection<ConsumingApplicationPOJO> caCollection =  new ArrayList<ConsumingApplicationPOJO>();
		   
		   Contract contract = drcRequest.getContract();
		   Collection<Title> titles = contract.getTitles();
		   
		   Iterator<Title> titleIter = titles.iterator();

		   while (titleIter.hasNext()) {
			   Title title = titleIter.next();

			   Collection<Strand> strands = title.getStrands();
			   Iterator<Strand> strandIter = strands.iterator();
			   
			   while (strandIter.hasNext()) {
				   ConsumingApplicationPOJO caPOJO = new ConsumingApplicationPOJO();
				   
				   //BASE level data
				   caPOJO.setRequestId(requestId);
				   caPOJO.setResponseId(responseId);
				   caPOJO.setConsumingApplicationName(consumingApplicationName);
				   caPOJO.setContractId(contract.getContractId());
				   caPOJO.setTitleListId(contract.getTitleListId());
				   		   
				   //TITLE level data
				   caPOJO.setReqProductId(title.getProductId());
				   caPOJO.setReqFoxVersionId(title.getFoxVersionId());
				   caPOJO.setReqFinProdId(title.getFinProdId());
				   caPOJO.setReqFoxId(title.getFoxId());
				   
				   //STRAND level data
				   Strand strand = strandIter.next();
				   caPOJO.setMediaId(strand.getMediaId());
				   caPOJO.setMltGroupId(strand.getMltGroupId());
				   caPOJO.setLanguageId(strand.getLanguageId());
				   caPOJO.setTerritoryId(strand.getTerritoryId());
				   caPOJO.setTitleListMapId(strand.getTitleListMapId());
				   caPOJO.setTitleLicenseRightId(strand.getTitleLicenseRightId());
				   caPOJO.setMobileCellWirelessIndicator(strand.getMobileCellWirelessIndicator());
				   caPOJO.setInternetOpenIndicator(strand.getInternetOpenIndicator());
				   caPOJO.setInternetClosedIndicator(strand.getInternetClosedIndicator());
				   caPOJO.setStartDate(strand.getStartDate());
				   caPOJO.setEndDate(strand.getEndDate());
				   
				   //Add the POJO to the collection
				   caCollection.add(caPOJO);
			   }
			   
		   }

			return caCollection;
		   
	   }
	   
//	   private Answer setAnswerDetails(Answer answerElement, DRCDao drcDao) {
//		   Answer answer = answerElement;
//		   
//		   Long queryId = answer.getQueryId();
//		   if (queryId != null) {
//			   Collection<RightsCheckDetail> rightsCheckDetail = drcDao.findRightsCheckDetail(answer.getQueryId());
//		   
//			   Iterator<RightsCheckDetail> rightsCheckDetailIter = rightsCheckDetail.iterator();
//			   while (rightsCheckDetailIter.hasNext()) {
//
//				   RightsCheckDetail rCD = rightsCheckDetailIter.next();
//			   
//				   rCD.setRightsCheckRestrictionDetail(drcDao.findRightsCheckRestrictionDetail(answer.getQueryId()));
//			   
//				   answer.setRightsCheckDetail(rightsCheckDetail);
//			   }
//		   }
//		  
//		   return answer;
//	   }
	   

//		public Collection<ProductAnswer> normalize(Collection<Product> productList, 
//				Collection<Answer> dbAnswerCollection, 
//				DRCDao drcDao) {
//			
//			Collection<ProductAnswer> productAnswerCollection = new ArrayList<ProductAnswer>();
//			
//			ProductAnswer productAnswer  =  null;
//			
//			Long previousPiD = null;
//			Long currentPiD = null;
//			
//			Long currentFvId = 0L;
//			Long previousFvId = 0L;
//			Long currentFiD = 0L;
//			Long previousFiD = 0L;
//			String currentFPiD = null;
//			String previousFPiD = null;
//			
//			
//			List<Answer> answerElementList = null;
//			int collectionSize = dbAnswerCollection.size();
//			int collectionCounter = 0;
//			
//			for (Answer answerElement : dbAnswerCollection) {
//				
//					//TODO: check the DB config to determine if app wants the fat answer or the skinny answer
//					answerElement = setAnswerDetails(answerElement, drcDao);
//					
//					collectionCounter++;
//		
//					//TODO figure out why is this a string
//					currentPiD = answerElement.getReqProductId();
//					currentFvId = answerElement.getReqFoxVersionId();
//					currentFiD = answerElement.getReqFoxId();
//					currentFPiD = answerElement.getReqFinProdId();
//					
//					
//					
//					if (previousPiD == null) {//create a new List
//						answerElementList = new ArrayList<Answer>();
//						answerElementList.add(answerElement);
//						previousPiD = currentPiD;
//						previousFvId = currentFvId;
//						previousFiD = currentFiD;
//						previousFPiD = currentFPiD;
//						
//						System.out.println("answerElementList.size() in init: " + answerElementList.size());
//						
//						//if no more elements, add to the collection
//						if (collectionCounter == collectionSize) {
//							System.out.println("we are at the end -- reqFoxVersionId: " + answerElement.getReqFoxVersionId());
//							productAnswer = new ProductAnswer(currentPiD, 
//									currentFvId,
//									currentFiD,
//									currentFPiD,
//									answerElementList); 
//							productAnswerCollection.add(productAnswer);
//						}
//							
//					} else if (previousPiD.equals(currentPiD)) {
//						previousPiD = currentPiD;
//						previousFvId = currentFvId;
//						previousFiD = currentFiD;
//						previousFPiD = currentFPiD;
//						
//						answerElementList.add(answerElement);
//						System.out.println("answerElementList.size() in equality: " + answerElementList.size());
//						
//						//if no more elements, add to the collection
//						if (collectionCounter == collectionSize) {
//							
//							productAnswer = new ProductAnswer(currentPiD, 
//									currentFvId,
//									currentFiD,
//									currentFPiD,
//									answerElementList);
//							
//							System.out.println("we are at the 2nd end productAnswer: " + productAnswer.toString());
//							productAnswerCollection.add(productAnswer);
//						}
//					} else {
//						//save the old list
//						productAnswer = new ProductAnswer(previousPiD, 
//								previousFvId,
//								previousFiD,
//								previousFPiD,
//								answerElementList);
//						
//						productAnswerCollection.add(productAnswer);
//						
//						//the pids don't equal, but we are at the end of the list
//						//start a new list for the new PiD
//						answerElementList = new ArrayList<Answer>();
//						answerElementList.add(answerElement);
//						
//						//let's set previous to current
//						previousPiD = currentPiD;
//						previousFvId = currentFvId;
//						previousFiD = currentFiD;
//						previousFPiD = currentFPiD;
//			
//						
//						if (collectionCounter == collectionSize) {
//							
//							productAnswer = new ProductAnswer(currentPiD, 
//									currentFvId,
//									currentFiD,
//									currentFPiD,
//									answerElementList);
//							
//							System.out.println("we are at the 2nd end productAnswer: " + productAnswer.toString());
//							productAnswerCollection.add(productAnswer);
//						}
//						
//					}
//					
//					
//			} //for
//			
//			return productAnswerCollection;
//	}

}
