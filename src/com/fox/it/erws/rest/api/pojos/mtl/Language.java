package com.fox.it.erws.rest.api.pojos.mtl;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="LNGG")
public class Language extends MTL implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7754091957171034403L;

	@Id
	@Column(name="LNGG_ID")
	private Long languageId;
	
	@Column(name="CRT_NM")
	private String createName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPD_DT")
	private Date updateDate;
	
	@Column(name="UPD_NM")
	private String updateName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CRT_DT")
	private Date createDate;
	
	@Column(name="LNGG_CD")
	private String languageCode;
	
	@Column(name="LNGG_DESC")
	private String languageDesc;
	
	@Column(name="LNGG_BITMAP")
	private String languageBitmap;
	
	@Column(name="ACTV_FLG")
	private String activeFlag;

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getLanguageDesc() {
		return languageDesc;
	}

	public void setLanguageDesc(String languageDesc) {
		this.languageDesc = languageDesc;
	}

	public String getLanguageBitmap() {
		return languageBitmap;
	}

	public void setLanguageBitmap(String languageBitmap) {
		this.languageBitmap = languageBitmap;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
