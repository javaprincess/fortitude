package com.fox.it.erws.rest.api.model.drc.response;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9069805280611921366L;
	
	private List<ProductAnswer> answer;

	public List<ProductAnswer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<ProductAnswer> answer) {
		this.answer = answer;
	}
	
}
