package com.fox.it.erws.rest.api.annotations.validators;


import javax.validation.Constraint;

@Constraint(validatedBy = DRCValidator.class)
public @interface DRCRequestValidator {
	 String message() default "{com.fox.it.erws.rest.api.model.drc.DRCRequest}";
}