package com.fox.it.erws.rest.api.validation;

import com.fox.it.erws.rest.api.dao.AppKeyData;
import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;

public class AppKeyAccumulatorVisitor implements NodeVisitor {
	private String appKeyField;
	private Long appKeyValue;
	private String appKeyDBName;
	private String titleKeyField;
	
	public AppKeyAccumulatorVisitor() {
	}

	@Override
	public void visit(AppControlParamRequiredFields controlParamObj,
			Object value) {
		String webServiceFieldName = controlParamObj.getWebServiceRequiredFieldName();
		if (controlParamObj.getAppKeyFieldFlag().equals("Y")) {
			setAppKeyField(webServiceFieldName);
			
			setAppKeyValue(new Long(value.toString()));
			setAppKeyDBName(controlParamObj.getFieldName());
		}
		if (controlParamObj.isTitle()) {
			setTitleKeyField(webServiceFieldName);
		}

	}
	
	public AppKeyData getAppKeyData() {
		return new AppKeyData(appKeyValue,appKeyField,appKeyDBName,titleKeyField);
	}

	public String getAppKeyField() {
		return appKeyField;
	}

	public void setAppKeyField(String appKeyField) {
		this.appKeyField = appKeyField;
	}

	public Long getAppKeyValue() {
		return appKeyValue;
	}

	public void setAppKeyValue(Long appKeyValue) {
		this.appKeyValue = appKeyValue;
	}

	public String getAppKeyDBName() {
		return appKeyDBName;
	}

	public void setAppKeyDBName(String appKeyDBName) {
		this.appKeyDBName = appKeyDBName;
	}

	public String getTitleKeyField() {
		return titleKeyField;
	}

	public void setTitleKeyField(String titleKeyField) {
		this.titleKeyField = titleKeyField;
	}
	
	
	
	

}
