package com.fox.it.erws.rest.api.config;

import org.springframework.beans.factory.annotation.Value;

public class ERWSConfiguration {

	@Value("${hostname}")
	private String hostname;
	
	public String getHostname() {
		return this.hostname;
	}
	
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
}
