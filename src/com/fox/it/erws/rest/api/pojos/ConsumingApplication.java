package com.fox.it.erws.rest.api.pojos;

import java.util.Date;

public interface ConsumingApplication {

	public  Long getId();
	public  void setId(Long id);
	public   Long getTitleListId();
	public  String getConsumingApplicationName();
	public  void setRunId(Long runId);
	public  Long getRunId();
	public  String getResponseId();
	public  Long getRequestId();
	public  Long getContractId();
	public  Long getMediaId();
	public  Long getTerritoryId();
	public  Long getLanguageId();
	public  Long getReqFoxId();
	public  String getReqFinProdId();
	public  Long getReqProductId();
	public  Long getTitleListMapId();
	public  Long getTitleLicenseRightId();
	public  Long getMltGroupId();
	public  Long getReqFoxVersionId();
	public  String getInternetOpenIndicator();
	public  String getInternetClosedIndicator();
	public  String getMobileCellWirelessIndicator();
	public  Date getEndDate();
	public  Date getStartDate();
	public  void setReqFoxVersionId(Long reqFoxversionId);
	public  void setContractId(Long contractId);
	public  void setTitleListId(Long titleListId);
	public  void setRequestId(Long requestId);
	public  void setResponseId(String responseId);
	public  void setConsumingApplicationName(String consumingApplicationName);
	public  void setMediaId(Long mediaId);
	public  void setTerritoryId(Long territoryId);
	public  void setLanguageId(Long languageId);
	public  void setReqFoxId(Long reqFoxId);
	public  void setReqFinProdId(String reqFinProdId);
	public  void setReqProductId(Long reqProductId);
	public  void setInternetOpenIndicator(String internetOpenIndicator);
	public  void setInternetClosedIndicator(String internetClosedIndicator);
	public  void setMobileCellWirelessIndicator(String mobileCellWirelessIndicator);
	public  void setStartDate(Date startDate);
	public  void setEndDate(Date endDate);
	public  void setTitleLicenseRightId(Long titleLicenseRightId);
	public  void setMltGroupId(Long mltGroupId);
	public  void setTitleListMapId(Long titleListMapId);

	
}
