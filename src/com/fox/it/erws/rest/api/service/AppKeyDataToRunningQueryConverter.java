package com.fox.it.erws.rest.api.service;

import com.fox.it.erws.rest.api.dao.AppKeyData;

public class AppKeyDataToRunningQueryConverter {

	public AppKeyDataToRunningQueryConverter() {
	}
	
	public static ApplicationQuery get(String applicationName,AppKeyData appKeyData) {
		ApplicationQuery applicationQuery = new ApplicationQuery(applicationName,(Long) appKeyData.getAppKeyValue());
		return applicationQuery;
	}

}
