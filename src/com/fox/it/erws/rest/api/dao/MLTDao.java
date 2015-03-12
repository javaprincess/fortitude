package com.fox.it.erws.rest.api.dao;


import java.util.List;


public interface MLTDao {
	

	public List<Long> findMediaList();
	public List<Long> findTerritoryList();
	public List<Long> findLanguageList();
	public boolean isValidMedia(Long mediaId);
	public boolean isValidLanguage(Long languageId);
	public boolean isValidTerritory(Long territoryId);
}
