package com.fox.it.erws.rest.api.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;




@Repository
public class MLTDaoImpl implements MLTDao {
	private Logger log = Logger.getLogger(MLTDaoImpl.class);
	
	
	@PersistenceUnit
	protected EntityManagerFactory entityManagerFactory;

	public MLTDaoImpl(EntityManagerFactory eM) {
		setEntityManagerFactory(eM);
	}
	
	public MLTDaoImpl() {
	
	}

	
    public void setEntityManagerFactory(EntityManagerFactory eMF) {
    	entityManagerFactory = eMF;
    }
	
    public EntityManagerFactory getEntityManagerFactory() {
    	return this.entityManagerFactory;
    }
 
	

	
	public List<Long> findMediaList() {
		EntityManager eM = getEntityManagerFactory().createEntityManager();
		
		List<Long> mediaList = null;
		String activeFlag = "Y";
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT m.mediaId from ");
		sql.append("Media m where m.mediaId <> 16 ");
		sql.append("and m.activeFlag = \'");
		sql.append(activeFlag);
		sql.append("\'");
		
		try {
			
			mediaList =  eM.createQuery(
			//All Media has a mediaId of 16; get only active media
			sql.toString(), Long.class)
			.getResultList();
			
		} catch (Exception e) {
			log.error("Error in MTLDao.findMedia(): " + e.getMessage());
		}
		
		eM.close();
		
		return mediaList;
	}
	
	
	public List<Long> findTerritoryList() {
		EntityManager eM = getEntityManagerFactory().createEntityManager();
		
		List<Long> territoryList = null;
		String activeFlag = "Y";
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT t.territoryId from ");
		sql.append("Territory t where t.territoryId <> 537 ");
		sql.append("and t.activeFlag = \'");
		sql.append(activeFlag);
		sql.append("\'");
		
		
		try {
			territoryList = eM.createQuery(
					//WW has a territoryId of 537; get only active territories
					sql.toString(), Long.class)
					.getResultList(); 

		} catch (Exception e) {
			log.error("Error in MTLDao.findTerritory(): " + e.getMessage());
		}
		
		eM.close();
		
		return territoryList;
	}
	

	public List<Long> findLanguageList() {
		EntityManager eM = getEntityManagerFactory().createEntityManager();
		
		List<Long> languageList = null;
		String activeFlag = "Y";
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT l.languageId from ");
		sql.append("Language l where l.languageId <> 2 ");
		sql.append("and l.activeFlag = \'");
		sql.append(activeFlag);
		sql.append("\'");
		
		try {
			languageList = eM.createQuery(
					//All Language has a languageId of 2; get only active languages
					sql.toString(), Long.class)
					.getResultList(); 
			} catch (Exception e) {
			log.error("Error in MTLDao.findLanguage(): " + e.getMessage());
		}
		
		eM.close();
		
		return languageList;
	}


}

