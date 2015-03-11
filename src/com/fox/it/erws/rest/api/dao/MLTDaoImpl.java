package com.fox.it.erws.rest.api.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.fox.it.erws.rest.api.pojos.mtl.Language;
import com.fox.it.erws.rest.api.pojos.mtl.Media;
import com.fox.it.erws.rest.api.pojos.mtl.Territory;



@Repository
public class MLTDaoImpl<T> implements MLTDao {
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
 
	
    public boolean isValidMedia(Object media) {
    	return findMediaList().contains(media);
     }
    
    public boolean isValidTerritory(Object territory) {
    	return findTerritoryList().contains(territory);
    }
    
    public boolean isValidLanguage(Object language) {  	
    	return findLanguageList().contains(language);
    }

	@SuppressWarnings("unchecked")
	public List<Media> findMediaList() {
		EntityManager eM = getEntityManagerFactory().createEntityManager();
		
		List<Media> mediaList = null;
		String activeFlag = "Y";
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT media_Id from ");
		sql.append("Media where media_Id <> 16 ");
		sql.append("and actv_flg = \'");
		sql.append(activeFlag);
		sql.append("\'");
		
		System.out.println("media sql: " + sql.toString());
		
		try {
			
			mediaList =  eM.createNativeQuery(
			//All Media has a mediaId of 16; get only active media
			//"SELECT mediaId from media where mediaId <> 16 and actv_flg=\'Y\'", Media.class)
			sql.toString(), Media.class)
			.getResultList();
			
		} catch (Exception e) {
			log.error("Error in MTLDao.findMedia(): " + e.getMessage());
		}
		
		eM.close();
		
		return mediaList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Territory> findTerritoryList() {
		EntityManager eM = getEntityManagerFactory().createEntityManager();
		
		List<Territory> territoryList = null;
		String activeFlag = "Y";
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT trrtry_Id from ");
		sql.append("trrtry where trrtry_Id <> 537 ");
		sql.append("and actv_flg = \'");
		sql.append(activeFlag);
		sql.append("\'");
		
		try {
			territoryList = eM.createNativeQuery(
					//WW has a territoryId of 537; get only active territories
					//"SELECT t.territoryId from Territory t where t.territoryId <> 537", Territory.class)
					sql.toString(), Territory.class)
					.getResultList(); 
			
		} catch (Exception e) {
			log.error("Error in MTLDao.findTerritory(): " + e.getMessage());
		}
		
		eM.close();
		
		return territoryList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Language> findLanguageList() {
		EntityManager eM = getEntityManagerFactory().createEntityManager();
		
		List<Language> languageList = null;
		String activeFlag = "Y";
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT lngg_Id from ");
		sql.append("lngg where lngg_Id <> 2 ");
		sql.append("and actv_flg = \'");
		sql.append(activeFlag);
		sql.append("\'");
		
		try {
			languageList = eM.createNativeQuery(
					//All Language has a languageId of 2; get only active languages
					//"SELECT l.languageId from Language l where l.languageId <> 2", Language.class)
					sql.toString(), Language.class)
					.getResultList(); 
			
			System.out.println("size of languageList: " + languageList.size());
		} catch (Exception e) {
			log.error("Error in MTLDao.findLanguage(): " + e.getMessage());
		}
		
		eM.close();
		
		return languageList;
	}


}

