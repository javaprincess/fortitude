package com.fox.it.erws.rest.api.model.drc;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonFormat;


public class DRCRightsCheckRequiredRequest extends DRCRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7247182647837496182L;
	
	private String consumingApplicationName;

	private Long titleListId; 
	
	private Long contractId;
	
	private Long titleListMapId;
	
	private Long titleLicenseRightId;
	
	private Long mltGroupId;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd,HH:00:00", timezone="PST")
	//private Timestamp dateTimeOfLastCheck;
	private String dateTimeOfLastCheck;
	
	private String appKeyField;
	
	public DRCRightsCheckRequiredRequest() {
		
	}
	
	//public DRCRequest(Long requestId, String consumingAppName, Contract contract) {
		
	public DRCRightsCheckRequiredRequest(Long contractId,
			Long titleListId,
			Long titleListMapId,
			Long titlelicenseRightId,
			Long mltGroupId,
			String consumingApplicationName, 
			//Timestamp dateTimeOfLastCheck) {
			String dateTimeOfLastCheck) {
			setTitleListId(titleListId);
			setConsumingApplicationName(consumingApplicationName);
			setDateTimeOfLastCheck(dateTimeOfLastCheck);
			setMltGroupId(mltGroupId);
			setTitleListMapId(titleListMapId);
			setTitleLicenseRightId(titleLicenseRightId);
			setContractId(contractId);
			
	}

	public String getConsumingApplicationName() {
		return consumingApplicationName;
	}

	public void setConsumingApplicationName(String consumingApplicationName) {
		this.consumingApplicationName = consumingApplicationName;
	}

	public Long getTitleListId() {
		return titleListId;
	}

	public void setTitleListId(Long titleListId) {
		this.titleListId = titleListId;
	}

	//public Timestamp getDateTimeOfLastCheck() {
	public String getDateTimeOfLastCheck() {
		return dateTimeOfLastCheck;
	}

	//public void setDateTimeOfLastCheck(Timestamp dateTimeOfLastCheck) {
	public void setDateTimeOfLastCheck(String dateTimeOfLastCheck) {
		this.dateTimeOfLastCheck = dateTimeOfLastCheck;
	}

	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public Long getTitleListMapId() {
		return titleListMapId;
	}

	public void setTitleListMapId(Long titleListMapId) {
		this.titleListMapId = titleListMapId;
	}

	public Long getTitleLicenseRightId() {
		return titleLicenseRightId;
	}

	public void setTitleLicenseRightId(Long titleLicenseRightId) {
		this.titleLicenseRightId = titleLicenseRightId;
	}

	public Long getMltGroupId() {
		return mltGroupId;
	}

	public void setMltGroupId(Long mltGroupId) {
		this.mltGroupId = mltGroupId;
	}

	public String getAppKeyField() {
		return appKeyField;
	}

	public void setAppKeyField(String appKeyField) {
		this.appKeyField = appKeyField;
	}
	
}
