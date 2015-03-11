package com.fox.it.erws.rest.api.pojos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="APP_PROD_LIST_RGHTS_CHK")
public class ProductList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4105737567869951864L;

	@Id	
	@Column(name="RUN_ID")
	private Long runId;
	
	@Column(name="CRT_NM")
	private String createName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CRT_DT")
	private Date createDate;
	
	@Column(name="UPD_NM")
	private String updateName;
	
	@Column(name="PROD_LIST_ID")
	private Long productListId;
	
	@Column(name="STS_DESC")
	private String statusDescription;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="STRT_TM")
	private Date startTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="END_TM")
	private Date endTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="MSG")
	private Date message;
	
	@Column(name="APP_NM")
	private String appName;

	public Long getRunId() {
		return runId;
	}

	public void setRunId(Long runId) {
		this.runId = runId;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public Long getProductListId() {
		return productListId;
	}

	public void setProductListId(Long productListId) {
		this.productListId = productListId;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getMessage() {
		return message;
	}

	public void setMessage(Date message) {
		this.message = message;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}
}
