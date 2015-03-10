package com.fox.it.erws.rest.enums;


public enum Expiration {
	
			DRC_ANSWERQUEUE_MESSAGE_EXPIRATION(360000L),  //1 hour
			ALLOCATION_SIZE(1000L);
			
			private final Long expiration;
			
			private Expiration(Long expiration) {
				this.expiration = expiration;
			}
			
			public Long getExpiration() {
				return expiration;
			}
		


}
