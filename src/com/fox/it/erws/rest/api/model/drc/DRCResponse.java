package com.fox.it.erws.rest.api.model.drc;

//This is one of the entry points for consumers interested in using this api
//This is a swagger resource

import java.io.Serializable;
import java.util.Collection;



public  class  DRCResponse<A> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1158875658864154491L;
	private Long responseId;
	private Collection<? extends A> answer;
	

	public DRCResponse() {}
	
	
	public DRCResponse(Long responseId) {
		setResponseId(responseId);
	}
	

	public Long getResponseId() {
		return responseId;

	}
	
	public void setResponseId(Long responseId) {
		this.responseId = responseId;
	}
	
	public void setAnswer(Collection<? extends A> answer) {
		this.answer = answer;
	}
	
	public Collection<? extends A> getAnswer() {
		return this.answer;
	}

}
