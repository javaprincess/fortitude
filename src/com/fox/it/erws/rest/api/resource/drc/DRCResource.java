package com.fox.it.erws.rest.api.resource.drc;

import java.io.Serializable;
import java.util.Collection;



public class DRCResource implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4127728739343334632L;

	private Collection<DRCAnswer> answerList;
	
	
	
	public DRCResource(Collection<DRCAnswer> answerList) {
		this.setAnswerList(answerList);
	}


	public Collection<DRCAnswer> getAnswer() {
		return this.answerList;
	}

	public void setAnswerList(Collection<DRCAnswer> answerList) {
		this.answerList = answerList;
	}


}
