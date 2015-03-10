package com.fox.it.erws.rest.api.pojos;

import java.io.Serializable;
import java.util.Collection;


public class RightsCheckDetailDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3597780010237726480L;

	private Long rightsCheckDetailId;

	private Long foxVersionId;

	private Long passFailCheckId;

	private Long queryId;

	private String comment;

	private String checkPassFlag;

	private Collection<RightsCheckRestrictionDetailDTO> rightsCheckRestrictionDetail;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@Override
	public String toString() {
		 StringBuilder result = new StringBuilder();
		 String NEW_LINE = System.getProperty("line.separator");

		 result.append(this.getClass().getName());
		 result.append(" Object Details {" + NEW_LINE);
		 result.append("     checkPassFlag: " + this.checkPassFlag);
		 result.append(NEW_LINE);
		 result.append("     foxVersionId: " + this.foxVersionId);
		 result.append(NEW_LINE);
		 result.append("     queryId: " + this.queryId);
		 result.append(NEW_LINE);
		 result.append("     passFailCheckId: " + this.passFailCheckId);
		 result.append(NEW_LINE);
		 result.append("  }");
		    
		 return result.toString();
	}

	public Long getFoxVersionId() {
		return foxVersionId;
	}

	public void setFoxVersionId(Long foxVersionId) {
		this.foxVersionId = foxVersionId;
	}

	public Long getQueryId() {
		return queryId;
	}

	public void setQueryId(Long queryId) {
		this.queryId = queryId;
	}

	public Long getRightsCheckDetailId() {
		return rightsCheckDetailId;
	}

	public void setRightsCheckDetailId(Long rightsCheckDetailId) {
		this.rightsCheckDetailId = rightsCheckDetailId;
	}

	public Long getPassFailCheckId() {
		return passFailCheckId;
	}

	public void setPassFailCheckId(Long passFailCheckId) {
		this.passFailCheckId = passFailCheckId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCheckPassFlag() {
		return checkPassFlag;
	}

	public void setCheckPassFlag(String checkPassFlag) {
		this.checkPassFlag = checkPassFlag;
	}

	public Collection<RightsCheckRestrictionDetailDTO> getRightsCheckRestrictionDetail() {
		return this.rightsCheckRestrictionDetail;
	}
	
	public void setRightsCheckRestrictionDetailDTO(Collection<RightsCheckRestrictionDetailDTO> rightsCheckRestrictionDetailDTO) {
		this.rightsCheckRestrictionDetail = rightsCheckRestrictionDetailDTO;
	}
	
}
