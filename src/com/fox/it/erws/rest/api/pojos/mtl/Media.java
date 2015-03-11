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
@Table(name="MEDIA")
public class Media extends MTL implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6932026180428435370L;

	@Id
	@Column(name="MEDIA_ID")
	private Long mediaId;
	
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
	
	@Column(name="MEDIA_CD")
	private String mediaCode;
	
	@Column(name="MEDIA_DESC")
	private String mediaDesc;
	
	@Column(name="MEDIA_BITMAP")
	private String mediaBitmap;
	
	@Column(name="MEDIA_LGL_NOTE")
	private String mediaLegalNote;
	
	@Column(name="MEDIA_BSNS_NOTE")
	private String mediaBusinessNote;
	
	@Column(name="ACTV_FLG")
	private String activeFlag;

	public Long getMediaId() {
		return mediaId;
	}

	public void setMediaId(Long mediaId) {
		this.mediaId = mediaId;
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

	public String getMediaCode() {
		return mediaCode;
	}

	public void setMediaCode(String mediaCode) {
		this.mediaCode = mediaCode;
	}

	public String getMediaDesc() {
		return mediaDesc;
	}

	public void setMediaDesc(String mediaDesc) {
		this.mediaDesc = mediaDesc;
	}

	public String getMediaBitmap() {
		return mediaBitmap;
	}

	public void setMediaBitmap(String mediaBitmap) {
		this.mediaBitmap = mediaBitmap;
	}

	public String getMediaLegalNote() {
		return mediaLegalNote;
	}

	public void setMediaLegalNote(String mediaLegalNote) {
		this.mediaLegalNote = mediaLegalNote;
	}

	public String getMediaBusinessNote() {
		return mediaBusinessNote;
	}

	public void setMediaBusinessNote(String mediaBusinessNote) {
		this.mediaBusinessNote = mediaBusinessNote;
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

