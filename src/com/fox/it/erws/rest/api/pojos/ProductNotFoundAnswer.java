package com.fox.it.erws.rest.api.pojos;

public class ProductNotFoundAnswer extends Answer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -806441822727827070L;

	private String reasonText;
	private int passFlag;
	
	public ProductNotFoundAnswer(String reasonText) {
		setReasonText(reasonText);
	}

	public String getReasonText() {
		return reasonText;
	}

	public void setReasonText(String reasonText) {
		this.reasonText = reasonText;
	}
	
	public void setPassFlag(int passFlag) {
		this.passFlag = passFlag;
	}
	
	public int getPassFlag() {
		return this.passFlag;
	}
}
