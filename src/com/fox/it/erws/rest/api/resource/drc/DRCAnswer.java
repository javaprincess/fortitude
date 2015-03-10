package com.fox.it.erws.rest.api.resource.drc;

import java.io.Serializable;

import com.fox.it.erws.rest.api.pojos.Answer;
import com.fox.it.erws.rest.api.pojos.Contract;
import com.fox.it.erws.rest.api.pojos.Title;




 public class DRCAnswer extends Answer implements Serializable {
	//wrapper around the Answer object
	/**
	 * 
	 */
	private static final long serialVersionUID = 1958190854821137820L;
	private Title title;
	private Contract contract;
	
	public DRCAnswer(Title title) {
		setTitle(title);
	}
	
	public DRCAnswer() {
		
	}

	public Contract getContract() {
		return contract;
	}
	
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}

	@Override
	public void setReasonText(String reasonText) {

		
	}

	@Override
	public String getReasonText() {
		return null;
	}

	@Override
	public int getPassFlag() {
		return 0;
	}

	@Override
	public void setPassFlag(int passFlag) {

		
	}

	

}
