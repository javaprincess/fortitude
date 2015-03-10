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
    	if (!findMediaList().contains(media))
    		return false;
    	else
    		return true;
    }
    
    public boolean isValidTerritory(Object territory) {
    	if (!findTerritoryList().contains(territory))
    		return false;
    	else
    		return true;
    }
    
    public boolean isValidLanguage(Object language) {
    	if (!findLanguageList().contains(language))
    		return false;
    	else
    		return true;
    }

	public List<Media> findMediaList() {
		EntityManager eM = getEntityManagerFactory().createEntityManager();
		
		List<Media> mediaList = null;
		
		try {
			mediaList = eM.createQuery(
					"SELECT m.mediaId from Media m", Media.class)
					.getResultList(); 
			
			System.out.println("size of mediaList: " + mediaList.size());
		} catch (Exception e) {
			log.error("Error in MTLDao.findMedia(): " + e.getMessage());
		}
		
		eM.close();
		
		return mediaList;
	}
	
	public List<Territory> findTerritoryList() {
		EntityManager eM = getEntityManagerFactory().createEntityManager();
		
		List<Territory> territoryList = null;
		
		try {
			territoryList = eM.createQuery(
					"SELECT t.territoryId from Territory t", Territory.class)
					.getResultList(); 
			System.out.println("size of territoryList: " + territoryList.size());
		} catch (Exception e) {
			log.error("Error in MTLDao.findTerritory(): " + e.getMessage());
		}
		
		eM.close();
		
		return territoryList;
	}
	
	public List<Language> findLanguageList() {
		EntityManager eM = getEntityManagerFactory().createEntityManager();
		
		List<Language> languageList = null;
		
		try {
			languageList = eM.createQuery(
					"SELECT l.languageId from Language l", Language.class)
					.getResultList(); 
			
			System.out.println("size of languageList: " + languageList.size());
		} catch (Exception e) {
			log.error("Error in MTLDao.findLanguage(): " + e.getMessage());
		}
		
		eM.close();
		
		return languageList;
	}


}

