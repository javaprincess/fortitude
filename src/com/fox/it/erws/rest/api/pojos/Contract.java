package com.fox.it.erws.rest.api.pojos;


import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




public class Contract implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2781798361787663268L;
	
	@NotNull
	@Size(max=10)
	private Long contractId;
	
	@NotNull
	@Size(max=20)
	private Long titleListId;
	
	private Collection<Title> titles;
	
	public Contract() {
		
	}
	public Contract(Long contractId, Collection<Title> titles) {
		setTitles(titles);
		setContractId(contractId);
	}
	
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}
	
	public Long getContractId() {
		return this.contractId;
	}

	
	public Collection<Title> getTitles() {
		return titles;
	}

	public void setTitles(Collection<Title> titles) {
		this.titles = titles;
	}
	
	@Override
	public String toString() {
		 StringBuilder result = new StringBuilder();
		 String NEW_LINE = System.getProperty("line.separator");

		 result.append(this.getClass().getName());
		 result.append("  {" + NEW_LINE);
		 result.append("     contractId: " + this.contractId);
		
		 
		 Iterator<Title> iterator = titles.iterator();
		 Title tempTitle;
		 while (iterator.hasNext()) {
			 tempTitle = iterator.next();
			 result.append(NEW_LINE);
			 result.append("     Titles: " + tempTitle.toString() );
		 }
		 
		 result.append(NEW_LINE);
		    
		 return result.toString();
	}
	public Long getTitleListId() {
		return titleListId;
	}
	public void setTitleListId(Long titleListId) {
		this.titleListId = titleListId;
	}

}
