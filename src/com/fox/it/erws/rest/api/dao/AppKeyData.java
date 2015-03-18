package com.fox.it.erws.rest.api.dao;

public class AppKeyData {
	private Long appKeyValue;
	private String appKeyField;
	private String appKeyDBName;
	private String titleKeyField;
	
	
	public AppKeyData(Long appKeyValue, String appKeyField, String appKeyDBName,String titleKeyField) {
		setAppKeyValue(appKeyValue);
		setAppKeyField(appKeyField);
		setAppKeyDBName(appKeyDBName);
		setTitleKeyField(titleKeyField);
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
	
	public String getTitleKeyField() {
		return titleKeyField;
	}

	public void setTitleKeyField(String titleKeyField) {
		this.titleKeyField = titleKeyField;
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
