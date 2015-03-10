package com.fox.it.erws.rest.api.pojos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public class Title implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6214778602860876315L;
	private Long productId;
	private Long foxId;
	private Long foxVersionId;
	private String finProdId;
	private String withinThroughoutFlag;
	
	private Collection<Strand> strands;

	public Title() {
		
	}
	
	public Title(Long productId) {
		setProductId(productId);
	}
	
	public Title(Long productId,
			Long foxVersionId,
			Long foxId,
			String withinThroughoutFlag,
			String finProdId,
			Collection<Strand> strands) {
		
		setProductId(productId);
		setFoxVersionId(foxVersionId);
		setWithinThroughoutFlag(withinThroughoutFlag);
		setStrands(strands);
		setFoxId(foxId);
		setFinProdId(finProdId);
	}

	public Collection<Strand> getStrands() {
		return strands;
	}

	public void setStrands(Collection<Strand> strands) {
		this.strands = strands;
	}

	public Long tempStrand() {
		return foxVersionId;
	}

	public void setFoxVersionId(Long foxVersionId) {
		this.foxVersionId = foxVersionId;
	}
	
	public Long getFoxVersionId() {
		return this.foxVersionId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public Long getFoxId() {
		return foxId;
	}
	
	public void setFoxId(Long foxId) {
		this.foxId = foxId;
	}
	
	public String getFinProdId() {
		return finProdId;
	}

	public void setFinProdId(String finProdId) {
		this.finProdId = finProdId;
	}
	
	@Override
	public String toString() {
		 StringBuilder result = new StringBuilder();
		 String NEW_LINE = System.getProperty("line.separator");

		 result.append(this.getClass().getName());
		 result.append("  {" + NEW_LINE);
		 result.append("    productId: " + this.productId);
		 result.append(NEW_LINE);
		 result.append("    foxId: " + this.foxId);
		 result.append(NEW_LINE);
		 result.append("    finProdId: " + this.finProdId);
		 result.append(NEW_LINE);
		 result.append("     foxVersionId: " + this.foxVersionId);
		 result.append(NEW_LINE);
		 result.append("     withinThroughoutFlag: " + this.withinThroughoutFlag);
		 result.append(NEW_LINE);
		 /* result.append("     endDate: " + this.endDate); */
		
		 Iterator<Strand> iterator = strands.iterator();
		 Strand tempStrand;
		 while (iterator.hasNext()) {
			 tempStrand = iterator.next();
			 result.append(NEW_LINE);
			 result.append("     Strands: " + tempStrand.toString() );
		 }
		 
		 result.append(NEW_LINE);
		 result.append("  }");
		 
		 return result.toString();
	}

	public String getWithinThroughoutFlag() {
		return withinThroughoutFlag;
	}

	public void setWithinThroughoutFlag(String withinThroughoutFlag) {
		this.withinThroughoutFlag = withinThroughoutFlag;
	}


	
}
