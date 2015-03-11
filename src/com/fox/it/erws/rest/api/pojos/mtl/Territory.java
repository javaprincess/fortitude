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
@Table(name="TRRTRY")
public class Territory extends MTL implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2636078110123192586L;

	@Id
	@Column(name="TRRTRY_ID")
	private Long territoryId;
	
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
	
	@Column(name="TRRTRY_CD")
	private String territoryCode;
	
	@Column(name="TRRTRY_DESC")
	private String territoryDesc;
	
	@Column(name="TRRTRY_BITMAP")
	private String territoryBitmap;
	
	@Column(name="ACCT_CD")
	private String accountCode;
	
	@Column(name="SLSMN_ID")
	private String slsmnId;
	
	@Column(name="TRRTRY_LGL_NOTE")
	private String territoryLegalNote;
	
	@Column(name="TRRTRY_BSNS_NOTE")
	private String territoryBusinessNote;
	
	@Column(name="ACTV_FLG")
	private String activeFlag;

	public Long getTerritoryId() {
		return territoryId;
	}

	public void setTerritoryId(Long territoryId) {
		this.territoryId = territoryId;
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

	public String getTerritoryCode() {
		return territoryCode;
	}

	public void setTerritoryCode(String territoryCode) {
		this.territoryCode = territoryCode;
	}

	public String getTerritoryDesc() {
		return territoryDesc;
	}

	public void setTerritoryDesc(String territoryDesc) {
		this.territoryDesc = territoryDesc;
	}

	public String getTerritoryBitmap() {
		return territoryBitmap;
	}

	public void setTerritoryBitmap(String territoryBitmap) {
		this.territoryBitmap = territoryBitmap;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getSlsmnId() {
		return slsmnId;
	}

	public void setSlsmnId(String slsmnId) {
		this.slsmnId = slsmnId;
	}

	public String getTerritoryLegalNote() {
		return territoryLegalNote;
	}

	public void setTerritoryLegalNote(String territoryLegalNote) {
		this.territoryLegalNote = territoryLegalNote;
	}

	public String getTerritoryBusinessNote() {
		return territoryBusinessNote;
	}

	public void setTerritoryBusinessNote(String territoryBusinessNote) {
		this.territoryBusinessNote = territoryBusinessNote;
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
