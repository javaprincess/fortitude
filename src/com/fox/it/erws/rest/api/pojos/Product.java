package com.fox.it.erws.rest.api.pojos;

import java.io.Serializable;

public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2252429615683726887L;
	
	private String productTag;
	private Long productId;
	
	public Product(String productTag, Long productId) {
		setProductTag(productTag);
		setProductId(productId);
	}
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductTag() {
		return productTag;
	}
	public void setProductTag(String productTag) {
		this.productTag = productTag;
	}
	
	

}
