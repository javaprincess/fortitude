package com.fox.it.erws.rest.api.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ERWSJaxbJacksonObjectMapper extends ObjectMapper {

	/**
	 * 
	 */
	private static final long serialVersionUID = -686473699054233804L;

	public ERWSJaxbJacksonObjectMapper() {

		System.out.println("HELLO ANDREAS MOLINA!!!!");
		
	    this.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
	            .setVisibility(PropertyAccessor.CREATOR, JsonAutoDetect.Visibility.ANY)
	            .setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE)
	            .setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE)
	            .setVisibility(PropertyAccessor.IS_GETTER, JsonAutoDetect.Visibility.NONE);

	    this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	    }
	

}
