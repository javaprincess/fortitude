package com.fox.it.erws.rest.api.pojos.mtl;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;



@Entity
public class Dummy {
	
	@Id
	@JoinColumn(columnDefinition="max(nvl(crt_dt,upd_dt))")
	private Media media;
	
	@JoinColumn(columnDefinition="max(nvl(crt_dt,upd_dt))")
	private Territory territory;
	
	@JoinColumn(columnDefinition="max(nvl(crt_dt,upd_dt))")
	private Language language;
	
	@Transient
	private Date mediaDate;
	
	@Transient
	private Date territoryDate;
	
	@Transient
	private Date languageDate;
	
	public Dummy() {}
	
	public Dummy(Date mediaDate,
			Date territoryDate,
			Date languageDate) {
		setMediaDate(mediaDate);
		setTerritoryDate(territoryDate);
		setLanguageDate(languageDate);
	}

	public Date getMediaDate() {
		return mediaDate;
	}

	public void setMediaDate(Date mediaDate) {
		this.mediaDate = mediaDate;
	}

	public Date getTerritoryDate() {
		return territoryDate;
	}

	public void setTerritoryDate(Date territoryDate) {
		this.territoryDate = territoryDate;
	}

	public Date getLanguageDate() {
		return languageDate;
	}

	public void setLanguageDate(Date languageDate) {
		this.languageDate = languageDate;
	}

}
