package com.fox.it.erws.rest.api.validation;

import com.fox.it.erws.rest.api.dao.AppKeyData;
import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;

public class AppKeyAccumulatorVisitor implements NodeVisitor {
	private String appKeyField;
	private Long appKeyValue;
	private String appKeyDBName;
	
	public AppKeyAccumulatorVisitor() {
	}

	@Override
	public void visit(AppControlParamRequiredFields controlParamObj,
			Object value) {
		if (controlParamObj.getAppKeyFieldFlag().equals("Y")) {
			setAppKeyField(controlParamObj.getWebServiceRequiredFieldName());
			System.out.println("getAppKeyField: " + getAppKeyField());
			
			setAppKeyValue(new Long(value.toString()));
			setAppKeyDBName(controlParamObj.getFieldName());
		}

	}
	
	public AppKeyData getAppKeyData() {
		return new AppKeyData(appKeyValue,appKeyField,appKeyDBName);
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
	
	

}
