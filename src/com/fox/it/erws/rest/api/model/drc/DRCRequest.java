package com.fox.it.erws.rest.api.model.drc;

import java.io.Serializable;
import com.fox.it.erws.rest.api.pojos.Contract;


public class DRCRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7247182647837496182L;
	
	private Contract contract;

	private Long requestId; 
	
	private String consumingApplicationName;
	
	private Long responseId;
	

	
	public DRCRequest() {
		
	}
		
	public DRCRequest(Long requestId, String consumingAppName, Contract contract) {
			
		setRequestId(requestId);
		setConsumingApplicationName(consumingAppName);
		setContract(contract);
		
	}
	
	
	
	@Override
	public String toString() {
		 StringBuilder result = new StringBuilder();
		 String NEW_LINE = System.getProperty("line.separator");

		 result.append(this.getClass().getName());
		 result.append(" DRCRequest {" + NEW_LINE);
		 result.append("     requestId: " + this.requestId);
		 result.append(NEW_LINE);
		 result.append("     responseId: " + this.responseId);
		 result.append(NEW_LINE);
		 result.append("     consumingApplicationName: " + this.consumingApplicationName);
		 result.append(NEW_LINE);
		 result.append("     Contract: " + this.contract.toString());
		 result.append(NEW_LINE);
		    
		 return result.toString();
	}


	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	} 


	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}


	public String getConsumingApplicationName() {
		return consumingApplicationName;
	}

	public void setConsumingApplicationName(String consumingAppName) {
		this.consumingApplicationName = consumingAppName;
	}

	public Long getResponseId() {
		return this.responseId;
	}
	
	public void setResponseId(Long responseId) {
		this.responseId = responseId;
	}

}
