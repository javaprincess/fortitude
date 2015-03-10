package com.fox.it.erws.rest.api.dao;

public class AppKeyData {
	private Long appKeyValue;
	private String appKeyField;
	private String appKeyDBName;
	
	public AppKeyData(Long appKeyValue, String appKeyField, String appKeyDBName) {
		setAppKeyValue(appKeyValue);
		setAppKeyField(appKeyField);
		setAppKeyDBName(appKeyDBName);
		
	}
	
	public String getAppKeyDBName() {
		return appKeyDBName;
	}
	
	public void setAppKeyDBName(String appKeyDBName) {
		this.appKeyDBName = appKeyDBName;
	}
	
	public Long getAppKeyValue() {
		return appKeyValue;
	}
	public void setAppKeyValue(Long appKeyValue) {
		this.appKeyValue = appKeyValue;
	}
	public String getAppKeyField() {
		return appKeyField;
	}
	public void setAppKeyField(String appKeyField) {
		this.appKeyField = appKeyField;
	}
	
	public String toString() {
		 StringBuilder result = new StringBuilder();
		 String NEW_LINE = System.getProperty("line.separator");

		 result.append(this.getClass().getName());
		 result.append(" Object Details {" + NEW_LINE);
		 result.append("     appKeyField: " + this.appKeyField);
		 result.append(NEW_LINE);
		 result.append("     appKeyValue: " + this.appKeyValue);
		 result.append(NEW_LINE);
		 result.append("  }");
		    
		 return result.toString();
	}

}
