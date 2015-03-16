package com.fox.it.erws.rest.api.util;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fox.it.erws.rest.api.model.drc.DRCRequest;
import com.fox.it.erws.rest.api.pojos.ConsumingApplicationPOJO;
import com.fox.it.erws.rest.api.pojos.Contract;
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
	   

}
