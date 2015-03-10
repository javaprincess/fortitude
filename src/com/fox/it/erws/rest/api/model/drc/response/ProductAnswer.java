package com.fox.it.erws.rest.api.model.drc.response;

import java.io.Serializable;
import java.util.List;

import com.fox.it.erws.rest.api.pojos.Answer;

public class ProductAnswer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2482392397481706034L;
	private Long reqProductId;
	private Long reqFoxVersionId;
	private Long reqFoxId;
	private String reqFinProdId;

	private List<Answer> strands;

	public ProductAnswer(Long reqProductId, 
			Long reqFoxVersionId, 
			Long reqFoxId,
			String reqFinProdId,
			List<Answer> answerElementList) {
		setReqProductId(reqProductId);
		setReqFoxVersionId(reqFoxVersionId);
		setReqFoxId(reqFoxId);
		setReqFinProdId(reqFinProdId);
		setStrands(answerElementList);
	}
	
	
	public String getReqFinProdId() {
		return this.reqFinProdId;
	}
	
	private void setReqFinProdId(String reqFinProdId) {
		this.reqFinProdId = reqFinProdId;
		
	}
	
	private void setReqFoxVersionId(Long reqFoxVersionId) {
		this.reqFoxVersionId = reqFoxVersionId;
		
	}
	
	private void setReqFoxId(Long reqFoxId) {
		this.reqFoxId = reqFoxId;
	}
	
	public Long getReqFoxVersionId(){
		return this.reqFoxVersionId;
	}
	
	public Long getReqFoxId() {
		return this.reqFoxId;
	}

	public Long getReqProductId() {
		return reqProductId;
	}
	public void setReqProductId(Long reqProductId) {
		this.reqProductId = reqProductId;
	} 
	public List<Answer> getStrands() {
		return strands;
	}
	public void setStrands(List<Answer> answerElementList) {
		this.strands = answerElementList;
	}
	
}
