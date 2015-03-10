package com.fox.it.erws.rest.enums;


public enum SemanticLinks {
	
			SUMMARY("/erws/drc/answer/summary?id="),
			DETAILS("/erws/drc/answer/details?id="),
			RESTRICTION_DETAILS("/erws/drc/answer/restriction/details?id=");
		
			
			
			private final String link;
			
			
			private SemanticLinks(String link) {
				this.link = link;
			}
			
			
			public String getLink() {
				return this.link;
			}
			
			

}
