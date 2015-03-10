package com.fox.it.erws.rest.api.annotations.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DRCValidator implements ConstraintValidator<DRCRequestValidator, String> {
		 
	    public void initialize(DRCRequestValidator validator) {
	       System.out.println("in DRCValidator.initialize");
	    }
	 
	    public boolean isValid(String value, ConstraintValidatorContext context) {
	        System.out.println("in DRCValidator.isValid");
	    	return false; 
	    }


}
