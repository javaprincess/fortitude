package com.fox.it.erws.rest.api.dao;


import java.util.List;
import com.fox.it.erws.rest.api.pojos.mtl.Language;
import com.fox.it.erws.rest.api.pojos.mtl.Media;
import com.fox.it.erws.rest.api.pojos.mtl.Territory;


public interface MLTDao {
	

	public List<Media> findMediaList();
	public List<Territory> findTerritoryList();
	public List<Language> findLanguageList();
	public boolean isValidMedia(Object media);
	public boolean isValidLanguage(Object language);
	public boolean isValidTerritory(Object territory);
}
