package com.fox.it.erws.rest.api.validation;

import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;

public interface NodeVisitor {
	public void visit(AppControlParamRequiredFields controlParamObj,Object value);
}
