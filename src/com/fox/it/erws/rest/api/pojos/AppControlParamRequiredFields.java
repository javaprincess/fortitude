package com.fox.it.erws.rest.api.pojos;

import java.sql.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Cacheable(false)
@Entity
@Table(name="APP_CTRL_PARAM_REQ_FLDS")
public class AppControlParamRequiredFields {

		@Id
		@Column(name="ID")
		private Long id;
		
		@Column(name="CRT_DT")
		private Date createDate;
		
		@Column(name="CRT_NM")
		private String createName;
		
		@Column(name="APP_NM")
		private String applicationName;
		
		@Column(name="FLD_NM")
		private String fieldName;
		
		@Column(name="RECORD_IN_FLAG")
		private Long recordInFlag;
		
		@Column(name="KEY_FLD_FLG")
		private String appKeyFieldFlag;
		
		@Column(name="WS_REQ_FLD_NM")
		private String webServiceRequiredFieldName;
		
		@Column(name="REQUIRED_ERROR_MSG")
		private String requiredErrorMessage;
		
		@Column(name="CHECK_ORDER")
		private Integer checkOrder;
		
		@Column(name="TAG_FLD_NM")
		private String tagFieldName;
		
		@Column(name="ISSTRAND")
		private boolean isStrand;
		
		@Column(name="ISTITLE")
		private boolean isTitle;
		
		@Column(name="ISCONTRACT")
		private boolean isContract;
		
		@Column(name="ISBASE")
		private boolean isBase;
		
		@Column(name="ISMLT")
		private boolean isMlt;
		
		@Column(name="MLT_ERR_MSG")
		private String mltErrorMessage;
	
		public void setMltErrorMessage(String mltErrorMessage) {
			this.mltErrorMessage = mltErrorMessage;
		}
		
		public String getMltErrorMessage() {
			return this.mltErrorMessage;
		}
		
		public String getApplicationName() {
			return applicationName;
		}
		public void setAppName(String applicationName) {
			this.applicationName = applicationName;
		}
		public String getFieldName() {
			return fieldName;
		}
		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}
		public String getAppKeyFieldFlag() {
			return appKeyFieldFlag;
		}
		public void setAppKeyFieldFlag(String keyFieldFlag) {
			this.appKeyFieldFlag = keyFieldFlag;
		}
			
		public boolean isMlt() {
			return isMlt;
		}
		public void setIsMlt(boolean isMlt) {
			this.isMlt = isMlt;
		}
			
		public boolean isBase() {
			return isBase;
		}
		public void setIsBase(boolean isBase) {
			this.isBase = isBase;
		}
			
		public boolean isContract() {
			return isContract;
		}
		public void setIsContract(boolean isContract) {
			this.isContract = isContract;
		}
		
		public boolean isStrand() {
			return isStrand;
		}
		public void setIsStrand(boolean isStrand) {
			this.isStrand = isStrand;
		}
		public boolean isTitle() {
			return isTitle;
		}
		public void setIsTitle(boolean isTitle) {
			this.isTitle = isTitle;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Date getCreateDate() {
			return createDate;
		}
		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}
		public String getCreateName() {
			return createName;
		}
		public void setCreateName(String createName) {
			this.createName = createName;
		}
		public Long getRecordInFlag() {
			return recordInFlag;
		}
		public void setRecordInFlag(Long recordInFlag) {
			this.recordInFlag = recordInFlag;
		}
		public String getWebServiceRequiredFieldName() {
			return webServiceRequiredFieldName;
		}
		public void setWebServiceRequiredFieldName(String webServiceRequiredFieldName) {
			this.webServiceRequiredFieldName = webServiceRequiredFieldName;
		}
		public String getRequiredErrorMessage() {
			return requiredErrorMessage;
		}
		public void setRequiredErrorMessage(String requiredErrorMessage) {
			this.requiredErrorMessage = requiredErrorMessage;
		}
		public Integer getCheckOrder() {
			return checkOrder;
		}
		public void setCheckOrder(Integer checkOrder) {
			this.checkOrder = checkOrder;
		}
		public String getTagFieldName() {
			return tagFieldName;
		}
		public void setTagFieldName(String tagFieldName) {
			this.tagFieldName = tagFieldName;
		}
		public void setApplicationName(String applicationName) {
			this.applicationName = applicationName;
		}
		public void setStrand(boolean isStrand) {
			this.isStrand = isStrand;
		}
		public void setTitle(boolean isTitle) {
			this.isTitle = isTitle;
		}
			
}
